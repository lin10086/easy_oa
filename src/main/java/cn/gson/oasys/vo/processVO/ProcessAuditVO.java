package cn.gson.oasys.vo.processVO;

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

    private Long deeplyId;    //紧急程度

    private String processName; //主题

    private String userName;//申请人姓名

    private Date applyTime; //申请时间

    private Long statusId;//审核人状态
}
