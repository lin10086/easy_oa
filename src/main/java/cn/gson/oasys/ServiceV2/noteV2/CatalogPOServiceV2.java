package cn.gson.oasys.ServiceV2.noteV2;

import cn.gson.oasys.mappers.CatalogPOMapper;
import cn.gson.oasys.mappers.NoteListPOMapper;
import cn.gson.oasys.model.po.CatalogPO;
import cn.gson.oasys.model.po.CatalogPOExample;
import cn.gson.oasys.model.po.NoteListPO;
import cn.gson.oasys.model.po.NoteListPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CatalogPOServiceV2 {
    @Resource
    private CatalogPOMapper catalogPOMapper;

    public List<CatalogPO> getCatalogPOByUserId(Long userId) {
        CatalogPOExample catalogPOExample = new CatalogPOExample();
        catalogPOExample.createCriteria().andCataUserIdEqualTo(userId);
        List<CatalogPO> catalogPOS = catalogPOMapper.selectByExample(catalogPOExample);
        return catalogPOS;
    }
}
