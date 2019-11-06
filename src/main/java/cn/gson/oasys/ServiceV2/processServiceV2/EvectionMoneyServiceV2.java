package cn.gson.oasys.ServiceV2.processServiceV2;

import cn.gson.oasys.mappers.EvectionMoneyPOMapper;
import cn.gson.oasys.mappers.StayPOMapper;
import cn.gson.oasys.mappers.TrafficPOMapper;
import cn.gson.oasys.model.po.*;
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
     * 根据费用报销表ID找住宿列表
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
     * 根据费用报销表ID找交通列表
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


}
