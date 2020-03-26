package com.teach.edu.core.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyhomeworkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyhomeworkExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNull() {
            addCriterion("deleted_at is null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNotNull() {
            addCriterion("deleted_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtEqualTo(Date value) {
            addCriterion("deleted_at =", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotEqualTo(Date value) {
            addCriterion("deleted_at <>", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThan(Date value) {
            addCriterion("deleted_at >", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("deleted_at >=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThan(Date value) {
            addCriterion("deleted_at <", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThanOrEqualTo(Date value) {
            addCriterion("deleted_at <=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIn(List<Date> values) {
            addCriterion("deleted_at in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotIn(List<Date> values) {
            addCriterion("deleted_at not in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtBetween(Date value1, Date value2) {
            addCriterion("deleted_at between", value1, value2, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotBetween(Date value1, Date value2) {
            addCriterion("deleted_at not between", value1, value2, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdIsNull() {
            addCriterion("homework_id is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdIsNotNull() {
            addCriterion("homework_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdEqualTo(Long value) {
            addCriterion("homework_id =", value, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdNotEqualTo(Long value) {
            addCriterion("homework_id <>", value, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdGreaterThan(Long value) {
            addCriterion("homework_id >", value, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("homework_id >=", value, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdLessThan(Long value) {
            addCriterion("homework_id <", value, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdLessThanOrEqualTo(Long value) {
            addCriterion("homework_id <=", value, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdIn(List<Long> values) {
            addCriterion("homework_id in", values, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdNotIn(List<Long> values) {
            addCriterion("homework_id not in", values, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdBetween(Long value1, Long value2) {
            addCriterion("homework_id between", value1, value2, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkIdNotBetween(Long value1, Long value2) {
            addCriterion("homework_id not between", value1, value2, "homeworkId");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlIsNull() {
            addCriterion("homework_url is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlIsNotNull() {
            addCriterion("homework_url is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlEqualTo(Long value) {
            addCriterion("homework_url =", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlNotEqualTo(Long value) {
            addCriterion("homework_url <>", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlGreaterThan(Long value) {
            addCriterion("homework_url >", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlGreaterThanOrEqualTo(Long value) {
            addCriterion("homework_url >=", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlLessThan(Long value) {
            addCriterion("homework_url <", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlLessThanOrEqualTo(Long value) {
            addCriterion("homework_url <=", value, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlIn(List<Long> values) {
            addCriterion("homework_url in", values, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlNotIn(List<Long> values) {
            addCriterion("homework_url not in", values, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlBetween(Long value1, Long value2) {
            addCriterion("homework_url between", value1, value2, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkUrlNotBetween(Long value1, Long value2) {
            addCriterion("homework_url not between", value1, value2, "homeworkUrl");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescIsNull() {
            addCriterion("homework_desc is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescIsNotNull() {
            addCriterion("homework_desc is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescEqualTo(String value) {
            addCriterion("homework_desc =", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescNotEqualTo(String value) {
            addCriterion("homework_desc <>", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescGreaterThan(String value) {
            addCriterion("homework_desc >", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescGreaterThanOrEqualTo(String value) {
            addCriterion("homework_desc >=", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescLessThan(String value) {
            addCriterion("homework_desc <", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescLessThanOrEqualTo(String value) {
            addCriterion("homework_desc <=", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescLike(String value) {
            addCriterion("homework_desc like", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescNotLike(String value) {
            addCriterion("homework_desc not like", value, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescIn(List<String> values) {
            addCriterion("homework_desc in", values, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescNotIn(List<String> values) {
            addCriterion("homework_desc not in", values, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescBetween(String value1, String value2) {
            addCriterion("homework_desc between", value1, value2, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkDescNotBetween(String value1, String value2) {
            addCriterion("homework_desc not between", value1, value2, "homeworkDesc");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusIsNull() {
            addCriterion("homework_status is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusIsNotNull() {
            addCriterion("homework_status is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusEqualTo(String value) {
            addCriterion("homework_status =", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusNotEqualTo(String value) {
            addCriterion("homework_status <>", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusGreaterThan(String value) {
            addCriterion("homework_status >", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("homework_status >=", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusLessThan(String value) {
            addCriterion("homework_status <", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusLessThanOrEqualTo(String value) {
            addCriterion("homework_status <=", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusLike(String value) {
            addCriterion("homework_status like", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusNotLike(String value) {
            addCriterion("homework_status not like", value, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusIn(List<String> values) {
            addCriterion("homework_status in", values, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusNotIn(List<String> values) {
            addCriterion("homework_status not in", values, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusBetween(String value1, String value2) {
            addCriterion("homework_status between", value1, value2, "homeworkStatus");
            return (Criteria) this;
        }

        public Criteria andHomeworkStatusNotBetween(String value1, String value2) {
            addCriterion("homework_status not between", value1, value2, "homeworkStatus");
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