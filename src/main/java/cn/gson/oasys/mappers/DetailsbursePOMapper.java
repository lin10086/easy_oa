package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.DetailsbursePO;
import cn.gson.oasys.modelV2.po.DetailsbursePOExample;
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

public interface DetailsbursePOMapper {
    @SelectProvider(type=DetailsbursePOSqlProvider.class, method="countByExample")
    long countByExample(DetailsbursePOExample example);

    @DeleteProvider(type=DetailsbursePOSqlProvider.class, method="deleteByExample")
    int deleteByExample(DetailsbursePOExample example);

    @Delete({
        "delete from aoa_detailsburse",
        "where detailsburse_id = #{detailsburseId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long detailsburseId);

    @Insert({
        "insert into aoa_detailsburse (descript, detailmoney, ",
        "invoices, produce_time, ",
        "subject, bursment_id)",
        "values (#{descript,jdbcType=VARCHAR}, #{detailmoney,jdbcType=DOUBLE}, ",
        "#{invoices,jdbcType=INTEGER}, #{produceTime,jdbcType=TIMESTAMP}, ",
        "#{subject,jdbcType=VARCHAR}, #{bursmentId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="detailsburseId", before=false, resultType=Long.class)
    int insert(DetailsbursePO record);

    @InsertProvider(type=DetailsbursePOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="detailsburseId", before=false, resultType=Long.class)
    int insertSelective(DetailsbursePO record);

    @SelectProvider(type=DetailsbursePOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="detailsburse_id", property="detailsburseId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="descript", property="descript", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailmoney", property="detailmoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="invoices", property="invoices", jdbcType=JdbcType.INTEGER),
        @Result(column="produce_time", property="produceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="bursment_id", property="bursmentId", jdbcType=JdbcType.BIGINT)
    })
    List<DetailsbursePO> selectByExample(DetailsbursePOExample example);

    @Select({
        "select",
        "detailsburse_id, descript, detailmoney, invoices, produce_time, subject, bursment_id",
        "from aoa_detailsburse",
        "where detailsburse_id = #{detailsburseId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="detailsburse_id", property="detailsburseId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="descript", property="descript", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailmoney", property="detailmoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="invoices", property="invoices", jdbcType=JdbcType.INTEGER),
        @Result(column="produce_time", property="produceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="bursment_id", property="bursmentId", jdbcType=JdbcType.BIGINT)
    })
    DetailsbursePO selectByPrimaryKey(Long detailsburseId);

    @UpdateProvider(type=DetailsbursePOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DetailsbursePO record, @Param("example") DetailsbursePOExample example);

    @UpdateProvider(type=DetailsbursePOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DetailsbursePO record, @Param("example") DetailsbursePOExample example);

    @UpdateProvider(type=DetailsbursePOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DetailsbursePO record);

    @Update({
        "update aoa_detailsburse",
        "set descript = #{descript,jdbcType=VARCHAR},",
          "detailmoney = #{detailmoney,jdbcType=DOUBLE},",
          "invoices = #{invoices,jdbcType=INTEGER},",
          "produce_time = #{produceTime,jdbcType=TIMESTAMP},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "bursment_id = #{bursmentId,jdbcType=BIGINT}",
        "where detailsburse_id = #{detailsburseId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DetailsbursePO record);
}