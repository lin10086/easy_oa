package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.FileListPO;
import cn.gson.oasys.modelV2.po.FileListPOExample;
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

public interface FileListPOMapper {
    @SelectProvider(type=FileListPOSqlProvider.class, method="countByExample")
    long countByExample(FileListPOExample example);

    @DeleteProvider(type=FileListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(FileListPOExample example);

    @Delete({
        "delete from aoa_file_list",
        "where file_id = #{fileId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long fileId);

    @Insert({
        "insert into aoa_file_list (file_name, file_path, ",
        "file_shuffix, content_type, ",
        "model, path_id, size, ",
        "upload_time, file_user_id, ",
        "file_istrash, file_isshare)",
        "values (#{fileName,jdbcType=VARCHAR}, #{filePath,jdbcType=VARCHAR}, ",
        "#{fileShuffix,jdbcType=VARCHAR}, #{contentType,jdbcType=VARCHAR}, ",
        "#{model,jdbcType=VARCHAR}, #{pathId,jdbcType=BIGINT}, #{size,jdbcType=BIGINT}, ",
        "#{uploadTime,jdbcType=TIMESTAMP}, #{fileUserId,jdbcType=BIGINT}, ",
        "#{fileIstrash,jdbcType=BIGINT}, #{fileIsshare,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="fileId", before=false, resultType=Long.class)
    int insert(FileListPO record);

    @InsertProvider(type=FileListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="fileId", before=false, resultType=Long.class)
    int insertSelective(FileListPO record);

    @SelectProvider(type=FileListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_shuffix", property="fileShuffix", jdbcType=JdbcType.VARCHAR),
        @Result(column="content_type", property="contentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="path_id", property="pathId", jdbcType=JdbcType.BIGINT),
        @Result(column="size", property="size", jdbcType=JdbcType.BIGINT),
        @Result(column="upload_time", property="uploadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="file_user_id", property="fileUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="file_istrash", property="fileIstrash", jdbcType=JdbcType.BIGINT),
        @Result(column="file_isshare", property="fileIsshare", jdbcType=JdbcType.BIGINT)
    })
    List<FileListPO> selectByExample(FileListPOExample example);

    @Select({
        "select",
        "file_id, file_name, file_path, file_shuffix, content_type, model, path_id, size, ",
        "upload_time, file_user_id, file_istrash, file_isshare",
        "from aoa_file_list",
        "where file_id = #{fileId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_shuffix", property="fileShuffix", jdbcType=JdbcType.VARCHAR),
        @Result(column="content_type", property="contentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="path_id", property="pathId", jdbcType=JdbcType.BIGINT),
        @Result(column="size", property="size", jdbcType=JdbcType.BIGINT),
        @Result(column="upload_time", property="uploadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="file_user_id", property="fileUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="file_istrash", property="fileIstrash", jdbcType=JdbcType.BIGINT),
        @Result(column="file_isshare", property="fileIsshare", jdbcType=JdbcType.BIGINT)
    })
    FileListPO selectByPrimaryKey(Long fileId);

    @UpdateProvider(type=FileListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FileListPO record, @Param("example") FileListPOExample example);

    @UpdateProvider(type=FileListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FileListPO record, @Param("example") FileListPOExample example);

    @UpdateProvider(type=FileListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FileListPO record);

    @Update({
        "update aoa_file_list",
        "set file_name = #{fileName,jdbcType=VARCHAR},",
          "file_path = #{filePath,jdbcType=VARCHAR},",
          "file_shuffix = #{fileShuffix,jdbcType=VARCHAR},",
          "content_type = #{contentType,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "path_id = #{pathId,jdbcType=BIGINT},",
          "size = #{size,jdbcType=BIGINT},",
          "upload_time = #{uploadTime,jdbcType=TIMESTAMP},",
          "file_user_id = #{fileUserId,jdbcType=BIGINT},",
          "file_istrash = #{fileIstrash,jdbcType=BIGINT},",
          "file_isshare = #{fileIsshare,jdbcType=BIGINT}",
        "where file_id = #{fileId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(FileListPO record);
}