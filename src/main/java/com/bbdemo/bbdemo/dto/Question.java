package com.bbdemo.bbdemo.dto;

public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private long gmt_create;
    private long gmt_modified;
    private Integer creator;
    private Integer viewCout;
    private Integer likeCout;
    private Integer commentCout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public long getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getViewCout() {
        return viewCout;
    }

    public void setViewCout(Integer viewCout) {
        this.viewCout = viewCout;
    }

    public Integer getLikeCout() {
        return likeCout;
    }

    public void setLikeCout(Integer likeCout) {
        this.likeCout = likeCout;
    }

    public Integer getCommentCout() {
        return commentCout;
    }

    public void setCommentCout(Integer commentCout) {
        this.commentCout = commentCout;
    }
}
