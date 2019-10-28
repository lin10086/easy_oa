package cn.gson.oasys.vo;

import cn.gson.oasys.model.entity.process.Bursement;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
//费用报销明细表
@Data
@ToString
public class DetailsBurseVO {
    private Long detailsBurseId;

    private Date produceTime;//费用产生时间

    private String 	subject;//费用产生科目

    private String descript;//费用说明

    private Integer invoices ;//票据张数

    private Double detailMoney;//报销金额

    private BursementVO bursementVO;//对应报销表
}
