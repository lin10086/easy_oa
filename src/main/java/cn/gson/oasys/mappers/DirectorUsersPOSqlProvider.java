package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.DirectorUsersPO;
import cn.gson.oasys.model.po.DirectorUsersPOExample.Criteria;
import cn.gson.oasys.model.po.DirectorUsersPOExample.Criterion;
import cn.gson.oasys.model.po.DirectorUsersPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DirectorUsersPOSqlProvider {

    public String countByExample(DirectorUsersPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_director_users");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DirectorUsersPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_director_users");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(DirectorUsersPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_director_users");
        
        if (record.getCatelogName() != null) {
            sql.VALUES("catelog_name", "#{catelogName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHandle() != null) {
            sql.VALUES("is_handle", "#{isHandle,jdbcType=INTEGER}");
        }
        
        if (record.getDirectorId() != null) {
            sql.VALUES("director_id", "#{directorId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getShareUserId() != null) {
            sql.VALUES("share_user_id", "#{shareUserId,jdbcType=BIGINT}");
        }
        
        if (record.getSharetime() != null) {
            sql.VALUES("sharetime", "#{sharetime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(DirectorUsersPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("director_users_id");
        } else {
            sql.SELECT("director_users_id");
        }
        sql.SELECT("catelog_name");
        sql.SELECT("is_handle");
        sql.SELECT("director_id");
        sql.SELECT("user_id");
        sql.SELECT("share_user_id");
        sql.SELECT("sharetime");
        sql.FROM("aoa_director_users");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        DirectorUsersPO record = (DirectorUsersPO) parameter.get("record");
        DirectorUsersPOExample example = (DirectorUsersPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_director_users");
        
        if (record.getDirectorUsersId() != null) {
            sql.SET("director_users_id = #{record.directorUsersId,jdbcType=BIGINT}");
        }
        
        if (record.getCatelogName() != null) {
            sql.SET("catelog_name = #{record.catelogName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHandle() != null) {
            sql.SET("is_handle = #{record.isHandle,jdbcType=INTEGER}");
        }
        
        if (record.getDirectorId() != null) {
            sql.SET("director_id = #{record.directorId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getShareUserId() != null) {
            sql.SET("share_user_id = #{record.shareUserId,jdbcType=BIGINT}");
        }
        
        if (record.getSharetime() != null) {
            sql.SET("sharetime = #{record.sharetime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_director_users");
        
        sql.SET("director_users_id = #{record.directorUsersId,jdbcType=BIGINT}");
        sql.SET("catelog_name = #{record.catelogName,jdbcType=VARCHAR}");
        sql.SET("is_handle = #{record.isHandle,jdbcType=INTEGER}");
        sql.SET("director_id = #{record.directorId,jdbcType=BIGINT}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("share_user_id = #{record.shareUserId,jdbcType=BIGINT}");
        sql.SET("sharetime = #{record.sharetime,jdbcType=TIMESTAMP}");
        
        DirectorUsersPOExample example = (DirectorUsersPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DirectorUsersPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_director_users");
        
        if (record.getCatelogName() != null) {
            sql.SET("catelog_name = #{catelogName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsHandle() != null) {
            sql.SET("is_handle = #{isHandle,jdbcType=INTEGER}");
        }
        
        if (record.getDirectorId() != null) {
            sql.SET("director_id = #{directorId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getShareUserId() != null) {
            sql.SET("share_user_id = #{shareUserId,jdbcType=BIGINT}");
        }
        
        if (record.getSharetime() != null) {
            sql.SET("sharetime = #{sharetime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("director_users_id = #{directorUsersId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DirectorUsersPOExample example, boolean includeExamplePhrase) {
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