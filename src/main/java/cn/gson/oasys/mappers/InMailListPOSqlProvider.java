package cn.gson.oasys.mappers;

import cn.gson.oasys.model.po.InMailListPO;
import cn.gson.oasys.model.po.InMailListPOExample.Criteria;
import cn.gson.oasys.model.po.InMailListPOExample.Criterion;
import cn.gson.oasys.model.po.InMailListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class InMailListPOSqlProvider {

    public String countByExample(InMailListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_in_mail_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(InMailListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_in_mail_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(InMailListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_in_mail_list");
        
        if (record.getMailCreateTime() != null) {
            sql.VALUES("mail_create_time", "#{mailCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMailFileId() != null) {
            sql.VALUES("mail_file_id", "#{mailFileId,jdbcType=BIGINT}");
        }
        
        if (record.getMailTitle() != null) {
            sql.VALUES("mail_title", "#{mailTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getMailType() != null) {
            sql.VALUES("mail_type", "#{mailType,jdbcType=BIGINT}");
        }
        
        if (record.getMailInPushUserId() != null) {
            sql.VALUES("mail_in_push_user_id", "#{mailInPushUserId,jdbcType=BIGINT}");
        }
        
        if (record.getInReceiver() != null) {
            sql.VALUES("in_receiver", "#{inReceiver,jdbcType=VARCHAR}");
        }
        
        if (record.getMailStatusId() != null) {
            sql.VALUES("mail_status_id", "#{mailStatusId,jdbcType=BIGINT}");
        }
        
        if (record.getMailNumberId() != null) {
            sql.VALUES("mail_number_id", "#{mailNumberId,jdbcType=BIGINT}");
        }
        
        if (record.getMailDel() != null) {
            sql.VALUES("mail_del", "#{mailDel,jdbcType=INTEGER}");
        }
        
        if (record.getMailPush() != null) {
            sql.VALUES("mail_push", "#{mailPush,jdbcType=INTEGER}");
        }
        
        if (record.getMailStar() != null) {
            sql.VALUES("mail_star", "#{mailStar,jdbcType=INTEGER}");
        }
        
        if (record.getMailContent() != null) {
            sql.VALUES("mail_content", "#{mailContent,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(InMailListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("mail_id");
        } else {
            sql.SELECT("mail_id");
        }
        sql.SELECT("mail_create_time");
        sql.SELECT("mail_file_id");
        sql.SELECT("mail_title");
        sql.SELECT("mail_type");
        sql.SELECT("mail_in_push_user_id");
        sql.SELECT("in_receiver");
        sql.SELECT("mail_status_id");
        sql.SELECT("mail_number_id");
        sql.SELECT("mail_del");
        sql.SELECT("mail_push");
        sql.SELECT("mail_star");
        sql.SELECT("mail_content");
        sql.FROM("aoa_in_mail_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(InMailListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("mail_id");
        } else {
            sql.SELECT("mail_id");
        }
        sql.SELECT("mail_create_time");
        sql.SELECT("mail_file_id");
        sql.SELECT("mail_title");
        sql.SELECT("mail_type");
        sql.SELECT("mail_in_push_user_id");
        sql.SELECT("in_receiver");
        sql.SELECT("mail_status_id");
        sql.SELECT("mail_number_id");
        sql.SELECT("mail_del");
        sql.SELECT("mail_push");
        sql.SELECT("mail_star");
        sql.FROM("aoa_in_mail_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        InMailListPO record = (InMailListPO) parameter.get("record");
        InMailListPOExample example = (InMailListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_in_mail_list");
        
        if (record.getMailId() != null) {
            sql.SET("mail_id = #{record.mailId,jdbcType=BIGINT}");
        }
        
        if (record.getMailCreateTime() != null) {
            sql.SET("mail_create_time = #{record.mailCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMailFileId() != null) {
            sql.SET("mail_file_id = #{record.mailFileId,jdbcType=BIGINT}");
        }
        
        if (record.getMailTitle() != null) {
            sql.SET("mail_title = #{record.mailTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getMailType() != null) {
            sql.SET("mail_type = #{record.mailType,jdbcType=BIGINT}");
        }
        
        if (record.getMailInPushUserId() != null) {
            sql.SET("mail_in_push_user_id = #{record.mailInPushUserId,jdbcType=BIGINT}");
        }
        
        if (record.getInReceiver() != null) {
            sql.SET("in_receiver = #{record.inReceiver,jdbcType=VARCHAR}");
        }
        
        if (record.getMailStatusId() != null) {
            sql.SET("mail_status_id = #{record.mailStatusId,jdbcType=BIGINT}");
        }
        
        if (record.getMailNumberId() != null) {
            sql.SET("mail_number_id = #{record.mailNumberId,jdbcType=BIGINT}");
        }
        
        if (record.getMailDel() != null) {
            sql.SET("mail_del = #{record.mailDel,jdbcType=INTEGER}");
        }
        
        if (record.getMailPush() != null) {
            sql.SET("mail_push = #{record.mailPush,jdbcType=INTEGER}");
        }
        
        if (record.getMailStar() != null) {
            sql.SET("mail_star = #{record.mailStar,jdbcType=INTEGER}");
        }
        
        if (record.getMailContent() != null) {
            sql.SET("mail_content = #{record.mailContent,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_in_mail_list");
        
        sql.SET("mail_id = #{record.mailId,jdbcType=BIGINT}");
        sql.SET("mail_create_time = #{record.mailCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("mail_file_id = #{record.mailFileId,jdbcType=BIGINT}");
        sql.SET("mail_title = #{record.mailTitle,jdbcType=VARCHAR}");
        sql.SET("mail_type = #{record.mailType,jdbcType=BIGINT}");
        sql.SET("mail_in_push_user_id = #{record.mailInPushUserId,jdbcType=BIGINT}");
        sql.SET("in_receiver = #{record.inReceiver,jdbcType=VARCHAR}");
        sql.SET("mail_status_id = #{record.mailStatusId,jdbcType=BIGINT}");
        sql.SET("mail_number_id = #{record.mailNumberId,jdbcType=BIGINT}");
        sql.SET("mail_del = #{record.mailDel,jdbcType=INTEGER}");
        sql.SET("mail_push = #{record.mailPush,jdbcType=INTEGER}");
        sql.SET("mail_star = #{record.mailStar,jdbcType=INTEGER}");
        sql.SET("mail_content = #{record.mailContent,jdbcType=LONGVARCHAR}");
        
        InMailListPOExample example = (InMailListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_in_mail_list");
        
        sql.SET("mail_id = #{record.mailId,jdbcType=BIGINT}");
        sql.SET("mail_create_time = #{record.mailCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("mail_file_id = #{record.mailFileId,jdbcType=BIGINT}");
        sql.SET("mail_title = #{record.mailTitle,jdbcType=VARCHAR}");
        sql.SET("mail_type = #{record.mailType,jdbcType=BIGINT}");
        sql.SET("mail_in_push_user_id = #{record.mailInPushUserId,jdbcType=BIGINT}");
        sql.SET("in_receiver = #{record.inReceiver,jdbcType=VARCHAR}");
        sql.SET("mail_status_id = #{record.mailStatusId,jdbcType=BIGINT}");
        sql.SET("mail_number_id = #{record.mailNumberId,jdbcType=BIGINT}");
        sql.SET("mail_del = #{record.mailDel,jdbcType=INTEGER}");
        sql.SET("mail_push = #{record.mailPush,jdbcType=INTEGER}");
        sql.SET("mail_star = #{record.mailStar,jdbcType=INTEGER}");
        
        InMailListPOExample example = (InMailListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(InMailListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_in_mail_list");
        
        if (record.getMailCreateTime() != null) {
            sql.SET("mail_create_time = #{mailCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMailFileId() != null) {
            sql.SET("mail_file_id = #{mailFileId,jdbcType=BIGINT}");
        }
        
        if (record.getMailTitle() != null) {
            sql.SET("mail_title = #{mailTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getMailType() != null) {
            sql.SET("mail_type = #{mailType,jdbcType=BIGINT}");
        }
        
        if (record.getMailInPushUserId() != null) {
            sql.SET("mail_in_push_user_id = #{mailInPushUserId,jdbcType=BIGINT}");
        }
        
        if (record.getInReceiver() != null) {
            sql.SET("in_receiver = #{inReceiver,jdbcType=VARCHAR}");
        }
        
        if (record.getMailStatusId() != null) {
            sql.SET("mail_status_id = #{mailStatusId,jdbcType=BIGINT}");
        }
        
        if (record.getMailNumberId() != null) {
            sql.SET("mail_number_id = #{mailNumberId,jdbcType=BIGINT}");
        }
        
        if (record.getMailDel() != null) {
            sql.SET("mail_del = #{mailDel,jdbcType=INTEGER}");
        }
        
        if (record.getMailPush() != null) {
            sql.SET("mail_push = #{mailPush,jdbcType=INTEGER}");
        }
        
        if (record.getMailStar() != null) {
            sql.SET("mail_star = #{mailStar,jdbcType=INTEGER}");
        }
        
        if (record.getMailContent() != null) {
            sql.SET("mail_content = #{mailContent,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("mail_id = #{mailId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, InMailListPOExample example, boolean includeExamplePhrase) {
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