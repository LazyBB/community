create table question
(
	id int auto_increment,
	title varchar(50),
	description text,
	gmt_create bigint,
	gmt_modified bigint,
	creator int,
	comment_cout int default 0,
	view_cout int default 0,
	like_cout int default 0,
	tag varchar(256),
	constraint question_pk
		primary key (id)
);

