package cn.gson.oasys.vo.factoryvo.taskFactory;

import cn.gson.oasys.model.po.TaskLoggerPO;
import cn.gson.oasys.vo.taskVO2.TaskLoggerVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskLoggerFactoryVO {
    public static TaskLoggerVO createTaskLoggerVO(TaskLoggerPO taskLoggerPO) {
        TaskLoggerVO taskLoggerVO = new TaskLoggerVO();
        taskLoggerVO.setCreateTime(new Timestamp(taskLoggerPO.getCreateTime().getTime()));
        taskLoggerVO.setLoggerId(taskLoggerPO.getLoggerId());
        taskLoggerVO.setLoggerStatusId(taskLoggerPO.getLoggerStatusid());
        taskLoggerVO.setLoggerTicking(taskLoggerPO.getLoggerTicking());
        taskLoggerVO.setUsername(taskLoggerPO.getUsername());
        return taskLoggerVO;
    }

    public static List<TaskLoggerVO> createTaskLoggerVOList(List<TaskLoggerPO> taskLoggerPOList) {
        List<TaskLoggerVO> taskLoggerVOList = new ArrayList<>();
        for (TaskLoggerPO taskLoggerPO : taskLoggerPOList) {
            taskLoggerVOList.add(TaskLoggerFactoryVO.createTaskLoggerVO(taskLoggerPO));
        }
        return taskLoggerVOList;
    }
}
