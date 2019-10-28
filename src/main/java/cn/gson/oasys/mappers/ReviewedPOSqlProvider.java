package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.ReviewedPO;
import cn.gson.oasys.model.po.ReviewedPOExample.Criteria;
import cn.gson.oasys.model.po.ReviewedPOExample.Criterion;
import cn.gson.oasys.model.po.ReviewedPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ReviewedPOSqlProvider {

    public String countByExample(ReviewedPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_reviewed");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReviewedPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_reviewed");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReviewedPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_reviewed");
        
        if (record.getAdvice() != null) {
            sql.VALUES("advice", "#{advice,jdbcType=VARCHAR}");
        }
        
        if (record.getReviewedTime() != null) {
            sql.VALUES("reviewed_time", "#{reviewedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.VALUES("pro_id", "#{proId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getDel() != null) {
            sql.VALUES("del", "#{del,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ReviewedPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("reviewed_id");
        } else {
            sql.SELECT("reviewed_id");
        }
        sql.SELECT("advice");
        sql.SELECT("reviewed_time");
        sql.SELECT("status_id");
        sql.SELECT("pro_id");
        sql.SELECT("user_id");
        sql.SELECT("del");
        sql.FROM("aoa_reviewed");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReviewedPO record = (ReviewedPO) parameter.get("record");
        ReviewedPOExample example = (ReviewedPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_reviewed");
        
        if (record.getReviewedId() != null) {
            sql.SET("reviewed_id = #{record.reviewedId,jdbcType=BIGINT}");
        }
        
        if (record.getAdvice() != null) {
            sql.SET("advice = #{record.advice,jdbcType=VARCHAR}");
        }
        
        if (record.getReviewedTime() != null) {
            sql.SET("reviewed_time = #{record.reviewedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getDel() != null) {
            sql.SET("del = #{record.del,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_reviewed");
        
        sql.SET("reviewed_id = #{record.reviewedId,jdbcType=BIGINT}");
        sql.SET("advice = #{record.advice,jdbcType=VARCHAR}");
        sql.SET("reviewed_time = #{record.reviewedTime,jdbcType=TIMESTAMP}");
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("pro_id = #{record.proId,jdbcType=BIGINT}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("del = #{record.del,jdbcType=INTEGER}");
        
        ReviewedPOExample example = (ReviewedPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReviewedPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_reviewed");
        
        if (record.getAdvice() != null) {
            sql.SET("advice = #{advice,jdbcType=VARCHAR}");
        }
        
        if (record.getReviewedTime() != null) {
            sql.SET("reviewed_time = #{reviewedTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{proId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getDel() != null) {
            sql.SET("del = #{del,jdbcType=INTEGER}");
        }
        
        sql.WHERE("reviewed_id = #{reviewedId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReviewedPOExample example, boolean includeExamplePhrase) {
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