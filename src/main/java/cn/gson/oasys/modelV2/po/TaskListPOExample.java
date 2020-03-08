package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskListPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskListPOExample() {
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

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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

        public Criteria andIsCancelIsNull() {
            addCriterion("is_cancel is null");
            return (Criteria) this;
        }

        public Criteria andIsCancelIsNotNull() {
            addCriterion("is_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andIsCancelEqualTo(Integer value) {
            addCriterion("is_cancel =", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotEqualTo(Integer value) {
            addCriterion("is_cancel <>", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelGreaterThan(Integer value) {
            addCriterion("is_cancel >", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_cancel >=", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelLessThan(Integer value) {
            addCriterion("is_cancel <", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelLessThanOrEqualTo(Integer value) {
            addCriterion("is_cancel <=", value, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelIn(List<Integer> values) {
            addCriterion("is_cancel in", values, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotIn(List<Integer> values) {
            addCriterion("is_cancel not in", values, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelBetween(Integer value1, Integer value2) {
            addCriterion("is_cancel between", value1, value2, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsCancelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_cancel not between", value1, value2, "isCancel");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNull() {
            addCriterion("is_top is null");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNotNull() {
            addCriterion("is_top is not null");
            return (Criteria) this;
        }

        public Criteria andIsTopEqualTo(Integer value) {
            addCriterion("is_top =", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotEqualTo(Integer value) {
            addCriterion("is_top <>", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThan(Integer value) {
            addCriterion("is_top >", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_top >=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThan(Integer value) {
            addCriterion("is_top <", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThanOrEqualTo(Integer value) {
            addCriterion("is_top <=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopIn(List<Integer> values) {
            addCriterion("is_top in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotIn(List<Integer> values) {
            addCriterion("is_top not in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopBetween(Integer value1, Integer value2) {
            addCriterion("is_top between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotBetween(Integer value1, Integer value2) {
            addCriterion("is_top not between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeIsNull() {
            addCriterion("star_time is null");
            return (Criteria) this;
        }

        public Criteria andStarTimeIsNotNull() {
            addCriterion("star_time is not null");
            return (Criteria) this;
        }

        public Criteria andStarTimeEqualTo(Date value) {
            addCriterion("star_time =", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeNotEqualTo(Date value) {
            addCriterion("star_time <>", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeGreaterThan(Date value) {
            addCriterion("star_time >", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("star_time >=", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeLessThan(Date value) {
            addCriterion("star_time <", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeLessThanOrEqualTo(Date value) {
            addCriterion("star_time <=", value, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeIn(List<Date> values) {
            addCriterion("star_time in", values, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeNotIn(List<Date> values) {
            addCriterion("star_time not in", values, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeBetween(Date value1, Date value2) {
            addCriterion("star_time between", value1, value2, "starTime");
            return (Criteria) this;
        }

        public Criteria andStarTimeNotBetween(Date value1, Date value2) {
            addCriterion("star_time not between", value1, value2, "starTime");
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

        public Criteria andStatusIdEqualTo(Integer value) {
            addCriterion("status_id =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(Integer value) {
            addCriterion("status_id <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(Integer value) {
            addCriterion("status_id >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_id >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(Integer value) {
            addCriterion("status_id <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("status_id <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<Integer> values) {
            addCriterion("status_id in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<Integer> values) {
            addCriterion("status_id not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("status_id between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("status_id not between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeIsNull() {
            addCriterion("task_describe is null");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeIsNotNull() {
            addCriterion("task_describe is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeEqualTo(String value) {
            addCriterion("task_describe =", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeNotEqualTo(String value) {
            addCriterion("task_describe <>", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeGreaterThan(String value) {
            addCriterion("task_describe >", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("task_describe >=", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeLessThan(String value) {
            addCriterion("task_describe <", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeLessThanOrEqualTo(String value) {
            addCriterion("task_describe <=", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeLike(String value) {
            addCriterion("task_describe like", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeNotLike(String value) {
            addCriterion("task_describe not like", value, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeIn(List<String> values) {
            addCriterion("task_describe in", values, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeNotIn(List<String> values) {
            addCriterion("task_describe not in", values, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeBetween(String value1, String value2) {
            addCriterion("task_describe between", value1, value2, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTaskDescribeNotBetween(String value1, String value2) {
            addCriterion("task_describe not between", value1, value2, "taskDescribe");
            return (Criteria) this;
        }

        public Criteria andTickingIsNull() {
            addCriterion("ticking is null");
            return (Criteria) this;
        }

        public Criteria andTickingIsNotNull() {
            addCriterion("ticking is not null");
            return (Criteria) this;
        }

        public Criteria andTickingEqualTo(String value) {
            addCriterion("ticking =", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingNotEqualTo(String value) {
            addCriterion("ticking <>", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingGreaterThan(String value) {
            addCriterion("ticking >", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingGreaterThanOrEqualTo(String value) {
            addCriterion("ticking >=", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingLessThan(String value) {
            addCriterion("ticking <", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingLessThanOrEqualTo(String value) {
            addCriterion("ticking <=", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingLike(String value) {
            addCriterion("ticking like", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingNotLike(String value) {
            addCriterion("ticking not like", value, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingIn(List<String> values) {
            addCriterion("ticking in", values, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingNotIn(List<String> values) {
            addCriterion("ticking not in", values, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingBetween(String value1, String value2) {
            addCriterion("ticking between", value1, value2, "ticking");
            return (Criteria) this;
        }

        public Criteria andTickingNotBetween(String value1, String value2) {
            addCriterion("ticking not between", value1, value2, "ticking");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andTaskPushUserIdIsNull() {
            addCriterion("task_push_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdIsNotNull() {
            addCriterion("task_push_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdEqualTo(Long value) {
            addCriterion("task_push_user_id =", value, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdNotEqualTo(Long value) {
            addCriterion("task_push_user_id <>", value, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdGreaterThan(Long value) {
            addCriterion("task_push_user_id >", value, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_push_user_id >=", value, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdLessThan(Long value) {
            addCriterion("task_push_user_id <", value, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdLessThanOrEqualTo(Long value) {
            addCriterion("task_push_user_id <=", value, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdIn(List<Long> values) {
            addCriterion("task_push_user_id in", values, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdNotIn(List<Long> values) {
            addCriterion("task_push_user_id not in", values, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdBetween(Long value1, Long value2) {
            addCriterion("task_push_user_id between", value1, value2, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPushUserIdNotBetween(Long value1, Long value2) {
            addCriterion("task_push_user_id not between", value1, value2, "taskPushUserId");
            return (Criteria) this;
        }

        public Criteria andReciverlistIsNull() {
            addCriterion("reciverlist is null");
            return (Criteria) this;
        }

        public Criteria andReciverlistIsNotNull() {
            addCriterion("reciverlist is not null");
            return (Criteria) this;
        }

        public Criteria andReciverlistEqualTo(String value) {
            addCriterion("reciverlist =", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistNotEqualTo(String value) {
            addCriterion("reciverlist <>", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistGreaterThan(String value) {
            addCriterion("reciverlist >", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistGreaterThanOrEqualTo(String value) {
            addCriterion("reciverlist >=", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistLessThan(String value) {
            addCriterion("reciverlist <", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistLessThanOrEqualTo(String value) {
            addCriterion("reciverlist <=", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistLike(String value) {
            addCriterion("reciverlist like", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistNotLike(String value) {
            addCriterion("reciverlist not like", value, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistIn(List<String> values) {
            addCriterion("reciverlist in", values, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistNotIn(List<String> values) {
            addCriterion("reciverlist not in", values, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistBetween(String value1, String value2) {
            addCriterion("reciverlist between", value1, value2, "reciverlist");
            return (Criteria) this;
        }

        public Criteria andReciverlistNotBetween(String value1, String value2) {
            addCriterion("reciverlist not between", value1, value2, "reciverlist");
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