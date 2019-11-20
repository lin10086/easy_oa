package cn.gson.oasys.ServiceV2.taskV2;

import cn.gson.oasys.mappers.TaskUserPOMapper;
import cn.gson.oasys.model.entity.task.Taskuser;
import cn.gson.oasys.model.po.TaskListPO;
import cn.gson.oasys.model.po.TaskUserPO;
import cn.gson.oasys.model.po.TaskUserPOExample;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.taskVO2.TaskUserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskUserServiceV2 {
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
     * 根据任务表ID删除任务用户表里的数据
     *
     * @param taskListPOId
     */
    public void deleteTaskUserPOByTaskListPOId(Long taskListPOId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskIdEqualTo(taskListPOId);
        taskUserPOMapper.deleteByExample(taskUserPOExample);
    }

    /**
     * 根据任务ID和接收人ID删除任务中间表
     *
     * @param taskListPOId
     * @param userId
     */
    public void deleteTaskUserPOByTaskListPOIdAndUserId(Long taskListPOId, Long userId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskIdEqualTo(taskListPOId).andTaskReciveUserIdEqualTo(userId);
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
     * @param taskId
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
     * @param userId
     * @param taskListPOId
     * @return
     */
    public Long getPkIdByUserIdAndTaskListId(Long userId, Long taskListPOId) {
        TaskUserPOExample taskUserPOExample = new TaskUserPOExample();
        taskUserPOExample.createCriteria().andTaskReciveUserIdEqualTo(userId).andTaskIdEqualTo(taskListPOId);
        TaskUserPO taskUserPO = taskUserPOMapper.selectByExample(taskUserPOExample).get(0);
        return taskUserPO.getPkId();
    }

    /**
     * 根据接收人ID在找任务关联表里找任务ID
     *
     * @param userId
     * @return
     */
    public List<Long> getTaskIdList(Long userId) {
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
