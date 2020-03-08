package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InMailListPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InMailListPOExample() {
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

        public Criteria andMailIdIsNull() {
            addCriterion("mail_id is null");
            return (Criteria) this;
        }

        public Criteria andMailIdIsNotNull() {
            addCriterion("mail_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailIdEqualTo(Long value) {
            addCriterion("mail_id =", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotEqualTo(Long value) {
            addCriterion("mail_id <>", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdGreaterThan(Long value) {
            addCriterion("mail_id >", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_id >=", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdLessThan(Long value) {
            addCriterion("mail_id <", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdLessThanOrEqualTo(Long value) {
            addCriterion("mail_id <=", value, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdIn(List<Long> values) {
            addCriterion("mail_id in", values, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotIn(List<Long> values) {
            addCriterion("mail_id not in", values, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdBetween(Long value1, Long value2) {
            addCriterion("mail_id between", value1, value2, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailIdNotBetween(Long value1, Long value2) {
            addCriterion("mail_id not between", value1, value2, "mailId");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeIsNull() {
            addCriterion("mail_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeIsNotNull() {
            addCriterion("mail_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeEqualTo(Date value) {
            addCriterion("mail_create_time =", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeNotEqualTo(Date value) {
            addCriterion("mail_create_time <>", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeGreaterThan(Date value) {
            addCriterion("mail_create_time >", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mail_create_time >=", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeLessThan(Date value) {
            addCriterion("mail_create_time <", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("mail_create_time <=", value, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeIn(List<Date> values) {
            addCriterion("mail_create_time in", values, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeNotIn(List<Date> values) {
            addCriterion("mail_create_time not in", values, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeBetween(Date value1, Date value2) {
            addCriterion("mail_create_time between", value1, value2, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("mail_create_time not between", value1, value2, "mailCreateTime");
            return (Criteria) this;
        }

        public Criteria andMailFileIdIsNull() {
            addCriterion("mail_file_id is null");
            return (Criteria) this;
        }

        public Criteria andMailFileIdIsNotNull() {
            addCriterion("mail_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailFileIdEqualTo(Long value) {
            addCriterion("mail_file_id =", value, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdNotEqualTo(Long value) {
            addCriterion("mail_file_id <>", value, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdGreaterThan(Long value) {
            addCriterion("mail_file_id >", value, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_file_id >=", value, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdLessThan(Long value) {
            addCriterion("mail_file_id <", value, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdLessThanOrEqualTo(Long value) {
            addCriterion("mail_file_id <=", value, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdIn(List<Long> values) {
            addCriterion("mail_file_id in", values, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdNotIn(List<Long> values) {
            addCriterion("mail_file_id not in", values, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdBetween(Long value1, Long value2) {
            addCriterion("mail_file_id between", value1, value2, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailFileIdNotBetween(Long value1, Long value2) {
            addCriterion("mail_file_id not between", value1, value2, "mailFileId");
            return (Criteria) this;
        }

        public Criteria andMailTitleIsNull() {
            addCriterion("mail_title is null");
            return (Criteria) this;
        }

        public Criteria andMailTitleIsNotNull() {
            addCriterion("mail_title is not null");
            return (Criteria) this;
        }

        public Criteria andMailTitleEqualTo(String value) {
            addCriterion("mail_title =", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotEqualTo(String value) {
            addCriterion("mail_title <>", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleGreaterThan(String value) {
            addCriterion("mail_title >", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleGreaterThanOrEqualTo(String value) {
            addCriterion("mail_title >=", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLessThan(String value) {
            addCriterion("mail_title <", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLessThanOrEqualTo(String value) {
            addCriterion("mail_title <=", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLike(String value) {
            addCriterion("mail_title like", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotLike(String value) {
            addCriterion("mail_title not like", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleIn(List<String> values) {
            addCriterion("mail_title in", values, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotIn(List<String> values) {
            addCriterion("mail_title not in", values, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleBetween(String value1, String value2) {
            addCriterion("mail_title between", value1, value2, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotBetween(String value1, String value2) {
            addCriterion("mail_title not between", value1, value2, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTypeIsNull() {
            addCriterion("mail_type is null");
            return (Criteria) this;
        }

        public Criteria andMailTypeIsNotNull() {
            addCriterion("mail_type is not null");
            return (Criteria) this;
        }

        public Criteria andMailTypeEqualTo(Long value) {
            addCriterion("mail_type =", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotEqualTo(Long value) {
            addCriterion("mail_type <>", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeGreaterThan(Long value) {
            addCriterion("mail_type >", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_type >=", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeLessThan(Long value) {
            addCriterion("mail_type <", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeLessThanOrEqualTo(Long value) {
            addCriterion("mail_type <=", value, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeIn(List<Long> values) {
            addCriterion("mail_type in", values, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotIn(List<Long> values) {
            addCriterion("mail_type not in", values, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeBetween(Long value1, Long value2) {
            addCriterion("mail_type between", value1, value2, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailTypeNotBetween(Long value1, Long value2) {
            addCriterion("mail_type not between", value1, value2, "mailType");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdIsNull() {
            addCriterion("mail_in_push_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdIsNotNull() {
            addCriterion("mail_in_push_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdEqualTo(Long value) {
            addCriterion("mail_in_push_user_id =", value, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdNotEqualTo(Long value) {
            addCriterion("mail_in_push_user_id <>", value, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdGreaterThan(Long value) {
            addCriterion("mail_in_push_user_id >", value, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_in_push_user_id >=", value, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdLessThan(Long value) {
            addCriterion("mail_in_push_user_id <", value, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdLessThanOrEqualTo(Long value) {
            addCriterion("mail_in_push_user_id <=", value, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdIn(List<Long> values) {
            addCriterion("mail_in_push_user_id in", values, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdNotIn(List<Long> values) {
            addCriterion("mail_in_push_user_id not in", values, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdBetween(Long value1, Long value2) {
            addCriterion("mail_in_push_user_id between", value1, value2, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andMailInPushUserIdNotBetween(Long value1, Long value2) {
            addCriterion("mail_in_push_user_id not between", value1, value2, "mailInPushUserId");
            return (Criteria) this;
        }

        public Criteria andInReceiverIsNull() {
            addCriterion("in_receiver is null");
            return (Criteria) this;
        }

        public Criteria andInReceiverIsNotNull() {
            addCriterion("in_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andInReceiverEqualTo(String value) {
            addCriterion("in_receiver =", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverNotEqualTo(String value) {
            addCriterion("in_receiver <>", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverGreaterThan(String value) {
            addCriterion("in_receiver >", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("in_receiver >=", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverLessThan(String value) {
            addCriterion("in_receiver <", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverLessThanOrEqualTo(String value) {
            addCriterion("in_receiver <=", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverLike(String value) {
            addCriterion("in_receiver like", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverNotLike(String value) {
            addCriterion("in_receiver not like", value, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverIn(List<String> values) {
            addCriterion("in_receiver in", values, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverNotIn(List<String> values) {
            addCriterion("in_receiver not in", values, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverBetween(String value1, String value2) {
            addCriterion("in_receiver between", value1, value2, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andInReceiverNotBetween(String value1, String value2) {
            addCriterion("in_receiver not between", value1, value2, "inReceiver");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdIsNull() {
            addCriterion("mail_status_id is null");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdIsNotNull() {
            addCriterion("mail_status_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdEqualTo(Long value) {
            addCriterion("mail_status_id =", value, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdNotEqualTo(Long value) {
            addCriterion("mail_status_id <>", value, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdGreaterThan(Long value) {
            addCriterion("mail_status_id >", value, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_status_id >=", value, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdLessThan(Long value) {
            addCriterion("mail_status_id <", value, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdLessThanOrEqualTo(Long value) {
            addCriterion("mail_status_id <=", value, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdIn(List<Long> values) {
            addCriterion("mail_status_id in", values, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdNotIn(List<Long> values) {
            addCriterion("mail_status_id not in", values, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdBetween(Long value1, Long value2) {
            addCriterion("mail_status_id between", value1, value2, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailStatusIdNotBetween(Long value1, Long value2) {
            addCriterion("mail_status_id not between", value1, value2, "mailStatusId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdIsNull() {
            addCriterion("mail_number_id is null");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdIsNotNull() {
            addCriterion("mail_number_id is not null");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdEqualTo(Long value) {
            addCriterion("mail_number_id =", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdNotEqualTo(Long value) {
            addCriterion("mail_number_id <>", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdGreaterThan(Long value) {
            addCriterion("mail_number_id >", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mail_number_id >=", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdLessThan(Long value) {
            addCriterion("mail_number_id <", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdLessThanOrEqualTo(Long value) {
            addCriterion("mail_number_id <=", value, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdIn(List<Long> values) {
            addCriterion("mail_number_id in", values, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdNotIn(List<Long> values) {
            addCriterion("mail_number_id not in", values, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdBetween(Long value1, Long value2) {
            addCriterion("mail_number_id between", value1, value2, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailNumberIdNotBetween(Long value1, Long value2) {
            addCriterion("mail_number_id not between", value1, value2, "mailNumberId");
            return (Criteria) this;
        }

        public Criteria andMailDelIsNull() {
            addCriterion("mail_del is null");
            return (Criteria) this;
        }

        public Criteria andMailDelIsNotNull() {
            addCriterion("mail_del is not null");
            return (Criteria) this;
        }

        public Criteria andMailDelEqualTo(Integer value) {
            addCriterion("mail_del =", value, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelNotEqualTo(Integer value) {
            addCriterion("mail_del <>", value, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelGreaterThan(Integer value) {
            addCriterion("mail_del >", value, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_del >=", value, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelLessThan(Integer value) {
            addCriterion("mail_del <", value, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelLessThanOrEqualTo(Integer value) {
            addCriterion("mail_del <=", value, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelIn(List<Integer> values) {
            addCriterion("mail_del in", values, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelNotIn(List<Integer> values) {
            addCriterion("mail_del not in", values, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelBetween(Integer value1, Integer value2) {
            addCriterion("mail_del between", value1, value2, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailDelNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_del not between", value1, value2, "mailDel");
            return (Criteria) this;
        }

        public Criteria andMailPushIsNull() {
            addCriterion("mail_push is null");
            return (Criteria) this;
        }

        public Criteria andMailPushIsNotNull() {
            addCriterion("mail_push is not null");
            return (Criteria) this;
        }

        public Criteria andMailPushEqualTo(Integer value) {
            addCriterion("mail_push =", value, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushNotEqualTo(Integer value) {
            addCriterion("mail_push <>", value, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushGreaterThan(Integer value) {
            addCriterion("mail_push >", value, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_push >=", value, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushLessThan(Integer value) {
            addCriterion("mail_push <", value, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushLessThanOrEqualTo(Integer value) {
            addCriterion("mail_push <=", value, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushIn(List<Integer> values) {
            addCriterion("mail_push in", values, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushNotIn(List<Integer> values) {
            addCriterion("mail_push not in", values, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushBetween(Integer value1, Integer value2) {
            addCriterion("mail_push between", value1, value2, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailPushNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_push not between", value1, value2, "mailPush");
            return (Criteria) this;
        }

        public Criteria andMailStarIsNull() {
            addCriterion("mail_star is null");
            return (Criteria) this;
        }

        public Criteria andMailStarIsNotNull() {
            addCriterion("mail_star is not null");
            return (Criteria) this;
        }

        public Criteria andMailStarEqualTo(Integer value) {
            addCriterion("mail_star =", value, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarNotEqualTo(Integer value) {
            addCriterion("mail_star <>", value, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarGreaterThan(Integer value) {
            addCriterion("mail_star >", value, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_star >=", value, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarLessThan(Integer value) {
            addCriterion("mail_star <", value, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarLessThanOrEqualTo(Integer value) {
            addCriterion("mail_star <=", value, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarIn(List<Integer> values) {
            addCriterion("mail_star in", values, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarNotIn(List<Integer> values) {
            addCriterion("mail_star not in", values, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarBetween(Integer value1, Integer value2) {
            addCriterion("mail_star between", value1, value2, "mailStar");
            return (Criteria) this;
        }

        public Criteria andMailStarNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_star not between", value1, value2, "mailStar");
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