create table NOTICE
(
    ID            BIGINT auto_increment,
    NOTIFIER      BIGINT not null,
    RECEIVER      BIGINT not null,
    OUTERID       BIGINT not null,
    TYPE          INT    not null,
    GMT_CREATE    BIGINT not null,
    STATUS        INT default 0,
    NOTIFIER_NAME VARCHAR(100),
    OUTER_TITLE   VARCHAR(100),
    constraint NOTICE_PK
        primary key (ID)
);