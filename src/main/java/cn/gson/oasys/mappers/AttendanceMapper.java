package cn.gson.oasys.mappers;


import cn.gson.oasys.model.entity.AttendanceEntity;
import cn.gson.oasys.model.entity.UserEntity;

import java.util.List;

public interface AttendanceMapper {
    // 根据 用户们的ID查询用户们的资料
    List<AttendanceEntity>selectUserIds(List<Integer>ids);
    List<AttendanceEntity>selectUserId(Integer userId);
}
