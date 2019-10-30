package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.OvertimePO;
import cn.gson.oasys.model.po.OvertimePOExample;
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

public interface OvertimePOMapper {
    @SelectProvider(type=OvertimePOSqlProvider.class, method="countByExample")
    long countByExample(OvertimePOExample example);

    @DeleteProvider(type=OvertimePOSqlProvider.class, method="deleteByExample")
    int deleteByExample(OvertimePOExample example);

    @Delete({
        "delete from aoa_overtime",
        "where overtime_id = #{overtimeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long overtimeId);

    @Insert({
        "insert into aoa_overtime (type_id, pro_id, ",
        "personnel_advice, manager_advice)",
        "values (#{typeId,jdbcType=BIGINT}, #{proId,jdbcType=BIGINT}, ",
        "#{personnelAdvice,jdbcType=VARCHAR}, #{managerAdvice,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="overtimeId", before=false, resultType=Long.class)
    int insert(OvertimePO record);

    @InsertProvider(type=OvertimePOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="overtimeId", before=false, resultType=Long.class)
    int insertSelective(OvertimePO record);

    @SelectProvider(type=OvertimePOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="overtime_id", property="overtimeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR)
    })
    List<OvertimePO> selectByExample(OvertimePOExample example);

    @Select({
        "select",
        "overtime_id, type_id, pro_id, personnel_advice, manager_advice",
        "from aoa_overtime",
        "where overtime_id = #{overtimeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="overtime_id", property="overtimeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR)
    })
    OvertimePO selectByPrimaryKey(Long overtimeId);

    @UpdateProvider(type=OvertimePOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OvertimePO record, @Param("example") OvertimePOExample example);

    @UpdateProvider(type=OvertimePOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OvertimePO record, @Param("example") OvertimePOExample example);

    @UpdateProvider(type=OvertimePOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OvertimePO record);

    @Update({
        "update aoa_overtime",
        "set type_id = #{typeId,jdbcType=BIGINT},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "personnel_advice = #{personnelAdvice,jdbcType=VARCHAR},",
          "manager_advice = #{managerAdvice,jdbcType=VARCHAR}",
        "where overtime_id = #{overtimeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OvertimePO record);
}