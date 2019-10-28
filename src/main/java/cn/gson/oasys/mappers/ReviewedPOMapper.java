package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ReviewedPO;
import cn.gson.oasys.model.po.ReviewedPOExample;
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

public interface ReviewedPOMapper {
    @SelectProvider(type=ReviewedPOSqlProvider.class, method="countByExample")
    long countByExample(ReviewedPOExample example);

    @DeleteProvider(type=ReviewedPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReviewedPOExample example);

    @Delete({
        "delete from aoa_reviewed",
        "where reviewed_id = #{reviewedId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long reviewedId);

    @Insert({
        "insert into aoa_reviewed (advice, reviewed_time, ",
        "status_id, pro_id, user_id, ",
        "del)",
        "values (#{advice,jdbcType=VARCHAR}, #{reviewedTime,jdbcType=TIMESTAMP}, ",
        "#{statusId,jdbcType=BIGINT}, #{proId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{del,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="reviewedId", before=false, resultType=Long.class)
    int insert(ReviewedPO record);

    @InsertProvider(type=ReviewedPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="reviewedId", before=false, resultType=Long.class)
    int insertSelective(ReviewedPO record);

    @SelectProvider(type=ReviewedPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="reviewed_id", property="reviewedId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="advice", property="advice", jdbcType=JdbcType.VARCHAR),
        @Result(column="reviewed_time", property="reviewedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="del", property="del", jdbcType=JdbcType.INTEGER)
    })
    List<ReviewedPO> selectByExample(ReviewedPOExample example);

    @Select({
        "select",
        "reviewed_id, advice, reviewed_time, status_id, pro_id, user_id, del",
        "from aoa_reviewed",
        "where reviewed_id = #{reviewedId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="reviewed_id", property="reviewedId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="advice", property="advice", jdbcType=JdbcType.VARCHAR),
        @Result(column="reviewed_time", property="reviewedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="del", property="del", jdbcType=JdbcType.INTEGER)
    })
    ReviewedPO selectByPrimaryKey(Long reviewedId);

    @UpdateProvider(type=ReviewedPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReviewedPO record, @Param("example") ReviewedPOExample example);

    @UpdateProvider(type=ReviewedPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReviewedPO record, @Param("example") ReviewedPOExample example);

    @UpdateProvider(type=ReviewedPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReviewedPO record);

    @Update({
        "update aoa_reviewed",
        "set advice = #{advice,jdbcType=VARCHAR},",
          "reviewed_time = #{reviewedTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "del = #{del,jdbcType=INTEGER}",
        "where reviewed_id = #{reviewedId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ReviewedPO record);
}