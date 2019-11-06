package cn.gson.oasys.vo.processV2;

import lombok.Data;
import lombok.ToString;

/**
 * 转正表
 */
@ToString
@Data
public class RegularVO {
    private Long regularId;//转正表

    private String experience;//试用期/实习期心得体会

    private String understand;//对本岗位职员的要求的理解

    private String  pullulate;//试用期/实习期在哪些方面有了成长

    private String deficiency;//目前存在的不足

    private String dobetter;//如何在本岗位作得更好

    private String advice;//对公司产品的意见及建议

    private Integer days;//实习天数

    private String personnelAdvice;//人事部意见及说明

    private String managerAdvice;//经理意见及说明

    private ProcessListVO processListVO;//流程主表ID（pro_id）

    private String auditUser;//审核人员

}
