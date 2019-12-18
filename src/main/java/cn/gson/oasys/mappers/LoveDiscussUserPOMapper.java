package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.LoveDiscussUserPO;
import cn.gson.oasys.model.po.LoveDiscussUserPOExample;
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

public interface LoveDiscussUserPOMapper {
    @SelectProvider(type=LoveDiscussUserPOSqlProvider.class, method="countByExample")
    long countByExample(LoveDiscussUserPOExample example);

    @DeleteProvider(type=LoveDiscussUserPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(LoveDiscussUserPOExample example);

    @Delete({
        "delete from aoa_love_discuss_user",
        "where discuss_user_id = #{discussUserId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long discussUserId);

    @Insert({
        "insert into aoa_love_discuss_user (discuss_id, user_id)",
        "values (#{discussId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="discussUserId", before=false, resultType=Long.class)
    int insert(LoveDiscussUserPO record);

    @InsertProvider(type=LoveDiscussUserPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="discussUserId", before=false, resultType=Long.class)
    int insertSelective(LoveDiscussUserPO record);

    @SelectProvider(type=LoveDiscussUserPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="discuss_user_id", property="discussUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<LoveDiscussUserPO> selectByExample(LoveDiscussUserPOExample example);

    @Select({
        "select",
        "discuss_user_id, discuss_id, user_id",
        "from aoa_love_discuss_user",
        "where discuss_user_id = #{discussUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="discuss_user_id", property="discussUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    LoveDiscussUserPO selectByPrimaryKey(Long discussUserId);

    @UpdateProvider(type=LoveDiscussUserPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LoveDiscussUserPO record, @Param("example") LoveDiscussUserPOExample example);

    @UpdateProvider(type=LoveDiscussUserPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LoveDiscussUserPO record, @Param("example") LoveDiscussUserPOExample example);

    @UpdateProvider(type=LoveDiscussUserPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoveDiscussUserPO record);

    @Update({
        "update aoa_love_discuss_user",
        "set discuss_id = #{discussId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where discuss_user_id = #{discussUserId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoveDiscussUserPO record);
}