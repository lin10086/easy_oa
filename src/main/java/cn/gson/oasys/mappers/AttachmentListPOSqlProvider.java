package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.AttachmentListPO;
import cn.gson.oasys.modelV2.po.AttachmentListPOExample.Criteria;
import cn.gson.oasys.modelV2.po.AttachmentListPOExample.Criterion;
import cn.gson.oasys.modelV2.po.AttachmentListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AttachmentListPOSqlProvider {

    public String countByExample(AttachmentListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_attachment_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AttachmentListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_attachment_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(AttachmentListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_attachment_list");
        
        if (record.getAttachmentName() != null) {
            sql.VALUES("attachment_name", "#{attachmentName,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentPath() != null) {
            sql.VALUES("attachment_path", "#{attachmentPath,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentShuffix() != null) {
            sql.VALUES("attachment_shuffix", "#{attachmentShuffix,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentSize() != null) {
            sql.VALUES("attachment_size", "#{attachmentSize,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentType() != null) {
            sql.VALUES("attachment_type", "#{attachmentType,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.VALUES("model", "#{model,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadTime() != null) {
            sql.VALUES("upload_time", "#{uploadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AttachmentListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("attachment_id");
        } else {
            sql.SELECT("attachment_id");
        }
        sql.SELECT("attachment_name");
        sql.SELECT("attachment_path");
        sql.SELECT("attachment_shuffix");
        sql.SELECT("attachment_size");
        sql.SELECT("attachment_type");
        sql.SELECT("model");
        sql.SELECT("upload_time");
        sql.SELECT("user_id");
        sql.FROM("aoa_attachment_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AttachmentListPO record = (AttachmentListPO) parameter.get("record");
        AttachmentListPOExample example = (AttachmentListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_attachment_list");
        
        if (record.getAttachmentId() != null) {
            sql.SET("attachment_id = #{record.attachmentId,jdbcType=BIGINT}");
        }
        
        if (record.getAttachmentName() != null) {
            sql.SET("attachment_name = #{record.attachmentName,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentPath() != null) {
            sql.SET("attachment_path = #{record.attachmentPath,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentShuffix() != null) {
            sql.SET("attachment_shuffix = #{record.attachmentShuffix,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentSize() != null) {
            sql.SET("attachment_size = #{record.attachmentSize,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentType() != null) {
            sql.SET("attachment_type = #{record.attachmentType,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadTime() != null) {
            sql.SET("upload_time = #{record.uploadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_attachment_list");
        
        sql.SET("attachment_id = #{record.attachmentId,jdbcType=BIGINT}");
        sql.SET("attachment_name = #{record.attachmentName,jdbcType=VARCHAR}");
        sql.SET("attachment_path = #{record.attachmentPath,jdbcType=VARCHAR}");
        sql.SET("attachment_shuffix = #{record.attachmentShuffix,jdbcType=VARCHAR}");
        sql.SET("attachment_size = #{record.attachmentSize,jdbcType=VARCHAR}");
        sql.SET("attachment_type = #{record.attachmentType,jdbcType=VARCHAR}");
        sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        sql.SET("upload_time = #{record.uploadTime,jdbcType=TIMESTAMP}");
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        
        AttachmentListPOExample example = (AttachmentListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AttachmentListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_attachment_list");
        
        if (record.getAttachmentName() != null) {
            sql.SET("attachment_name = #{attachmentName,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentPath() != null) {
            sql.SET("attachment_path = #{attachmentPath,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentShuffix() != null) {
            sql.SET("attachment_shuffix = #{attachmentShuffix,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentSize() != null) {
            sql.SET("attachment_size = #{attachmentSize,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachmentType() != null) {
            sql.SET("attachment_type = #{attachmentType,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{model,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadTime() != null) {
            sql.SET("upload_time = #{uploadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("attachment_id = #{attachmentId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AttachmentListPOExample example, boolean includeExamplePhrase) {
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