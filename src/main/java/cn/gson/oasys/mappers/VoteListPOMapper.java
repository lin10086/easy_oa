package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.VoteListPO;
import cn.gson.oasys.model.po.VoteListPOExample;
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

public interface VoteListPOMapper {
    @SelectProvider(type=VoteListPOSqlProvider.class, method="countByExample")
    long countByExample(VoteListPOExample example);

    @DeleteProvider(type=VoteListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(VoteListPOExample example);

    @Delete({
        "delete from aoa_vote_list",
        "where vote_id = #{voteId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long voteId);

    @Insert({
        "insert into aoa_vote_list (end_time, selectone, ",
        "start_time)",
        "values (#{endTime,jdbcType=TIMESTAMP}, #{selectone,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="voteId", before=false, resultType=Long.class)
    int insert(VoteListPO record);

    @InsertProvider(type=VoteListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="voteId", before=false, resultType=Long.class)
    int insertSelective(VoteListPO record);

    @SelectProvider(type=VoteListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="selectone", property="selectone", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<VoteListPO> selectByExample(VoteListPOExample example);

    @Select({
        "select",
        "vote_id, end_time, selectone, start_time",
        "from aoa_vote_list",
        "where vote_id = #{voteId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="selectone", property="selectone", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP)
    })
    VoteListPO selectByPrimaryKey(Long voteId);

    @UpdateProvider(type=VoteListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VoteListPO record, @Param("example") VoteListPOExample example);

    @UpdateProvider(type=VoteListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VoteListPO record, @Param("example") VoteListPOExample example);

    @UpdateProvider(type=VoteListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VoteListPO record);

    @Update({
        "update aoa_vote_list",
        "set end_time = #{endTime,jdbcType=TIMESTAMP},",
          "selectone = #{selectone,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP}",
        "where vote_id = #{voteId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VoteListPO record);
}