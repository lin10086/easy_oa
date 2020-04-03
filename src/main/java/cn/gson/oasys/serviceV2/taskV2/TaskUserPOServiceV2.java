package cn.gson.oasys.serviceV2.taskV2;

import cn.gson.oasys.mappers.TaskUserPOMapper;
import cn.gson.oasys.modelV2.po.TaskListPO;
import cn.gson.oasys.modelV2.po.TaskUserPO;
import cn.gson.oasys.modelV2.po.TaskUserPOExample;
import cn.gson.oasys.modelV2.po.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 任务用户业务
 */
@Service
public class TaskUserPOServiceV2 {
    @Resource
    private TaskUserPOMapper taskUserPOMapper;

    /**
     * 插入任务中间表
     *
     * @param taskListPO
     * @param userPO
     */
    public void insertTaskUserPO(TaskListPO taskListPO, UserPO userPO) {
        TaskUserPO taskUserPO = new TaskUserPO();
        taskUserPO.setStatusId(taskListPO.getStatusId().longValue());
        taskUserPO.setTaskId(taskListPO.getTaskId());
        taskUserPO.setTaskReciveUserId(userPO.getUserId());
        taskUserPOMapper.insertSelective(taskUserPO);
    }

    /**
     * 根据任务表ID找任务中间表
     *
     * @param taskListPOId
     * @return
     */
    public List<TaskUserPO> getTaskUserPOByTaskListPOId(Long taskListPOId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskIdEqualTo(taskListPOId);
        List<TaskUserPO> taskUserPOList = taskUserPOMapper.selectByExample(taskUserPOExample);
        return taskUserPOList;
    }

    /**
     * 根据用户id和状态id找任务中间表信息
     *
     * @param userId
     * @param statusId
     * @return
     */
    public List<TaskUserPO> getTaskUserPOByUserIdAndStatusId(Long userId, Long statusId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskReciveUserIdEqualTo(userId).andStatusIdEqualTo(statusId);
        List<TaskUserPO> taskUserPOList = taskUserPOMapper.selectByExample(taskUserPOExample);
        return taskUserPOList;
    }

    /**
     * 根据任务表ID删除任务用户表里的数据
     *
     * @param taskListPOId 任务ID
     */
    public void deleteTaskUserPOByTaskListPOId(Long taskListPOId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskIdEqualTo(taskListPOId);
        taskUserPOMapper.deleteByExample(taskUserPOExample);
    }


    /**
     * 根据中间表ID删除中间表信息
     *
     * @param pkId
     */
    public void deleteTaskUserPOByPkId(Long pkId) {
        taskUserPOMapper.deleteByPrimaryKey(pkId);
    }


    /**
     * 根据任务ID和接收人ID删除任务中间表
     *
     * @param taskListPOId 任务ID
     * @param userId       用户ID
     */
    public void deleteTaskUserPOByTaskListPOIdAndUserId(Long taskListPOId, Long userId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskIdEqualTo(taskListPOId).andTaskReciveUserIdEqualTo(userId);
        taskUserPOMapper.deleteByExample(taskUserPOExample);
    }

    /**
     * 根据用户ID和任务表ID返回关联表的状态ID
     *
     * @param userId
     * @param taskListPOId
     * @return
     */
    public Long getStatusIdByUserIdAndTaskListId(Long userId, Long taskListPOId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskReciveUserIdEqualTo(userId).andTaskIdEqualTo(taskListPOId);
        TaskUserPO taskUserPO = taskUserPOMapper.selectByExample(taskUserPOExample).get(0);
        return taskUserPO.getStatusId();
    }

    /**
     * 根据任务ID找状态列表
     *
     * @param taskId 任务id
     * @return
     */
    public List<Long> getStatusIdList(Long taskId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskIdEqualTo(taskId);
        List<TaskUserPO> taskUserPOList = taskUserPOMapper.selectByExample(taskUserPOExample);
        List<Long> list = new ArrayList<>();
        for (TaskUserPO taskUserPO : taskUserPOList) {
            list.add(taskUserPO.getStatusId());
        }
        return list;
    }

    /**
     * 根据接收人ID和任务ID在任务中间表，返回任务中间表ID
     *
     * @param userId       任务接收人ID
     * @param taskListPOId 任务表ID
     * @return 任务用户中间表ID
     */
    public Long getPkIdByUserIdAndTaskListId(Long userId, Long taskListPOId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskReciveUserIdEqualTo(userId).andTaskIdEqualTo(taskListPOId);
        TaskUserPO taskUserPO = taskUserPOMapper.selectByExample(taskUserPOExample).get(0);
        return taskUserPO.getPkId();
    }

    /**
     * 根据用户ID（即接收人ID）在任务用户关联表里找任务ID
     *
     * @param userId 用户ID
     * @return 任务ID集合
     */
    public List<Long> getTaskIdListByUserId(Long userId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskReciveUserIdEqualTo(userId);
        List<TaskUserPO> taskUserPOList = taskUserPOMapper.selectByExample(taskUserPOExample);
        List<Long> taskIdList = new ArrayList<>();
        for (TaskUserPO taskUserPO : taskUserPOList) {
            taskIdList.add(taskUserPO.getTaskId());
        }
        return taskIdList;
    }


    /**
     * 更新任务中间表
     *
     * @param pkId
     * @param taskListPOId
     * @param statusId
     * @param userId
     */
    public void updateTaskListUserPO(Long pkId, Long taskListPOId, Long statusId, Long userId) {
        TaskUserPO taskUserPO = new TaskUserPO();
        taskUserPO.setPkId(pkId);
        taskUserPO.setStatusId(statusId);
        taskUserPO.setTaskReciveUserId(userId);
        taskUserPO.setTaskId(taskListPOId);
        taskUserPOMapper.updateByPrimaryKeySelective(taskUserPO);
    }


}
