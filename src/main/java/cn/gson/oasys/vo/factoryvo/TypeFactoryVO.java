package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.vo.TypeVO;

import java.util.ArrayList;
import java.util.List;

public class TypeFactoryVO {
    public static TypeVO createTypeVO(TypePO typePO){
        TypeVO typeVO = new TypeVO();
        typeVO.setTypeId(typePO.getTypeId());
        typeVO.setTypeName(typePO.getTypeName());
        typeVO.setTypeColor(typePO.getTypeColor());
        typeVO.setTypeModel(typePO.getTypeModel());
        typeVO.setTypeSortValue(typePO.getSortValue());
        return typeVO;
    }

    public static List<TypeVO> createTypeVOList(List<TypePO>typePOList){
        List<TypeVO>typeVOList = new ArrayList<>();
        for(TypePO typePO : typePOList){
            typeVOList.add(TypeFactoryVO.createTypeVO(typePO));
        }
        return typeVOList;
    }
}
