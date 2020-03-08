package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.RolePO;
import cn.gson.oasys.modelV2.po.RolePOExample;
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

public interface RolePOMapper {
    @SelectProvider(type=RolePOSqlProvider.class, method="countByExample")
    long countByExample(RolePOExample example);

    @DeleteProvider(type=RolePOSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolePOExample example);

    @Delete({
        "delete from aoa_role_",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleId);

    @Insert({
        "insert into aoa_role_ (role_name, role_value)",
        "values (#{roleName,jdbcType=VARCHAR}, #{roleValue,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="roleId", before=false, resultType=Long.class)
    int insert(RolePO record);

    @InsertProvider(type=RolePOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="roleId", before=false, resultType=Long.class)
    int insertSelective(RolePO record);

    @SelectProvider(type=RolePOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_value", property="roleValue", jdbcType=JdbcType.INTEGER)
    })
    List<RolePO> selectByExample(RolePOExample example);

    @Select({
        "select",
        "role_id, role_name, role_value",
        "from aoa_role_",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_value", property="roleValue", jdbcType=JdbcType.INTEGER)
    })
    RolePO selectByPrimaryKey(Long roleId);

    @UpdateProvider(type=RolePOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolePO record, @Param("example") RolePOExample example);

    @UpdateProvider(type=RolePOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolePO record, @Param("example") RolePOExample example);

    @UpdateProvider(type=RolePOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolePO record);

    @Update({
        "update aoa_role_",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "role_value = #{roleValue,jdbcType=INTEGER}",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RolePO record);
}