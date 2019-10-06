create schema sconferencedb collate utf8mb4_0900_ai_ci;

create table address
(
    id int auto_increment
        primary key,
    city char(30) not null,
    street char(50) not null,
    building char(10) not null,
    room char(5) not null
);

create table language
(
    id int auto_increment
        primary key,
    language char(3) null,
    constraint language
        unique (language)
);

create table positions
(
    id int auto_increment
        primary key,
    position char(50) null,
    constraint position
        unique (position)
);

create table users
(
    id int auto_increment
        primary key,
    name char(50) not null,
    surname char(50) not null,
    email char(100) not null,
    password char(50) not null,
    position int null,
    language int null,
    rating int null,
    bonuses int null,
    discriminator char(6) null,
    constraint users_ibfk_1
        foreign key (position) references positions (id)
            on update cascade on delete set null,
    constraint users_ibfk_2
        foreign key (language) references language (id)
            on update cascade on delete set null
);

create table reports
(
    id int auto_increment
        primary key,
    name char(255) not null,
    address_id int null,
    date date null,
    time time null,
    speaker_id int null,
    presence int default 0 null,
    constraint reports_ibfk_1
        foreign key (speaker_id) references users (id)
            on update cascade on delete set null,
    constraint reports_ibfk_2
        foreign key (address_id) references address (id)
            on update cascade on delete set null
);

create table registeredlist
(
    user_id int not null,
    report_id int not null,
    primary key (report_id, user_id),
    constraint registeredlist_ibfk_1
        foreign key (user_id) references users (id)
            on update cascade on delete cascade,
    constraint registeredlist_ibfk_2
        foreign key (report_id) references reports (id)
            on update cascade on delete cascade
);

create index user_id
    on registeredlist (user_id);

create index address_id
    on reports (address_id);

create index speaker_id
    on reports (speaker_id);

create index language
    on users (language);

create index position
    on users (position);

