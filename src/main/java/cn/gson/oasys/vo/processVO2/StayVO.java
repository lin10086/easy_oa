package cn.gson.oasys.vo.processVO2;

import cn.gson.oasys.vo.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 住宿申请表
 */
@ToString
@Data
public class StayVO {

    private Long stayId;//住宿申请表ID

    private UserVO userVO;//住宿人员数据录user_name用户ID

    private Date stayTime;//入住日期

    private Date leaveTime;//离店日期

    private String stayCity;//入住城市

    private String hotelName;//入住酒店

    private Integer day;//入住天数

    private Double stayMoney;//酒店标准(多少元一天）

    private EvectionMoneyVO evectionMoneyVO;//数据库evemoney_id，出差费用申请单ID

    private String username;//住宿人员名
}
