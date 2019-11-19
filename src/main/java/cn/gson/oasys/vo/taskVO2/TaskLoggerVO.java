package cn.gson.oasys.vo.taskVO2;

import cn.gson.oasys.model.entity.task.Tasklist;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Data
public class TaskLoggerVO {
    private Long loggerId;//任务日志id主键logger_id

    private Date createTime;//任务日志创建时间create_time

    private String loggerTicking;//任务日志反馈内容logger_ticking

    private TaskListVO taskListVO;//任务id外键task_id

    private String username;//任务日志生成人username

    private Integer loggerStatusId; //状态id(logger_statusid0
}
