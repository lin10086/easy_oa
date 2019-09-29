package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.StatusPO;
import cn.gson.oasys.model.po.StatusPOExample;
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

public interface StatusPOMapper {
    @SelectProvider(type=StatusPOSqlProvider.class, method="countByExample")
    long countByExample(StatusPOExample example);

    @DeleteProvider(type=StatusPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatusPOExample example);

    @Delete({
        "delete from aoa_status_list",
        "where status_id = #{statusId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long statusId);

    @Insert({
        "insert into aoa_status_list (status_color, status_model, ",
        "status_name, sort_value, ",
        "sort_precent)",
        "values (#{statusColor,jdbcType=VARCHAR}, #{statusModel,jdbcType=VARCHAR}, ",
        "#{statusName,jdbcType=VARCHAR}, #{sortValue,jdbcType=INTEGER}, ",
        "#{sortPrecent,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="statusId", before=false, resultType=Long.class)
    int insert(StatusPO record);

    @InsertProvider(type=StatusPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="statusId", before=false, resultType=Long.class)
    int insertSelective(StatusPO record);

    @SelectProvider(type=StatusPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status_color", property="statusColor", jdbcType=JdbcType.VARCHAR),
        @Result(column="status_model", property="statusModel", jdbcType=JdbcType.VARCHAR),
        @Result(column="status_name", property="statusName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_value", property="sortValue", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_precent", property="sortPrecent", jdbcType=JdbcType.VARCHAR)
    })
    List<StatusPO> selectByExample(StatusPOExample example);

    @Select({
        "select",
        "status_id, status_color, status_model, status_name, sort_value, sort_precent",
        "from aoa_status_list",
        "where status_id = #{statusId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status_color", property="statusColor", jdbcType=JdbcType.VARCHAR),
        @Result(column="status_model", property="statusModel", jdbcType=JdbcType.VARCHAR),
        @Result(column="status_name", property="statusName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort_value", property="sortValue", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_precent", property="sortPrecent", jdbcType=JdbcType.VARCHAR)
    })
    StatusPO selectByPrimaryKey(Long statusId);

    @UpdateProvider(type=StatusPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatusPO record, @Param("example") StatusPOExample example);

    @UpdateProvider(type=StatusPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatusPO record, @Param("example") StatusPOExample example);

    @UpdateProvider(type=StatusPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatusPO record);

    @Update({
        "update aoa_status_list",
        "set status_color = #{statusColor,jdbcType=VARCHAR},",
          "status_model = #{statusModel,jdbcType=VARCHAR},",
          "status_name = #{statusName,jdbcType=VARCHAR},",
          "sort_value = #{sortValue,jdbcType=INTEGER},",
          "sort_precent = #{sortPrecent,jdbcType=VARCHAR}",
        "where status_id = #{statusId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatusPO record);
}