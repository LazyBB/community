create table COMMENT
(
    ID            BIGINT auto_increment,
    PARENT_ID     BIGINT not null,
    COMMENT       VARCHAR(1024),
    TYPE          INT    not null,
    COMMENTER     BIGINT not null,
    GMT_CREATE    BIGINT,
    GMT_MODIFIED  BIGINT,
    LIKE_COUNT    BIGINT default 0,
    COMMENT_COUNT BIGINT default 0,
    constraint COMMENT_PK
        primary key (ID)
);

