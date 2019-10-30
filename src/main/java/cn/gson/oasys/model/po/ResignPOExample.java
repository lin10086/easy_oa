package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.List;

public class ResignPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResignPOExample() {
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

        public Criteria andResignIdIsNull() {
            addCriterion("resign_id is null");
            return (Criteria) this;
        }

        public Criteria andResignIdIsNotNull() {
            addCriterion("resign_id is not null");
            return (Criteria) this;
        }

        public Criteria andResignIdEqualTo(Long value) {
            addCriterion("resign_id =", value, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdNotEqualTo(Long value) {
            addCriterion("resign_id <>", value, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdGreaterThan(Long value) {
            addCriterion("resign_id >", value, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resign_id >=", value, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdLessThan(Long value) {
            addCriterion("resign_id <", value, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdLessThanOrEqualTo(Long value) {
            addCriterion("resign_id <=", value, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdIn(List<Long> values) {
            addCriterion("resign_id in", values, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdNotIn(List<Long> values) {
            addCriterion("resign_id not in", values, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdBetween(Long value1, Long value2) {
            addCriterion("resign_id between", value1, value2, "resignId");
            return (Criteria) this;
        }

        public Criteria andResignIdNotBetween(Long value1, Long value2) {
            addCriterion("resign_id not between", value1, value2, "resignId");
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

        public Criteria andIsFinishIsNull() {
            addCriterion("is_finish is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNotNull() {
            addCriterion("is_finish is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishEqualTo(Boolean value) {
            addCriterion("is_finish =", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotEqualTo(Boolean value) {
            addCriterion("is_finish <>", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThan(Boolean value) {
            addCriterion("is_finish >", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_finish >=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThan(Boolean value) {
            addCriterion("is_finish <", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThanOrEqualTo(Boolean value) {
            addCriterion("is_finish <=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishIn(List<Boolean> values) {
            addCriterion("is_finish in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotIn(List<Boolean> values) {
            addCriterion("is_finish not in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finish between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finish not between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andNofinishIsNull() {
            addCriterion("nofinish is null");
            return (Criteria) this;
        }

        public Criteria andNofinishIsNotNull() {
            addCriterion("nofinish is not null");
            return (Criteria) this;
        }

        public Criteria andNofinishEqualTo(String value) {
            addCriterion("nofinish =", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishNotEqualTo(String value) {
            addCriterion("nofinish <>", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishGreaterThan(String value) {
            addCriterion("nofinish >", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishGreaterThanOrEqualTo(String value) {
            addCriterion("nofinish >=", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishLessThan(String value) {
            addCriterion("nofinish <", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishLessThanOrEqualTo(String value) {
            addCriterion("nofinish <=", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishLike(String value) {
            addCriterion("nofinish like", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishNotLike(String value) {
            addCriterion("nofinish not like", value, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishIn(List<String> values) {
            addCriterion("nofinish in", values, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishNotIn(List<String> values) {
            addCriterion("nofinish not in", values, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishBetween(String value1, String value2) {
            addCriterion("nofinish between", value1, value2, "nofinish");
            return (Criteria) this;
        }

        public Criteria andNofinishNotBetween(String value1, String value2) {
            addCriterion("nofinish not between", value1, value2, "nofinish");
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

        public Criteria andSuggestIsNull() {
            addCriterion("suggest is null");
            return (Criteria) this;
        }

        public Criteria andSuggestIsNotNull() {
            addCriterion("suggest is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestEqualTo(String value) {
            addCriterion("suggest =", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotEqualTo(String value) {
            addCriterion("suggest <>", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestGreaterThan(String value) {
            addCriterion("suggest >", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestGreaterThanOrEqualTo(String value) {
            addCriterion("suggest >=", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLessThan(String value) {
            addCriterion("suggest <", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLessThanOrEqualTo(String value) {
            addCriterion("suggest <=", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLike(String value) {
            addCriterion("suggest like", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotLike(String value) {
            addCriterion("suggest not like", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestIn(List<String> values) {
            addCriterion("suggest in", values, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotIn(List<String> values) {
            addCriterion("suggest not in", values, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestBetween(String value1, String value2) {
            addCriterion("suggest between", value1, value2, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotBetween(String value1, String value2) {
            addCriterion("suggest not between", value1, value2, "suggest");
            return (Criteria) this;
        }

        public Criteria andHandUserIsNull() {
            addCriterion("hand_user is null");
            return (Criteria) this;
        }

        public Criteria andHandUserIsNotNull() {
            addCriterion("hand_user is not null");
            return (Criteria) this;
        }

        public Criteria andHandUserEqualTo(Long value) {
            addCriterion("hand_user =", value, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserNotEqualTo(Long value) {
            addCriterion("hand_user <>", value, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserGreaterThan(Long value) {
            addCriterion("hand_user >", value, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserGreaterThanOrEqualTo(Long value) {
            addCriterion("hand_user >=", value, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserLessThan(Long value) {
            addCriterion("hand_user <", value, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserLessThanOrEqualTo(Long value) {
            addCriterion("hand_user <=", value, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserIn(List<Long> values) {
            addCriterion("hand_user in", values, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserNotIn(List<Long> values) {
            addCriterion("hand_user not in", values, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserBetween(Long value1, Long value2) {
            addCriterion("hand_user between", value1, value2, "handUser");
            return (Criteria) this;
        }

        public Criteria andHandUserNotBetween(Long value1, Long value2) {
            addCriterion("hand_user not between", value1, value2, "handUser");
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