package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.TaskUserPO;
import cn.gson.oasys.model.po.TaskUserPOExample;
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

public interface TaskUserPOMapper {
    @SelectProvider(type=TaskUserPOSqlProvider.class, method="countByExample")
    long countByExample(TaskUserPOExample example);

    @DeleteProvider(type=TaskUserPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskUserPOExample example);

    @Delete({
        "delete from aoa_task_user",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long pkId);

    @Insert({
        "insert into aoa_task_user (status_id, task_id, ",
        "task_recive_user_id)",
        "values (#{statusId,jdbcType=BIGINT}, #{taskId,jdbcType=BIGINT}, ",
        "#{taskReciveUserId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pkId", before=false, resultType=Long.class)
    int insert(TaskUserPO record);

    @InsertProvider(type=TaskUserPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pkId", before=false, resultType=Long.class)
    int insertSelective(TaskUserPO record);

    @SelectProvider(type=TaskUserPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="pk_id", property="pkId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_recive_user_id", property="taskReciveUserId", jdbcType=JdbcType.BIGINT)
    })
    List<TaskUserPO> selectByExample(TaskUserPOExample example);

    @Select({
        "select",
        "pk_id, status_id, task_id, task_recive_user_id",
        "from aoa_task_user",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="pk_id", property="pkId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_recive_user_id", property="taskReciveUserId", jdbcType=JdbcType.BIGINT)
    })
    TaskUserPO selectByPrimaryKey(Long pkId);

    @UpdateProvider(type=TaskUserPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskUserPO record, @Param("example") TaskUserPOExample example);

    @UpdateProvider(type=TaskUserPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskUserPO record, @Param("example") TaskUserPOExample example);

    @UpdateProvider(type=TaskUserPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskUserPO record);

    @Update({
        "update aoa_task_user",
        "set status_id = #{statusId,jdbcType=BIGINT},",
          "task_id = #{taskId,jdbcType=BIGINT},",
          "task_recive_user_id = #{taskReciveUserId,jdbcType=BIGINT}",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskUserPO record);
}