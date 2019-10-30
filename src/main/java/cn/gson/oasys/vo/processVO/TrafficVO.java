package cn.gson.oasys.vo.processVO;

import cn.gson.oasys.model.entity.process.EvectionMoney;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.*;
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

    @ManyToOne()
    @JoinColumn(name="evection_id")
    private EvectionMoney evection;

    @Transient
    private String username;

}
