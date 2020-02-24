create table comment
(
	id bigint auto_increment,
	parent_id bigint not null,
	comment varchar(1024),
	type int not null,
	commenter int not null,
	gmt_create bigint,
	gmt_modified bigint,
	like_count bigint default 0,
	constraint comment_pk
		primary key (id)
);

