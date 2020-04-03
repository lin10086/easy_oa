package cn.gson.oasys.controller.daymanage;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import cn.gson.oasys.serviceV2.deptV2.DeptPOServiceV2;
import cn.gson.oasys.serviceV2.scheduleV2.ScheduleListServiceV2;
import cn.gson.oasys.serviceV2.scheduleV2.ScheduleServiceV2;
import cn.gson.oasys.serviceV2.scheduleV2.ScheduleUserServiceV2;
import cn.gson.oasys.modelV2.po.SchedulePO;
import cn.gson.oasys.modelV2.po.StatusPO;
import cn.gson.oasys.modelV2.po.TypePO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.voandfactory.userVO2.UserVO;
import cn.gson.oasys.voandfactory.scheduleVO2.ScheduleListVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import cn.gson.oasys.model.dao.daymanagedao.DaymanageDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.schedule.ScheduleList;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.daymanage.DaymanageServices;
import cn.gson.oasys.services.process.ProcessService;

@Controller
@RequestMapping("/")
public class DaymanageController {
    @Autowired
    DaymanageDao daydao;
    @Autowired
    UserDao udao;
    @Autowired
    DaymanageServices dayser;
    @Autowired
    StatusDao statusdao;
    @Autowired
    TypeDao typedao;
    @Autowired
    ProcessService ps;

    /*	@RequestMapping("daymanage")
        private String daymanage(@SessionAttribute("userId") Long userid,
                Model model,@RequestParam(value="page",defaultValue="0") int page,
                @RequestParam(value="size",defaultValue="10") int size
                ) {
            List<SystemTypeList> types = typedao.findByTypeModel("aoa_schedule_list");
            List<SystemStatusList> statuses = statusdao.findByStatusModel("aoa_schedule_list");
            List<Order> orders=new ArrayList<>();
            orders.add(new Order(Direction.DESC, "statusId"));
            orders.add(new Order(Direction.DESC, "createTime"));
            Sort sort=new Sort(orders);
            Pageable pa=new PageRequest(page, size,sort);
            User user = udao.findOne(userid);
            Page<ScheduleList> myday = daydao.findByUser(user, pa);

            List<ScheduleList> scheduleLists = myday.getContent();

            model.addAttribute("schedules",scheduleLists);
            model.addAttribute("types",types);
            model.addAttribute("statuses",statuses);
            model.addAttribute("page", myday);
            model.addAttribute("url", "daymanagepaging");
            model.addAttribute("ismyday", 1);
            return "daymanage/daymanage";
        }
        */
    @RequestMapping("daymanagepaging")
    private String daymanagepaging(@SessionAttribute("userId") Long userid,
                                   Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size) {
        List<SystemTypeList> types = typedao.findByTypeModel("aoa_schedule_list");
        List<SystemStatusList> statuses = statusdao.findByStatusModel("aoa_schedule_list");

        Sort sort = new Sort(new Order(Direction.ASC, "user"));
        Pageable pa = new PageRequest(page, size, sort);
        User user = udao.findOne(userid);
        Page<ScheduleList> myday = daydao.findByUser(user, pa);

        List<ScheduleList> scheduleLists = myday.getContent();
        model.addAttribute("types", types);
        model.addAttribute("statuses", statuses);
        model.addAttribute("schedules", scheduleLists);
        model.addAttribute("page", myday);
        model.addAttribute("url", "daymanagepaging");
        model.addAttribute("ismyday", 1);
        return "daymanage/daymanagepaging";
    }

    @RequestMapping("aboutmeday")
    private String aboutmeday(@SessionAttribute("userId") Long userid,
                              Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {

        List<SystemTypeList> types = typedao.findByTypeModel("aoa_schedule_list");
        List<SystemStatusList> statuses = statusdao.findByStatusModel("aoa_schedule_list");

        Sort sort = new Sort(new Order(Direction.ASC, "user"));
        Pageable pa = new PageRequest(page, size, sort);
        User user = udao.findOne(userid);
        List<User> users = new ArrayList<>();
        users.add(user);
        Page<ScheduleList> aboutmeday = daydao.findByUsers(users, pa);

        List<ScheduleList> scheduleLists = aboutmeday.getContent();

        model.addAttribute("schedules", scheduleLists);
        model.addAttribute("types", types);
        model.addAttribute("statuses", statuses);
        model.addAttribute("page", aboutmeday);
        model.addAttribute("url", "aboutmedaypaging");

        return "daymanage/daymanage";
    }

    @RequestMapping("aboutmedaypaging")
    public String aboutmedaypaging(@SessionAttribute("userId") Long userid,
                                   Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size) {
        List<SystemTypeList> types = typedao.findByTypeModel("aoa_schedule_list");
        List<SystemStatusList> statuses = statusdao.findByStatusModel("aoa_schedule_list");

        Sort sort = new Sort(new Order(Direction.ASC, "user"));
        Pageable pa = new PageRequest(page, size, sort);
        User user = udao.findOne(userid);
        List<User> users = new ArrayList<>();
        users.add(user);
        Page<ScheduleList> aboutmeday = daydao.findByUsers(users, pa);

        List<ScheduleList> scheduleLists = aboutmeday.getContent();

        model.addAttribute("schedules", scheduleLists);
        model.addAttribute("types", types);
        model.addAttribute("statuses", statuses);
        model.addAttribute("page", aboutmeday);
        model.addAttribute("url", "aboutmedaypaging");

        return "daymanage/daymanagepaging";
    }

   /* @RequestMapping("dayedit")
    private String dayedit(@RequestParam(value = "rcid", required = false) Long rcid,
                           @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size,
                           Model model
    ) {
        ps.user(page, size, model);
        List<SystemTypeList> types = typedao.findByTypeModel("aoa_schedule_list");
        List<SystemStatusList> statuses = statusdao.findByStatusModel("aoa_schedule_list");
        ScheduleList rc = null;
        if (rcid != null) {
            rc = daydao.findOne(rcid);
            System.out.println(rc);
        }

        model.addAttribute("types", types);
        model.addAttribute("statuses", statuses);
        model.addAttribute("rc", rc);
        return "daymanage/editday";
    }*/
/*

    @RequestMapping("addandchangeday")
    public String addandchangeday(ScheduleList scheduleList, @RequestParam("shareuser") String shareuser, BindingResult br,
                                  @SessionAttribute("userId") Long userid) {
        User user = udao.findOne(userid);
        System.out.println(shareuser);
        List<User> users = new ArrayList<>();

        System.out.println(users.size());
        StringTokenizer st = new StringTokenizer(shareuser, ";");

        while (st.hasMoreElements()) {
            users.add(udao.findByUserName(st.nextToken()));
        }

        scheduleList.setUser(user);
        if (users.size() > 0) {
            scheduleList.setUsers(users);
        }
        System.out.println(scheduleList);

        daydao.save(scheduleList);
        return "/daymanage";
    }
*/

   /* @RequestMapping("dayremove")
    public String dayremove(@RequestParam(value = "rcid") Long rcid) {
        ScheduleList rc = daydao.findOne(rcid);

        daydao.delete(rc);

        return "/daymanage";
    }*/

    /**
     * 一下是日历controller
     *
     * @return
     */
   /* @RequestMapping("daycalendar")
    private String daycalendar() {
        return "daymanage/daycalendar";
    }*/

//	@RequestMapping("mycalendarload")
//	public void mycalendarload(@SessionAttribute("userId") Long userid,HttpServletResponse response) throws IOException{
//		List<ScheduleList> se = dayser.aboutmeschedule(userid);
//		
//		for (ScheduleList scheduleList : se) {
//			System.out.println(scheduleList);
//		}
//		
//		String json = JSONObject.toJSONString(se);
//		response.setHeader("Cache-Control", "no-cache");
//		response.setContentType("text/json;charset=UTF-8");
//		response.getWriter().write(json);
//		
//	}
   /* @RequestMapping("mycalendarload")
    public @ResponseBody
    List<ScheduleList> mycalendarload(@SessionAttribute("userId") Long userid, HttpServletResponse response) throws IOException {
        List<ScheduleList> se = dayser.aboutmeschedule(userid);

        return se;
    }*/

    //==================================================

    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private DeptPOServiceV2 deptPOServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private ScheduleListServiceV2 scheduleListServiceV2;
    @Resource
    private ScheduleUserServiceV2 scheduleUserServiceV2;
    @Resource
    private ScheduleServiceV2 scheduleServiceV2;

    /**
     * 日程管理
     *
     * @param userId
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("daymanage")
    private String dayManage(@SessionAttribute("userId") Long userId,
                             Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);

        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_schedule_list");
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_schedule_list");

        PageHelper.startPage(page, size);
        List<SchedulePO> schedulePOList = scheduleListServiceV2.getSchedulePOListByUserId(userId);
        String deptName = deptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId()).getDeptName();
        PageInfo pageInfo = new PageInfo(schedulePOList);

        model.addAttribute("types", typePOList);//日程类型
        model.addAttribute("statuses", statusPOList);//日程状态
        model.addAttribute("username", userPO.getUserName());//用户名
        model.addAttribute("deptName", deptName);//部门名
        model.addAttribute("schedules", schedulePOList);//日程
        model.addAttribute("page", pageInfo);//分页信息
        model.addAttribute("url", "daymanagepaging");
        model.addAttribute("ismyday", 1);//
        return "daymanage/daymanage";
    }

    /**
     * 日程管理的增加，修改
     *
     * @param rcId
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping("dayedit")
    private String dayEdit(@RequestParam(value = "rcId", required = false) Long rcId,
                           @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size,
                           Model model) {
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_schedule_list");
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_schedule_list");

        if (rcId != null) {
            SchedulePO schedulePO = scheduleListServiceV2.getSchedulePOBySchedulePOId(rcId);
            model.addAttribute("startTime", new Timestamp(schedulePO.getStartTime().getTime()));
            model.addAttribute("endTime", new Timestamp(schedulePO.getEndTime().getTime()));
            model.addAttribute("isRemind", schedulePO.getIsRemind() == 0 ? false : true);
            model.addAttribute("rc", schedulePO);
        } else {
            model.addAttribute("startTime", new Timestamp(new Date().getTime()));
            model.addAttribute("endTime", new Timestamp(new Date().getTime()));
        }

        PageHelper.startPage(page, size);
//        List<UserVO> userVOList = userVOListServiceV2.setUserVOList();//获取通讯录信息
//        PageInfo pageInfo = new PageInfo(userVOList);
//        model.addAttribute("page", pageInfo);
//        model.addAttribute("userVOList", userVOList);
        model.addAttribute("url", "names");

        model.addAttribute("types", typePOList);
        model.addAttribute("statuses", statusPOList);

        return "daymanage/editday";
    }


    /**
     * 日程管理的增加修改接收
     *
     * @param scheduleListVO
     * @param shareuser      增加或修改接收人
     * @param br
     * @param userId
     * @return
     */
    @RequestMapping("addandchangeday")
    public String addandchangeday(ScheduleListVO scheduleListVO, @RequestParam("shareuser") String shareuser, BindingResult br,
                                  @SessionAttribute("userId") Long userId) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);//登录人
        SchedulePO schedulePO = scheduleListServiceV2.insertOrUpdateSchedulePO(scheduleListVO, userId);//插入或更新日程表
        scheduleUserServiceV2.deleteScheduleUserPO(schedulePO.getRcId());//根据日程id删除日程用户关联表信息
        List<Long> UserIds = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(shareuser, ";");//分割接收人
        while (st.hasMoreElements()) {
            UserIds.add(userPOServiceV2.getUserPOByUsername(st.nextToken()).getUserId());
        }
        if (UserIds.size() > 0) {
            for (Long userIds : UserIds) {
                scheduleUserServiceV2.insertScheduleUserPO(schedulePO.getRcId(), userIds);
            }
        }
        return "/daymanage";
    }

    /**
     * 日程管理中的删除
     *
     * @param rcId
     * @return
     */
    @RequestMapping("dayremove")
    public String dayRemove(@RequestParam(value = "rcId") Long rcId) {
        scheduleListServiceV2.deleteSchedulePO(rcId);
        return "/daymanage";
    }

    /**
     * 日程管理》我的日历
     *
     * @return
     */
    @RequestMapping("daycalendar")
    private String dayCalendar() {
        return "daymanage/daycalendar";
    }

    /**
     *
     * @param userId
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("mycalendarload")
    public @ResponseBody
    List<ScheduleListVO> mycalendarload(@SessionAttribute("userId") Long userId, HttpServletResponse response) throws IOException {
        List<ScheduleListVO>scheduleListVOS = scheduleServiceV2.scheduleListVOS(userId);
        return scheduleListVOS;
    }

}
