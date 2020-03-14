package com.bbdemo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2002,"问题不存在，换个试试？"),
    TARGET_NOT_FOUND(2003,"评论或问题未选中，换个试试？"),
    NO_LOGIN(100,"尚未登录"),
    SYS_ERROR(1001,"服务器异常，请稍后再试"),
    TYPE_NOT_FOUND(2004,"评论类型未选定或错误"),
    COMMENT_NOT_FOUND(2005,"评论不存在，换个试试"),
    COMMENT_IS_EMPTY(2006,"评论不能为空"),
    IMAGE_UPLOAD_FALSE(2007,"图片上传失败");
    private String message;
    private Integer code;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code,String message) {
        this.code=code;
        this.message = message;
    }
}
