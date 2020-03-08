package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.RegularPO;
import cn.gson.oasys.modelV2.po.RegularPOExample;
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

public interface RegularPOMapper {
    @SelectProvider(type=RegularPOSqlProvider.class, method="countByExample")
    long countByExample(RegularPOExample example);

    @DeleteProvider(type=RegularPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(RegularPOExample example);

    @Delete({
        "delete from aoa_regular",
        "where regular_id = #{regularId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long regularId);

    @Insert({
        "insert into aoa_regular (advice, deficiency, ",
        "dobetter, experience, ",
        "personnel_advice, pullulate, ",
        "understand, pro_id, ",
        "manager_advice, days)",
        "values (#{advice,jdbcType=VARCHAR}, #{deficiency,jdbcType=VARCHAR}, ",
        "#{dobetter,jdbcType=VARCHAR}, #{experience,jdbcType=VARCHAR}, ",
        "#{personnelAdvice,jdbcType=VARCHAR}, #{pullulate,jdbcType=VARCHAR}, ",
        "#{understand,jdbcType=VARCHAR}, #{proId,jdbcType=BIGINT}, ",
        "#{managerAdvice,jdbcType=VARCHAR}, #{days,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="regularId", before=false, resultType=Long.class)
    int insert(RegularPO record);

    @InsertProvider(type=RegularPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="regularId", before=false, resultType=Long.class)
    int insertSelective(RegularPO record);

    @SelectProvider(type=RegularPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="regular_id", property="regularId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="advice", property="advice", jdbcType=JdbcType.VARCHAR),
        @Result(column="deficiency", property="deficiency", jdbcType=JdbcType.VARCHAR),
        @Result(column="dobetter", property="dobetter", jdbcType=JdbcType.VARCHAR),
        @Result(column="experience", property="experience", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="pullulate", property="pullulate", jdbcType=JdbcType.VARCHAR),
        @Result(column="understand", property="understand", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="days", property="days", jdbcType=JdbcType.INTEGER)
    })
    List<RegularPO> selectByExample(RegularPOExample example);

    @Select({
        "select",
        "regular_id, advice, deficiency, dobetter, experience, personnel_advice, pullulate, ",
        "understand, pro_id, manager_advice, days",
        "from aoa_regular",
        "where regular_id = #{regularId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="regular_id", property="regularId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="advice", property="advice", jdbcType=JdbcType.VARCHAR),
        @Result(column="deficiency", property="deficiency", jdbcType=JdbcType.VARCHAR),
        @Result(column="dobetter", property="dobetter", jdbcType=JdbcType.VARCHAR),
        @Result(column="experience", property="experience", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="pullulate", property="pullulate", jdbcType=JdbcType.VARCHAR),
        @Result(column="understand", property="understand", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="days", property="days", jdbcType=JdbcType.INTEGER)
    })
    RegularPO selectByPrimaryKey(Long regularId);

    @UpdateProvider(type=RegularPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RegularPO record, @Param("example") RegularPOExample example);

    @UpdateProvider(type=RegularPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RegularPO record, @Param("example") RegularPOExample example);

    @UpdateProvider(type=RegularPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RegularPO record);

    @Update({
        "update aoa_regular",
        "set advice = #{advice,jdbcType=VARCHAR},",
          "deficiency = #{deficiency,jdbcType=VARCHAR},",
          "dobetter = #{dobetter,jdbcType=VARCHAR},",
          "experience = #{experience,jdbcType=VARCHAR},",
          "personnel_advice = #{personnelAdvice,jdbcType=VARCHAR},",
          "pullulate = #{pullulate,jdbcType=VARCHAR},",
          "understand = #{understand,jdbcType=VARCHAR},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "manager_advice = #{managerAdvice,jdbcType=VARCHAR},",
          "days = #{days,jdbcType=INTEGER}",
        "where regular_id = #{regularId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RegularPO record);
}