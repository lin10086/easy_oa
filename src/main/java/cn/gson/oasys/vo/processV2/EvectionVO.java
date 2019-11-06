package cn.gson.oasys.vo.processV2;

import lombok.Data;
import lombok.ToString;

/**
 * 出差表
 */
@ToString
@Data
public class EvectionVO {

    private Long evectionId;//出差表ID

    private Long typeId;    //外出类型

    private ProcessListVO ProcessListVO;//主表pro_id

    private String personnelAdvice;//人事部意见及说明

    private String managerAdvice;//经理意见及说明

    private String auditUser;//审核人员
}
