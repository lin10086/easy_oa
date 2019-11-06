package cn.gson.oasys.vo.processV2;

import lombok.Data;
import lombok.ToString;

/**
 * 加班表
 */
@ToString
@Data
public class OverTimeVO {
    private Long overtimeId;// 加班表ID

    private Long typeId; //加班类型

    private ProcessListVO processListVO;//流程主表ID（pro_id）

    private String personnelAdvice;//人事部意见及说明

    private String managerAdvice;//经理意见及说明

    private String auditUser;//审核人员
}
