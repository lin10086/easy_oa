package cn.gson.oasys.vo.processVO2;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 流程管理》流程审核
 */
@ToString
@Data
public class ProcessAuditVO {
    private Long processId;//主表ID

    private String typeName;//主表的类型名

    private String processName; //标题（主表）

    private String userName;//申请人姓名

    private Date applyTime; //申请时间（主表里）

    private Long exigenceName;    //紧急程度（主表里deeplyId）

    private Long statusId;//审核状态(在审核表里）
}
