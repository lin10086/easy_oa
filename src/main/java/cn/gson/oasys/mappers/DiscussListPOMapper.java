package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.DiscussListPO;
import cn.gson.oasys.model.po.DiscussListPOExample;
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

public interface DiscussListPOMapper {
    @SelectProvider(type=DiscussListPOSqlProvider.class, method="countByExample")
    long countByExample(DiscussListPOExample example);

    @DeleteProvider(type=DiscussListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(DiscussListPOExample example);

    @Delete({
        "delete from aoa_discuss_list",
        "where discuss_id = #{discussId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long discussId);

    @Insert({
        "insert into aoa_discuss_list (attachment_id, create_time, ",
        "status_id, title, ",
        "type_id, visit_num, ",
        "discuss_user_id, vote_id, ",
        "modify_time, content)",
        "values (#{attachmentId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{statusId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{typeId,jdbcType=BIGINT}, #{visitNum,jdbcType=INTEGER}, ",
        "#{discussUserId,jdbcType=BIGINT}, #{voteId,jdbcType=BIGINT}, ",
        "#{modifyTime,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="discussId", before=false, resultType=Long.class)
    int insert(DiscussListPO record);

    @InsertProvider(type=DiscussListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="discussId", before=false, resultType=Long.class)
    int insertSelective(DiscussListPO record);

    @SelectProvider(type=DiscussListPOSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="attachment_id", property="attachmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="visit_num", property="visitNum", jdbcType=JdbcType.INTEGER),
        @Result(column="discuss_user_id", property="discussUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<DiscussListPO> selectByExampleWithBLOBs(DiscussListPOExample example);

    @SelectProvider(type=DiscussListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="attachment_id", property="attachmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="visit_num", property="visitNum", jdbcType=JdbcType.INTEGER),
        @Result(column="discuss_user_id", property="discussUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DiscussListPO> selectByExample(DiscussListPOExample example);

    @Select({
        "select",
        "discuss_id, attachment_id, create_time, status_id, title, type_id, visit_num, ",
        "discuss_user_id, vote_id, modify_time, content",
        "from aoa_discuss_list",
        "where discuss_id = #{discussId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="discuss_id", property="discussId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="attachment_id", property="attachmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="visit_num", property="visitNum", jdbcType=JdbcType.INTEGER),
        @Result(column="discuss_user_id", property="discussUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    DiscussListPO selectByPrimaryKey(Long discussId);

    @UpdateProvider(type=DiscussListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DiscussListPO record, @Param("example") DiscussListPOExample example);

    @UpdateProvider(type=DiscussListPOSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") DiscussListPO record, @Param("example") DiscussListPOExample example);

    @UpdateProvider(type=DiscussListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DiscussListPO record, @Param("example") DiscussListPOExample example);

    @UpdateProvider(type=DiscussListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DiscussListPO record);

    @Update({
        "update aoa_discuss_list",
        "set attachment_id = #{attachmentId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "visit_num = #{visitNum,jdbcType=INTEGER},",
          "discuss_user_id = #{discussUserId,jdbcType=BIGINT},",
          "vote_id = #{voteId,jdbcType=BIGINT},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where discuss_id = #{discussId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(DiscussListPO record);

    @Update({
        "update aoa_discuss_list",
        "set attachment_id = #{attachmentId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "visit_num = #{visitNum,jdbcType=INTEGER},",
          "discuss_user_id = #{discussUserId,jdbcType=BIGINT},",
          "vote_id = #{voteId,jdbcType=BIGINT},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where discuss_id = #{discussId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DiscussListPO record);
}