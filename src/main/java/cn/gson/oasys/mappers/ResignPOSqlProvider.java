package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ResignPO;
import cn.gson.oasys.model.po.ResignPOExample.Criteria;
import cn.gson.oasys.model.po.ResignPOExample.Criterion;
import cn.gson.oasys.model.po.ResignPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ResignPOSqlProvider {

    public String countByExample(ResignPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_resign");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ResignPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_resign");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ResignPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_resign");
        
        if (record.getFinancialAdvice() != null) {
            sql.VALUES("financial_advice", "#{financialAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getIsFinish() != null) {
            sql.VALUES("is_finish", "#{isFinish,jdbcType=BIT}");
        }
        
        if (record.getNofinish() != null) {
            sql.VALUES("nofinish", "#{nofinish,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnelAdvice() != null) {
            sql.VALUES("personnel_advice", "#{personnelAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getSuggest() != null) {
            sql.VALUES("suggest", "#{suggest,jdbcType=VARCHAR}");
        }
        
        if (record.getHandUser() != null) {
            sql.VALUES("hand_user", "#{handUser,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.VALUES("pro_id", "#{proId,jdbcType=BIGINT}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.VALUES("manager_advice", "#{managerAdvice,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ResignPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("resign_id");
        } else {
            sql.SELECT("resign_id");
        }
        sql.SELECT("financial_advice");
        sql.SELECT("is_finish");
        sql.SELECT("nofinish");
        sql.SELECT("personnel_advice");
        sql.SELECT("suggest");
        sql.SELECT("hand_user");
        sql.SELECT("pro_id");
        sql.SELECT("manager_advice");
        sql.FROM("aoa_resign");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ResignPO record = (ResignPO) parameter.get("record");
        ResignPOExample example = (ResignPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_resign");
        
        if (record.getResignId() != null) {
            sql.SET("resign_id = #{record.resignId,jdbcType=BIGINT}");
        }
        
        if (record.getFinancialAdvice() != null) {
            sql.SET("financial_advice = #{record.financialAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getIsFinish() != null) {
            sql.SET("is_finish = #{record.isFinish,jdbcType=BIT}");
        }
        
        if (record.getNofinish() != null) {
            sql.SET("nofinish = #{record.nofinish,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnelAdvice() != null) {
            sql.SET("personnel_advice = #{record.personnelAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getSuggest() != null) {
            sql.SET("suggest = #{record.suggest,jdbcType=VARCHAR}");
        }
        
        if (record.getHandUser() != null) {
            sql.SET("hand_user = #{record.handUser,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.SET("manager_advice = #{record.managerAdvice,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_resign");
        
        sql.SET("resign_id = #{record.resignId,jdbcType=BIGINT}");
        sql.SET("financial_advice = #{record.financialAdvice,jdbcType=VARCHAR}");
        sql.SET("is_finish = #{record.isFinish,jdbcType=BIT}");
        sql.SET("nofinish = #{record.nofinish,jdbcType=VARCHAR}");
        sql.SET("personnel_advice = #{record.personnelAdvice,jdbcType=VARCHAR}");
        sql.SET("suggest = #{record.suggest,jdbcType=VARCHAR}");
        sql.SET("hand_user = #{record.handUser,jdbcType=BIGINT}");
        sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        sql.SET("manager_advice = #{record.managerAdvice,jdbcType=VARCHAR}");
        
        ResignPOExample example = (ResignPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ResignPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_resign");
        
        if (record.getFinancialAdvice() != null) {
            sql.SET("financial_advice = #{financialAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getIsFinish() != null) {
            sql.SET("is_finish = #{isFinish,jdbcType=BIT}");
        }
        
        if (record.getNofinish() != null) {
            sql.SET("nofinish = #{nofinish,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnelAdvice() != null) {
            sql.SET("personnel_advice = #{personnelAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getSuggest() != null) {
            sql.SET("suggest = #{suggest,jdbcType=VARCHAR}");
        }
        
        if (record.getHandUser() != null) {
            sql.SET("hand_user = #{handUser,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{proId,jdbcType=BIGINT}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.SET("manager_advice = #{managerAdvice,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("resign_id = #{resignId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ResignPOExample example, boolean includeExamplePhrase) {
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