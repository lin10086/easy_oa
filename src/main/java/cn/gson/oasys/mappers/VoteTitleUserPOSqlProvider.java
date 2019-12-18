package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.VoteTitleUserPO;
import cn.gson.oasys.model.po.VoteTitleUserPOExample.Criteria;
import cn.gson.oasys.model.po.VoteTitleUserPOExample.Criterion;
import cn.gson.oasys.model.po.VoteTitleUserPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VoteTitleUserPOSqlProvider {

    public String countByExample(VoteTitleUserPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_vote_title_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VoteTitleUserPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_vote_title_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VoteTitleUserPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_vote_title_user");
        
        if (record.getVoteId() != null) {
            sql.VALUES("vote_id", "#{voteId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getTitleId() != null) {
            sql.VALUES("title_id", "#{titleId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VoteTitleUserPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("vote_title_user_id");
        } else {
            sql.SELECT("vote_title_user_id");
        }
        sql.SELECT("vote_id");
        sql.SELECT("user_id");
        sql.SELECT("title_id");
        sql.FROM("aoa_vote_title_user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VoteTitleUserPO record = (VoteTitleUserPO) parameter.get("record");
        VoteTitleUserPOExample example = (VoteTitleUserPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_vote_title_user");
        
        if (record.getVoteTitleUserId() != null) {
            sql.SET("vote_title_user_id = #{record.voteTitleUserId,jdbcType=BIGINT}");
        }
        
        if (record.getVoteId() != null) {
            sql.SET("vote_id = #{record.voteId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getTitleId() != null) {
            sql.SET("title_id = #{record.titleId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_vote_title_user");
        
        sql.SET("vote_title_user_id = #{record.voteTitleUserId,jdbcType=BIGINT}");
        sql.SET("vote_id = #{record.voteId,jdbcType=BIGINT}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("title_id = #{record.titleId,jdbcType=BIGINT}");
        
        VoteTitleUserPOExample example = (VoteTitleUserPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VoteTitleUserPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_vote_title_user");
        
        if (record.getVoteId() != null) {
            sql.SET("vote_id = #{voteId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getTitleId() != null) {
            sql.SET("title_id = #{titleId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("vote_title_user_id = #{voteTitleUserId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VoteTitleUserPOExample example, boolean includeExamplePhrase) {
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