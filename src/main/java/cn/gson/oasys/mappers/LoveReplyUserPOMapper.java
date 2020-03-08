package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.LoveReplyUserPO;
import cn.gson.oasys.modelV2.po.LoveReplyUserPOExample;
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

public interface LoveReplyUserPOMapper {
    @SelectProvider(type=LoveReplyUserPOSqlProvider.class, method="countByExample")
    long countByExample(LoveReplyUserPOExample example);

    @DeleteProvider(type=LoveReplyUserPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(LoveReplyUserPOExample example);

    @Delete({
        "delete from aoa_love_user",
        "where reply_user_id = #{replyUserId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long replyUserId);

    @Insert({
        "insert into aoa_love_user (reply_id, user_id)",
        "values (#{replyId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="replyUserId", before=false, resultType=Long.class)
    int insert(LoveReplyUserPO record);

    @InsertProvider(type=LoveReplyUserPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="replyUserId", before=false, resultType=Long.class)
    int insertSelective(LoveReplyUserPO record);

    @SelectProvider(type=LoveReplyUserPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="reply_user_id", property="replyUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<LoveReplyUserPO> selectByExample(LoveReplyUserPOExample example);

    @Select({
        "select",
        "reply_user_id, reply_id, user_id",
        "from aoa_love_user",
        "where reply_user_id = #{replyUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="reply_user_id", property="replyUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    LoveReplyUserPO selectByPrimaryKey(Long replyUserId);

    @UpdateProvider(type=LoveReplyUserPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LoveReplyUserPO record, @Param("example") LoveReplyUserPOExample example);

    @UpdateProvider(type=LoveReplyUserPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LoveReplyUserPO record, @Param("example") LoveReplyUserPOExample example);

    @UpdateProvider(type=LoveReplyUserPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoveReplyUserPO record);

    @Update({
        "update aoa_love_user",
        "set reply_id = #{replyId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where reply_user_id = #{replyUserId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoveReplyUserPO record);
}