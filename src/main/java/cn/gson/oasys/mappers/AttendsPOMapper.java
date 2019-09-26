package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.AttendsPO;
import cn.gson.oasys.model.po.AttendsPOExample;
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

public interface AttendsPOMapper {
    @SelectProvider(type=AttendsPOSqlProvider.class, method="countByExample")
    long countByExample(AttendsPOExample example);

    @DeleteProvider(type=AttendsPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(AttendsPOExample example);

    @Delete({
        "delete from aoa_attends_list",
        "where attends_id = #{attendsId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long attendsId);

    @Insert({
        "insert into aoa_attends_list (attends_ip, attends_remark, ",
        "attends_time, status_id, ",
        "type_id, attends_user_id, ",
        "attend_hmtime, week_ofday, ",
        "holiday_days, holiday_start)",
        "values (#{attendsIp,jdbcType=VARCHAR}, #{attendsRemark,jdbcType=VARCHAR}, ",
        "#{attendsTime,jdbcType=TIMESTAMP}, #{statusId,jdbcType=BIGINT}, ",
        "#{typeId,jdbcType=BIGINT}, #{attendsUserId,jdbcType=BIGINT}, ",
        "#{attendHmtime,jdbcType=VARCHAR}, #{weekOfday,jdbcType=VARCHAR}, ",
        "#{holidayDays,jdbcType=DOUBLE}, #{holidayStart,jdbcType=DATE})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="attendsId", before=false, resultType=Long.class)
    int insert(AttendsPO record);

    @InsertProvider(type=AttendsPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="attendsId", before=false, resultType=Long.class)
    int insertSelective(AttendsPO record);

    @SelectProvider(type=AttendsPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="attends_id", property="attendsId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="attends_ip", property="attendsIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="attends_remark", property="attendsRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="attends_time", property="attendsTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="attends_user_id", property="attendsUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="attend_hmtime", property="attendHmtime", jdbcType=JdbcType.VARCHAR),
        @Result(column="week_ofday", property="weekOfday", jdbcType=JdbcType.VARCHAR),
        @Result(column="holiday_days", property="holidayDays", jdbcType=JdbcType.DOUBLE),
        @Result(column="holiday_start", property="holidayStart", jdbcType=JdbcType.DATE)
    })
    List<AttendsPO> selectByExample(AttendsPOExample example);

    @Select({
        "select",
        "attends_id, attends_ip, attends_remark, attends_time, status_id, type_id, attends_user_id, ",
        "attend_hmtime, week_ofday, holiday_days, holiday_start",
        "from aoa_attends_list",
        "where attends_id = #{attendsId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="attends_id", property="attendsId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="attends_ip", property="attendsIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="attends_remark", property="attendsRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="attends_time", property="attendsTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="attends_user_id", property="attendsUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="attend_hmtime", property="attendHmtime", jdbcType=JdbcType.VARCHAR),
        @Result(column="week_ofday", property="weekOfday", jdbcType=JdbcType.VARCHAR),
        @Result(column="holiday_days", property="holidayDays", jdbcType=JdbcType.DOUBLE),
        @Result(column="holiday_start", property="holidayStart", jdbcType=JdbcType.DATE)
    })
    AttendsPO selectByPrimaryKey(Long attendsId);

    @UpdateProvider(type=AttendsPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AttendsPO record, @Param("example") AttendsPOExample example);

    @UpdateProvider(type=AttendsPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AttendsPO record, @Param("example") AttendsPOExample example);

    @UpdateProvider(type=AttendsPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AttendsPO record);

    @Update({
        "update aoa_attends_list",
        "set attends_ip = #{attendsIp,jdbcType=VARCHAR},",
          "attends_remark = #{attendsRemark,jdbcType=VARCHAR},",
          "attends_time = #{attendsTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "attends_user_id = #{attendsUserId,jdbcType=BIGINT},",
          "attend_hmtime = #{attendHmtime,jdbcType=VARCHAR},",
          "week_ofday = #{weekOfday,jdbcType=VARCHAR},",
          "holiday_days = #{holidayDays,jdbcType=DOUBLE},",
          "holiday_start = #{holidayStart,jdbcType=DATE}",
        "where attends_id = #{attendsId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AttendsPO record);
}