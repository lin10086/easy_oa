package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.modelV2.po.StayPO;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StayVOFactory {
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    public static StayVO createStayVOByStayPO(StayPO stayPO) {
        StayVO stayVO = new StayVO();
        stayVO.setStayId(stayPO.getStayId());
//        private User user;//出差人员user_name(用户ID)
        stayVO.setStayTime(new Timestamp(stayPO.getStayTime().getTime()));
        stayVO.setLeaveTime(new Timestamp(stayPO.getLeaveTime().getTime()));
        stayVO.setStayCity(stayPO.getStayCity());
        stayVO.setHotelName(stayPO.getHotelName());
        stayVO.setDay(stayPO.getDay());
        stayVO.setStayMoney(stayPO.getStayMoney());
//        private EvectionMoney evemoney;//evemoney_id对应出差费用申请表
        return stayVO;
    }

    public static List<StayVO> createStayVOListByStayPOList(List<StayPO> stayPOList) {
        List<StayVO> stayVOList = new ArrayList<>();
        for (StayPO stayPO : stayPOList) {
            stayVOList.add(StayVOFactory.createStayVOByStayPO(stayPO));
        }
        return stayVOList;
    }
}
