package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.DeptPO;
import cn.gson.oasys.modelV2.po.DeptPOExample.Criteria;
import cn.gson.oasys.modelV2.po.DeptPOExample.Criterion;
import cn.gson.oasys.modelV2.po.DeptPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DeptPOSqlProvider {

    public String countByExample(DeptPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_dept");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DeptPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_dept");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(DeptPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_dept");
        
        if (record.getDeptAddr() != null) {
            sql.VALUES("dept_addr", "#{deptAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptFax() != null) {
            sql.VALUES("dept_fax", "#{deptFax,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptName() != null) {
            sql.VALUES("dept_name", "#{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptTel() != null) {
            sql.VALUES("dept_tel", "#{deptTel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptmanager() != null) {
            sql.VALUES("deptmanager", "#{deptmanager,jdbcType=BIGINT}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(DeptPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("dept_id");
        } else {
            sql.SELECT("dept_id");
        }
        sql.SELECT("dept_addr");
        sql.SELECT("dept_fax");
        sql.SELECT("dept_name");
        sql.SELECT("dept_tel");
        sql.SELECT("email");
        sql.SELECT("deptmanager");
        sql.SELECT("end_time");
        sql.SELECT("start_time");
        sql.FROM("aoa_dept");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        DeptPO record = (DeptPO) parameter.get("record");
        DeptPOExample example = (DeptPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_dept");
        
        if (record.getDeptId() != null) {
            sql.SET("dept_id = #{record.deptId,jdbcType=BIGINT}");
        }
        
        if (record.getDeptAddr() != null) {
            sql.SET("dept_addr = #{record.deptAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptFax() != null) {
            sql.SET("dept_fax = #{record.deptFax,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptName() != null) {
            sql.SET("dept_name = #{record.deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptTel() != null) {
            sql.SET("dept_tel = #{record.deptTel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptmanager() != null) {
            sql.SET("deptmanager = #{record.deptmanager,jdbcType=BIGINT}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_dept");
        
        sql.SET("dept_id = #{record.deptId,jdbcType=BIGINT}");
        sql.SET("dept_addr = #{record.deptAddr,jdbcType=VARCHAR}");
        sql.SET("dept_fax = #{record.deptFax,jdbcType=VARCHAR}");
        sql.SET("dept_name = #{record.deptName,jdbcType=VARCHAR}");
        sql.SET("dept_tel = #{record.deptTel,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("deptmanager = #{record.deptmanager,jdbcType=BIGINT}");
        sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        
        DeptPOExample example = (DeptPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DeptPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_dept");
        
        if (record.getDeptAddr() != null) {
            sql.SET("dept_addr = #{deptAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptFax() != null) {
            sql.SET("dept_fax = #{deptFax,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptName() != null) {
            sql.SET("dept_name = #{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptTel() != null) {
            sql.SET("dept_tel = #{deptTel,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptmanager() != null) {
            sql.SET("deptmanager = #{deptmanager,jdbcType=BIGINT}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("dept_id = #{deptId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DeptPOExample example, boolean includeExamplePhrase) {
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