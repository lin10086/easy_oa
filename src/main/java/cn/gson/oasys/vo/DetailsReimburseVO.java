package cn.gson.oasys.vo;

import cn.gson.oasys.vo.processVO.ReimbursementVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
//费用报销明细表
@Data
@ToString
public class DetailsReimburseVO {
    private Long detailsReimburseVOId;

    private Date produceTime;//费用产生时间

    private String 	subject;//费用产生科目

    private String descript;//费用说明

    private Integer invoices ;//票据张数

    private Double detailMoney;//报销金额

    private ReimbursementVO reimbursementVO;//对应报销表
}
