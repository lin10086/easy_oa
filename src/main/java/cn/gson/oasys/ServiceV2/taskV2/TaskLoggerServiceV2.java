package cn.gson.oasys.ServiceV2.taskV2;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.TaskLoggerPOMapper;
import cn.gson.oasys.model.po.TaskListPO;
import cn.gson.oasys.model.po.TaskLoggerPO;
import cn.gson.oasys.model.po.TaskLoggerPOExample;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.taskVO2.TaskLoggerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TaskLoggerServiceV2 {
    @Resource
    private TaskLoggerPOMapper taskLoggerPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;


    /**
     * 根据任务ID找任务日志
     *
     * @param taskListPOId
     * @return
     */
    public List<TaskLoggerPO> getTaskLoggerPOByTaskListPOId(Long taskListPOId) {
        TaskLoggerPOExample taskLoggerPOExample = new TaskLoggerPOExample();
        taskLoggerPOExample.createCriteria().andTaskIdEqualTo(taskListPOId);
        List<TaskLoggerPO> taskLoggerPOList = taskLoggerPOMapper.selectByExample(taskLoggerPOExample);
        return taskLoggerPOList;
    }

    /**
     * 插入日志表
     *
     * @param taskListPO
     * @return
     */
    public void insertTaskLoggerPO(TaskListPO taskListPO) {
        TaskLoggerPO taskLoggerPO = new TaskLoggerPO();
        taskLoggerPO.setCreateTime(taskListPO.getPublishTime());
        taskLoggerPO.setLoggerStatusid(taskListPO.getStatusId());
        taskLoggerPO.setLoggerTicking(taskListPO.getTicking());
        taskLoggerPO.setTaskId(taskListPO.getTaskId());
        taskLoggerPO.setUsername(userServiceV2.getUserPOByUserId(taskListPO.getTaskPushUserId()).getUserName());
        taskLoggerPOMapper.insertSelective(taskLoggerPO);
    }

    /**
     * 更新日志
     *
     * @param taskLoggerVO
     * @param userPO
     */
    public void insertTaskLoggerPO(TaskLoggerVO taskLoggerVO, UserPO userPO, TaskListPO taskListPO) {
        TaskLoggerPO taskLoggerPO = new TaskLoggerPO();
        taskLoggerPO.setCreateTime(new Date());
        taskLoggerPO.setUsername(userPO.getUserName());
        taskLoggerPO.setLoggerTicking(taskLoggerVO.getLoggerTicking());
        taskLoggerPO.setTaskId(taskListPO.getTaskId());
        taskLoggerPO.setLoggerStatusid(taskLoggerVO.getLoggerStatusId());
        taskLoggerPOMapper.insertSelective(taskLoggerPO);
    }

    /**
     * 根据任务ID删除任务日志
     *
     * @param taskId
     */
    public void deleteTaskLoggerPOByTaskId(Long taskId) {
        TaskLoggerPOExample taskLoggerPOExample = new TaskLoggerPOExample();
        taskLoggerPOExample.createCriteria().andTaskIdEqualTo(taskId);
        taskLoggerPOMapper.deleteByExample(taskLoggerPOExample);

    }

}
