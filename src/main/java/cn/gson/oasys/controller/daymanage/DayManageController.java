package cn.gson.oasys.controller.daymanage;

import cn.gson.oasys.modelV2.bo.PageInformation;
import cn.gson.oasys.modelV2.po.SchedulePO;
import cn.gson.oasys.modelV2.po.StatusPO;
import cn.gson.oasys.modelV2.po.TypePO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.serviceV2.deptV2.DeptPOServiceV2;
import cn.gson.oasys.serviceV2.scheduleV2.ScheduleListPOServiceV2;
import cn.gson.oasys.serviceV2.scheduleV2.ScheduleServiceV2;
import cn.gson.oasys.serviceV2.scheduleV2.ScheduleUserPOServiceV2;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserServiceV2;
import cn.gson.oasys.voandfactory.scheduleVO2.ScheduleListVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Controller
@RequestMapping("/")
public class DayManageController {

    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private DeptPOServiceV2 deptPOServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private ScheduleListPOServiceV2 scheduleListPOServiceV2;
    @Resource
    private ScheduleUserPOServiceV2 scheduleUserPOServiceV2;
    @Resource
    private ScheduleServiceV2 scheduleServiceV2;
    @Resource
    PageInformation pageInformation;

    /**
     * 日程管理
     *
     * @param userId 用户ID
     * @param model
     * @param page   第几页
     * @param size   每页几条
     * @return
     */
    @RequestMapping("daymanage")
    private String dayManage(@SessionAttribute("userId") Long userId,
                             Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);
//        日程的类型信息
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_schedule_list");
//        日程的状态信息
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_schedule_list");
//        根据日程所属人找日程列表
        List<SchedulePO> schedulePOList = scheduleListPOServiceV2.getSchedulePOListByUserId(userId);
        List<SchedulePO> subSchedulePOS = pageInformation.getSchedulePOSPage(page, size, schedulePOList, model);
//        用户的部门名
        String deptName = deptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId()).getDeptName();

        model.addAttribute("types", typePOList);//日程类型
        model.addAttribute("statuses", statusPOList);//日程状态
        model.addAttribute("username", userPO.getUserName());//用户名
        model.addAttribute("deptName", deptName);//用户的部门名
        model.addAttribute("schedules", subSchedulePOS);//日程列表
        model.addAttribute("url", "daymanagepaging");
        model.addAttribute("ismyday", 1);
        return "daymanage/daymanage";
    }

    @RequestMapping("daymanagepaging")
    private String dayManagePaging(@SessionAttribute("userId") Long userId,
                                   Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);
//        日程的类型信息
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_schedule_list");
//        日程的状态信息
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_schedule_list");
//        根据日程所属人找日程列表
        List<SchedulePO> schedulePOList = scheduleListPOServiceV2.getSchedulePOListByUserId(userId);
        List<SchedulePO> subSchedulePOS = pageInformation.getSchedulePOSPage(page, size, schedulePOList, model);
//        用户的部门名
        String deptName = deptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId()).getDeptName();

        model.addAttribute("types", typePOList);//日程类型
        model.addAttribute("statuses", statusPOList);//日程状态
        model.addAttribute("username", userPO.getUserName());//用户名
        model.addAttribute("deptName", deptName);//用户的部门名
        model.addAttribute("schedules", subSchedulePOS);//日程列表
        model.addAttribute("url", "daymanagepaging");
        model.addAttribute("ismyday", 1);
        return "daymanage/daymanagepaging";
    }

    /**
     * 日程管理的增加，修改
     *
     * @param rcId  日程ID
     * @param page  第几页
     * @param size  每页大小
     * @param model
     * @return
     */
    @RequestMapping("dayedit")
    private String dayEdit(@RequestParam(value = "rcId", required = false) Long rcId,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size,
                           Model model) {
//        日程的类型信息
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_schedule_list");
//        日程的状态信息
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_schedule_list");
        if (rcId != null) {
//             日程信息
            SchedulePO schedulePO = scheduleListPOServiceV2.getSchedulePOBySchedulePOId(rcId);
//            日程的开始时间
            model.addAttribute("startTime", new Timestamp(schedulePO.getStartTime().getTime()));
//            日程的结束时间
            model.addAttribute("endTime", new Timestamp(schedulePO.getEndTime().getTime()));
//            是否提醒
            model.addAttribute("isRemind", schedulePO.getIsRemind() == 0 ? false : true);
//            日程信息
            model.addAttribute("rc", schedulePO);
        } else {
            model.addAttribute("startTime", new Timestamp(new Date().getTime()));
            model.addAttribute("endTime", new Timestamp(new Date().getTime()));
        }
        //设置通讯录
        userServiceV2.setUserVOListAllAndPage(model, page, size);
        model.addAttribute("url", "names");
        model.addAttribute("types", typePOList);
        model.addAttribute("statuses", statusPOList);

        return "daymanage/editday";
    }


    /**
     * 日程管理的增加修改接收
     *
     * @param scheduleListVO 日程的信息
     * @param shareUser      增加或修改接收人
     * @param br
     * @param userId         用户ID
     * @return
     */
    @RequestMapping("addandchangeday")
    public String addAndChangeDay(ScheduleListVO scheduleListVO, @RequestParam("shareuser") String shareUser, BindingResult br,
                                  @SessionAttribute("userId") Long userId) {
        //插入或更新日程表
        SchedulePO schedulePO = scheduleListPOServiceV2.insertOrUpdateSchedulePO(scheduleListVO, userId);
        //因为日程的接收人可能该变，因此先根据日程id删除日程用户关联表信息，在根据新的日程接收人重新插入
        scheduleUserPOServiceV2.deleteScheduleUserPO(schedulePO.getRcId());
        List<Long> UserIds = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(shareUser, ";");//分割接收人
        while (st.hasMoreElements()) {
            UserIds.add(userPOServiceV2.getUserPOByUsername(st.nextToken()).getUserId());
        }
        if (UserIds.size() > 0) {
            for (Long userIds : UserIds) {
                scheduleUserPOServiceV2.insertScheduleUserPO(schedulePO.getRcId(), userIds);
            }
        }
        return "/daymanage";
    }

    /**
     * 日程管理中的删除
     *
     * @param rcId 日程ID
     * @return
     */
    @RequestMapping("dayremove")
    public String dayRemove(@RequestParam(value = "rcId") Long rcId) {
        scheduleListPOServiceV2.deleteSchedulePO(rcId);
        return "/daymanage";
    }

    /**
     * 我的日历
     *
     * @return
     */
    @RequestMapping("daycalendar")
    private String dayCalendar() {
        return "daymanage/daycalendar";
    }

    /**
     * @param userId 用户ID
     * @return
     * @throws IOException
     */
    @RequestMapping("mycalendarload")
    @ResponseBody
    public List<ScheduleListVO> myCalendarLoad(@SessionAttribute("userId") Long userId) {
        List<ScheduleListVO> scheduleListVOS = scheduleServiceV2.scheduleListVOS(userId);
        return scheduleListVOS;
    }

}
