package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.NoteListPO;
import cn.gson.oasys.model.po.NoteListPOExample;
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

public interface NoteListPOMapper {
    @SelectProvider(type=NoteListPOSqlProvider.class, method="countByExample")
    long countByExample(NoteListPOExample example);

    @DeleteProvider(type=NoteListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(NoteListPOExample example);

    @Delete({
        "delete from aoa_note_list",
        "where note_id = #{noteId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long noteId);

    @Insert({
        "insert into aoa_note_list (content, create_time, ",
        "status_id, title, ",
        "type_id, catalog_id, ",
        "attach_id, is_collected, ",
        "createman_id, receiver)",
        "values (#{content,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{statusId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{typeId,jdbcType=BIGINT}, #{catalogId,jdbcType=BIGINT}, ",
        "#{attachId,jdbcType=BIGINT}, #{isCollected,jdbcType=BIGINT}, ",
        "#{createmanId,jdbcType=BIGINT}, #{receiver,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="noteId", before=false, resultType=Long.class)
    int insert(NoteListPO record);

    @InsertProvider(type=NoteListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="noteId", before=false, resultType=Long.class)
    int insertSelective(NoteListPO record);

    @SelectProvider(type=NoteListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="catalog_id", property="catalogId", jdbcType=JdbcType.BIGINT),
        @Result(column="attach_id", property="attachId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_collected", property="isCollected", jdbcType=JdbcType.BIGINT),
        @Result(column="createman_id", property="createmanId", jdbcType=JdbcType.BIGINT),
        @Result(column="receiver", property="receiver", jdbcType=JdbcType.VARCHAR)
    })
    List<NoteListPO> selectByExample(NoteListPOExample example);

    @Select({
        "select",
        "note_id, content, create_time, status_id, title, type_id, catalog_id, attach_id, ",
        "is_collected, createman_id, receiver",
        "from aoa_note_list",
        "where note_id = #{noteId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="catalog_id", property="catalogId", jdbcType=JdbcType.BIGINT),
        @Result(column="attach_id", property="attachId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_collected", property="isCollected", jdbcType=JdbcType.BIGINT),
        @Result(column="createman_id", property="createmanId", jdbcType=JdbcType.BIGINT),
        @Result(column="receiver", property="receiver", jdbcType=JdbcType.VARCHAR)
    })
    NoteListPO selectByPrimaryKey(Long noteId);

    @UpdateProvider(type=NoteListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NoteListPO record, @Param("example") NoteListPOExample example);

    @UpdateProvider(type=NoteListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NoteListPO record, @Param("example") NoteListPOExample example);

    @UpdateProvider(type=NoteListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NoteListPO record);

    @Update({
        "update aoa_note_list",
        "set content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "catalog_id = #{catalogId,jdbcType=BIGINT},",
          "attach_id = #{attachId,jdbcType=BIGINT},",
          "is_collected = #{isCollected,jdbcType=BIGINT},",
          "createman_id = #{createmanId,jdbcType=BIGINT},",
          "receiver = #{receiver,jdbcType=VARCHAR}",
        "where note_id = #{noteId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NoteListPO record);
}