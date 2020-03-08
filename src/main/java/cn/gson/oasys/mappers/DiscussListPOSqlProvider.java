package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.DiscussListPO;
import cn.gson.oasys.modelV2.po.DiscussListPOExample.Criteria;
import cn.gson.oasys.modelV2.po.DiscussListPOExample.Criterion;
import cn.gson.oasys.modelV2.po.DiscussListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DiscussListPOSqlProvider {

    public String countByExample(DiscussListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_discuss_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DiscussListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_discuss_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(DiscussListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_discuss_list");
        
        if (record.getAttachmentId() != null) {
            sql.VALUES("attachment_id", "#{attachmentId,jdbcType=INTEGER}");
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
        
        if (record.getVisitNum() != null) {
            sql.VALUES("visit_num", "#{visitNum,jdbcType=INTEGER}");
        }
        
        if (record.getDiscussUserId() != null) {
            sql.VALUES("discuss_user_id", "#{discussUserId,jdbcType=BIGINT}");
        }
        
        if (record.getVoteId() != null) {
            sql.VALUES("vote_id", "#{voteId,jdbcType=BIGINT}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(DiscussListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("discuss_id");
        } else {
            sql.SELECT("discuss_id");
        }
        sql.SELECT("attachment_id");
        sql.SELECT("create_time");
        sql.SELECT("status_id");
        sql.SELECT("title");
        sql.SELECT("type_id");
        sql.SELECT("visit_num");
        sql.SELECT("discuss_user_id");
        sql.SELECT("vote_id");
        sql.SELECT("modify_time");
        sql.SELECT("content");
        sql.FROM("aoa_discuss_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(DiscussListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("discuss_id");
        } else {
            sql.SELECT("discuss_id");
        }
        sql.SELECT("attachment_id");
        sql.SELECT("create_time");
        sql.SELECT("status_id");
        sql.SELECT("title");
        sql.SELECT("type_id");
        sql.SELECT("visit_num");
        sql.SELECT("discuss_user_id");
        sql.SELECT("vote_id");
        sql.SELECT("modify_time");
        sql.FROM("aoa_discuss_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        DiscussListPO record = (DiscussListPO) parameter.get("record");
        DiscussListPOExample example = (DiscussListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_discuss_list");
        
        if (record.getDiscussId() != null) {
            sql.SET("discuss_id = #{record.discussId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachmentId() != null) {
            sql.SET("attachment_id = #{record.attachmentId,jdbcType=INTEGER}");
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
        
        if (record.getVisitNum() != null) {
            sql.SET("visit_num = #{record.visitNum,jdbcType=INTEGER}");
        }
        
        if (record.getDiscussUserId() != null) {
            sql.SET("discuss_user_id = #{record.discussUserId,jdbcType=BIGINT}");
        }
        
        if (record.getVoteId() != null) {
            sql.SET("vote_id = #{record.voteId,jdbcType=BIGINT}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_discuss_list");
        
        sql.SET("discuss_id = #{record.discussId,jdbcType=BIGINT}");
        sql.SET("attachment_id = #{record.attachmentId,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("visit_num = #{record.visitNum,jdbcType=INTEGER}");
        sql.SET("discuss_user_id = #{record.discussUserId,jdbcType=BIGINT}");
        sql.SET("vote_id = #{record.voteId,jdbcType=BIGINT}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        DiscussListPOExample example = (DiscussListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_discuss_list");
        
        sql.SET("discuss_id = #{record.discussId,jdbcType=BIGINT}");
        sql.SET("attachment_id = #{record.attachmentId,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("visit_num = #{record.visitNum,jdbcType=INTEGER}");
        sql.SET("discuss_user_id = #{record.discussUserId,jdbcType=BIGINT}");
        sql.SET("vote_id = #{record.voteId,jdbcType=BIGINT}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        DiscussListPOExample example = (DiscussListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DiscussListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_discuss_list");
        
        if (record.getAttachmentId() != null) {
            sql.SET("attachment_id = #{attachmentId,jdbcType=INTEGER}");
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
        
        if (record.getVisitNum() != null) {
            sql.SET("visit_num = #{visitNum,jdbcType=INTEGER}");
        }
        
        if (record.getDiscussUserId() != null) {
            sql.SET("discuss_user_id = #{discussUserId,jdbcType=BIGINT}");
        }
        
        if (record.getVoteId() != null) {
            sql.SET("vote_id = #{voteId,jdbcType=BIGINT}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("discuss_id = #{discussId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DiscussListPOExample example, boolean includeExamplePhrase) {
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