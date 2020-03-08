package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.AttendsPO;
import cn.gson.oasys.modelV2.po.AttendsPOExample.Criteria;
import cn.gson.oasys.modelV2.po.AttendsPOExample.Criterion;
import cn.gson.oasys.modelV2.po.AttendsPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AttendsPOSqlProvider {

    public String countByExample(AttendsPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_attends_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AttendsPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_attends_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(AttendsPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_attends_list");
        
        if (record.getAttendsIp() != null) {
            sql.VALUES("attends_ip", "#{attendsIp,jdbcType=VARCHAR}");
        }
        
        if (record.getAttendsRemark() != null) {
            sql.VALUES("attends_remark", "#{attendsRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getAttendsTime() != null) {
            sql.VALUES("attends_time", "#{attendsTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeId() != null) {
            sql.VALUES("type_id", "#{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getAttendsUserId() != null) {
            sql.VALUES("attends_user_id", "#{attendsUserId,jdbcType=BIGINT}");
        }
        
        if (record.getAttendHmtime() != null) {
            sql.VALUES("attend_hmtime", "#{attendHmtime,jdbcType=VARCHAR}");
        }
        
        if (record.getWeekOfday() != null) {
            sql.VALUES("week_ofday", "#{weekOfday,jdbcType=VARCHAR}");
        }
        
        if (record.getHolidayDays() != null) {
            sql.VALUES("holiday_days", "#{holidayDays,jdbcType=DOUBLE}");
        }
        
        if (record.getHolidayStart() != null) {
            sql.VALUES("holiday_start", "#{holidayStart,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AttendsPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("attends_id");
        } else {
            sql.SELECT("attends_id");
        }
        sql.SELECT("attends_ip");
        sql.SELECT("attends_remark");
        sql.SELECT("attends_time");
        sql.SELECT("status_id");
        sql.SELECT("type_id");
        sql.SELECT("attends_user_id");
        sql.SELECT("attend_hmtime");
        sql.SELECT("week_ofday");
        sql.SELECT("holiday_days");
        sql.SELECT("holiday_start");
        sql.FROM("aoa_attends_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AttendsPO record = (AttendsPO) parameter.get("record");
        AttendsPOExample example = (AttendsPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_attends_list");
        
        if (record.getAttendsId() != null) {
            sql.SET("attends_id = #{record.attendsId,jdbcType=BIGINT}");
        }
        
        if (record.getAttendsIp() != null) {
            sql.SET("attends_ip = #{record.attendsIp,jdbcType=VARCHAR}");
        }
        
        if (record.getAttendsRemark() != null) {
            sql.SET("attends_remark = #{record.attendsRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getAttendsTime() != null) {
            sql.SET("attends_time = #{record.attendsTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        }
        
        if (record.getAttendsUserId() != null) {
            sql.SET("attends_user_id = #{record.attendsUserId,jdbcType=BIGINT}");
        }
        
        if (record.getAttendHmtime() != null) {
            sql.SET("attend_hmtime = #{record.attendHmtime,jdbcType=VARCHAR}");
        }
        
        if (record.getWeekOfday() != null) {
            sql.SET("week_ofday = #{record.weekOfday,jdbcType=VARCHAR}");
        }
        
        if (record.getHolidayDays() != null) {
            sql.SET("holiday_days = #{record.holidayDays,jdbcType=DOUBLE}");
        }
        
        if (record.getHolidayStart() != null) {
            sql.SET("holiday_start = #{record.holidayStart,jdbcType=DATE}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_attends_list");
        
        sql.SET("attends_id = #{record.attendsId,jdbcType=BIGINT}");
        sql.SET("attends_ip = #{record.attendsIp,jdbcType=VARCHAR}");
        sql.SET("attends_remark = #{record.attendsRemark,jdbcType=VARCHAR}");
        sql.SET("attends_time = #{record.attendsTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("attends_user_id = #{record.attendsUserId,jdbcType=BIGINT}");
        sql.SET("attend_hmtime = #{record.attendHmtime,jdbcType=VARCHAR}");
        sql.SET("week_ofday = #{record.weekOfday,jdbcType=VARCHAR}");
        sql.SET("holiday_days = #{record.holidayDays,jdbcType=DOUBLE}");
        sql.SET("holiday_start = #{record.holidayStart,jdbcType=DATE}");
        
        AttendsPOExample example = (AttendsPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AttendsPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_attends_list");
        
        if (record.getAttendsIp() != null) {
            sql.SET("attends_ip = #{attendsIp,jdbcType=VARCHAR}");
        }
        
        if (record.getAttendsRemark() != null) {
            sql.SET("attends_remark = #{attendsRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getAttendsTime() != null) {
            sql.SET("attends_time = #{attendsTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getAttendsUserId() != null) {
            sql.SET("attends_user_id = #{attendsUserId,jdbcType=BIGINT}");
        }
        
        if (record.getAttendHmtime() != null) {
            sql.SET("attend_hmtime = #{attendHmtime,jdbcType=VARCHAR}");
        }
        
        if (record.getWeekOfday() != null) {
            sql.SET("week_ofday = #{weekOfday,jdbcType=VARCHAR}");
        }
        
        if (record.getHolidayDays() != null) {
            sql.SET("holiday_days = #{holidayDays,jdbcType=DOUBLE}");
        }
        
        if (record.getHolidayStart() != null) {
            sql.SET("holiday_start = #{holidayStart,jdbcType=DATE}");
        }
        
        sql.WHERE("attends_id = #{attendsId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AttendsPOExample example, boolean includeExamplePhrase) {
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