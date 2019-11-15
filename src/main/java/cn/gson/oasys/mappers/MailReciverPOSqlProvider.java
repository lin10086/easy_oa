package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.MailReciverPO;
import cn.gson.oasys.model.po.MailReciverPOExample.Criteria;
import cn.gson.oasys.model.po.MailReciverPOExample.Criterion;
import cn.gson.oasys.model.po.MailReciverPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MailReciverPOSqlProvider {

    public String countByExample(MailReciverPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_mail_reciver");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MailReciverPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_mail_reciver");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(MailReciverPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_mail_reciver");
        
        if (record.getIsRead() != null) {
            sql.VALUES("is_read", "#{isRead,jdbcType=INTEGER}");
        }
        
        if (record.getMailId() != null) {
            sql.VALUES("mail_id", "#{mailId,jdbcType=BIGINT}");
        }
        
        if (record.getMailReciverId() != null) {
            sql.VALUES("mail_reciver_id", "#{mailReciverId,jdbcType=BIGINT}");
        }
        
        if (record.getIsStar() != null) {
            sql.VALUES("is_star", "#{isStar,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MailReciverPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("pk_id");
        } else {
            sql.SELECT("pk_id");
        }
        sql.SELECT("is_read");
        sql.SELECT("mail_id");
        sql.SELECT("mail_reciver_id");
        sql.SELECT("is_star");
        sql.SELECT("is_del");
        sql.FROM("aoa_mail_reciver");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MailReciverPO record = (MailReciverPO) parameter.get("record");
        MailReciverPOExample example = (MailReciverPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_mail_reciver");
        
        if (record.getPkId() != null) {
            sql.SET("pk_id = #{record.pkId,jdbcType=BIGINT}");
        }
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{record.isRead,jdbcType=INTEGER}");
        }
        
        if (record.getMailId() != null) {
            sql.SET("mail_id = #{record.mailId,jdbcType=BIGINT}");
        }
        
        if (record.getMailReciverId() != null) {
            sql.SET("mail_reciver_id = #{record.mailReciverId,jdbcType=BIGINT}");
        }
        
        if (record.getIsStar() != null) {
            sql.SET("is_star = #{record.isStar,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{record.isDel,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_mail_reciver");
        
        sql.SET("pk_id = #{record.pkId,jdbcType=BIGINT}");
        sql.SET("is_read = #{record.isRead,jdbcType=INTEGER}");
        sql.SET("mail_id = #{record.mailId,jdbcType=BIGINT}");
        sql.SET("mail_reciver_id = #{record.mailReciverId,jdbcType=BIGINT}");
        sql.SET("is_star = #{record.isStar,jdbcType=INTEGER}");
        sql.SET("is_del = #{record.isDel,jdbcType=INTEGER}");
        
        MailReciverPOExample example = (MailReciverPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MailReciverPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_mail_reciver");
        
        if (record.getIsRead() != null) {
            sql.SET("is_read = #{isRead,jdbcType=INTEGER}");
        }
        
        if (record.getMailId() != null) {
            sql.SET("mail_id = #{mailId,jdbcType=BIGINT}");
        }
        
        if (record.getMailReciverId() != null) {
            sql.SET("mail_reciver_id = #{mailReciverId,jdbcType=BIGINT}");
        }
        
        if (record.getIsStar() != null) {
            sql.SET("is_star = #{isStar,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=INTEGER}");
        }
        
        sql.WHERE("pk_id = #{pkId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MailReciverPOExample example, boolean includeExamplePhrase) {
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