package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.VoteTitlesPO;
import cn.gson.oasys.modelV2.po.VoteTitlesPOExample;
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

public interface VoteTitlesPOMapper {
    @SelectProvider(type=VoteTitlesPOSqlProvider.class, method="countByExample")
    long countByExample(VoteTitlesPOExample example);

    @DeleteProvider(type=VoteTitlesPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(VoteTitlesPOExample example);

    @Delete({
        "delete from aoa_vote_titles",
        "where title_id = #{titleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long titleId);

    @Insert({
        "insert into aoa_vote_titles (color, title, ",
        "vote_id)",
        "values (#{color,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{voteId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="titleId", before=false, resultType=Long.class)
    int insert(VoteTitlesPO record);

    @InsertProvider(type=VoteTitlesPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="titleId", before=false, resultType=Long.class)
    int insertSelective(VoteTitlesPO record);

    @SelectProvider(type=VoteTitlesPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="color", property="color", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT)
    })
    List<VoteTitlesPO> selectByExample(VoteTitlesPOExample example);

    @Select({
        "select",
        "title_id, color, title, vote_id",
        "from aoa_vote_titles",
        "where title_id = #{titleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="title_id", property="titleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="color", property="color", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="vote_id", property="voteId", jdbcType=JdbcType.BIGINT)
    })
    VoteTitlesPO selectByPrimaryKey(Long titleId);

    @UpdateProvider(type=VoteTitlesPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VoteTitlesPO record, @Param("example") VoteTitlesPOExample example);

    @UpdateProvider(type=VoteTitlesPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VoteTitlesPO record, @Param("example") VoteTitlesPOExample example);

    @UpdateProvider(type=VoteTitlesPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VoteTitlesPO record);

    @Update({
        "update aoa_vote_titles",
        "set color = #{color,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "vote_id = #{voteId,jdbcType=BIGINT}",
        "where title_id = #{titleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VoteTitlesPO record);
}