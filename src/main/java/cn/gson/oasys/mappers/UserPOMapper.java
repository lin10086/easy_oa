package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
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

public interface UserPOMapper {
    @SelectProvider(type=UserPOSqlProvider.class, method="countByExample")
    long countByExample(UserPOExample example);

    @DeleteProvider(type=UserPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserPOExample example);

    @Delete({
        "delete from aoa_user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into aoa_user (address, bank, ",
        "birth, eamil, ",
        "father_id, hire_time, ",
        "user_idcard, img_path, ",
        "is_lock, last_login_ip, ",
        "last_login_time, modify_time, ",
        "modify_user_id, password, ",
        "real_name, salary, user_school, ",
        "sex, theme_skin, ",
        "user_edu, user_name, ",
        "user_sign, user_tel, ",
        "dept_id, position_id, ",
        "role_id, superman, ",
        "holiday, pinyin)",
        "values (#{address,jdbcType=VARCHAR}, #{bank,jdbcType=VARCHAR}, ",
        "#{birth,jdbcType=TIMESTAMP}, #{eamil,jdbcType=VARCHAR}, ",
        "#{fatherId,jdbcType=BIGINT}, #{hireTime,jdbcType=TIMESTAMP}, ",
        "#{userIdcard,jdbcType=VARCHAR}, #{imgPath,jdbcType=VARCHAR}, ",
        "#{isLock,jdbcType=INTEGER}, #{lastLoginIp,jdbcType=VARCHAR}, ",
        "#{lastLoginTime,jdbcType=TIMESTAMP}, #{modifyTime,jdbcType=TIMESTAMP}, ",
        "#{modifyUserId,jdbcType=BIGINT}, #{password,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{salary,jdbcType=REAL}, #{userSchool,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{themeSkin,jdbcType=VARCHAR}, ",
        "#{userEdu,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userSign,jdbcType=VARCHAR}, #{userTel,jdbcType=VARCHAR}, ",
        "#{deptId,jdbcType=BIGINT}, #{positionId,jdbcType=BIGINT}, ",
        "#{roleId,jdbcType=BIGINT}, #{superman,jdbcType=INTEGER}, ",
        "#{holiday,jdbcType=INTEGER}, #{pinyin,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Long.class)
    int insert(UserPO record);

    @InsertProvider(type=UserPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Long.class)
    int insertSelective(UserPO record);

    @SelectProvider(type=UserPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank", property="bank", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="eamil", property="eamil", jdbcType=JdbcType.VARCHAR),
        @Result(column="father_id", property="fatherId", jdbcType=JdbcType.BIGINT),
        @Result(column="hire_time", property="hireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_idcard", property="userIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_path", property="imgPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_lock", property="isLock", jdbcType=JdbcType.INTEGER),
        @Result(column="last_login_ip", property="lastLoginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_user_id", property="modifyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.REAL),
        @Result(column="user_school", property="userSchool", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="theme_skin", property="themeSkin", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_edu", property="userEdu", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sign", property="userSign", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_tel", property="userTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT),
        @Result(column="position_id", property="positionId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="superman", property="superman", jdbcType=JdbcType.INTEGER),
        @Result(column="holiday", property="holiday", jdbcType=JdbcType.INTEGER),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR)
    })
    List<UserPO> selectByExample(UserPOExample example);

    @Select({
        "select",
        "user_id, address, bank, birth, eamil, father_id, hire_time, user_idcard, img_path, ",
        "is_lock, last_login_ip, last_login_time, modify_time, modify_user_id, password, ",
        "real_name, salary, user_school, sex, theme_skin, user_edu, user_name, user_sign, ",
        "user_tel, dept_id, position_id, role_id, superman, holiday, pinyin",
        "from aoa_user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank", property="bank", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="eamil", property="eamil", jdbcType=JdbcType.VARCHAR),
        @Result(column="father_id", property="fatherId", jdbcType=JdbcType.BIGINT),
        @Result(column="hire_time", property="hireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_idcard", property="userIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_path", property="imgPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_lock", property="isLock", jdbcType=JdbcType.INTEGER),
        @Result(column="last_login_ip", property="lastLoginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_user_id", property="modifyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.REAL),
        @Result(column="user_school", property="userSchool", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="theme_skin", property="themeSkin", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_edu", property="userEdu", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sign", property="userSign", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_tel", property="userTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.BIGINT),
        @Result(column="position_id", property="positionId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="superman", property="superman", jdbcType=JdbcType.INTEGER),
        @Result(column="holiday", property="holiday", jdbcType=JdbcType.INTEGER),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR)
    })
    UserPO selectByPrimaryKey(Long userId);

    @UpdateProvider(type=UserPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserPO record, @Param("example") UserPOExample example);

    @UpdateProvider(type=UserPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserPO record, @Param("example") UserPOExample example);

    @UpdateProvider(type=UserPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserPO record);

    @Update({
        "update aoa_user",
        "set address = #{address,jdbcType=VARCHAR},",
          "bank = #{bank,jdbcType=VARCHAR},",
          "birth = #{birth,jdbcType=TIMESTAMP},",
          "eamil = #{eamil,jdbcType=VARCHAR},",
          "father_id = #{fatherId,jdbcType=BIGINT},",
          "hire_time = #{hireTime,jdbcType=TIMESTAMP},",
          "user_idcard = #{userIdcard,jdbcType=VARCHAR},",
          "img_path = #{imgPath,jdbcType=VARCHAR},",
          "is_lock = #{isLock,jdbcType=INTEGER},",
          "last_login_ip = #{lastLoginIp,jdbcType=VARCHAR},",
          "last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP},",
          "modify_user_id = #{modifyUserId,jdbcType=BIGINT},",
          "password = #{password,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "salary = #{salary,jdbcType=REAL},",
          "user_school = #{userSchool,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "theme_skin = #{themeSkin,jdbcType=VARCHAR},",
          "user_edu = #{userEdu,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_sign = #{userSign,jdbcType=VARCHAR},",
          "user_tel = #{userTel,jdbcType=VARCHAR},",
          "dept_id = #{deptId,jdbcType=BIGINT},",
          "position_id = #{positionId,jdbcType=BIGINT},",
          "role_id = #{roleId,jdbcType=BIGINT},",
          "superman = #{superman,jdbcType=INTEGER},",
          "holiday = #{holiday,jdbcType=INTEGER},",
          "pinyin = #{pinyin,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserPO record);
}