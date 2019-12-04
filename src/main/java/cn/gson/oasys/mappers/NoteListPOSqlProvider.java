package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.NoteListPO;
import cn.gson.oasys.model.po.NoteListPOExample.Criteria;
import cn.gson.oasys.model.po.NoteListPOExample.Criterion;
import cn.gson.oasys.model.po.NoteListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class NoteListPOSqlProvider {

    public String countByExample(NoteListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_note_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(NoteListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_note_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(NoteListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_note_list");
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.VALUES("type_id", "#{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getCatalogId() != null) {
            sql.VALUES("catalog_id", "#{catalogId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachId() != null) {
            sql.VALUES("attach_id", "#{attachId,jdbcType=BIGINT}");
        }
        
        if (record.getIsCollected() != null) {
            sql.VALUES("is_collected", "#{isCollected,jdbcType=BIGINT}");
        }
        
        if (record.getCreatemanId() != null) {
            sql.VALUES("createman_id", "#{createmanId,jdbcType=BIGINT}");
        }
        
        if (record.getReceiver() != null) {
            sql.VALUES("receiver", "#{receiver,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(NoteListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("note_id");
        } else {
            sql.SELECT("note_id");
        }
        sql.SELECT("content");
        sql.SELECT("create_time");
        sql.SELECT("status_id");
        sql.SELECT("title");
        sql.SELECT("type_id");
        sql.SELECT("catalog_id");
        sql.SELECT("attach_id");
        sql.SELECT("is_collected");
        sql.SELECT("createman_id");
        sql.SELECT("receiver");
        sql.FROM("aoa_note_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        NoteListPO record = (NoteListPO) parameter.get("record");
        NoteListPOExample example = (NoteListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_note_list");
        
        if (record.getNoteId() != null) {
            sql.SET("note_id = #{record.noteId,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        }
        
        if (record.getCatalogId() != null) {
            sql.SET("catalog_id = #{record.catalogId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachId() != null) {
            sql.SET("attach_id = #{record.attachId,jdbcType=BIGINT}");
        }
        
        if (record.getIsCollected() != null) {
            sql.SET("is_collected = #{record.isCollected,jdbcType=BIGINT}");
        }
        
        if (record.getCreatemanId() != null) {
            sql.SET("createman_id = #{record.createmanId,jdbcType=BIGINT}");
        }
        
        if (record.getReceiver() != null) {
            sql.SET("receiver = #{record.receiver,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_note_list");
        
        sql.SET("note_id = #{record.noteId,jdbcType=BIGINT}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("catalog_id = #{record.catalogId,jdbcType=BIGINT}");
        sql.SET("attach_id = #{record.attachId,jdbcType=BIGINT}");
        sql.SET("is_collected = #{record.isCollected,jdbcType=BIGINT}");
        sql.SET("createman_id = #{record.createmanId,jdbcType=BIGINT}");
        sql.SET("receiver = #{record.receiver,jdbcType=VARCHAR}");
        
        NoteListPOExample example = (NoteListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NoteListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_note_list");
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getCatalogId() != null) {
            sql.SET("catalog_id = #{catalogId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachId() != null) {
            sql.SET("attach_id = #{attachId,jdbcType=BIGINT}");
        }
        
        if (record.getIsCollected() != null) {
            sql.SET("is_collected = #{isCollected,jdbcType=BIGINT}");
        }
        
        if (record.getCreatemanId() != null) {
            sql.SET("createman_id = #{createmanId,jdbcType=BIGINT}");
        }
        
        if (record.getReceiver() != null) {
            sql.SET("receiver = #{receiver,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("note_id = #{noteId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NoteListPOExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}