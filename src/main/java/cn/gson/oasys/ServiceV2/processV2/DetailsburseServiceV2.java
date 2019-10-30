package cn.gson.oasys.ServiceV2.processV2;

import cn.gson.oasys.mappers.DetailsbursePOMapper;
import cn.gson.oasys.model.po.DetailsbursePO;
import cn.gson.oasys.model.po.DetailsbursePOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DetailsburseServiceV2 {
    @Resource
    private DetailsbursePOMapper detailsbursePOMapper;

    /**
     * 根据费用报销表ID找费用报销详细表
     *
     * @param bursementId 费用报销表ID
     * @return
     */
    public List<DetailsbursePO> getDetailsbursePOListByBusementId(Long bursementId) {
        DetailsbursePOExample detailsbursePOExample = new DetailsbursePOExample();
        detailsbursePOExample.createCriteria().andBursmentIdEqualTo(bursementId);
        List<DetailsbursePO> detailsbursePOList = detailsbursePOMapper.selectByExample(detailsbursePOExample);
        return detailsbursePOList;
    }
}
