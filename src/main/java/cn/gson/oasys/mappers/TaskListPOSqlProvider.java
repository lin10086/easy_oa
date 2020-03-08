package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.TaskListPO;
import cn.gson.oasys.modelV2.po.TaskListPOExample.Criteria;
import cn.gson.oasys.modelV2.po.TaskListPOExample.Criterion;
import cn.gson.oasys.modelV2.po.TaskListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TaskListPOSqlProvider {

    public String countByExample(TaskListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_task_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_task_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TaskListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_task_list");
        
        if (record.getComment() != null) {
            sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsCancel() != null) {
            sql.VALUES("is_cancel", "#{isCancel,jdbcType=INTEGER}");
        }
        
        if (record.getIsTop() != null) {
            sql.VALUES("is_top", "#{isTop,jdbcType=INTEGER}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStarTime() != null) {
            sql.VALUES("star_time", "#{starTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.VALUES("status_id", "#{statusId,jdbcType=INTEGER}");
        }
        
        if (record.getTaskDescribe() != null) {
            sql.VALUES("task_describe", "#{taskDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getTicking() != null) {
            sql.VALUES("ticking", "#{ticking,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.VALUES("type_id", "#{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskPushUserId() != null) {
            sql.VALUES("task_push_user_id", "#{taskPushUserId,jdbcType=BIGINT}");
        }
        
        if (record.getReciverlist() != null) {
            sql.VALUES("reciverlist", "#{reciverlist,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("task_id");
        } else {
            sql.SELECT("task_id");
        }
        sql.SELECT("comment");
        sql.SELECT("end_time");
        sql.SELECT("is_cancel");
        sql.SELECT("is_top");
        sql.SELECT("modify_time");
        sql.SELECT("publish_time");
        sql.SELECT("star_time");
        sql.SELECT("status_id");
        sql.SELECT("task_describe");
        sql.SELECT("ticking");
        sql.SELECT("title");
        sql.SELECT("type_id");
        sql.SELECT("task_push_user_id");
        sql.SELECT("reciverlist");
        sql.FROM("aoa_task_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskListPO record = (TaskListPO) parameter.get("record");
        TaskListPOExample example = (TaskListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_list");
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        }
        
        if (record.getComment() != null) {
            sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsCancel() != null) {
            sql.SET("is_cancel = #{record.isCancel,jdbcType=INTEGER}");
        }
        
        if (record.getIsTop() != null) {
            sql.SET("is_top = #{record.isTop,jdbcType=INTEGER}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{record.publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStarTime() != null) {
            sql.SET("star_time = #{record.starTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{record.statusId,jdbcType=INTEGER}");
        }
        
        if (record.getTaskDescribe() != null) {
            sql.SET("task_describe = #{record.taskDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getTicking() != null) {
            sql.SET("ticking = #{record.ticking,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskPushUserId() != null) {
            sql.SET("task_push_user_id = #{record.taskPushUserId,jdbcType=BIGINT}");
        }
        
        if (record.getReciverlist() != null) {
            sql.SET("reciverlist = #{record.reciverlist,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_list");
        
        sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("is_cancel = #{record.isCancel,jdbcType=INTEGER}");
        sql.SET("is_top = #{record.isTop,jdbcType=INTEGER}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        sql.SET("publish_time = #{record.publishTime,jdbcType=TIMESTAMP}");
        sql.SET("star_time = #{record.starTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=INTEGER}");
        sql.SET("task_describe = #{record.taskDescribe,jdbcType=VARCHAR}");
        sql.SET("ticking = #{record.ticking,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("task_push_user_id = #{record.taskPushUserId,jdbcType=BIGINT}");
        sql.SET("reciverlist = #{record.reciverlist,jdbcType=VARCHAR}");
        
        TaskListPOExample example = (TaskListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TaskListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_task_list");
        
        if (record.getComment() != null) {
            sql.SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsCancel() != null) {
            sql.SET("is_cancel = #{isCancel,jdbcType=INTEGER}");
        }
        
        if (record.getIsTop() != null) {
            sql.SET("is_top = #{isTop,jdbcType=INTEGER}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStarTime() != null) {
            sql.SET("star_time = #{starTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{statusId,jdbcType=INTEGER}");
        }
        
        if (record.getTaskDescribe() != null) {
            sql.SET("task_describe = #{taskDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getTicking() != null) {
            sql.SET("ticking = #{ticking,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskPushUserId() != null) {
            sql.SET("task_push_user_id = #{taskPushUserId,jdbcType=BIGINT}");
        }
        
        if (record.getReciverlist() != null) {
            sql.SET("reciverlist = #{reciverlist,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("task_id = #{taskId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskListPOExample example, boolean includeExamplePhrase) {
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