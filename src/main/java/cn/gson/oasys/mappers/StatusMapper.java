package cn.gson.oasys.mappers;


import cn.gson.oasys.model.entity.AttendanceEntity;
import cn.gson.oasys.model.entity.StatusEntity;

import java.util.List;

public interface StatusMapper {
    StatusEntity selectStatusId(Integer statusId);
    List<StatusEntity>selectStatusModel(String statusModel);

}
