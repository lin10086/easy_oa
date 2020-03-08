package cn.gson.oasys.modelV2.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileListPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileListPOExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Long value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Long value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Long value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Long value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Long value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Long> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Long> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Long value1, Long value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Long value1, Long value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileShuffixIsNull() {
            addCriterion("file_shuffix is null");
            return (Criteria) this;
        }

        public Criteria andFileShuffixIsNotNull() {
            addCriterion("file_shuffix is not null");
            return (Criteria) this;
        }

        public Criteria andFileShuffixEqualTo(String value) {
            addCriterion("file_shuffix =", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixNotEqualTo(String value) {
            addCriterion("file_shuffix <>", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixGreaterThan(String value) {
            addCriterion("file_shuffix >", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixGreaterThanOrEqualTo(String value) {
            addCriterion("file_shuffix >=", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixLessThan(String value) {
            addCriterion("file_shuffix <", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixLessThanOrEqualTo(String value) {
            addCriterion("file_shuffix <=", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixLike(String value) {
            addCriterion("file_shuffix like", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixNotLike(String value) {
            addCriterion("file_shuffix not like", value, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixIn(List<String> values) {
            addCriterion("file_shuffix in", values, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixNotIn(List<String> values) {
            addCriterion("file_shuffix not in", values, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixBetween(String value1, String value2) {
            addCriterion("file_shuffix between", value1, value2, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andFileShuffixNotBetween(String value1, String value2) {
            addCriterion("file_shuffix not between", value1, value2, "fileShuffix");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(String value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(String value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(String value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(String value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(String value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLike(String value) {
            addCriterion("content_type like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotLike(String value) {
            addCriterion("content_type not like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<String> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<String> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(String value1, String value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(String value1, String value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andPathIdIsNull() {
            addCriterion("path_id is null");
            return (Criteria) this;
        }

        public Criteria andPathIdIsNotNull() {
            addCriterion("path_id is not null");
            return (Criteria) this;
        }

        public Criteria andPathIdEqualTo(Long value) {
            addCriterion("path_id =", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdNotEqualTo(Long value) {
            addCriterion("path_id <>", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdGreaterThan(Long value) {
            addCriterion("path_id >", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdGreaterThanOrEqualTo(Long value) {
            addCriterion("path_id >=", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdLessThan(Long value) {
            addCriterion("path_id <", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdLessThanOrEqualTo(Long value) {
            addCriterion("path_id <=", value, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdIn(List<Long> values) {
            addCriterion("path_id in", values, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdNotIn(List<Long> values) {
            addCriterion("path_id not in", values, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdBetween(Long value1, Long value2) {
            addCriterion("path_id between", value1, value2, "pathId");
            return (Criteria) this;
        }

        public Criteria andPathIdNotBetween(Long value1, Long value2) {
            addCriterion("path_id not between", value1, value2, "pathId");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Long value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Long value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Long value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Long value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Long value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Long> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Long> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Long value1, Long value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Long value1, Long value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andFileUserIdIsNull() {
            addCriterion("file_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFileUserIdIsNotNull() {
            addCriterion("file_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileUserIdEqualTo(Long value) {
            addCriterion("file_user_id =", value, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdNotEqualTo(Long value) {
            addCriterion("file_user_id <>", value, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdGreaterThan(Long value) {
            addCriterion("file_user_id >", value, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("file_user_id >=", value, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdLessThan(Long value) {
            addCriterion("file_user_id <", value, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdLessThanOrEqualTo(Long value) {
            addCriterion("file_user_id <=", value, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdIn(List<Long> values) {
            addCriterion("file_user_id in", values, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdNotIn(List<Long> values) {
            addCriterion("file_user_id not in", values, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdBetween(Long value1, Long value2) {
            addCriterion("file_user_id between", value1, value2, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileUserIdNotBetween(Long value1, Long value2) {
            addCriterion("file_user_id not between", value1, value2, "fileUserId");
            return (Criteria) this;
        }

        public Criteria andFileIstrashIsNull() {
            addCriterion("file_istrash is null");
            return (Criteria) this;
        }

        public Criteria andFileIstrashIsNotNull() {
            addCriterion("file_istrash is not null");
            return (Criteria) this;
        }

        public Criteria andFileIstrashEqualTo(Long value) {
            addCriterion("file_istrash =", value, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashNotEqualTo(Long value) {
            addCriterion("file_istrash <>", value, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashGreaterThan(Long value) {
            addCriterion("file_istrash >", value, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashGreaterThanOrEqualTo(Long value) {
            addCriterion("file_istrash >=", value, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashLessThan(Long value) {
            addCriterion("file_istrash <", value, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashLessThanOrEqualTo(Long value) {
            addCriterion("file_istrash <=", value, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashIn(List<Long> values) {
            addCriterion("file_istrash in", values, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashNotIn(List<Long> values) {
            addCriterion("file_istrash not in", values, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashBetween(Long value1, Long value2) {
            addCriterion("file_istrash between", value1, value2, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIstrashNotBetween(Long value1, Long value2) {
            addCriterion("file_istrash not between", value1, value2, "fileIstrash");
            return (Criteria) this;
        }

        public Criteria andFileIsshareIsNull() {
            addCriterion("file_isshare is null");
            return (Criteria) this;
        }

        public Criteria andFileIsshareIsNotNull() {
            addCriterion("file_isshare is not null");
            return (Criteria) this;
        }

        public Criteria andFileIsshareEqualTo(Long value) {
            addCriterion("file_isshare =", value, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareNotEqualTo(Long value) {
            addCriterion("file_isshare <>", value, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareGreaterThan(Long value) {
            addCriterion("file_isshare >", value, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareGreaterThanOrEqualTo(Long value) {
            addCriterion("file_isshare >=", value, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareLessThan(Long value) {
            addCriterion("file_isshare <", value, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareLessThanOrEqualTo(Long value) {
            addCriterion("file_isshare <=", value, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareIn(List<Long> values) {
            addCriterion("file_isshare in", values, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareNotIn(List<Long> values) {
            addCriterion("file_isshare not in", values, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareBetween(Long value1, Long value2) {
            addCriterion("file_isshare between", value1, value2, "fileIsshare");
            return (Criteria) this;
        }

        public Criteria andFileIsshareNotBetween(Long value1, Long value2) {
            addCriterion("file_isshare not between", value1, value2, "fileIsshare");
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