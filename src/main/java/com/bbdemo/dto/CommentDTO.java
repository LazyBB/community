package com.bbdemo.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private long parentId;
    private String comment;
    private Integer type;
}
