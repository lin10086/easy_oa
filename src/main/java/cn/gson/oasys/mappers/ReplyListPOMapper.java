package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ReplyListPO;
import cn.gson.oasys.model.po.ReplyListPOExample;
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

public interface ReplyListPOMapper {
    @SelectProvider(type=ReplyListPOSqlProvider.class, method="countByExample")
    long countByExample(ReplyListPOExample example);

    @DeleteProvider(type=ReplyListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReplyListPOExample example);

    @Delete({
        "delete from aoa_reply_list",
        "where reply_id = #{replyId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long replyId);

    @Insert({
        "insert into aoa_reply_list (replay_time, discuss_id, ",
        "reply_user_id, content)",
        "values (#{replayTime,jdbcType=TIMESTAMP}, #{discussId,jdbcType=BIGINT}, ",
        "#{replyUserId,jdbcType=BIGINT}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="replyId", before=false, resultType=Long.class)
    int insert(ReplyListPO record);

    @InsertProvider(type=ReplyListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="replyId", before=false, resultType=Long.class)
    int insertSelective(ReplyListPO record);

    @SelectProvider(type=ReplyListPOSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="replay_time", property="replayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_user_id", property="replyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ReplyListPO> selectByExampleWithBLOBs(ReplyListPOExample example);

    @SelectProvider(type=ReplyListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="replay_time", property="replayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_user_id", property="replyUserId", jdbcType=JdbcType.BIGINT)
    })
    List<ReplyListPO> selectByExample(ReplyListPOExample example);

    @Select({
        "select",
        "reply_id, replay_time, discuss_id, reply_user_id, content",
        "from aoa_reply_list",
        "where reply_id = #{replyId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="replay_time", property="replayTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_user_id", property="replyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    ReplyListPO selectByPrimaryKey(Long replyId);

    @UpdateProvider(type=ReplyListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReplyListPO record, @Param("example") ReplyListPOExample example);

    @UpdateProvider(type=ReplyListPOSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ReplyListPO record, @Param("example") ReplyListPOExample example);

    @UpdateProvider(type=ReplyListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReplyListPO record, @Param("example") ReplyListPOExample example);

    @UpdateProvider(type=ReplyListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReplyListPO record);

    @Update({
        "update aoa_reply_list",
        "set replay_time = #{replayTime,jdbcType=TIMESTAMP},",
          "discuss_id = #{discussId,jdbcType=BIGINT},",
          "reply_user_id = #{replyUserId,jdbcType=BIGINT},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where reply_id = #{replyId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ReplyListPO record);

    @Update({
        "update aoa_reply_list",
        "set replay_time = #{replayTime,jdbcType=TIMESTAMP},",
          "discuss_id = #{discussId,jdbcType=BIGINT},",
          "reply_user_id = #{replyUserId,jdbcType=BIGINT}",
        "where reply_id = #{replyId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ReplyListPO record);
}