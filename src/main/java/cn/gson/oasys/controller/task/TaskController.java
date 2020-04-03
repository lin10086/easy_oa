package cn.gson.oasys.controller.task;

import cn.gson.oasys.modelV2.bo.PageInformation;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.taskV2.TaskListPOServiceV2;
import cn.gson.oasys.serviceV2.taskV2.TaskLoggerServiceV2;
import cn.gson.oasys.serviceV2.taskV2.TaskServiceV2;
import cn.gson.oasys.serviceV2.taskV2.TaskUserPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserServiceV2;
import cn.gson.oasys.voandfactory.taskVO2.TaskListVO;
import cn.gson.oasys.voandfactory.taskVO2.TaskLoggerVO;
import cn.gson.oasys.voandfactory.taskVO2.TaskLoggerVOFactory;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Controller
@RequestMapping("/")
public class TaskController {

    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TaskServiceV2 taskServiceV2;
    @Resource
    private TaskUserPOServiceV2 taskUserServiceV2;
    @Resource
    private TaskListPOServiceV2 taskListServiceV2;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private TaskLoggerServiceV2 taskLoggerServiceV2;
    @Resource
    private PageInformation pageInformation;

    /**
     * 任务管理主页面
     *
     * @param model
     * @param userId 用户ID
     * @param page   第几页
     * @param size   每也大小
     * @return
     */

    @RequestMapping("taskmanage")
    public String taskManage(Model model,
                             @SessionAttribute("userId") Long userId,
                             @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size) {
        //根据发布人ID找任务
        List<TaskListPO> taskListPOList = taskServiceV2.selectTackListPOByTaskPushUserIdAndVal(null, userId);
//        任务信息分页
        List<TaskListPO> subTaskListPOS = pageInformation.getTaskListPOSPage(page, size, taskListPOList, model);
        List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPO(taskListPOList, userId);//任务的包装信息
        model.addAttribute("taskListPOList", subTaskListPOS);
        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "paixu");
        return "task/taskmanage";
    }

    /**
     * 任务管理中各种排序
     */
    @RequestMapping("paixu")
    public String order(HttpServletRequest request,
                        @SessionAttribute("userId") Long userId, Model model,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        String val = null;
        if (!StringUtil.isEmpty(request.getParameter("val"))) {
            val = request.getParameter("val").trim();
            model.addAttribute("sort", "&val=" + val);
        }
        //根据发布人ID和排序条件找任务
        List<TaskListPO> taskListPOList = taskServiceV2.selectTackListPOByTaskPushUserIdAndVal(val, userId);
//        任务信息分页
        List<TaskListPO> subTaskListPOS = pageInformation.getTaskListPOSPage(page, size, taskListPOList, model);
        //任务表的包装信息
        List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPO(subTaskListPOS, userId);
        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "paixu");
        return "task/managetable";

    }

    /**
     * 点击新增任务
     */
    @RequestMapping("addtask")
    public String addTask(@SessionAttribute("userId") Long userId,
                          @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size, Model model) {
        List<TypePO> typePOList = typePOServiceV2.getTypePOListAll();// 所有类型信息
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOListAll();//所有状态信息
        userServiceV2.setUserVOListAllAndPage(model, page, size);//获取通讯录信息
        model.addAttribute("typelist", typePOList);
        model.addAttribute("statuslist", statusPOList);
        model.addAttribute("url", "names");
        model.addAttribute("qufen", "任务");
        return "task/addtask";
    }

    /**
     * 保存增加的任务
     *
     * @param userId
     * @param taskListVO
     * @param br
     * @param request
     * @return
     */
    @RequestMapping("saveaddtask")
    public String saveAddTask(@SessionAttribute("userId") Long userId,
                              @Valid TaskListVO taskListVO, BindingResult br,
                              HttpServletRequest request) {
        request.getAttribute("success");
        TaskListPO taskListPO = taskServiceV2.insertOrUpdateTaskListPO(taskListVO, userId);//插入任务表
        taskLoggerServiceV2.insertTaskLoggerPO(taskListPO);
        // 分割任务接收人
        StringTokenizer st = new StringTokenizer(taskListVO.getReciverlist(), ";");
        while (st.hasMoreElements()) {
            UserPO receiverUserPO = userPOServiceV2.getUserPOByUsername(st.nextToken());
//            插入任务中间表
            taskUserServiceV2.insertTaskUserPO(taskListPO, receiverUserPO);
        }
        return "redirect:/taskmanage";
    }

    /**
     * 修改任务
     */
    @RequestMapping("edittask")
    public String editTask(Model model,
                           HttpServletRequest req,
                           @SessionAttribute("userId") Long userId,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
        userServiceV2.setUserVOListAllAndPage(model, page, size);
        // 得到链接中的任务id
        Long taskId = Long.parseLong(req.getParameter("id"));
        // 通过任务id得到相应的任务
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);
        // 得到任务状态id
        Long statusId = taskListPO.getStatusId().longValue();
        // 得到任务类型id
        Long typeId = taskListPO.getTypeId();
        // 查看状态表
        StatusPO statusPO = statusPOServiceV2.getStatusPOByStatusId(statusId);
        // 查询类型表
        TypePO typePO = typePOServiceV2.getTypePOByTypeId(typeId);
        model.addAttribute("task", taskListPO);
        model.addAttribute("type", typePO);
        model.addAttribute("status", statusPO);
        model.addAttribute("taskIsTop", taskListPO.getIsTop() == 0 ? false : true);
        model.addAttribute("taskIsCancel", taskListPO.getIsCancel() == 0 ? false : true);
        model.addAttribute("taskStarTime", new Timestamp(taskListPO.getStarTime().getTime()));
        model.addAttribute("taskEndTime", new Timestamp(taskListPO.getEndTime().getTime()));
        model.addAttribute("url", "names");//通讯录分页控制器
        model.addAttribute("qufen", "任务");
        return "task/edittask";
    }

    /**
     * 保存修改任务
     */
    @RequestMapping("update")
    public String update(TaskListVO taskListVO, HttpSession session) {
        Long userId = ((Long) session.getAttribute("userId"));//用户ID
        TaskListPO taskListPO = taskServiceV2.insertOrUpdateTaskListPO(taskListVO, userId);
        // 因为可能修改接收人所以先删除以前接收这个任务的用户在重新插入接收这个任务的新用户
        taskUserServiceV2.deleteTaskUserPOByTaskListPOId(taskListVO.getTaskId());

        StringTokenizer st = new StringTokenizer(taskListVO.getReciverlist(), ";");
        while (st.hasMoreElements()) {
            UserPO receiverUserPO = userPOServiceV2.getUserPOByUsername(st.nextToken());
            taskUserServiceV2.insertTaskUserPO(taskListPO, receiverUserPO);
        }
        return "redirect:/taskmanage";
    }

    /**
     * 任务管理的查看任务
     */
    @RequestMapping("seetask")
    public String seeTask(HttpServletRequest req, Model model) {
        // 得到任务的 id
        Long taskId = Long.parseLong(req.getParameter("id"));
        // 通过任务id得到相应的任务
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);
        //任务表里面的状态ID
        Long statusId = taskListPO.getStatusId().longValue();
        //根据任务表里的状态ID获取状态信息
        StatusPO statusPO = statusPOServiceV2.getStatusPOByStatusId(statusId);
        //获取所有的状态信息
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOListAll();
        //发布人信息
        UserPO pushUserPO = userPOServiceV2.getUserPOByUserId(taskListPO.getTaskPushUserId());
        //根据任务ID获取日志列表
        List<TaskLoggerPO> taskLoggerPOList = taskLoggerServiceV2.getTaskLoggerPOByTaskListPOId(taskId);
        model.addAttribute("task", taskListPO);//任务信息
        model.addAttribute("taskStarTime", new Timestamp(taskListPO.getStarTime().getTime()));//任务开始时间
        model.addAttribute("taskEndTime", new Timestamp(taskListPO.getEndTime().getTime()));//任务结束时间
        model.addAttribute("taskPushTime", new Timestamp(taskListPO.getPublishTime().getTime()));//任务发布时间
        model.addAttribute("user", pushUserPO);//任务发布人
        model.addAttribute("status", statusPO);//任务的状态信息
        model.addAttribute("loggerlist", taskLoggerPOList);//任务的日志信息
        for (TaskLoggerPO taskLoggerPO : taskLoggerPOList) {
            model.addAttribute("loggerlistcreatetime", new Timestamp(taskLoggerPO.getCreateTime().getTime()));//任务的日志时间
        }
        model.addAttribute("statuslist", statusPOList);//所有的状态信息
        return "task/seetask";
    }

    /**
     * 任务管理中的查看中的保存（任务状态和反馈日志）
     *
     * @return
     */
    @RequestMapping("tasklogger")
    public String taskLogger(TaskLoggerVO taskLoggerVO, @SessionAttribute("userId") Long userId, HttpServletRequest req) {
        Long taskId = Long.parseLong(req.getParameter("taskId"));// 得到任务的 id
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);
        taskLoggerServiceV2.insertTaskLoggerPO(taskLoggerVO, userPO, taskId);//插入任务日志
        // 修改任务状态
        taskServiceV2.updateTaskListPOStatus(taskId, taskLoggerVO.getLoggerStatusId().longValue());
        // 修改任务中间表状态
        taskServiceV2.updateTaskListUserPOStatus(taskId, taskLoggerVO.getLoggerStatusId().longValue());
        return "redirect:/taskmanage";
    }


    /**
     * 根据发布人这边删除任务和相关联系
     *
     * @param req
     * @return
     */
    @RequestMapping("deletetask")
    public String deleteTask(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        // 得到任务的 id
        Long taskId = Long.parseLong(req.getParameter("id"));
        // 根据任务id找出这条任务
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);
        if (taskListPO.getTaskPushUserId().equals(userId)) {
            taskLoggerServiceV2.deleteTaskLoggerPOByTaskId(taskId);
            StringTokenizer st = new StringTokenizer(taskListPO.getReciverlist(), ";");
            while (st.hasMoreElements()) {
                UserPO receiverUserPO = userPOServiceV2.getUserPOByUsername(st.nextToken());
                taskUserServiceV2.deleteTaskUserPOByTaskListPOIdAndUserId(taskId, receiverUserPO.getUserId());
            }
            taskServiceV2.deleteTaskListPOByTaskId(taskId);
        } else {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        return "redirect:/taskmanage";
    }

    /**
     * 我的任务
     */
    @RequestMapping("mytask")
    public String myTasks(@SessionAttribute("userId") Long userId, Model model,
                          @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size) {
        List<TaskListPO> taskListPOList = taskServiceV2.sortTaskListPO(userId, null);
        if (taskListPOList != null) {
            List<TaskListPO> subTaskListPOList = pageInformation.getTaskListPOSPage(page, size, taskListPOList, model);
            List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPOList(subTaskListPOList, userId);
            model.addAttribute("tasklist", mapList);
        } else {
            List<TaskListPO> taskListPOList2 = taskListServiceV2.getTaskListPOByTickingIsNotNull();
            List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPOList(taskListPOList2, userId);
            model.addAttribute("tasklist", mapList);
        }
        model.addAttribute("url", "mychaxun");
        return "task/mytask";
    }

    /**
     * 接收人这边删除(我的任务）
     */
    @RequestMapping("myshanchu")
    public String myTaskDelete(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        Long taskId = Long.parseLong(req.getParameter("taskId"));// 得到任务的 id
        Long pkId = taskUserServiceV2.getPkIdByUserIdAndTaskListId(userId, taskId);
        taskUserServiceV2.deleteTaskUserPOByPkId(pkId);
        return "redirect:/mytask";
    }

    /**
     * 我任务里面的查看
     *
     * @param req
     * @param userId 用户ID
     * @return
     */
    @RequestMapping("myseetask")
    public String mySeeTask(Model model, HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        Long taskId = Long.parseLong(req.getParameter("taskId"));// 得到任务的 id
        TaskListPO taskListPO = taskListServiceV2.getTaskListPOByTaskListPOId(taskId);// 通过任务id得到相应的任务
        Long statusId = taskListPO.getStatusId().longValue();// 任务表里的状态ID
        StatusPO statusPO = statusPOServiceV2.getStatusPOByStatusId(statusId);//根据任务表里的状态ID获取状态信息
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOListAll();//获取所有的状态信息
        UserPO userPO = userPOServiceV2.getUserPOByUserId(taskListPO.getTaskPushUserId());//发布人
        List<TaskLoggerPO> taskLoggerPOList = taskLoggerServiceV2.getTaskLoggerPOByTaskListPOId(taskId);//根据任务ID找任务日志
        List<TaskLoggerVO> taskLoggerVOList = TaskLoggerVOFactory.createTaskLoggerVOListByTaskLoggerPOList(taskLoggerPOList);//
        for (TaskLoggerVO taskLoggerVO : taskLoggerVOList) {
            taskLoggerVO.setUsername(userPOServiceV2.getUserPOByUserId(userId).getUserName());
            taskLoggerVO.setCreateTime(new Timestamp(new Date().getTime()));
        }
        model.addAttribute("task", taskListPO);//任务信息
        model.addAttribute("taskStarTime", new Timestamp(taskListPO.getStarTime().getTime()));//任务开始时间
        model.addAttribute("taskEndTime", new Timestamp(taskListPO.getEndTime().getTime()));//任务结束时间
        model.addAttribute("taskPushTime", new Timestamp(taskListPO.getPublishTime().getTime()));//任务发布时间
        model.addAttribute("user", userPO);//任务发布人
        model.addAttribute("status", statusPO);//任务状态信息
        model.addAttribute("loggerlist", taskLoggerVOList);//任务日志信息列表
        model.addAttribute("statuslist", statusPOList);//所有状态信息
        return "task/myseetask";
    }

    /**
     * 从我的任务查看里面修改状态和日志
     */
    @RequestMapping("uplogger")
    public String updateLogger(TaskLoggerVO taskLoggerVO, @SessionAttribute("userId") Long userId, HttpServletRequest req) {
        Long taskId = Long.parseLong(req.getParameter("taskId"));
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);// 查找用户
        taskLoggerServiceV2.insertTaskLoggerPO(taskLoggerVO, userPO, taskId);//插入日志
        // 修改任务中间表ID
        Long pkId = taskUserServiceV2.getPkIdByUserIdAndTaskListId(userId, taskId);
        // 更新任务中间表
        taskUserServiceV2.updateTaskListUserPO(pkId, taskId, taskLoggerVO.getLoggerStatusId().longValue(), userId);
        // 通过任务id查看状态列表
        List<Long> statusIdList = taskUserServiceV2.getStatusIdList(taskId);
        // 选出最小的状态id 修改任务表里面的状态
        Long min = statusIdList.get(0);
        for (Long m : statusIdList) {
            if (m < min) {
                min = m;
            }
        }
        //修改任务状态（按完成度最低的人修改）
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
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        String title = null;//输入的名词
        if (!StringUtil.isEmpty(request.getParameter("title"))) {
            title = request.getParameter("title").trim();
        }
        List<TaskListPO> taskListPOList = taskServiceV2.sortTaskListPO(userId, title);
        List<TaskListPO> subTaskListPOList = pageInformation.getTaskListPOSPage(page, size, taskListPOList, model);
        List<Map<String, Object>> mapList = taskServiceV2.packageTaskListPOList(subTaskListPOList, userId);
        model.addAttribute("tasklist", mapList);
        model.addAttribute("url", "mychaxun");
        model.addAttribute("sort", "&title=" + title);
        return "task/mytasklist";
    }

}
