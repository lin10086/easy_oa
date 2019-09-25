package cn.gson.oasys.mappers;


import cn.gson.oasys.model.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    // 根据上司ID查询下属用户（可能有多个）
    List<UserEntity>selectFatherUserId(Integer fatherId);
}
