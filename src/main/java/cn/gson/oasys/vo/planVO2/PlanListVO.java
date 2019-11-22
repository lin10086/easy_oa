package cn.gson.oasys.vo.planVO2;

import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@ToString
@Data
public class PlanListVO {

    private Long planId;//plan_id

    private Long typeId; //类型id(type_id)

    private Long statusId; //状态id(status_id)

    private Long attachmentId;   //附件id(attach_id)

    private Date startTime;   //开始时间start_time

    private Date endTime;   //结束时间end_time

    private Date createTime;   //记录创建时间create_time

    private String title;   //标题

    private String label;   //标签

    private String planContent;   //计划内容plan_content

    private String planSummary;   //计划总结plan_summary

    private String planComment;   //计划评论plan_comment

    private UserVO userVO; //用户计划外键plan_user_id
}
