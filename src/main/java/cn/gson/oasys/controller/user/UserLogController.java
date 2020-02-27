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

import cn.gson.oasys.ServiceV2.UserLoginRecordServiceV2;
import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.ServiceV2.scheduleV2.ScheduleListServiceV2;
import cn.gson.oasys.ServiceV2.taskV2.TaskListServiceV2;
import cn.gson.oasys.ServiceV2.userV2.UserLogServiceV2;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.userVO2.UserLoginRecordVO;
import cn.gson.oasys.vo.userVO2.UserLoginRecordVOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import cn.gson.oasys.model.dao.scheduledao.ScheduleDao;
import cn.gson.oasys.model.dao.taskdao.TaskDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.dao.user.UserLogDao;
import cn.gson.oasys.model.dao.user.UserLogRecordDao;
import cn.gson.oasys.model.dao.user.UserLogRecordService;
import cn.gson.oasys.model.dao.user.UserLogService;

@Controller
@RequestMapping("/")
public class UserLogController {
    @Autowired
    private UserLogDao userLogDao;
    @Autowired
    private UserLogService userLogService;
    @Autowired
    private UserDao uDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserLogRecordDao userLogRecordDao;
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private UserLogRecordService userLogRecordService;

    @Resource
    private UserLoginRecordServiceV2 userLoginRecordServiceV2;
    @Resource
    private UserPOServiceV2 userServiceV2;

  /*  //日历的数据显示(1..)
    @RequestMapping("littlecalendar")
    public String test3df(HttpSession session, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long userid = Long.valueOf(session.getAttribute("userId") + "");
        List list = new ArrayList<>();
        List<ScheduleList> dates = scheduleDao.findstart(userid);
        for (ScheduleList scheduleList : dates) {
            list.add(sdf.format(scheduleList.getStartTime()));
        }
        String json = JSONObject.toJSONString(list);
        System.out.println(json);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
        return null;
    }
*/

  /*  //给hashMap按照value排序(2..)
    public static ArrayList<Map.Entry<String, Integer>> sortMap(Map map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue() - obj1.getValue();
            }
        });
        return (ArrayList<Entry<String, Integer>>) entries;
    }*/

    /*   //用来查找用户记录(3..)
       @RequestMapping("morelog")
       public String test3df(@RequestParam(value = "page", defaultValue = "0") int page,
                             HttpSession session, Model model,
                             @RequestParam(value = "baseKey", required = false) String basekey,
                             @RequestParam(value = "time", required = false) String time,
                             @RequestParam(value = "icon", required = false) String icon) {
           getuserlog(page, session, model, basekey, time, icon);
           return "user/userlogmanage";
       }
       */
    //(4..)
  /*  public void getuserlog(int page, HttpSession session, Model model, String basekey, String time,
                           String icon) {
        long userid = Long.valueOf(session.getAttribute("userId") + "");
        setTwo(model, basekey, time, icon);
        Page<UserLog> page3 = userLogService.ulogpaging(page, basekey, userid, time);
        model.addAttribute("page", page3);
        model.addAttribute("userloglist", page3.getContent());
        model.addAttribute("url", "morelogtable");
    }
*/
  /*  //记忆两种规则(5..)
    private void setTwo(Model model, String basekey, Object time, Object icon) {
        if (!StringUtils.isEmpty(time)) {
            model.addAttribute("time", time);
            model.addAttribute("icon", icon);
            model.addAttribute("sort", "&time=" + time + "&icon=" + icon);
        }
        if (!StringUtils.isEmpty(basekey)) {
            model.addAttribute("basekey", basekey);
            model.addAttribute("sort", "&basekey=" + basekey);
        }
    }
*/
  /*//用来查找用户记录
  @RequestMapping("morelogtable")
  public String test3dfrt(@RequestParam(value = "page", defaultValue = "0") int page,
                          HttpSession session, Model model,
                          @RequestParam(value = "baseKey", required = false) String basekey,
                          @RequestParam(value = "time", required = false) String time,
                          @RequestParam(value = "icon", required = false) String icon) {
      getuserlog(page, session, model, basekey, time, icon);
      return "user/userlogmanagetable";

  }*/

 /*   //显示本周的每天的记录
    @RequestMapping("countweeklogin")
    public String countWeekLogin(HttpServletResponse response) throws IOException {
        Integer[] r = new Integer[7];
        Calendar calendar = Calendar.getInstance();
        setToFirstDay(calendar);
        for (int i = 0; i < 7; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            r[i] = userLogRecordDao.countlog(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        String json = JSONObject.toJSONString(r);
        System.out.println(json);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
        return null;
    }
*/
   /* private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
*/

    //显示任务统计模块数据
 /*   @RequestMapping("counttasknum")
    public String test3df(HttpServletResponse response) throws IOException {
        List<User> uList = uDao.findAll();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i = 0;
        for (User user : uList) {
            if (taskDao.countfinish(7l, user.getUserId()) > 0) {
                hashMap.put(user.getUserName(), taskDao.countfinish(7l, user.getUserId()));
                i++;
            }
        }
        ArrayList<Map.Entry<String, Integer>> entries = sortMap(hashMap);
        ArrayList<Map.Entry<String, Integer>> entries2 = new ArrayList<Map.Entry<String, Integer>>();

        if (entries.size() >= 5)
            //获得前5个s
            for (int j = 0; j < 5; j++) {
                entries2.add(entries.get(j));
            }
        else {
            entries2 = entries;
        }
        String json = JSONObject.toJSONString(entries2);
        System.out.println(json);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
        return null;
    }*/


  /*  //用来查找用户记录(用户管理》在线用户
    @RequestMapping("morelogrecord")
    public String test3df342(@RequestParam(value = "page", defaultValue = "0") int page,
                             HttpSession session, Model model,
                             @RequestParam(value = "baseKey", required = false) String basekey,
                             @RequestParam(value = "time", required = false) String time,
                             @RequestParam(value = "icon", required = false) String icon) {
//        getuserlogrecord(page, session, model, basekey, time, icon);
        getUserLoginRecord(page, session, model, basekey, time, icon);//自己的
        return "user/userlogrecordmanage";
    }

*/

/*
  //在线用户里调用的方法
  public void getuserlogrecord(int page, HttpSession session, Model model, String basekey, String time,
                               String icon) {
      long userid = Long.valueOf(session.getAttribute("userId") + "");
      setTwo(model, basekey, time, icon);
      // 把用户根据时间降序并分页
      Page<LoginRecord> page4 = userLogRecordService.ulogpaging(page, basekey, userid, time);
      model.addAttribute("page", page4);
      model.addAttribute("userloglist", page4.getContent());
      System.out.println("debug");
      for (LoginRecord loginRecord : page4.getContent()) {
          System.out.println("000" + loginRecord);
      }
      model.addAttribute("url", "morelogrecordtable");
  }

*/
/*

    //用来查找用户记录
    @RequestMapping("morelogrecordtable")
    public String test3dfrt342(@RequestParam(value = "page", defaultValue = "0") int page,
                               HttpSession session, Model model,
                               @RequestParam(value = "baseKey", required = false) String basekey,
                               @RequestParam(value = "time", required = false) String time,
                               @RequestParam(value = "icon", required = false) String icon) {
        getuserlogrecord(page, session, model, basekey, time, icon);
        return "user/userlogrecordmanagetable";

    }
*/


    //===========================================================
    @Resource
    private ScheduleListServiceV2 scheduleListServiceV2;
    @Resource
    private UserLogServiceV2 userLogServiceV2;
    @Resource
    private TaskListServiceV2 taskListServiceV2;

    //日历的数据显示(1..)
    @RequestMapping("littlecalendar")
    public String littleCalendar(HttpSession session, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        List list = new ArrayList<>();
        List<SchedulePO> schedulePOList = scheduleListServiceV2.getSchedulePOListByUserId(userId);
        for (SchedulePO schedulePO : schedulePOList) {
            list.add(sdf.format(schedulePO.getStartTime()));
        }
        String json = JSONObject.toJSONString(list);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
        return null;
    }

    //给hashMap按照value排序(2..)
    public static ArrayList<Map.Entry<String, Integer>> sortMap(Map map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue() - obj1.getValue();
            }
        });
        return (ArrayList<Entry<String, Integer>>) entries;
    }

    //用来查找用户记录(3..)
    @RequestMapping("morelog")
    public String moreLog(@RequestParam(value = "page", defaultValue = "1") int page,
                          HttpSession session, Model model,
                          @RequestParam(value = "baseKey", required = false) String basekey,
                          @RequestParam(value = "time", required = false) String time,
                          @RequestParam(value = "icon", required = false) String icon) {
        getUserLog(page, session, model, basekey, time, icon);
        return "user/userlogmanage";
    }

    //(4..)
    public void getUserLog(int page, HttpSession session, Model model, String basekey, String time,
                           String icon) {
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        setTwo(model, basekey, time, icon);
        List<UserLogPO> userLogPOList = userLogServiceV2.userLogPOListByBaseKeyAndUserIdAndTime(basekey, userId, time);
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

    //记忆两种规则(5..)
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

    //用来查找用户记录
    @RequestMapping("morelogtable")
    public String moreLogTable(@RequestParam(value = "page", defaultValue = "1") int page,
                               HttpSession session, Model model,
                               @RequestParam(value = "baseKey", required = false) String baseKey,
                               @RequestParam(value = "time", required = false) String time,
                               @RequestParam(value = "icon", required = false) String icon) {
        getUserLog(page, session, model, baseKey, time, icon);
        return "user/userlogmanagetable";

    }

    //显示本周的每天的记录
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

    @RequestMapping("counttasknum")
    public String countTaskNum(HttpServletResponse response) throws IOException {
        List<UserPO> userPOList = userServiceV2.getUserAll();
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
     * 用来查找用户记录(用户管理》在线用户
     *
     * @param page    第几页
     * @param session
     * @param model
     * @param basekey 模糊字
     * @param time
     * @param icon
     * @return
     */
    @RequestMapping("morelogrecord")
    public String moreLogRecord(@RequestParam(value = "page", defaultValue = "1") int page,
                                HttpSession session, Model model,
                                @RequestParam(value = "baseKey", required = false) String basekey,
                                @RequestParam(value = "time", required = false) String time,
                                @RequestParam(value = "icon", required = false) String icon) {
        getUserLoginRecord(page, session, model, basekey, time, icon);//自己的
        return "user/userlogrecordmanage";
    }


    //在线用户里调用的方法
    public void getUserLoginRecord(int page, HttpSession session, Model model, String basekey, String time,
                                   String icon) {
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        setTwo(model, basekey, time, icon);
        List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordServiceV2.getUserLoginRecordPOSByUserIdAndLoginTimeSortAndBaseKey(basekey, userId, time);
        // 把用户根据时间降序并分页
        getUserLoginRecordPage(page, model, userLoginRecordPOList);
        model.addAttribute("url", "morelogrecordtable");
    }

    public void getUserLoginRecordPage(int page, Model model, List<UserLoginRecordPO> userLoginRecordPOList) {
        //根据用户们的ID查询用户们
        List<UserPO> userPOList = new ArrayList<>();
        //把记录表里的用户ID和用户的名字对应起来
        for (UserLoginRecordPO userLoginRecordPO : userLoginRecordPOList) {
            userLoginRecordPO.setLoginTime(new Timestamp(userLoginRecordPO.getLoginTime().getTime()));
            UserPO userPO = userServiceV2.getUserPOByUserId(userLoginRecordPO.getUserId());
            userPOList.add(userPO);
        }

        PageBO pageBO = new PageBO(page, 10);
        pageBO.setTotalCount(userLoginRecordPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > userLoginRecordPOList.size()) {
            end = userLoginRecordPOList.size();
        }
        List<UserLoginRecordPO> subUserLoginRecordPOS = userLoginRecordPOList.subList(start, end);
        List<UserLoginRecordVO> userLoginRecordVOList = UserLoginRecordVOFactory.createUserLoginRecordVOList(subUserLoginRecordPOS);
        for (UserLoginRecordPO userLoginRecordPO : subUserLoginRecordPOS) {
            for (UserLoginRecordVO userLoginRecordVO : userLoginRecordVOList) {
                if (userLoginRecordPO.getRecordId().equals(userLoginRecordVO.getId())) {
                    userLoginRecordVO.setUserVO(userServiceV2.setUserVOByUserId(userLoginRecordPO.getUserId()));
                }
            }
        }
        model.addAttribute("page", pageBO);
        model.addAttribute("userloglist", userLoginRecordVOList);

    }

    //用来查找用户记录
    @RequestMapping("morelogrecordtable")
    public String moreLogRecordTable(@RequestParam(value = "page", defaultValue = "1") int page,
                                     HttpSession session, Model model,
                                     @RequestParam(value = "baseKey", required = false) String basekey,
                                     @RequestParam(value = "time", required = false) String time,
                                     @RequestParam(value = "icon", required = false) String icon) {
        getUserLoginRecord(page, session, model, basekey, time, icon);
        return "user/userlogrecordmanagetable";

    }

}
