package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.TypeFactory;
import cn.gson.oasys.mappers.TypePOMapper;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.model.po.TypePOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 根据类型名找类型
     *
     * @param typeName
     * @return
     */
    public List<Long> getTypePOIdByTypeName(String typeName) {
        TypePOExample typePOExample = new TypePOExample();
        typePOExample.createCriteria().andTypeNameLike(typeName);
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        List<Long> longList = new ArrayList<>();
        for (TypePO typePO : typePOList) {
            longList.add(typePO.getTypeId());
        }
        return longList;
    }

    /**
     * 根据类型模型和类型名找唯一类型对象
     *
     * @param typeModel
     * @param typeName
     * @return
     */
    public TypePO getTypePOByTypeModelAndTypeName(String typeModel, String typeName) {
        TypePOExample typePOExample = new TypePOExample();
        typePOExample.createCriteria().andTypeModelEqualTo(typeModel).andTypeNameEqualTo(typeName);
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        if (typePOList.size() == 0) {
            return null;
        }
        return typePOList.get(0);
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

    /**
     * 在类型列表里面找类型ID和类型名通过类型列表
     *
     * @param typePOList 类型列表
     * @return
     */
    public Map<Long, String> getTypeIdAndTypeNameByTypePOList(List<TypePO> typePOList) {
        Map<Long, String> map = new HashMap<>();
        for (TypePO typePO : typePOList) {
            map.put(typePO.getTypeId(), typePO.getTypeName());
        }
        return map;
    }

    /**
     * 根据ID找类型
     *
     * @param typeId
     * @return
     */
    public TypePO getTypePOByTypeId(Long typeId) {
        TypePO typePO = typePOMapper.selectByPrimaryKey(typeId);
        return typePO;
    }

    /**
     * 获取所有类型
     *
     * @return
     */
    public List<TypePO> getTypePOListAll() {
        TypePOExample typePOExample = new TypePOExample();
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        return typePOList;
    }
}
