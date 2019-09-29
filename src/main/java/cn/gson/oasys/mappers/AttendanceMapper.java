package cn.gson.oasys.mappers;


import cn.gson.oasys.model.entity.AttendanceEntity;
import cn.gson.oasys.model.entity.UserEntity;
import cn.gson.oasys.model.entity.attendce.Attends;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceMapper {
    // 根据 用户们的ID查询用户们的考勤资料
    List<AttendanceEntity>selectUserIds(List<Integer>ids);
    //根据用户ID查询用户考勤资料
    List<AttendanceEntity>selectUserId(Integer userId);

    Page<AttendanceEntity> selectByUserOrderByTypeIdDesc(@Param("ids") List<Integer>ids,Pageable pa);
    Page<AttendanceEntity> selectByUserOrderByTypeIdAsc(@Param("ids") List<Integer>ids,Pageable pa);
}
