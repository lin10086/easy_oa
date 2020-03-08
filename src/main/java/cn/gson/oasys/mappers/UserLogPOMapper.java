package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.UserLogPO;
import cn.gson.oasys.modelV2.po.UserLogPOExample;
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

public interface UserLogPOMapper {
    @SelectProvider(type=UserLogPOSqlProvider.class, method="countByExample")
    long countByExample(UserLogPOExample example);

    @DeleteProvider(type=UserLogPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserLogPOExample example);

    @Delete({
        "delete from aoa_user_log",
        "where log_id = #{logId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long logId);

    @Insert({
        "insert into aoa_user_log (ip_addr, log_time, ",
        "title, url, user_id)",
        "values (#{ipAddr,jdbcType=VARCHAR}, #{logTime,jdbcType=TIMESTAMP}, ",
        "#{title,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="logId", before=false, resultType=Long.class)
    int insert(UserLogPO record);

    @InsertProvider(type=UserLogPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="logId", before=false, resultType=Long.class)
    int insertSelective(UserLogPO record);

    @SelectProvider(type=UserLogPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="log_id", property="logId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip_addr", property="ipAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="log_time", property="logTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<UserLogPO> selectByExample(UserLogPOExample example);

    @Select({
        "select",
        "log_id, ip_addr, log_time, title, url, user_id",
        "from aoa_user_log",
        "where log_id = #{logId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="log_id", property="logId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip_addr", property="ipAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="log_time", property="logTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    UserLogPO selectByPrimaryKey(Long logId);

    @UpdateProvider(type=UserLogPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserLogPO record, @Param("example") UserLogPOExample example);

    @UpdateProvider(type=UserLogPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserLogPO record, @Param("example") UserLogPOExample example);

    @UpdateProvider(type=UserLogPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserLogPO record);

    @Update({
        "update aoa_user_log",
        "set ip_addr = #{ipAddr,jdbcType=VARCHAR},",
          "log_time = #{logTime,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where log_id = #{logId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserLogPO record);
}