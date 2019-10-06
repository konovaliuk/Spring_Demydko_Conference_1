drop database if exists SConferenceDb;
create database SConferenceDb;
use SConferenceDb;

create table address
(
	id int auto_increment primary key,
	city char(30) not null,
	street char(50) not null,
	building char(10) not null,
	room char(5) not null
);

create table positions
(
	id int auto_increment primary key,
	position char(50) unique
);

create table language
(
	id int auto_increment primary key,
	 language char(3) unique
);


create table users
(
	id int auto_increment primary key,
	name char(50) not null,
	surname char(50) not null,
	email char(100) not null,
    password char(50) not null,
	position int,
    language int,
    rating int default null,
    bonuses int default null,
    discriminator char(6),
	foreign key (position) references positions (id)
		on update cascade on delete set null,
	foreign key (language) references language (id)
		on update cascade on delete set null
);



create table reports
(
	id int auto_increment primary key,
	name char(255) not null,
	address_id int default null,
	date date null,
    time time null,
	speaker_id int default null,
    presence int default 0,
	foreign key (speaker_id) references users (id)
		on update cascade on delete set null,
	foreign key (address_id) references address (id)
   	on update cascade  on delete set null
);


create table registeredlist
(
     user_id int not null,
	report_id int not null,
    foreign key (user_id) references users (id)
			on update cascade on delete cascade,
    foreign key (report_id) references reports (id)
		on update cascade on delete cascade,
    primary key(report_id, user_id)
	);


