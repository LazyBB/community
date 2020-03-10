package com.bbdemo.dto;

import lombok.Data;

@Data
public class NoticeDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Integer type;
    private String typeName;
    private Long outerid;
}
