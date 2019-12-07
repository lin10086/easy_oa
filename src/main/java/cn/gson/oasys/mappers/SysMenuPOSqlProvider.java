package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.SysMenuPO;
import cn.gson.oasys.model.po.SysMenuPOExample.Criteria;
import cn.gson.oasys.model.po.SysMenuPOExample.Criterion;
import cn.gson.oasys.model.po.SysMenuPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysMenuPOSqlProvider {

    public String countByExample(SysMenuPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysMenuPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysMenuPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_sys_menu");
        
        if (record.getIsShow() != null) {
            sql.VALUES("is_show", "#{isShow,jdbcType=INTEGER}");
        }
        
        if (record.getMenuGrade() != null) {
            sql.VALUES("menu_grade", "#{menuGrade,jdbcType=INTEGER}");
        }
        
        if (record.getMenuIcon() != null) {
            sql.VALUES("menu_icon", "#{menuIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuName() != null) {
            sql.VALUES("menu_name", "#{menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuUrl() != null) {
            sql.VALUES("menu_url", "#{menuUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getSortId() != null) {
            sql.VALUES("sort_id", "#{sortId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysMenuPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("menu_id");
        } else {
            sql.SELECT("menu_id");
        }
        sql.SELECT("is_show");
        sql.SELECT("menu_grade");
        sql.SELECT("menu_icon");
        sql.SELECT("menu_name");
        sql.SELECT("menu_url");
        sql.SELECT("parent_id");
        sql.SELECT("sort_id");
        sql.FROM("aoa_sys_menu");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysMenuPO record = (SysMenuPO) parameter.get("record");
        SysMenuPOExample example = (SysMenuPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_sys_menu");
        
        if (record.getMenuId() != null) {
            sql.SET("menu_id = #{record.menuId,jdbcType=BIGINT}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{record.isShow,jdbcType=INTEGER}");
        }
        
        if (record.getMenuGrade() != null) {
            sql.SET("menu_grade = #{record.menuGrade,jdbcType=INTEGER}");
        }
        
        if (record.getMenuIcon() != null) {
            sql.SET("menu_icon = #{record.menuIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuUrl() != null) {
            sql.SET("menu_url = #{record.menuUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getSortId() != null) {
            sql.SET("sort_id = #{record.sortId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_sys_menu");
        
        sql.SET("menu_id = #{record.menuId,jdbcType=BIGINT}");
        sql.SET("is_show = #{record.isShow,jdbcType=INTEGER}");
        sql.SET("menu_grade = #{record.menuGrade,jdbcType=INTEGER}");
        sql.SET("menu_icon = #{record.menuIcon,jdbcType=VARCHAR}");
        sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        sql.SET("menu_url = #{record.menuUrl,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=BIGINT}");
        sql.SET("sort_id = #{record.sortId,jdbcType=INTEGER}");
        
        SysMenuPOExample example = (SysMenuPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysMenuPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_sys_menu");
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{isShow,jdbcType=INTEGER}");
        }
        
        if (record.getMenuGrade() != null) {
            sql.SET("menu_grade = #{menuGrade,jdbcType=INTEGER}");
        }
        
        if (record.getMenuIcon() != null) {
            sql.SET("menu_icon = #{menuIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{menuName,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuUrl() != null) {
            sql.SET("menu_url = #{menuUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getSortId() != null) {
            sql.SET("sort_id = #{sortId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("menu_id = #{menuId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysMenuPOExample example, boolean includeExamplePhrase) {
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