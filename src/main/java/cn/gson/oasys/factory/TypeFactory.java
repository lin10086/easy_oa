package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.model.po.UserPO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeFactory {

    public static SystemTypeList create(TypePO typePO) {
        SystemTypeList systemTypeList = new SystemTypeList();
        systemTypeList.setTypeId(typePO.getTypeId());
        systemTypeList.setTypeColor(typePO.getTypeColor());
        systemTypeList.setTypeModel(typePO.getTypeModel());
        systemTypeList.setTypeName(typePO.getTypeName());
        systemTypeList.setTypeSortValue(typePO.getSortValue());
        return systemTypeList;
    }

    public static List<SystemTypeList> createTypes(List<TypePO> typePOList) {
        List<SystemTypeList> systemTypeLists = new ArrayList<>();
        for (TypePO typePO : typePOList) {
            systemTypeLists.add(TypeFactory.create(typePO));
        }
        return systemTypeLists;
    }
}
