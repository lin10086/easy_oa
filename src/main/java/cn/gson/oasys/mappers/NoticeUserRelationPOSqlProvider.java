package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.NoticeUserRelationPO;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPOExample.Criteria;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPOExample.Criterion;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class NoticeUserRelationPOSqlProvider {

    public String countByExample(NoticeUserRelationPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_notice_user_relation");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(NoticeUserRelationPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_notice_user_relation");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(NoticeUserRelationPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_notice_user_relation");
        
        if (record.getIsRead() != null) {
            sql.VALUES("is_read", "#{isRead,jdbcType=INTEGER}");
        }
        
        if (record.getRelationNoticeId() != null) {
            sql.VALUES("relation_notice_id", "#{relationNoticeId,jdbcType=BIGINT}");
        }
        
        if (record.getRelationUserId() != null) {
            sql.VALUES("relation_user_id", "#{relationUserId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(NoticeUserRelationPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("relation_id");
        } else {
            sql.SELECT("relation_id");
        }
        sql.SELECT("is_read");
        sql.SELECT("relation_notice_id");
        sql.SELECT("relation_user_id");
        sql.FROM("aoa_notice_user_relation");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        NoticeUserRelationPO record = (NoticeUserRelationPO) parameter.get("record");
        NoticeUserRelationPOExample example = (NoticeUserRelationPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_notice_user_relation");
        
        if (record.getRelationId() != null) {
            sql.SET("relation_id = #{record.relationId,jdbcType=BIGINT}");
        }
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{record.isRead,jdbcType=INTEGER}");
        }
        
        if (record.getRelationNoticeId() != null) {
            sql.SET("relation_notice_id = #{record.relationNoticeId,jdbcType=BIGINT}");
        }
        
        if (record.getRelationUserId() != null) {
            sql.SET("relation_user_id = #{record.relationUserId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_notice_user_relation");
        
        sql.SET("relation_id = #{record.relationId,jdbcType=BIGINT}");
        sql.SET("is_read = #{record.isRead,jdbcType=INTEGER}");
        sql.SET("relation_notice_id = #{record.relationNoticeId,jdbcType=BIGINT}");
        sql.SET("relation_user_id = #{record.relationUserId,jdbcType=BIGINT}");
        
        NoticeUserRelationPOExample example = (NoticeUserRelationPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NoticeUserRelationPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_notice_user_relation");
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{isRead,jdbcType=INTEGER}");
        }
        
        if (record.getRelationNoticeId() != null) {
            sql.SET("relation_notice_id = #{relationNoticeId,jdbcType=BIGINT}");
        }
        
        if (record.getRelationUserId() != null) {
            sql.SET("relation_user_id = #{relationUserId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("relation_id = #{relationId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NoticeUserRelationPOExample example, boolean includeExamplePhrase) {
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