package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.voandfactory.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 费用报销表
 */
@ToString
@Data
public class ReimbursementVO {

    private Long reimbursementId;

    private UserVO userVOMoney;//证明人(数据库名称用户ID）user_name

    private String name;//相关客户

    private Long typeId;//报销方式（银行卡，现金，其他）

    private UserVO operationUserVO;//报销人员(数据库名称用户ID)operation_name(审核人员id)

    private Date reimbursementTime;//报销日期

    private Integer allinvoices ;//票据总数

    private String managerAdvice;//经理意见及说明

    private String financialAdvice;//财务部意见及说明

    private Double allMoney;//总计金额

    private String auditName;//审核人员名

    private String testifyName;//证明人的名字

    private List<DetailsReimburseVO> detailsReimburseVOList;//费用报销明细表

    private ProcessListVO processListVO;//主表id
}
