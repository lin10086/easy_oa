package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.SysMenuPO;
import cn.gson.oasys.model.po.SysMenuPOExample;
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

public interface SysMenuPOMapper {
    @SelectProvider(type=SysMenuPOSqlProvider.class, method="countByExample")
    long countByExample(SysMenuPOExample example);

    @DeleteProvider(type=SysMenuPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMenuPOExample example);

    @Delete({
        "delete from aoa_sys_menu",
        "where menu_id = #{menuId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long menuId);

    @Insert({
        "insert into aoa_sys_menu (is_show, menu_grade, ",
        "menu_icon, menu_name, ",
        "menu_url, parent_id, ",
        "sort_id)",
        "values (#{isShow,jdbcType=INTEGER}, #{menuGrade,jdbcType=INTEGER}, ",
        "#{menuIcon,jdbcType=VARCHAR}, #{menuName,jdbcType=VARCHAR}, ",
        "#{menuUrl,jdbcType=VARCHAR}, #{parentId,jdbcType=BIGINT}, ",
        "#{sortId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="menuId", before=false, resultType=Long.class)
    int insert(SysMenuPO record);

    @InsertProvider(type=SysMenuPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="menuId", before=false, resultType=Long.class)
    int insertSelective(SysMenuPO record);

    @SelectProvider(type=SysMenuPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_grade", property="menuGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_icon", property="menuIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_url", property="menuUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="sort_id", property="sortId", jdbcType=JdbcType.INTEGER)
    })
    List<SysMenuPO> selectByExample(SysMenuPOExample example);

    @Select({
        "select",
        "menu_id, is_show, menu_grade, menu_icon, menu_name, menu_url, parent_id, sort_id",
        "from aoa_sys_menu",
        "where menu_id = #{menuId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_grade", property="menuGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_icon", property="menuIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_url", property="menuUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="sort_id", property="sortId", jdbcType=JdbcType.INTEGER)
    })
    SysMenuPO selectByPrimaryKey(Long menuId);

    @UpdateProvider(type=SysMenuPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMenuPO record, @Param("example") SysMenuPOExample example);

    @UpdateProvider(type=SysMenuPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMenuPO record, @Param("example") SysMenuPOExample example);

    @UpdateProvider(type=SysMenuPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMenuPO record);

    @Update({
        "update aoa_sys_menu",
        "set is_show = #{isShow,jdbcType=INTEGER},",
          "menu_grade = #{menuGrade,jdbcType=INTEGER},",
          "menu_icon = #{menuIcon,jdbcType=VARCHAR},",
          "menu_name = #{menuName,jdbcType=VARCHAR},",
          "menu_url = #{menuUrl,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT},",
          "sort_id = #{sortId,jdbcType=INTEGER}",
        "where menu_id = #{menuId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysMenuPO record);
}