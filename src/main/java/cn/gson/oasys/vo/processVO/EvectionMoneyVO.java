package cn.gson.oasys.vo.processVO;

import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.model.entity.process.Stay;
import cn.gson.oasys.model.entity.process.Traffic;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 出差费用申请表
 */
@ToString
@Data
public class EvectionMoneyVO {

    private Long evectionMoneyId;

    private Double money; //申请总金额

    private String name; //关联客户

    private String managerAdvice;//经理意见及说明

    private String financialAdvice;//财务部意见及说明

    private ProcessList proId;//主表ID（pro_id）

    private Long pro;

    List<TrafficVO> trafficVOList;//交通费用明细表

    List<StayVO> stayVOList;//住宿申请表

    private String auditName;//审核人员

}
