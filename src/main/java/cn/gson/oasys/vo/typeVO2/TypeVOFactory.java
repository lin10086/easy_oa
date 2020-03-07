package cn.gson.oasys.vo.typeVO2;

import cn.gson.oasys.model.po.TypePO;

import java.util.ArrayList;
import java.util.List;

public class TypeVOFactory {
    public static TypeVO createTypeVOByTypePO(TypePO typePO) {
        TypeVO typeVO = new TypeVO();
        typeVO.setTypeId(typePO.getTypeId());
        typeVO.setTypeColor(typePO.getTypeColor());
        typeVO.setTypeModel(typePO.getTypeModel());
        typeVO.setTypeName(typePO.getTypeName());
        typeVO.setTypeSortValue(typePO.getSortValue());
        return typeVO;
    }

    public static List<TypeVO> createTypeVOListByTypePOList(List<TypePO> typePOList) {
        List<TypeVO> typeVOList = new ArrayList<>();
        for (TypePO typePO : typePOList) {
            typeVOList.add(TypeVOFactory.createTypeVOByTypePO(typePO));
        }
        return typeVOList;
    }
}
