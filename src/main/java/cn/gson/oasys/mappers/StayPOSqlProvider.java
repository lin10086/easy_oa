package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.StayPO;
import cn.gson.oasys.modelV2.po.StayPOExample.Criteria;
import cn.gson.oasys.modelV2.po.StayPOExample.Criterion;
import cn.gson.oasys.modelV2.po.StayPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class StayPOSqlProvider {

    public String countByExample(StayPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_stay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(StayPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_stay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(StayPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_stay");
        
        if (record.getDay() != null) {
            sql.VALUES("day", "#{day,jdbcType=INTEGER}");
        }
        
        if (record.getHotelName() != null) {
            sql.VALUES("hotel_name", "#{hotelName,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaveTime() != null) {
            sql.VALUES("leave_time", "#{leaveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStayCity() != null) {
            sql.VALUES("stay_city", "#{stayCity,jdbcType=VARCHAR}");
        }
        
        if (record.getStayMoney() != null) {
            sql.VALUES("stay_money", "#{stayMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getStayTime() != null) {
            sql.VALUES("stay_time", "#{stayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEvemoneyId() != null) {
            sql.VALUES("evemoney_id", "#{evemoneyId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(StayPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("stay_id");
        } else {
            sql.SELECT("stay_id");
        }
        sql.SELECT("day");
        sql.SELECT("hotel_name");
        sql.SELECT("leave_time");
        sql.SELECT("stay_city");
        sql.SELECT("stay_money");
        sql.SELECT("stay_time");
        sql.SELECT("evemoney_id");
        sql.SELECT("user_name");
        sql.FROM("aoa_stay");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StayPO record = (StayPO) parameter.get("record");
        StayPOExample example = (StayPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_stay");
        
        if (record.getStayId() != null) {
            sql.SET("stay_id = #{record.stayId,jdbcType=BIGINT}");
        }
        
        if (record.getDay() != null) {
            sql.SET("day = #{record.day,jdbcType=INTEGER}");
        }
        
        if (record.getHotelName() != null) {
            sql.SET("hotel_name = #{record.hotelName,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaveTime() != null) {
            sql.SET("leave_time = #{record.leaveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStayCity() != null) {
            sql.SET("stay_city = #{record.stayCity,jdbcType=VARCHAR}");
        }
        
        if (record.getStayMoney() != null) {
            sql.SET("stay_money = #{record.stayMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getStayTime() != null) {
            sql.SET("stay_time = #{record.stayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEvemoneyId() != null) {
            sql.SET("evemoney_id = #{record.evemoneyId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_stay");
        
        sql.SET("stay_id = #{record.stayId,jdbcType=BIGINT}");
        sql.SET("day = #{record.day,jdbcType=INTEGER}");
        sql.SET("hotel_name = #{record.hotelName,jdbcType=VARCHAR}");
        sql.SET("leave_time = #{record.leaveTime,jdbcType=TIMESTAMP}");
        sql.SET("stay_city = #{record.stayCity,jdbcType=VARCHAR}");
        sql.SET("stay_money = #{record.stayMoney,jdbcType=DOUBLE}");
        sql.SET("stay_time = #{record.stayTime,jdbcType=TIMESTAMP}");
        sql.SET("evemoney_id = #{record.evemoneyId,jdbcType=BIGINT}");
        sql.SET("user_name = #{record.userName,jdbcType=BIGINT}");
        
        StayPOExample example = (StayPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(StayPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_stay");
        
        if (record.getDay() != null) {
            sql.SET("day = #{day,jdbcType=INTEGER}");
        }
        
        if (record.getHotelName() != null) {
            sql.SET("hotel_name = #{hotelName,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaveTime() != null) {
            sql.SET("leave_time = #{leaveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStayCity() != null) {
            sql.SET("stay_city = #{stayCity,jdbcType=VARCHAR}");
        }
        
        if (record.getStayMoney() != null) {
            sql.SET("stay_money = #{stayMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getStayTime() != null) {
            sql.SET("stay_time = #{stayTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEvemoneyId() != null) {
            sql.SET("evemoney_id = #{evemoneyId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=BIGINT}");
        }
        
        sql.WHERE("stay_id = #{stayId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, StayPOExample example, boolean includeExamplePhrase) {
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