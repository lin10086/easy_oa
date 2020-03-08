package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.SchedulePO;
import cn.gson.oasys.modelV2.po.SchedulePOExample;
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

public interface SchedulePOMapper {
    @SelectProvider(type=SchedulePOSqlProvider.class, method="countByExample")
    long countByExample(SchedulePOExample example);

    @DeleteProvider(type=SchedulePOSqlProvider.class, method="deleteByExample")
    int deleteByExample(SchedulePOExample example);

    @Delete({
        "delete from aoa_schedule_list",
        "where rc_id = #{rcId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long rcId);

    @Insert({
        "insert into aoa_schedule_list (create_time, end_time, ",
        "filedescribe, is_remind, ",
        "start_time, status_id, ",
        "title, type_id, user_id, ",
        "miaoshu, isreminded)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{filedescribe,jdbcType=VARCHAR}, #{isRemind,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{statusId,jdbcType=BIGINT}, ",
        "#{title,jdbcType=VARCHAR}, #{typeId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{miaoshu,jdbcType=VARCHAR}, #{isreminded,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="rcId", before=false, resultType=Long.class)
    int insert(SchedulePO record);

    @InsertProvider(type=SchedulePOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="rcId", before=false, resultType=Long.class)
    int insertSelective(SchedulePO record);

    @SelectProvider(type=SchedulePOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="rc_id", property="rcId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="filedescribe", property="filedescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_remind", property="isRemind", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="miaoshu", property="miaoshu", jdbcType=JdbcType.VARCHAR),
        @Result(column="isreminded", property="isreminded", jdbcType=JdbcType.INTEGER)
    })
    List<SchedulePO> selectByExample(SchedulePOExample example);

    @Select({
        "select",
        "rc_id, create_time, end_time, filedescribe, is_remind, start_time, status_id, ",
        "title, type_id, user_id, miaoshu, isreminded",
        "from aoa_schedule_list",
        "where rc_id = #{rcId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="rc_id", property="rcId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="filedescribe", property="filedescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_remind", property="isRemind", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="miaoshu", property="miaoshu", jdbcType=JdbcType.VARCHAR),
        @Result(column="isreminded", property="isreminded", jdbcType=JdbcType.INTEGER)
    })
    SchedulePO selectByPrimaryKey(Long rcId);

    @UpdateProvider(type=SchedulePOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SchedulePO record, @Param("example") SchedulePOExample example);

    @UpdateProvider(type=SchedulePOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SchedulePO record, @Param("example") SchedulePOExample example);

    @UpdateProvider(type=SchedulePOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SchedulePO record);

    @Update({
        "update aoa_schedule_list",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "filedescribe = #{filedescribe,jdbcType=VARCHAR},",
          "is_remind = #{isRemind,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "miaoshu = #{miaoshu,jdbcType=VARCHAR},",
          "isreminded = #{isreminded,jdbcType=INTEGER}",
        "where rc_id = #{rcId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SchedulePO record);
}