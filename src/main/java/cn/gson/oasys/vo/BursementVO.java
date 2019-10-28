package cn.gson.oasys.vo;

import cn.gson.oasys.model.entity.process.DetailsBurse;
import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.model.entity.user.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@ToString
@Data
public class BursementVO {

    private Long bursementId;

    private UserVO userVOMoney;//证明人

    private String name;//相关客户

    private Long typeId;//报销方式（银行卡，现金，其他）

    private User operation;//报销人员

    private Date burseTime;//报销日期

    private Integer allinvoices ;//票据总数

    private String managerAdvice;//经理意见及说明

    private String financialAdvice;//财务部意见及说明

    private Double allMoney;//总计金额

    private String auditName;//审核人员名

    private String nameMoney;//承担主体(证明人的名字）

    private List<DetailsBurseVO> detailsBurseVOList;//费用报销明细表

    private ProcessListVO processListVO;//主表
}
