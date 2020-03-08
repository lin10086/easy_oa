package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.FileListPO;
import cn.gson.oasys.modelV2.po.FileListPOExample.Criteria;
import cn.gson.oasys.modelV2.po.FileListPOExample.Criterion;
import cn.gson.oasys.modelV2.po.FileListPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class FileListPOSqlProvider {

    public String countByExample(FileListPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_file_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FileListPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_file_list");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(FileListPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_file_list");
        
        if (record.getFileName() != null) {
            sql.VALUES("file_name", "#{fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getFilePath() != null) {
            sql.VALUES("file_path", "#{filePath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileShuffix() != null) {
            sql.VALUES("file_shuffix", "#{fileShuffix,jdbcType=VARCHAR}");
        }
        
        if (record.getContentType() != null) {
            sql.VALUES("content_type", "#{contentType,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.VALUES("model", "#{model,jdbcType=VARCHAR}");
        }
        
        if (record.getPathId() != null) {
            sql.VALUES("path_id", "#{pathId,jdbcType=BIGINT}");
        }
        
        if (record.getSize() != null) {
            sql.VALUES("size", "#{size,jdbcType=BIGINT}");
        }
        
        if (record.getUploadTime() != null) {
            sql.VALUES("upload_time", "#{uploadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFileUserId() != null) {
            sql.VALUES("file_user_id", "#{fileUserId,jdbcType=BIGINT}");
        }
        
        if (record.getFileIstrash() != null) {
            sql.VALUES("file_istrash", "#{fileIstrash,jdbcType=BIGINT}");
        }
        
        if (record.getFileIsshare() != null) {
            sql.VALUES("file_isshare", "#{fileIsshare,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(FileListPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("file_id");
        } else {
            sql.SELECT("file_id");
        }
        sql.SELECT("file_name");
        sql.SELECT("file_path");
        sql.SELECT("file_shuffix");
        sql.SELECT("content_type");
        sql.SELECT("model");
        sql.SELECT("path_id");
        sql.SELECT("size");
        sql.SELECT("upload_time");
        sql.SELECT("file_user_id");
        sql.SELECT("file_istrash");
        sql.SELECT("file_isshare");
        sql.FROM("aoa_file_list");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FileListPO record = (FileListPO) parameter.get("record");
        FileListPOExample example = (FileListPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_file_list");
        
        if (record.getFileId() != null) {
            sql.SET("file_id = #{record.fileId,jdbcType=BIGINT}");
        }
        
        if (record.getFileName() != null) {
            sql.SET("file_name = #{record.fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getFilePath() != null) {
            sql.SET("file_path = #{record.filePath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileShuffix() != null) {
            sql.SET("file_shuffix = #{record.fileShuffix,jdbcType=VARCHAR}");
        }
        
        if (record.getContentType() != null) {
            sql.SET("content_type = #{record.contentType,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        }
        
        if (record.getPathId() != null) {
            sql.SET("path_id = #{record.pathId,jdbcType=BIGINT}");
        }
        
        if (record.getSize() != null) {
            sql.SET("size = #{record.size,jdbcType=BIGINT}");
        }
        
        if (record.getUploadTime() != null) {
            sql.SET("upload_time = #{record.uploadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFileUserId() != null) {
            sql.SET("file_user_id = #{record.fileUserId,jdbcType=BIGINT}");
        }
        
        if (record.getFileIstrash() != null) {
            sql.SET("file_istrash = #{record.fileIstrash,jdbcType=BIGINT}");
        }
        
        if (record.getFileIsshare() != null) {
            sql.SET("file_isshare = #{record.fileIsshare,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_file_list");
        
        sql.SET("file_id = #{record.fileId,jdbcType=BIGINT}");
        sql.SET("file_name = #{record.fileName,jdbcType=VARCHAR}");
        sql.SET("file_path = #{record.filePath,jdbcType=VARCHAR}");
        sql.SET("file_shuffix = #{record.fileShuffix,jdbcType=VARCHAR}");
        sql.SET("content_type = #{record.contentType,jdbcType=VARCHAR}");
        sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        sql.SET("path_id = #{record.pathId,jdbcType=BIGINT}");
        sql.SET("size = #{record.size,jdbcType=BIGINT}");
        sql.SET("upload_time = #{record.uploadTime,jdbcType=TIMESTAMP}");
        sql.SET("file_user_id = #{record.fileUserId,jdbcType=BIGINT}");
        sql.SET("file_istrash = #{record.fileIstrash,jdbcType=BIGINT}");
        sql.SET("file_isshare = #{record.fileIsshare,jdbcType=BIGINT}");
        
        FileListPOExample example = (FileListPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FileListPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_file_list");
        
        if (record.getFileName() != null) {
            sql.SET("file_name = #{fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getFilePath() != null) {
            sql.SET("file_path = #{filePath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileShuffix() != null) {
            sql.SET("file_shuffix = #{fileShuffix,jdbcType=VARCHAR}");
        }
        
        if (record.getContentType() != null) {
            sql.SET("content_type = #{contentType,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{model,jdbcType=VARCHAR}");
        }
        
        if (record.getPathId() != null) {
            sql.SET("path_id = #{pathId,jdbcType=BIGINT}");
        }
        
        if (record.getSize() != null) {
            sql.SET("size = #{size,jdbcType=BIGINT}");
        }
        
        if (record.getUploadTime() != null) {
            sql.SET("upload_time = #{uploadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFileUserId() != null) {
            sql.SET("file_user_id = #{fileUserId,jdbcType=BIGINT}");
        }
        
        if (record.getFileIstrash() != null) {
            sql.SET("file_istrash = #{fileIstrash,jdbcType=BIGINT}");
        }
        
        if (record.getFileIsshare() != null) {
            sql.SET("file_isshare = #{fileIsshare,jdbcType=BIGINT}");
        }
        
        sql.WHERE("file_id = #{fileId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, FileListPOExample example, boolean includeExamplePhrase) {
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