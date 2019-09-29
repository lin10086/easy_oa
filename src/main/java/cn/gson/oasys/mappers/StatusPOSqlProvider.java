package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.StatusPO;
import cn.gson.oasys.model.po.StatusPOExample.Criteria;
import cn.gson.oasys.model.po.StatusPOExample.Criterion;
import cn.gson.oasys.model.po.StatusPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class StatusPOSqlProvider {

    public String countByExample(StatusPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_status_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(StatusPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_status_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(StatusPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_status_list");
        
        if (record.getStatusColor() != null) {
            sql.VALUES("status_color", "#{statusColor,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusModel() != null) {
            sql.VALUES("status_model", "#{statusModel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusName() != null) {
            sql.VALUES("status_name", "#{statusName,jdbcType=VARCHAR}");
        }
        
        if (record.getSortValue() != null) {
            sql.VALUES("sort_value", "#{sortValue,jdbcType=INTEGER}");
        }
        
        if (record.getSortPrecent() != null) {
            sql.VALUES("sort_precent", "#{sortPrecent,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(StatusPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("status_id");
        } else {
            sql.SELECT("status_id");
        }
        sql.SELECT("status_color");
        sql.SELECT("status_model");
        sql.SELECT("status_name");
        sql.SELECT("sort_value");
        sql.SELECT("sort_precent");
        sql.FROM("aoa_status_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StatusPO record = (StatusPO) parameter.get("record");
        StatusPOExample example = (StatusPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_status_list");
        
        if (record.getStatusId() != null) {
            sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }
        
        if (record.getStatusColor() != null) {
            sql.SET("status_color = #{record.statusColor,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusModel() != null) {
            sql.SET("status_model = #{record.statusModel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusName() != null) {
            sql.SET("status_name = #{record.statusName,jdbcType=VARCHAR}");
        }
        
        if (record.getSortValue() != null) {
            sql.SET("sort_value = #{record.sortValue,jdbcType=INTEGER}");
        }
        
        if (record.getSortPrecent() != null) {
            sql.SET("sort_precent = #{record.sortPrecent,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_status_list");
        
        sql.SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        sql.SET("status_color = #{record.statusColor,jdbcType=VARCHAR}");
        sql.SET("status_model = #{record.statusModel,jdbcType=VARCHAR}");
        sql.SET("status_name = #{record.statusName,jdbcType=VARCHAR}");
        sql.SET("sort_value = #{record.sortValue,jdbcType=INTEGER}");
        sql.SET("sort_precent = #{record.sortPrecent,jdbcType=VARCHAR}");
        
        StatusPOExample example = (StatusPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(StatusPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_status_list");
        
        if (record.getStatusColor() != null) {
            sql.SET("status_color = #{statusColor,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusModel() != null) {
            sql.SET("status_model = #{statusModel,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusName() != null) {
            sql.SET("status_name = #{statusName,jdbcType=VARCHAR}");
        }
        
        if (record.getSortValue() != null) {
            sql.SET("sort_value = #{sortValue,jdbcType=INTEGER}");
        }
        
        if (record.getSortPrecent() != null) {
            sql.SET("sort_precent = #{sortPrecent,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("status_id = #{statusId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, StatusPOExample example, boolean includeExamplePhrase) {
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