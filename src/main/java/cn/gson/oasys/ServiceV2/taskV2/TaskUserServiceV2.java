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
     * 根据任务ID和用户ID删除任务中间表
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
     * 根据用户ID和任务表ID返回关联表（任务用户表）ID
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


}
