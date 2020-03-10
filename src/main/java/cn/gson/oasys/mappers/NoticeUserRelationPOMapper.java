package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.NoticeUserRelationPO;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPOExample;
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

public interface NoticeUserRelationPOMapper {
    @SelectProvider(type=NoticeUserRelationPOSqlProvider.class, method="countByExample")
    long countByExample(NoticeUserRelationPOExample example);

    @DeleteProvider(type=NoticeUserRelationPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(NoticeUserRelationPOExample example);

    @Delete({
        "delete from aoa_notice_user_relation",
        "where relation_id = #{relationId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long relationId);

    @Insert({
        "insert into aoa_notice_user_relation (is_read, relation_notice_id, ",
        "relation_user_id)",
        "values (#{isRead,jdbcType=INTEGER}, #{relationNoticeId,jdbcType=BIGINT}, ",
        "#{relationUserId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="relationId", before=false, resultType=Long.class)
    int insert(NoticeUserRelationPO record);

    @InsertProvider(type=NoticeUserRelationPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="relationId", before=false, resultType=Long.class)
    int insertSelective(NoticeUserRelationPO record);

    @SelectProvider(type=NoticeUserRelationPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="relation_id", property="relationId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="relation_notice_id", property="relationNoticeId", jdbcType=JdbcType.BIGINT),
        @Result(column="relation_user_id", property="relationUserId", jdbcType=JdbcType.BIGINT)
    })
    List<NoticeUserRelationPO> selectByExample(NoticeUserRelationPOExample example);

    @Select({
        "select",
        "relation_id, is_read, relation_notice_id, relation_user_id",
        "from aoa_notice_user_relation",
        "where relation_id = #{relationId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="relation_id", property="relationId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="relation_notice_id", property="relationNoticeId", jdbcType=JdbcType.BIGINT),
        @Result(column="relation_user_id", property="relationUserId", jdbcType=JdbcType.BIGINT)
    })
    NoticeUserRelationPO selectByPrimaryKey(Long relationId);

    @UpdateProvider(type=NoticeUserRelationPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NoticeUserRelationPO record, @Param("example") NoticeUserRelationPOExample example);

    @UpdateProvider(type=NoticeUserRelationPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NoticeUserRelationPO record, @Param("example") NoticeUserRelationPOExample example);

    @UpdateProvider(type=NoticeUserRelationPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NoticeUserRelationPO record);

    @Update({
        "update aoa_notice_user_relation",
        "set is_read = #{isRead,jdbcType=INTEGER},",
          "relation_notice_id = #{relationNoticeId,jdbcType=BIGINT},",
          "relation_user_id = #{relationUserId,jdbcType=BIGINT}",
        "where relation_id = #{relationId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NoticeUserRelationPO record);
}