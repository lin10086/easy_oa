package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.SchedulePO;
import cn.gson.oasys.model.po.SchedulePOExample.Criteria;
import cn.gson.oasys.model.po.SchedulePOExample.Criterion;
import cn.gson.oasys.model.po.SchedulePOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SchedulePOSqlProvider {

    public String countByExample(SchedulePOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_schedule_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SchedulePOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_schedule_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SchedulePO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_schedule_list");
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFiledescribe() != null) {
            sql.VALUES("filedescribe", "#{filedescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRemind() != null) {
            sql.VALUES("is_remind", "#{isRemind,jdbcType=INTEGER}");
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
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getMiaoshu() != null) {
            sql.VALUES("miaoshu", "#{miaoshu,jdbcType=VARCHAR}");
        }
        
        if (record.getIsreminded() != null) {
            sql.VALUES("isreminded", "#{isreminded,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SchedulePOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("rc_id");
        } else {
            sql.SELECT("rc_id");
        }
        sql.SELECT("create_time");
        sql.SELECT("end_time");
        sql.SELECT("filedescribe");
        sql.SELECT("is_remind");
        sql.SELECT("start_time");
        sql.SELECT("status_id");
        sql.SELECT("title");
        sql.SELECT("type_id");
        sql.SELECT("user_id");
        sql.SELECT("miaoshu");
        sql.SELECT("isreminded");
        sql.FROM("aoa_schedule_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SchedulePO record = (SchedulePO) parameter.get("record");
        SchedulePOExample example = (SchedulePOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_schedule_list");
        
        if (record.getRcId() != null) {
            sql.SET("rc_id = #{record.rcId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFiledescribe() != null) {
            sql.SET("filedescribe = #{record.filedescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRemind() != null) {
            sql.SET("is_remind = #{record.isRemind,jdbcType=INTEGER}");
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
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getMiaoshu() != null) {
            sql.SET("miaoshu = #{record.miaoshu,jdbcType=VARCHAR}");
        }
        
        if (record.getIsreminded() != null) {
            sql.SET("isreminded = #{record.isreminded,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_schedule_list");
        
        sql.SET("rc_id = #{record.rcId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("filedescribe = #{record.filedescribe,jdbcType=VARCHAR}");
        sql.SET("is_remind = #{record.isRemind,jdbcType=INTEGER}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("miaoshu = #{record.miaoshu,jdbcType=VARCHAR}");
        sql.SET("isreminded = #{record.isreminded,jdbcType=INTEGER}");
        
        SchedulePOExample example = (SchedulePOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SchedulePO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_schedule_list");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFiledescribe() != null) {
            sql.SET("filedescribe = #{filedescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getIsRemind() != null) {
            sql.SET("is_remind = #{isRemind,jdbcType=INTEGER}");
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
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getMiaoshu() != null) {
            sql.SET("miaoshu = #{miaoshu,jdbcType=VARCHAR}");
        }
        
        if (record.getIsreminded() != null) {
            sql.SET("isreminded = #{isreminded,jdbcType=INTEGER}");
        }
        
        sql.WHERE("rc_id = #{rcId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SchedulePOExample example, boolean includeExamplePhrase) {
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