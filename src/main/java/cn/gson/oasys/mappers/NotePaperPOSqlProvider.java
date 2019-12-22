package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.NotePaperPO;
import cn.gson.oasys.model.po.NotePaperPOExample.Criteria;
import cn.gson.oasys.model.po.NotePaperPOExample.Criterion;
import cn.gson.oasys.model.po.NotePaperPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class NotePaperPOSqlProvider {

    public String countByExample(NotePaperPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_notepaper");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(NotePaperPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_notepaper");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(NotePaperPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_notepaper");
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getNotepaperUserId() != null) {
            sql.VALUES("notepaper_user_id", "#{notepaperUserId,jdbcType=BIGINT}");
        }
        
        if (record.getConcent() != null) {
            sql.VALUES("concent", "#{concent,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(NotePaperPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("notepaper_id");
        } else {
            sql.SELECT("notepaper_id");
        }
        sql.SELECT("create_time");
        sql.SELECT("title");
        sql.SELECT("notepaper_user_id");
        sql.SELECT("concent");
        sql.FROM("aoa_notepaper");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(NotePaperPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("notepaper_id");
        } else {
            sql.SELECT("notepaper_id");
        }
        sql.SELECT("create_time");
        sql.SELECT("title");
        sql.SELECT("notepaper_user_id");
        sql.FROM("aoa_notepaper");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        NotePaperPO record = (NotePaperPO) parameter.get("record");
        NotePaperPOExample example = (NotePaperPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_notepaper");
        
        if (record.getNotepaperId() != null) {
            sql.SET("notepaper_id = #{record.notepaperId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getNotepaperUserId() != null) {
            sql.SET("notepaper_user_id = #{record.notepaperUserId,jdbcType=BIGINT}");
        }
        
        if (record.getConcent() != null) {
            sql.SET("concent = #{record.concent,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_notepaper");
        
        sql.SET("notepaper_id = #{record.notepaperId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("notepaper_user_id = #{record.notepaperUserId,jdbcType=BIGINT}");
        sql.SET("concent = #{record.concent,jdbcType=LONGVARCHAR}");
        
        NotePaperPOExample example = (NotePaperPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_notepaper");
        
        sql.SET("notepaper_id = #{record.notepaperId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("notepaper_user_id = #{record.notepaperUserId,jdbcType=BIGINT}");
        
        NotePaperPOExample example = (NotePaperPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NotePaperPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_notepaper");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getNotepaperUserId() != null) {
            sql.SET("notepaper_user_id = #{notepaperUserId,jdbcType=BIGINT}");
        }
        
        if (record.getConcent() != null) {
            sql.SET("concent = #{concent,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("notepaper_id = #{notepaperId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NotePaperPOExample example, boolean includeExamplePhrase) {
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