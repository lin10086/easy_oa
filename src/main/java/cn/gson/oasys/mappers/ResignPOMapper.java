package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.ResignPO;
import cn.gson.oasys.modelV2.po.ResignPOExample;
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

public interface ResignPOMapper {
    @SelectProvider(type=ResignPOSqlProvider.class, method="countByExample")
    long countByExample(ResignPOExample example);

    @DeleteProvider(type=ResignPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResignPOExample example);

    @Delete({
        "delete from aoa_resign",
        "where resign_id = #{resignId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long resignId);

    @Insert({
        "insert into aoa_resign (financial_advice, is_finish, ",
        "nofinish, personnel_advice, ",
        "suggest, hand_user, ",
        "pro_id, manager_advice)",
        "values (#{financialAdvice,jdbcType=VARCHAR}, #{isFinish,jdbcType=BIT}, ",
        "#{nofinish,jdbcType=VARCHAR}, #{personnelAdvice,jdbcType=VARCHAR}, ",
        "#{suggest,jdbcType=VARCHAR}, #{handUser,jdbcType=BIGINT}, ",
        "#{proId,jdbcType=BIGINT}, #{managerAdvice,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="resignId", before=false, resultType=Long.class)
    int insert(ResignPO record);

    @InsertProvider(type=ResignPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="resignId", before=false, resultType=Long.class)
    int insertSelective(ResignPO record);

    @SelectProvider(type=ResignPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="resign_id", property="resignId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="financial_advice", property="financialAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_finish", property="isFinish", jdbcType=JdbcType.BIT),
        @Result(column="nofinish", property="nofinish", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="suggest", property="suggest", jdbcType=JdbcType.VARCHAR),
        @Result(column="hand_user", property="handUser", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR)
    })
    List<ResignPO> selectByExample(ResignPOExample example);

    @Select({
        "select",
        "resign_id, financial_advice, is_finish, nofinish, personnel_advice, suggest, ",
        "hand_user, pro_id, manager_advice",
        "from aoa_resign",
        "where resign_id = #{resignId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="resign_id", property="resignId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="financial_advice", property="financialAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_finish", property="isFinish", jdbcType=JdbcType.BIT),
        @Result(column="nofinish", property="nofinish", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnel_advice", property="personnelAdvice", jdbcType=JdbcType.VARCHAR),
        @Result(column="suggest", property="suggest", jdbcType=JdbcType.VARCHAR),
        @Result(column="hand_user", property="handUser", jdbcType=JdbcType.BIGINT),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="manager_advice", property="managerAdvice", jdbcType=JdbcType.VARCHAR)
    })
    ResignPO selectByPrimaryKey(Long resignId);

    @UpdateProvider(type=ResignPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ResignPO record, @Param("example") ResignPOExample example);

    @UpdateProvider(type=ResignPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ResignPO record, @Param("example") ResignPOExample example);

    @UpdateProvider(type=ResignPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResignPO record);

    @Update({
        "update aoa_resign",
        "set financial_advice = #{financialAdvice,jdbcType=VARCHAR},",
          "is_finish = #{isFinish,jdbcType=BIT},",
          "nofinish = #{nofinish,jdbcType=VARCHAR},",
          "personnel_advice = #{personnelAdvice,jdbcType=VARCHAR},",
          "suggest = #{suggest,jdbcType=VARCHAR},",
          "hand_user = #{handUser,jdbcType=BIGINT},",
          "pro_id = #{proId,jdbcType=BIGINT},",
          "manager_advice = #{managerAdvice,jdbcType=VARCHAR}",
        "where resign_id = #{resignId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ResignPO record);
}