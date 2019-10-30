package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrafficPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrafficPOExample() {
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

        public Criteria andTrafficIdIsNull() {
            addCriterion("traffic_id is null");
            return (Criteria) this;
        }

        public Criteria andTrafficIdIsNotNull() {
            addCriterion("traffic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficIdEqualTo(Long value) {
            addCriterion("traffic_id =", value, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdNotEqualTo(Long value) {
            addCriterion("traffic_id <>", value, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdGreaterThan(Long value) {
            addCriterion("traffic_id >", value, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdGreaterThanOrEqualTo(Long value) {
            addCriterion("traffic_id >=", value, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdLessThan(Long value) {
            addCriterion("traffic_id <", value, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdLessThanOrEqualTo(Long value) {
            addCriterion("traffic_id <=", value, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdIn(List<Long> values) {
            addCriterion("traffic_id in", values, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdNotIn(List<Long> values) {
            addCriterion("traffic_id not in", values, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdBetween(Long value1, Long value2) {
            addCriterion("traffic_id between", value1, value2, "trafficId");
            return (Criteria) this;
        }

        public Criteria andTrafficIdNotBetween(Long value1, Long value2) {
            addCriterion("traffic_id not between", value1, value2, "trafficId");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNull() {
            addCriterion("depart_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNotNull() {
            addCriterion("depart_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartNameEqualTo(String value) {
            addCriterion("depart_name =", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotEqualTo(String value) {
            addCriterion("depart_name <>", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThan(String value) {
            addCriterion("depart_name >", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("depart_name >=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThan(String value) {
            addCriterion("depart_name <", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThanOrEqualTo(String value) {
            addCriterion("depart_name <=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLike(String value) {
            addCriterion("depart_name like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotLike(String value) {
            addCriterion("depart_name not like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameIn(List<String> values) {
            addCriterion("depart_name in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotIn(List<String> values) {
            addCriterion("depart_name not in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameBetween(String value1, String value2) {
            addCriterion("depart_name between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotBetween(String value1, String value2) {
            addCriterion("depart_name not between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartTimeIsNull() {
            addCriterion("depart_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartTimeIsNotNull() {
            addCriterion("depart_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartTimeEqualTo(Date value) {
            addCriterion("depart_time =", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeNotEqualTo(Date value) {
            addCriterion("depart_time <>", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeGreaterThan(Date value) {
            addCriterion("depart_time >", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("depart_time >=", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeLessThan(Date value) {
            addCriterion("depart_time <", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeLessThanOrEqualTo(Date value) {
            addCriterion("depart_time <=", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeIn(List<Date> values) {
            addCriterion("depart_time in", values, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeNotIn(List<Date> values) {
            addCriterion("depart_time not in", values, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeBetween(Date value1, Date value2) {
            addCriterion("depart_time between", value1, value2, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeNotBetween(Date value1, Date value2) {
            addCriterion("depart_time not between", value1, value2, "departTime");
            return (Criteria) this;
        }

        public Criteria andReachNameIsNull() {
            addCriterion("reach_name is null");
            return (Criteria) this;
        }

        public Criteria andReachNameIsNotNull() {
            addCriterion("reach_name is not null");
            return (Criteria) this;
        }

        public Criteria andReachNameEqualTo(String value) {
            addCriterion("reach_name =", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameNotEqualTo(String value) {
            addCriterion("reach_name <>", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameGreaterThan(String value) {
            addCriterion("reach_name >", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameGreaterThanOrEqualTo(String value) {
            addCriterion("reach_name >=", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameLessThan(String value) {
            addCriterion("reach_name <", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameLessThanOrEqualTo(String value) {
            addCriterion("reach_name <=", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameLike(String value) {
            addCriterion("reach_name like", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameNotLike(String value) {
            addCriterion("reach_name not like", value, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameIn(List<String> values) {
            addCriterion("reach_name in", values, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameNotIn(List<String> values) {
            addCriterion("reach_name not in", values, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameBetween(String value1, String value2) {
            addCriterion("reach_name between", value1, value2, "reachName");
            return (Criteria) this;
        }

        public Criteria andReachNameNotBetween(String value1, String value2) {
            addCriterion("reach_name not between", value1, value2, "reachName");
            return (Criteria) this;
        }

        public Criteria andSeatTypeIsNull() {
            addCriterion("seat_type is null");
            return (Criteria) this;
        }

        public Criteria andSeatTypeIsNotNull() {
            addCriterion("seat_type is not null");
            return (Criteria) this;
        }

        public Criteria andSeatTypeEqualTo(String value) {
            addCriterion("seat_type =", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotEqualTo(String value) {
            addCriterion("seat_type <>", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeGreaterThan(String value) {
            addCriterion("seat_type >", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("seat_type >=", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeLessThan(String value) {
            addCriterion("seat_type <", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeLessThanOrEqualTo(String value) {
            addCriterion("seat_type <=", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeLike(String value) {
            addCriterion("seat_type like", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotLike(String value) {
            addCriterion("seat_type not like", value, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeIn(List<String> values) {
            addCriterion("seat_type in", values, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotIn(List<String> values) {
            addCriterion("seat_type not in", values, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeBetween(String value1, String value2) {
            addCriterion("seat_type between", value1, value2, "seatType");
            return (Criteria) this;
        }

        public Criteria andSeatTypeNotBetween(String value1, String value2) {
            addCriterion("seat_type not between", value1, value2, "seatType");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyIsNull() {
            addCriterion("traffic_money is null");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyIsNotNull() {
            addCriterion("traffic_money is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyEqualTo(Double value) {
            addCriterion("traffic_money =", value, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyNotEqualTo(Double value) {
            addCriterion("traffic_money <>", value, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyGreaterThan(Double value) {
            addCriterion("traffic_money >", value, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("traffic_money >=", value, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyLessThan(Double value) {
            addCriterion("traffic_money <", value, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyLessThanOrEqualTo(Double value) {
            addCriterion("traffic_money <=", value, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyIn(List<Double> values) {
            addCriterion("traffic_money in", values, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyNotIn(List<Double> values) {
            addCriterion("traffic_money not in", values, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyBetween(Double value1, Double value2) {
            addCriterion("traffic_money between", value1, value2, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficMoneyNotBetween(Double value1, Double value2) {
            addCriterion("traffic_money not between", value1, value2, "trafficMoney");
            return (Criteria) this;
        }

        public Criteria andTrafficNameIsNull() {
            addCriterion("traffic_name is null");
            return (Criteria) this;
        }

        public Criteria andTrafficNameIsNotNull() {
            addCriterion("traffic_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficNameEqualTo(String value) {
            addCriterion("traffic_name =", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameNotEqualTo(String value) {
            addCriterion("traffic_name <>", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameGreaterThan(String value) {
            addCriterion("traffic_name >", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameGreaterThanOrEqualTo(String value) {
            addCriterion("traffic_name >=", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameLessThan(String value) {
            addCriterion("traffic_name <", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameLessThanOrEqualTo(String value) {
            addCriterion("traffic_name <=", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameLike(String value) {
            addCriterion("traffic_name like", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameNotLike(String value) {
            addCriterion("traffic_name not like", value, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameIn(List<String> values) {
            addCriterion("traffic_name in", values, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameNotIn(List<String> values) {
            addCriterion("traffic_name not in", values, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameBetween(String value1, String value2) {
            addCriterion("traffic_name between", value1, value2, "trafficName");
            return (Criteria) this;
        }

        public Criteria andTrafficNameNotBetween(String value1, String value2) {
            addCriterion("traffic_name not between", value1, value2, "trafficName");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdIsNull() {
            addCriterion("evemoney_id is null");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdIsNotNull() {
            addCriterion("evemoney_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdEqualTo(Long value) {
            addCriterion("evemoney_id =", value, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdNotEqualTo(Long value) {
            addCriterion("evemoney_id <>", value, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdGreaterThan(Long value) {
            addCriterion("evemoney_id >", value, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evemoney_id >=", value, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdLessThan(Long value) {
            addCriterion("evemoney_id <", value, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdLessThanOrEqualTo(Long value) {
            addCriterion("evemoney_id <=", value, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdIn(List<Long> values) {
            addCriterion("evemoney_id in", values, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdNotIn(List<Long> values) {
            addCriterion("evemoney_id not in", values, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdBetween(Long value1, Long value2) {
            addCriterion("evemoney_id between", value1, value2, "evemoneyId");
            return (Criteria) this;
        }

        public Criteria andEvemoneyIdNotBetween(Long value1, Long value2) {
            addCriterion("evemoney_id not between", value1, value2, "evemoneyId");
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