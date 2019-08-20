package com.lh.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MajorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MajorExample() {
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

        public Criteria andMajorIdIsNull() {
            addCriterion("major_id is null");
            return (Criteria) this;
        }

        public Criteria andMajorIdIsNotNull() {
            addCriterion("major_id is not null");
            return (Criteria) this;
        }

        public Criteria andMajorIdEqualTo(Integer value) {
            addCriterion("major_id =", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotEqualTo(Integer value) {
            addCriterion("major_id <>", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThan(Integer value) {
            addCriterion("major_id >", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_id >=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThan(Integer value) {
            addCriterion("major_id <", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThanOrEqualTo(Integer value) {
            addCriterion("major_id <=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdIn(List<Integer> values) {
            addCriterion("major_id in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotIn(List<Integer> values) {
            addCriterion("major_id not in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdBetween(Integer value1, Integer value2) {
            addCriterion("major_id between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("major_id not between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNull() {
            addCriterion("major_name is null");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNotNull() {
            addCriterion("major_name is not null");
            return (Criteria) this;
        }

        public Criteria andMajorNameEqualTo(String value) {
            addCriterion("major_name =", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotEqualTo(String value) {
            addCriterion("major_name <>", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThan(String value) {
            addCriterion("major_name >", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThanOrEqualTo(String value) {
            addCriterion("major_name >=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThan(String value) {
            addCriterion("major_name <", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThanOrEqualTo(String value) {
            addCriterion("major_name <=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLike(String value) {
            addCriterion("major_name like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotLike(String value) {
            addCriterion("major_name not like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameIn(List<String> values) {
            addCriterion("major_name in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotIn(List<String> values) {
            addCriterion("major_name not in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameBetween(String value1, String value2) {
            addCriterion("major_name between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotBetween(String value1, String value2) {
            addCriterion("major_name not between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorCodeIsNull() {
            addCriterion("major_code is null");
            return (Criteria) this;
        }

        public Criteria andMajorCodeIsNotNull() {
            addCriterion("major_code is not null");
            return (Criteria) this;
        }

        public Criteria andMajorCodeEqualTo(String value) {
            addCriterion("major_code =", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotEqualTo(String value) {
            addCriterion("major_code <>", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeGreaterThan(String value) {
            addCriterion("major_code >", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("major_code >=", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeLessThan(String value) {
            addCriterion("major_code <", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeLessThanOrEqualTo(String value) {
            addCriterion("major_code <=", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeLike(String value) {
            addCriterion("major_code like", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotLike(String value) {
            addCriterion("major_code not like", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeIn(List<String> values) {
            addCriterion("major_code in", values, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotIn(List<String> values) {
            addCriterion("major_code not in", values, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeBetween(String value1, String value2) {
            addCriterion("major_code between", value1, value2, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotBetween(String value1, String value2) {
            addCriterion("major_code not between", value1, value2, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorYearIsNull() {
            addCriterion("major_year is null");
            return (Criteria) this;
        }

        public Criteria andMajorYearIsNotNull() {
            addCriterion("major_year is not null");
            return (Criteria) this;
        }

        public Criteria andMajorYearEqualTo(Integer value) {
            addCriterion("major_year =", value, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearNotEqualTo(Integer value) {
            addCriterion("major_year <>", value, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearGreaterThan(Integer value) {
            addCriterion("major_year >", value, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_year >=", value, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearLessThan(Integer value) {
            addCriterion("major_year <", value, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearLessThanOrEqualTo(Integer value) {
            addCriterion("major_year <=", value, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearIn(List<Integer> values) {
            addCriterion("major_year in", values, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearNotIn(List<Integer> values) {
            addCriterion("major_year not in", values, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearBetween(Integer value1, Integer value2) {
            addCriterion("major_year between", value1, value2, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorYearNotBetween(Integer value1, Integer value2) {
            addCriterion("major_year not between", value1, value2, "majorYear");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyIsNull() {
            addCriterion("major_money is null");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyIsNotNull() {
            addCriterion("major_money is not null");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyEqualTo(Integer value) {
            addCriterion("major_money =", value, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyNotEqualTo(Integer value) {
            addCriterion("major_money <>", value, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyGreaterThan(Integer value) {
            addCriterion("major_money >", value, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_money >=", value, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyLessThan(Integer value) {
            addCriterion("major_money <", value, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("major_money <=", value, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyIn(List<Integer> values) {
            addCriterion("major_money in", values, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyNotIn(List<Integer> values) {
            addCriterion("major_money not in", values, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyBetween(Integer value1, Integer value2) {
            addCriterion("major_money between", value1, value2, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andMajorMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("major_money not between", value1, value2, "majorMoney");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andSelectTimeIsNull() {
            addCriterion("select_time is null");
            return (Criteria) this;
        }

        public Criteria andSelectTimeIsNotNull() {
            addCriterion("select_time is not null");
            return (Criteria) this;
        }

        public Criteria andSelectTimeEqualTo(Date value) {
            addCriterion("select_time =", value, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeNotEqualTo(Date value) {
            addCriterion("select_time <>", value, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeGreaterThan(Date value) {
            addCriterion("select_time >", value, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("select_time >=", value, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeLessThan(Date value) {
            addCriterion("select_time <", value, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeLessThanOrEqualTo(Date value) {
            addCriterion("select_time <=", value, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeIn(List<Date> values) {
            addCriterion("select_time in", values, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeNotIn(List<Date> values) {
            addCriterion("select_time not in", values, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeBetween(Date value1, Date value2) {
            addCriterion("select_time between", value1, value2, "selectTime");
            return (Criteria) this;
        }

        public Criteria andSelectTimeNotBetween(Date value1, Date value2) {
            addCriterion("select_time not between", value1, value2, "selectTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
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