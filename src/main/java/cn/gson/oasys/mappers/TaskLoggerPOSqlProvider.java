package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.TaskLoggerPO;
import cn.gson.oasys.modelV2.po.TaskLoggerPOExample.Criteria;
import cn.gson.oasys.modelV2.po.TaskLoggerPOExample.Criterion;
import cn.gson.oasys.modelV2.po.TaskLoggerPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TaskLoggerPOSqlProvider {

    public String countByExample(TaskLoggerPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_task_logger");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskLoggerPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_task_logger");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TaskLoggerPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_task_logger");
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoggerTicking() != null) {
            sql.VALUES("logger_ticking", "#{loggerTicking,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskId() != null) {
            sql.VALUES("task_id", "#{taskId,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getLoggerStatusid() != null) {
            sql.VALUES("logger_statusid", "#{loggerStatusid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskLoggerPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("logger_id");
        } else {
            sql.SELECT("logger_id");
        }
        sql.SELECT("create_time");
        sql.SELECT("logger_ticking");
        sql.SELECT("task_id");
        sql.SELECT("username");
        sql.SELECT("logger_statusid");
        sql.FROM("aoa_task_logger");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskLoggerPO record = (TaskLoggerPO) parameter.get("record");
        TaskLoggerPOExample example = (TaskLoggerPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_logger");
        
        if (record.getLoggerId() != null) {
            sql.SET("logger_id = #{record.loggerId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoggerTicking() != null) {
            sql.SET("logger_ticking = #{record.loggerTicking,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getLoggerStatusid() != null) {
            sql.SET("logger_statusid = #{record.loggerStatusid,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_logger");
        
        sql.SET("logger_id = #{record.loggerId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("logger_ticking = #{record.loggerTicking,jdbcType=VARCHAR}");
        sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        sql.SET("logger_statusid = #{record.loggerStatusid,jdbcType=INTEGER}");
        
        TaskLoggerPOExample example = (TaskLoggerPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TaskLoggerPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_logger");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoggerTicking() != null) {
            sql.SET("logger_ticking = #{loggerTicking,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{taskId,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getLoggerStatusid() != null) {
            sql.SET("logger_statusid = #{loggerStatusid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("logger_id = #{loggerId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskLoggerPOExample example, boolean includeExamplePhrase) {
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