package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.DirectorPO;
import cn.gson.oasys.modelV2.po.DirectorPOExample.Criteria;
import cn.gson.oasys.modelV2.po.DirectorPOExample.Criterion;
import cn.gson.oasys.modelV2.po.DirectorPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DirectorPOSqlProvider {

    public String countByExample(DirectorPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_director");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DirectorPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_director");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(DirectorPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_director");
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyNumber() != null) {
            sql.VALUES("company_number", "#{companyNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath() != null) {
            sql.VALUES("image_path", "#{imagePath,jdbcType=INTEGER}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.VALUES("phone_number", "#{phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.VALUES("pinyin", "#{pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyname() != null) {
            sql.VALUES("companyname", "#{companyname,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(DirectorPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("director_id");
        } else {
            sql.SELECT("director_id");
        }
        sql.SELECT("address");
        sql.SELECT("company_number");
        sql.SELECT("email");
        sql.SELECT("image_path");
        sql.SELECT("phone_number");
        sql.SELECT("pinyin");
        sql.SELECT("remark");
        sql.SELECT("sex");
        sql.SELECT("user_name");
        sql.SELECT("user_id");
        sql.SELECT("companyname");
        sql.FROM("aoa_director");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        DirectorPO record = (DirectorPO) parameter.get("record");
        DirectorPOExample example = (DirectorPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_director");
        
        if (record.getDirectorId() != null) {
            sql.SET("director_id = #{record.directorId,jdbcType=BIGINT}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyNumber() != null) {
            sql.SET("company_number = #{record.companyNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath() != null) {
            sql.SET("image_path = #{record.imagePath,jdbcType=INTEGER}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{record.phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{record.sex,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyname() != null) {
            sql.SET("companyname = #{record.companyname,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_director");
        
        sql.SET("director_id = #{record.directorId,jdbcType=BIGINT}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("company_number = #{record.companyNumber,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("image_path = #{record.imagePath,jdbcType=INTEGER}");
        sql.SET("phone_number = #{record.phoneNumber,jdbcType=VARCHAR}");
        sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("sex = #{record.sex,jdbcType=VARCHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("companyname = #{record.companyname,jdbcType=VARCHAR}");
        
        DirectorPOExample example = (DirectorPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DirectorPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_director");
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyNumber() != null) {
            sql.SET("company_number = #{companyNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getImagePath() != null) {
            sql.SET("image_path = #{imagePath,jdbcType=INTEGER}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{pinyin,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyname() != null) {
            sql.SET("companyname = #{companyname,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("director_id = #{directorId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DirectorPOExample example, boolean includeExamplePhrase) {
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