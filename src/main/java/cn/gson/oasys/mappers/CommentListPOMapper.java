package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.CommentListPO;
import cn.gson.oasys.model.po.CommentListPOExample;
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

public interface CommentListPOMapper {
    @SelectProvider(type=CommentListPOSqlProvider.class, method="countByExample")
    long countByExample(CommentListPOExample example);

    @DeleteProvider(type=CommentListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommentListPOExample example);

    @Delete({
        "delete from aoa_comment_list",
        "where comment_id = #{commentId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long commentId);

    @Insert({
        "insert into aoa_comment_list (comment, time, ",
        "comment_user_id, reply_id)",
        "values (#{comment,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP}, ",
        "#{commentUserId,jdbcType=BIGINT}, #{replyId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="commentId", before=false, resultType=Long.class)
    int insert(CommentListPO record);

    @InsertProvider(type=CommentListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="commentId", before=false, resultType=Long.class)
    int insertSelective(CommentListPO record);

    @SelectProvider(type=CommentListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment_user_id", property="commentUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT)
    })
    List<CommentListPO> selectByExample(CommentListPOExample example);

    @Select({
        "select",
        "comment_id, comment, time, comment_user_id, reply_id",
        "from aoa_comment_list",
        "where comment_id = #{commentId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment_user_id", property="commentUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_id", property="replyId", jdbcType=JdbcType.BIGINT)
    })
    CommentListPO selectByPrimaryKey(Long commentId);

    @UpdateProvider(type=CommentListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommentListPO record, @Param("example") CommentListPOExample example);

    @UpdateProvider(type=CommentListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommentListPO record, @Param("example") CommentListPOExample example);

    @UpdateProvider(type=CommentListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommentListPO record);

    @Update({
        "update aoa_comment_list",
        "set comment = #{comment,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "comment_user_id = #{commentUserId,jdbcType=BIGINT},",
          "reply_id = #{replyId,jdbcType=BIGINT}",
        "where comment_id = #{commentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommentListPO record);
}