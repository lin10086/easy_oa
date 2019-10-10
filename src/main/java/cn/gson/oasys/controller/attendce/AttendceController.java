package cn.gson.oasys.controller.attendce;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.gson.oasys.ServiceV2.AttendanceServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.factory.*;
import cn.gson.oasys.mappers.*;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.bo.QueryAttendsBO;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.po.*;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.gson.oasys.common.StringtoDate;
import cn.gson.oasys.model.dao.attendcedao.AttendceDao;
import cn.gson.oasys.model.dao.attendcedao.AttendceService;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.dao.user.UserService;
import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.User;

@Controller
@RequestMapping("/")
public class AttendceController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private AttendceDao attenceDao;
    @Resource
    private AttendceService attendceService;
    @Resource
    private UserDao uDao;
    @Resource
    private UserService userService;
    @Resource
    private TypeDao typeDao;
    @Resource
    private StatusDao statusDao;
    @Resource
    private AttendanceServiceV2 attendanceServiceV2;
    @Resource
    UserPOMapper userPOMapper;
    @Resource
    TypePOMapper typePOMapper;
    @Resource
    StatusPOMapper statusPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private DeptPOMapper deptPOMapper;
    @Resource
    private AttendsPOMapper attendsPOMapper;

    List<Attends> alist;
    List<User> uList;
    Date start, end;
    String month_;
    // 格式转化导入
    DefaultConversionService service = new DefaultConversionService();
/*
    // 考勤 前面的签到
    @RequestMapping("singin")
    public String Datag(HttpSession session, Model model, HttpServletRequest request) throws InterruptedException, UnknownHostException {
        //首先获取ip
        InetAddress ia = null;
        ia = ia.getLocalHost();
        String attendip = ia.getHostAddress();
        // 时间规范
        String start = "08:00:00", end = "17:00:00";
        service.addConverter(new StringtoDate());
        // 状态默认是正常
        long typeId, statusId = 10;
        Attends attends = null;
        //获取ID
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        //根据用户ID获取用户信息
        User user = uDao.findOne(userId);
//        日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        获取当前日期
        Date date = new Date();
//        把当前日期转换为字符串格式
        String nowdate = sdf.format(date);
        // 星期 判断该日期是星期几
        SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE");
        // 截取时分
        SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm");
        // 截取时分秒
        SimpleDateFormat sdf5 = new SimpleDateFormat("HH:mm:ss");

        // 获取当前时间的星期
        String weekofday = sdf3.format(date);
        // 获取当前时间的时分
        String hourmin = sdf4.format(date);
        // 获取当前时间的时分秒
        String hourminsec = sdf5.format(date);
        //System.out.println("星期" + weekofday + "时分" + hourmin + "时分秒" + hourminsec);
        //System.out.println(date);
        Long aid = null;

        // 查找用户当天的所有记录（用户ID，考勤时间）
        Integer count = attenceDao.countrecord(nowdate, userId);
        if (hourminsec.compareTo(end) > 0) {
            // 在17之后签到无效
            System.out.println("----不能签到");
            model.addAttribute("error", "1");
        }
        if (hourminsec.compareTo("05:00:00") < 0) {
            //在凌晨5点之前不能签到
            System.out.println("----不能签到");
            model.addAttribute("error", "2");
        } else if ((hourminsec.compareTo("05:00:00") > 0) && (hourminsec.compareTo(end) < 0)) {
            // 明确一点就是一个用户一天只能产生两条记录
            if (count == 0) {
                if (hourminsec.compareTo(end) < 0) {
                    // 没有找到当天的记录就表示（第一次签到）此次点击是上班 就是用来判断该记录的类型
                    // 上班id8
                    typeId = 8;
                    // 上班就只有迟到和正常
                    if (hourminsec.compareTo(start) > 0) {
                        // 迟于规定时间 迟到
                        statusId = 11;
                    } else if (hourminsec.compareTo(start) < 0) {
                        statusId = 10;
                    }
                    attends = new Attends(typeId, statusId, date, hourmin, weekofday, attendip, user);
                    attenceDao.save(attends);
                }
            }
            if (count == 1) {
                // 找到当天的一条记录就表示此次点击是下班
                // 下班id9
                typeId = 9;
                // 下班就只有早退和正常
                if (hourminsec.compareTo(end) > 0) {
                    // 在规定时间晚下班正常
                    statusId = 10;
                } else if (hourminsec.compareTo(end) < 0) {
                    // 在规定时间早下班早退
                    statusId = 12;
                }
                attends = new Attends(typeId, statusId, date, hourmin, weekofday, attendip, user);
                attenceDao.save(attends);
            }
            if (count >= 2) {
                // 已经是下班的状态了 大于2就是修改考勤时间了
                // 下班id9
                if (hourminsec.compareTo(end) > 0) { // 最进一次签到在规定时间晚下班正常
                    statusId = 10;
                } else if (hourminsec.compareTo(end) < 0) {
                    // 最进一次签到在规定时间早下班早退
                    statusId = 12;
                }
                //当天下班的考勤记录（用户ID，考勤时间）返回下班考勤表aid
                aid = attenceDao.findoffworkid(nowdate, userId);
                //根据aid查询考勤记录
                Attends attends2 = attenceDao.findOne(aid);
                //把用户的IP设置到考勤表
                attends2.setAttendsIp(attendip);
                attenceDao.save(attends2);
                // 更改考勤时间（根据考勤表ID修改考勤时间，考勤时分）
                attendceService.updatetime(date, hourmin, statusId, aid);
                //查找某用户某天最新记录用来显示用户最新的类型和考勤时间（考勤表的用户ID，考勤时间）
                Attends aList = attenceDao.findlastest(nowdate, userId);
            }
        }
        // 显示用户当天最新的记录
        Attends aList = attenceDao.findlastest(nowdate, userId);
        if (aList != null) {
            String type = typeDao.findname(aList.getTypeId());
            model.addAttribute("type", type);
        }
        model.addAttribute("alist", aList);
        return "systemcontrol/signin";
    }
*/

    // 考勤 前面的签到
    @RequestMapping("singin")
    public String Datag(HttpSession session, Model model, HttpServletRequest request) throws InterruptedException, UnknownHostException {
        //首先获取ip
        String attendip = InetAddress.getLocalHost().getHostAddress();
        // 时间规范
        String start = "08:00:00", end = "17:00:00";
        service.addConverter(new StringtoDate());
        // 状态默认是正常
        long typeId, statusId = 10;
        Attends attends = null;
//        AttendsPO attendsPO = null;
        //获取ID
        Long userId = Long.parseLong(session.getAttribute("userId").toString());
        //根据用户ID获取用户信息
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        User user = UserFactory.create(userPO);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowdate = sdf.format(date);
        SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf5 = new SimpleDateFormat("HH:mm:ss");
        String weekofday = sdf3.format(date);
        String hourmin = sdf4.format(date);
        String hourminsec = sdf5.format(date);
        Long aid = null;
        Integer count = attendanceServiceV2.countAttendance(nowdate, userId);
        if (hourminsec.compareTo(end) > 0) {
            // 在17之后签到无效
            System.out.println("----不能签到");
            model.addAttribute("error", "1");
        }
        if (hourminsec.compareTo("05:00:00") < 0) {
            //在凌晨5点之前不能签到
            System.out.println("----不能签到");
            model.addAttribute("error", "2");
        } else if ((hourminsec.compareTo("05:00:00") > 0)) {
            if (count == 0) {
                if (hourminsec.compareTo(end) < 0) {
                    typeId = 8;
                    if (hourminsec.compareTo(start) > 0) {
                        statusId = 11;
                    } else if (hourminsec.compareTo(start) < 0) {
                        statusId = 10;
                    }
                    AttendsPO attendsPO = new AttendsPO();
                    attendsPO.setTypeId(typeId);
                    attendsPO.setStatusId(statusId);
                    attendsPO.setAttendsTime(date);
                    attendsPO.setAttendHmtime(hourmin);
                    attendsPO.setWeekOfday(weekofday);
                    attendsPO.setAttendsIp(attendip);
                    attendsPO.setAttendsUserId(userId);
                    attendsPOMapper.updateByPrimaryKeySelective(attendsPO);
                }
            }
            if (count == 1) {
                typeId = 9;
                if (hourminsec.compareTo(end) > 0) {
                    statusId = 10;
                } else if (hourminsec.compareTo(end) < 0) {
                    statusId = 12;
                }
                AttendsPO attendsPO = new AttendsPO();
                attendsPO.setTypeId(typeId);
                attendsPO.setStatusId(statusId);
                attendsPO.setAttendsTime(date);
                attendsPO.setAttendHmtime(hourmin);
                attendsPO.setWeekOfday(weekofday);
                attendsPO.setAttendsIp(attendip);
                attendsPO.setAttendsUserId(userId);
                attendsPOMapper.updateByPrimaryKeySelective(attendsPO);
            }
            if (count >= 2) {
                if (hourminsec.compareTo(end) > 0) {
                    statusId = 10;
                } else if (hourminsec.compareTo(end) < 0) {
                    statusId = 12;
                }
                aid = attendanceServiceV2.userAttendanceId(nowdate, 9L, userId);
                AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(aid);
                Attends attends2 = AttendsFactory.create(userPO, attendsPO);
                attends2.setAttendsIp(attendip);
                attendsPOMapper.updateByPrimaryKeySelective(attendsPO);
                // 更改考勤时间（根据考勤表ID修改考勤时间，考勤时分）
                attendanceServiceV2.updateTimeV2(date, hourmin, statusId, aid);
                //查找某用户某天最新记录用来显示用户最新的类型和考勤时间（考勤表的用户ID，考勤时间）
                Attends aList = attendanceServiceV2.attends(nowdate, userId, userPO);
            }
        }
        // 显示用户当天最新的记录
//        Attends aList = attenceDao.findlastest(nowdate, userId);
        Attends aList = attendanceServiceV2.attends(nowdate, userId, userPO);
        if (aList != null) {
            String type = attendanceServiceV2.typeName(aList.getTypeId());
            model.addAttribute("type", type);
        }
        model.addAttribute("alist", aList);
        return "systemcontrol/signin";
    }

    // 考勤列表 给单个用户使用
    @RequestMapping(value = "attendcelist", method = RequestMethod.GET)
    public String test(HttpServletRequest request, Model model, HttpSession session,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "baseKey", required = false) String baseKey,
                       @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "status", required = false) String status,
                       @RequestParam(value = "time", required = false) String time,
                       @RequestParam(value = "icon", required = false) String icon) {
//        signsortpaging(request, model, session, page, null, type, status, time, icon);
        signsortpagingV2(request, model, session, page, null, type, status, time, icon);
        return "attendce/attendcelist";
    }

    @RequestMapping(value = "attendcelisttable", method = RequestMethod.GET)
    public String testdf(HttpServletRequest request, Model model, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon) {
//        signsortpaging(request, model, session, page, baseKey, type, status, time, icon);
        signsortpagingV2(request, model, session, page, baseKey, type, status, time, icon);
        return "attendce/attendcelisttable";
    }


    /**
     * 考勤管理某个管理员下面的所有员工的信息
     *
     * @param request请求
     * @param session
     * @param page页面
     * @param baseKey
     * @param type考勤类型
     * @param status考勤状态
     * @param time
     * @param icon
     * @param model
     * @return
     */
    @RequestMapping("attendceatt")
    public String testdasf(HttpServletRequest request, HttpSession session,
                           @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "baseKey", required = false) String baseKey,
                           @RequestParam(value = "type", required = false) String type,
                           @RequestParam(value = "status", required = false) String status,
                           @RequestParam(value = "time", required = false) String time,
                           @RequestParam(value = "icon", required = false) String icon, Model model) {
        //莫管理下的所有考勤信息
//        allsortpaging(request, session, page, baseKey, type, status, time, icon, model);
        attendceattPage(request, session, page, baseKey, type, status, time, icon, model);
        return "attendce/attendceview";
    }

    // 分頁分页
    @RequestMapping("attendcetable")
    public String table(HttpServletRequest request, HttpSession session,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "baseKey", required = false) String baseKey,
                        @RequestParam(value = "type", required = false) String type,
                        @RequestParam(value = "status", required = false) String status,
                        @RequestParam(value = "time", required = false) String time,
                        @RequestParam(value = "icon", required = false) String icon, Model model) {
//        allsortpaging(request, session, page, baseKey, type, status, time, icon, model);
        attendceattPage(request, session, page, baseKey, type, status, time, icon, model);
        return "attendce/attendcetable";
    }


    // 删除
    @RequestMapping("attdelete")
    public String dsfa(HttpServletRequest request, HttpSession session) {
        long aid = Long.valueOf(request.getParameter("aid"));
//        attendceService.delete(aid);
        attendanceServiceV2.deleteUserAttendanceByAid(aid);
        return "redirect:/attendceatt";
    }

    // 月报表
    @RequestMapping("attendcemonth")
    public String test2(HttpServletRequest request, Model model, HttpSession session,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "baseKey", required = false) String baseKey) {
//        monthtablepaging(request, model, session, page, baseKey);
        monthtablepagingV2(request, model, session, page, baseKey);
        return "attendce/monthtable";
    }

    @RequestMapping("realmonthtable")
    public String dfshe(HttpServletRequest request, Model model, HttpSession session,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "baseKey", required = false) String baseKey) {
//        monthtablepaging(request, model, session, page, baseKey);
        monthtablepagingV2(request, model, session, page, baseKey);
        return "attendce/realmonthtable";
    }

    // 周报表
    @RequestMapping("attendceweek")
    public String attendanceWeek(HttpServletRequest request, HttpSession session,
                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "baseKey", required = false) String baseKey) {
//        weektablepaging(request, session, page, baseKey);
        weektablepagingV2(request, session, page, baseKey);
        return "attendce/weektable";
    }

    @RequestMapping("realweektable")
    public String dsaf(HttpServletRequest request, HttpSession session,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "baseKey", required = false) String baseKey) {
//        weektablepaging(request, session, page, baseKey);
        weektablepagingV2(request, session, page, baseKey);
        return "attendce/realweektable";

    }


    @RequestMapping("attendceedit")
    public String updateSave(@Param("aid") String aid, Model model, HttpServletRequest request, HttpSession session) {
        Long userid = Long.valueOf(session.getAttribute("userId") + "");
        if (aid == null) {
            model.addAttribute("write", 0);
        } else if (aid != null) {
            long id = Long.valueOf(aid);
            Attends attends = attenceDao.findOne(id);
            model.addAttribute("write", 1);
            model.addAttribute("attends", attends);
        }
        typestatus(request);
        return "attendce/attendceedit";
    }

    @RequestMapping("attendceedit2")
    public String DSAGen(HttpServletRequest request) {
        long id = Long.valueOf(request.getParameter("id"));
        Attends attends = attenceDao.findOne(id);
        request.setAttribute("attends", attends);
        typestatus(request);
        return "attendce/attendceedit2";
    }

    @RequestMapping(value = "attendcesave", method = RequestMethod.GET)
    public void Datadf() {
    }


        // 修改保存
        @RequestMapping(value = "attendcesave", method = RequestMethod.POST)
        public String updateSave(Model model, HttpSession session, HttpServletRequest request) {
            Long userid = Long.parseLong(session.getAttribute("userId") + "");
            String remark = request.getParameter("remark");
            String statusname = request.getParameter("status");
            SystemStatusList statusList = statusDao.findByStatusModelAndStatusName("aoa_attends_list", statusname);
            long id = Long.parseLong(request.getParameter("id"));
            Attends attends = attenceDao.findOne(id);
            attends.setAttendsRemark(remark);
            attenceDao.save(attends);
            //attendceService.updatereamrk(remark, id);
            return "redirect:/attendceatt";
        }

/*
    // 修改保存
    @RequestMapping(value = "attendcesave", method = RequestMethod.POST)
    public String test4(Model model, HttpSession session, HttpServletRequest request) {
        Long userid = Long.parseLong(session.getAttribute("userId") + "");
        String remark = request.getParameter("remark");
        String statusname = request.getParameter("status");
        SystemStatusList statusList = statusDao.findByStatusModelAndStatusName("aoa_attends_list", statusname);
        long id = Long.parseLong(request.getParameter("id"));
        Attends attends = attenceDao.findOne(id);
        attends.setAttendsRemark(remark);
        attends.setStatusId(statusList.getStatusId());
        attenceDao.save(attends);
        //attendceService.updatereamrk(remark, id);
        return "redirect:/attendceatt";
    }
*/
/*
    // 修改保存
    @RequestMapping(value = "attendcesave", method = RequestMethod.POST)
    public String updateSaveV2(Model model, HttpSession session, HttpServletRequest request) {
        Long userid = Long.parseLong(session.getAttribute("userId") + "");
        String remark = request.getParameter("remark");
        String statusname = request.getParameter("status");
        //自己改的
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo("aoa_attends_list")
                .andStatusNameEqualTo(statusname);
        List<StatusPO>statusPOList  = statusPOMapper.selectByExample(statusPOExample);
        long id = Long.parseLong(request.getParameter("id"));
       自己写的
        AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(id);
        attendsPO.setAttendsRemark(remark);
        attendsPO.setStatusId(statusList.getStatusId());
        attendsPOMapper.updateByPrimaryKeySelective(attendsPO);

        //attendceService.updatereamrk(remark, id);
        return "redirect:/attendceatt";
    }
    */

    // 状态类型方法
    private void typestatus(HttpServletRequest request) {
        //根据模型里面的表名查询到的类型列表，放到类型列表集合里面
        List<SystemTypeList> type = (List<SystemTypeList>) typeDao.findByTypeModel("aoa_attends_list");

        //根据模型里面的表名查询到的状态列表，放到状态列表集合里面
        List<SystemStatusList> status = (List<SystemStatusList>) statusDao.findByStatusModel("aoa_attends_list");

        request.setAttribute("typelist", type);
        request.setAttribute("statuslist", status);
    }

    //新的类型方法
    private void typestatusV2(HttpServletRequest request) {
        //获取模型里面的类型放到类型列表集合里面V2
        TypePOExample typePOExample = new TypePOExample();
        typePOExample.createCriteria().andTypeModelEqualTo("aoa_attends_list");
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        List<SystemTypeList> systemTypeLists = TypeFactory.createTypes(typePOList);

        //获取模型里面的状态放到状态列表集合里面
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo("aoa_attends_list");
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        List<SystemStatusList> systemStatusLists = StatusFactory.createStatus(statusPOList);

        request.setAttribute("typelist", systemTypeLists);
        request.setAttribute("statuslist", systemStatusLists);
    }

    /**
     * 设置model里面的属性
     *
     * @param baseKey
     * @param type考勤类型
     * @param status考勤状态
     * @param time考勤时间
     * @param icon
     * @param model模型
     */
    public void setModelSomething(String baseKey, Object type, Object status, Object time, Object icon, Model model) {
        if (!StringUtils.isEmpty(icon)) {
            //如果icon不为空把icon添加到model中
            model.addAttribute("icon", icon);
            if (!StringUtils.isEmpty(type)) {
                //如果type不为空把type添加到mode中
                model.addAttribute("type", type);
                if ("1".equals(type)) {
                    model.addAttribute("sort", "&type=1&icon=" + icon);
                } else {
                    model.addAttribute("sort", "&type=0&icon=" + icon);
                }
            }
            if (!StringUtils.isEmpty(status)) {
                //如果状态不为空把状态status添加到mode中
                model.addAttribute("status", status);
                if ("1".equals(status)) {
                    //如果状态是1把icon添加到mode中
                    model.addAttribute("sort", "&status=1&icon=" + icon);
                } else {
                    //如果状态是0把icon添加到mode中
                    model.addAttribute("sort", "&status=0&icon=" + icon);
                }
            }
            if (!StringUtils.isEmpty(time)) {
                model.addAttribute("time", time);
                if ("1".equals(time)) {
                    model.addAttribute("sort", "&time=1&icon=" + icon);
                } else {
                    model.addAttribute("sort", "&time=0&icon=" + icon);
                }
            }
        }
        if (!StringUtils.isEmpty(baseKey)) {
            model.addAttribute("sort", "&baseKey=" + baseKey);
        }
    }

    //单个用户的排序和分页
    private void signsortpaging(HttpServletRequest request, Model model, HttpSession session, int page, String baseKey,
                                String type, String status, String time, String icon) {
        Long userid = Long.valueOf(session.getAttribute("userId") + "");
        setModelSomething(baseKey, type, status, time, icon, model);
        Page<Attends> page2 = attendceService.singlepage(page, baseKey, userid, type, status, time);
        typestatus(request);
        request.setAttribute("alist", page2.getContent());
        for (Attends attends : page2.getContent()) {
            System.out.println(attends);
        }
        request.setAttribute("page", page2);
        request.setAttribute("url", "attendcelisttable");
    }

    //单个用户的排序和分页
    private void signsortpagingV2(HttpServletRequest request, Model model, HttpSession session, int page, String baseKey,
                                  String type, String status, String time, String icon) {
        Long userid = Long.valueOf(session.getAttribute("userId").toString());
        setModelSomething(baseKey, type, status, time, icon, model);
        List<Attends> attendsList = attendanceServiceV2.attendancePage(page, userid);
        typestatusV2(request);
        request.setAttribute("alist", attendsList);
        request.setAttribute("page", attendsList);
        request.setAttribute("url", "attendcelisttable");
    }

    //新增的方法（改管理下的所有所有用户）V2
    private void attendceattPage(HttpServletRequest request, HttpSession session, int page, String baseKey,
                                 String type, String status, String time, String icon, Model model) {
        setModelSomething(baseKey, type, status, time, icon, model);
        // 上司的ID
        Long userId = Long.valueOf(session.getAttribute("userId").toString());

        //根据上司ID查询下属用户
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(userId);
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);

        //把自己定义的下属用户转换为本身的下属用户
        List<User> userList = UserFactory.create(userPOList);

        //获取下属的用户ID
        List<Long> ids = UserFactory.getUserIds(userList);

        //根据上司ID查询上司信息
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        //把自己定义的用户转换为本身的用户
        User user = UserFactory.create(userPO);

        typestatusV2(request);

        QueryAttendsBO queryAttendsBO = new QueryAttendsBO();
        PageBO pageBO = new PageBO(page);

        queryAttendsBO.setUserIds(ids);
        List<AttendsPO> attendsPOList = attendanceServiceV2.queryAttend(queryAttendsBO, pageBO);

        List<Attends> attendsList = AttendsFactory.create(userPOList, attendsPOList);

        //获取考勤页面的内容放到请求对象的alist里面
        request.setAttribute("alist", attendsList);
        //把考勤页面的引用page2放到请求对象的page中
        request.setAttribute("page", attendsList);
        //设置请求对象的url为attendcetable
        request.setAttribute("url", "attendcetable");
    }

    //该管理下面的所有用户
    private void allsortpaging(HttpServletRequest request, HttpSession session, int page, String baseKey, String type,
                               String status, String time, String icon, Model model) {
        //设置model里面的属性
        setModelSomething(baseKey, type, status, time, icon, model);
        //从session里面获取用户ID
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        //创建Long类型的集合ids用于存放查询到的用户ID
        List<Long> ids = new ArrayList<>();
        //根据上司ID查询到下属用户
        List<User> users = uDao.findByFatherId(userId);
        //遍历查询到的 下属用户
        for (User user : users) {
            //获取下属用户的ID并添加到创建的集合ids中
            ids.add(user.getUserId());
        }
        //如果集合中的size为0说明没有用户，把0添加进去
        if (ids.size() == 0) {
            ids.add(0L);
        }
        //根据上司的ID查询上司的用户信息
        User user = uDao.findOne(userId);
        //把类型状态列表设置到请求对象里面
        typestatus(request);

        //根据下属用户ID，类型，状态，时间来分页查询，把结果放到考勤页面里面
        Page<Attends> page2 = attendceService.paging(page, baseKey, ids, type, status, time);

        //获取考勤页面的内容放到请求对象的alist里面
        request.setAttribute("alist", page2.getContent());
        //把考勤页面的引用page2放到请求对象的page中
        request.setAttribute("page", page2);
        //设置请求对象的url为attendcetable
        request.setAttribute("url", "attendcetable");
    }

    //新的考勤周报表分页V2
    private void weektablepagingV2(HttpServletRequest request, HttpSession session, int page, String baseKey) {
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        // 格式转化
        service.addConverter(new StringtoDate());
        Date startdate = service.convert(starttime, Date.class);
        Date enddate = service.convert(endtime, Date.class);
        //获取上司用户的ID
        Long fatherId = Long.parseLong(session.getAttribute("userId").toString());

        //获取fatherId下的所有用户的信息并且分页,该UserPO里面只有用户部门的dept_id
        List<UserPO> userPOList = userServiceV2.findUserAndPageByFatherId(page, fatherId);
        //把自己定义的用户列表转换成人家的，用户的 dept为null
        List<User> userList = UserFactory.create(userPOList);
        //把用户ID和部门对应起来
        Map<Long, Dept> map = userServiceV2.userIdAndDept(userPOList);

        //把一周的靠勤的考勤放到attendsList 里面,已经转换为本身的考勤列表
        List<Attends> attendsList = attendanceServiceV2.findOneWeekV2(startdate, enddate, userList);

        for (User user : userList) {
            Set<Attends> attenceset = new HashSet<>();
            for (Attends attence : attendsList) {
                if (Objects.equals(attence.getUser().getUserId(), user.getUserId())) {
                    //把一个用户的考勤拿出来放到set集合里面
                    attenceset.add(attence);
                }
            }
            // 把部门信息放到用户里面
            user.setDept(map.get(user.getUserId()));
            // 把用户的考勤放到用户里面
            user.setaSet(attenceset);
        }
        String[] weekday = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        request.setAttribute("ulist", userList);
        request.setAttribute("page", userList);
        request.setAttribute("weekday", weekday);
        request.setAttribute("url", "realweektable");
    }


    //考勤周报表分页
    private void weektablepaging(HttpServletRequest request, HttpSession session, int page, String baseKey) {
        //获取开始时间
        String starttime = request.getParameter("starttime");
        //获取结束时间
        String endtime = request.getParameter("endtime");
        // 格式转化
        service.addConverter(new StringtoDate());
        //第一个类型表示原类型，第二个类型表示目标类型，然后里面定义了一个convert方法，
        //将原类型对象作为参数传入进行转换之后返回目标类型对象
        //Date.class获取Date中的一个对象
        Date startdate = service.convert(starttime, Date.class);
        Date enddate = service.convert(endtime, Date.class);

        //用来查找该用户下面管理的所有用户信息
        //获取用户的ID
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        List<Long> ids = new ArrayList<>();
        //获取userId下的所有用户的信息
        Page<User> userspage = userService.findmyemployuser(page, baseKey, userId);
        for (User user : userspage) {
            //遍历所有用户信息并把用户ID加到ids中
            ids.add(user.getUserId());
        }
        if (ids.size() == 0) {
            ids.add(0L);
        }

        //找到某个管理员下面的所有用户的信息 保证传过来的是正确的数据 分页之后可以使用全局变量来
        //记住开始和结束日期
        if (startdate != null && enddate != null) {
            start = startdate;
            end = enddate;
        }
        if (startdate == null && enddate == null)
            startdate = start;
        enddate = end;
        System.out.println("再次获取" + startdate + "结束" + enddate);
        //把一周的靠勤的放到alist 里面
        List<Attends> alist = attenceDao.findoneweek(startdate, enddate, ids);

        for (User user : userspage) {
            Set<Attends> attenceset = new HashSet<>();

            for (Attends attence : alist) {
                if (Objects.equals(attence.getUser().getUserId(), user.getUserId())) {
                    //把一个用户的考勤拿出来放到set集合里面
                    attenceset.add(attence);
                }
            }
            // 把用户的考勤放到用户里面
            user.setaSet(attenceset);
        }
        String[] weekday = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        request.setAttribute("ulist", userspage.getContent());
        request.setAttribute("page", userspage);
        request.setAttribute("weekday", weekday);
        request.setAttribute("url", "realweektable");
    }

    //月报表
    private void monthtablepaging(HttpServletRequest request, Model model,
                                  HttpSession session, int page, String baseKey) {
//        offnum下班次数，上班次数toworknum
        Integer offnum, toworknum;
        //获取到上司的ID
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        //定义集合用于存放下属用户ID
        List<Long> ids = new ArrayList<>();
        //找到该管理员下的所有用户并分页
        Page<User> userspage = userService.findmyemployuser(page, baseKey, userId);
//        遍历下属用户信息获取下属用户ID
        for (User user : userspage) {
            ids.add(user.getUserId());
        }
        if (ids.size() == 0) {
            ids.add(0L);
        }
//        获取月份
        String month = request.getParameter("month");

        if (month != null)
            month_ = month;
        else
            month = month_;
//用户名和天数
        Map<String, List<Integer>> uMap = new HashMap<>();
        List<Integer> result = null;
        for (User user : userspage) {
            result = new ArrayList<>();
            //当月该用户下班次数
            offnum = attenceDao.countoffwork(month, user.getUserId());
            //当月该用户上班次数
            toworknum = attenceDao.counttowork(month, user.getUserId());
            //10正常；11迟到；12早退
            for (long statusId = 10; statusId < 13; statusId++) {
                //这里面记录了正常迟到早退等状态
                if (statusId == 12)
                    result.add(attenceDao.countnum(month, statusId, user.getUserId()) + toworknum - offnum);//只有上班没有下班按早退算
                else
                    result.add(attenceDao.countnum(month, statusId, user.getUserId()));
            }
            //添加请假和出差的记录//应该是查找 使用sql的sum（）函数来统计出差和请假的次数
            System.out.println("请假天数" + attenceDao.countothernum(month, 46L, user.getUserId()));
            if (attenceDao.countothernum(month, 46L, user.getUserId()) != null)
                result.add(attenceDao.countothernum(month, 46L, user.getUserId()));
            else
                result.add(0);
            if (attenceDao.countothernum(month, 47L, user.getUserId()) != null)
                result.add(attenceDao.countothernum(month, 47L, user.getUserId()));
            else
                result.add(0);
            //这里记录了旷工的次数 还有请假天数没有记录 旷工次数=30-8-请假次数-某天签到次数
            //这里还有请假天数没有写
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            //当前的年月
            String date_month = sdf.format(date);
            if (month != null) {
                //指定的数大于等于参数
                if (month.compareTo(date_month) >= 0)
                    result.add(0);
                else
                    //上班次数
                    result.add(30 - 8 - offnum);
            }
            uMap.put(user.getUserName(), result);
        }
        model.addAttribute("uMap", uMap);
        model.addAttribute("ulist", userspage.getContent());
        model.addAttribute("page", userspage);
        model.addAttribute("url", "realmonthtable");
    }

    //月报表V2
    private void monthtablepagingV2(HttpServletRequest request, Model model,
                                    HttpSession session, int page, String baseKey) {
        Integer offnum, toworknum;
        Long fatherId = Long.parseLong(session.getAttribute("userId").toString());
        //获取fatherId下的所有用户的信息并且分页
        List<UserPO> userPOList = userServiceV2.findUserAndPageByFatherId(page, fatherId);
        List<User> userList = UserFactory.create(userPOList);
//        获取月份
        String month = request.getParameter("month");
        Map<String, List<Integer>> uMap = new HashMap<>();
        List<Integer> result = null;
        //把用户ID和部门对应起来
        Map<Long, Dept> map = userServiceV2.userIdAndDept(userPOList);
        for (User user : userList) {
            // 把部门信息放到用户里面
            user.setDept(map.get(user.getUserId()));
            result = new ArrayList<>();
            //当月该用户下班次数
            offnum = attendanceServiceV2.userCountOffWork(month, user.getUserId());
            toworknum = attendanceServiceV2.userCountToWork(month, user.getUserId());
            //10正常；11迟到；12早退
            for (long statusId = 10; statusId < 13; statusId++) {
                //这里面记录了正常迟到早退等状态
                if (statusId == 12) {
                    result.add(attendanceServiceV2.userCountStatusNum(month, statusId, user.getUserId()) + toworknum - offnum);
                } else {
                    result.add(attendanceServiceV2.userCountStatusNum(month, statusId, user.getUserId()));
                }
            }

            if (attendanceServiceV2.userCountTypeNum(month, 46L, user.getUserId()) != null) {
                result.add(attendanceServiceV2.userCountTypeNum(month, 46L, user.getUserId()));
            } else {
                result.add(0);
            }
            if (attendanceServiceV2.userCountTypeNum(month, 47L, user.getUserId()) != null) {
                result.add(attendanceServiceV2.userCountTypeNum(month, 47L, user.getUserId()));
            } else {
                result.add(0);
            }
            //这里记录了旷工的次数 还有请假天数没有记录 旷工次数=30-8-请假次数-某天签到次数
            //这里还有请假天数没有写
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            //当前的年月
            String date_month = sdf.format(date);
            if (month != null) {
                //指定的数大于等于参数
                if (month.compareTo(date_month) >= 0)
                    result.add(0);
                else
                    //上班次数
                    result.add(30 - 8 - offnum);
            }
            uMap.put(user.getUserName(), result);
        }
        model.addAttribute("uMap", uMap);
        model.addAttribute("ulist", userList);
        model.addAttribute("page", userList);
        model.addAttribute("url", "realmonthtable");

    }
}