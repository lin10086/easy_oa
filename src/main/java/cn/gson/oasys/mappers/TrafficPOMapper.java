package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.TrafficPO;
import cn.gson.oasys.modelV2.po.TrafficPOExample;
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

public interface TrafficPOMapper {
    @SelectProvider(type=TrafficPOSqlProvider.class, method="countByExample")
    long countByExample(TrafficPOExample example);

    @DeleteProvider(type=TrafficPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(TrafficPOExample example);

    @Delete({
        "delete from aoa_traffic",
        "where traffic_id = #{trafficId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long trafficId);

    @Insert({
        "insert into aoa_traffic (depart_name, depart_time, ",
        "reach_name, seat_type, ",
        "traffic_money, traffic_name, ",
        "evemoney_id, user_name)",
        "values (#{departName,jdbcType=VARCHAR}, #{departTime,jdbcType=TIMESTAMP}, ",
        "#{reachName,jdbcType=VARCHAR}, #{seatType,jdbcType=VARCHAR}, ",
        "#{trafficMoney,jdbcType=DOUBLE}, #{trafficName,jdbcType=VARCHAR}, ",
        "#{evemoneyId,jdbcType=BIGINT}, #{userName,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="trafficId", before=false, resultType=Long.class)
    int insert(TrafficPO record);

    @InsertProvider(type=TrafficPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="trafficId", before=false, resultType=Long.class)
    int insertSelective(TrafficPO record);

    @SelectProvider(type=TrafficPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="traffic_id", property="trafficId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="depart_name", property="departName", jdbcType=JdbcType.VARCHAR),
        @Result(column="depart_time", property="departTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reach_name", property="reachName", jdbcType=JdbcType.VARCHAR),
        @Result(column="seat_type", property="seatType", jdbcType=JdbcType.VARCHAR),
        @Result(column="traffic_money", property="trafficMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="traffic_name", property="trafficName", jdbcType=JdbcType.VARCHAR),
        @Result(column="evemoney_id", property="evemoneyId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.BIGINT)
    })
    List<TrafficPO> selectByExample(TrafficPOExample example);

    @Select({
        "select",
        "traffic_id, depart_name, depart_time, reach_name, seat_type, traffic_money, ",
        "traffic_name, evemoney_id, user_name",
        "from aoa_traffic",
        "where traffic_id = #{trafficId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="traffic_id", property="trafficId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="depart_name", property="departName", jdbcType=JdbcType.VARCHAR),
        @Result(column="depart_time", property="departTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reach_name", property="reachName", jdbcType=JdbcType.VARCHAR),
        @Result(column="seat_type", property="seatType", jdbcType=JdbcType.VARCHAR),
        @Result(column="traffic_money", property="trafficMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="traffic_name", property="trafficName", jdbcType=JdbcType.VARCHAR),
        @Result(column="evemoney_id", property="evemoneyId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.BIGINT)
    })
    TrafficPO selectByPrimaryKey(Long trafficId);

    @UpdateProvider(type=TrafficPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TrafficPO record, @Param("example") TrafficPOExample example);

    @UpdateProvider(type=TrafficPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TrafficPO record, @Param("example") TrafficPOExample example);

    @UpdateProvider(type=TrafficPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TrafficPO record);

    @Update({
        "update aoa_traffic",
        "set depart_name = #{departName,jdbcType=VARCHAR},",
          "depart_time = #{departTime,jdbcType=TIMESTAMP},",
          "reach_name = #{reachName,jdbcType=VARCHAR},",
          "seat_type = #{seatType,jdbcType=VARCHAR},",
          "traffic_money = #{trafficMoney,jdbcType=DOUBLE},",
          "traffic_name = #{trafficName,jdbcType=VARCHAR},",
          "evemoney_id = #{evemoneyId,jdbcType=BIGINT},",
          "user_name = #{userName,jdbcType=BIGINT}",
        "where traffic_id = #{trafficId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TrafficPO record);
}