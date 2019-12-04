package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ReceiverNotePO;
import cn.gson.oasys.model.po.ReceiverNotePOExample;
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

public interface ReceiverNotePOMapper {
    @SelectProvider(type=ReceiverNotePOSqlProvider.class, method="countByExample")
    long countByExample(ReceiverNotePOExample example);

    @DeleteProvider(type=ReceiverNotePOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReceiverNotePOExample example);

    @Delete({
        "delete from aoa_receiver_note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into aoa_receiver_note (note_id, user_id)",
        "values (#{noteId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ReceiverNotePO record);

    @InsertProvider(type=ReceiverNotePOSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ReceiverNotePO record);

    @SelectProvider(type=ReceiverNotePOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    List<ReceiverNotePO> selectByExample(ReceiverNotePOExample example);

    @Select({
        "select",
        "id, note_id, user_id",
        "from aoa_receiver_note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="note_id", property="noteId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    ReceiverNotePO selectByPrimaryKey(Long id);

    @UpdateProvider(type=ReceiverNotePOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReceiverNotePO record, @Param("example") ReceiverNotePOExample example);

    @UpdateProvider(type=ReceiverNotePOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReceiverNotePO record, @Param("example") ReceiverNotePOExample example);

    @UpdateProvider(type=ReceiverNotePOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReceiverNotePO record);

    @Update({
        "update aoa_receiver_note",
        "set note_id = #{noteId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReceiverNotePO record);
}