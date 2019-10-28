package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ProcessListPO;
import cn.gson.oasys.model.po.ProcessListPOExample.Criteria;
import cn.gson.oasys.model.po.ProcessListPOExample.Criterion;
import cn.gson.oasys.model.po.ProcessListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProcessListPOSqlProvider {

    public String countByExample(ProcessListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_process_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProcessListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_process_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ProcessListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_process_list");
        
        if (record.getApplyTime() != null) {
            sql.VALUES("apply_time", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeeplyId() != null) {
            sql.VALUES("deeply_id", "#{deeplyId,jdbcType=BIGINT}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProcessName() != null) {
            sql.VALUES("process_name", "#{processName,jdbcType=VARCHAR}");
        }
        
        if (record.getProcseeDays() != null) {
            sql.VALUES("procsee_days", "#{procseeDays,jdbcType=INTEGER}");
        }
        
        if (record.getIsChecked() != null) {
            sql.VALUES("is_checked", "#{isChecked,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeName() != null) {
            sql.VALUES("type_name", "#{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getProFileId() != null) {
            sql.VALUES("pro_file_id", "#{proFileId,jdbcType=BIGINT}");
        }
        
        if (record.getProcessUserId() != null) {
            sql.VALUES("process_user_id", "#{processUserId,jdbcType=BIGINT}");
        }
        
        if (record.getShenuser() != null) {
            sql.VALUES("shenuser", "#{shenuser,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessDes() != null) {
            sql.VALUES("process_des", "#{processDes,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(ProcessListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("process_id");
        } else {
            sql.SELECT("process_id");
        }
        sql.SELECT("apply_time");
        sql.SELECT("deeply_id");
        sql.SELECT("end_time");
        sql.SELECT("process_name");
        sql.SELECT("procsee_days");
        sql.SELECT("is_checked");
        sql.SELECT("start_time");
        sql.SELECT("status_id");
        sql.SELECT("type_name");
        sql.SELECT("pro_file_id");
        sql.SELECT("process_user_id");
        sql.SELECT("shenuser");
        sql.SELECT("process_des");
        sql.FROM("aoa_process_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(ProcessListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("process_id");
        } else {
            sql.SELECT("process_id");
        }
        sql.SELECT("apply_time");
        sql.SELECT("deeply_id");
        sql.SELECT("end_time");
        sql.SELECT("process_name");
        sql.SELECT("procsee_days");
        sql.SELECT("is_checked");
        sql.SELECT("start_time");
        sql.SELECT("status_id");
        sql.SELECT("type_name");
        sql.SELECT("pro_file_id");
        sql.SELECT("process_user_id");
        sql.SELECT("shenuser");
        sql.FROM("aoa_process_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProcessListPO record = (ProcessListPO) parameter.get("record");
        ProcessListPOExample example = (ProcessListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_process_list");
        
        if (record.getProcessId() != null) {
            sql.SET("process_id = #{record.processId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeeplyId() != null) {
            sql.SET("deeply_id = #{record.deeplyId,jdbcType=BIGINT}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProcessName() != null) {
            sql.SET("process_name = #{record.processName,jdbcType=VARCHAR}");
        }
        
        if (record.getProcseeDays() != null) {
            sql.SET("procsee_days = #{record.procseeDays,jdbcType=INTEGER}");
        }
        
        if (record.getIsChecked() != null) {
            sql.SET("is_checked = #{record.isChecked,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeName() != null) {
            sql.SET("type_name = #{record.typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getProFileId() != null) {
            sql.SET("pro_file_id = #{record.proFileId,jdbcType=BIGINT}");
        }
        
        if (record.getProcessUserId() != null) {
            sql.SET("process_user_id = #{record.processUserId,jdbcType=BIGINT}");
        }
        
        if (record.getShenuser() != null) {
            sql.SET("shenuser = #{record.shenuser,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessDes() != null) {
            sql.SET("process_des = #{record.processDes,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_process_list");
        
        sql.SET("process_id = #{record.processId,jdbcType=BIGINT}");
        sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        sql.SET("deeply_id = #{record.deeplyId,jdbcType=BIGINT}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("process_name = #{record.processName,jdbcType=VARCHAR}");
        sql.SET("procsee_days = #{record.procseeDays,jdbcType=INTEGER}");
        sql.SET("is_checked = #{record.isChecked,jdbcType=INTEGER}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("type_name = #{record.typeName,jdbcType=VARCHAR}");
        sql.SET("pro_file_id = #{record.proFileId,jdbcType=BIGINT}");
        sql.SET("process_user_id = #{record.processUserId,jdbcType=BIGINT}");
        sql.SET("shenuser = #{record.shenuser,jdbcType=VARCHAR}");
        sql.SET("process_des = #{record.processDes,jdbcType=LONGVARCHAR}");
        
        ProcessListPOExample example = (ProcessListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_process_list");
        
        sql.SET("process_id = #{record.processId,jdbcType=BIGINT}");
        sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        sql.SET("deeply_id = #{record.deeplyId,jdbcType=BIGINT}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("process_name = #{record.processName,jdbcType=VARCHAR}");
        sql.SET("procsee_days = #{record.procseeDays,jdbcType=INTEGER}");
        sql.SET("is_checked = #{record.isChecked,jdbcType=INTEGER}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("type_name = #{record.typeName,jdbcType=VARCHAR}");
        sql.SET("pro_file_id = #{record.proFileId,jdbcType=BIGINT}");
        sql.SET("process_user_id = #{record.processUserId,jdbcType=BIGINT}");
        sql.SET("shenuser = #{record.shenuser,jdbcType=VARCHAR}");
        
        ProcessListPOExample example = (ProcessListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProcessListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_process_list");
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeeplyId() != null) {
            sql.SET("deeply_id = #{deeplyId,jdbcType=BIGINT}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProcessName() != null) {
            sql.SET("process_name = #{processName,jdbcType=VARCHAR}");
        }
        
        if (record.getProcseeDays() != null) {
            sql.SET("procsee_days = #{procseeDays,jdbcType=INTEGER}");
        }
        
        if (record.getIsChecked() != null) {
            sql.SET("is_checked = #{isChecked,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeName() != null) {
            sql.SET("type_name = #{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getProFileId() != null) {
            sql.SET("pro_file_id = #{proFileId,jdbcType=BIGINT}");
        }
        
        if (record.getProcessUserId() != null) {
            sql.SET("process_user_id = #{processUserId,jdbcType=BIGINT}");
        }
        
        if (record.getShenuser() != null) {
            sql.SET("shenuser = #{shenuser,jdbcType=VARCHAR}");
        }
        
        if (record.getProcessDes() != null) {
            sql.SET("process_des = #{processDes,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("process_id = #{processId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProcessListPOExample example, boolean includeExamplePhrase) {
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