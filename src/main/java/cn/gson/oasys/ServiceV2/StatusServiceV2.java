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
    public List<StatusPO> getStatusPOByTypeModel(String statusModel) {
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo(statusModel);
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        return statusPOList;
    }

    /**
     * 根据状态模型和状态名找状态
     *
     * @param statusModel 状态模型
     * @param statusName  状态名
     * @return
     */
    public StatusPO getStatusPOByTypeModelAndTypeName(String statusModel, String statusName) {
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo(statusModel).andStatusNameEqualTo(statusName);
        StatusPO statusPO = statusPOMapper.selectByExample(statusPOExample).get(0);
        return statusPO;

    }

    /**
     * 根据状态ID找状态
     *
     * @param statusId 状态ID
     * @return
     */
    public StatusPO getStatusPOByStatusId(Long statusId) {
        StatusPO statusPO = statusPOMapper.selectByPrimaryKey(statusId);
        return statusPO;
    }

    /**
     * 获取所有状态
     *
     * @return
     */
    public List<StatusPO> getStatusPOListAll() {
        StatusPOExample statusPOExample = new StatusPOExample();
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        return statusPOList;
    }

}
