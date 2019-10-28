package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.mappers.StatusPOMapper;
import cn.gson.oasys.model.po.StatusPO;
import cn.gson.oasys.model.po.StatusPOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class StatusServiceV2 {
    @Resource
    private StatusPOMapper statusPOMapper;

    //根据状态模型找状态列表
    public List<StatusPO> getStatusPOByTypeModel(String statusModel){
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo(statusModel);
        List<StatusPO>statusPOList = statusPOMapper.selectByExample(statusPOExample);
        return statusPOList;
    }

}
