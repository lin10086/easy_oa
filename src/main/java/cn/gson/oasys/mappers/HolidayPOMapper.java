package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.HolidayPO;
import cn.gson.oasys.model.po.HolidayPOExample;
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

public interface HolidayPOMapper {
    @SelectProvider(type=HolidayPOSqlProvider.class, method="countByExample")
    long countByExample(HolidayPOExample example);

    @DeleteProvider(type=HolidayPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(HolidayPOExample example);

    @Delete({
        "delete from aoa_holiday",
        "where holiday_id = #{holidayId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long holidayId);

    @Insert({
        "insert into aoa_holiday (leave_days, type_id, ",
        "pro_id, manager_advice, ",
        "personnel_advice)",
        "values (#{leaveDays,jdbcType=INTEGER}, #{typeId,jdbcType=BIGINT}, ",
        "#{proId,jdbcType=BIGINT}, #{managerAdvice,jdbcType=VARCHAR}, ",
        "#{personnelAdvice,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="holidayId", before=false, resultType=Long.class)
    int insert(HolidayPO record);

    @InsertProvider(type=HolidayPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="holidayId", before=false, resultType=Long.class)
    int insertSelective(HolidayPO record);

    @SelectProvider(type=HolidayPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="holiday_id", property="holidayId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="leave_days", property="leaveDays", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR)
    })
    List<HolidayPO> selectByExample(HolidayPOExample example);

    @Select({
        "select",
        "holiday_id, leave_days, type_id, pro_id, manager_advice, personnel_advice",
        "from aoa_holiday",
        "where holiday_id = #{holidayId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="holiday_id", property="holidayId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="leave_days", property="leaveDays", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR)
    })
    HolidayPO selectByPrimaryKey(Long holidayId);

    @UpdateProvider(type=HolidayPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HolidayPO record, @Param("example") HolidayPOExample example);

    @UpdateProvider(type=HolidayPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HolidayPO record, @Param("example") HolidayPOExample example);

    @UpdateProvider(type=HolidayPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HolidayPO record);

    @Update({
        "update aoa_holiday",
        "set leave_days = #{leaveDays,jdbcType=INTEGER},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "manager_advice = #{managerAdvice,jdbcType=VARCHAR},",
          "personnel_advice = #{personnelAdvice,jdbcType=VARCHAR}",
        "where holiday_id = #{holidayId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HolidayPO record);
}