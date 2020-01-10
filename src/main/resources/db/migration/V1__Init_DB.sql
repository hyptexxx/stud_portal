
create table if not exists list_category
(
	id_category int auto_increment
		primary key,
	category varchar(86) not null,
	description varchar(128) null
);

create table if not exists list_kafedr
(
	id_kafedr int auto_increment
		primary key,
	name varchar(256) not null
);

create table if not exists napr_podg
(
	id_napr int auto_increment
		primary key,
	name varchar(256) not null,
	id_kaf int not null,
	constraint napr_podg_list_kafedr_id_kafedr_fk
		foreign key (id_kaf) references list_kafedr (id_kafedr)
			on update cascade on delete cascade
);

create table if not exists teachers
(
	id_teacher int auto_increment
		primary key,
	id_n int not null,
	fio varchar(128) null,
	constraint teachers_napr_podg_id_napr_fk
		foreign key (id_n) references napr_podg (id_napr)
			on update cascade on delete cascade
);

create table if not exists users
(
	user_id int auto_increment
		primary key,
	fio varchar(256) not null,
	id_napr int not null,
	id_category int null,
	constraint users_list_category_id_category_fk
		foreign key (id_category) references list_category (id_category)
			on update cascade on delete cascade,
	constraint users_napr_podg_id_napr_fk
		foreign key (id_napr) references napr_podg (id_napr)
			on update cascade on delete cascade
);

create table if not exists science_publication
(
	id_science_publication int auto_increment
		primary key,
	name varchar(128) not null,
	text varchar(2048) not null,
	user_id int null,
	teacher_id int null,
	constraint science_publication_teachers_id_teacher_fk
		foreign key (teacher_id) references teachers (id_teacher)
			on update cascade on delete cascade,
	constraint science_publication_users_user_id_fk
		foreign key (user_id) references users (user_id)
			on update cascade on delete cascade
);

create table if not exists vkr
(
	id_vkr int auto_increment
		primary key,
	date_def datetime null,
	user_id int not null,
	id_teacher int null,
	constraint vkr_teachers_id_teacher_fk
		foreign key (id_teacher) references teachers (id_teacher)
			on update cascade on delete cascade,
	constraint vkr_users_user_id_fk
		foreign key (user_id) references users (user_id)
			on update cascade on delete cascade
);

