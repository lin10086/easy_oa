package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.List;

public class OvertimePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OvertimePOExample() {
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

        public Criteria andOvertimeIdIsNull() {
            addCriterion("overtime_id is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdIsNotNull() {
            addCriterion("overtime_id is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdEqualTo(Long value) {
            addCriterion("overtime_id =", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdNotEqualTo(Long value) {
            addCriterion("overtime_id <>", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdGreaterThan(Long value) {
            addCriterion("overtime_id >", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("overtime_id >=", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdLessThan(Long value) {
            addCriterion("overtime_id <", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdLessThanOrEqualTo(Long value) {
            addCriterion("overtime_id <=", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdIn(List<Long> values) {
            addCriterion("overtime_id in", values, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdNotIn(List<Long> values) {
            addCriterion("overtime_id not in", values, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdBetween(Long value1, Long value2) {
            addCriterion("overtime_id between", value1, value2, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdNotBetween(Long value1, Long value2) {
            addCriterion("overtime_id not between", value1, value2, "overtimeId");
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

        public Criteria andPersonnelAdviceIsNull() {
            addCriterion("personnel_advice is null");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceIsNotNull() {
            addCriterion("personnel_advice is not null");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceEqualTo(String value) {
            addCriterion("personnel_advice =", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotEqualTo(String value) {
            addCriterion("personnel_advice <>", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceGreaterThan(String value) {
            addCriterion("personnel_advice >", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("personnel_advice >=", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceLessThan(String value) {
            addCriterion("personnel_advice <", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceLessThanOrEqualTo(String value) {
            addCriterion("personnel_advice <=", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceLike(String value) {
            addCriterion("personnel_advice like", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotLike(String value) {
            addCriterion("personnel_advice not like", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceIn(List<String> values) {
            addCriterion("personnel_advice in", values, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotIn(List<String> values) {
            addCriterion("personnel_advice not in", values, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceBetween(String value1, String value2) {
            addCriterion("personnel_advice between", value1, value2, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotBetween(String value1, String value2) {
            addCriterion("personnel_advice not between", value1, value2, "personnelAdvice");
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