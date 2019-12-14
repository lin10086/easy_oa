package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.DirectorUsersPO;
import cn.gson.oasys.model.po.DirectorUsersPOExample;
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

public interface DirectorUsersPOMapper {
    @SelectProvider(type=DirectorUsersPOSqlProvider.class, method="countByExample")
    long countByExample(DirectorUsersPOExample example);

    @DeleteProvider(type=DirectorUsersPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(DirectorUsersPOExample example);

    @Delete({
        "delete from aoa_director_users",
        "where director_users_id = #{directorUsersId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long directorUsersId);

    @Insert({
        "insert into aoa_director_users (catelog_name, is_handle, ",
        "director_id, user_id, ",
        "share_user_id, sharetime)",
        "values (#{catelogName,jdbcType=VARCHAR}, #{isHandle,jdbcType=INTEGER}, ",
        "#{directorId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{shareUserId,jdbcType=BIGINT}, #{sharetime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="directorUsersId", before=false, resultType=Long.class)
    int insert(DirectorUsersPO record);

    @InsertProvider(type=DirectorUsersPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="directorUsersId", before=false, resultType=Long.class)
    int insertSelective(DirectorUsersPO record);

    @SelectProvider(type=DirectorUsersPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="director_users_id", property="directorUsersId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="catelog_name", property="catelogName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_handle", property="isHandle", jdbcType=JdbcType.INTEGER),
        @Result(column="director_id", property="directorId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="share_user_id", property="shareUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="sharetime", property="sharetime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DirectorUsersPO> selectByExample(DirectorUsersPOExample example);

    @Select({
        "select",
        "director_users_id, catelog_name, is_handle, director_id, user_id, share_user_id, ",
        "sharetime",
        "from aoa_director_users",
        "where director_users_id = #{directorUsersId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="director_users_id", property="directorUsersId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="catelog_name", property="catelogName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_handle", property="isHandle", jdbcType=JdbcType.INTEGER),
        @Result(column="director_id", property="directorId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="share_user_id", property="shareUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="sharetime", property="sharetime", jdbcType=JdbcType.TIMESTAMP)
    })
    DirectorUsersPO selectByPrimaryKey(Long directorUsersId);

    @UpdateProvider(type=DirectorUsersPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DirectorUsersPO record, @Param("example") DirectorUsersPOExample example);

    @UpdateProvider(type=DirectorUsersPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DirectorUsersPO record, @Param("example") DirectorUsersPOExample example);

    @UpdateProvider(type=DirectorUsersPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DirectorUsersPO record);

    @Update({
        "update aoa_director_users",
        "set catelog_name = #{catelogName,jdbcType=VARCHAR},",
          "is_handle = #{isHandle,jdbcType=INTEGER},",
          "director_id = #{directorId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "share_user_id = #{shareUserId,jdbcType=BIGINT},",
          "sharetime = #{sharetime,jdbcType=TIMESTAMP}",
        "where director_users_id = #{directorUsersId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DirectorUsersPO record);
}