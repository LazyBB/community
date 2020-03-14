create table QUESTION
(
    ID           BIGINT auto_increment,
    TITLE        VARCHAR(50),
    DESCRIPTION  TEXT,
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    CREATOR      BIGINT,
    COMMENT_COUT INT default 0,
    VIEW_COUT    INT default 0,
    LIKE_COUT    INT default 0,
    TAG          VARCHAR(256),
    constraint QUESTION_PK
        primary key (ID)
);
