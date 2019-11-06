package cn.gson.oasys.vo.factoryvo.processfactory;

import cn.gson.oasys.model.po.StayPO;
import cn.gson.oasys.vo.processV2.StayVO;

import java.util.ArrayList;
import java.util.List;

public class StayVOFactory {

    public static StayVO createStayVO(StayPO stayPO) {
        StayVO stayVO = new StayVO();
        stayVO.setStayId(stayPO.getStayId());
//        private User user;//出差人员user_name(用户ID)
        stayVO.setStayTime(stayPO.getStayTime());
        stayVO.setLeaveTime(stayPO.getLeaveTime());
        stayVO.setStayCity(stayPO.getStayCity());
        stayVO.setHotelName(stayPO.getHotelName());
        stayVO.setDay(stayPO.getDay());
        stayVO.setStayMoney(stayPO.getStayMoney());
//        private EvectionMoney evemoney;//evemoney_id对应出差费用申请表
        return stayVO;
    }

    public static List<StayVO> createStayVOList(List<StayPO> stayPOList) {
        List<StayVO> stayVOList = new ArrayList<>();
        for (StayPO stayPO : stayPOList) {
            stayVOList.add(StayVOFactory.createStayVO(stayPO));
        }
        return stayVOList;
    }
}
