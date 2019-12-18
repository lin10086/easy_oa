package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.VoteTitlesPO;
import cn.gson.oasys.model.po.VoteTitlesPOExample.Criteria;
import cn.gson.oasys.model.po.VoteTitlesPOExample.Criterion;
import cn.gson.oasys.model.po.VoteTitlesPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VoteTitlesPOSqlProvider {

    public String countByExample(VoteTitlesPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_vote_titles");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VoteTitlesPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_vote_titles");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VoteTitlesPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_vote_titles");
        
        if (record.getColor() != null) {
            sql.VALUES("color", "#{color,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getVoteId() != null) {
            sql.VALUES("vote_id", "#{voteId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VoteTitlesPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("title_id");
        } else {
            sql.SELECT("title_id");
        }
        sql.SELECT("color");
        sql.SELECT("title");
        sql.SELECT("vote_id");
        sql.FROM("aoa_vote_titles");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VoteTitlesPO record = (VoteTitlesPO) parameter.get("record");
        VoteTitlesPOExample example = (VoteTitlesPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_vote_titles");
        
        if (record.getTitleId() != null) {
            sql.SET("title_id = #{record.titleId,jdbcType=BIGINT}");
        }
        
        if (record.getColor() != null) {
            sql.SET("color = #{record.color,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getVoteId() != null) {
            sql.SET("vote_id = #{record.voteId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_vote_titles");
        
        sql.SET("title_id = #{record.titleId,jdbcType=BIGINT}");
        sql.SET("color = #{record.color,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("vote_id = #{record.voteId,jdbcType=BIGINT}");
        
        VoteTitlesPOExample example = (VoteTitlesPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VoteTitlesPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_vote_titles");
        
        if (record.getColor() != null) {
            sql.SET("color = #{color,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getVoteId() != null) {
            sql.SET("vote_id = #{voteId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("title_id = #{titleId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VoteTitlesPOExample example, boolean includeExamplePhrase) {
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