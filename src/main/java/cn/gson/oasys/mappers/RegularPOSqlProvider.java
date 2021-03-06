package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.RegularPO;
import cn.gson.oasys.modelV2.po.RegularPOExample.Criteria;
import cn.gson.oasys.modelV2.po.RegularPOExample.Criterion;
import cn.gson.oasys.modelV2.po.RegularPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RegularPOSqlProvider {

    public String countByExample(RegularPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_regular");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RegularPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_regular");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RegularPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_regular");
        
        if (record.getAdvice() != null) {
            sql.VALUES("advice", "#{advice,jdbcType=VARCHAR}");
        }
        
        if (record.getDeficiency() != null) {
            sql.VALUES("deficiency", "#{deficiency,jdbcType=VARCHAR}");
        }
        
        if (record.getDobetter() != null) {
            sql.VALUES("dobetter", "#{dobetter,jdbcType=VARCHAR}");
        }
        
        if (record.getExperience() != null) {
            sql.VALUES("experience", "#{experience,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnelAdvice() != null) {
            sql.VALUES("personnel_advice", "#{personnelAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getPullulate() != null) {
            sql.VALUES("pullulate", "#{pullulate,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderstand() != null) {
            sql.VALUES("understand", "#{understand,jdbcType=VARCHAR}");
        }
        
        if (record.getProId() != null) {
            sql.VALUES("pro_id", "#{proId,jdbcType=BIGINT}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.VALUES("manager_advice", "#{managerAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getDays() != null) {
            sql.VALUES("days", "#{days,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RegularPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("regular_id");
        } else {
            sql.SELECT("regular_id");
        }
        sql.SELECT("advice");
        sql.SELECT("deficiency");
        sql.SELECT("dobetter");
        sql.SELECT("experience");
        sql.SELECT("personnel_advice");
        sql.SELECT("pullulate");
        sql.SELECT("understand");
        sql.SELECT("pro_id");
        sql.SELECT("manager_advice");
        sql.SELECT("days");
        sql.FROM("aoa_regular");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RegularPO record = (RegularPO) parameter.get("record");
        RegularPOExample example = (RegularPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_regular");
        
        if (record.getRegularId() != null) {
            sql.SET("regular_id = #{record.regularId,jdbcType=BIGINT}");
        }
        
        if (record.getAdvice() != null) {
            sql.SET("advice = #{record.advice,jdbcType=VARCHAR}");
        }
        
        if (record.getDeficiency() != null) {
            sql.SET("deficiency = #{record.deficiency,jdbcType=VARCHAR}");
        }
        
        if (record.getDobetter() != null) {
            sql.SET("dobetter = #{record.dobetter,jdbcType=VARCHAR}");
        }
        
        if (record.getExperience() != null) {
            sql.SET("experience = #{record.experience,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnelAdvice() != null) {
            sql.SET("personnel_advice = #{record.personnelAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getPullulate() != null) {
            sql.SET("pullulate = #{record.pullulate,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderstand() != null) {
            sql.SET("understand = #{record.understand,jdbcType=VARCHAR}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.SET("manager_advice = #{record.managerAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getDays() != null) {
            sql.SET("days = #{record.days,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_regular");
        
        sql.SET("regular_id = #{record.regularId,jdbcType=BIGINT}");
        sql.SET("advice = #{record.advice,jdbcType=VARCHAR}");
        sql.SET("deficiency = #{record.deficiency,jdbcType=VARCHAR}");
        sql.SET("dobetter = #{record.dobetter,jdbcType=VARCHAR}");
        sql.SET("experience = #{record.experience,jdbcType=VARCHAR}");
        sql.SET("personnel_advice = #{record.personnelAdvice,jdbcType=VARCHAR}");
        sql.SET("pullulate = #{record.pullulate,jdbcType=VARCHAR}");
        sql.SET("understand = #{record.understand,jdbcType=VARCHAR}");
        sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        sql.SET("manager_advice = #{record.managerAdvice,jdbcType=VARCHAR}");
        sql.SET("days = #{record.days,jdbcType=INTEGER}");
        
        RegularPOExample example = (RegularPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RegularPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_regular");
        
        if (record.getAdvice() != null) {
            sql.SET("advice = #{advice,jdbcType=VARCHAR}");
        }
        
        if (record.getDeficiency() != null) {
            sql.SET("deficiency = #{deficiency,jdbcType=VARCHAR}");
        }
        
        if (record.getDobetter() != null) {
            sql.SET("dobetter = #{dobetter,jdbcType=VARCHAR}");
        }
        
        if (record.getExperience() != null) {
            sql.SET("experience = #{experience,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnelAdvice() != null) {
            sql.SET("personnel_advice = #{personnelAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getPullulate() != null) {
            sql.SET("pullulate = #{pullulate,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderstand() != null) {
            sql.SET("understand = #{understand,jdbcType=VARCHAR}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{proId,jdbcType=BIGINT}");
        }
        
        if (record.getManagerAdvice() != null) {
            sql.SET("manager_advice = #{managerAdvice,jdbcType=VARCHAR}");
        }
        
        if (record.getDays() != null) {
            sql.SET("days = #{days,jdbcType=INTEGER}");
        }
        
        sql.WHERE("regular_id = #{regularId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RegularPOExample example, boolean includeExamplePhrase) {
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