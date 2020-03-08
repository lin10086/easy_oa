package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.FilePathPO;
import cn.gson.oasys.modelV2.po.FilePathPOExample;
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

public interface FilePathPOMapper {
    @SelectProvider(type=FilePathPOSqlProvider.class, method="countByExample")
    long countByExample(FilePathPOExample example);

    @DeleteProvider(type=FilePathPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(FilePathPOExample example);

    @Delete({
        "delete from aoa_file_path",
        "where path_id = #{pathId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long pathId);

    @Insert({
        "insert into aoa_file_path (parent_id, path_name, ",
        "path_user_id, path_istrash)",
        "values (#{parentId,jdbcType=BIGINT}, #{pathName,jdbcType=VARCHAR}, ",
        "#{pathUserId,jdbcType=BIGINT}, #{pathIstrash,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pathId", before=false, resultType=Long.class)
    int insert(FilePathPO record);

    @InsertProvider(type=FilePathPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pathId", before=false, resultType=Long.class)
    int insertSelective(FilePathPO record);

    @SelectProvider(type=FilePathPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="path_id", property="pathId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="path_name", property="pathName", jdbcType=JdbcType.VARCHAR),
        @Result(column="path_user_id", property="pathUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="path_istrash", property="pathIstrash", jdbcType=JdbcType.BIGINT)
    })
    List<FilePathPO> selectByExample(FilePathPOExample example);

    @Select({
        "select",
        "path_id, parent_id, path_name, path_user_id, path_istrash",
        "from aoa_file_path",
        "where path_id = #{pathId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="path_id", property="pathId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="path_name", property="pathName", jdbcType=JdbcType.VARCHAR),
        @Result(column="path_user_id", property="pathUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="path_istrash", property="pathIstrash", jdbcType=JdbcType.BIGINT)
    })
    FilePathPO selectByPrimaryKey(Long pathId);

    @UpdateProvider(type=FilePathPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FilePathPO record, @Param("example") FilePathPOExample example);

    @UpdateProvider(type=FilePathPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FilePathPO record, @Param("example") FilePathPOExample example);

    @UpdateProvider(type=FilePathPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FilePathPO record);

    @Update({
        "update aoa_file_path",
        "set parent_id = #{parentId,jdbcType=BIGINT},",
          "path_name = #{pathName,jdbcType=VARCHAR},",
          "path_user_id = #{pathUserId,jdbcType=BIGINT},",
          "path_istrash = #{pathIstrash,jdbcType=BIGINT}",
        "where path_id = #{pathId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(FilePathPO record);
}