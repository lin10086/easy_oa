package cn.gson.oasys.voandfactory.taskVO2;

import cn.gson.oasys.modelV2.po.TaskLoggerPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskLoggerVOFactory {
    public static TaskLoggerVO createTaskLoggerVOByTaskLoggerPO(TaskLoggerPO taskLoggerPO) {
        TaskLoggerVO taskLoggerVO = new TaskLoggerVO();
        taskLoggerVO.setCreateTime(new Timestamp(taskLoggerPO.getCreateTime().getTime()));
        taskLoggerVO.setLoggerId(taskLoggerPO.getLoggerId());
        taskLoggerVO.setLoggerStatusId(taskLoggerPO.getLoggerStatusid());
        taskLoggerVO.setLoggerTicking(taskLoggerPO.getLoggerTicking());
        taskLoggerVO.setUsername(taskLoggerPO.getUsername());
        return taskLoggerVO;
    }

    public static List<TaskLoggerVO> createTaskLoggerVOListByTaskLoggerPOList(List<TaskLoggerPO> taskLoggerPOList) {
        List<TaskLoggerVO> taskLoggerVOList = new ArrayList<>();
        for (TaskLoggerPO taskLoggerPO : taskLoggerPOList) {
            taskLoggerVOList.add(TaskLoggerVOFactory.createTaskLoggerVOByTaskLoggerPO(taskLoggerPO));
        }
        return taskLoggerVOList;
    }
}
