package com.bbdemo.bbdemo.dto;

import com.bbdemo.bbdemo.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
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
    private User user;
}
