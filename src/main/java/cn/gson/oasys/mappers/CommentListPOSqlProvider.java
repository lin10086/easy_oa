package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.CommentListPO;
import cn.gson.oasys.modelV2.po.CommentListPOExample.Criteria;
import cn.gson.oasys.modelV2.po.CommentListPOExample.Criterion;
import cn.gson.oasys.modelV2.po.CommentListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommentListPOSqlProvider {

    public String countByExample(CommentListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_comment_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommentListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_comment_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommentListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_comment_list");
        
        if (record.getComment() != null) {
            sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentUserId() != null) {
            sql.VALUES("comment_user_id", "#{commentUserId,jdbcType=BIGINT}");
        }
        
        if (record.getReplyId() != null) {
            sql.VALUES("reply_id", "#{replyId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommentListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("comment_id");
        } else {
            sql.SELECT("comment_id");
        }
        sql.SELECT("comment");
        sql.SELECT("time");
        sql.SELECT("comment_user_id");
        sql.SELECT("reply_id");
        sql.FROM("aoa_comment_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommentListPO record = (CommentListPO) parameter.get("record");
        CommentListPOExample example = (CommentListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_comment_list");
        
        if (record.getCommentId() != null) {
            sql.SET("comment_id = #{record.commentId,jdbcType=BIGINT}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{record.time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentUserId() != null) {
            sql.SET("comment_user_id = #{record.commentUserId,jdbcType=BIGINT}");
        }
        
        if (record.getReplyId() != null) {
            sql.SET("reply_id = #{record.replyId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_comment_list");
        
        sql.SET("comment_id = #{record.commentId,jdbcType=BIGINT}");
        sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        sql.SET("time = #{record.time,jdbcType=TIMESTAMP}");
        sql.SET("comment_user_id = #{record.commentUserId,jdbcType=BIGINT}");
        sql.SET("reply_id = #{record.replyId,jdbcType=BIGINT}");
        
        CommentListPOExample example = (CommentListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommentListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_comment_list");
        
        if (record.getComment() != null) {
            sql.SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentUserId() != null) {
            sql.SET("comment_user_id = #{commentUserId,jdbcType=BIGINT}");
        }
        
        if (record.getReplyId() != null) {
            sql.SET("reply_id = #{replyId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("comment_id = #{commentId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommentListPOExample example, boolean includeExamplePhrase) {
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