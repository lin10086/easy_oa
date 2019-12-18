package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.VoteTitleUserPO;
import cn.gson.oasys.model.po.VoteTitleUserPOExample;
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

public interface VoteTitleUserPOMapper {
    @SelectProvider(type=VoteTitleUserPOSqlProvider.class, method="countByExample")
    long countByExample(VoteTitleUserPOExample example);

    @DeleteProvider(type=VoteTitleUserPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(VoteTitleUserPOExample example);

    @Delete({
        "delete from aoa_vote_title_user",
        "where vote_title_user_id = #{voteTitleUserId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long voteTitleUserId);

    @Insert({
        "insert into aoa_vote_title_user (vote_id, user_id, ",
        "title_id)",
        "values (#{voteId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{titleId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="voteTitleUserId", before=false, resultType=Long.class)
    int insert(VoteTitleUserPO record);

    @InsertProvider(type=VoteTitleUserPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="voteTitleUserId", before=false, resultType=Long.class)
    int insertSelective(VoteTitleUserPO record);

    @SelectProvider(type=VoteTitleUserPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="vote_title_user_id", property="voteTitleUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.BIGINT)
    })
    List<VoteTitleUserPO> selectByExample(VoteTitleUserPOExample example);

    @Select({
        "select",
        "vote_title_user_id, vote_id, user_id, title_id",
        "from aoa_vote_title_user",
        "where vote_title_user_id = #{voteTitleUserId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="vote_title_user_id", property="voteTitleUserId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.BIGINT)
    })
    VoteTitleUserPO selectByPrimaryKey(Long voteTitleUserId);

    @UpdateProvider(type=VoteTitleUserPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VoteTitleUserPO record, @Param("example") VoteTitleUserPOExample example);

    @UpdateProvider(type=VoteTitleUserPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VoteTitleUserPO record, @Param("example") VoteTitleUserPOExample example);

    @UpdateProvider(type=VoteTitleUserPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VoteTitleUserPO record);

    @Update({
        "update aoa_vote_title_user",
        "set vote_id = #{voteId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "title_id = #{titleId,jdbcType=BIGINT}",
        "where vote_title_user_id = #{voteTitleUserId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VoteTitleUserPO record);
}