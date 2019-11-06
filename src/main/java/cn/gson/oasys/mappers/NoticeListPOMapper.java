package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.NoticeListPO;
import cn.gson.oasys.model.po.NoticeListPOExample;
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

public interface NoticeListPOMapper {
    @SelectProvider(type=NoticeListPOSqlProvider.class, method="countByExample")
    long countByExample(NoticeListPOExample example);

    @DeleteProvider(type=NoticeListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(NoticeListPOExample example);

    @Delete({
        "delete from aoa_notice_list",
        "where notice_id = #{noticeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long noticeId);

    @Insert({
        "insert into aoa_notice_list (content, is_top, ",
        "modify_time, notice_time, ",
        "status_id, title, ",
        "type_id, url, user_id)",
        "values (#{content,jdbcType=VARCHAR}, #{isTop,jdbcType=INTEGER}, ",
        "#{modifyTime,jdbcType=TIMESTAMP}, #{noticeTime,jdbcType=TIMESTAMP}, ",
        "#{statusId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{typeId,jdbcType=BIGINT}, #{url,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="noticeId", before=false, resultType=Long.class)
    int insert(NoticeListPO record);

    @InsertProvider(type=NoticeListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="noticeId", before=false, resultType=Long.class)
    int insertSelective(NoticeListPO record);

    @SelectProvider(type=NoticeListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notice_time", property="noticeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<NoticeListPO> selectByExample(NoticeListPOExample example);

    @Select({
        "select",
        "notice_id, content, is_top, modify_time, notice_time, status_id, title, type_id, ",
        "url, user_id",
        "from aoa_notice_list",
        "where notice_id = #{noticeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notice_time", property="noticeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    NoticeListPO selectByPrimaryKey(Long noticeId);

    @UpdateProvider(type=NoticeListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NoticeListPO record, @Param("example") NoticeListPOExample example);

    @UpdateProvider(type=NoticeListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NoticeListPO record, @Param("example") NoticeListPOExample example);

    @UpdateProvider(type=NoticeListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NoticeListPO record);

    @Update({
        "update aoa_notice_list",
        "set content = #{content,jdbcType=VARCHAR},",
          "is_top = #{isTop,jdbcType=INTEGER},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP},",
          "notice_time = #{noticeTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "url = #{url,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where notice_id = #{noticeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NoticeListPO record);
}