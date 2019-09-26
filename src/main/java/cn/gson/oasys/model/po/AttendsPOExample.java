package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AttendsPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendsPOExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAttendsIdIsNull() {
            addCriterion("attends_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendsIdIsNotNull() {
            addCriterion("attends_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendsIdEqualTo(Long value) {
            addCriterion("attends_id =", value, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdNotEqualTo(Long value) {
            addCriterion("attends_id <>", value, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdGreaterThan(Long value) {
            addCriterion("attends_id >", value, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attends_id >=", value, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdLessThan(Long value) {
            addCriterion("attends_id <", value, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdLessThanOrEqualTo(Long value) {
            addCriterion("attends_id <=", value, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdIn(List<Long> values) {
            addCriterion("attends_id in", values, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdNotIn(List<Long> values) {
            addCriterion("attends_id not in", values, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdBetween(Long value1, Long value2) {
            addCriterion("attends_id between", value1, value2, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIdNotBetween(Long value1, Long value2) {
            addCriterion("attends_id not between", value1, value2, "attendsId");
            return (Criteria) this;
        }

        public Criteria andAttendsIpIsNull() {
            addCriterion("attends_ip is null");
            return (Criteria) this;
        }

        public Criteria andAttendsIpIsNotNull() {
            addCriterion("attends_ip is not null");
            return (Criteria) this;
        }

        public Criteria andAttendsIpEqualTo(String value) {
            addCriterion("attends_ip =", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpNotEqualTo(String value) {
            addCriterion("attends_ip <>", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpGreaterThan(String value) {
            addCriterion("attends_ip >", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpGreaterThanOrEqualTo(String value) {
            addCriterion("attends_ip >=", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpLessThan(String value) {
            addCriterion("attends_ip <", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpLessThanOrEqualTo(String value) {
            addCriterion("attends_ip <=", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpLike(String value) {
            addCriterion("attends_ip like", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpNotLike(String value) {
            addCriterion("attends_ip not like", value, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpIn(List<String> values) {
            addCriterion("attends_ip in", values, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpNotIn(List<String> values) {
            addCriterion("attends_ip not in", values, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpBetween(String value1, String value2) {
            addCriterion("attends_ip between", value1, value2, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsIpNotBetween(String value1, String value2) {
            addCriterion("attends_ip not between", value1, value2, "attendsIp");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkIsNull() {
            addCriterion("attends_remark is null");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkIsNotNull() {
            addCriterion("attends_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkEqualTo(String value) {
            addCriterion("attends_remark =", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkNotEqualTo(String value) {
            addCriterion("attends_remark <>", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkGreaterThan(String value) {
            addCriterion("attends_remark >", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("attends_remark >=", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkLessThan(String value) {
            addCriterion("attends_remark <", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkLessThanOrEqualTo(String value) {
            addCriterion("attends_remark <=", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkLike(String value) {
            addCriterion("attends_remark like", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkNotLike(String value) {
            addCriterion("attends_remark not like", value, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkIn(List<String> values) {
            addCriterion("attends_remark in", values, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkNotIn(List<String> values) {
            addCriterion("attends_remark not in", values, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkBetween(String value1, String value2) {
            addCriterion("attends_remark between", value1, value2, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsRemarkNotBetween(String value1, String value2) {
            addCriterion("attends_remark not between", value1, value2, "attendsRemark");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeIsNull() {
            addCriterion("attends_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeIsNotNull() {
            addCriterion("attends_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeEqualTo(Date value) {
            addCriterion("attends_time =", value, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeNotEqualTo(Date value) {
            addCriterion("attends_time <>", value, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeGreaterThan(Date value) {
            addCriterion("attends_time >", value, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attends_time >=", value, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeLessThan(Date value) {
            addCriterion("attends_time <", value, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeLessThanOrEqualTo(Date value) {
            addCriterion("attends_time <=", value, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeIn(List<Date> values) {
            addCriterion("attends_time in", values, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeNotIn(List<Date> values) {
            addCriterion("attends_time not in", values, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeBetween(Date value1, Date value2) {
            addCriterion("attends_time between", value1, value2, "attendsTime");
            return (Criteria) this;
        }

        public Criteria andAttendsTimeNotBetween(Date value1, Date value2) {
            addCriterion("attends_time not between", value1, value2, "attendsTime");
            return (Criteria) this;
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

        public Criteria andAttendsUserIdIsNull() {
            addCriterion("attends_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdIsNotNull() {
            addCriterion("attends_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdEqualTo(Long value) {
            addCriterion("attends_user_id =", value, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdNotEqualTo(Long value) {
            addCriterion("attends_user_id <>", value, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdGreaterThan(Long value) {
            addCriterion("attends_user_id >", value, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attends_user_id >=", value, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdLessThan(Long value) {
            addCriterion("attends_user_id <", value, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdLessThanOrEqualTo(Long value) {
            addCriterion("attends_user_id <=", value, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdIn(List<Long> values) {
            addCriterion("attends_user_id in", values, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdNotIn(List<Long> values) {
            addCriterion("attends_user_id not in", values, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdBetween(Long value1, Long value2) {
            addCriterion("attends_user_id between", value1, value2, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendsUserIdNotBetween(Long value1, Long value2) {
            addCriterion("attends_user_id not between", value1, value2, "attendsUserId");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeIsNull() {
            addCriterion("attend_hmtime is null");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeIsNotNull() {
            addCriterion("attend_hmtime is not null");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeEqualTo(String value) {
            addCriterion("attend_hmtime =", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeNotEqualTo(String value) {
            addCriterion("attend_hmtime <>", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeGreaterThan(String value) {
            addCriterion("attend_hmtime >", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeGreaterThanOrEqualTo(String value) {
            addCriterion("attend_hmtime >=", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeLessThan(String value) {
            addCriterion("attend_hmtime <", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeLessThanOrEqualTo(String value) {
            addCriterion("attend_hmtime <=", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeLike(String value) {
            addCriterion("attend_hmtime like", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeNotLike(String value) {
            addCriterion("attend_hmtime not like", value, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeIn(List<String> values) {
            addCriterion("attend_hmtime in", values, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeNotIn(List<String> values) {
            addCriterion("attend_hmtime not in", values, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeBetween(String value1, String value2) {
            addCriterion("attend_hmtime between", value1, value2, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andAttendHmtimeNotBetween(String value1, String value2) {
            addCriterion("attend_hmtime not between", value1, value2, "attendHmtime");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayIsNull() {
            addCriterion("week_ofday is null");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayIsNotNull() {
            addCriterion("week_ofday is not null");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayEqualTo(String value) {
            addCriterion("week_ofday =", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayNotEqualTo(String value) {
            addCriterion("week_ofday <>", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayGreaterThan(String value) {
            addCriterion("week_ofday >", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayGreaterThanOrEqualTo(String value) {
            addCriterion("week_ofday >=", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayLessThan(String value) {
            addCriterion("week_ofday <", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayLessThanOrEqualTo(String value) {
            addCriterion("week_ofday <=", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayLike(String value) {
            addCriterion("week_ofday like", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayNotLike(String value) {
            addCriterion("week_ofday not like", value, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayIn(List<String> values) {
            addCriterion("week_ofday in", values, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayNotIn(List<String> values) {
            addCriterion("week_ofday not in", values, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayBetween(String value1, String value2) {
            addCriterion("week_ofday between", value1, value2, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andWeekOfdayNotBetween(String value1, String value2) {
            addCriterion("week_ofday not between", value1, value2, "weekOfday");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysIsNull() {
            addCriterion("holiday_days is null");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysIsNotNull() {
            addCriterion("holiday_days is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysEqualTo(Double value) {
            addCriterion("holiday_days =", value, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysNotEqualTo(Double value) {
            addCriterion("holiday_days <>", value, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysGreaterThan(Double value) {
            addCriterion("holiday_days >", value, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysGreaterThanOrEqualTo(Double value) {
            addCriterion("holiday_days >=", value, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysLessThan(Double value) {
            addCriterion("holiday_days <", value, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysLessThanOrEqualTo(Double value) {
            addCriterion("holiday_days <=", value, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysIn(List<Double> values) {
            addCriterion("holiday_days in", values, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysNotIn(List<Double> values) {
            addCriterion("holiday_days not in", values, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysBetween(Double value1, Double value2) {
            addCriterion("holiday_days between", value1, value2, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayDaysNotBetween(Double value1, Double value2) {
            addCriterion("holiday_days not between", value1, value2, "holidayDays");
            return (Criteria) this;
        }

        public Criteria andHolidayStartIsNull() {
            addCriterion("holiday_start is null");
            return (Criteria) this;
        }

        public Criteria andHolidayStartIsNotNull() {
            addCriterion("holiday_start is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayStartEqualTo(Date value) {
            addCriterionForJDBCDate("holiday_start =", value, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("holiday_start <>", value, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartGreaterThan(Date value) {
            addCriterionForJDBCDate("holiday_start >", value, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("holiday_start >=", value, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartLessThan(Date value) {
            addCriterionForJDBCDate("holiday_start <", value, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("holiday_start <=", value, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartIn(List<Date> values) {
            addCriterionForJDBCDate("holiday_start in", values, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("holiday_start not in", values, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("holiday_start between", value1, value2, "holidayStart");
            return (Criteria) this;
        }

        public Criteria andHolidayStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("holiday_start not between", value1, value2, "holidayStart");
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