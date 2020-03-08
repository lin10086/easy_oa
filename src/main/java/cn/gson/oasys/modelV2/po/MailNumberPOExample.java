package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailNumberPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MailNumberPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMailNumberIdIsNull() {
            addCriterion("mail_number_id is null");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdIsNotNull() {
            addCriterion("mail_number_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdEqualTo(Long value) {
            addCriterion("mail_number_id =", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdNotEqualTo(Long value) {
            addCriterion("mail_number_id <>", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdGreaterThan(Long value) {
            addCriterion("mail_number_id >", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_number_id >=", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdLessThan(Long value) {
            addCriterion("mail_number_id <", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdLessThanOrEqualTo(Long value) {
            addCriterion("mail_number_id <=", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdIn(List<Long> values) {
            addCriterion("mail_number_id in", values, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdNotIn(List<Long> values) {
            addCriterion("mail_number_id not in", values, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdBetween(Long value1, Long value2) {
            addCriterion("mail_number_id between", value1, value2, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdNotBetween(Long value1, Long value2) {
            addCriterion("mail_number_id not between", value1, value2, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailAccountIsNull() {
            addCriterion("mail_account is null");
            return (Criteria) this;
        }

        public Criteria andMailAccountIsNotNull() {
            addCriterion("mail_account is not null");
            return (Criteria) this;
        }

        public Criteria andMailAccountEqualTo(String value) {
            addCriterion("mail_account =", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountNotEqualTo(String value) {
            addCriterion("mail_account <>", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountGreaterThan(String value) {
            addCriterion("mail_account >", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountGreaterThanOrEqualTo(String value) {
            addCriterion("mail_account >=", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountLessThan(String value) {
            addCriterion("mail_account <", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountLessThanOrEqualTo(String value) {
            addCriterion("mail_account <=", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountLike(String value) {
            addCriterion("mail_account like", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountNotLike(String value) {
            addCriterion("mail_account not like", value, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountIn(List<String> values) {
            addCriterion("mail_account in", values, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountNotIn(List<String> values) {
            addCriterion("mail_account not in", values, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountBetween(String value1, String value2) {
            addCriterion("mail_account between", value1, value2, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailAccountNotBetween(String value1, String value2) {
            addCriterion("mail_account not between", value1, value2, "mailAccount");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeIsNull() {
            addCriterion("mail_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeIsNotNull() {
            addCriterion("mail_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeEqualTo(Date value) {
            addCriterion("mail_create_time =", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeNotEqualTo(Date value) {
            addCriterion("mail_create_time <>", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeGreaterThan(Date value) {
            addCriterion("mail_create_time >", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mail_create_time >=", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeLessThan(Date value) {
            addCriterion("mail_create_time <", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("mail_create_time <=", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeIn(List<Date> values) {
            addCriterion("mail_create_time in", values, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeNotIn(List<Date> values) {
            addCriterion("mail_create_time not in", values, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeBetween(Date value1, Date value2) {
            addCriterion("mail_create_time between", value1, value2, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("mail_create_time not between", value1, value2, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailDesIsNull() {
            addCriterion("mail_des is null");
            return (Criteria) this;
        }

        public Criteria andMailDesIsNotNull() {
            addCriterion("mail_des is not null");
            return (Criteria) this;
        }

        public Criteria andMailDesEqualTo(String value) {
            addCriterion("mail_des =", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesNotEqualTo(String value) {
            addCriterion("mail_des <>", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesGreaterThan(String value) {
            addCriterion("mail_des >", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesGreaterThanOrEqualTo(String value) {
            addCriterion("mail_des >=", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesLessThan(String value) {
            addCriterion("mail_des <", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesLessThanOrEqualTo(String value) {
            addCriterion("mail_des <=", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesLike(String value) {
            addCriterion("mail_des like", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesNotLike(String value) {
            addCriterion("mail_des not like", value, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesIn(List<String> values) {
            addCriterion("mail_des in", values, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesNotIn(List<String> values) {
            addCriterion("mail_des not in", values, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesBetween(String value1, String value2) {
            addCriterion("mail_des between", value1, value2, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailDesNotBetween(String value1, String value2) {
            addCriterion("mail_des not between", value1, value2, "mailDes");
            return (Criteria) this;
        }

        public Criteria andMailTypeIsNull() {
            addCriterion("mail_type is null");
            return (Criteria) this;
        }

        public Criteria andMailTypeIsNotNull() {
            addCriterion("mail_type is not null");
            return (Criteria) this;
        }

        public Criteria andMailTypeEqualTo(Long value) {
            addCriterion("mail_type =", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotEqualTo(Long value) {
            addCriterion("mail_type <>", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeGreaterThan(Long value) {
            addCriterion("mail_type >", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_type >=", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeLessThan(Long value) {
            addCriterion("mail_type <", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeLessThanOrEqualTo(Long value) {
            addCriterion("mail_type <=", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeIn(List<Long> values) {
            addCriterion("mail_type in", values, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotIn(List<Long> values) {
            addCriterion("mail_type not in", values, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeBetween(Long value1, Long value2) {
            addCriterion("mail_type between", value1, value2, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotBetween(Long value1, Long value2) {
            addCriterion("mail_type not between", value1, value2, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailUserNameIsNull() {
            addCriterion("mail_user_name is null");
            return (Criteria) this;
        }

        public Criteria andMailUserNameIsNotNull() {
            addCriterion("mail_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andMailUserNameEqualTo(String value) {
            addCriterion("mail_user_name =", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameNotEqualTo(String value) {
            addCriterion("mail_user_name <>", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameGreaterThan(String value) {
            addCriterion("mail_user_name >", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("mail_user_name >=", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameLessThan(String value) {
            addCriterion("mail_user_name <", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameLessThanOrEqualTo(String value) {
            addCriterion("mail_user_name <=", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameLike(String value) {
            addCriterion("mail_user_name like", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameNotLike(String value) {
            addCriterion("mail_user_name not like", value, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameIn(List<String> values) {
            addCriterion("mail_user_name in", values, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameNotIn(List<String> values) {
            addCriterion("mail_user_name not in", values, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameBetween(String value1, String value2) {
            addCriterion("mail_user_name between", value1, value2, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andMailUserNameNotBetween(String value1, String value2) {
            addCriterion("mail_user_name not between", value1, value2, "mailUserName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Long value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Long value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Long value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Long value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Long value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Long> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Long> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Long value1, Long value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Long value1, Long value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdIsNull() {
            addCriterion("mail_num_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdIsNotNull() {
            addCriterion("mail_num_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdEqualTo(Long value) {
            addCriterion("mail_num_user_id =", value, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdNotEqualTo(Long value) {
            addCriterion("mail_num_user_id <>", value, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdGreaterThan(Long value) {
            addCriterion("mail_num_user_id >", value, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_num_user_id >=", value, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdLessThan(Long value) {
            addCriterion("mail_num_user_id <", value, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdLessThanOrEqualTo(Long value) {
            addCriterion("mail_num_user_id <=", value, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdIn(List<Long> values) {
            addCriterion("mail_num_user_id in", values, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdNotIn(List<Long> values) {
            addCriterion("mail_num_user_id not in", values, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdBetween(Long value1, Long value2) {
            addCriterion("mail_num_user_id between", value1, value2, "mailNumUserId");
            return (Criteria) this;
        }

        public Criteria andMailNumUserIdNotBetween(Long value1, Long value2) {
            addCriterion("mail_num_user_id not between", value1, value2, "mailNumUserId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}