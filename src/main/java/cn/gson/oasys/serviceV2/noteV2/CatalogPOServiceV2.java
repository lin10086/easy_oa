package cn.gson.oasys.serviceV2.noteV2;

import cn.gson.oasys.mappers.CatalogPOMapper;
import cn.gson.oasys.modelV2.po.CatalogPO;
import cn.gson.oasys.modelV2.po.CatalogPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CatalogPOServiceV2 {
    @Resource
    private CatalogPOMapper catalogPOMapper;

    /**
     * 插入一条目录
     *
     * @param catalogPO 目录信息
     */
    public void insertCatalogPO(CatalogPO catalogPO) {
        catalogPOMapper.insertSelective(catalogPO);
    }

    /**
     * 根据目录ID删除目录信息
     *
     * @param catalogPOId 目录ID
     */
    public void deleteCatalogPOByCatalogId(Long catalogPOId) {
        catalogPOMapper.deleteByPrimaryKey(catalogPOId);
    }

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
