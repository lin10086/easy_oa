package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.EvectionMoneyPO;
import cn.gson.oasys.model.po.EvectionMoneyPOExample;
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

public interface EvectionMoneyPOMapper {
    @SelectProvider(type=EvectionMoneyPOSqlProvider.class, method="countByExample")
    long countByExample(EvectionMoneyPOExample example);

    @DeleteProvider(type=EvectionMoneyPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(EvectionMoneyPOExample example);

    @Delete({
        "delete from aoa_evectionmoney",
        "where evectionmoney_id = #{evectionmoneyId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long evectionmoneyId);

    @Insert({
        "insert into aoa_evectionmoney (financial_advice, manager_advice, ",
        "money, name, pro_id, ",
        "pro)",
        "values (#{financialAdvice,jdbcType=VARCHAR}, #{managerAdvice,jdbcType=VARCHAR}, ",
        "#{money,jdbcType=DOUBLE}, #{name,jdbcType=VARCHAR}, #{proId,jdbcType=BIGINT}, ",
        "#{pro,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="evectionmoneyId", before=false, resultType=Long.class)
    int insert(EvectionMoneyPO record);

    @InsertProvider(type=EvectionMoneyPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="evectionmoneyId", before=false, resultType=Long.class)
    int insertSelective(EvectionMoneyPO record);

    @SelectProvider(type=EvectionMoneyPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="evectionmoney_id", property="evectionmoneyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="financial_advice", property="financialAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="money", property="money", jdbcType=JdbcType.DOUBLE),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro", property="pro", jdbcType=JdbcType.INTEGER)
    })
    List<EvectionMoneyPO> selectByExample(EvectionMoneyPOExample example);

    @Select({
        "select",
        "evectionmoney_id, financial_advice, manager_advice, money, name, pro_id, pro",
        "from aoa_evectionmoney",
        "where evectionmoney_id = #{evectionmoneyId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="evectionmoney_id", property="evectionmoneyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="financial_advice", property="financialAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="money", property="money", jdbcType=JdbcType.DOUBLE),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro", property="pro", jdbcType=JdbcType.INTEGER)
    })
    EvectionMoneyPO selectByPrimaryKey(Long evectionmoneyId);

    @UpdateProvider(type=EvectionMoneyPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EvectionMoneyPO record, @Param("example") EvectionMoneyPOExample example);

    @UpdateProvider(type=EvectionMoneyPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EvectionMoneyPO record, @Param("example") EvectionMoneyPOExample example);

    @UpdateProvider(type=EvectionMoneyPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EvectionMoneyPO record);

    @Update({
        "update aoa_evectionmoney",
        "set financial_advice = #{financialAdvice,jdbcType=VARCHAR},",
          "manager_advice = #{managerAdvice,jdbcType=VARCHAR},",
          "money = #{money,jdbcType=DOUBLE},",
          "name = #{name,jdbcType=VARCHAR},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "pro = #{pro,jdbcType=INTEGER}",
        "where evectionmoney_id = #{evectionmoneyId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EvectionMoneyPO record);
}