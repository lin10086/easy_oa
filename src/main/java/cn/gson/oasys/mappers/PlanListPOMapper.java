package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.PlanListPO;
import cn.gson.oasys.model.po.PlanListPOExample;
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

public interface PlanListPOMapper {
    @SelectProvider(type=PlanListPOSqlProvider.class, method="countByExample")
    long countByExample(PlanListPOExample example);

    @DeleteProvider(type=PlanListPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(PlanListPOExample example);

    @Delete({
        "delete from aoa_plan_list",
        "where plan_id = #{planId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long planId);

    @Insert({
        "insert into aoa_plan_list (create_time, end_time, ",
        "label, plan_comment, ",
        "plan_content, plan_summary, ",
        "start_time, status_id, ",
        "title, type_id, plan_user_id, ",
        "attach_id)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{label,jdbcType=VARCHAR}, #{planComment,jdbcType=VARCHAR}, ",
        "#{planContent,jdbcType=VARCHAR}, #{planSummary,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{statusId,jdbcType=BIGINT}, ",
        "#{title,jdbcType=VARCHAR}, #{typeId,jdbcType=BIGINT}, #{planUserId,jdbcType=BIGINT}, ",
        "#{attachId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="planId", before=false, resultType=Long.class)
    int insert(PlanListPO record);

    @InsertProvider(type=PlanListPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="planId", before=false, resultType=Long.class)
    int insertSelective(PlanListPO record);

    @SelectProvider(type=PlanListPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="plan_id", property="planId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_comment", property="planComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_content", property="planContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_summary", property="planSummary", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="plan_user_id", property="planUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="attach_id", property="attachId", jdbcType=JdbcType.BIGINT)
    })
    List<PlanListPO> selectByExample(PlanListPOExample example);

    @Select({
        "select",
        "plan_id, create_time, end_time, label, plan_comment, plan_content, plan_summary, ",
        "start_time, status_id, title, type_id, plan_user_id, attach_id",
        "from aoa_plan_list",
        "where plan_id = #{planId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="plan_id", property="planId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_comment", property="planComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_content", property="planContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="plan_summary", property="planSummary", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="plan_user_id", property="planUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="attach_id", property="attachId", jdbcType=JdbcType.BIGINT)
    })
    PlanListPO selectByPrimaryKey(Long planId);

    @UpdateProvider(type=PlanListPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PlanListPO record, @Param("example") PlanListPOExample example);

    @UpdateProvider(type=PlanListPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PlanListPO record, @Param("example") PlanListPOExample example);

    @UpdateProvider(type=PlanListPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PlanListPO record);

    @Update({
        "update aoa_plan_list",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "label = #{label,jdbcType=VARCHAR},",
          "plan_comment = #{planComment,jdbcType=VARCHAR},",
          "plan_content = #{planContent,jdbcType=VARCHAR},",
          "plan_summary = #{planSummary,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "status_id = #{statusId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "plan_user_id = #{planUserId,jdbcType=BIGINT},",
          "attach_id = #{attachId,jdbcType=BIGINT}",
        "where plan_id = #{planId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PlanListPO record);
}