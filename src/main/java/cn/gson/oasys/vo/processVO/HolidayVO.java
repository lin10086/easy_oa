package cn.gson.oasys.vo.processVO;

import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.vo.ProcessListVO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * 请假表
 */
@ToString
@Data
public class HolidayVO {
    private Long holidayId;//请假表ID

    private Long typeId;  //请假类型

    private Integer leaveDays; //请假天数

    private ProcessListVO processListVO;//流程主表ID（pro_id）

    private String personnelAdvice;//人事部意见及说明

    private String managerAdvice;//经理意见及说明

    private String auditUser;//审核人员
}
