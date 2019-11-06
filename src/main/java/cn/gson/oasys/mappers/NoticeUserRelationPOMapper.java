package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.NoticeUserRelationPO;
import cn.gson.oasys.model.po.NoticeUserRelationPOExample;
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
        "where relatin_id = #{relatinId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long relatinId);

    @Insert({
        "insert into aoa_notice_user_relation (is_read, relatin_notice_id, ",
        "relatin_user_id)",
        "values (#{isRead,jdbcType=INTEGER}, #{relatinNoticeId,jdbcType=BIGINT}, ",
        "#{relatinUserId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="relatinId", before=false, resultType=Long.class)
    int insert(NoticeUserRelationPO record);

    @InsertProvider(type=NoticeUserRelationPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="relatinId", before=false, resultType=Long.class)
    int insertSelective(NoticeUserRelationPO record);

    @SelectProvider(type=NoticeUserRelationPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="relatin_id", property="relatinId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="relatin_notice_id", property="relatinNoticeId", jdbcType=JdbcType.BIGINT),
        @Result(column="relatin_user_id", property="relatinUserId", jdbcType=JdbcType.BIGINT)
    })
    List<NoticeUserRelationPO> selectByExample(NoticeUserRelationPOExample example);

    @Select({
        "select",
        "relatin_id, is_read, relatin_notice_id, relatin_user_id",
        "from aoa_notice_user_relation",
        "where relatin_id = #{relatinId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="relatin_id", property="relatinId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="relatin_notice_id", property="relatinNoticeId", jdbcType=JdbcType.BIGINT),
        @Result(column="relatin_user_id", property="relatinUserId", jdbcType=JdbcType.BIGINT)
    })
    NoticeUserRelationPO selectByPrimaryKey(Long relatinId);

    @UpdateProvider(type=NoticeUserRelationPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NoticeUserRelationPO record, @Param("example") NoticeUserRelationPOExample example);

    @UpdateProvider(type=NoticeUserRelationPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NoticeUserRelationPO record, @Param("example") NoticeUserRelationPOExample example);

    @UpdateProvider(type=NoticeUserRelationPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NoticeUserRelationPO record);

    @Update({
        "update aoa_notice_user_relation",
        "set is_read = #{isRead,jdbcType=INTEGER},",
          "relatin_notice_id = #{relatinNoticeId,jdbcType=BIGINT},",
          "relatin_user_id = #{relatinUserId,jdbcType=BIGINT}",
        "where relatin_id = #{relatinId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NoticeUserRelationPO record);
}