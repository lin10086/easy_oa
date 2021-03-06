package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.List;

public class LoveDiscussUserPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoveDiscussUserPOExample() {
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

        public Criteria andDiscussUserIdIsNull() {
            addCriterion("discuss_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdIsNotNull() {
            addCriterion("discuss_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdEqualTo(Long value) {
            addCriterion("discuss_user_id =", value, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdNotEqualTo(Long value) {
            addCriterion("discuss_user_id <>", value, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdGreaterThan(Long value) {
            addCriterion("discuss_user_id >", value, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("discuss_user_id >=", value, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdLessThan(Long value) {
            addCriterion("discuss_user_id <", value, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdLessThanOrEqualTo(Long value) {
            addCriterion("discuss_user_id <=", value, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdIn(List<Long> values) {
            addCriterion("discuss_user_id in", values, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdNotIn(List<Long> values) {
            addCriterion("discuss_user_id not in", values, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdBetween(Long value1, Long value2) {
            addCriterion("discuss_user_id between", value1, value2, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussUserIdNotBetween(Long value1, Long value2) {
            addCriterion("discuss_user_id not between", value1, value2, "discussUserId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdIsNull() {
            addCriterion("discuss_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscussIdIsNotNull() {
            addCriterion("discuss_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussIdEqualTo(Long value) {
            addCriterion("discuss_id =", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdNotEqualTo(Long value) {
            addCriterion("discuss_id <>", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdGreaterThan(Long value) {
            addCriterion("discuss_id >", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdGreaterThanOrEqualTo(Long value) {
            addCriterion("discuss_id >=", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdLessThan(Long value) {
            addCriterion("discuss_id <", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdLessThanOrEqualTo(Long value) {
            addCriterion("discuss_id <=", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdIn(List<Long> values) {
            addCriterion("discuss_id in", values, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdNotIn(List<Long> values) {
            addCriterion("discuss_id not in", values, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdBetween(Long value1, Long value2) {
            addCriterion("discuss_id between", value1, value2, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdNotBetween(Long value1, Long value2) {
            addCriterion("discuss_id not between", value1, value2, "discussId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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