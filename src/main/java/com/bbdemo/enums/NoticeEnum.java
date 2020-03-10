package com.bbdemo.enums;

public enum NoticeEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论"),
    ;
    private int type;
    private String name;

    public static String nameOfType(int type) {
        for (NoticeEnum noticeEnum : NoticeEnum.values()) {
            if (noticeEnum.getType() == type) {
                return noticeEnum.getName();
            }
        }
        return "";
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NoticeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
