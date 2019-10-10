package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.PositionPOExample;
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

public interface PositionPOMapper {
    @SelectProvider(type=PositionPOSqlProvider.class, method="countByExample")
    long countByExample(PositionPOExample example);

    @DeleteProvider(type=PositionPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(PositionPOExample example);

    @Delete({
        "delete from aoa_position",
        "where position_id = #{positionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long positionId);

    @Insert({
        "insert into aoa_position (level, name, ",
        "describtion, deptid)",
        "values (#{level,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{describtion,jdbcType=VARCHAR}, #{deptid,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="positionId", before=false, resultType=Long.class)
    int insert(PositionPO record);

    @InsertProvider(type=PositionPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="positionId", before=false, resultType=Long.class)
    int insertSelective(PositionPO record);

    @SelectProvider(type=PositionPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="position_id", property="positionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="describtion", property="describtion", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.BIGINT)
    })
    List<PositionPO> selectByExample(PositionPOExample example);

    @Select({
        "select",
        "position_id, level, name, describtion, deptid",
        "from aoa_position",
        "where position_id = #{positionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="position_id", property="positionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="describtion", property="describtion", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.BIGINT)
    })
    PositionPO selectByPrimaryKey(Long positionId);

    @UpdateProvider(type=PositionPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PositionPO record, @Param("example") PositionPOExample example);

    @UpdateProvider(type=PositionPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PositionPO record, @Param("example") PositionPOExample example);

    @UpdateProvider(type=PositionPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PositionPO record);

    @Update({
        "update aoa_position",
        "set level = #{level,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "describtion = #{describtion,jdbcType=VARCHAR},",
          "deptid = #{deptid,jdbcType=BIGINT}",
        "where position_id = #{positionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PositionPO record);
}