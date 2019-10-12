package cn.gson.oasys.controller.user;

import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gson.oasys.ServiceV2.UserLoginRecordServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.factory.UserLoginRecordFactory;
import cn.gson.oasys.model.po.UserLoginRecordPO;
import cn.gson.oasys.model.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import cn.gson.oasys.model.dao.user.UserService;
import cn.gson.oasys.model.entity.schedule.ScheduleList;
import cn.gson.oasys.model.entity.user.LoginRecord;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.entity.user.UserLog;

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
    private UserServiceV2 userServiceV2;
/*
    //显示本周的每天的记录
    @RequestMapping("countweeklogin")
    public String dfsa(HttpServletResponse response) throws IOException {
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

    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }

    //给hashMap按照value排序
    public static ArrayList<Map.Entry<String, Integer>> sortMap(Map map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue() - obj1.getValue();
            }
        });
        return (ArrayList<Entry<String, Integer>>) entries;
    }

    //显示任务统计模块数据
    @RequestMapping("counttasknum")
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
    }

    //日历的数据显示
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

    //用来查找用户记录(用户管理》在线用户
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

/*
    //用来查找用户记录
    @RequestMapping("morelogrecordtable")
    public String test3dfrt342(@RequestParam(value = "page", defaultValue = "0") int page,
                               HttpSession session, Model model,
                               @RequestParam(value = "baseKey", required = false) String basekey,
                               @RequestParam(value = "time", required = false) String time,
                               @RequestParam(value = "icon", required = false) String icon) {
        getuserlogrecord(page, session, model, basekey, time, icon);
//        getUserLoginRecord(page, session, model, basekey, time, icon);//自己的
        return "user/userlogrecordmanagetable";

    }
*/
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

    //自己写的在线用户列表
    public void getUserLoginRecord(int page, HttpSession session, Model model, String basekey, String time,
                                   String icon) {
        long userid = Long.valueOf(session.getAttribute("userId").toString());
        setTwo(model, basekey, time, icon);
        // 把用户根据时间降序并分页
        List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordServiceV2.userLoginPage(page, userid, time);

        //根据用户们的ID查询用户们
        List<UserPO>userPOList = new ArrayList<>();
        //把记录表里的用户ID和用户的名字对应起来
        for(UserLoginRecordPO userLoginRecordPO : userLoginRecordPOList){
            UserPO userPO =userServiceV2.getUserPOByUserId(userLoginRecordPO.getUserId());
            userPOList.add(userPO);
        }
        List<LoginRecord>loginRecordList = UserLoginRecordFactory.create(userLoginRecordPOList,userPOList);
        model.addAttribute("page", loginRecordList);
        model.addAttribute("userloglist", loginRecordList);
        model.addAttribute("url", "morelogrecordtable");
    }

/*
    //用来查找用户记录
    @RequestMapping("morelog")
    public String test3df(@RequestParam(value = "page", defaultValue = "0") int page,
                          HttpSession session, Model model,
                          @RequestParam(value = "baseKey", required = false) String basekey,
                          @RequestParam(value = "time", required = false) String time,
                          @RequestParam(value = "icon", required = false) String icon) {
        getuserlog(page, session, model, basekey, time, icon);
        return "user/userlogmanage";
    }

    //用来查找用户记录
    @RequestMapping("morelogtable")
    public String test3dfrt(@RequestParam(value = "page", defaultValue = "0") int page,
                            HttpSession session, Model model,
                            @RequestParam(value = "baseKey", required = false) String basekey,
                            @RequestParam(value = "time", required = false) String time,
                            @RequestParam(value = "icon", required = false) String icon) {
        getuserlog(page, session, model, basekey, time, icon);
        return "user/userlogmanagetable";

    }


    public void getuserlog(int page, HttpSession session, Model model, String basekey, String time,
                           String icon) {
        long userid = Long.valueOf(session.getAttribute("userId") + "");
        setTwo(model, basekey, time, icon);
        Page<UserLog> page3 = userLogService.ulogpaging(page, basekey, userid, time);
        model.addAttribute("page", page3);
        model.addAttribute("userloglist", page3.getContent());

        model.addAttribute("url", "morelogtable");
    }
*/
    //记忆两种规则
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

}
