package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.List;

public class TypePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypePOExample() {
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

        public Criteria andTypeColorIsNull() {
            addCriterion("type_color is null");
            return (Criteria) this;
        }

        public Criteria andTypeColorIsNotNull() {
            addCriterion("type_color is not null");
            return (Criteria) this;
        }

        public Criteria andTypeColorEqualTo(String value) {
            addCriterion("type_color =", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorNotEqualTo(String value) {
            addCriterion("type_color <>", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorGreaterThan(String value) {
            addCriterion("type_color >", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorGreaterThanOrEqualTo(String value) {
            addCriterion("type_color >=", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorLessThan(String value) {
            addCriterion("type_color <", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorLessThanOrEqualTo(String value) {
            addCriterion("type_color <=", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorLike(String value) {
            addCriterion("type_color like", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorNotLike(String value) {
            addCriterion("type_color not like", value, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorIn(List<String> values) {
            addCriterion("type_color in", values, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorNotIn(List<String> values) {
            addCriterion("type_color not in", values, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorBetween(String value1, String value2) {
            addCriterion("type_color between", value1, value2, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeColorNotBetween(String value1, String value2) {
            addCriterion("type_color not between", value1, value2, "typeColor");
            return (Criteria) this;
        }

        public Criteria andTypeModelIsNull() {
            addCriterion("type_model is null");
            return (Criteria) this;
        }

        public Criteria andTypeModelIsNotNull() {
            addCriterion("type_model is not null");
            return (Criteria) this;
        }

        public Criteria andTypeModelEqualTo(String value) {
            addCriterion("type_model =", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelNotEqualTo(String value) {
            addCriterion("type_model <>", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelGreaterThan(String value) {
            addCriterion("type_model >", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelGreaterThanOrEqualTo(String value) {
            addCriterion("type_model >=", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelLessThan(String value) {
            addCriterion("type_model <", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelLessThanOrEqualTo(String value) {
            addCriterion("type_model <=", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelLike(String value) {
            addCriterion("type_model like", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelNotLike(String value) {
            addCriterion("type_model not like", value, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelIn(List<String> values) {
            addCriterion("type_model in", values, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelNotIn(List<String> values) {
            addCriterion("type_model not in", values, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelBetween(String value1, String value2) {
            addCriterion("type_model between", value1, value2, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeModelNotBetween(String value1, String value2) {
            addCriterion("type_model not between", value1, value2, "typeModel");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
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