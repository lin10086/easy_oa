package cn.gson.oasys.vo.processVO2;

import cn.gson.oasys.vo.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 交通费用明细表
 */
@ToString
@Data
public class TrafficVO {

    private Long trafficId;//交通费用表ID

    private UserVO userVO;//出差人员(数据库user_name用户ID）

    private Date departTime;//出发时间

    private String departName;//出发城市

    private String reachName;//到达城市

    private String trafficName;//交通工具

    private String seatType;//座位类型

    private Double trafficMoney;//交通标准

    private EvectionMoneyVO evectionMoneyVO;//数据库evemoney_id，出差费用申请单ID

    private String username;//出差人员名

}
