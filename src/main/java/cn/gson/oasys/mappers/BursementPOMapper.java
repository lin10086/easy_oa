package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.BursementPO;
import cn.gson.oasys.model.po.BursementPOExample;
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

public interface BursementPOMapper {
    @SelectProvider(type=BursementPOSqlProvider.class, method="countByExample")
    long countByExample(BursementPOExample example);

    @DeleteProvider(type=BursementPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(BursementPOExample example);

    @Delete({
        "delete from aoa_bursement",
        "where bursement_id = #{bursementId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long bursementId);

    @Insert({
        "insert into aoa_bursement (all_money, allinvoices, ",
        "burse_time, financial_advice, ",
        "manager_advice, name, ",
        "type_id, operation_name, ",
        "pro_id, user_name)",
        "values (#{allMoney,jdbcType=DOUBLE}, #{allinvoices,jdbcType=INTEGER}, ",
        "#{burseTime,jdbcType=TIMESTAMP}, #{financialAdvice,jdbcType=VARCHAR}, ",
        "#{managerAdvice,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{typeId,jdbcType=BIGINT}, #{operationName,jdbcType=BIGINT}, ",
        "#{proId,jdbcType=BIGINT}, #{userName,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="bursementId", before=false, resultType=Long.class)
    int insert(BursementPO record);

    @InsertProvider(type=BursementPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="bursementId", before=false, resultType=Long.class)
    int insertSelective(BursementPO record);

    @SelectProvider(type=BursementPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="bursement_id", property="bursementId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="all_money", property="allMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="allinvoices", property="allinvoices", jdbcType=JdbcType.INTEGER),
        @Result(column="burse_time", property="burseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="financial_advice", property="financialAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="operation_name", property="operationName", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.BIGINT)
    })
    List<BursementPO> selectByExample(BursementPOExample example);

    @Select({
        "select",
        "bursement_id, all_money, allinvoices, burse_time, financial_advice, manager_advice, ",
        "name, type_id, operation_name, pro_id, user_name",
        "from aoa_bursement",
        "where bursement_id = #{bursementId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="bursement_id", property="bursementId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="all_money", property="allMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="allinvoices", property="allinvoices", jdbcType=JdbcType.INTEGER),
        @Result(column="burse_time", property="burseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="financial_advice", property="financialAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="operation_name", property="operationName", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.BIGINT)
    })
    BursementPO selectByPrimaryKey(Long bursementId);

    @UpdateProvider(type=BursementPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BursementPO record, @Param("example") BursementPOExample example);

    @UpdateProvider(type=BursementPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BursementPO record, @Param("example") BursementPOExample example);

    @UpdateProvider(type=BursementPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BursementPO record);

    @Update({
        "update aoa_bursement",
        "set all_money = #{allMoney,jdbcType=DOUBLE},",
          "allinvoices = #{allinvoices,jdbcType=INTEGER},",
          "burse_time = #{burseTime,jdbcType=TIMESTAMP},",
          "financial_advice = #{financialAdvice,jdbcType=VARCHAR},",
          "manager_advice = #{managerAdvice,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "operation_name = #{operationName,jdbcType=BIGINT},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "user_name = #{userName,jdbcType=BIGINT}",
        "where bursement_id = #{bursementId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BursementPO record);
}