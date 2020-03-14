package com.bbdemo.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.ID
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.PARENT_ID
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.COMMENT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.TYPE
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.COMMENTER
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Long commenter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.GMT_CREATE
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.GMT_MODIFIED
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.LIKE_COUNT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Long likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.COMMENT_COUNT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    private Long commentCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.ID
     *
     * @return the value of COMMENT.ID
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.ID
     *
     * @param id the value for COMMENT.ID
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.PARENT_ID
     *
     * @return the value of COMMENT.PARENT_ID
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.PARENT_ID
     *
     * @param parentId the value for COMMENT.PARENT_ID
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.COMMENT
     *
     * @return the value of COMMENT.COMMENT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.COMMENT
     *
     * @param comment the value for COMMENT.COMMENT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.TYPE
     *
     * @return the value of COMMENT.TYPE
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.TYPE
     *
     * @param type the value for COMMENT.TYPE
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.COMMENTER
     *
     * @return the value of COMMENT.COMMENTER
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Long getCommenter() {
        return commenter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.COMMENTER
     *
     * @param commenter the value for COMMENT.COMMENTER
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setCommenter(Long commenter) {
        this.commenter = commenter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.GMT_CREATE
     *
     * @return the value of COMMENT.GMT_CREATE
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.GMT_CREATE
     *
     * @param gmtCreate the value for COMMENT.GMT_CREATE
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.GMT_MODIFIED
     *
     * @return the value of COMMENT.GMT_MODIFIED
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.GMT_MODIFIED
     *
     * @param gmtModified the value for COMMENT.GMT_MODIFIED
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.LIKE_COUNT
     *
     * @return the value of COMMENT.LIKE_COUNT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Long getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.LIKE_COUNT
     *
     * @param likeCount the value for COMMENT.LIKE_COUNT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.COMMENT_COUNT
     *
     * @return the value of COMMENT.COMMENT_COUNT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.COMMENT_COUNT
     *
     * @param commentCount the value for COMMENT.COMMENT_COUNT
     *
     * @mbg.generated Sat Mar 14 18:19:27 CST 2020
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
}