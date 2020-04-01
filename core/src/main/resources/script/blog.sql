create user 'teach'@'%' identified by 'teaching';
create  database teach;
grant all on *.* to 'teach'@'%';
--sudo vi /etc/mysql/mysql.conf.d/mysqld.cnf
create table oms_user
(
    id    bigint not null primary key,
    name      varchar(200)   not null,
    email     varchar(200),
    password  varchar(200),
    image_url varchar(200)   not null,
    nick_name varchar(200),
    address   varchar(200),
    mobile    varchar(11),
    wx_id     varchar(200),
    qq_id     varchar(200),
    sex       integer,
    birthday  date,
    crt       date,
    lut       date
);

create table wx_user
(
    id        bigint not null  primary key,
    user_name  varchar(200),
    password   varchar(200),
    email      varchar(200),
    mobile     varchar(200),
    student_id varchar(200),
    open_id    varchar(200),
    avatar_url varchar(200),
    nick_name  varchar(200),
    updated_at timestamp null,
    created_at timestamp null,
    deleted_at timestamp null,
    class_name varchar(200),
    code       varchar(200),
    contry     varchar(200)
);


create table notes
(
    id         bigint not null  primary key,
    updated_at timestamp null,
    created_at timestamp null,
    deleted_at timestamp null,
    title       varchar(255),
    notes       varchar(255),
    book_name   varchar(255),
    book_author varchar(255),
    notes_desc  varchar(255),
    user_id     bigint
);


create table homework
(
    id   bigint     not null primary key,
    updated_at timestamp null,
    created_at timestamp null,
    deleted_at timestamp null,
    title       varchar(200),
    content     varchar(200),
    class_name  varchar(200),
    teach_name  varchar(200),
    course_name varchar(200)
);



create table myhomework
(
    id              bigint not null

        primary key,
    updated_at     timestamp null,
    created_at     timestamp null,
    deleted_at     timestamp null,
    homework_id     bigint,
    homework_url    varchar(200),
    homework_desc   varchar(200),
    homework_status varchar(200),
    user_id         bigint,
    user_name       varchar(200),
    class_name      varchar(200)
);


create table grade
(
    id     bigint not null  primary key,
    updated_at  timestamp null,
    created_at  timestamp null,
    deleted_at  timestamp null,
    student_id   bigint,
    course_name  varchar(200),
    course_grade integer,
    teach_name   varchar(200),
    grades       double precision,
    test_scores  double precision,
    show_grades  double precision,
    signin       double precision,
    class_name   varchar(200)
);



create table materials
(
    id  bigint    not null primary key,
    updated_at    timestamp null,
    created_at    timestamp null,
    deleted_at    timestamp null,
    materials_url  varchar(200),
    materials_desc varchar(200),
    category       varchar(200),
    course_name    varchar(200)
);

create table errormessage
(
    id     bigint   not null primary key,
    updated_at  timestamp null,
    created_at timestamp null,
    deleted_at timestamp null,
    content     varchar(200)
);


create table remind
(
    id     bigint    not null  primary key,
    updated_at timestamp null,
    created_at timestamp null,
    deleted_at timestamp null,
    title      varchar(200),
    reminddesc varchar(200),
    content    varchar(200),
    status     varchar(200),
    user_id    bigint
);


create table signin
(
    id        bigint not null primary key,
    updated_at  timestamp null,
    created_at  timestamp null,
    deleted_at  timestamp null,
    class_name   varchar(200),
    student_id   bigint,
    start_signin timestamp null,
    end_signin  timestamp null,
    teach_name   varchar(200),
    crouse_name  varchar(200)
);


