package cn.gson.oasys.mappers;

import cn.gson.oasys.model.entity.TypeEntity;

import java.util.List;

public interface TypeMapper {
    TypeEntity selectTypeId(Integer typeId);
    List<TypeEntity> selectTypeModel(String typeModel);
}
