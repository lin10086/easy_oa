package cn.gson.oasys.voandfactory.taskVO2;

import cn.gson.oasys.model.entity.task.Tasklist;
import cn.gson.oasys.model.entity.user.User;
import lombok.Data;
import lombok.ToString;

/**
 * 任务接收人联系表
 */
@ToString
@Data
public class TaskUserVO {

    private Long pkId;//任务接收人主键id(pk_id)

    private Tasklist taskId;//任务id外键(task_id)

    private User userId;//接收人id外键(task_recive_user_id)

    private Integer statusId;//任务状态id(status_id)
}
