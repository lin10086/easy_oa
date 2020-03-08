package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.UserLoginRecordPO;
import cn.gson.oasys.modelV2.po.UserLoginRecordPOExample.Criteria;
import cn.gson.oasys.modelV2.po.UserLoginRecordPOExample.Criterion;
import cn.gson.oasys.modelV2.po.UserLoginRecordPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserLoginRecordPOSqlProvider {

    public String countByExample(UserLoginRecordPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_user_login_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserLoginRecordPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_user_login_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UserLoginRecordPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_user_login_record");
        
        if (record.getBrowser() != null) {
            sql.VALUES("browser", "#{browser,jdbcType=VARCHAR}");
        }
        
        if (record.getIpAddr() != null) {
            sql.VALUES("ip_addr", "#{ipAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginTime() != null) {
            sql.VALUES("login_time", "#{loginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSessionId() != null) {
            sql.VALUES("session_id", "#{sessionId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserLoginRecordPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("record_id");
        } else {
            sql.SELECT("record_id");
        }
        sql.SELECT("browser");
        sql.SELECT("ip_addr");
        sql.SELECT("login_time");
        sql.SELECT("session_id");
        sql.SELECT("user_id");
        sql.FROM("aoa_user_login_record");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserLoginRecordPO record = (UserLoginRecordPO) parameter.get("record");
        UserLoginRecordPOExample example = (UserLoginRecordPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_user_login_record");
        
        if (record.getRecordId() != null) {
            sql.SET("record_id = #{record.recordId,jdbcType=BIGINT}");
        }
        
        if (record.getBrowser() != null) {
            sql.SET("browser = #{record.browser,jdbcType=VARCHAR}");
        }
        
        if (record.getIpAddr() != null) {
            sql.SET("ip_addr = #{record.ipAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginTime() != null) {
            sql.SET("login_time = #{record.loginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSessionId() != null) {
            sql.SET("session_id = #{record.sessionId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_user_login_record");
        
        sql.SET("record_id = #{record.recordId,jdbcType=BIGINT}");
        sql.SET("browser = #{record.browser,jdbcType=VARCHAR}");
        sql.SET("ip_addr = #{record.ipAddr,jdbcType=VARCHAR}");
        sql.SET("login_time = #{record.loginTime,jdbcType=TIMESTAMP}");
        sql.SET("session_id = #{record.sessionId,jdbcType=VARCHAR}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        
        UserLoginRecordPOExample example = (UserLoginRecordPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserLoginRecordPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_user_login_record");
        
        if (record.getBrowser() != null) {
            sql.SET("browser = #{browser,jdbcType=VARCHAR}");
        }
        
        if (record.getIpAddr() != null) {
            sql.SET("ip_addr = #{ipAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginTime() != null) {
            sql.SET("login_time = #{loginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSessionId() != null) {
            sql.SET("session_id = #{sessionId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("record_id = #{recordId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserLoginRecordPOExample example, boolean includeExamplePhrase) {
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