package com.lh.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andResoureIdIsNull() {
            addCriterion("resoure_id is null");
            return (Criteria) this;
        }

        public Criteria andResoureIdIsNotNull() {
            addCriterion("resoure_id is not null");
            return (Criteria) this;
        }

        public Criteria andResoureIdEqualTo(Integer value) {
            addCriterion("resoure_id =", value, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdNotEqualTo(Integer value) {
            addCriterion("resoure_id <>", value, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdGreaterThan(Integer value) {
            addCriterion("resoure_id >", value, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resoure_id >=", value, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdLessThan(Integer value) {
            addCriterion("resoure_id <", value, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdLessThanOrEqualTo(Integer value) {
            addCriterion("resoure_id <=", value, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdIn(List<Integer> values) {
            addCriterion("resoure_id in", values, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdNotIn(List<Integer> values) {
            addCriterion("resoure_id not in", values, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdBetween(Integer value1, Integer value2) {
            addCriterion("resoure_id between", value1, value2, "resoureId");
            return (Criteria) this;
        }

        public Criteria andResoureIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resoure_id not between", value1, value2, "resoureId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andResoureUrlIsNull() {
            addCriterion("resoure_url is null");
            return (Criteria) this;
        }

        public Criteria andResoureUrlIsNotNull() {
            addCriterion("resoure_url is not null");
            return (Criteria) this;
        }

        public Criteria andResoureUrlEqualTo(String value) {
            addCriterion("resoure_url =", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlNotEqualTo(String value) {
            addCriterion("resoure_url <>", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlGreaterThan(String value) {
            addCriterion("resoure_url >", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("resoure_url >=", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlLessThan(String value) {
            addCriterion("resoure_url <", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlLessThanOrEqualTo(String value) {
            addCriterion("resoure_url <=", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlLike(String value) {
            addCriterion("resoure_url like", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlNotLike(String value) {
            addCriterion("resoure_url not like", value, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlIn(List<String> values) {
            addCriterion("resoure_url in", values, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlNotIn(List<String> values) {
            addCriterion("resoure_url not in", values, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlBetween(String value1, String value2) {
            addCriterion("resoure_url between", value1, value2, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResoureUrlNotBetween(String value1, String value2) {
            addCriterion("resoure_url not between", value1, value2, "resoureUrl");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("resource_type is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(Integer value) {
            addCriterion("resource_type =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(Integer value) {
            addCriterion("resource_type <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(Integer value) {
            addCriterion("resource_type >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_type >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(Integer value) {
            addCriterion("resource_type <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("resource_type <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<Integer> values) {
            addCriterion("resource_type in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<Integer> values) {
            addCriterion("resource_type not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("resource_type between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_type not between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdIsNull() {
            addCriterion("resource_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdIsNotNull() {
            addCriterion("resource_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdEqualTo(Integer value) {
            addCriterion("resource_parent_id =", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdNotEqualTo(Integer value) {
            addCriterion("resource_parent_id <>", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdGreaterThan(Integer value) {
            addCriterion("resource_parent_id >", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_parent_id >=", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdLessThan(Integer value) {
            addCriterion("resource_parent_id <", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("resource_parent_id <=", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdIn(List<Integer> values) {
            addCriterion("resource_parent_id in", values, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdNotIn(List<Integer> values) {
            addCriterion("resource_parent_id not in", values, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdBetween(Integer value1, Integer value2) {
            addCriterion("resource_parent_id between", value1, value2, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_parent_id not between", value1, value2, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceSortIsNull() {
            addCriterion("resource_sort is null");
            return (Criteria) this;
        }

        public Criteria andResourceSortIsNotNull() {
            addCriterion("resource_sort is not null");
            return (Criteria) this;
        }

        public Criteria andResourceSortEqualTo(Integer value) {
            addCriterion("resource_sort =", value, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortNotEqualTo(Integer value) {
            addCriterion("resource_sort <>", value, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortGreaterThan(Integer value) {
            addCriterion("resource_sort >", value, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_sort >=", value, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortLessThan(Integer value) {
            addCriterion("resource_sort <", value, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortLessThanOrEqualTo(Integer value) {
            addCriterion("resource_sort <=", value, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortIn(List<Integer> values) {
            addCriterion("resource_sort in", values, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortNotIn(List<Integer> values) {
            addCriterion("resource_sort not in", values, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortBetween(Integer value1, Integer value2) {
            addCriterion("resource_sort between", value1, value2, "resourceSort");
            return (Criteria) this;
        }

        public Criteria andResourceSortNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_sort not between", value1, value2, "resourceSort");
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