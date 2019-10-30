package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StayPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StayPOExample() {
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

        public Criteria andStayIdIsNull() {
            addCriterion("stay_id is null");
            return (Criteria) this;
        }

        public Criteria andStayIdIsNotNull() {
            addCriterion("stay_id is not null");
            return (Criteria) this;
        }

        public Criteria andStayIdEqualTo(Long value) {
            addCriterion("stay_id =", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotEqualTo(Long value) {
            addCriterion("stay_id <>", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdGreaterThan(Long value) {
            addCriterion("stay_id >", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("stay_id >=", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdLessThan(Long value) {
            addCriterion("stay_id <", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdLessThanOrEqualTo(Long value) {
            addCriterion("stay_id <=", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdIn(List<Long> values) {
            addCriterion("stay_id in", values, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotIn(List<Long> values) {
            addCriterion("stay_id not in", values, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdBetween(Long value1, Long value2) {
            addCriterion("stay_id between", value1, value2, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotBetween(Long value1, Long value2) {
            addCriterion("stay_id not between", value1, value2, "stayId");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNull() {
            addCriterion("leave_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNotNull() {
            addCriterion("leave_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeEqualTo(Date value) {
            addCriterion("leave_time =", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotEqualTo(Date value) {
            addCriterion("leave_time <>", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThan(Date value) {
            addCriterion("leave_time >", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("leave_time >=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThan(Date value) {
            addCriterion("leave_time <", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThanOrEqualTo(Date value) {
            addCriterion("leave_time <=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIn(List<Date> values) {
            addCriterion("leave_time in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotIn(List<Date> values) {
            addCriterion("leave_time not in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeBetween(Date value1, Date value2) {
            addCriterion("leave_time between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotBetween(Date value1, Date value2) {
            addCriterion("leave_time not between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andStayCityIsNull() {
            addCriterion("stay_city is null");
            return (Criteria) this;
        }

        public Criteria andStayCityIsNotNull() {
            addCriterion("stay_city is not null");
            return (Criteria) this;
        }

        public Criteria andStayCityEqualTo(String value) {
            addCriterion("stay_city =", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityNotEqualTo(String value) {
            addCriterion("stay_city <>", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityGreaterThan(String value) {
            addCriterion("stay_city >", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityGreaterThanOrEqualTo(String value) {
            addCriterion("stay_city >=", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityLessThan(String value) {
            addCriterion("stay_city <", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityLessThanOrEqualTo(String value) {
            addCriterion("stay_city <=", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityLike(String value) {
            addCriterion("stay_city like", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityNotLike(String value) {
            addCriterion("stay_city not like", value, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityIn(List<String> values) {
            addCriterion("stay_city in", values, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityNotIn(List<String> values) {
            addCriterion("stay_city not in", values, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityBetween(String value1, String value2) {
            addCriterion("stay_city between", value1, value2, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayCityNotBetween(String value1, String value2) {
            addCriterion("stay_city not between", value1, value2, "stayCity");
            return (Criteria) this;
        }

        public Criteria andStayMoneyIsNull() {
            addCriterion("stay_money is null");
            return (Criteria) this;
        }

        public Criteria andStayMoneyIsNotNull() {
            addCriterion("stay_money is not null");
            return (Criteria) this;
        }

        public Criteria andStayMoneyEqualTo(Double value) {
            addCriterion("stay_money =", value, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyNotEqualTo(Double value) {
            addCriterion("stay_money <>", value, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyGreaterThan(Double value) {
            addCriterion("stay_money >", value, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("stay_money >=", value, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyLessThan(Double value) {
            addCriterion("stay_money <", value, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyLessThanOrEqualTo(Double value) {
            addCriterion("stay_money <=", value, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyIn(List<Double> values) {
            addCriterion("stay_money in", values, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyNotIn(List<Double> values) {
            addCriterion("stay_money not in", values, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyBetween(Double value1, Double value2) {
            addCriterion("stay_money between", value1, value2, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayMoneyNotBetween(Double value1, Double value2) {
            addCriterion("stay_money not between", value1, value2, "stayMoney");
            return (Criteria) this;
        }

        public Criteria andStayTimeIsNull() {
            addCriterion("stay_time is null");
            return (Criteria) this;
        }

        public Criteria andStayTimeIsNotNull() {
            addCriterion("stay_time is not null");
            return (Criteria) this;
        }

        public Criteria andStayTimeEqualTo(Date value) {
            addCriterion("stay_time =", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeNotEqualTo(Date value) {
            addCriterion("stay_time <>", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeGreaterThan(Date value) {
            addCriterion("stay_time >", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stay_time >=", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeLessThan(Date value) {
            addCriterion("stay_time <", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeLessThanOrEqualTo(Date value) {
            addCriterion("stay_time <=", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeIn(List<Date> values) {
            addCriterion("stay_time in", values, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeNotIn(List<Date> values) {
            addCriterion("stay_time not in", values, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeBetween(Date value1, Date value2) {
            addCriterion("stay_time between", value1, value2, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeNotBetween(Date value1, Date value2) {
            addCriterion("stay_time not between", value1, value2, "stayTime");
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