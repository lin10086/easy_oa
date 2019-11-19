package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.TaskUserPO;
import cn.gson.oasys.model.po.TaskUserPOExample.Criteria;
import cn.gson.oasys.model.po.TaskUserPOExample.Criterion;
import cn.gson.oasys.model.po.TaskUserPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TaskUserPOSqlProvider {

    public String countByExample(TaskUserPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_task_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskUserPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_task_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TaskUserPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_task_user");
        
        if (record.getStatusId() != null) {
            sql.VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskId() != null) {
            sql.VALUES("task_id", "#{taskId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskReciveUserId() != null) {
            sql.VALUES("task_recive_user_id", "#{taskReciveUserId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskUserPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("pk_id");
        } else {
            sql.SELECT("pk_id");
        }
        sql.SELECT("status_id");
        sql.SELECT("task_id");
        sql.SELECT("task_recive_user_id");
        sql.FROM("aoa_task_user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskUserPO record = (TaskUserPO) parameter.get("record");
        TaskUserPOExample example = (TaskUserPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_user");
        
        if (record.getPkId() != null) {
            sql.SET("pk_id = #{record.pkId,jdbcType=BIGINT}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskReciveUserId() != null) {
            sql.SET("task_recive_user_id = #{record.taskReciveUserId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_user");
        
        sql.SET("pk_id = #{record.pkId,jdbcType=BIGINT}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        sql.SET("task_recive_user_id = #{record.taskReciveUserId,jdbcType=BIGINT}");
        
        TaskUserPOExample example = (TaskUserPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TaskUserPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_user");
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{taskId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskReciveUserId() != null) {
            sql.SET("task_recive_user_id = #{taskReciveUserId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("pk_id = #{pkId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskUserPOExample example, boolean includeExamplePhrase) {
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