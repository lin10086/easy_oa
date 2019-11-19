package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.TaskListPO;
import cn.gson.oasys.model.po.TaskListPOExample;
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

public interface TaskListPOMapper {
    @SelectProvider(type=TaskListPOSqlProvider.class, method="countByExample")
    long countByExample(TaskListPOExample example);

    @DeleteProvider(type=TaskListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskListPOExample example);

    @Delete({
        "delete from aoa_task_list",
        "where task_id = #{taskId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long taskId);

    @Insert({
        "insert into aoa_task_list (comment, end_time, ",
        "is_cancel, is_top, ",
        "modify_time, publish_time, ",
        "star_time, status_id, ",
        "task_describe, ticking, ",
        "title, type_id, task_push_user_id, ",
        "reciverlist)",
        "values (#{comment,jdbcType=VARCHAR}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{isCancel,jdbcType=INTEGER}, #{isTop,jdbcType=INTEGER}, ",
        "#{modifyTime,jdbcType=TIMESTAMP}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{starTime,jdbcType=TIMESTAMP}, #{statusId,jdbcType=INTEGER}, ",
        "#{taskDescribe,jdbcType=VARCHAR}, #{ticking,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{typeId,jdbcType=BIGINT}, #{taskPushUserId,jdbcType=BIGINT}, ",
        "#{reciverlist,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="taskId", before=false, resultType=Long.class)
    int insert(TaskListPO record);

    @InsertProvider(type=TaskListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="taskId", before=false, resultType=Long.class)
    int insertSelective(TaskListPO record);

    @SelectProvider(type=TaskListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_cancel", property="isCancel", jdbcType=JdbcType.INTEGER),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="star_time", property="starTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.INTEGER),
        @Result(column="task_describe", property="taskDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="ticking", property="ticking", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_push_user_id", property="taskPushUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="reciverlist", property="reciverlist", jdbcType=JdbcType.VARCHAR)
    })
    List<TaskListPO> selectByExample(TaskListPOExample example);

    @Select({
        "select",
        "task_id, comment, end_time, is_cancel, is_top, modify_time, publish_time, star_time, ",
        "status_id, task_describe, ticking, title, type_id, task_push_user_id, reciverlist",
        "from aoa_task_list",
        "where task_id = #{taskId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_cancel", property="isCancel", jdbcType=JdbcType.INTEGER),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="star_time", property="starTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.INTEGER),
        @Result(column="task_describe", property="taskDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="ticking", property="ticking", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_push_user_id", property="taskPushUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="reciverlist", property="reciverlist", jdbcType=JdbcType.VARCHAR)
    })
    TaskListPO selectByPrimaryKey(Long taskId);

    @UpdateProvider(type=TaskListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskListPO record, @Param("example") TaskListPOExample example);

    @UpdateProvider(type=TaskListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskListPO record, @Param("example") TaskListPOExample example);

    @UpdateProvider(type=TaskListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskListPO record);

    @Update({
        "update aoa_task_list",
        "set comment = #{comment,jdbcType=VARCHAR},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "is_cancel = #{isCancel,jdbcType=INTEGER},",
          "is_top = #{isTop,jdbcType=INTEGER},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "star_time = #{starTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=INTEGER},",
          "task_describe = #{taskDescribe,jdbcType=VARCHAR},",
          "ticking = #{ticking,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "task_push_user_id = #{taskPushUserId,jdbcType=BIGINT},",
          "reciverlist = #{reciverlist,jdbcType=VARCHAR}",
        "where task_id = #{taskId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskListPO record);
}