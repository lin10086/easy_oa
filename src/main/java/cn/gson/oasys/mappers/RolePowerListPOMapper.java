package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.RolePowerListPO;
import cn.gson.oasys.modelV2.po.RolePowerListPOExample;
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

public interface RolePowerListPOMapper {
    @SelectProvider(type=RolePowerListPOSqlProvider.class, method="countByExample")
    long countByExample(RolePowerListPOExample example);

    @DeleteProvider(type=RolePowerListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolePowerListPOExample example);

    @Delete({
        "delete from aoa_role_power_list",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long pkId);

    @Insert({
        "insert into aoa_role_power_list (is_show, menu_id, ",
        "role_id)",
        "values (#{isShow,jdbcType=INTEGER}, #{menuId,jdbcType=BIGINT}, ",
        "#{roleId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pkId", before=false, resultType=Long.class)
    int insert(RolePowerListPO record);

    @InsertProvider(type=RolePowerListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pkId", before=false, resultType=Long.class)
    int insertSelective(RolePowerListPO record);

    @SelectProvider(type=RolePowerListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="pk_id", property="pkId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT)
    })
    List<RolePowerListPO> selectByExample(RolePowerListPOExample example);

    @Select({
        "select",
        "pk_id, is_show, menu_id, role_id",
        "from aoa_role_power_list",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="pk_id", property="pkId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT)
    })
    RolePowerListPO selectByPrimaryKey(Long pkId);

    @UpdateProvider(type=RolePowerListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolePowerListPO record, @Param("example") RolePowerListPOExample example);

    @UpdateProvider(type=RolePowerListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolePowerListPO record, @Param("example") RolePowerListPOExample example);

    @UpdateProvider(type=RolePowerListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolePowerListPO record);

    @Update({
        "update aoa_role_power_list",
        "set is_show = #{isShow,jdbcType=INTEGER},",
          "menu_id = #{menuId,jdbcType=BIGINT},",
          "role_id = #{roleId,jdbcType=BIGINT}",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RolePowerListPO record);
}