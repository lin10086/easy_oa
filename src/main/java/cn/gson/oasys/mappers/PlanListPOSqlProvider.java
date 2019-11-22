package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.PlanListPO;
import cn.gson.oasys.model.po.PlanListPOExample.Criteria;
import cn.gson.oasys.model.po.PlanListPOExample.Criterion;
import cn.gson.oasys.model.po.PlanListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PlanListPOSqlProvider {

    public String countByExample(PlanListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_plan_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PlanListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_plan_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PlanListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_plan_list");
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLabel() != null) {
            sql.VALUES("label", "#{label,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanComment() != null) {
            sql.VALUES("plan_comment", "#{planComment,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanContent() != null) {
            sql.VALUES("plan_content", "#{planContent,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanSummary() != null) {
            sql.VALUES("plan_summary", "#{planSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getPlanUserId() != null) {
            sql.VALUES("plan_user_id", "#{planUserId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachId() != null) {
            sql.VALUES("attach_id", "#{attachId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PlanListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("plan_id");
        } else {
            sql.SELECT("plan_id");
        }
        sql.SELECT("create_time");
        sql.SELECT("end_time");
        sql.SELECT("label");
        sql.SELECT("plan_comment");
        sql.SELECT("plan_content");
        sql.SELECT("plan_summary");
        sql.SELECT("start_time");
        sql.SELECT("status_id");
        sql.SELECT("title");
        sql.SELECT("type_id");
        sql.SELECT("plan_user_id");
        sql.SELECT("attach_id");
        sql.FROM("aoa_plan_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PlanListPO record = (PlanListPO) parameter.get("record");
        PlanListPOExample example = (PlanListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_plan_list");
        
        if (record.getPlanId() != null) {
            sql.SET("plan_id = #{record.planId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLabel() != null) {
            sql.SET("label = #{record.label,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanComment() != null) {
            sql.SET("plan_comment = #{record.planComment,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanContent() != null) {
            sql.SET("plan_content = #{record.planContent,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanSummary() != null) {
            sql.SET("plan_summary = #{record.planSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getPlanUserId() != null) {
            sql.SET("plan_user_id = #{record.planUserId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachId() != null) {
            sql.SET("attach_id = #{record.attachId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_plan_list");
        
        sql.SET("plan_id = #{record.planId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("label = #{record.label,jdbcType=VARCHAR}");
        sql.SET("plan_comment = #{record.planComment,jdbcType=VARCHAR}");
        sql.SET("plan_content = #{record.planContent,jdbcType=VARCHAR}");
        sql.SET("plan_summary = #{record.planSummary,jdbcType=VARCHAR}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("plan_user_id = #{record.planUserId,jdbcType=BIGINT}");
        sql.SET("attach_id = #{record.attachId,jdbcType=BIGINT}");
        
        PlanListPOExample example = (PlanListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PlanListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_plan_list");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLabel() != null) {
            sql.SET("label = #{label,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanComment() != null) {
            sql.SET("plan_comment = #{planComment,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanContent() != null) {
            sql.SET("plan_content = #{planContent,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanSummary() != null) {
            sql.SET("plan_summary = #{planSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getPlanUserId() != null) {
            sql.SET("plan_user_id = #{planUserId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachId() != null) {
            sql.SET("attach_id = #{attachId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("plan_id = #{planId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PlanListPOExample example, boolean includeExamplePhrase) {
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