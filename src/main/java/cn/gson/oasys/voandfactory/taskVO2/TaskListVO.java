package cn.gson.oasys.voandfactory.taskVO2;

import cn.gson.oasys.voandfactory.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 任务表
 */
@ToString
@Data
public class TaskListVO {
    private Long taskId;//任务id主键task_id

    private Long typeId;//任务类型（公事，私事）type_id

    private Date publishTime;//发布时间publish_time

    private Date starTime;//任务开始时间star_time

    private Date endTime;//任务结束时间end_time

    private Date modifyTime;//任务修改时间modify_time

    private String title;//任务主题title

    private String reciverlist;//reciverlist接收人不能为空

    private UserVO usersId;//发布人id/task_push_user_id

    private String taskDescribe;//任务描述task_describe

    private String comment;//任务评价comment

    private Boolean top = false;//任务是否置顶is_top

    private Boolean cancel = false;//是否取消任务is_cancel

    private String ticking;//任务结束后反馈ticking

    private Integer statusId;//任务状态id/status_id
}
