package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.SubjectPO;
import cn.gson.oasys.model.po.SubjectPOExample;
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

public interface SubjectPOMapper {
    @SelectProvider(type=SubjectPOSqlProvider.class, method="countByExample")
    long countByExample(SubjectPOExample example);

    @DeleteProvider(type=SubjectPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(SubjectPOExample example);

    @Delete({
        "delete from aoa_subject",
        "where subject_id = #{subjectId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long subjectId);

    @Insert({
        "insert into aoa_subject (name, parent_id)",
        "values (#{name,jdbcType=VARCHAR}, #{parentId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="subjectId", before=false, resultType=Long.class)
    int insert(SubjectPO record);

    @InsertProvider(type=SubjectPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="subjectId", before=false, resultType=Long.class)
    int insertSelective(SubjectPO record);

    @SelectProvider(type=SubjectPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT)
    })
    List<SubjectPO> selectByExample(SubjectPOExample example);

    @Select({
        "select",
        "subject_id, name, parent_id",
        "from aoa_subject",
        "where subject_id = #{subjectId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT)
    })
    SubjectPO selectByPrimaryKey(Long subjectId);

    @UpdateProvider(type=SubjectPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SubjectPO record, @Param("example") SubjectPOExample example);

    @UpdateProvider(type=SubjectPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SubjectPO record, @Param("example") SubjectPOExample example);

    @UpdateProvider(type=SubjectPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SubjectPO record);

    @Update({
        "update aoa_subject",
        "set name = #{name,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=BIGINT}",
        "where subject_id = #{subjectId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SubjectPO record);
}