package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.TrafficPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TrafficVOFactory {

    public static TrafficVO createTrafficVOByTrafficPO(TrafficPO trafficPO) {
        TrafficVO trafficVO = new TrafficVO();
        trafficVO.setTrafficId(trafficPO.getTrafficId());
        //        private User user;//出差人员user_name(用户ID)
        trafficVO.setDepartName(trafficPO.getDepartName());
        trafficVO.setDepartTime(new Timestamp(trafficPO.getDepartTime().getTime()));
        trafficVO.setReachName(trafficPO.getReachName());
        trafficVO.setTrafficName(trafficPO.getTrafficName());
        trafficVO.setSeatType(trafficPO.getSeatType());
        trafficVO.setTrafficMoney(trafficPO.getTrafficMoney());
//    private EvectionMoney evection;//evection_id 出差表ID对应出差表????
        return trafficVO;
    }

    public static List<TrafficVO> createTrafficVOListByTrafficPOList(List<TrafficPO> trafficPOList) {
        List<TrafficVO> trafficVOList = new ArrayList<>();
        for (TrafficPO trafficPO : trafficPOList) {
            trafficVOList.add(TrafficVOFactory.createTrafficVOByTrafficPO(trafficPO));
        }
        return trafficVOList;
    }

}
