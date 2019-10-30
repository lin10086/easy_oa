package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.EvectionPO;
import cn.gson.oasys.model.po.EvectionPOExample;
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

public interface EvectionPOMapper {
    @SelectProvider(type=EvectionPOSqlProvider.class, method="countByExample")
    long countByExample(EvectionPOExample example);

    @DeleteProvider(type=EvectionPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(EvectionPOExample example);

    @Delete({
        "delete from aoa_evection",
        "where evection_id = #{evectionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long evectionId);

    @Insert({
        "insert into aoa_evection (type_id, pro_id, ",
        "personnel_advice, manager_advice)",
        "values (#{typeId,jdbcType=BIGINT}, #{proId,jdbcType=BIGINT}, ",
        "#{personnelAdvice,jdbcType=VARCHAR}, #{managerAdvice,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="evectionId", before=false, resultType=Long.class)
    int insert(EvectionPO record);

    @InsertProvider(type=EvectionPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="evectionId", before=false, resultType=Long.class)
    int insertSelective(EvectionPO record);

    @SelectProvider(type=EvectionPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="evection_id", property="evectionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR)
    })
    List<EvectionPO> selectByExample(EvectionPOExample example);

    @Select({
        "select",
        "evection_id, type_id, pro_id, personnel_advice, manager_advice",
        "from aoa_evection",
        "where evection_id = #{evectionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="evection_id", property="evectionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR)
    })
    EvectionPO selectByPrimaryKey(Long evectionId);

    @UpdateProvider(type=EvectionPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EvectionPO record, @Param("example") EvectionPOExample example);

    @UpdateProvider(type=EvectionPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EvectionPO record, @Param("example") EvectionPOExample example);

    @UpdateProvider(type=EvectionPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EvectionPO record);

    @Update({
        "update aoa_evection",
        "set type_id = #{typeId,jdbcType=BIGINT},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "personnel_advice = #{personnelAdvice,jdbcType=VARCHAR},",
          "manager_advice = #{managerAdvice,jdbcType=VARCHAR}",
        "where evection_id = #{evectionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EvectionPO record);
}