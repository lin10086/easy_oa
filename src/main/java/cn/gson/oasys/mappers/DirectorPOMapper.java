package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.DirectorPO;
import cn.gson.oasys.model.po.DirectorPOExample;
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

public interface DirectorPOMapper {
    @SelectProvider(type=DirectorPOSqlProvider.class, method="countByExample")
    long countByExample(DirectorPOExample example);

    @DeleteProvider(type=DirectorPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(DirectorPOExample example);

    @Delete({
        "delete from aoa_director",
        "where director_id = #{directorId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long directorId);

    @Insert({
        "insert into aoa_director (address, company_number, ",
        "email, image_path, ",
        "phone_number, pinyin, ",
        "remark, sex, user_name, ",
        "user_id, companyname)",
        "values (#{address,jdbcType=VARCHAR}, #{companyNumber,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{imagePath,jdbcType=INTEGER}, ",
        "#{phoneNumber,jdbcType=VARCHAR}, #{pinyin,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=BIGINT}, #{companyname,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="directorId", before=false, resultType=Long.class)
    int insert(DirectorPO record);

    @InsertProvider(type=DirectorPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="directorId", before=false, resultType=Long.class)
    int insertSelective(DirectorPO record);

    @SelectProvider(type=DirectorPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="director_id", property="directorId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_number", property="companyNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="image_path", property="imagePath", jdbcType=JdbcType.INTEGER),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyname", property="companyname", jdbcType=JdbcType.VARCHAR)
    })
    List<DirectorPO> selectByExample(DirectorPOExample example);

    @Select({
        "select",
        "director_id, address, company_number, email, image_path, phone_number, pinyin, ",
        "remark, sex, user_name, user_id, companyname",
        "from aoa_director",
        "where director_id = #{directorId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="director_id", property="directorId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_number", property="companyNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="image_path", property="imagePath", jdbcType=JdbcType.INTEGER),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyname", property="companyname", jdbcType=JdbcType.VARCHAR)
    })
    DirectorPO selectByPrimaryKey(Long directorId);

    @UpdateProvider(type=DirectorPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DirectorPO record, @Param("example") DirectorPOExample example);

    @UpdateProvider(type=DirectorPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DirectorPO record, @Param("example") DirectorPOExample example);

    @UpdateProvider(type=DirectorPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DirectorPO record);

    @Update({
        "update aoa_director",
        "set address = #{address,jdbcType=VARCHAR},",
          "company_number = #{companyNumber,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "image_path = #{imagePath,jdbcType=INTEGER},",
          "phone_number = #{phoneNumber,jdbcType=VARCHAR},",
          "pinyin = #{pinyin,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "companyname = #{companyname,jdbcType=VARCHAR}",
        "where director_id = #{directorId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DirectorPO record);
}