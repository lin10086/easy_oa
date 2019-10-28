package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessListPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessListPOExample() {
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

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(Long value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(Long value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(Long value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(Long value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<Long> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<Long> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(Long value1, Long value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdIsNull() {
            addCriterion("deeply_id is null");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdIsNotNull() {
            addCriterion("deeply_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdEqualTo(Long value) {
            addCriterion("deeply_id =", value, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdNotEqualTo(Long value) {
            addCriterion("deeply_id <>", value, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdGreaterThan(Long value) {
            addCriterion("deeply_id >", value, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("deeply_id >=", value, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdLessThan(Long value) {
            addCriterion("deeply_id <", value, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdLessThanOrEqualTo(Long value) {
            addCriterion("deeply_id <=", value, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdIn(List<Long> values) {
            addCriterion("deeply_id in", values, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdNotIn(List<Long> values) {
            addCriterion("deeply_id not in", values, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdBetween(Long value1, Long value2) {
            addCriterion("deeply_id between", value1, value2, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andDeeplyIdNotBetween(Long value1, Long value2) {
            addCriterion("deeply_id not between", value1, value2, "deeplyId");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNull() {
            addCriterion("process_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("process_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("process_name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("process_name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("process_name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("process_name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("process_name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("process_name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("process_name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("process_name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("process_name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("process_name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("process_name not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysIsNull() {
            addCriterion("procsee_days is null");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysIsNotNull() {
            addCriterion("procsee_days is not null");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysEqualTo(Integer value) {
            addCriterion("procsee_days =", value, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysNotEqualTo(Integer value) {
            addCriterion("procsee_days <>", value, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysGreaterThan(Integer value) {
            addCriterion("procsee_days >", value, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("procsee_days >=", value, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysLessThan(Integer value) {
            addCriterion("procsee_days <", value, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysLessThanOrEqualTo(Integer value) {
            addCriterion("procsee_days <=", value, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysIn(List<Integer> values) {
            addCriterion("procsee_days in", values, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysNotIn(List<Integer> values) {
            addCriterion("procsee_days not in", values, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysBetween(Integer value1, Integer value2) {
            addCriterion("procsee_days between", value1, value2, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andProcseeDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("procsee_days not between", value1, value2, "procseeDays");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNull() {
            addCriterion("is_checked is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNotNull() {
            addCriterion("is_checked is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedEqualTo(Integer value) {
            addCriterion("is_checked =", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotEqualTo(Integer value) {
            addCriterion("is_checked <>", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThan(Integer value) {
            addCriterion("is_checked >", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_checked >=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThan(Integer value) {
            addCriterion("is_checked <", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThanOrEqualTo(Integer value) {
            addCriterion("is_checked <=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIn(List<Integer> values) {
            addCriterion("is_checked in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotIn(List<Integer> values) {
            addCriterion("is_checked not in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedBetween(Integer value1, Integer value2) {
            addCriterion("is_checked between", value1, value2, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_checked not between", value1, value2, "isChecked");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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

        public Criteria andProFileIdIsNull() {
            addCriterion("pro_file_id is null");
            return (Criteria) this;
        }

        public Criteria andProFileIdIsNotNull() {
            addCriterion("pro_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andProFileIdEqualTo(Long value) {
            addCriterion("pro_file_id =", value, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdNotEqualTo(Long value) {
            addCriterion("pro_file_id <>", value, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdGreaterThan(Long value) {
            addCriterion("pro_file_id >", value, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_file_id >=", value, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdLessThan(Long value) {
            addCriterion("pro_file_id <", value, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_file_id <=", value, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdIn(List<Long> values) {
            addCriterion("pro_file_id in", values, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdNotIn(List<Long> values) {
            addCriterion("pro_file_id not in", values, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdBetween(Long value1, Long value2) {
            addCriterion("pro_file_id between", value1, value2, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProFileIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_file_id not between", value1, value2, "proFileId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdIsNull() {
            addCriterion("process_user_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdIsNotNull() {
            addCriterion("process_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdEqualTo(Long value) {
            addCriterion("process_user_id =", value, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdNotEqualTo(Long value) {
            addCriterion("process_user_id <>", value, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdGreaterThan(Long value) {
            addCriterion("process_user_id >", value, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("process_user_id >=", value, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdLessThan(Long value) {
            addCriterion("process_user_id <", value, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdLessThanOrEqualTo(Long value) {
            addCriterion("process_user_id <=", value, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdIn(List<Long> values) {
            addCriterion("process_user_id in", values, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdNotIn(List<Long> values) {
            addCriterion("process_user_id not in", values, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdBetween(Long value1, Long value2) {
            addCriterion("process_user_id between", value1, value2, "processUserId");
            return (Criteria) this;
        }

        public Criteria andProcessUserIdNotBetween(Long value1, Long value2) {
            addCriterion("process_user_id not between", value1, value2, "processUserId");
            return (Criteria) this;
        }

        public Criteria andShenuserIsNull() {
            addCriterion("shenuser is null");
            return (Criteria) this;
        }

        public Criteria andShenuserIsNotNull() {
            addCriterion("shenuser is not null");
            return (Criteria) this;
        }

        public Criteria andShenuserEqualTo(String value) {
            addCriterion("shenuser =", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserNotEqualTo(String value) {
            addCriterion("shenuser <>", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserGreaterThan(String value) {
            addCriterion("shenuser >", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserGreaterThanOrEqualTo(String value) {
            addCriterion("shenuser >=", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserLessThan(String value) {
            addCriterion("shenuser <", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserLessThanOrEqualTo(String value) {
            addCriterion("shenuser <=", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserLike(String value) {
            addCriterion("shenuser like", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserNotLike(String value) {
            addCriterion("shenuser not like", value, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserIn(List<String> values) {
            addCriterion("shenuser in", values, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserNotIn(List<String> values) {
            addCriterion("shenuser not in", values, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserBetween(String value1, String value2) {
            addCriterion("shenuser between", value1, value2, "shenuser");
            return (Criteria) this;
        }

        public Criteria andShenuserNotBetween(String value1, String value2) {
            addCriterion("shenuser not between", value1, value2, "shenuser");
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