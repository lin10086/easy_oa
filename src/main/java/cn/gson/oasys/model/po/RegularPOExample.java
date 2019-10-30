package cn.gson.oasys.model.po;

import java.util.ArrayList;
import java.util.List;

public class RegularPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegularPOExample() {
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

        public Criteria andRegularIdIsNull() {
            addCriterion("regular_id is null");
            return (Criteria) this;
        }

        public Criteria andRegularIdIsNotNull() {
            addCriterion("regular_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegularIdEqualTo(Long value) {
            addCriterion("regular_id =", value, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdNotEqualTo(Long value) {
            addCriterion("regular_id <>", value, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdGreaterThan(Long value) {
            addCriterion("regular_id >", value, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdGreaterThanOrEqualTo(Long value) {
            addCriterion("regular_id >=", value, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdLessThan(Long value) {
            addCriterion("regular_id <", value, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdLessThanOrEqualTo(Long value) {
            addCriterion("regular_id <=", value, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdIn(List<Long> values) {
            addCriterion("regular_id in", values, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdNotIn(List<Long> values) {
            addCriterion("regular_id not in", values, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdBetween(Long value1, Long value2) {
            addCriterion("regular_id between", value1, value2, "regularId");
            return (Criteria) this;
        }

        public Criteria andRegularIdNotBetween(Long value1, Long value2) {
            addCriterion("regular_id not between", value1, value2, "regularId");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNull() {
            addCriterion("advice is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNotNull() {
            addCriterion("advice is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceEqualTo(String value) {
            addCriterion("advice =", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotEqualTo(String value) {
            addCriterion("advice <>", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThan(String value) {
            addCriterion("advice >", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("advice >=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThan(String value) {
            addCriterion("advice <", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThanOrEqualTo(String value) {
            addCriterion("advice <=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLike(String value) {
            addCriterion("advice like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotLike(String value) {
            addCriterion("advice not like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceIn(List<String> values) {
            addCriterion("advice in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotIn(List<String> values) {
            addCriterion("advice not in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceBetween(String value1, String value2) {
            addCriterion("advice between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotBetween(String value1, String value2) {
            addCriterion("advice not between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andDeficiencyIsNull() {
            addCriterion("deficiency is null");
            return (Criteria) this;
        }

        public Criteria andDeficiencyIsNotNull() {
            addCriterion("deficiency is not null");
            return (Criteria) this;
        }

        public Criteria andDeficiencyEqualTo(String value) {
            addCriterion("deficiency =", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyNotEqualTo(String value) {
            addCriterion("deficiency <>", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyGreaterThan(String value) {
            addCriterion("deficiency >", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyGreaterThanOrEqualTo(String value) {
            addCriterion("deficiency >=", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyLessThan(String value) {
            addCriterion("deficiency <", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyLessThanOrEqualTo(String value) {
            addCriterion("deficiency <=", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyLike(String value) {
            addCriterion("deficiency like", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyNotLike(String value) {
            addCriterion("deficiency not like", value, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyIn(List<String> values) {
            addCriterion("deficiency in", values, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyNotIn(List<String> values) {
            addCriterion("deficiency not in", values, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyBetween(String value1, String value2) {
            addCriterion("deficiency between", value1, value2, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDeficiencyNotBetween(String value1, String value2) {
            addCriterion("deficiency not between", value1, value2, "deficiency");
            return (Criteria) this;
        }

        public Criteria andDobetterIsNull() {
            addCriterion("dobetter is null");
            return (Criteria) this;
        }

        public Criteria andDobetterIsNotNull() {
            addCriterion("dobetter is not null");
            return (Criteria) this;
        }

        public Criteria andDobetterEqualTo(String value) {
            addCriterion("dobetter =", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterNotEqualTo(String value) {
            addCriterion("dobetter <>", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterGreaterThan(String value) {
            addCriterion("dobetter >", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterGreaterThanOrEqualTo(String value) {
            addCriterion("dobetter >=", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterLessThan(String value) {
            addCriterion("dobetter <", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterLessThanOrEqualTo(String value) {
            addCriterion("dobetter <=", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterLike(String value) {
            addCriterion("dobetter like", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterNotLike(String value) {
            addCriterion("dobetter not like", value, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterIn(List<String> values) {
            addCriterion("dobetter in", values, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterNotIn(List<String> values) {
            addCriterion("dobetter not in", values, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterBetween(String value1, String value2) {
            addCriterion("dobetter between", value1, value2, "dobetter");
            return (Criteria) this;
        }

        public Criteria andDobetterNotBetween(String value1, String value2) {
            addCriterion("dobetter not between", value1, value2, "dobetter");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(String value) {
            addCriterion("experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(String value) {
            addCriterion("experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(String value) {
            addCriterion("experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(String value) {
            addCriterion("experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(String value) {
            addCriterion("experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLike(String value) {
            addCriterion("experience like", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotLike(String value) {
            addCriterion("experience not like", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<String> values) {
            addCriterion("experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<String> values) {
            addCriterion("experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(String value1, String value2) {
            addCriterion("experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(String value1, String value2) {
            addCriterion("experience not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceIsNull() {
            addCriterion("personnel_advice is null");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceIsNotNull() {
            addCriterion("personnel_advice is not null");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceEqualTo(String value) {
            addCriterion("personnel_advice =", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotEqualTo(String value) {
            addCriterion("personnel_advice <>", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceGreaterThan(String value) {
            addCriterion("personnel_advice >", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("personnel_advice >=", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceLessThan(String value) {
            addCriterion("personnel_advice <", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceLessThanOrEqualTo(String value) {
            addCriterion("personnel_advice <=", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceLike(String value) {
            addCriterion("personnel_advice like", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotLike(String value) {
            addCriterion("personnel_advice not like", value, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceIn(List<String> values) {
            addCriterion("personnel_advice in", values, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotIn(List<String> values) {
            addCriterion("personnel_advice not in", values, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceBetween(String value1, String value2) {
            addCriterion("personnel_advice between", value1, value2, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPersonnelAdviceNotBetween(String value1, String value2) {
            addCriterion("personnel_advice not between", value1, value2, "personnelAdvice");
            return (Criteria) this;
        }

        public Criteria andPullulateIsNull() {
            addCriterion("pullulate is null");
            return (Criteria) this;
        }

        public Criteria andPullulateIsNotNull() {
            addCriterion("pullulate is not null");
            return (Criteria) this;
        }

        public Criteria andPullulateEqualTo(String value) {
            addCriterion("pullulate =", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateNotEqualTo(String value) {
            addCriterion("pullulate <>", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateGreaterThan(String value) {
            addCriterion("pullulate >", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateGreaterThanOrEqualTo(String value) {
            addCriterion("pullulate >=", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateLessThan(String value) {
            addCriterion("pullulate <", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateLessThanOrEqualTo(String value) {
            addCriterion("pullulate <=", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateLike(String value) {
            addCriterion("pullulate like", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateNotLike(String value) {
            addCriterion("pullulate not like", value, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateIn(List<String> values) {
            addCriterion("pullulate in", values, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateNotIn(List<String> values) {
            addCriterion("pullulate not in", values, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateBetween(String value1, String value2) {
            addCriterion("pullulate between", value1, value2, "pullulate");
            return (Criteria) this;
        }

        public Criteria andPullulateNotBetween(String value1, String value2) {
            addCriterion("pullulate not between", value1, value2, "pullulate");
            return (Criteria) this;
        }

        public Criteria andUnderstandIsNull() {
            addCriterion("understand is null");
            return (Criteria) this;
        }

        public Criteria andUnderstandIsNotNull() {
            addCriterion("understand is not null");
            return (Criteria) this;
        }

        public Criteria andUnderstandEqualTo(String value) {
            addCriterion("understand =", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandNotEqualTo(String value) {
            addCriterion("understand <>", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandGreaterThan(String value) {
            addCriterion("understand >", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandGreaterThanOrEqualTo(String value) {
            addCriterion("understand >=", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandLessThan(String value) {
            addCriterion("understand <", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandLessThanOrEqualTo(String value) {
            addCriterion("understand <=", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandLike(String value) {
            addCriterion("understand like", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandNotLike(String value) {
            addCriterion("understand not like", value, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandIn(List<String> values) {
            addCriterion("understand in", values, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandNotIn(List<String> values) {
            addCriterion("understand not in", values, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandBetween(String value1, String value2) {
            addCriterion("understand between", value1, value2, "understand");
            return (Criteria) this;
        }

        public Criteria andUnderstandNotBetween(String value1, String value2) {
            addCriterion("understand not between", value1, value2, "understand");
            return (Criteria) this;
        }

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Long value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Long value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Long value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Long value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Long> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Long> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Long value1, Long value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceIsNull() {
            addCriterion("manager_advice is null");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceIsNotNull() {
            addCriterion("manager_advice is not null");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceEqualTo(String value) {
            addCriterion("manager_advice =", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotEqualTo(String value) {
            addCriterion("manager_advice <>", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceGreaterThan(String value) {
            addCriterion("manager_advice >", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("manager_advice >=", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceLessThan(String value) {
            addCriterion("manager_advice <", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceLessThanOrEqualTo(String value) {
            addCriterion("manager_advice <=", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceLike(String value) {
            addCriterion("manager_advice like", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotLike(String value) {
            addCriterion("manager_advice not like", value, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceIn(List<String> values) {
            addCriterion("manager_advice in", values, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotIn(List<String> values) {
            addCriterion("manager_advice not in", values, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceBetween(String value1, String value2) {
            addCriterion("manager_advice between", value1, value2, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andManagerAdviceNotBetween(String value1, String value2) {
            addCriterion("manager_advice not between", value1, value2, "managerAdvice");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
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