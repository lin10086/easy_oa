package cn.gson.oasys.serviceV2.taskV2;

import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
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
    private UserPOServiceV2 userPOServiceV2;


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
        taskLoggerPO.setUsername(userPOServiceV2.getUserPOByUserId(taskListPO.getTaskPushUserId()).getUserName());
        taskLoggerPOMapper.insertSelective(taskLoggerPO);
    }

    /**
     * 插入日志
     *
     * @param taskLoggerVO
     * @param userPO
     */
    public void insertTaskLoggerPO(TaskLoggerVO taskLoggerVO, UserPO userPO, Long taskId) {
        TaskLoggerPO taskLoggerPO = new TaskLoggerPO();
        taskLoggerPO.setCreateTime(new Date());
        taskLoggerPO.setUsername(userPO.getUserName());//更新日志的人名
        taskLoggerPO.setLoggerTicking(taskLoggerVO.getLoggerTicking());
        taskLoggerPO.setTaskId(taskId);
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
