alter table QUESTION alter column ID bigint auto_increment;

alter table QUESTION alter column CREATOR bigint;
alter table USER alter column ID bigint;
alter table COMMENT alter column COMMENTER bigint;
