package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailsbursePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailsbursePOExample() {
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

        public Criteria andDetailsburseIdIsNull() {
            addCriterion("detailsburse_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdIsNotNull() {
            addCriterion("detailsburse_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdEqualTo(Long value) {
            addCriterion("detailsburse_id =", value, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdNotEqualTo(Long value) {
            addCriterion("detailsburse_id <>", value, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdGreaterThan(Long value) {
            addCriterion("detailsburse_id >", value, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("detailsburse_id >=", value, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdLessThan(Long value) {
            addCriterion("detailsburse_id <", value, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdLessThanOrEqualTo(Long value) {
            addCriterion("detailsburse_id <=", value, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdIn(List<Long> values) {
            addCriterion("detailsburse_id in", values, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdNotIn(List<Long> values) {
            addCriterion("detailsburse_id not in", values, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdBetween(Long value1, Long value2) {
            addCriterion("detailsburse_id between", value1, value2, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDetailsburseIdNotBetween(Long value1, Long value2) {
            addCriterion("detailsburse_id not between", value1, value2, "detailsburseId");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNull() {
            addCriterion("descript is null");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNotNull() {
            addCriterion("descript is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptEqualTo(String value) {
            addCriterion("descript =", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotEqualTo(String value) {
            addCriterion("descript <>", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThan(String value) {
            addCriterion("descript >", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("descript >=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThan(String value) {
            addCriterion("descript <", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThanOrEqualTo(String value) {
            addCriterion("descript <=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLike(String value) {
            addCriterion("descript like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotLike(String value) {
            addCriterion("descript not like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptIn(List<String> values) {
            addCriterion("descript in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotIn(List<String> values) {
            addCriterion("descript not in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptBetween(String value1, String value2) {
            addCriterion("descript between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotBetween(String value1, String value2) {
            addCriterion("descript not between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyIsNull() {
            addCriterion("detailmoney is null");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyIsNotNull() {
            addCriterion("detailmoney is not null");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyEqualTo(Double value) {
            addCriterion("detailmoney =", value, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyNotEqualTo(Double value) {
            addCriterion("detailmoney <>", value, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyGreaterThan(Double value) {
            addCriterion("detailmoney >", value, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("detailmoney >=", value, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyLessThan(Double value) {
            addCriterion("detailmoney <", value, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyLessThanOrEqualTo(Double value) {
            addCriterion("detailmoney <=", value, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyIn(List<Double> values) {
            addCriterion("detailmoney in", values, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyNotIn(List<Double> values) {
            addCriterion("detailmoney not in", values, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyBetween(Double value1, Double value2) {
            addCriterion("detailmoney between", value1, value2, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andDetailmoneyNotBetween(Double value1, Double value2) {
            addCriterion("detailmoney not between", value1, value2, "detailmoney");
            return (Criteria) this;
        }

        public Criteria andInvoicesIsNull() {
            addCriterion("invoices is null");
            return (Criteria) this;
        }

        public Criteria andInvoicesIsNotNull() {
            addCriterion("invoices is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicesEqualTo(Integer value) {
            addCriterion("invoices =", value, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesNotEqualTo(Integer value) {
            addCriterion("invoices <>", value, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesGreaterThan(Integer value) {
            addCriterion("invoices >", value, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoices >=", value, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesLessThan(Integer value) {
            addCriterion("invoices <", value, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesLessThanOrEqualTo(Integer value) {
            addCriterion("invoices <=", value, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesIn(List<Integer> values) {
            addCriterion("invoices in", values, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesNotIn(List<Integer> values) {
            addCriterion("invoices not in", values, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesBetween(Integer value1, Integer value2) {
            addCriterion("invoices between", value1, value2, "invoices");
            return (Criteria) this;
        }

        public Criteria andInvoicesNotBetween(Integer value1, Integer value2) {
            addCriterion("invoices not between", value1, value2, "invoices");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNull() {
            addCriterion("produce_time is null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNotNull() {
            addCriterion("produce_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeEqualTo(Date value) {
            addCriterion("produce_time =", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotEqualTo(Date value) {
            addCriterion("produce_time <>", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThan(Date value) {
            addCriterion("produce_time >", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("produce_time >=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThan(Date value) {
            addCriterion("produce_time <", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThanOrEqualTo(Date value) {
            addCriterion("produce_time <=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIn(List<Date> values) {
            addCriterion("produce_time in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotIn(List<Date> values) {
            addCriterion("produce_time not in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeBetween(Date value1, Date value2) {
            addCriterion("produce_time between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotBetween(Date value1, Date value2) {
            addCriterion("produce_time not between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andBursmentIdIsNull() {
            addCriterion("bursment_id is null");
            return (Criteria) this;
        }

        public Criteria andBursmentIdIsNotNull() {
            addCriterion("bursment_id is not null");
            return (Criteria) this;
        }

        public Criteria andBursmentIdEqualTo(Long value) {
            addCriterion("bursment_id =", value, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdNotEqualTo(Long value) {
            addCriterion("bursment_id <>", value, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdGreaterThan(Long value) {
            addCriterion("bursment_id >", value, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bursment_id >=", value, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdLessThan(Long value) {
            addCriterion("bursment_id <", value, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdLessThanOrEqualTo(Long value) {
            addCriterion("bursment_id <=", value, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdIn(List<Long> values) {
            addCriterion("bursment_id in", values, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdNotIn(List<Long> values) {
            addCriterion("bursment_id not in", values, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdBetween(Long value1, Long value2) {
            addCriterion("bursment_id between", value1, value2, "bursmentId");
            return (Criteria) this;
        }

        public Criteria andBursmentIdNotBetween(Long value1, Long value2) {
            addCriterion("bursment_id not between", value1, value2, "bursmentId");
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