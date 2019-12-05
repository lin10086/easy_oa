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

    /**
     * 根据用户id找用户目录列表
     *
     * @param userId 用户id
     * @return
     */
    public List<CatalogPO> getCatalogPOByUserId(Long userId) {
        CatalogPOExample catalogPOExample = new CatalogPOExample();
        catalogPOExample.createCriteria().andCataUserIdEqualTo(userId);
        List<CatalogPO> catalogPOS = catalogPOMapper.selectByExample(catalogPOExample);
        return catalogPOS;
    }

    /**
     * 根据目录id找目录信息
     *
     * @param catalogId 目录id
     * @return
     */
    public CatalogPO getCatalogPOByCatalogId(Long catalogId) {
        CatalogPO catalogPO = catalogPOMapper.selectByPrimaryKey(catalogId);
        return catalogPO;
    }

}
