package cn.gson.oasys.serviceV2.processServiceV2;

import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.mappers.EvectionMoneyPOMapper;
import cn.gson.oasys.mappers.StayPOMapper;
import cn.gson.oasys.mappers.TrafficPOMapper;
import cn.gson.oasys.modelV2.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EvectionMoneyServiceV2 {
    @Resource
    private EvectionMoneyPOMapper evectionMoneyPOMapper;

    @Resource
    private StayPOMapper stayPOMapper;
    @Resource
    private TrafficPOMapper trafficPOMapper;
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    /**
     * 根据主表ID找出差费用报销表
     *
     * @param processListPOId 主表ID
     * @return
     */
    public EvectionMoneyPO getEvectionMoneyPOByProcessListPOId(Long processListPOId) {
        EvectionMoneyPOExample evectionMoneyPOExample = new EvectionMoneyPOExample();
        evectionMoneyPOExample.createCriteria().andProIdEqualTo(processListPOId);
        EvectionMoneyPO evectionMoneyPO = evectionMoneyPOMapper.selectByExample(evectionMoneyPOExample).get(0);
        return evectionMoneyPO;
    }

    /**
     * 根据费用出差报销表ID找住宿列表
     *
     * @param evectionMoneyPOId 费用报销表ID
     * @return
     */
    public List<StayPO> getStayPOList(Long evectionMoneyPOId) {
        StayPOExample stayPOExample = new StayPOExample();
        stayPOExample.createCriteria().andEvemoneyIdEqualTo(evectionMoneyPOId);
        List<StayPO> stayPOList = stayPOMapper.selectByExample(stayPOExample);
        return stayPOList;
    }

    /**
     * 根据出差报销表ID找交通列表
     *
     * @param evectionMoneyPOId 费用报销表ID
     * @return
     */
    public List<TrafficPO> getTrafficPOList(Long evectionMoneyPOId) {
        TrafficPOExample trafficPOExample = new TrafficPOExample();
        trafficPOExample.createCriteria().andEvemoneyIdEqualTo(evectionMoneyPOId);
        List<TrafficPO> trafficPOList = trafficPOMapper.selectByExample(trafficPOExample);
        return trafficPOList;
    }


    /**
     * 根据住宿表ID找住宿人员
     *
     * @param stayId
     * @return
     */
    public UserPO userPOByStayId(Long stayId) {
        StayPO stayPO = stayPOMapper.selectByPrimaryKey(stayId);
        UserPO userPO = userPOServiceV2.getUserPOByUserId(stayPO.getUserName());
        return userPO;
    }

    /**
     * 根据交通表ID找出差人员名
     *
     * @param trafficId
     * @return
     */
    public UserPO userPOByTrafficId(Long trafficId) {
        TrafficPO trafficPO = trafficPOMapper.selectByPrimaryKey(trafficId);
        UserPO userPO = userPOServiceV2.getUserPOByUserId(trafficPO.getUserName());
        return userPO;
    }


    /**
     * 根据交通费用表ID找交通费用表
     *
     * @param trafficId
     * @return
     */
    public TrafficPO getTrafficPOByTrafficId(Long trafficId) {
        TrafficPO trafficPO = trafficPOMapper.selectByPrimaryKey(trafficId);
        return trafficPO;
    }
}
