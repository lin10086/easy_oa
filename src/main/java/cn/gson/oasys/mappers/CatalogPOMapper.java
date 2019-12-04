package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.CatalogPO;
import cn.gson.oasys.model.po.CatalogPOExample;
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

public interface CatalogPOMapper {
    @SelectProvider(type=CatalogPOSqlProvider.class, method="countByExample")
    long countByExample(CatalogPOExample example);

    @DeleteProvider(type=CatalogPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(CatalogPOExample example);

    @Delete({
        "delete from aoa_catalog",
        "where catalog_id = #{catalogId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long catalogId);

    @Insert({
        "insert into aoa_catalog (catalog_name, parent_id, ",
        "cata_user_id)",
        "values (#{catalogName,jdbcType=VARCHAR}, #{parentId,jdbcType=INTEGER}, ",
        "#{cataUserId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="catalogId", before=false, resultType=Long.class)
    int insert(CatalogPO record);

    @InsertProvider(type=CatalogPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="catalogId", before=false, resultType=Long.class)
    int insertSelective(CatalogPO record);

    @SelectProvider(type=CatalogPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="catalog_id", property="catalogId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="catalog_name", property="catalogName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="cata_user_id", property="cataUserId", jdbcType=JdbcType.BIGINT)
    })
    List<CatalogPO> selectByExample(CatalogPOExample example);

    @Select({
        "select",
        "catalog_id, catalog_name, parent_id, cata_user_id",
        "from aoa_catalog",
        "where catalog_id = #{catalogId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="catalog_id", property="catalogId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="catalog_name", property="catalogName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="cata_user_id", property="cataUserId", jdbcType=JdbcType.BIGINT)
    })
    CatalogPO selectByPrimaryKey(Long catalogId);

    @UpdateProvider(type=CatalogPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CatalogPO record, @Param("example") CatalogPOExample example);

    @UpdateProvider(type=CatalogPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CatalogPO record, @Param("example") CatalogPOExample example);

    @UpdateProvider(type=CatalogPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CatalogPO record);

    @Update({
        "update aoa_catalog",
        "set catalog_name = #{catalogName,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "cata_user_id = #{cataUserId,jdbcType=BIGINT}",
        "where catalog_id = #{catalogId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CatalogPO record);
}