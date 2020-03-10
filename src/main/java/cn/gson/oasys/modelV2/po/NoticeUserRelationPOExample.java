package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.List;

public class NoticeUserRelationPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeUserRelationPOExample() {
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

        public Criteria andRelationIdIsNull() {
            addCriterion("relation_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationIdEqualTo(Long value) {
            addCriterion("relation_id =", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotEqualTo(Long value) {
            addCriterion("relation_id <>", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThan(Long value) {
            addCriterion("relation_id >", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_id >=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThan(Long value) {
            addCriterion("relation_id <", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_id <=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdIn(List<Long> values) {
            addCriterion("relation_id in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotIn(List<Long> values) {
            addCriterion("relation_id not in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdBetween(Long value1, Long value2) {
            addCriterion("relation_id between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_id not between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Integer> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Integer> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdIsNull() {
            addCriterion("relation_notice_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdIsNotNull() {
            addCriterion("relation_notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdEqualTo(Long value) {
            addCriterion("relation_notice_id =", value, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdNotEqualTo(Long value) {
            addCriterion("relation_notice_id <>", value, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdGreaterThan(Long value) {
            addCriterion("relation_notice_id >", value, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_notice_id >=", value, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdLessThan(Long value) {
            addCriterion("relation_notice_id <", value, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_notice_id <=", value, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdIn(List<Long> values) {
            addCriterion("relation_notice_id in", values, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdNotIn(List<Long> values) {
            addCriterion("relation_notice_id not in", values, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdBetween(Long value1, Long value2) {
            addCriterion("relation_notice_id between", value1, value2, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationNoticeIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_notice_id not between", value1, value2, "relationNoticeId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdIsNull() {
            addCriterion("relation_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdIsNotNull() {
            addCriterion("relation_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdEqualTo(Long value) {
            addCriterion("relation_user_id =", value, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdNotEqualTo(Long value) {
            addCriterion("relation_user_id <>", value, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdGreaterThan(Long value) {
            addCriterion("relation_user_id >", value, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_user_id >=", value, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdLessThan(Long value) {
            addCriterion("relation_user_id <", value, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_user_id <=", value, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdIn(List<Long> values) {
            addCriterion("relation_user_id in", values, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdNotIn(List<Long> values) {
            addCriterion("relation_user_id not in", values, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdBetween(Long value1, Long value2) {
            addCriterion("relation_user_id between", value1, value2, "relationUserId");
            return (Criteria) this;
        }

        public Criteria andRelationUserIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_user_id not between", value1, value2, "relationUserId");
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