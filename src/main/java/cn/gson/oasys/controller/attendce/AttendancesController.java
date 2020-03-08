package cn.gson.oasys.controller.attendce;

import cn.gson.oasys.common.StringtoDate;
import cn.gson.oasys.modelV2.bo.PageInformation;
import cn.gson.oasys.modelV2.po.AttendsPO;
import cn.gson.oasys.modelV2.po.StatusPO;
import cn.gson.oasys.modelV2.po.TypePO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.serviceV2.attendansV2.AttendanceServiceV2;
import cn.gson.oasys.serviceV2.attendansV2.AttendancesPOService;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserServiceV2;
import cn.gson.oasys.voandfactory.attendansVO2.AttendancesVO;
import cn.gson.oasys.voandfactory.attendansVO2.AttendancesVOFactory;
import cn.gson.oasys.voandfactory.deptVO2.DeptVO;
import cn.gson.oasys.voandfactory.statusVO2.StatusVO;
import cn.gson.oasys.voandfactory.statusVO2.StatusVOFactory;
import cn.gson.oasys.voandfactory.typeVO2.TypeVO;
import cn.gson.oasys.voandfactory.typeVO2.TypeVOFactory;
import cn.gson.oasys.voandfactory.userVO2.UserVOFactory;
import cn.gson.oasys.voandfactory.userVO2.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class AttendancesController {

    @Resource
    private AttendanceServiceV2 attendanceServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private AttendancesPOService attendancesPOService;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private PageInformation pageInformation;


    // 格式转化导入
    DefaultConversionService service = new DefaultConversionService();

    /**
     * 考勤前面的签到
     *
     * @param session
     * @param model
     * @param request
     * @return
     * @throws InterruptedException
     * @throws UnknownHostException
     */
    @RequestMapping("singin")
    public String singIn(HttpSession session, Model model, HttpServletRequest request) throws InterruptedException, UnknownHostException {
        //首先获取主机ip
        String attendIp = InetAddress.getLocalHost().getHostAddress();
        String start = "08:00:00";//开始时间
        String end = "17:00:00";//结束时间
        // 时间规范
        service.addConverter(new StringtoDate());
        long typeId;
        // 状态默认是正常
        long statusId = 10;
        Long userId = Long.parseLong(session.getAttribute("userId").toString());//用户ID
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式
        Date date = new Date();
        String nowDate = sdf.format(date);//现在的时间（年月日）
        SimpleDateFormat sdf3 = new SimpleDateFormat("EE");//周几
        SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm");//时分
        SimpleDateFormat sdf5 = new SimpleDateFormat("HH:mm:ss");//时分秒
        String weekOfDay = sdf3.format(date);//现在时间是周几
        String hourMin = sdf4.format(date);//现在的时分
        String hourMinSec = sdf5.format(date);//现在的时分秒
        Integer count = attendanceServiceV2.countAttendance(nowDate, userId);//用户当天的考勤次数
        if (hourMinSec.compareTo("23:00:00") > 0) {
            // 在23之后签到无效
            model.addAttribute("error", "1");
        }
        if (hourMinSec.compareTo("05:00:00") < 0) {
            //在凌晨5点之前不能签到
            model.addAttribute("error", "2");
        } else if ((hourMinSec.compareTo("05:00:00") > 0)) {//5点之后
            if (count == 0) {//目前还没有签到
                if (hourMinSec.compareTo(end) < 0) {//17点之前
                    typeId = 8;//上班
                    if (hourMinSec.compareTo(start) > 0) {
                        statusId = 11;//上班迟到
                    } else if (hourMinSec.compareTo(start) < 0) {
                        statusId = 10;//上班正常
                    }
                    attendancesPOService.insertAttendancesPO(typeId, statusId, date, hourMin, weekOfDay, attendIp, userId);
                }
            }
            if (count == 1) {//已经签到1次
                typeId = 9;//下班（已经签到了一次，第二次按下班算）
                if (hourMinSec.compareTo(end) > 0) {
                    statusId = 10;//下班正常
                } else if (hourMinSec.compareTo(end) < 0) {
                    statusId = 12;//下班早退
                }
                attendancesPOService.insertAttendancesPO(typeId, statusId, date, hourMin, weekOfDay, attendIp, userId);
            }
            if (count >= 2) {
                if (hourMinSec.compareTo(end) > 0) {
                    statusId = 10;//正常
                } else if (hourMinSec.compareTo(end) < 0) {
                    statusId = 12;//早退
                }
                AttendsPO attendsPO = attendanceServiceV2.getUserNowDateAttendancePO(nowDate, 9L, userId);//获取用户当天的下班考勤ID
                // 更改考勤时间（根据考勤表ID修改考勤时间，考勤时分）
                attendancesPOService.updateTimeAndStatusIdAndIp(date, hourMin, statusId, attendsPO.getAttendsId(), attendIp);
            }
        }
        //查找某用户某天最新记录用来显示用户最新的类型和考勤时间（考勤表的用户ID，考勤时间）
        AttendsPO attendsPO = attendanceServiceV2.getNewAttendancePOByUserId(nowDate, userId);
        AttendancesVO attendanceVO = AttendancesVOFactory.createAttendancesVOByAttendancesPO(attendsPO);
        if (attendanceVO != null) {
            String typeName = typePOServiceV2.getTypeNameByTypeId(attendanceVO.getTypeId());//根据类型ID查找类型名
            model.addAttribute("type", typeName);
        }
        model.addAttribute("alist", attendanceVO);
        return "systemcontrol/signin";
    }


    /**
     * 单个用户使用考勤列表
     *
     * @param request
     * @param model
     * @param session
     * @param page    第几页
     * @param baseKey 模糊字
     * @param type    类型
     * @param status  状态
     * @param time    时间
     * @param icon
     * @return
     */
    @RequestMapping(value = "attendcelist", method = RequestMethod.GET)
    public String attendanceList(HttpServletRequest request, Model model, HttpSession session,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "baseKey", required = false) String baseKey,
                                 @RequestParam(value = "type", required = false) String type,
                                 @RequestParam(value = "status", required = false) String status,
                                 @RequestParam(value = "time", required = false) String time,
                                 @RequestParam(value = "icon", required = false) String icon) {
        signSortPagingV2(request, model, session, page, null, type, status, time, icon);
        return "attendce/attendcelist";
    }

    /**
     * 单个用户使用考勤列表表格分页
     *
     * @param request
     * @param model
     * @param session
     * @param page
     * @param baseKey
     * @param type
     * @param status
     * @param time
     * @param icon
     * @return
     */
    @RequestMapping(value = "attendcelisttable", method = RequestMethod.GET)
    public String attendanceListTable(HttpServletRequest request, Model model, HttpSession session,
                                      @RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "baseKey", required = false) String baseKey,
                                      @RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "status", required = false) String status,
                                      @RequestParam(value = "time", required = false) String time,
                                      @RequestParam(value = "icon", required = false) String icon) {
        signSortPagingV2(request, model, session, page, baseKey, type, status, time, icon);
        return "attendce/attendcelisttable";
    }


    /**
     * 考勤管理（某个管理员下面的所有员工的考勤信息）
     *
     * @param request 请求
     * @param session
     * @param page    页面
     * @param baseKey 模糊字
     * @param type    考勤类型
     * @param status  考勤状态
     * @param time
     * @param icon
     * @param model
     * @return
     */
    @RequestMapping("attendceatt")
    public String attendancesManage(HttpServletRequest request, HttpSession session,
                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "baseKey", required = false) String baseKey,
                                    @RequestParam(value = "type", required = false) String type,
                                    @RequestParam(value = "status", required = false) String status,
                                    @RequestParam(value = "time", required = false) String time,
                                    @RequestParam(value = "icon", required = false) String icon, Model model) {
        //莫管理下的所有考勤信息
        attendancesManageUserPOPage(request, session, page, baseKey, type, status, time, icon, model);
        return "attendce/attendceview";
    }

    /**
     * 考勤管理（某个管理员下面的所有员工的考勤信息）表格分页
     *
     * @param request
     * @param session
     * @param page
     * @param baseKey
     * @param type
     * @param status
     * @param time
     * @param icon
     * @param model
     * @return
     */
    @RequestMapping("attendcetable")
    public String attendancesManageTable(HttpServletRequest request, HttpSession session,
                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "baseKey", required = false) String baseKey,
                                         @RequestParam(value = "type", required = false) String type,
                                         @RequestParam(value = "status", required = false) String status,
                                         @RequestParam(value = "time", required = false) String time,
                                         @RequestParam(value = "icon", required = false) String icon, Model model) {
        attendancesManageUserPOPage(request, session, page, baseKey, type, status, time, icon, model);
        return "attendce/attendcetable";
    }


    /**
     * 删除
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("attdelete")
    public String deleteAttendances(HttpServletRequest request, HttpSession session) {
        long aid = Long.valueOf(request.getParameter("aid"));//考勤ID
        attendancesPOService.deleteAttendancesPOByAttendancesId(aid);//根据考勤ID删除考勤
        return "redirect:/attendceatt";
    }


    /**
     * 月报表
     *
     * @param request
     * @param model
     * @param session
     * @param page
     * @param baseKey
     * @return
     */
    @RequestMapping("attendcemonth")
    public String attendancesMonth(HttpServletRequest request, Model model, HttpSession session,
                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "baseKey", required = false) String baseKey) {
        monthTablePage(request, model, session, page, baseKey);
        return "attendce/monthtable";
    }

    /**
     * 月报表表格
     *
     * @param request
     * @param model
     * @param session
     * @param page
     * @param baseKey
     * @return
     */
    @RequestMapping("realmonthtable")
    public String realMonthTable(HttpServletRequest request, Model model, HttpSession session,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "baseKey", required = false) String baseKey) {
        monthTablePage(request, model, session, page, baseKey);
        return "attendce/realmonthtable";
    }

    /**
     * 周报表
     *
     * @param request
     * @param session
     * @param page
     * @param baseKey
     * @return
     */
    @RequestMapping("attendceweek")
    public String attendancesWeek(HttpServletRequest request, HttpSession session,
                                  @RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "baseKey", required = false) String baseKey) {
        weekTablePage(request, session, page, baseKey);
        return "attendce/weektable";
    }

    /**
     * 真实表格周报表
     *
     * @param request
     * @param session
     * @param page
     * @param baseKey
     * @return
     */
    @RequestMapping("realweektable")
    public String realWeekTable(HttpServletRequest request, HttpSession session,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "baseKey", required = false) String baseKey) {
        weekTablePage(request, session, page, baseKey);
        return "attendce/realweektable";

    }

    /**
     * 考勤管理的修改
     *
     * @param aid     考勤ID
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("attendceedit")
    public String attendancesManageEdit(@Param("aid") String aid, Model model, HttpServletRequest request, HttpSession session) {
        if (aid == null) {
            model.addAttribute("write", 0);
        } else if (aid != null) {
            long id = Long.valueOf(aid);
            AttendsPO attendsPO = attendancesPOService.getAttendancesPOByAttendancesId(id);
            AttendancesVO attendanceVO = AttendancesVOFactory.createAttendancesVOByAttendancesPO(attendsPO);
            model.addAttribute("write", 1);
            model.addAttribute("attends", attendanceVO);
        }
        typeAndStatusV2(request);
        return "attendce/attendceedit";
    }

    /**
     * 考勤编辑2
     *
     * @param request
     * @return
     */
    @RequestMapping("attendceedit2")
    public String attendancesEdit2(HttpServletRequest request) {
        long aid = Long.valueOf(request.getParameter("id"));//考勤ID
        AttendsPO attendsPO = attendancesPOService.getAttendancesPOByAttendancesId(aid);
        AttendancesVO attendanceVO = AttendancesVOFactory.createAttendancesVOByAttendancesPO(attendsPO);
        typeAndStatusV2(request);
        request.setAttribute("attends", attendanceVO);
        return "attendce/attendceedit2";
    }

    /**
     * 考勤管理的修改保存
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "attendcesave", method = RequestMethod.POST)
    public String updateSaveAttendances(HttpServletRequest request) {
        String remark = request.getParameter("remark");//考勤备注
        String statusName = request.getParameter("status");//状态名
        StatusPO statusPO = statusPOServiceV2.getStatusPOByTypeModelAndStatusName("aoa_attends_list", statusName);
        long id = Long.parseLong(request.getParameter("id"));//考勤id
        attendancesPOService.updateAttendancesByRemarkAndStatusId(remark, statusPO.getStatusId(), id);
        return "redirect:/attendceatt";
    }

    /**
     * 设置model里面的属性
     *
     * @param baseKey
     * @param type    考勤类型
     * @param status  考勤状态
     * @param time    考勤时间
     * @param icon
     * @param model   模型
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


    /**
     * 单个用户的排序和分页
     *
     * @param request
     * @param model
     * @param session
     * @param page
     * @param baseKey
     * @param type
     * @param status
     * @param time
     * @param icon
     */
    private void signSortPagingV2(HttpServletRequest request, Model model, HttpSession session, int page, String baseKey,
                                  String type, String status, String time, String icon) {
        Long userId = Long.valueOf(session.getAttribute("userId").toString());//用户ID
        setModelSomething(baseKey, type, status, time, icon, model);//设置model里面的属性
        //获取用户的考勤列表
        List<AttendsPO> attendsPOList = attendancesPOService.getAttendancesPOListByUserId(userId);
        List<AttendancesVO> subAttendanceVOList = pageInformation.getAttendancesVOListPage(page, 10, attendsPOList, request);
        typeAndStatusV2(request);
        request.setAttribute("alist", subAttendanceVOList);
        request.setAttribute("url", "attendcelisttable");
    }

    /**
     * 根据类型模型和状态模型找类型列表和状态列表
     *
     * @param request
     */
    private void typeAndStatusV2(HttpServletRequest request) {
        //根据类型模型找类型列表
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_attends_list");
        List<TypeVO> typeVOList = TypeVOFactory.createTypeVOListByTypePOList(typePOList);
//        根据状态模型找状态列表
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_attends_list");
        List<StatusVO> statusVOList = StatusVOFactory.createStatusVOListByStatusPOList(statusPOList);
        request.setAttribute("typelist", typeVOList);
        request.setAttribute("statuslist", statusVOList);
    }

    /**
     * 考勤管理》考勤管理
     *
     * @param request
     * @param session
     * @param page
     * @param baseKey
     * @param type
     * @param status
     * @param time
     * @param icon
     * @param model
     */
    private void attendancesManageUserPOPage(HttpServletRequest request, HttpSession session, int page, String baseKey,
                                             String type, String status, String time, String icon, Model model) {
        setModelSomething(baseKey, type, status, time, icon, model);//设置model里面的属性
        Long userId = Long.valueOf(session.getAttribute("userId").toString());//用户ID即上司的ID
        List<UserPO> userPOList = userPOServiceV2.getUserPOListByFatherId(userId);// 找此用户的下属用户列表
        //获取下属的用户ID
        List<Long> userIds = userServiceV2.getUserIdsByUserPOList(userPOList);
        typeAndStatusV2(request);
        //根据下属用户ID，类型，状态，时间来分页查询，把结果放到考勤页面里面
        List<AttendsPO> attendsPOList = attendanceServiceV2.attendancesPage(baseKey, userIds, type, status, time);
        List<AttendancesVO> subAttendanceVOList = pageInformation.getAttendancesVOListPage(page, 10, attendsPOList, request);
        //获取考勤页面的内容放到请求对象的alist里面
        request.setAttribute("alist", subAttendanceVOList);
        //设置请求对象的url为attendcetable
        request.setAttribute("url", "attendcetable");
    }

    /**
     * 考勤周报表方法
     *
     * @param request
     * @param session
     * @param page
     * @param baseKey
     */
    private void weekTablePage(HttpServletRequest request, HttpSession session, int page, String baseKey) {
        String startTime = request.getParameter("starttime");//开始时间
        String endTime = request.getParameter("endtime");//结束时间
        // 格式转化
        service.addConverter(new StringtoDate());
        Date startDate = service.convert(startTime, Date.class);
        Date endDate = service.convert(endTime, Date.class);
        Long userId = Long.parseLong(session.getAttribute("userId").toString());//用户ID
        //获取用户的下属用户
        List<UserPO> userPOList = userPOServiceV2.getUserPOByFatherId(userId);
        List<UserPO> sunUserPOList = pageInformation.getUserPOListPage(page, 10, userPOList, request);
        List<UserVO> userVOList = UserVOFactory.createUserVOListByUserPOList(sunUserPOList);
        //获取下属用户ids
        List<Long> userIds = userServiceV2.getUserIdsByUserPOList(userPOList);
        //把用户ID和部门对应起来
        Map<Long, DeptVO> map = userPOServiceV2.userIdAndDeptVO(userPOList);
        //下属一段时间内的考勤
        List<AttendsPO> attendsPOList = attendanceServiceV2.findOneWeek(startDate, endDate, userIds);
        List<AttendancesVO> attendanceVOList = attendanceServiceV2.getAttendancesVOListByAttendancesPOList(attendsPOList);
        for (UserVO userVO : userVOList) {
            Set<AttendancesVO> attendanceVOSet = new HashSet<>();
            for (AttendancesVO attendanceVO : attendanceVOList) {
                if (Objects.equals(attendanceVO.getUserVO().getUserId(), userVO.getUserId())) {
                    //把一个用户的考勤拿出来放到set集合里面
                    attendanceVOSet.add(attendanceVO);
                }
            }
//            把部门信息放到用户里面
            userVO.setDeptVO(map.get(userVO.getUserId()));
            // 把用户的考勤放到用户里面
            userVO.setAttendancesSet(attendanceVOSet);
        }
        String[] weekday = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        request.setAttribute("ulist", userVOList);
        request.setAttribute("weekday", weekday);
        request.setAttribute("url", "realweektable");
    }


    /**
     * 月报表方法
     *
     * @param request
     * @param model
     * @param session
     * @param page
     * @param baseKey
     */
    private void monthTablePage(HttpServletRequest request, Model model,
                                HttpSession session, int page, String baseKey) {
        Integer offNum, toWorkNum;// 下班数，上班数
        Long userId = Long.parseLong(session.getAttribute("userId").toString());//用户ID
        //获取用户的下属用户并分页
        List<UserPO> userPOList = userPOServiceV2.getUserPOListByFatherIdAndUsernameLikeAndRealNameLike(userId, baseKey);
        List<UserPO> sunUserPOList = pageInformation.getUserPOListPage(page, 10, userPOList, request);
        List<UserVO> userVOList = UserVOFactory.createUserVOListByUserPOList(sunUserPOList);
//        获取月份
        String month = request.getParameter("month");
        Map<String, List<Integer>> uMap = new HashMap<>();//用户名和各种天数
        List<Integer> result;//用于添加各种天数
        //把用户ID和部门对应起来
        Map<Long, DeptVO> map = userPOServiceV2.userIdAndDeptVO(userPOList);
        for (UserVO userVO : userVOList) {
            // 把部门信息放到用户里面
            userVO.setDeptVO(map.get(userVO.getUserId()));
            result = new ArrayList<>();
            //当月该用户下班次数
            offNum = attendanceServiceV2.userCountOffWorkOrToWorkOrLeaveOrEvection(month, userVO.getUserId(), 9L);
//            当月该用户上班次数
            toWorkNum = attendanceServiceV2.userCountOffWorkOrToWorkOrLeaveOrEvection(month, userVO.getUserId(), 8L);
            //10正常；11迟到；12早退
            for (long statusId = 10; statusId < 13; statusId++) {
                //这里面记录了正常迟到早退等状态
                if (statusId == 12) {//只上班没下班按早退算
                    result.add(attendanceServiceV2.userCountStatusNum(month, statusId, userVO.getUserId()) + toWorkNum - offNum);
                } else {
                    result.add(attendanceServiceV2.userCountStatusNum(month, statusId, userVO.getUserId()));
                }
            }
            //获取请假的次数请假
            if (attendanceServiceV2.userCountOffWorkOrToWorkOrLeaveOrEvection(month, userVO.getUserId(), 46L) != null) {
                result.add(attendanceServiceV2.userCountOffWorkOrToWorkOrLeaveOrEvection(month, userVO.getUserId(), 46L));
            } else {
                result.add(0);
            }
            //获取出差的次数
            if (attendanceServiceV2.userCountOffWorkOrToWorkOrLeaveOrEvection(month, userVO.getUserId(), 47L) != null) {
                result.add(attendanceServiceV2.userCountOffWorkOrToWorkOrLeaveOrEvection(month, userVO.getUserId(), 47L));
            } else {
                result.add(0);
            }
            //这里记录了旷工的次数 还有请假天数没有记录 旷工次数=30-8-请假次数-某天签到次数
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            //当前的年月
            String date_month = sdf.format(date);
            if (month != null) {
                //指定的数大于等于参数
                if (month.compareTo(date_month) >= 0) {
                    result.add(0);
                } else {
                    //旷工次数
                    result.add(30 - 8 - offNum);
                }
                uMap.put(userVO.getUserName(), result);
            }
        }
        model.addAttribute("uMap", uMap);
        model.addAttribute("ulist", userVOList);
        model.addAttribute("url", "realmonthtable");
    }

}