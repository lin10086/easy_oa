package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.model.po.TypePOExample;
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

public interface TypePOMapper {
    @SelectProvider(type=TypePOSqlProvider.class, method="countByExample")
    long countByExample(TypePOExample example);

    @DeleteProvider(type=TypePOSqlProvider.class, method="deleteByExample")
    int deleteByExample(TypePOExample example);

    @Delete({
        "delete from aoa_type_list",
        "where type_id = #{typeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long typeId);

    @Insert({
        "insert into aoa_type_list (type_color, type_model, ",
        "type_name, sort_value)",
        "values (#{typeColor,jdbcType=VARCHAR}, #{typeModel,jdbcType=VARCHAR}, ",
        "#{typeName,jdbcType=VARCHAR}, #{sortValue,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="typeId", before=false, resultType=Long.class)
    int insert(TypePO record);

    @InsertProvider(type=TypePOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="typeId", before=false, resultType=Long.class)
    int insertSelective(TypePO record);

    @SelectProvider(type=TypePOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_color", property="typeColor", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_model", property="typeModel", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_value", property="sortValue", jdbcType=JdbcType.INTEGER)
    })
    List<TypePO> selectByExample(TypePOExample example);

    @Select({
        "select",
        "type_id, type_color, type_model, type_name, sort_value",
        "from aoa_type_list",
        "where type_id = #{typeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type_color", property="typeColor", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_model", property="typeModel", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_value", property="sortValue", jdbcType=JdbcType.INTEGER)
    })
    TypePO selectByPrimaryKey(Long typeId);

    @UpdateProvider(type=TypePOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TypePO record, @Param("example") TypePOExample example);

    @UpdateProvider(type=TypePOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TypePO record, @Param("example") TypePOExample example);

    @UpdateProvider(type=TypePOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TypePO record);

    @Update({
        "update aoa_type_list",
        "set type_color = #{typeColor,jdbcType=VARCHAR},",
          "type_model = #{typeModel,jdbcType=VARCHAR},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "sort_value = #{sortValue,jdbcType=INTEGER}",
        "where type_id = #{typeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TypePO record);
}