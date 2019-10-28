package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ProcessListPO;
import cn.gson.oasys.model.po.ProcessListPOExample;
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

public interface ProcessListPOMapper {
    @SelectProvider(type=ProcessListPOSqlProvider.class, method="countByExample")
    long countByExample(ProcessListPOExample example);

    @DeleteProvider(type=ProcessListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProcessListPOExample example);

    @Delete({
        "delete from aoa_process_list",
        "where process_id = #{processId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long processId);

    @Insert({
        "insert into aoa_process_list (apply_time, deeply_id, ",
        "end_time, process_name, ",
        "procsee_days, is_checked, ",
        "start_time, status_id, ",
        "type_name, pro_file_id, ",
        "process_user_id, shenuser, ",
        "process_des)",
        "values (#{applyTime,jdbcType=TIMESTAMP}, #{deeplyId,jdbcType=BIGINT}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{processName,jdbcType=VARCHAR}, ",
        "#{procseeDays,jdbcType=INTEGER}, #{isChecked,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{statusId,jdbcType=BIGINT}, ",
        "#{typeName,jdbcType=VARCHAR}, #{proFileId,jdbcType=BIGINT}, ",
        "#{processUserId,jdbcType=BIGINT}, #{shenuser,jdbcType=VARCHAR}, ",
        "#{processDes,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="processId", before=false, resultType=Long.class)
    int insert(ProcessListPO record);

    @InsertProvider(type=ProcessListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="processId", before=false, resultType=Long.class)
    int insertSelective(ProcessListPO record);

    @SelectProvider(type=ProcessListPOSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="process_id", property="processId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deeply_id", property="deeplyId", jdbcType=JdbcType.BIGINT),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="process_name", property="processName", jdbcType=JdbcType.VARCHAR),
        @Result(column="procsee_days", property="procseeDays", jdbcType=JdbcType.INTEGER),
        @Result(column="is_checked", property="isChecked", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_file_id", property="proFileId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_user_id", property="processUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="shenuser", property="shenuser", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_des", property="processDes", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ProcessListPO> selectByExampleWithBLOBs(ProcessListPOExample example);

    @SelectProvider(type=ProcessListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="process_id", property="processId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deeply_id", property="deeplyId", jdbcType=JdbcType.BIGINT),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="process_name", property="processName", jdbcType=JdbcType.VARCHAR),
        @Result(column="procsee_days", property="procseeDays", jdbcType=JdbcType.INTEGER),
        @Result(column="is_checked", property="isChecked", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_file_id", property="proFileId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_user_id", property="processUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="shenuser", property="shenuser", jdbcType=JdbcType.VARCHAR)
    })
    List<ProcessListPO> selectByExample(ProcessListPOExample example);

    @Select({
        "select",
        "process_id, apply_time, deeply_id, end_time, process_name, procsee_days, is_checked, ",
        "start_time, status_id, type_name, pro_file_id, process_user_id, shenuser, process_des",
        "from aoa_process_list",
        "where process_id = #{processId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="process_id", property="processId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deeply_id", property="deeplyId", jdbcType=JdbcType.BIGINT),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="process_name", property="processName", jdbcType=JdbcType.VARCHAR),
        @Result(column="procsee_days", property="procseeDays", jdbcType=JdbcType.INTEGER),
        @Result(column="is_checked", property="isChecked", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_file_id", property="proFileId", jdbcType=JdbcType.BIGINT),
        @Result(column="process_user_id", property="processUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="shenuser", property="shenuser", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_des", property="processDes", jdbcType=JdbcType.LONGVARCHAR)
    })
    ProcessListPO selectByPrimaryKey(Long processId);

    @UpdateProvider(type=ProcessListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProcessListPO record, @Param("example") ProcessListPOExample example);

    @UpdateProvider(type=ProcessListPOSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ProcessListPO record, @Param("example") ProcessListPOExample example);

    @UpdateProvider(type=ProcessListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProcessListPO record, @Param("example") ProcessListPOExample example);

    @UpdateProvider(type=ProcessListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProcessListPO record);

    @Update({
        "update aoa_process_list",
        "set apply_time = #{applyTime,jdbcType=TIMESTAMP},",
          "deeply_id = #{deeplyId,jdbcType=BIGINT},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "process_name = #{processName,jdbcType=VARCHAR},",
          "procsee_days = #{procseeDays,jdbcType=INTEGER},",
          "is_checked = #{isChecked,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "pro_file_id = #{proFileId,jdbcType=BIGINT},",
          "process_user_id = #{processUserId,jdbcType=BIGINT},",
          "shenuser = #{shenuser,jdbcType=VARCHAR},",
          "process_des = #{processDes,jdbcType=LONGVARCHAR}",
        "where process_id = #{processId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ProcessListPO record);

    @Update({
        "update aoa_process_list",
        "set apply_time = #{applyTime,jdbcType=TIMESTAMP},",
          "deeply_id = #{deeplyId,jdbcType=BIGINT},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "process_name = #{processName,jdbcType=VARCHAR},",
          "procsee_days = #{procseeDays,jdbcType=INTEGER},",
          "is_checked = #{isChecked,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "pro_file_id = #{proFileId,jdbcType=BIGINT},",
          "process_user_id = #{processUserId,jdbcType=BIGINT},",
          "shenuser = #{shenuser,jdbcType=VARCHAR}",
        "where process_id = #{processId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProcessListPO record);
}