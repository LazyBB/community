package com.bbdemo.enums;

public enum NoticeStatusEnum {
    UNREAD(0),READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NoticeStatusEnum(int status) {
        this.status = status;
    }
}
