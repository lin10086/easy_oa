package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.StayPO;
import cn.gson.oasys.model.po.StayPOExample;
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

public interface StayPOMapper {
    @SelectProvider(type=StayPOSqlProvider.class, method="countByExample")
    long countByExample(StayPOExample example);

    @DeleteProvider(type=StayPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(StayPOExample example);

    @Delete({
        "delete from aoa_stay",
        "where stay_id = #{stayId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long stayId);

    @Insert({
        "insert into aoa_stay (day, hotel_name, ",
        "leave_time, stay_city, ",
        "stay_money, stay_time, ",
        "evemoney_id, user_name)",
        "values (#{day,jdbcType=INTEGER}, #{hotelName,jdbcType=VARCHAR}, ",
        "#{leaveTime,jdbcType=TIMESTAMP}, #{stayCity,jdbcType=VARCHAR}, ",
        "#{stayMoney,jdbcType=DOUBLE}, #{stayTime,jdbcType=TIMESTAMP}, ",
        "#{evemoneyId,jdbcType=BIGINT}, #{userName,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="stayId", before=false, resultType=Long.class)
    int insert(StayPO record);

    @InsertProvider(type=StayPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="stayId", before=false, resultType=Long.class)
    int insertSelective(StayPO record);

    @SelectProvider(type=StayPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="stay_id", property="stayId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="day", property="day", jdbcType=JdbcType.INTEGER),
        @Result(column="hotel_name", property="hotelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="leave_time", property="leaveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stay_city", property="stayCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="stay_money", property="stayMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="stay_time", property="stayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="evemoney_id", property="evemoneyId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.BIGINT)
    })
    List<StayPO> selectByExample(StayPOExample example);

    @Select({
        "select",
        "stay_id, day, hotel_name, leave_time, stay_city, stay_money, stay_time, evemoney_id, ",
        "user_name",
        "from aoa_stay",
        "where stay_id = #{stayId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="stay_id", property="stayId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="day", property="day", jdbcType=JdbcType.INTEGER),
        @Result(column="hotel_name", property="hotelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="leave_time", property="leaveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stay_city", property="stayCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="stay_money", property="stayMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="stay_time", property="stayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="evemoney_id", property="evemoneyId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.BIGINT)
    })
    StayPO selectByPrimaryKey(Long stayId);

    @UpdateProvider(type=StayPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StayPO record, @Param("example") StayPOExample example);

    @UpdateProvider(type=StayPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StayPO record, @Param("example") StayPOExample example);

    @UpdateProvider(type=StayPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StayPO record);

    @Update({
        "update aoa_stay",
        "set day = #{day,jdbcType=INTEGER},",
          "hotel_name = #{hotelName,jdbcType=VARCHAR},",
          "leave_time = #{leaveTime,jdbcType=TIMESTAMP},",
          "stay_city = #{stayCity,jdbcType=VARCHAR},",
          "stay_money = #{stayMoney,jdbcType=DOUBLE},",
          "stay_time = #{stayTime,jdbcType=TIMESTAMP},",
          "evemoney_id = #{evemoneyId,jdbcType=BIGINT},",
          "user_name = #{userName,jdbcType=BIGINT}",
        "where stay_id = #{stayId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StayPO record);
}