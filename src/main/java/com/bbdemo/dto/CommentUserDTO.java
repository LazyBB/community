package com.bbdemo.dto;

import com.bbdemo.model.User;
import lombok.Data;

@Data
public class CommentUserDTO {
    private Long id;
    private Long parentId;
    private String comment;
    private Integer type;
    private Long commenter;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private User user;
    private Long commentCount;
}
