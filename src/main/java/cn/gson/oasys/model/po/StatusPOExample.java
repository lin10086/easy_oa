package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.List;

public class StatusPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatusPOExample() {
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

        public Criteria andStatusIdIsNull() {
            addCriterion("status_id is null");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNotNull() {
            addCriterion("status_id is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIdEqualTo(Long value) {
            addCriterion("status_id =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(Long value) {
            addCriterion("status_id <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(Long value) {
            addCriterion("status_id >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(Long value) {
            addCriterion("status_id >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(Long value) {
            addCriterion("status_id <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(Long value) {
            addCriterion("status_id <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<Long> values) {
            addCriterion("status_id in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<Long> values) {
            addCriterion("status_id not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(Long value1, Long value2) {
            addCriterion("status_id between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(Long value1, Long value2) {
            addCriterion("status_id not between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusColorIsNull() {
            addCriterion("status_color is null");
            return (Criteria) this;
        }

        public Criteria andStatusColorIsNotNull() {
            addCriterion("status_color is not null");
            return (Criteria) this;
        }

        public Criteria andStatusColorEqualTo(String value) {
            addCriterion("status_color =", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorNotEqualTo(String value) {
            addCriterion("status_color <>", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorGreaterThan(String value) {
            addCriterion("status_color >", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorGreaterThanOrEqualTo(String value) {
            addCriterion("status_color >=", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorLessThan(String value) {
            addCriterion("status_color <", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorLessThanOrEqualTo(String value) {
            addCriterion("status_color <=", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorLike(String value) {
            addCriterion("status_color like", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorNotLike(String value) {
            addCriterion("status_color not like", value, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorIn(List<String> values) {
            addCriterion("status_color in", values, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorNotIn(List<String> values) {
            addCriterion("status_color not in", values, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorBetween(String value1, String value2) {
            addCriterion("status_color between", value1, value2, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusColorNotBetween(String value1, String value2) {
            addCriterion("status_color not between", value1, value2, "statusColor");
            return (Criteria) this;
        }

        public Criteria andStatusModelIsNull() {
            addCriterion("status_model is null");
            return (Criteria) this;
        }

        public Criteria andStatusModelIsNotNull() {
            addCriterion("status_model is not null");
            return (Criteria) this;
        }

        public Criteria andStatusModelEqualTo(String value) {
            addCriterion("status_model =", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelNotEqualTo(String value) {
            addCriterion("status_model <>", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelGreaterThan(String value) {
            addCriterion("status_model >", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelGreaterThanOrEqualTo(String value) {
            addCriterion("status_model >=", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelLessThan(String value) {
            addCriterion("status_model <", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelLessThanOrEqualTo(String value) {
            addCriterion("status_model <=", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelLike(String value) {
            addCriterion("status_model like", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelNotLike(String value) {
            addCriterion("status_model not like", value, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelIn(List<String> values) {
            addCriterion("status_model in", values, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelNotIn(List<String> values) {
            addCriterion("status_model not in", values, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelBetween(String value1, String value2) {
            addCriterion("status_model between", value1, value2, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusModelNotBetween(String value1, String value2) {
            addCriterion("status_model not between", value1, value2, "statusModel");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNull() {
            addCriterion("status_name is null");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNotNull() {
            addCriterion("status_name is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNameEqualTo(String value) {
            addCriterion("status_name =", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotEqualTo(String value) {
            addCriterion("status_name <>", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThan(String value) {
            addCriterion("status_name >", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("status_name >=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThan(String value) {
            addCriterion("status_name <", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThanOrEqualTo(String value) {
            addCriterion("status_name <=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLike(String value) {
            addCriterion("status_name like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotLike(String value) {
            addCriterion("status_name not like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameIn(List<String> values) {
            addCriterion("status_name in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotIn(List<String> values) {
            addCriterion("status_name not in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameBetween(String value1, String value2) {
            addCriterion("status_name between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotBetween(String value1, String value2) {
            addCriterion("status_name not between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andSortValueIsNull() {
            addCriterion("sort_value is null");
            return (Criteria) this;
        }

        public Criteria andSortValueIsNotNull() {
            addCriterion("sort_value is not null");
            return (Criteria) this;
        }

        public Criteria andSortValueEqualTo(Integer value) {
            addCriterion("sort_value =", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotEqualTo(Integer value) {
            addCriterion("sort_value <>", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueGreaterThan(Integer value) {
            addCriterion("sort_value >", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_value >=", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueLessThan(Integer value) {
            addCriterion("sort_value <", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueLessThanOrEqualTo(Integer value) {
            addCriterion("sort_value <=", value, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueIn(List<Integer> values) {
            addCriterion("sort_value in", values, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotIn(List<Integer> values) {
            addCriterion("sort_value not in", values, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueBetween(Integer value1, Integer value2) {
            addCriterion("sort_value between", value1, value2, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortValueNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_value not between", value1, value2, "sortValue");
            return (Criteria) this;
        }

        public Criteria andSortPrecentIsNull() {
            addCriterion("sort_precent is null");
            return (Criteria) this;
        }

        public Criteria andSortPrecentIsNotNull() {
            addCriterion("sort_precent is not null");
            return (Criteria) this;
        }

        public Criteria andSortPrecentEqualTo(String value) {
            addCriterion("sort_precent =", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentNotEqualTo(String value) {
            addCriterion("sort_precent <>", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentGreaterThan(String value) {
            addCriterion("sort_precent >", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentGreaterThanOrEqualTo(String value) {
            addCriterion("sort_precent >=", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentLessThan(String value) {
            addCriterion("sort_precent <", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentLessThanOrEqualTo(String value) {
            addCriterion("sort_precent <=", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentLike(String value) {
            addCriterion("sort_precent like", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentNotLike(String value) {
            addCriterion("sort_precent not like", value, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentIn(List<String> values) {
            addCriterion("sort_precent in", values, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentNotIn(List<String> values) {
            addCriterion("sort_precent not in", values, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentBetween(String value1, String value2) {
            addCriterion("sort_precent between", value1, value2, "sortPrecent");
            return (Criteria) this;
        }

        public Criteria andSortPrecentNotBetween(String value1, String value2) {
            addCriterion("sort_precent not between", value1, value2, "sortPrecent");
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