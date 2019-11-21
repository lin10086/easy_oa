package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ScheduleUserPO;
import cn.gson.oasys.model.po.ScheduleUserPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ScheduleUserPOMapper {
    @SelectProvider(type=ScheduleUserPOSqlProvider.class, method="countByExample")
    long countByExample(ScheduleUserPOExample example);

    @DeleteProvider(type=ScheduleUserPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ScheduleUserPOExample example);

    @Delete({
        "delete from aoa_schedule_user",
        "where sche_user_id = #{scheUserId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long scheUserId);

    @Insert({
        "insert into aoa_schedule_user (rc_id, user_id)",
        "values (#{rcId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="scheUserId", before=false, resultType=Long.class)
    int insert(ScheduleUserPO record);

    @InsertProvider(type=ScheduleUserPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="scheUserId", before=false, resultType=Long.class)
    int insertSelective(ScheduleUserPO record);

    @SelectProvider(type=ScheduleUserPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="sche_user_id", property="scheUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="rc_id", property="rcId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<ScheduleUserPO> selectByExample(ScheduleUserPOExample example);

    @Select({
        "select",
        "sche_user_id, rc_id, user_id",
        "from aoa_schedule_user",
        "where sche_user_id = #{scheUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="sche_user_id", property="scheUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="rc_id", property="rcId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    ScheduleUserPO selectByPrimaryKey(Long scheUserId);

    @UpdateProvider(type=ScheduleUserPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ScheduleUserPO record, @Param("example") ScheduleUserPOExample example);

    @UpdateProvider(type=ScheduleUserPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ScheduleUserPO record, @Param("example") ScheduleUserPOExample example);

    @UpdateProvider(type=ScheduleUserPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ScheduleUserPO record);

    @Update({
        "update aoa_schedule_user",
        "set rc_id = #{rcId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where sche_user_id = #{scheUserId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ScheduleUserPO record);
}