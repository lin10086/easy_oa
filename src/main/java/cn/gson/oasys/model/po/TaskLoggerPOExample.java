package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskLoggerPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskLoggerPOExample() {
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

        public Criteria andLoggerIdIsNull() {
            addCriterion("logger_id is null");
            return (Criteria) this;
        }

        public Criteria andLoggerIdIsNotNull() {
            addCriterion("logger_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerIdEqualTo(Long value) {
            addCriterion("logger_id =", value, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdNotEqualTo(Long value) {
            addCriterion("logger_id <>", value, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdGreaterThan(Long value) {
            addCriterion("logger_id >", value, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("logger_id >=", value, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdLessThan(Long value) {
            addCriterion("logger_id <", value, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdLessThanOrEqualTo(Long value) {
            addCriterion("logger_id <=", value, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdIn(List<Long> values) {
            addCriterion("logger_id in", values, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdNotIn(List<Long> values) {
            addCriterion("logger_id not in", values, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdBetween(Long value1, Long value2) {
            addCriterion("logger_id between", value1, value2, "loggerId");
            return (Criteria) this;
        }

        public Criteria andLoggerIdNotBetween(Long value1, Long value2) {
            addCriterion("logger_id not between", value1, value2, "loggerId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingIsNull() {
            addCriterion("logger_ticking is null");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingIsNotNull() {
            addCriterion("logger_ticking is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingEqualTo(String value) {
            addCriterion("logger_ticking =", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingNotEqualTo(String value) {
            addCriterion("logger_ticking <>", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingGreaterThan(String value) {
            addCriterion("logger_ticking >", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingGreaterThanOrEqualTo(String value) {
            addCriterion("logger_ticking >=", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingLessThan(String value) {
            addCriterion("logger_ticking <", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingLessThanOrEqualTo(String value) {
            addCriterion("logger_ticking <=", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingLike(String value) {
            addCriterion("logger_ticking like", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingNotLike(String value) {
            addCriterion("logger_ticking not like", value, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingIn(List<String> values) {
            addCriterion("logger_ticking in", values, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingNotIn(List<String> values) {
            addCriterion("logger_ticking not in", values, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingBetween(String value1, String value2) {
            addCriterion("logger_ticking between", value1, value2, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andLoggerTickingNotBetween(String value1, String value2) {
            addCriterion("logger_ticking not between", value1, value2, "loggerTicking");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidIsNull() {
            addCriterion("logger_statusid is null");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidIsNotNull() {
            addCriterion("logger_statusid is not null");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidEqualTo(Integer value) {
            addCriterion("logger_statusid =", value, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidNotEqualTo(Integer value) {
            addCriterion("logger_statusid <>", value, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidGreaterThan(Integer value) {
            addCriterion("logger_statusid >", value, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("logger_statusid >=", value, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidLessThan(Integer value) {
            addCriterion("logger_statusid <", value, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidLessThanOrEqualTo(Integer value) {
            addCriterion("logger_statusid <=", value, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidIn(List<Integer> values) {
            addCriterion("logger_statusid in", values, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidNotIn(List<Integer> values) {
            addCriterion("logger_statusid not in", values, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidBetween(Integer value1, Integer value2) {
            addCriterion("logger_statusid between", value1, value2, "loggerStatusid");
            return (Criteria) this;
        }

        public Criteria andLoggerStatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("logger_statusid not between", value1, value2, "loggerStatusid");
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