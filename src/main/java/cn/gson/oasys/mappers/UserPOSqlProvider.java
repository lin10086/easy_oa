package cn.gson.oasys.mappers;

import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.modelV2.po.UserPOExample.Criteria;
import cn.gson.oasys.modelV2.po.UserPOExample.Criterion;
import cn.gson.oasys.modelV2.po.UserPOExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserPOSqlProvider {

    public String countByExample(UserPOExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("aoa_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserPOExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("aoa_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UserPO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("aoa_user");
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBank() != null) {
            sql.VALUES("bank", "#{bank,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            sql.VALUES("birth", "#{birth,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEamil() != null) {
            sql.VALUES("eamil", "#{eamil,jdbcType=VARCHAR}");
        }
        
        if (record.getFatherId() != null) {
            sql.VALUES("father_id", "#{fatherId,jdbcType=BIGINT}");
        }
        
        if (record.getHireTime() != null) {
            sql.VALUES("hire_time", "#{hireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserIdcard() != null) {
            sql.VALUES("user_idcard", "#{userIdcard,jdbcType=VARCHAR}");
        }
        
        if (record.getImgPath() != null) {
            sql.VALUES("img_path", "#{imgPath,jdbcType=VARCHAR}");
        }
        
        if (record.getIsLock() != null) {
            sql.VALUES("is_lock", "#{isLock,jdbcType=INTEGER}");
        }
        
        if (record.getLastLoginIp() != null) {
            sql.VALUES("last_login_ip", "#{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.VALUES("last_login_time", "#{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyUserId() != null) {
            sql.VALUES("modify_user_id", "#{modifyUserId,jdbcType=BIGINT}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.VALUES("real_name", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getSalary() != null) {
            sql.VALUES("salary", "#{salary,jdbcType=REAL}");
        }
        
        if (record.getUserSchool() != null) {
            sql.VALUES("user_school", "#{userSchool,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getThemeSkin() != null) {
            sql.VALUES("theme_skin", "#{themeSkin,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEdu() != null) {
            sql.VALUES("user_edu", "#{userEdu,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSign() != null) {
            sql.VALUES("user_sign", "#{userSign,jdbcType=VARCHAR}");
        }
        
        if (record.getUserTel() != null) {
            sql.VALUES("user_tel", "#{userTel,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptId() != null) {
            sql.VALUES("dept_id", "#{deptId,jdbcType=BIGINT}");
        }
        
        if (record.getPositionId() != null) {
            sql.VALUES("position_id", "#{positionId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            sql.VALUES("role_id", "#{roleId,jdbcType=BIGINT}");
        }
        
        if (record.getSuperman() != null) {
            sql.VALUES("superman", "#{superman,jdbcType=INTEGER}");
        }
        
        if (record.getHoliday() != null) {
            sql.VALUES("holiday", "#{holiday,jdbcType=INTEGER}");
        }
        
        if (record.getPinyin() != null) {
            sql.VALUES("pinyin", "#{pinyin,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserPOExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("user_id");
        } else {
            sql.SELECT("user_id");
        }
        sql.SELECT("address");
        sql.SELECT("bank");
        sql.SELECT("birth");
        sql.SELECT("eamil");
        sql.SELECT("father_id");
        sql.SELECT("hire_time");
        sql.SELECT("user_idcard");
        sql.SELECT("img_path");
        sql.SELECT("is_lock");
        sql.SELECT("last_login_ip");
        sql.SELECT("last_login_time");
        sql.SELECT("modify_time");
        sql.SELECT("modify_user_id");
        sql.SELECT("password");
        sql.SELECT("real_name");
        sql.SELECT("salary");
        sql.SELECT("user_school");
        sql.SELECT("sex");
        sql.SELECT("theme_skin");
        sql.SELECT("user_edu");
        sql.SELECT("user_name");
        sql.SELECT("user_sign");
        sql.SELECT("user_tel");
        sql.SELECT("dept_id");
        sql.SELECT("position_id");
        sql.SELECT("role_id");
        sql.SELECT("superman");
        sql.SELECT("holiday");
        sql.SELECT("pinyin");
        sql.FROM("aoa_user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserPO record = (UserPO) parameter.get("record");
        UserPOExample example = (UserPOExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("aoa_user");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getBank() != null) {
            sql.SET("bank = #{record.bank,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            sql.SET("birth = #{record.birth,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEamil() != null) {
            sql.SET("eamil = #{record.eamil,jdbcType=VARCHAR}");
        }
        
        if (record.getFatherId() != null) {
            sql.SET("father_id = #{record.fatherId,jdbcType=BIGINT}");
        }
        
        if (record.getHireTime() != null) {
            sql.SET("hire_time = #{record.hireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserIdcard() != null) {
            sql.SET("user_idcard = #{record.userIdcard,jdbcType=VARCHAR}");
        }
        
        if (record.getImgPath() != null) {
            sql.SET("img_path = #{record.imgPath,jdbcType=VARCHAR}");
        }
        
        if (record.getIsLock() != null) {
            sql.SET("is_lock = #{record.isLock,jdbcType=INTEGER}");
        }
        
        if (record.getLastLoginIp() != null) {
            sql.SET("last_login_ip = #{record.lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyUserId() != null) {
            sql.SET("modify_user_id = #{record.modifyUserId,jdbcType=BIGINT}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        }
        
        if (record.getSalary() != null) {
            sql.SET("salary = #{record.salary,jdbcType=REAL}");
        }
        
        if (record.getUserSchool() != null) {
            sql.SET("user_school = #{record.userSchool,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{record.sex,jdbcType=VARCHAR}");
        }
        
        if (record.getThemeSkin() != null) {
            sql.SET("theme_skin = #{record.themeSkin,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEdu() != null) {
            sql.SET("user_edu = #{record.userEdu,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSign() != null) {
            sql.SET("user_sign = #{record.userSign,jdbcType=VARCHAR}");
        }
        
        if (record.getUserTel() != null) {
            sql.SET("user_tel = #{record.userTel,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptId() != null) {
            sql.SET("dept_id = #{record.deptId,jdbcType=BIGINT}");
        }
        
        if (record.getPositionId() != null) {
            sql.SET("position_id = #{record.positionId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            sql.SET("role_id = #{record.roleId,jdbcType=BIGINT}");
        }
        
        if (record.getSuperman() != null) {
            sql.SET("superman = #{record.superman,jdbcType=INTEGER}");
        }
        
        if (record.getHoliday() != null) {
            sql.SET("holiday = #{record.holiday,jdbcType=INTEGER}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_user");
        
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("bank = #{record.bank,jdbcType=VARCHAR}");
        sql.SET("birth = #{record.birth,jdbcType=TIMESTAMP}");
        sql.SET("eamil = #{record.eamil,jdbcType=VARCHAR}");
        sql.SET("father_id = #{record.fatherId,jdbcType=BIGINT}");
        sql.SET("hire_time = #{record.hireTime,jdbcType=TIMESTAMP}");
        sql.SET("user_idcard = #{record.userIdcard,jdbcType=VARCHAR}");
        sql.SET("img_path = #{record.imgPath,jdbcType=VARCHAR}");
        sql.SET("is_lock = #{record.isLock,jdbcType=INTEGER}");
        sql.SET("last_login_ip = #{record.lastLoginIp,jdbcType=VARCHAR}");
        sql.SET("last_login_time = #{record.lastLoginTime,jdbcType=TIMESTAMP}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        sql.SET("modify_user_id = #{record.modifyUserId,jdbcType=BIGINT}");
        sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        sql.SET("salary = #{record.salary,jdbcType=REAL}");
        sql.SET("user_school = #{record.userSchool,jdbcType=VARCHAR}");
        sql.SET("sex = #{record.sex,jdbcType=VARCHAR}");
        sql.SET("theme_skin = #{record.themeSkin,jdbcType=VARCHAR}");
        sql.SET("user_edu = #{record.userEdu,jdbcType=VARCHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("user_sign = #{record.userSign,jdbcType=VARCHAR}");
        sql.SET("user_tel = #{record.userTel,jdbcType=VARCHAR}");
        sql.SET("dept_id = #{record.deptId,jdbcType=BIGINT}");
        sql.SET("position_id = #{record.positionId,jdbcType=BIGINT}");
        sql.SET("role_id = #{record.roleId,jdbcType=BIGINT}");
        sql.SET("superman = #{record.superman,jdbcType=INTEGER}");
        sql.SET("holiday = #{record.holiday,jdbcType=INTEGER}");
        sql.SET("pinyin = #{record.pinyin,jdbcType=VARCHAR}");
        
        UserPOExample example = (UserPOExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserPO record) {
        SQL sql = new SQL();
        sql.UPDATE("aoa_user");
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBank() != null) {
            sql.SET("bank = #{bank,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            sql.SET("birth = #{birth,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEamil() != null) {
            sql.SET("eamil = #{eamil,jdbcType=VARCHAR}");
        }
        
        if (record.getFatherId() != null) {
            sql.SET("father_id = #{fatherId,jdbcType=BIGINT}");
        }
        
        if (record.getHireTime() != null) {
            sql.SET("hire_time = #{hireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserIdcard() != null) {
            sql.SET("user_idcard = #{userIdcard,jdbcType=VARCHAR}");
        }
        
        if (record.getImgPath() != null) {
            sql.SET("img_path = #{imgPath,jdbcType=VARCHAR}");
        }
        
        if (record.getIsLock() != null) {
            sql.SET("is_lock = #{isLock,jdbcType=INTEGER}");
        }
        
        if (record.getLastLoginIp() != null) {
            sql.SET("last_login_ip = #{lastLoginIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.SET("last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyUserId() != null) {
            sql.SET("modify_user_id = #{modifyUserId,jdbcType=BIGINT}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getSalary() != null) {
            sql.SET("salary = #{salary,jdbcType=REAL}");
        }
        
        if (record.getUserSchool() != null) {
            sql.SET("user_school = #{userSchool,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getThemeSkin() != null) {
            sql.SET("theme_skin = #{themeSkin,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEdu() != null) {
            sql.SET("user_edu = #{userEdu,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSign() != null) {
            sql.SET("user_sign = #{userSign,jdbcType=VARCHAR}");
        }
        
        if (record.getUserTel() != null) {
            sql.SET("user_tel = #{userTel,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptId() != null) {
            sql.SET("dept_id = #{deptId,jdbcType=BIGINT}");
        }
        
        if (record.getPositionId() != null) {
            sql.SET("position_id = #{positionId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            sql.SET("role_id = #{roleId,jdbcType=BIGINT}");
        }
        
        if (record.getSuperman() != null) {
            sql.SET("superman = #{superman,jdbcType=INTEGER}");
        }
        
        if (record.getHoliday() != null) {
            sql.SET("holiday = #{holiday,jdbcType=INTEGER}");
        }
        
        if (record.getPinyin() != null) {
            sql.SET("pinyin = #{pinyin,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("user_id = #{userId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserPOExample example, boolean includeExamplePhrase) {
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