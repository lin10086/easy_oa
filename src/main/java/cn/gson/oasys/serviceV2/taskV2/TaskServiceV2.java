package cn.gson.oasys.serviceV2.taskV2;

import cn.gson.oasys.mappers.TaskListPOMapper;
import cn.gson.oasys.mappers.TaskUserPOMapper;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.serviceV2.deptV2.DeptPOServiceV2;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.voandfactory.taskVO2.TaskListVO;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

/**
 * 任务业务
 */
@Service
public class TaskServiceV2 {

    @Resource
    private TaskListPOMapper taskListPOMapper;
    @Resource
    private TaskUserPOServiceV2 taskUserServiceV2;
    @Resource
    private TaskListPOServiceV2 taskListPOServiceV2;
    @Resource
    private TaskUserPOMapper taskUserPOMapper;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private DeptPOServiceV2 deptPOServiceV2;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;

    /**
     * 根据发布人ID找任务列表及各种排序
     *
     * @param val    排序条件
     * @param userId 登录人ID
     * @return
     */
    public List<TaskListPO> selectTackListPOByTaskPushUserIdAndVal(String val, Long userId) {
        List<TaskListPO> taskListPOS = null;
        if (StringUtil.isEmpty(val)) {
            TaskListPOExample taskListPOExample = new TaskListPOExample();
            taskListPOExample.createCriteria().andTaskPushUserIdEqualTo(userId);
            taskListPOExample.setOrderByClause("is_top DESC,publish_time DESC");
            taskListPOS = taskListPOMapper.selectByExample(taskListPOExample);
        } else if (("类型").equals(val)) {
            TaskListPOExample taskListPOExample = new TaskListPOExample();
            taskListPOExample.createCriteria().andTaskPushUserIdEqualTo(userId);
            taskListPOExample.setOrderByClause("type_id DESC");
            taskListPOExample.createCriteria().andTaskPushUserIdEqualTo(userId);
            taskListPOS = taskListPOMapper.selectByExample(taskListPOExample);
        } else if (("状态").equals(val)) {
            TaskListPOExample taskListPOExample = new TaskListPOExample();
            taskListPOExample.createCriteria().andTaskPushUserIdEqualTo(userId);
            taskListPOExample.setOrderByClause("status_id DESC");
            taskListPOS = taskListPOMapper.selectByExample(taskListPOExample);
        } else if (("发布时间").equals(val)) {
            TaskListPOExample taskListPOExample = new TaskListPOExample();
            taskListPOExample.createCriteria().andTaskPushUserIdEqualTo(userId);
            taskListPOExample.setOrderByClause("publish_time DESC");
            taskListPOS = taskListPOMapper.selectByExample(taskListPOExample);
        } else {
            TaskListPOExample taskListPOExample = new TaskListPOExample();
            taskListPOExample.createCriteria().andTaskPushUserIdEqualTo(userId).andTitleLike("%" + val + "%");
            taskListPOS = taskListPOMapper.selectByExample(taskListPOExample);
        }
        return taskListPOS;
    }


    /**
     * 从前端获取到的任务表数据插入任务表或更新数据
     *
     * @param taskListVO
     * @param userId
     */
    public TaskListPO insertOrUpdateTaskListPO(TaskListVO taskListVO, Long userId) {
        TaskListPO taskListPO = new TaskListPO();
        taskListPO.setModifyTime(new Date());
        taskListPO.setPublishTime(new Date());
        taskListPO.setTaskPushUserId(userId);
        taskListPO.setTypeId(taskListVO.getTypeId());
        taskListPO.setStarTime(taskListVO.getStarTime());
        taskListPO.setEndTime(taskListVO.getEndTime());
        taskListPO.setTitle(taskListVO.getTitle());
        taskListPO.setReciverlist(taskListVO.getReciverlist());
        taskListPO.setTaskDescribe(taskListVO.getTaskDescribe());
        taskListPO.setComment(taskListVO.getComment());
        taskListPO.setIsTop(taskListVO.getTop() == false ? 0 : 1);
        taskListPO.setIsCancel(taskListVO.getCancel() == false ? 0 : 1);
        taskListPO.setTicking(taskListVO.getTicking());
        taskListPO.setStatusId(taskListVO.getStatusId());

        if (taskListVO.getTaskId() != null) {
            taskListPO.setTaskId(taskListVO.getTaskId());
            taskListPOMapper.updateByPrimaryKeySelective(taskListPO);
        } else {
            taskListPOMapper.insertSelective(taskListPO);
        }
        return taskListPO;
    }


    /**
     * 更新任务表状态
     *
     * @param taskListPOId
     * @param statusId
     */
    public void updateTaskListPOStatus(Long taskListPOId, Long statusId) {
        TaskListPO taskListPO = taskListPOMapper.selectByPrimaryKey(taskListPOId);
        taskListPO.setStatusId(statusId.intValue());
        taskListPOMapper.updateByPrimaryKeySelective(taskListPO);
    }

    /**
     * 更新任务中间表
     *
     * @param taskListPOId
     * @param statusId
     */
    public void updateTaskListUserPOStatus(Long taskListPOId, Long statusId) {
        List<TaskUserPO> taskUserPOList = taskUserServiceV2.getTaskUserPOByTaskListPOId(taskListPOId);
        for (TaskUserPO taskUserPO : taskUserPOList) {
            taskUserPO.setStatusId(statusId);
            taskUserPOMapper.updateByPrimaryKeySelective(taskUserPO);
        }
    }


    /**
     * 根据任务表ID删除任务表
     *
     * @param taskId
     */
    public void deleteTaskListPOByTaskId(Long taskId) {
        taskListPOMapper.deleteByPrimaryKey(taskId);
    }

    /**
     * 排序
     *
     * @param userId 用户ID
     * @param title  标题
     * @return
     */
    public List<TaskListPO> sortTaskListPO(Long userId, String title) {
        List<TaskListPO> taskListPOList = null;
        // 根据接收人id查询任务id
        List<Long> taskIdList = taskUserServiceV2.getTaskIdListByUserId(userId);
        TypePO typePO = null;
        StatusPO statusPO = null;
        UserPO userPO = null;
        if (title != null) {
            typePO = typePOServiceV2.getTypePOByTypeModelAndTypeName("aoa_task_list", title);
            statusPO = statusPOServiceV2.getStatusPOByTypeModelAndStatusName("aoa_task_list", title);
            userPO = userPOServiceV2.getUserPOByUsername(title);
        }
        if (StringUtil.isEmpty(title)) {
            if (taskIdList.size() > 0) {
                taskListPOList = taskListPOServiceV2.getTaskListPOBySortAndTaskIdIn(taskIdList);
            }
        } else if (!Objects.isNull(typePO)) {
            taskListPOList = taskListPOServiceV2.getTaskListPOByTypeIdAndTaskIdIn(taskIdList, typePO.getTypeId());
        } else if (!Objects.isNull(statusPO)) {
            taskListPOList = taskListPOServiceV2.getTaskListPOByStatusIdAndTaskIdIn(taskIdList, statusPO.getStatusId().intValue());
        } else if (("已取消").equals(title)) {
            taskListPOList = taskListPOServiceV2.getTaskListPOBycancelAndTaskIdIn(taskIdList, true);
        } else if (!Objects.isNull(userPO)) {
            taskListPOList = taskListPOServiceV2.getTaskListPOByUserPOIdAndTaskIdIn(taskIdList, userPO);
        } else {
            taskListPOList = taskListPOServiceV2.getTaskListPOByTitleLikeAndTaskIdIn(taskIdList, title);
        }
        return taskListPOList;
    }

    /**
     * 包装任务表
     *
     * @param taskListPOList 任务表
     * @param userId         用户ID
     * @return
     */
    public List<Map<String, Object>> packageTaskListPO(List<TaskListPO> taskListPOList, Long userId) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);// 用户信息
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (TaskListPO taskListPO : taskListPOList) {
            Map<String, Object> map = new HashMap<>();
            DeptPO deptPO = deptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId());//用户的部门信息
            StatusPO statusPO = statusPOServiceV2.getStatusPOByStatusId(taskListPO.getStatusId().longValue());//任务的状态信息
            map.put("taskid", taskListPO.getTaskId());//任务表ID
            map.put("typename", typePOServiceV2.getTypePOByTypeId(taskListPO.getTypeId()).getTypeName());//任务类型名
            map.put("statusname", statusPO.getStatusName());//任务状态名
            map.put("statuscolor", statusPO.getStatusColor());//任务状态颜色
            map.put("title", taskListPO.getTitle());//任务标题
            map.put("publishtime", new Timestamp(taskListPO.getPublishTime().getTime()));//任务发布时间
            map.put("zhiding", taskListPO.getIsTop() == 0 ? false : true); // 任务是否置顶
            map.put("cancel", taskListPO.getIsCancel() == 0 ? false : true);//是否取消任务
            map.put("username", userPO.getUserName());//用户名
            map.put("deptname", deptPO.getDeptName());//部门名
            mapList.add(map);
        }
        return mapList;
    }


    /**
     * 封装（index4)
     *
     * @param taskListPOList
     * @param userId
     * @return
     */
    public List<Map<String, Object>> packageTaskListPOList(List<TaskListPO> taskListPOList, Long userId) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (taskListPOList != null) {
            for (TaskListPO taskListPO : taskListPOList) {
                Map<String, Object> result = new HashMap<>();
                Long taskId = taskListPO.getTaskId();// 查询任务id
                Long statusId = taskUserServiceV2.getStatusIdByUserIdAndTaskListId(userId, taskId);// 查询接收人的任务状态id
                UserPO pushUserPO = userPOServiceV2.getUserPOByUserId(taskListPO.getTaskPushUserId());// 查询发布人
                String deptName = deptPOServiceV2.getDeptPOByDeptId(pushUserPO.getDeptId()).getDeptName();//发布人的部门名
                result.put("taskid", taskId);//任务ID
                result.put("typename", typePOServiceV2.getTypePOByTypeId(taskListPO.getTypeId()).getTypeName());//类型名
                result.put("statusname", statusPOServiceV2.getStatusPOByStatusId(statusId).getStatusName());//状态名
                result.put("statuscolor", statusPOServiceV2.getStatusPOByStatusId(statusId).getStatusColor());//状态颜色
                result.put("title", taskListPO.getTitle());//任务标题
                result.put("publishtime", new Timestamp(taskListPO.getPublishTime().getTime()));//任务发布时间
                result.put("zhiding", taskListPO.getIsTop() == 0 ? false : true);//是否置顶
                result.put("cancel", taskListPO.getIsCancel() == 0 ? false : true);//是否取消
                result.put("username", pushUserPO.getUserName());//发布人名
                result.put("deptname", deptName);//发布人的部门名
                list.add(result);
            }
        }
        return list;
    }

}