package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.BursementPO;
import cn.gson.oasys.model.po.BursementPOExample.Criteria;
import cn.gson.oasys.model.po.BursementPOExample.Criterion;
import cn.gson.oasys.model.po.BursementPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BursementPOSqlProvider {

    public String countByExample(BursementPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_bursement");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BursementPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_bursement");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BursementPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_bursement");
        
        if (record.getAllMoney() != null) {
            sql.VALUES("all_money", "#{allMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getAllinvoices() != null) {
            sql.VALUES("allinvoices", "#{allinvoices,jdbcType=INTEGER}");
        }
        
        if (record.getBurseTime() != null) {
            sql.VALUES("burse_time", "#{burseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinancialAdvice() != null) {
            sql.VALUES("financial_advice", "#{financialAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.VALUES("manager_advice", "#{managerAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.VALUES("type_id", "#{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getOperationName() != null) {
            sql.VALUES("operation_name", "#{operationName,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.VALUES("pro_id", "#{proId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BursementPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("bursement_id");
        } else {
            sql.SELECT("bursement_id");
        }
        sql.SELECT("all_money");
        sql.SELECT("allinvoices");
        sql.SELECT("burse_time");
        sql.SELECT("financial_advice");
        sql.SELECT("manager_advice");
        sql.SELECT("name");
        sql.SELECT("type_id");
        sql.SELECT("operation_name");
        sql.SELECT("pro_id");
        sql.SELECT("user_name");
        sql.FROM("aoa_bursement");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BursementPO record = (BursementPO) parameter.get("record");
        BursementPOExample example = (BursementPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_bursement");
        
        if (record.getBursementId() != null) {
            sql.SET("bursement_id = #{record.bursementId,jdbcType=BIGINT}");
        }
        
        if (record.getAllMoney() != null) {
            sql.SET("all_money = #{record.allMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getAllinvoices() != null) {
            sql.SET("allinvoices = #{record.allinvoices,jdbcType=INTEGER}");
        }
        
        if (record.getBurseTime() != null) {
            sql.SET("burse_time = #{record.burseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinancialAdvice() != null) {
            sql.SET("financial_advice = #{record.financialAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.SET("manager_advice = #{record.managerAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        }
        
        if (record.getOperationName() != null) {
            sql.SET("operation_name = #{record.operationName,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_bursement");
        
        sql.SET("bursement_id = #{record.bursementId,jdbcType=BIGINT}");
        sql.SET("all_money = #{record.allMoney,jdbcType=DOUBLE}");
        sql.SET("allinvoices = #{record.allinvoices,jdbcType=INTEGER}");
        sql.SET("burse_time = #{record.burseTime,jdbcType=TIMESTAMP}");
        sql.SET("financial_advice = #{record.financialAdvice,jdbcType=VARCHAR}");
        sql.SET("manager_advice = #{record.managerAdvice,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=BIGINT}");
        sql.SET("operation_name = #{record.operationName,jdbcType=BIGINT}");
        sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        sql.SET("user_name = #{record.userName,jdbcType=BIGINT}");
        
        BursementPOExample example = (BursementPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BursementPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_bursement");
        
        if (record.getAllMoney() != null) {
            sql.SET("all_money = #{allMoney,jdbcType=DOUBLE}");
        }
        
        if (record.getAllinvoices() != null) {
            sql.SET("allinvoices = #{allinvoices,jdbcType=INTEGER}");
        }
        
        if (record.getBurseTime() != null) {
            sql.SET("burse_time = #{burseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinancialAdvice() != null) {
            sql.SET("financial_advice = #{financialAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.SET("manager_advice = #{managerAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{typeId,jdbcType=BIGINT}");
        }
        
        if (record.getOperationName() != null) {
            sql.SET("operation_name = #{operationName,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{proId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=BIGINT}");
        }
        
        sql.WHERE("bursement_id = #{bursementId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BursementPOExample example, boolean includeExamplePhrase) {
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