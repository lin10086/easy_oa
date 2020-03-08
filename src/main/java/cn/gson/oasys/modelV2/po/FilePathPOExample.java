package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.List;

public class FilePathPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilePathPOExample() {
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

        public Criteria andPathIdIsNull() {
            addCriterion("path_id is null");
            return (Criteria) this;
        }

        public Criteria andPathIdIsNotNull() {
            addCriterion("path_id is not null");
            return (Criteria) this;
        }

        public Criteria andPathIdEqualTo(Long value) {
            addCriterion("path_id =", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdNotEqualTo(Long value) {
            addCriterion("path_id <>", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdGreaterThan(Long value) {
            addCriterion("path_id >", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdGreaterThanOrEqualTo(Long value) {
            addCriterion("path_id >=", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdLessThan(Long value) {
            addCriterion("path_id <", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdLessThanOrEqualTo(Long value) {
            addCriterion("path_id <=", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdIn(List<Long> values) {
            addCriterion("path_id in", values, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdNotIn(List<Long> values) {
            addCriterion("path_id not in", values, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdBetween(Long value1, Long value2) {
            addCriterion("path_id between", value1, value2, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdNotBetween(Long value1, Long value2) {
            addCriterion("path_id not between", value1, value2, "pathId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andPathNameIsNull() {
            addCriterion("path_name is null");
            return (Criteria) this;
        }

        public Criteria andPathNameIsNotNull() {
            addCriterion("path_name is not null");
            return (Criteria) this;
        }

        public Criteria andPathNameEqualTo(String value) {
            addCriterion("path_name =", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameNotEqualTo(String value) {
            addCriterion("path_name <>", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameGreaterThan(String value) {
            addCriterion("path_name >", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameGreaterThanOrEqualTo(String value) {
            addCriterion("path_name >=", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameLessThan(String value) {
            addCriterion("path_name <", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameLessThanOrEqualTo(String value) {
            addCriterion("path_name <=", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameLike(String value) {
            addCriterion("path_name like", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameNotLike(String value) {
            addCriterion("path_name not like", value, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameIn(List<String> values) {
            addCriterion("path_name in", values, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameNotIn(List<String> values) {
            addCriterion("path_name not in", values, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameBetween(String value1, String value2) {
            addCriterion("path_name between", value1, value2, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathNameNotBetween(String value1, String value2) {
            addCriterion("path_name not between", value1, value2, "pathName");
            return (Criteria) this;
        }

        public Criteria andPathUserIdIsNull() {
            addCriterion("path_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPathUserIdIsNotNull() {
            addCriterion("path_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPathUserIdEqualTo(Long value) {
            addCriterion("path_user_id =", value, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdNotEqualTo(Long value) {
            addCriterion("path_user_id <>", value, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdGreaterThan(Long value) {
            addCriterion("path_user_id >", value, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("path_user_id >=", value, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdLessThan(Long value) {
            addCriterion("path_user_id <", value, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdLessThanOrEqualTo(Long value) {
            addCriterion("path_user_id <=", value, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdIn(List<Long> values) {
            addCriterion("path_user_id in", values, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdNotIn(List<Long> values) {
            addCriterion("path_user_id not in", values, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdBetween(Long value1, Long value2) {
            addCriterion("path_user_id between", value1, value2, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathUserIdNotBetween(Long value1, Long value2) {
            addCriterion("path_user_id not between", value1, value2, "pathUserId");
            return (Criteria) this;
        }

        public Criteria andPathIstrashIsNull() {
            addCriterion("path_istrash is null");
            return (Criteria) this;
        }

        public Criteria andPathIstrashIsNotNull() {
            addCriterion("path_istrash is not null");
            return (Criteria) this;
        }

        public Criteria andPathIstrashEqualTo(Long value) {
            addCriterion("path_istrash =", value, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashNotEqualTo(Long value) {
            addCriterion("path_istrash <>", value, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashGreaterThan(Long value) {
            addCriterion("path_istrash >", value, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashGreaterThanOrEqualTo(Long value) {
            addCriterion("path_istrash >=", value, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashLessThan(Long value) {
            addCriterion("path_istrash <", value, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashLessThanOrEqualTo(Long value) {
            addCriterion("path_istrash <=", value, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashIn(List<Long> values) {
            addCriterion("path_istrash in", values, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashNotIn(List<Long> values) {
            addCriterion("path_istrash not in", values, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashBetween(Long value1, Long value2) {
            addCriterion("path_istrash between", value1, value2, "pathIstrash");
            return (Criteria) this;
        }

        public Criteria andPathIstrashNotBetween(Long value1, Long value2) {
            addCriterion("path_istrash not between", value1, value2, "pathIstrash");
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