package com.bbdemo.bbdemo.model;

import lombok.Data;

@Data
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
    private String avatarUrl;
}
