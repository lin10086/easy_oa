package cn.gson.oasys.controller.task;

import java.sql.Timestamp;
import java.text.ParseException;


import java.util.Date;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.*;
import cn.gson.oasys.ServiceV2.taskV2.TaskListServiceV2;
import cn.gson.oasys.ServiceV2.taskV2.TaskLoggerServiceV2;
import cn.gson.oasys.ServiceV2.taskV2.TaskServiceV2;
import cn.gson.oasys.ServiceV2.taskV2.TaskUserServiceV2;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.factoryvo.taskFactory.TaskLoggerFactoryVO;
import cn.gson.oasys.vo.mailVO2.MailNumberVO;
import cn.gson.oasys.vo.taskVO2.TaskListVO;
import cn.gson.oasys.vo.taskVO2.TaskLoggerVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;

import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.taskdao.TaskDao;
import cn.gson.oasys.model.dao.taskdao.TaskloggerDao;
import cn.gson.oasys.model.dao.taskdao.TaskuserDao;
import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.task.Tasklist;
import cn.gson.oasys.model.entity.task.Tasklogger;
import cn.gson.oasys.model.entity.task.Taskuser;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.task.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskDao tdao;
    @Autowired
    private StatusDao sdao;
    @Autowired
    private TypeDao tydao;
    @Autowired
    private UserDao udao;
    @Autowired
    private DeptDao ddao;
    @Autowired
    private TaskuserDao tudao;
    @Autowired
    private TaskService tservice;
    @Autowired
    private TaskloggerDao tldao;
    @Autowired
    private PositionDao pdao;
    /**
     * 任务管理表格
     *
     * @return
     */
/*	@RequestMapping("taskmanage")
	public String index(Model model,
			@SessionAttribute("userId") Long userId,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		// 通过发布人id找用户
		User tu = udao.findOne(userId);
		// 根据发布人id查询任务
		Page<Tasklist> tasklist=tservice.index(page, size, null, tu);
		List<Map<String, Object>> list=tservice.index2(tasklist, tu);
		model.addAttribute("mapList", list);
		model.addAttribute("page", tasklist);
		model.addAttribute("url", "paixu");
		return "task/taskmanage";
	}
*/

    /*   *//**
     * 各种排序
     *//*
    @RequestMapping("paixu")
    public String paixu(HttpServletRequest request,
                        @SessionAttribute("userId") Long userId, Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {

        // 通过发布人id找用户
        User tu = udao.findOne(userId);
        String val = null;
        if (!StringUtil.isEmpty(request.getParameter("val"))) {
            val = request.getParameter("val").trim();
            model.addAttribute("sort", "&val=" + val);
        }

        Page<Tasklist> tasklist = tservice.index(page, size, val, tu);
        List<Map<String, Object>> list = tservice.index2(tasklist, tu);
        model.addAttribute("tasklist", list);
        model.addAttribute("page", tasklist);
        model.addAttribute("url", "paixu");

        return "task/managetable";

    }
*/

    /* *//**
     * 点击新增任务
     *//*
    @RequestMapping("addtask")
    public ModelAndView index2(@SessionAttribute("userId") Long userId,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(page, size);
        ModelAndView mav = new ModelAndView("task/addtask");
        // 查询类型表
        Iterable<SystemTypeList> typelist = tydao.findAll();
        // 查询状态表
        Iterable<SystemStatusList> statuslist = sdao.findAll();
        // 查询部门下面的员工
        Page<User> pagelist = udao.findByFatherId(userId, pa);
        List<User> emplist = pagelist.getContent();
        // 查询部门表
        Iterable<Dept> deptlist = ddao.findAll();
        // 查职位表
        Iterable<Position> poslist = pdao.findAll();
        mav.addObject("typelist", typelist);
        mav.addObject("statuslist", statuslist);
        mav.addObject("emplist", emplist);
        mav.addObject("deptlist", deptlist);
        mav.addObject("poslist", poslist);
        mav.addObject("page", pagelist);
        mav.addObject("url", "names");
        mav.addObject("qufen", "任务");
        return mav;
    }*/

    /**
     * 新增任务保存
     */
  /*  @RequestMapping("addtasks")
    public String addtask(@SessionAttribute("userId") Long userId, HttpServletRequest request) {
        User userlist = udao.findOne(userId);
        Tasklist list = (Tasklist) request.getAttribute("tasklist");
        request.getAttribute("success");
        list.setUsersId(userlist);
        list.setPublishTime(new Date());
        list.setModifyTime(new Date());
        tdao.save(list);
        // 分割任务接收人
        StringTokenizer st = new StringTokenizer(list.getReciverlist(), ";");
        while (st.hasMoreElements()) {
            User reciver = udao.findid(st.nextToken());
            Taskuser task = new Taskuser();
            task.setTaskId(list);
            task.setUserId(reciver);
            task.setStatusId(list.getStatusId());
            // 存任务中间表
            tudao.save(task);

        }

        return "redirect:/taskmanage";
    }*/

    /* *//**
     * 修改任务
     *//*
    @RequestMapping("edittasks")
    public ModelAndView index3(HttpServletRequest req, @SessionAttribute("userId") Long userId,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(page, size);
        ModelAndView mav = new ModelAndView("task/edittask");
        // 得到链接中的任务id
        String taskid = req.getParameter("id");
        Long ltaskid = Long.parseLong(taskid);
        // 通过任务id得到相应的任务
        Tasklist task = tdao.findOne(ltaskid);
        // 得到状态id
        Long statusid = task.getStatusId().longValue();
        // 得到类型id
        Long typeid = task.getTypeId();
        // 查看状态表
        SystemStatusList status = sdao.findOne(statusid);
        // 查询类型表
        SystemTypeList type = tydao.findOne(typeid);

        // 查询部门下面的员工
        Page<User> pagelist = udao.findByFatherId(userId, pa);
        List<User> emplist = pagelist.getContent();

        // 查询部门表
        Iterable<Dept> deptlist = ddao.findAll();
        // 查职位表
        Iterable<Position> poslist = pdao.findAll();
        mav.addObject("type", type);
        mav.addObject("status", status);
        mav.addObject("emplist", emplist);
        mav.addObject("deptlist", deptlist);
        mav.addObject("poslist", poslist);
        mav.addObject("task", task);
        mav.addObject("page", pagelist);
        mav.addObject("url", "names");
        mav.addObject("qufen", "任务");
        return mav;
    }

    *//**
     * 修改任务确定
     *//*
    @RequestMapping("update")
    public String update(Tasklist task, HttpSession session) {
        String userId = ((String) session.getAttribute("userId")).trim();
        Long userid = Long.parseLong(userId);
        User userlist = udao.findOne(userid);
        task.setUsersId(userlist);
        task.setPublishTime(new Date());
        task.setModifyTime(new Date());
        tservice.save(task);
        // 分割任务接收人 还要查找联系人的主键
        StringTokenizer st = new StringTokenizer(task.getReciverlist(), ";");
        while (st.hasMoreElements()) {
            User reciver = udao.findid(st.nextToken());
            Long pkid = udao.findpkId(task.getTaskId(), reciver.getUserId());
            Taskuser tasku = new Taskuser();
            tasku.setPkId(pkid);
            tasku.setTaskId(task);
            tasku.setUserId(reciver);
            tasku.setStatusId(task.getStatusId());
            // 存任务中间表
            tudao.save(tasku);
        }
        return "redirect:/taskmanage";
    }
*/

    /* *//**
     * 查看任务
     *//*
    @RequestMapping("seetasks")
    public ModelAndView index4(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("task/seetask");
        // 得到任务的 id
        String taskid = req.getParameter("id");
        Long ltaskid = Long.parseLong(taskid);
        // 通过任务id得到相应的任务
        Tasklist task = tdao.findOne(ltaskid);
        Long statusid = task.getStatusId().longValue();

        // 根据状态id查看状态表
        SystemStatusList status = sdao.findOne(statusid);
        // 查看状态表
        Iterable<SystemStatusList> statuslist = sdao.findAll();
        // 查看发布人
        User user = udao.findOne(task.getUsersId().getUserId());
        // 查看任务日志表
        List<Tasklogger> logger = tldao.findByTaskId(ltaskid);
        mav.addObject("task", task);
        mav.addObject("user", user);
        mav.addObject("status", status);
        mav.addObject("loggerlist", logger);
        mav.addObject("statuslist", statuslist);
        return mav;
    }
*/
    /**
     * 存反馈日志
     *
     * @return
     */
   /* @RequestMapping("tasklogger")
    public String tasklogger(Tasklogger logger, @SessionAttribute("userId") Long userId) {
        User userlist = udao.findOne(userId);
        logger.setCreateTime(new Date());
        logger.setUsername(userlist.getUserName());
        // 存日志
        tldao.save(logger);
        // 修改任务状态
        tservice.updateStatusid(logger.getTaskId().getTaskId(), logger.getLoggerStatusid());
        // 修改任务中间表状态
        tservice.updateUStatusid(logger.getTaskId().getTaskId(), logger.getLoggerStatusid());

        return "redirect:/taskmanage";

    }*/
//---------------------------------------------------------

    /* *//**
     * 我的任务
     *//*
    @RequestMapping("mytask")
    public String index5(@SessionAttribute("userId") Long userId, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(page, size);
        Page<Tasklist> tasklist = tservice.index3(userId, null, page, size);

        Page<Tasklist> tasklist2 = tdao.findByTickingIsNotNull(pa);
        if (tasklist != null) {
            List<Map<String, Object>> list = tservice.index4(tasklist, userId);
            model.addAttribute("page", tasklist);
            model.addAttribute("tasklist", list);
        } else {
            List<Map<String, Object>> list2 = tservice.index4(tasklist2, userId);
            model.addAttribute("page", tasklist2);
            model.addAttribute("tasklist", list2);
        }
        model.addAttribute("url", "mychaxun");
        return "task/mytask";
    }
*/

    /*  *//**
     * 在我的任务里面进行查询
     *
     * @throws ParseException
     *//*
    @RequestMapping("mychaxun")
    public String select(HttpServletRequest request, @SessionAttribute("userId") Long userId, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) throws ParseException {

        String title = null;
        if (!StringUtil.isEmpty(request.getParameter("title"))) {
            title = request.getParameter("title").trim();
        }
        Page<Tasklist> tasklist = tservice.index3(userId, title, page, size);
        List<Map<String, Object>> list = tservice.index4(tasklist, userId);
        model.addAttribute("tasklist", list);
        model.addAttribute("page", tasklist);
        model.addAttribute("url", "mychaxun");
        model.addAttribute("sort", "&title=" + title);
        return "task/mytasklist";
    }
*/

    /**
     * 我任务里面的查看
     *
     * @param req
     * @param userId
     * @return
     *//*
    @RequestMapping("myseetasks")
    public ModelAndView myseetask(HttpServletRequest req, @SessionAttribute("userId") Long userId) {

        ModelAndView mav = new ModelAndView("task/myseetask");
        // 得到任务的 id
        String taskid = req.getParameter("id");

        Long ltaskid = Long.parseLong(taskid);
        // 通过任务id得到相应的任务
        Tasklist task = tdao.findOne(ltaskid);

        // 查看状态表
        Iterable<SystemStatusList> statuslist = sdao.findAll();
        // 查询接收人的任务状态
        Long ustatus = tudao.findByuserIdAndTaskId(userId, ltaskid);

        SystemStatusList status = sdao.findOne(ustatus);
        *//*System.out.println(status);*//*
        // 查看发布人
        User user = udao.findOne(task.getUsersId().getUserId());
        // 查看任务日志表
        List<Tasklogger> logger = tldao.findByTaskId(ltaskid);
        mav.addObject("task", task);
        mav.addObject("user", user);
        mav.addObject("status", status);
        mav.addObject("statuslist", statuslist);
        mav.addObject("loggerlist", logger);
        return mav;

    }*/

    /* *//**
     * 从我的任务查看里面修改状态和日志
     *//*
    @RequestMapping("uplogger")
    public String updatelo(Tasklogger logger, @SessionAttribute("userId") Long userId) {
        System.out.println(logger.getLoggerStatusid());
        // 获取用户id
        // 查找用户
        User user = udao.findOne(userId);
        // 查任务
        Tasklist task = tdao.findOne(logger.getTaskId().getTaskId());
        logger.setCreateTime(new Date());
        logger.setUsername(user.getUserName());
        // 存日志
        tldao.save(logger);
        // 修改任务中间表状态
        Long pkid = udao.findpkId(logger.getTaskId().getTaskId(), userId);
        Taskuser tasku = new Taskuser();
        tasku.setPkId(pkid);
        tasku.setTaskId(task);
        tasku.setUserId(user);
        if (!Objects.isNull(logger.getLoggerStatusid())) {
            tasku.setStatusId(logger.getLoggerStatusid());
        }
        // 存任务中间表
        tudao.save(tasku);
        // 修改任务状态
        // 通过任务id查看总状态
        List<Integer> statu = tudao.findByTaskId(logger.getTaskId().getTaskId());
        System.out.println(statu);
        // 选出最小的状态id 修改任务表里面的状态
        Integer min = statu.get(0);
        for (Integer integer : statu) {
            if (integer.intValue() < min) {
                min = integer;
            }
        }
        int up = tservice.updateStatusid(logger.getTaskId().getTaskId(), min);
		*//*System.out.println(logger.getTaskId().getTaskId() + "aaaa");
		System.out.println(min + "wwww");
		System.out.println(up + "pppppp");*//*
        if (up > 0) {
            System.out.println("任务状态修改成功!");
        }
        return "redirect:/mytask";
    }*/
    /*

     */
/**
 * 根据发布人这边删除任务和相关联系
 *
 * @param req
 * @return
 *//*

    @RequestMapping("shanchu")
    public String delete(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        // 得到任务的 id
        String taskid = req.getParameter("id");
        Long ltaskid = Long.parseLong(taskid);
        // 根据任务id找出这条任务
        Tasklist task = tdao.findOne(ltaskid);
        if (task.getUsersId().getUserId().equals(userId)) {
            // 删除日志表
            int i = tservice.detelelogger(ltaskid);
            System.out.println(i + "mmmmmmmmmmmm");
            // 分割任务接收人 还要查找联系人的主键并删除接收人中间表
            StringTokenizer st = new StringTokenizer(task.getReciverlist(), ";");
            while (st.hasMoreElements()) {
                User reciver = udao.findid(st.nextToken());
                Long pkid = udao.findpkId(task.getTaskId(), reciver.getUserId());
                int m = tservice.delete(pkid);
                System.out.println(m + "sssssssssss");
            }
            // 删除这条任务
            tservice.deteletask(task);
        } else {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        return "redirect:/taskmanage";
    }
*/

    /**
     * 接收人这边删除
     */
  /*  @RequestMapping("myshanchu")
    public String mydelete(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        // 用户id
        // 得到任务的 id
        String taskid = req.getParameter("id");
        Long ltaskid = Long.parseLong(taskid);
        Long pkid = udao.findpkId(ltaskid, userId);
        tservice.delete(pkid);
        return "redirect:/mytask";
    }
*/

    //================================================
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TaskServiceV2 taskServiceV2;
    @Resource
    private TaskUserServiceV2 taskUserServiceV2;
    @Resource
    private TaskListServiceV2 taskListServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private PositionServiceV2 positionServiceV2;
    @Resource
    private UserVOListServiceV2 userVOListServiceV2;
    @Resource
    private TaskLoggerServiceV2 taskLoggerServiceV2;

    /**
     * 任务管理主页面
     *
     * @return
     */
    @RequestMapping("taskmanage")
    public String index(Model model,
                        @SessionAttribute("userId") Long userId,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        //根据发布人ID找任务
        List<TaskListPO> taskListPOList = taskServiceV2.selectTackListPO(page, size, null, userId);
        PageInfo pageInfo = new PageInfo(taskListPOList);
        List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPO(taskListPOList, userId);
        model.addAttribute("taskListPOList", taskListPOList);
        model.addAttribute("mapList", mapList);
        model.addAttribute("page", pageInfo);
        model.addAttribute("url", "paixu");
        return "task/taskmanage";
    }

    /**
     * 任务管理中各种排序
     */
    @RequestMapping("paixu")
    public String paixu(HttpServletRequest request,
                        @SessionAttribute("userId") Long userId, Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        String val = null;
        if (!StringUtil.isEmpty(request.getParameter("val"))) {
            val = request.getParameter("val").trim();
            model.addAttribute("sort", "&val=" + val);
        }
        List<TaskListPO> taskListPOList = taskServiceV2.selectTackListPO(page, size, val, userId);
        PageInfo pageInfo = new PageInfo(taskListPOList);
        List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPO(taskListPOList, userId);


        model.addAttribute("mapList", mapList);
        model.addAttribute("page", pageInfo);
        model.addAttribute("url", "paixu");

        return "task/managetable";

    }


    /**
     * 点击新增任务
     */
    @RequestMapping("addtask")
    public ModelAndView index2(@SessionAttribute("userId") Long userId,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "10") int size) {
        ModelAndView mav = new ModelAndView("task/addtask");
        List<TypePO> typePOList = typeServiceV2.getTypePOListAll();// 所有类型信息
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOListAll();//所有状态信息
        List<UserPO> userPOList = userServiceV2.getUserPOListByFatherId(userId);// 获取下属用户
        List<DeptPO> deptPOList = deptServiceV2.getDeptPOListAll();//所有部门信息
        List<PositionPO> positionPOList = positionServiceV2.getPositionListAll();//获取所有职位信息

        PageHelper.startPage(page, size);
        List<UserVO> userVOList = userVOListServiceV2.setUserVOList();//获取通讯录信息
        PageInfo pageInfo = new PageInfo(userVOList);
        mav.addObject("page", pageInfo);
        mav.addObject("userVOList", userVOList);

        mav.addObject("typelist", typePOList);
        mav.addObject("statuslist", statusPOList);
        mav.addObject("emplist", userPOList);
        mav.addObject("deptlist", deptPOList);
        mav.addObject("poslist", positionPOList);
        mav.addObject("url", "names");
        mav.addObject("qufen", "任务");
        return mav;
    }

    /**
     * 新增任务保存
     */
//    @RequestMapping("addtasks")
//    public String addtask(@SessionAttribute("userId") Long userId, HttpServletRequest request) {
////        TaskListPO taskListPO = (TaskListPO) request.getAttribute("taskListPOList");
////        List<Map<String, Object>> mapList= (List)request.getAttribute("tasklist");
//        TaskListVO taskListVO = (TaskListVO) request.getAttribute("tasklist");
//        request.getAttribute("success");
//        TaskListPO taskListPO = taskServiceV2.insertOrUpdateTaskListPO(taskListVO, userId);
//        // 分割任务接收人
//        StringTokenizer st = new StringTokenizer(taskListVO.getReciverlist(), ";");
//        while (st.hasMoreElements()) {
//            UserPO receiverUserPO = userServiceV2.getUserPOByUsername(st.nextToken());
//            taskUserServiceV2.insertTaskUserPO(taskListPO, receiverUserPO);
//        }
//        return "redirect:/taskmanage";
//    }


    /**
     * 保存增加的任务
     *
     * @param userId
     * @param taskListVO
     * @param br
     * @param request
     * @return
     */
//    @RequestMapping("addtasks")
    @RequestMapping("ck_addtask")
    public String addtask(@SessionAttribute("userId") Long userId, @Valid TaskListVO taskListVO, BindingResult br, HttpServletRequest request) {
        request.getAttribute("success");
        TaskListPO taskListPO = taskServiceV2.insertOrUpdateTaskListPO(taskListVO, userId);//插入任务表
        taskLoggerServiceV2.insertTaskLoggerPO(taskListPO);
        // 分割任务接收人
        StringTokenizer st = new StringTokenizer(taskListVO.getReciverlist(), ";");
        while (st.hasMoreElements()) {
            UserPO receiverUserPO = userServiceV2.getUserPOByUsername(st.nextToken());
            taskUserServiceV2.insertTaskUserPO(taskListPO, receiverUserPO);
        }
        return "redirect:/taskmanage";
    }

    /**
     * 修改任务
     */
    @RequestMapping("edittasks")
    public ModelAndView index3(HttpServletRequest req, @SessionAttribute("userId") Long userId,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(page, size);
        ModelAndView mav = new ModelAndView("task/edittask");
        // 得到链接中的任务id
        Long taskId = Long.parseLong(req.getParameter("id"));
        // 通过任务id得到相应的任务
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);
//        Tasklist task = tdao.findOne(ltaskid);
        // 得到状态id
        Long statusId = taskListPO.getStatusId().longValue();
        // 得到类型id
        Long typeId = taskListPO.getTypeId();
        // 查看状态表
        StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(statusId);
//        SystemStatusList status = sdao.findOne(statusid);
        // 查询类型表
        TypePO typePO = typeServiceV2.getTypePOByTypeId(typeId);
//        SystemTypeList type = tydao.findOne(typeid);
        // 查询部门下面的员工
//        List<UserPO> userPOList = userServiceV2.getUserPOListByFatherId(userId);
//        Page<User> pagelist = udao.findByFatherId(userId, pa);
//        List<User> emplist = pagelist.getContent();
        PageHelper.startPage(page, size);
        List<UserVO> userVOList = userVOListServiceV2.setUserVOList();//获取通讯录信息
        PageInfo pageInfo = new PageInfo(userVOList);

        // 查询部门表
        Iterable<Dept> deptlist = ddao.findAll();
        // 查职位表
        Iterable<Position> poslist = pdao.findAll();
        mav.addObject("type", typePO);
        mav.addObject("status", statusPO);
//        mav.addObject("emplist", userPOList);
        mav.addObject("userVOList", userVOList);
//        mav.addObject("deptlist", deptlist);
        mav.addObject("task", taskListPO);
        mav.addObject("taskIsTop", taskListPO.getIsTop() == 0 ? false : true);
        mav.addObject("taskIsCancel", taskListPO.getIsCancel() == 0 ? false : true);
        mav.addObject("taskStarTime", new Timestamp(taskListPO.getStarTime().getTime()));
        mav.addObject("taskEndTime", new Timestamp(taskListPO.getEndTime().getTime()));
        mav.addObject("page", pageInfo);
        mav.addObject("url", "names");
        mav.addObject("qufen", "任务");
        return mav;
    }

    /**
     * 修改任务确定
     */
    @RequestMapping("update")
    public String update(TaskListVO taskListVO, HttpSession session) {
        Long userId = ((Long) session.getAttribute("userId"));
//        Long userId = Long.parseLong(userIdString);
        TaskListPO taskListPO = taskServiceV2.insertOrUpdateTaskListPO(taskListVO, userId);
        // 因为可能修改接收人所以先删除以前接收这个任务的用户在重新插入接收这个任务的新用户
        taskUserServiceV2.deleteTaskUserPOByTaskListPOId(taskListVO.getTaskId());

        StringTokenizer st = new StringTokenizer(taskListVO.getReciverlist(), ";");
        while (st.hasMoreElements()) {
            UserPO receiverUserPO = userServiceV2.getUserPOByUsername(st.nextToken());
            taskUserServiceV2.insertTaskUserPO(taskListPO, receiverUserPO);
        }

        return "redirect:/taskmanage";
    }

    /**
     * 查看任务
     */
    @RequestMapping("seetasks")
    public ModelAndView seeTask(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("task/seetask");
        // 得到任务的 id
        Long taskId = Long.parseLong(req.getParameter("id"));

        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);// 通过任务id得到相应的任务
        Long statusId = taskListPO.getStatusId().longValue();//任务表里面的状态ID
        StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(statusId);//根据任务表里的状态ID获取状态信息
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOListAll();//获取所有的状态信息
        UserPO pushUserPO = userServiceV2.getUserPOByUserId(taskListPO.getTaskPushUserId());//发布人
        List<TaskLoggerPO> taskLoggerPOList = taskLoggerServiceV2.getTaskLoggerPOByTaskListPOId(taskId);//根据任务ID获取日志列表
        List<TaskLoggerVO> taskLoggerVOList = null;
        if (taskLoggerPOList != null) {
            taskLoggerVOList = TaskLoggerFactoryVO.createTaskLoggerVOList(taskLoggerPOList);
//            for (TaskLoggerVO taskLoggerVO : taskLoggerVOList) {
////                taskLoggerVO.setUsername();
//                taskLoggerVO.setCreateTime(new Timestamp(taskListPO.getPublishTime().getTime()));
//            }
        }
        mav.addObject("task", taskListPO);//任务信息
        mav.addObject("taskStarTime", new Timestamp(taskListPO.getStarTime().getTime()));//任务开始时间
        mav.addObject("taskEndTime", new Timestamp(taskListPO.getEndTime().getTime()));//任务结束时间
        mav.addObject("taskPushTime", new Timestamp(taskListPO.getPublishTime().getTime()));//任务发布时间
        mav.addObject("user", pushUserPO);//任务发布人
        mav.addObject("status", statusPO);//任务的状态信息
        mav.addObject("loggerlist", taskLoggerVOList);//任务的日志信息
        mav.addObject("statuslist", statusPOList);//所有的状态信息
        return mav;
    }


    /**
     * 任务管理中的查看 存反馈日志
     *
     * @return
     */
    @RequestMapping("tasklogger")
    public String tasklogger(TaskLoggerVO taskLoggerVO, @SessionAttribute("userId") Long userId, HttpServletRequest req) {
        Long taskId = Long.parseLong(req.getParameter("taskId"));// 得到任务的 id
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);

        taskLoggerServiceV2.insertTaskLoggerPO(taskLoggerVO, userPO, taskId);//更新任务日志
        // 修改任务状态
        taskServiceV2.updateTaskListPOStatus(taskId, taskLoggerVO.getLoggerStatusId().longValue());
        // 修改任务中间表状态
        taskServiceV2.updateTaskListUserPOStatus(taskId, taskLoggerVO.getLoggerStatusId().longValue());
//        tservice.updateUStatusid(logger.getTaskId().getTaskId(), logger.getLoggerStatusid());
        return "redirect:/taskmanage";
    }


    /**
     * 根据发布人这边删除任务和相关联系
     *
     * @param req
     * @return
     */
    @RequestMapping("shanchu")
    public String delete(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        // 得到任务的 id
        Long taskId = Long.parseLong(req.getParameter("id"));
        // 根据任务id找出这条任务
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);
        if (taskListPO.getTaskPushUserId().equals(userId)) {
            taskLoggerServiceV2.deleteTaskLoggerPOByTaskId(taskId);
            StringTokenizer st = new StringTokenizer(taskListPO.getReciverlist(), ";");
            while (st.hasMoreElements()) {
                UserPO receverUserPO = userServiceV2.getUserPOByUsername(st.nextToken());
                taskUserServiceV2.deleteTaskUserPOByTaskListPOIdAndUserId(taskId, receverUserPO.getUserId());
            }
            taskServiceV2.deleteTaskListPOByTaskId(taskId);
        } else {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        return "redirect:/taskmanage";
    }

//---------------------------

    /**
     * 我的任务
     */
    @RequestMapping("mytask")
    public String myTasks(@SessionAttribute("userId") Long userId, Model model,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<TaskListPO> taskListPOList = taskServiceV2.sortTaskListPO(userId, null, page, size);
        PageInfo pageInfo = new PageInfo(taskListPOList);

        if (taskListPOList != null) {
            List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPOList(taskListPOList, userId);
            model.addAttribute("page", pageInfo);
            model.addAttribute("tasklist", mapList);
        } else {
            PageHelper.startPage(page, size);
            List<TaskListPO> taskListPOList2 = taskListServiceV2.getTaskListPOByTickingIsNotNull();
            PageInfo pageInfo2 = new PageInfo(taskListPOList2);
            List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPOList(taskListPOList2, userId);
            model.addAttribute("page", pageInfo2);
            model.addAttribute("tasklist", mapList);
        }
        model.addAttribute("url", "mychaxun");
        return "task/mytask";
    }


    /**
     * 接收人这边删除(我的任务）
     */
    @RequestMapping("myshanchu")
    public String mydelete(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        Long taskId = Long.parseLong(req.getParameter("taskId"));// 得到任务的 id
        Long pkId = taskUserServiceV2.getPkIdByUserIdAndTaskListId(userId, taskId);
        taskUserServiceV2.deleteTaskUserPOByPkId(pkId);
        return "redirect:/mytask";
    }

    /**
     * 我任务里面的查看
     *
     * @param req
     * @param userId
     * @return
     */
    @RequestMapping("myseetasks")
    public ModelAndView mySeeTask(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        ModelAndView mav = new ModelAndView("task/myseetask");
        Long taskId = Long.parseLong(req.getParameter("taskId"));// 得到任务的 id
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);// 通过任务id得到相应的任务
        Long statusId = taskListPO.getStatusId().longValue();// 任务表里的状态ID
        StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(statusId);//根据任务表里的状态ID获取状态信息
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOListAll();//获取所有的状态信息
        UserPO userPO = userServiceV2.getUserPOByUserId(taskListPO.getTaskPushUserId());//发布人
        List<TaskLoggerPO> taskLoggerPOList = taskLoggerServiceV2.getTaskLoggerPOByTaskListPOId(taskId);//根据任务ID找任务日志
        List<TaskLoggerVO> taskLoggerVOList = TaskLoggerFactoryVO.createTaskLoggerVOList(taskLoggerPOList);//
        for (TaskLoggerVO taskLoggerVO : taskLoggerVOList) {
            taskLoggerVO.setUsername(userServiceV2.getUserPOByUserId(userId).getUserName());
            taskLoggerVO.setCreateTime(new Timestamp(new Date().getTime()));
        }
        mav.addObject("task", taskListPO);
        mav.addObject("taskStarTime", new Timestamp(taskListPO.getStarTime().getTime()));
        mav.addObject("taskEndTime", new Timestamp(taskListPO.getEndTime().getTime()));
        mav.addObject("taskPushTime", new Timestamp(taskListPO.getPublishTime().getTime()));
        mav.addObject("user", userPO);
        mav.addObject("status", statusPO);
        mav.addObject("loggerlist", taskLoggerVOList);
        mav.addObject("statuslist", statusPOList);
        return mav;
    }

    /**
     * 从我的任务查看里面修改状态和日志
     */
    @RequestMapping("uplogger")
    public String updatelo(TaskLoggerVO taskLoggerVO, @SessionAttribute("userId") Long userId, HttpServletRequest req) {
        Long taskId = Long.parseLong(req.getParameter("taskId"));
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);// 查找用户
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);// 查任务
        taskLoggerServiceV2.insertTaskLoggerPO(taskLoggerVO, userPO, taskId);//插入日志
        // 修改任务中间表状态
        Long pkId = taskUserServiceV2.getPkIdByUserIdAndTaskListId(userId, taskId);
        taskServiceV2.updateTaskListUserPOStatus(taskId, taskLoggerVO.getLoggerStatusId().longValue());
        taskUserServiceV2.updateTaskListUserPO(pkId, taskId, taskLoggerVO.getLoggerStatusId().longValue(), userId);// 存任务中间表;
        // 通过任务id查看总状态
        List<Long> statusIdList = taskUserServiceV2.getStatusIdList(taskId);
        // 选出最小的状态id 修改任务表里面的状态
        Long min = statusIdList.get(0);
        for (Long m : statusIdList) {
            if (m < min) {
                min = m;
            }
        }
        Integer rows = taskListServiceV2.updateTaskListPOStatus(taskId, min);
        if (rows > 0) {
            System.out.println("任务状态修改成功!");
        }
        return "redirect:/mytask";
    }

    /**
     * 在我的任务里面进行查询
     *
     * @throws ParseException
     */
    @RequestMapping("mychaxun")
    public String select(HttpServletRequest request, @SessionAttribute("userId") Long userId, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) throws ParseException {
        String title = null;//输入的名词
        if (!StringUtil.isEmpty(request.getParameter("title"))) {
            title = request.getParameter("title").trim();
        }

        PageHelper.startPage(page, size);
        List<TaskListPO> taskListPOList = taskServiceV2.sortTaskListPO(userId, title, page, size);
        PageInfo pageInfo = new PageInfo(taskListPOList);
        List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPOList(taskListPOList, userId);
        model.addAttribute("tasklist", mapList);
        model.addAttribute("page", pageInfo);
        model.addAttribute("url", "mychaxun");
        model.addAttribute("sort", "&title=" + title);
        return "task/mytasklist";
    }


}
