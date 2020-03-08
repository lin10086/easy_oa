package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.MailNumberPO;
import cn.gson.oasys.modelV2.po.MailNumberPOExample.Criteria;
import cn.gson.oasys.modelV2.po.MailNumberPOExample.Criterion;
import cn.gson.oasys.modelV2.po.MailNumberPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MailNumberPOSqlProvider {

    public String countByExample(MailNumberPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_mailnumber");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MailNumberPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_mailnumber");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(MailNumberPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_mailnumber");
        
        if (record.getMailAccount() != null) {
            sql.VALUES("mail_account", "#{mailAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMailCreateTime() != null) {
            sql.VALUES("mail_create_time", "#{mailCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMailDes() != null) {
            sql.VALUES("mail_des", "#{mailDes,jdbcType=VARCHAR}");
        }
        
        if (record.getMailType() != null) {
            sql.VALUES("mail_type", "#{mailType,jdbcType=BIGINT}");
        }
        
        if (record.getMailUserName() != null) {
            sql.VALUES("mail_user_name", "#{mailUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=BIGINT}");
        }
        
        if (record.getMailNumUserId() != null) {
            sql.VALUES("mail_num_user_id", "#{mailNumUserId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MailNumberPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("mail_number_id");
        } else {
            sql.SELECT("mail_number_id");
        }
        sql.SELECT("mail_account");
        sql.SELECT("mail_create_time");
        sql.SELECT("mail_des");
        sql.SELECT("mail_type");
        sql.SELECT("mail_user_name");
        sql.SELECT("password");
        sql.SELECT("status");
        sql.SELECT("mail_num_user_id");
        sql.FROM("aoa_mailnumber");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MailNumberPO record = (MailNumberPO) parameter.get("record");
        MailNumberPOExample example = (MailNumberPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_mailnumber");
        
        if (record.getMailNumberId() != null) {
            sql.SET("mail_number_id = #{record.mailNumberId,jdbcType=BIGINT}");
        }
        
        if (record.getMailAccount() != null) {
            sql.SET("mail_account = #{record.mailAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMailCreateTime() != null) {
            sql.SET("mail_create_time = #{record.mailCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMailDes() != null) {
            sql.SET("mail_des = #{record.mailDes,jdbcType=VARCHAR}");
        }
        
        if (record.getMailType() != null) {
            sql.SET("mail_type = #{record.mailType,jdbcType=BIGINT}");
        }
        
        if (record.getMailUserName() != null) {
            sql.SET("mail_user_name = #{record.mailUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=BIGINT}");
        }
        
        if (record.getMailNumUserId() != null) {
            sql.SET("mail_num_user_id = #{record.mailNumUserId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_mailnumber");
        
        sql.SET("mail_number_id = #{record.mailNumberId,jdbcType=BIGINT}");
        sql.SET("mail_account = #{record.mailAccount,jdbcType=VARCHAR}");
        sql.SET("mail_create_time = #{record.mailCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("mail_des = #{record.mailDes,jdbcType=VARCHAR}");
        sql.SET("mail_type = #{record.mailType,jdbcType=BIGINT}");
        sql.SET("mail_user_name = #{record.mailUserName,jdbcType=VARCHAR}");
        sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=BIGINT}");
        sql.SET("mail_num_user_id = #{record.mailNumUserId,jdbcType=BIGINT}");
        
        MailNumberPOExample example = (MailNumberPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MailNumberPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_mailnumber");
        
        if (record.getMailAccount() != null) {
            sql.SET("mail_account = #{mailAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMailCreateTime() != null) {
            sql.SET("mail_create_time = #{mailCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMailDes() != null) {
            sql.SET("mail_des = #{mailDes,jdbcType=VARCHAR}");
        }
        
        if (record.getMailType() != null) {
            sql.SET("mail_type = #{mailType,jdbcType=BIGINT}");
        }
        
        if (record.getMailUserName() != null) {
            sql.SET("mail_user_name = #{mailUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=BIGINT}");
        }
        
        if (record.getMailNumUserId() != null) {
            sql.SET("mail_num_user_id = #{mailNumUserId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("mail_number_id = #{mailNumberId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MailNumberPOExample example, boolean includeExamplePhrase) {
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