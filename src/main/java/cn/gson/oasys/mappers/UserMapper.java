package cn.gson.oasys.mappers;


import cn.gson.oasys.model.entity.UserEntity;
import cn.gson.oasys.model.entity.attendce.Attends;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMapper {
    // 根据上司ID查询下属用户（可能有多个）
    List<UserEntity>selectFatherUserIds(Integer fatherId);
    //根据用户信息查询用户信息
    UserEntity selectFatherUserId(Integer userId);


}
