package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.DeptPOExample;
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

public interface DeptPOMapper {
    @SelectProvider(type=DeptPOSqlProvider.class, method="countByExample")
    long countByExample(DeptPOExample example);

    @DeleteProvider(type=DeptPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(DeptPOExample example);

    @Delete({
        "delete from aoa_dept",
        "where dept_id = #{deptId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long deptId);

    @Insert({
        "insert into aoa_dept (dept_addr, dept_fax, ",
        "dept_name, dept_tel, ",
        "email, deptmanager, ",
        "end_time, start_time)",
        "values (#{deptAddr,jdbcType=VARCHAR}, #{deptFax,jdbcType=VARCHAR}, ",
        "#{deptName,jdbcType=VARCHAR}, #{deptTel,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{deptmanager,jdbcType=BIGINT}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{startTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="deptId", before=false, resultType=Long.class)
    int insert(DeptPO record);

    @InsertProvider(type=DeptPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="deptId", before=false, resultType=Long.class)
    int insertSelective(DeptPO record);

    @SelectProvider(type=DeptPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dept_addr", property="deptAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_fax", property="deptFax", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_tel", property="deptTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptmanager", property="deptmanager", jdbcType=JdbcType.BIGINT),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DeptPO> selectByExample(DeptPOExample example);

    @Select({
        "select",
        "dept_id, dept_addr, dept_fax, dept_name, dept_tel, email, deptmanager, end_time, ",
        "start_time",
        "from aoa_dept",
        "where dept_id = #{deptId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dept_addr", property="deptAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_fax", property="deptFax", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_tel", property="deptTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptmanager", property="deptmanager", jdbcType=JdbcType.BIGINT),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP)
    })
    DeptPO selectByPrimaryKey(Long deptId);

    @UpdateProvider(type=DeptPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DeptPO record, @Param("example") DeptPOExample example);

    @UpdateProvider(type=DeptPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DeptPO record, @Param("example") DeptPOExample example);

    @UpdateProvider(type=DeptPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DeptPO record);

    @Update({
        "update aoa_dept",
        "set dept_addr = #{deptAddr,jdbcType=VARCHAR},",
          "dept_fax = #{deptFax,jdbcType=VARCHAR},",
          "dept_name = #{deptName,jdbcType=VARCHAR},",
          "dept_tel = #{deptTel,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "deptmanager = #{deptmanager,jdbcType=BIGINT},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "start_time = #{startTime,jdbcType=TIMESTAMP}",
        "where dept_id = #{deptId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DeptPO record);
}