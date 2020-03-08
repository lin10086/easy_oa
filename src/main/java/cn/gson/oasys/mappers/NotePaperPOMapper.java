package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.NotePaperPO;
import cn.gson.oasys.modelV2.po.NotePaperPOExample;
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

public interface NotePaperPOMapper {
    @SelectProvider(type=NotePaperPOSqlProvider.class, method="countByExample")
    long countByExample(NotePaperPOExample example);

    @DeleteProvider(type=NotePaperPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(NotePaperPOExample example);

    @Delete({
        "delete from aoa_notepaper",
        "where notepaper_id = #{notepaperId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long notepaperId);

    @Insert({
        "insert into aoa_notepaper (create_time, title, ",
        "notepaper_user_id, concent)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{title,jdbcType=VARCHAR}, ",
        "#{notepaperUserId,jdbcType=BIGINT}, #{concent,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="notepaperId", before=false, resultType=Long.class)
    int insert(NotePaperPO record);

    @InsertProvider(type=NotePaperPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="notepaperId", before=false, resultType=Long.class)
    int insertSelective(NotePaperPO record);

    @SelectProvider(type=NotePaperPOSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="notepaper_id", property="notepaperId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="notepaper_user_id", property="notepaperUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="concent", property="concent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<NotePaperPO> selectByExampleWithBLOBs(NotePaperPOExample example);

    @SelectProvider(type=NotePaperPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notepaper_id", property="notepaperId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="notepaper_user_id", property="notepaperUserId", jdbcType=JdbcType.BIGINT)
    })
    List<NotePaperPO> selectByExample(NotePaperPOExample example);

    @Select({
        "select",
        "notepaper_id, create_time, title, notepaper_user_id, concent",
        "from aoa_notepaper",
        "where notepaper_id = #{notepaperId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="notepaper_id", property="notepaperId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="notepaper_user_id", property="notepaperUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="concent", property="concent", jdbcType=JdbcType.LONGVARCHAR)
    })
    NotePaperPO selectByPrimaryKey(Long notepaperId);

    @UpdateProvider(type=NotePaperPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NotePaperPO record, @Param("example") NotePaperPOExample example);

    @UpdateProvider(type=NotePaperPOSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") NotePaperPO record, @Param("example") NotePaperPOExample example);

    @UpdateProvider(type=NotePaperPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NotePaperPO record, @Param("example") NotePaperPOExample example);

    @UpdateProvider(type=NotePaperPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NotePaperPO record);

    @Update({
        "update aoa_notepaper",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "notepaper_user_id = #{notepaperUserId,jdbcType=BIGINT},",
          "concent = #{concent,jdbcType=LONGVARCHAR}",
        "where notepaper_id = #{notepaperId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(NotePaperPO record);

    @Update({
        "update aoa_notepaper",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "notepaper_user_id = #{notepaperUserId,jdbcType=BIGINT}",
        "where notepaper_id = #{notepaperId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NotePaperPO record);
}