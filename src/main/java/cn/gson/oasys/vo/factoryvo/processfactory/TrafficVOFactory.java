package cn.gson.oasys.vo.factoryvo.processfactory;

import cn.gson.oasys.model.po.TrafficPO;
import cn.gson.oasys.vo.processV2.TrafficVO;

import java.util.ArrayList;
import java.util.List;

public class TrafficVOFactory {

    public static TrafficVO createTrafficVO(TrafficPO trafficPO) {
        TrafficVO trafficVO = new TrafficVO();
        trafficVO.setTrafficId(trafficPO.getTrafficId());
        //        private User user;//出差人员user_name(用户ID)
        trafficVO.setDepartName(trafficPO.getDepartName());
        trafficVO.setDepartTime(trafficPO.getDepartTime());
        trafficVO.setReachName(trafficPO.getReachName());
        trafficVO.setTrafficName(trafficPO.getTrafficName());
        trafficVO.setSeatType(trafficPO.getSeatType());
        trafficVO.setTrafficMoney(trafficPO.getTrafficMoney());
//    private EvectionMoney evection;//evection_id 出差表ID对应出差表????
        return trafficVO;
    }

    public static List<TrafficVO> createTrafficVOList(List<TrafficPO> trafficPOList) {
        List<TrafficVO> trafficVOList = new ArrayList<>();
        for (TrafficPO trafficPO : trafficPOList) {
            trafficVOList.add(TrafficVOFactory.createTrafficVO(trafficPO));
        }
        return trafficVOList;
    }

}
