package cn.gson.oasys.controller.user;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gson.oasys.serviceV2.userV2.UserLoginRecordServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.scheduleV2.ScheduleListServiceV2;
import cn.gson.oasys.serviceV2.taskV2.TaskListServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserLogServiceV2;
import cn.gson.oasys.modelV2.bo.PageBO;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.voandfactory.userVO2.UserLoginRecordVO;
import cn.gson.oasys.voandfactory.userVO2.UserLoginRecordVOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/")
public class UserLogController {

    @Resource
    private ScheduleListServiceV2 scheduleListServiceV2;
    @Resource
    private UserLogServiceV2 userLogServiceV2;
    @Resource
    private TaskListServiceV2 taskListServiceV2;
    @Resource
    private UserLoginRecordServiceV2 userLoginRecordServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    /**
     * 日历的数据显示
     *
     * @param session
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("littlecalendar")
    public String littleCalendar(HttpSession session, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        List list = new ArrayList<>();
        List<SchedulePO> schedulePOList = scheduleListServiceV2.getSchedulePOListByUserId(userId);//用户的日程表
        for (SchedulePO schedulePO : schedulePOList) {
            list.add(sdf.format(schedulePO.getStartTime()));
        }
        String json = JSONObject.toJSONString(list);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 给hashMap按照value排序
     *
     * @param map
     * @return
     */
    public static ArrayList<Map.Entry<String, Integer>> sortMap(Map map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue() - obj1.getValue();
            }
        });
        return (ArrayList<Entry<String, Integer>>) entries;
    }

    /**
     * 用来查找用户记录
     *
     * @param page
     * @param session
     * @param model
     * @param baseKey
     * @param time
     * @param icon
     * @return
     */
    @RequestMapping("morelog")
    public String moreLog(@RequestParam(value = "page", defaultValue = "1") int page,
                          HttpSession session, Model model,
                          @RequestParam(value = "baseKey", required = false) String baseKey,
                          @RequestParam(value = "time", required = false) String time,
                          @RequestParam(value = "icon", required = false) String icon) {
        getUserLog(page, session, model, baseKey, time, icon);
        return "user/userlogmanage";
    }

    /**
     * 用户登录信息
     *
     * @param page
     * @param session
     * @param model
     * @param baseKey
     * @param time
     * @param icon
     */
    public void getUserLog(int page, HttpSession session, Model model, String baseKey, String time,
                           String icon) {
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        setTwo(model, baseKey, time, icon);
        List<UserLogPO> userLogPOList = userLogServiceV2.userLogPOListByBaseKeyAndUserIdAndTime(baseKey, userId, time);
        for (UserLogPO userLogPO : userLogPOList) {
            userLogPO.setLogTime(new Timestamp(userLogPO.getLogTime().getTime()));
        }
        PageBO pageBO = new PageBO(page, 15);
        pageBO.setTotalCount(userLogPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        List<UserLogPO> subUserLogPOS = userLogPOList.subList(start, end);
        model.addAttribute("page", pageBO);
        model.addAttribute("userloglist", subUserLogPOS);
        model.addAttribute("url", "morelogtable");
    }

    /**
     * 用来查找用户记录
     *
     * @param page    第几页
     * @param session
     * @param model
     * @param baseKey 模糊字
     * @param time
     * @param icon
     * @return
     */
    @RequestMapping("morelogtable")
    public String moreLogTable(@RequestParam(value = "page", defaultValue = "1") int page,
                               HttpSession session, Model model,
                               @RequestParam(value = "baseKey", required = false) String baseKey,
                               @RequestParam(value = "time", required = false) String time,
                               @RequestParam(value = "icon", required = false) String icon) {
        getUserLog(page, session, model, baseKey, time, icon);
        return "user/userlogmanagetable";
    }

    /**
     * 显示本周的每天的记录
     *
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("countweeklogin")
    public String countWeekLogin(HttpServletResponse response) throws IOException {
        Integer[] r = new Integer[7];
        Calendar calendar = Calendar.getInstance();
        setToFirstDay(calendar);
        for (int i = 0; i < 7; i++) {
            r[i] = userLoginRecordServiceV2.getUserLoginRecordPOByLoginTimeLikeCount(calendar);
            calendar.add(Calendar.DATE, 1);
        }
        String json = JSONObject.toJSONString(r);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
        return null;
    }

    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }

    /**
     * 显示任务统计模块数据
     *
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("counttasknum")
    public String countTaskNum(HttpServletResponse response) throws IOException {
        List<UserPO> userPOList = userPOServiceV2.getUserAll();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i = 0;
        for (UserPO userPO : userPOList) {
            List<TaskListPO> taskListPOS = taskListServiceV2.getTaskListPOByStatusIdAndUserId(7, userPO.getUserId());
            if (taskListPOS.size() > 0) {
                hashMap.put(userPO.getUserName(), taskListPOS.size());
                i++;
            }
        }
        ArrayList<Map.Entry<String, Integer>> entries = sortMap(hashMap);
        ArrayList<Map.Entry<String, Integer>> entries2 = new ArrayList<Map.Entry<String, Integer>>();
        if (entries.size() >= 5) {
            //获得前5个s
            for (int j = 0; j < 5; j++) {
                entries2.add(entries.get(j));
            }
        } else {
            entries2 = entries;
        }
        String json = JSONObject.toJSONString(entries2);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 用来查找用户记录(用户管理》在线用户)
     *
     * @param page    第几页
     * @param session
     * @param model
     * @param baseKey 模糊字
     * @param time
     * @param icon
     * @return
     */
    @RequestMapping("morelogrecord")
    public String moreLogRecord(@RequestParam(value = "page", defaultValue = "1") int page,
                                HttpSession session, Model model,
                                @RequestParam(value = "baseKey", required = false) String baseKey,
                                @RequestParam(value = "time", required = false) String time,
                                @RequestParam(value = "icon", required = false) String icon) {
        getUserLoginRecord(page, session, model, baseKey, time, icon);
        return "user/userlogrecordmanage";
    }

    /**
     * 获取用户登录记录
     *
     * @param page    第几页
     * @param session
     * @param model
     * @param baseKey 模糊字
     * @param time
     * @param icon
     */
    public void getUserLoginRecord(int page, HttpSession session, Model model, String baseKey, String time,
                                   String icon) {
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        setTwo(model, baseKey, time, icon);
        //获取用户登录记录列表
        List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordServiceV2.getUserLoginRecordPOSByUserIdAndLoginTimeSortAndBaseKey(baseKey, userId, time);
        // 把用户根据时间降序并分页
        getUserLoginRecordPage(page, model, userLoginRecordPOList);
        model.addAttribute("url", "morelogrecordtable");
    }


    /**
     * 时间和模糊字是否存在
     *
     * @param model
     * @param baseKey 模糊字
     * @param time    时间
     * @param icon
     */
    private void setTwo(Model model, String baseKey, Object time, Object icon) {
        if (!StringUtils.isEmpty(time)) {
            model.addAttribute("time", time);
            model.addAttribute("icon", icon);
            model.addAttribute("sort", "&time=" + time + "&icon=" + icon);
        }
        if (!StringUtils.isEmpty(baseKey)) {
            model.addAttribute("basekey", baseKey);
            model.addAttribute("sort", "&basekey=" + baseKey);
        }
    }


    /**
     * 获取用户登录记的分页信息
     *
     * @param page                  第几页
     * @param model
     * @param userLoginRecordPOList 用户登录记录列表
     */
    public void getUserLoginRecordPage(int page, Model model, List<UserLoginRecordPO> userLoginRecordPOList) {
//        //登录用户的信息
//        List<UserPO> userPOList = new ArrayList<>();
//        //根据用户记录的ID找用户信息添加到集合里
//        for (UserLoginRecordPO userLoginRecordPO : userLoginRecordPOList) {
//            userLoginRecordPO.setLoginTime(new Timestamp(userLoginRecordPO.getLoginTime().getTime()));//登录时间
//            UserPO userPO = userPOServiceV2.getUserPOByUserId(userLoginRecordPO.getUserId());//根据登录疾苦的用户ID获取用户信息
//            userPOList.add(userPO);
//        }

        PageBO pageBO = new PageBO(page, 10);
        pageBO.setTotalCount(userLoginRecordPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > userLoginRecordPOList.size()) {
            end = userLoginRecordPOList.size();
        }
        List<UserLoginRecordPO> subUserLoginRecordPOS = userLoginRecordPOList.subList(start, end);//每页的用户登录列表
        List<UserLoginRecordVO> userLoginRecordVOList = UserLoginRecordVOFactory.createUserLoginRecordVOListByUserLoginRecordPOList(subUserLoginRecordPOS);
        //补全用户登录表的用户信息
        for (UserLoginRecordPO userLoginRecordPO : subUserLoginRecordPOS) {
            for (UserLoginRecordVO userLoginRecordVO : userLoginRecordVOList) {
                if (userLoginRecordPO.getRecordId().equals(userLoginRecordVO.getId())) {
                    userLoginRecordVO.setUserVO(userPOServiceV2.setUserVOByUserId(userLoginRecordPO.getUserId()));
                }
            }
        }
        model.addAttribute("page", pageBO);//分页信息
        model.addAttribute("userloglist", userLoginRecordVOList);

    }


    /**
     * 用来查找用户记录
     *
     * @param page    第几页
     * @param session
     * @param model
     * @param baseKey 模糊字
     * @param time
     * @param icon
     * @return
     */
    @RequestMapping("morelogrecordtable")
    public String moreLogRecordTable(@RequestParam(value = "page", defaultValue = "1") int page,
                                     HttpSession session, Model model,
                                     @RequestParam(value = "baseKey", required = false) String baseKey,
                                     @RequestParam(value = "time", required = false) String time,
                                     @RequestParam(value = "icon", required = false) String icon) {
        getUserLoginRecord(page, session, model, baseKey, time, icon);
        return "user/userlogrecordmanagetable";

    }

}
