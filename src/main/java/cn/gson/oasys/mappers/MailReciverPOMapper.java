package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.MailReciverPO;
import cn.gson.oasys.modelV2.po.MailReciverPOExample;
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

public interface MailReciverPOMapper {
    @SelectProvider(type=MailReciverPOSqlProvider.class, method="countByExample")
    long countByExample(MailReciverPOExample example);

    @DeleteProvider(type=MailReciverPOSqlProvider.class, method="deleteByExample")
    int deleteByExample(MailReciverPOExample example);

    @Delete({
        "delete from aoa_mail_reciver",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long pkId);

    @Insert({
        "insert into aoa_mail_reciver (is_read, mail_id, ",
        "mail_reciver_id, is_star, ",
        "is_del)",
        "values (#{isRead,jdbcType=INTEGER}, #{mailId,jdbcType=BIGINT}, ",
        "#{mailReciverId,jdbcType=BIGINT}, #{isStar,jdbcType=INTEGER}, ",
        "#{isDel,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pkId", before=false, resultType=Long.class)
    int insert(MailReciverPO record);

    @InsertProvider(type=MailReciverPOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="pkId", before=false, resultType=Long.class)
    int insertSelective(MailReciverPO record);

    @SelectProvider(type=MailReciverPOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="pk_id", property="pkId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_id", property="mailId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_reciver_id", property="mailReciverId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_star", property="isStar", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER)
    })
    List<MailReciverPO> selectByExample(MailReciverPOExample example);

    @Select({
        "select",
        "pk_id, is_read, mail_id, mail_reciver_id, is_star, is_del",
        "from aoa_mail_reciver",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="pk_id", property="pkId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.INTEGER),
        @Result(column="mail_id", property="mailId", jdbcType=JdbcType.BIGINT),
        @Result(column="mail_reciver_id", property="mailReciverId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_star", property="isStar", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER)
    })
    MailReciverPO selectByPrimaryKey(Long pkId);

    @UpdateProvider(type=MailReciverPOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MailReciverPO record, @Param("example") MailReciverPOExample example);

    @UpdateProvider(type=MailReciverPOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MailReciverPO record, @Param("example") MailReciverPOExample example);

    @UpdateProvider(type=MailReciverPOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MailReciverPO record);

    @Update({
        "update aoa_mail_reciver",
        "set is_read = #{isRead,jdbcType=INTEGER},",
          "mail_id = #{mailId,jdbcType=BIGINT},",
          "mail_reciver_id = #{mailReciverId,jdbcType=BIGINT},",
          "is_star = #{isStar,jdbcType=INTEGER},",
          "is_del = #{isDel,jdbcType=INTEGER}",
        "where pk_id = #{pkId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MailReciverPO record);
}