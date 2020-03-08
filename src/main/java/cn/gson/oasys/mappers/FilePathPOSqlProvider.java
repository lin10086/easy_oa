package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.FilePathPO;
import cn.gson.oasys.modelV2.po.FilePathPOExample.Criteria;
import cn.gson.oasys.modelV2.po.FilePathPOExample.Criterion;
import cn.gson.oasys.modelV2.po.FilePathPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class FilePathPOSqlProvider {

    public String countByExample(FilePathPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_file_path");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FilePathPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_file_path");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(FilePathPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_file_path");
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getPathName() != null) {
            sql.VALUES("path_name", "#{pathName,jdbcType=VARCHAR}");
        }
        
        if (record.getPathUserId() != null) {
            sql.VALUES("path_user_id", "#{pathUserId,jdbcType=BIGINT}");
        }
        
        if (record.getPathIstrash() != null) {
            sql.VALUES("path_istrash", "#{pathIstrash,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(FilePathPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("path_id");
        } else {
            sql.SELECT("path_id");
        }
        sql.SELECT("parent_id");
        sql.SELECT("path_name");
        sql.SELECT("path_user_id");
        sql.SELECT("path_istrash");
        sql.FROM("aoa_file_path");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FilePathPO record = (FilePathPO) parameter.get("record");
        FilePathPOExample example = (FilePathPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_file_path");
        
        if (record.getPathId() != null) {
            sql.SET("path_id = #{record.pathId,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getPathName() != null) {
            sql.SET("path_name = #{record.pathName,jdbcType=VARCHAR}");
        }
        
        if (record.getPathUserId() != null) {
            sql.SET("path_user_id = #{record.pathUserId,jdbcType=BIGINT}");
        }
        
        if (record.getPathIstrash() != null) {
            sql.SET("path_istrash = #{record.pathIstrash,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_file_path");
        
        sql.SET("path_id = #{record.pathId,jdbcType=BIGINT}");
        sql.SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        sql.SET("path_name = #{record.pathName,jdbcType=VARCHAR}");
        sql.SET("path_user_id = #{record.pathUserId,jdbcType=BIGINT}");
        sql.SET("path_istrash = #{record.pathIstrash,jdbcType=BIGINT}");
        
        FilePathPOExample example = (FilePathPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FilePathPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_file_path");
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getPathName() != null) {
            sql.SET("path_name = #{pathName,jdbcType=VARCHAR}");
        }
        
        if (record.getPathUserId() != null) {
            sql.SET("path_user_id = #{pathUserId,jdbcType=BIGINT}");
        }
        
        if (record.getPathIstrash() != null) {
            sql.SET("path_istrash = #{pathIstrash,jdbcType=BIGINT}");
        }
        
        sql.WHERE("path_id = #{pathId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, FilePathPOExample example, boolean includeExamplePhrase) {
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