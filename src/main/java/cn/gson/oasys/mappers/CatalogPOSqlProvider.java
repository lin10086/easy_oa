package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.CatalogPO;
import cn.gson.oasys.model.po.CatalogPOExample.Criteria;
import cn.gson.oasys.model.po.CatalogPOExample.Criterion;
import cn.gson.oasys.model.po.CatalogPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CatalogPOSqlProvider {

    public String countByExample(CatalogPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_catalog");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CatalogPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_catalog");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CatalogPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_catalog");
        
        if (record.getCatalogName() != null) {
            sql.VALUES("catalog_name", "#{catalogName,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCataUserId() != null) {
            sql.VALUES("cata_user_id", "#{cataUserId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CatalogPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("catalog_id");
        } else {
            sql.SELECT("catalog_id");
        }
        sql.SELECT("catalog_name");
        sql.SELECT("parent_id");
        sql.SELECT("cata_user_id");
        sql.FROM("aoa_catalog");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CatalogPO record = (CatalogPO) parameter.get("record");
        CatalogPOExample example = (CatalogPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_catalog");
        
        if (record.getCatalogId() != null) {
            sql.SET("catalog_id = #{record.catalogId,jdbcType=BIGINT}");
        }
        
        if (record.getCatalogName() != null) {
            sql.SET("catalog_name = #{record.catalogName,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCataUserId() != null) {
            sql.SET("cata_user_id = #{record.cataUserId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_catalog");
        
        sql.SET("catalog_id = #{record.catalogId,jdbcType=BIGINT}");
        sql.SET("catalog_name = #{record.catalogName,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        sql.SET("cata_user_id = #{record.cataUserId,jdbcType=BIGINT}");
        
        CatalogPOExample example = (CatalogPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CatalogPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_catalog");
        
        if (record.getCatalogName() != null) {
            sql.SET("catalog_name = #{catalogName,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getCataUserId() != null) {
            sql.SET("cata_user_id = #{cataUserId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("catalog_id = #{catalogId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CatalogPOExample example, boolean includeExamplePhrase) {
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