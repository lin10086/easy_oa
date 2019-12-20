package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ReplyListPO;
import cn.gson.oasys.model.po.ReplyListPOExample.Criteria;
import cn.gson.oasys.model.po.ReplyListPOExample.Criterion;
import cn.gson.oasys.model.po.ReplyListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ReplyListPOSqlProvider {

    public String countByExample(ReplyListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_reply_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReplyListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_reply_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReplyListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_reply_list");
        
        if (record.getReplayTime() != null) {
            sql.VALUES("replay_time", "#{replayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDiscussId() != null) {
            sql.VALUES("discuss_id", "#{discussId,jdbcType=BIGINT}");
        }
        
        if (record.getReplyUserId() != null) {
            sql.VALUES("reply_user_id", "#{replyUserId,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(ReplyListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("reply_id");
        } else {
            sql.SELECT("reply_id");
        }
        sql.SELECT("replay_time");
        sql.SELECT("discuss_id");
        sql.SELECT("reply_user_id");
        sql.SELECT("content");
        sql.FROM("aoa_reply_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(ReplyListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("reply_id");
        } else {
            sql.SELECT("reply_id");
        }
        sql.SELECT("replay_time");
        sql.SELECT("discuss_id");
        sql.SELECT("reply_user_id");
        sql.FROM("aoa_reply_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReplyListPO record = (ReplyListPO) parameter.get("record");
        ReplyListPOExample example = (ReplyListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_reply_list");
        
        if (record.getReplyId() != null) {
            sql.SET("reply_id = #{record.replyId,jdbcType=BIGINT}");
        }
        
        if (record.getReplayTime() != null) {
            sql.SET("replay_time = #{record.replayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDiscussId() != null) {
            sql.SET("discuss_id = #{record.discussId,jdbcType=BIGINT}");
        }
        
        if (record.getReplyUserId() != null) {
            sql.SET("reply_user_id = #{record.replyUserId,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_reply_list");
        
        sql.SET("reply_id = #{record.replyId,jdbcType=BIGINT}");
        sql.SET("replay_time = #{record.replayTime,jdbcType=TIMESTAMP}");
        sql.SET("discuss_id = #{record.discussId,jdbcType=BIGINT}");
        sql.SET("reply_user_id = #{record.replyUserId,jdbcType=BIGINT}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        ReplyListPOExample example = (ReplyListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_reply_list");
        
        sql.SET("reply_id = #{record.replyId,jdbcType=BIGINT}");
        sql.SET("replay_time = #{record.replayTime,jdbcType=TIMESTAMP}");
        sql.SET("discuss_id = #{record.discussId,jdbcType=BIGINT}");
        sql.SET("reply_user_id = #{record.replyUserId,jdbcType=BIGINT}");
        
        ReplyListPOExample example = (ReplyListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReplyListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_reply_list");
        
        if (record.getReplayTime() != null) {
            sql.SET("replay_time = #{replayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDiscussId() != null) {
            sql.SET("discuss_id = #{discussId,jdbcType=BIGINT}");
        }
        
        if (record.getReplyUserId() != null) {
            sql.SET("reply_user_id = #{replyUserId,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("reply_id = #{replyId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReplyListPOExample example, boolean includeExamplePhrase) {
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