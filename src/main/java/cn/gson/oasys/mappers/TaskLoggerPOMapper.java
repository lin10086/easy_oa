package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.TaskLoggerPO;
import cn.gson.oasys.model.po.TaskLoggerPOExample;
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

public interface TaskLoggerPOMapper {
    @SelectProvider(type=TaskLoggerPOSqlProvider.class, method="countByExample")
    long countByExample(TaskLoggerPOExample example);

    @DeleteProvider(type=TaskLoggerPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskLoggerPOExample example);

    @Delete({
        "delete from aoa_task_logger",
        "where logger_id = #{loggerId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long loggerId);

    @Insert({
        "insert into aoa_task_logger (create_time, logger_ticking, ",
        "task_id, username, ",
        "logger_statusid)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{loggerTicking,jdbcType=VARCHAR}, ",
        "#{taskId,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{loggerStatusid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="loggerId", before=false, resultType=Long.class)
    int insert(TaskLoggerPO record);

    @InsertProvider(type=TaskLoggerPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="loggerId", before=false, resultType=Long.class)
    int insertSelective(TaskLoggerPO record);

    @SelectProvider(type=TaskLoggerPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="logger_id", property="loggerId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="logger_ticking", property="loggerTicking", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="logger_statusid", property="loggerStatusid", jdbcType=JdbcType.INTEGER)
    })
    List<TaskLoggerPO> selectByExample(TaskLoggerPOExample example);

    @Select({
        "select",
        "logger_id, create_time, logger_ticking, task_id, username, logger_statusid",
        "from aoa_task_logger",
        "where logger_id = #{loggerId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="logger_id", property="loggerId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="logger_ticking", property="loggerTicking", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="logger_statusid", property="loggerStatusid", jdbcType=JdbcType.INTEGER)
    })
    TaskLoggerPO selectByPrimaryKey(Long loggerId);

    @UpdateProvider(type=TaskLoggerPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskLoggerPO record, @Param("example") TaskLoggerPOExample example);

    @UpdateProvider(type=TaskLoggerPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskLoggerPO record, @Param("example") TaskLoggerPOExample example);

    @UpdateProvider(type=TaskLoggerPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskLoggerPO record);

    @Update({
        "update aoa_task_logger",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "logger_ticking = #{loggerTicking,jdbcType=VARCHAR},",
          "task_id = #{taskId,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "logger_statusid = #{loggerStatusid,jdbcType=INTEGER}",
        "where logger_id = #{loggerId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskLoggerPO record);
}