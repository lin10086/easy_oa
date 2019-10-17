package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BursementPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BursementPOExample() {
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

        public Criteria andBursementIdIsNull() {
            addCriterion("bursement_id is null");
            return (Criteria) this;
        }

        public Criteria andBursementIdIsNotNull() {
            addCriterion("bursement_id is not null");
            return (Criteria) this;
        }

        public Criteria andBursementIdEqualTo(Long value) {
            addCriterion("bursement_id =", value, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdNotEqualTo(Long value) {
            addCriterion("bursement_id <>", value, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdGreaterThan(Long value) {
            addCriterion("bursement_id >", value, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bursement_id >=", value, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdLessThan(Long value) {
            addCriterion("bursement_id <", value, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdLessThanOrEqualTo(Long value) {
            addCriterion("bursement_id <=", value, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdIn(List<Long> values) {
            addCriterion("bursement_id in", values, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdNotIn(List<Long> values) {
            addCriterion("bursement_id not in", values, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdBetween(Long value1, Long value2) {
            addCriterion("bursement_id between", value1, value2, "bursementId");
            return (Criteria) this;
        }

        public Criteria andBursementIdNotBetween(Long value1, Long value2) {
            addCriterion("bursement_id not between", value1, value2, "bursementId");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIsNull() {
            addCriterion("all_money is null");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIsNotNull() {
            addCriterion("all_money is not null");
            return (Criteria) this;
        }

        public Criteria andAllMoneyEqualTo(Double value) {
            addCriterion("all_money =", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotEqualTo(Double value) {
            addCriterion("all_money <>", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyGreaterThan(Double value) {
            addCriterion("all_money >", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("all_money >=", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyLessThan(Double value) {
            addCriterion("all_money <", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyLessThanOrEqualTo(Double value) {
            addCriterion("all_money <=", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIn(List<Double> values) {
            addCriterion("all_money in", values, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotIn(List<Double> values) {
            addCriterion("all_money not in", values, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyBetween(Double value1, Double value2) {
            addCriterion("all_money between", value1, value2, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotBetween(Double value1, Double value2) {
            addCriterion("all_money not between", value1, value2, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesIsNull() {
            addCriterion("allinvoices is null");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesIsNotNull() {
            addCriterion("allinvoices is not null");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesEqualTo(Integer value) {
            addCriterion("allinvoices =", value, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesNotEqualTo(Integer value) {
            addCriterion("allinvoices <>", value, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesGreaterThan(Integer value) {
            addCriterion("allinvoices >", value, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesGreaterThanOrEqualTo(Integer value) {
            addCriterion("allinvoices >=", value, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesLessThan(Integer value) {
            addCriterion("allinvoices <", value, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesLessThanOrEqualTo(Integer value) {
            addCriterion("allinvoices <=", value, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesIn(List<Integer> values) {
            addCriterion("allinvoices in", values, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesNotIn(List<Integer> values) {
            addCriterion("allinvoices not in", values, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesBetween(Integer value1, Integer value2) {
            addCriterion("allinvoices between", value1, value2, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andAllinvoicesNotBetween(Integer value1, Integer value2) {
            addCriterion("allinvoices not between", value1, value2, "allinvoices");
            return (Criteria) this;
        }

        public Criteria andBurseTimeIsNull() {
            addCriterion("burse_time is null");
            return (Criteria) this;
        }

        public Criteria andBurseTimeIsNotNull() {
            addCriterion("burse_time is not null");
            return (Criteria) this;
        }

        public Criteria andBurseTimeEqualTo(Date value) {
            addCriterion("burse_time =", value, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeNotEqualTo(Date value) {
            addCriterion("burse_time <>", value, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeGreaterThan(Date value) {
            addCriterion("burse_time >", value, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("burse_time >=", value, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeLessThan(Date value) {
            addCriterion("burse_time <", value, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeLessThanOrEqualTo(Date value) {
            addCriterion("burse_time <=", value, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeIn(List<Date> values) {
            addCriterion("burse_time in", values, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeNotIn(List<Date> values) {
            addCriterion("burse_time not in", values, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeBetween(Date value1, Date value2) {
            addCriterion("burse_time between", value1, value2, "burseTime");
            return (Criteria) this;
        }

        public Criteria andBurseTimeNotBetween(Date value1, Date value2) {
            addCriterion("burse_time not between", value1, value2, "burseTime");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceIsNull() {
            addCriterion("financial_advice is null");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceIsNotNull() {
            addCriterion("financial_advice is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceEqualTo(String value) {
            addCriterion("financial_advice =", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceNotEqualTo(String value) {
            addCriterion("financial_advice <>", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceGreaterThan(String value) {
            addCriterion("financial_advice >", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("financial_advice >=", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceLessThan(String value) {
            addCriterion("financial_advice <", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceLessThanOrEqualTo(String value) {
            addCriterion("financial_advice <=", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceLike(String value) {
            addCriterion("financial_advice like", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceNotLike(String value) {
            addCriterion("financial_advice not like", value, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceIn(List<String> values) {
            addCriterion("financial_advice in", values, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceNotIn(List<String> values) {
            addCriterion("financial_advice not in", values, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceBetween(String value1, String value2) {
            addCriterion("financial_advice between", value1, value2, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andFinancialAdviceNotBetween(String value1, String value2) {
            addCriterion("financial_advice not between", value1, value2, "financialAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceIsNull() {
            addCriterion("manager_advice is null");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceIsNotNull() {
            addCriterion("manager_advice is not null");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceEqualTo(String value) {
            addCriterion("manager_advice =", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotEqualTo(String value) {
            addCriterion("manager_advice <>", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceGreaterThan(String value) {
            addCriterion("manager_advice >", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("manager_advice >=", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceLessThan(String value) {
            addCriterion("manager_advice <", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceLessThanOrEqualTo(String value) {
            addCriterion("manager_advice <=", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceLike(String value) {
            addCriterion("manager_advice like", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotLike(String value) {
            addCriterion("manager_advice not like", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceIn(List<String> values) {
            addCriterion("manager_advice in", values, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotIn(List<String> values) {
            addCriterion("manager_advice not in", values, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceBetween(String value1, String value2) {
            addCriterion("manager_advice between", value1, value2, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotBetween(String value1, String value2) {
            addCriterion("manager_advice not between", value1, value2, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Long value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Long value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Long value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Long value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Long> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Long> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Long value1, Long value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNull() {
            addCriterion("operation_name is null");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNotNull() {
            addCriterion("operation_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperationNameEqualTo(Long value) {
            addCriterion("operation_name =", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotEqualTo(Long value) {
            addCriterion("operation_name <>", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThan(Long value) {
            addCriterion("operation_name >", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThanOrEqualTo(Long value) {
            addCriterion("operation_name >=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThan(Long value) {
            addCriterion("operation_name <", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThanOrEqualTo(Long value) {
            addCriterion("operation_name <=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameIn(List<Long> values) {
            addCriterion("operation_name in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotIn(List<Long> values) {
            addCriterion("operation_name not in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameBetween(Long value1, Long value2) {
            addCriterion("operation_name between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotBetween(Long value1, Long value2) {
            addCriterion("operation_name not between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Long value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Long value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Long value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Long value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Long> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Long> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Long value1, Long value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(Long value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(Long value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(Long value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(Long value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(Long value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(Long value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<Long> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<Long> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(Long value1, Long value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(Long value1, Long value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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