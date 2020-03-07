package cn.gson.oasys.serviceV2.typeV2;

import cn.gson.oasys.mappers.TypePOMapper;
import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.model.po.TypePOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TypePOServiceV2 {
    @Resource
    private TypePOMapper typePOMapper;

    /**
     * 根据是否存在类型ID来区分是插入还是更新
     *
     * @param typePO 类型信息
     */
    public void insertOrUpdateTypePO(TypePO typePO) {
        if (typePO.getTypeId() != null) {
            typePOMapper.updateByPrimaryKeySelective(typePO);
        } else {
            typePOMapper.insertSelective(typePO);
        }
    }

    /**
     * 根据类型ID删除类型信息
     *
     * @param typeId 类型ID
     */
    public void deleteTypePOByTypeId(Long typeId) {
        typePOMapper.deleteByPrimaryKey(typeId);
    }

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
     * 根据类型模糊找类型
     *
     * @param typeName 类型名
     * @return 返回类型id
     */
    public List<Long> getTypePOIdByTypeNameLike(String typeName) {
        TypePOExample typePOExample = new TypePOExample();
        typePOExample.createCriteria().andTypeNameLike("%" + typeName + "%");
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        List<Long> longList = new ArrayList<>();
        for (TypePO typePO : typePOList) {
            longList.add(typePO.getTypeId());
        }
        return longList;
    }

    /**
     * 根据类型名和类型模型查找
     *
     * @param name 模糊查找字
     * @return
     */
    public List<TypePO> getTypePOListByTypeNameLikeOrTypeModelLike(String name) {
        TypePOExample typePOExample = new TypePOExample();
        typePOExample.createCriteria().andTypeNameLike("%" + name + "%");
        TypePOExample.Criteria criteria1 = typePOExample.createCriteria();
        criteria1.andTypeModelLike("%" + name + "%");
        typePOExample.or(criteria1);
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        return typePOList;
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
     * @return
     */
    public String getTypeNameByTypeId(Long typeId) {
        TypePO typePO = typePOMapper.selectByPrimaryKey(typeId);
        String typeName = typePO.getTypeName();
        return typeName;
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
     * 获取所有类型信息
     *
     * @return
     */
    public List<TypePO> getTypePOListAll() {
        TypePOExample typePOExample = new TypePOExample();
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        return typePOList;
    }
}
