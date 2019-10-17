package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.AttachmentListPO;
import cn.gson.oasys.model.po.AttachmentListPOExample;
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

public interface AttachmentListPOMapper {
    @SelectProvider(type=AttachmentListPOSqlProvider.class, method="countByExample")
    long countByExample(AttachmentListPOExample example);

    @DeleteProvider(type=AttachmentListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(AttachmentListPOExample example);

    @Delete({
        "delete from aoa_attachment_list",
        "where attachment_id = #{attachmentId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long attachmentId);

    @Insert({
        "insert into aoa_attachment_list (attachment_name, attachment_path, ",
        "attachment_shuffix, attachment_size, ",
        "attachment_type, model, ",
        "upload_time, user_id)",
        "values (#{attachmentName,jdbcType=VARCHAR}, #{attachmentPath,jdbcType=VARCHAR}, ",
        "#{attachmentShuffix,jdbcType=VARCHAR}, #{attachmentSize,jdbcType=VARCHAR}, ",
        "#{attachmentType,jdbcType=VARCHAR}, #{model,jdbcType=VARCHAR}, ",
        "#{uploadTime,jdbcType=TIMESTAMP}, #{userId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="attachmentId", before=false, resultType=Long.class)
    int insert(AttachmentListPO record);

    @InsertProvider(type=AttachmentListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="attachmentId", before=false, resultType=Long.class)
    int insertSelective(AttachmentListPO record);

    @SelectProvider(type=AttachmentListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="attachment_id", property="attachmentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="attachment_name", property="attachmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_path", property="attachmentPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_shuffix", property="attachmentShuffix", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_size", property="attachmentSize", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_type", property="attachmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_time", property="uploadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    List<AttachmentListPO> selectByExample(AttachmentListPOExample example);

    @Select({
        "select",
        "attachment_id, attachment_name, attachment_path, attachment_shuffix, attachment_size, ",
        "attachment_type, model, upload_time, user_id",
        "from aoa_attachment_list",
        "where attachment_id = #{attachmentId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="attachment_id", property="attachmentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="attachment_name", property="attachmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_path", property="attachmentPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_shuffix", property="attachmentShuffix", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_size", property="attachmentSize", jdbcType=JdbcType.VARCHAR),
        @Result(column="attachment_type", property="attachmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_time", property="uploadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    AttachmentListPO selectByPrimaryKey(Long attachmentId);

    @UpdateProvider(type=AttachmentListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AttachmentListPO record, @Param("example") AttachmentListPOExample example);

    @UpdateProvider(type=AttachmentListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AttachmentListPO record, @Param("example") AttachmentListPOExample example);

    @UpdateProvider(type=AttachmentListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AttachmentListPO record);

    @Update({
        "update aoa_attachment_list",
        "set attachment_name = #{attachmentName,jdbcType=VARCHAR},",
          "attachment_path = #{attachmentPath,jdbcType=VARCHAR},",
          "attachment_shuffix = #{attachmentShuffix,jdbcType=VARCHAR},",
          "attachment_size = #{attachmentSize,jdbcType=VARCHAR},",
          "attachment_type = #{attachmentType,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "upload_time = #{uploadTime,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=VARCHAR}",
        "where attachment_id = #{attachmentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AttachmentListPO record);
}