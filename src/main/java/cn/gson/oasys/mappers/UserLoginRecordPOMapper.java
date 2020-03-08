package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.UserLoginRecordPO;
import cn.gson.oasys.modelV2.po.UserLoginRecordPOExample;
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

public interface UserLoginRecordPOMapper {
    @SelectProvider(type=UserLoginRecordPOSqlProvider.class, method="countByExample")
    long countByExample(UserLoginRecordPOExample example);

    @DeleteProvider(type=UserLoginRecordPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserLoginRecordPOExample example);

    @Delete({
        "delete from aoa_user_login_record",
        "where record_id = #{recordId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long recordId);

    @Insert({
        "insert into aoa_user_login_record (browser, ip_addr, ",
        "login_time, session_id, ",
        "user_id)",
        "values (#{browser,jdbcType=VARCHAR}, #{ipAddr,jdbcType=VARCHAR}, ",
        "#{loginTime,jdbcType=TIMESTAMP}, #{sessionId,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="recordId", before=false, resultType=Long.class)
    int insert(UserLoginRecordPO record);

    @InsertProvider(type=UserLoginRecordPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="recordId", before=false, resultType=Long.class)
    int insertSelective(UserLoginRecordPO record);

    @SelectProvider(type=UserLoginRecordPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="record_id", property="recordId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="browser", property="browser", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_addr", property="ipAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="session_id", property="sessionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<UserLoginRecordPO> selectByExample(UserLoginRecordPOExample example);

    @Select({
        "select",
        "record_id, browser, ip_addr, login_time, session_id, user_id",
        "from aoa_user_login_record",
        "where record_id = #{recordId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="record_id", property="recordId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="browser", property="browser", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_addr", property="ipAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="session_id", property="sessionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    UserLoginRecordPO selectByPrimaryKey(Long recordId);

    @UpdateProvider(type=UserLoginRecordPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserLoginRecordPO record, @Param("example") UserLoginRecordPOExample example);

    @UpdateProvider(type=UserLoginRecordPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserLoginRecordPO record, @Param("example") UserLoginRecordPOExample example);

    @UpdateProvider(type=UserLoginRecordPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserLoginRecordPO record);

    @Update({
        "update aoa_user_login_record",
        "set browser = #{browser,jdbcType=VARCHAR},",
          "ip_addr = #{ipAddr,jdbcType=VARCHAR},",
          "login_time = #{loginTime,jdbcType=TIMESTAMP},",
          "session_id = #{sessionId,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where record_id = #{recordId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserLoginRecordPO record);
}