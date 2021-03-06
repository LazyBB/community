package com.bbdemo.dto;

import com.bbdemo.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private long id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private long creator;
    private Integer viewCout;
    private Integer likeCout;
    private Integer commentCout;
    private String avatarUrl;
    private User user;
}
