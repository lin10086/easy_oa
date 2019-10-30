package cn.gson.oasys.vo.processVO;

import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.vo.ProcessListVO;
import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * 离职表
 */
@ToString
@Data
public class ResignVO {

    private Long resignId;//离职表ID

    private String suggest;//申请人的意见及建议

    private Boolean finish=false;//是否还有费用报销未完成

    private UserVO handUserVO; //工作交接人员

    private String noFinish;//未完成事宜

    private String financialAdvice;//财务部意见及说明

    private String personnelAdvice;//人事部意见及说明

    private String managerAdvice;//经理意见及说明

    private ProcessListVO processListVO;//流程主表ID（pro_id)

    private String nameUser;//审核人员

    private String handUser;//交接人员名
}
