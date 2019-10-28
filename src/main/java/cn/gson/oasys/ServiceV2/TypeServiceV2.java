package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.TypeFactory;
import cn.gson.oasys.mappers.TypePOMapper;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.model.po.TypePOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class TypeServiceV2 {
    @Resource
    private TypePOMapper typePOMapper;

    /**
     * 根据类型模型找类型列表
     *
     * @param typeModel 类型模型
     * @return 类型列表
     */
    public List<TypePO> getTypePOByTypeModel(String typeModel) {
        TypePOExample typePOExample = new TypePOExample();
        typePOExample.createCriteria().andTypeModelEqualTo(typeModel);
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        return typePOList;
    }

    /**
     * 根据类型ID查找类型名
     *
     * @param typeId 类型ID
     * @return 类型名
     */
    public String getTypeNameByTypeId(Long typeId) {
        TypePO typePO = typePOMapper.selectByPrimaryKey(typeId);
        String typeName = typePO.getTypeName();
        return typeName;
    }

}
