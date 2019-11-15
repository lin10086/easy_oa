package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.InMailListPO;
import cn.gson.oasys.model.po.InMailListPOExample;
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

public interface InMailListPOMapper {
    @SelectProvider(type=InMailListPOSqlProvider.class, method="countByExample")
    long countByExample(InMailListPOExample example);

    @DeleteProvider(type=InMailListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(InMailListPOExample example);

    @Delete({
        "delete from aoa_in_mail_list",
        "where mail_id = #{mailId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long mailId);

    @Insert({
        "insert into aoa_in_mail_list (mail_create_time, mail_file_id, ",
        "mail_title, mail_type, ",
        "mail_in_push_user_id, in_receiver, ",
        "mail_status_id, mail_number_id, ",
        "mail_del, mail_push, ",
        "mail_star, mail_content)",
        "values (#{mailCreateTime,jdbcType=TIMESTAMP}, #{mailFileId,jdbcType=BIGINT}, ",
        "#{mailTitle,jdbcType=VARCHAR}, #{mailType,jdbcType=BIGINT}, ",
        "#{mailInPushUserId,jdbcType=BIGINT}, #{inReceiver,jdbcType=VARCHAR}, ",
        "#{mailStatusId,jdbcType=BIGINT}, #{mailNumberId,jdbcType=BIGINT}, ",
        "#{mailDel,jdbcType=INTEGER}, #{mailPush,jdbcType=INTEGER}, ",
        "#{mailStar,jdbcType=INTEGER}, #{mailContent,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="mailId", before=false, resultType=Long.class)
    int insert(InMailListPO record);

    @InsertProvider(type=InMailListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="mailId", before=false, resultType=Long.class)
    int insertSelective(InMailListPO record);

    @SelectProvider(type=InMailListPOSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="mail_id", property="mailId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mail_create_time", property="mailCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mail_file_id", property="mailFileId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_title", property="mailTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_type", property="mailType", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_in_push_user_id", property="mailInPushUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="in_receiver", property="inReceiver", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_status_id", property="mailStatusId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_number_id", property="mailNumberId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_del", property="mailDel", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_push", property="mailPush", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_star", property="mailStar", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_content", property="mailContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<InMailListPO> selectByExampleWithBLOBs(InMailListPOExample example);

    @SelectProvider(type=InMailListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="mail_id", property="mailId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mail_create_time", property="mailCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mail_file_id", property="mailFileId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_title", property="mailTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_type", property="mailType", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_in_push_user_id", property="mailInPushUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="in_receiver", property="inReceiver", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_status_id", property="mailStatusId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_number_id", property="mailNumberId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_del", property="mailDel", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_push", property="mailPush", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_star", property="mailStar", jdbcType=JdbcType.INTEGER)
    })
    List<InMailListPO> selectByExample(InMailListPOExample example);

    @Select({
        "select",
        "mail_id, mail_create_time, mail_file_id, mail_title, mail_type, mail_in_push_user_id, ",
        "in_receiver, mail_status_id, mail_number_id, mail_del, mail_push, mail_star, ",
        "mail_content",
        "from aoa_in_mail_list",
        "where mail_id = #{mailId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="mail_id", property="mailId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mail_create_time", property="mailCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mail_file_id", property="mailFileId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_title", property="mailTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_type", property="mailType", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_in_push_user_id", property="mailInPushUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="in_receiver", property="inReceiver", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_status_id", property="mailStatusId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_number_id", property="mailNumberId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_del", property="mailDel", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_push", property="mailPush", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_star", property="mailStar", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_content", property="mailContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    InMailListPO selectByPrimaryKey(Long mailId);

    @UpdateProvider(type=InMailListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InMailListPO record, @Param("example") InMailListPOExample example);

    @UpdateProvider(type=InMailListPOSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") InMailListPO record, @Param("example") InMailListPOExample example);

    @UpdateProvider(type=InMailListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InMailListPO record, @Param("example") InMailListPOExample example);

    @UpdateProvider(type=InMailListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(InMailListPO record);

    @Update({
        "update aoa_in_mail_list",
        "set mail_create_time = #{mailCreateTime,jdbcType=TIMESTAMP},",
          "mail_file_id = #{mailFileId,jdbcType=BIGINT},",
          "mail_title = #{mailTitle,jdbcType=VARCHAR},",
          "mail_type = #{mailType,jdbcType=BIGINT},",
          "mail_in_push_user_id = #{mailInPushUserId,jdbcType=BIGINT},",
          "in_receiver = #{inReceiver,jdbcType=VARCHAR},",
          "mail_status_id = #{mailStatusId,jdbcType=BIGINT},",
          "mail_number_id = #{mailNumberId,jdbcType=BIGINT},",
          "mail_del = #{mailDel,jdbcType=INTEGER},",
          "mail_push = #{mailPush,jdbcType=INTEGER},",
          "mail_star = #{mailStar,jdbcType=INTEGER},",
          "mail_content = #{mailContent,jdbcType=LONGVARCHAR}",
        "where mail_id = #{mailId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(InMailListPO record);

    @Update({
        "update aoa_in_mail_list",
        "set mail_create_time = #{mailCreateTime,jdbcType=TIMESTAMP},",
          "mail_file_id = #{mailFileId,jdbcType=BIGINT},",
          "mail_title = #{mailTitle,jdbcType=VARCHAR},",
          "mail_type = #{mailType,jdbcType=BIGINT},",
          "mail_in_push_user_id = #{mailInPushUserId,jdbcType=BIGINT},",
          "in_receiver = #{inReceiver,jdbcType=VARCHAR},",
          "mail_status_id = #{mailStatusId,jdbcType=BIGINT},",
          "mail_number_id = #{mailNumberId,jdbcType=BIGINT},",
          "mail_del = #{mailDel,jdbcType=INTEGER},",
          "mail_push = #{mailPush,jdbcType=INTEGER},",
          "mail_star = #{mailStar,jdbcType=INTEGER}",
        "where mail_id = #{mailId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(InMailListPO record);
}