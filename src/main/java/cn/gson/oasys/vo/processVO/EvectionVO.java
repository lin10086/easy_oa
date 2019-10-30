package cn.gson.oasys.vo.processVO;

import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.vo.ProcessListVO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * 出差表
 */
@ToString
@Data
public class EvectionVO {

    private Long evectionId;

    private Long typeId;    //外出类型

    private ProcessListVO ProcessListVO;//主表pro_id

    private String personnelAdvice;//人事部意见及说明

    private String managerAdvice;//经理意见及说明

    private String auditUser;//审核人员
}
