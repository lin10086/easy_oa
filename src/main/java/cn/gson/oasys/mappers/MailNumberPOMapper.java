package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.MailNumberPO;
import cn.gson.oasys.modelV2.po.MailNumberPOExample;
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

public interface MailNumberPOMapper {
    @SelectProvider(type=MailNumberPOSqlProvider.class, method="countByExample")
    long countByExample(MailNumberPOExample example);

    @DeleteProvider(type=MailNumberPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(MailNumberPOExample example);

    @Delete({
        "delete from aoa_mailnumber",
        "where mail_number_id = #{mailNumberId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long mailNumberId);

    @Insert({
        "insert into aoa_mailnumber (mail_account, mail_create_time, ",
        "mail_des, mail_type, ",
        "mail_user_name, password, ",
        "status, mail_num_user_id)",
        "values (#{mailAccount,jdbcType=VARCHAR}, #{mailCreateTime,jdbcType=TIMESTAMP}, ",
        "#{mailDes,jdbcType=VARCHAR}, #{mailType,jdbcType=BIGINT}, ",
        "#{mailUserName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=BIGINT}, #{mailNumUserId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="mailNumberId", before=false, resultType=Long.class)
    int insert(MailNumberPO record);

    @InsertProvider(type=MailNumberPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="mailNumberId", before=false, resultType=Long.class)
    int insertSelective(MailNumberPO record);

    @SelectProvider(type=MailNumberPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="mail_number_id", property="mailNumberId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mail_account", property="mailAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_create_time", property="mailCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mail_des", property="mailDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_type", property="mailType", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_user_name", property="mailUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_num_user_id", property="mailNumUserId", jdbcType=JdbcType.BIGINT)
    })
    List<MailNumberPO> selectByExample(MailNumberPOExample example);

    @Select({
        "select",
        "mail_number_id, mail_account, mail_create_time, mail_des, mail_type, mail_user_name, ",
        "password, status, mail_num_user_id",
        "from aoa_mailnumber",
        "where mail_number_id = #{mailNumberId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="mail_number_id", property="mailNumberId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mail_account", property="mailAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_create_time", property="mailCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mail_des", property="mailDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_type", property="mailType", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_user_name", property="mailUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_num_user_id", property="mailNumUserId", jdbcType=JdbcType.BIGINT)
    })
    MailNumberPO selectByPrimaryKey(Long mailNumberId);

    @UpdateProvider(type=MailNumberPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MailNumberPO record, @Param("example") MailNumberPOExample example);

    @UpdateProvider(type=MailNumberPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MailNumberPO record, @Param("example") MailNumberPOExample example);

    @UpdateProvider(type=MailNumberPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MailNumberPO record);

    @Update({
        "update aoa_mailnumber",
        "set mail_account = #{mailAccount,jdbcType=VARCHAR},",
          "mail_create_time = #{mailCreateTime,jdbcType=TIMESTAMP},",
          "mail_des = #{mailDes,jdbcType=VARCHAR},",
          "mail_type = #{mailType,jdbcType=BIGINT},",
          "mail_user_name = #{mailUserName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=BIGINT},",
          "mail_num_user_id = #{mailNumUserId,jdbcType=BIGINT}",
        "where mail_number_id = #{mailNumberId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MailNumberPO record);
}