package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DirectorUsersPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DirectorUsersPOExample() {
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

        public Criteria andDirectorUsersIdIsNull() {
            addCriterion("director_users_id is null");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdIsNotNull() {
            addCriterion("director_users_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdEqualTo(Long value) {
            addCriterion("director_users_id =", value, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdNotEqualTo(Long value) {
            addCriterion("director_users_id <>", value, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdGreaterThan(Long value) {
            addCriterion("director_users_id >", value, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdGreaterThanOrEqualTo(Long value) {
            addCriterion("director_users_id >=", value, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdLessThan(Long value) {
            addCriterion("director_users_id <", value, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdLessThanOrEqualTo(Long value) {
            addCriterion("director_users_id <=", value, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdIn(List<Long> values) {
            addCriterion("director_users_id in", values, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdNotIn(List<Long> values) {
            addCriterion("director_users_id not in", values, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdBetween(Long value1, Long value2) {
            addCriterion("director_users_id between", value1, value2, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andDirectorUsersIdNotBetween(Long value1, Long value2) {
            addCriterion("director_users_id not between", value1, value2, "directorUsersId");
            return (Criteria) this;
        }

        public Criteria andCatelogNameIsNull() {
            addCriterion("catelog_name is null");
            return (Criteria) this;
        }

        public Criteria andCatelogNameIsNotNull() {
            addCriterion("catelog_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatelogNameEqualTo(String value) {
            addCriterion("catelog_name =", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotEqualTo(String value) {
            addCriterion("catelog_name <>", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameGreaterThan(String value) {
            addCriterion("catelog_name >", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameGreaterThanOrEqualTo(String value) {
            addCriterion("catelog_name >=", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameLessThan(String value) {
            addCriterion("catelog_name <", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameLessThanOrEqualTo(String value) {
            addCriterion("catelog_name <=", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameLike(String value) {
            addCriterion("catelog_name like", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotLike(String value) {
            addCriterion("catelog_name not like", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameIn(List<String> values) {
            addCriterion("catelog_name in", values, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotIn(List<String> values) {
            addCriterion("catelog_name not in", values, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameBetween(String value1, String value2) {
            addCriterion("catelog_name between", value1, value2, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotBetween(String value1, String value2) {
            addCriterion("catelog_name not between", value1, value2, "catelogName");
            return (Criteria) this;
        }

        public Criteria andIsHandleIsNull() {
            addCriterion("is_handle is null");
            return (Criteria) this;
        }

        public Criteria andIsHandleIsNotNull() {
            addCriterion("is_handle is not null");
            return (Criteria) this;
        }

        public Criteria andIsHandleEqualTo(Integer value) {
            addCriterion("is_handle =", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleNotEqualTo(Integer value) {
            addCriterion("is_handle <>", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleGreaterThan(Integer value) {
            addCriterion("is_handle >", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_handle >=", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleLessThan(Integer value) {
            addCriterion("is_handle <", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleLessThanOrEqualTo(Integer value) {
            addCriterion("is_handle <=", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleIn(List<Integer> values) {
            addCriterion("is_handle in", values, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleNotIn(List<Integer> values) {
            addCriterion("is_handle not in", values, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleBetween(Integer value1, Integer value2) {
            addCriterion("is_handle between", value1, value2, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_handle not between", value1, value2, "isHandle");
            return (Criteria) this;
        }

        public Criteria andDirectorIdIsNull() {
            addCriterion("director_id is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIdIsNotNull() {
            addCriterion("director_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorIdEqualTo(Long value) {
            addCriterion("director_id =", value, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdNotEqualTo(Long value) {
            addCriterion("director_id <>", value, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdGreaterThan(Long value) {
            addCriterion("director_id >", value, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("director_id >=", value, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdLessThan(Long value) {
            addCriterion("director_id <", value, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdLessThanOrEqualTo(Long value) {
            addCriterion("director_id <=", value, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdIn(List<Long> values) {
            addCriterion("director_id in", values, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdNotIn(List<Long> values) {
            addCriterion("director_id not in", values, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdBetween(Long value1, Long value2) {
            addCriterion("director_id between", value1, value2, "directorId");
            return (Criteria) this;
        }

        public Criteria andDirectorIdNotBetween(Long value1, Long value2) {
            addCriterion("director_id not between", value1, value2, "directorId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdIsNull() {
            addCriterion("share_user_id is null");
            return (Criteria) this;
        }

        public Criteria andShareUserIdIsNotNull() {
            addCriterion("share_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareUserIdEqualTo(Long value) {
            addCriterion("share_user_id =", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdNotEqualTo(Long value) {
            addCriterion("share_user_id <>", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdGreaterThan(Long value) {
            addCriterion("share_user_id >", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("share_user_id >=", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdLessThan(Long value) {
            addCriterion("share_user_id <", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdLessThanOrEqualTo(Long value) {
            addCriterion("share_user_id <=", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdIn(List<Long> values) {
            addCriterion("share_user_id in", values, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdNotIn(List<Long> values) {
            addCriterion("share_user_id not in", values, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdBetween(Long value1, Long value2) {
            addCriterion("share_user_id between", value1, value2, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdNotBetween(Long value1, Long value2) {
            addCriterion("share_user_id not between", value1, value2, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andSharetimeIsNull() {
            addCriterion("sharetime is null");
            return (Criteria) this;
        }

        public Criteria andSharetimeIsNotNull() {
            addCriterion("sharetime is not null");
            return (Criteria) this;
        }

        public Criteria andSharetimeEqualTo(Date value) {
            addCriterion("sharetime =", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotEqualTo(Date value) {
            addCriterion("sharetime <>", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeGreaterThan(Date value) {
            addCriterion("sharetime >", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sharetime >=", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeLessThan(Date value) {
            addCriterion("sharetime <", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeLessThanOrEqualTo(Date value) {
            addCriterion("sharetime <=", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeIn(List<Date> values) {
            addCriterion("sharetime in", values, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotIn(List<Date> values) {
            addCriterion("sharetime not in", values, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeBetween(Date value1, Date value2) {
            addCriterion("sharetime between", value1, value2, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotBetween(Date value1, Date value2) {
            addCriterion("sharetime not between", value1, value2, "sharetime");
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