package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.TrafficPO;
import cn.gson.oasys.modelV2.po.TrafficPOExample.Criteria;
import cn.gson.oasys.modelV2.po.TrafficPOExample.Criterion;
import cn.gson.oasys.modelV2.po.TrafficPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TrafficPOSqlProvider {

    public String countByExample(TrafficPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_traffic");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TrafficPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_traffic");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TrafficPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_traffic");
        
        if (record.getDepartName() != null) {
            sql.VALUES("depart_name", "#{departName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartTime() != null) {
            sql.VALUES("depart_time", "#{departTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReachName() != null) {
            sql.VALUES("reach_name", "#{reachName,jdbcType=VARCHAR}");
        }
        
        if (record.getSeatType() != null) {
            sql.VALUES("seat_type", "#{seatType,jdbcType=VARCHAR}");
        }
        
        if (record.getTrafficMoney() != null) {
            sql.VALUES("traffic_money", "#{trafficMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getTrafficName() != null) {
            sql.VALUES("traffic_name", "#{trafficName,jdbcType=VARCHAR}");
        }
        
        if (record.getEvemoneyId() != null) {
            sql.VALUES("evemoney_id", "#{evemoneyId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TrafficPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("traffic_id");
        } else {
            sql.SELECT("traffic_id");
        }
        sql.SELECT("depart_name");
        sql.SELECT("depart_time");
        sql.SELECT("reach_name");
        sql.SELECT("seat_type");
        sql.SELECT("traffic_money");
        sql.SELECT("traffic_name");
        sql.SELECT("evemoney_id");
        sql.SELECT("user_name");
        sql.FROM("aoa_traffic");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TrafficPO record = (TrafficPO) parameter.get("record");
        TrafficPOExample example = (TrafficPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_traffic");
        
        if (record.getTrafficId() != null) {
            sql.SET("traffic_id = #{record.trafficId,jdbcType=BIGINT}");
        }
        
        if (record.getDepartName() != null) {
            sql.SET("depart_name = #{record.departName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartTime() != null) {
            sql.SET("depart_time = #{record.departTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReachName() != null) {
            sql.SET("reach_name = #{record.reachName,jdbcType=VARCHAR}");
        }
        
        if (record.getSeatType() != null) {
            sql.SET("seat_type = #{record.seatType,jdbcType=VARCHAR}");
        }
        
        if (record.getTrafficMoney() != null) {
            sql.SET("traffic_money = #{record.trafficMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getTrafficName() != null) {
            sql.SET("traffic_name = #{record.trafficName,jdbcType=VARCHAR}");
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
        sql.UPDATE("aoa_traffic");
        
        sql.SET("traffic_id = #{record.trafficId,jdbcType=BIGINT}");
        sql.SET("depart_name = #{record.departName,jdbcType=VARCHAR}");
        sql.SET("depart_time = #{record.departTime,jdbcType=TIMESTAMP}");
        sql.SET("reach_name = #{record.reachName,jdbcType=VARCHAR}");
        sql.SET("seat_type = #{record.seatType,jdbcType=VARCHAR}");
        sql.SET("traffic_money = #{record.trafficMoney,jdbcType=DOUBLE}");
        sql.SET("traffic_name = #{record.trafficName,jdbcType=VARCHAR}");
        sql.SET("evemoney_id = #{record.evemoneyId,jdbcType=BIGINT}");
        sql.SET("user_name = #{record.userName,jdbcType=BIGINT}");
        
        TrafficPOExample example = (TrafficPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TrafficPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_traffic");
        
        if (record.getDepartName() != null) {
            sql.SET("depart_name = #{departName,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartTime() != null) {
            sql.SET("depart_time = #{departTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReachName() != null) {
            sql.SET("reach_name = #{reachName,jdbcType=VARCHAR}");
        }
        
        if (record.getSeatType() != null) {
            sql.SET("seat_type = #{seatType,jdbcType=VARCHAR}");
        }
        
        if (record.getTrafficMoney() != null) {
            sql.SET("traffic_money = #{trafficMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getTrafficName() != null) {
            sql.SET("traffic_name = #{trafficName,jdbcType=VARCHAR}");
        }
        
        if (record.getEvemoneyId() != null) {
            sql.SET("evemoney_id = #{evemoneyId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=BIGINT}");
        }
        
        sql.WHERE("traffic_id = #{trafficId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TrafficPOExample example, boolean includeExamplePhrase) {
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