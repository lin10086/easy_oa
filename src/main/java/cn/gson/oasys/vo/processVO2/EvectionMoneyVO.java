package cn.gson.oasys.vo.processVO2;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 出差费用申请表
 */
@Data
@ToString
public class EvectionMoneyVO {

    private Long evectionMoneyId;//住宿申请表ID

    private Double money; //申请总金额

    private String name; //关联客户

    private String managerAdvice;//经理意见及说明

    private String financialAdvice;//财务部意见及说明

    private ProcessListVO processListVO;//主表ID（pro_id）

    private Long pro;

    List<TrafficVO> trafficVOList;//交通费用明细表

    List<StayVO> stayVOList;//住宿申请表

    private String auditUser;//审核人员

}
