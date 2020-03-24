-- ----------------------------
-- Table structure for user
-- ----------------------------


create user teach with password 'teaching';
create database teachDb owner teach;
grant all privileges on database teachDb to teach;
create table if not exists "user"
(
    id        bigint  not null
        constraint user_pkey
            primary key,
    name      varchar not null,
    email     varchar,
    passwrod  varchar,
    image_url varchar not null,
    nick_name varchar,
    address   varchar,
    mobile    varchar(11),
    wx_id     varchar,
    qq_id     varchar,
    sex       integer,
    birthday  date,
    crt       date,
    lut       date
)
;
--//@formatter:off
comment on table "user" is '用户表';
comment on column "user".id is '主键ｉｄ';
comment on column "user".name is '用户名';
comment on column "user".email is '邮箱';
comment on column "user".passwrod is '密码';
comment on column "user".image_url is '头像';
comment on column "user".nick_name is '昵称';
comment on column "user".address is '地址';
comment on column "user".mobile is '电话';
comment on column "user".wx_id is '微信ｉｄ';
comment on column "user".qq_id is 'qqID';
comment on column "user".sex is 'X性别';
comment on column "user".birthday is '出生日期';
comment on column "user".crt is '创建时间';
comment on column "user".lut is '更新时间';

alter table "user"
    owner to teach;

--微信用户
create table if not exists wx_user
(
    id         bigint not null
        constraint wx_user_pkey primary key,
    user_name  varchar(200),
    password   varchar(200),
    email      varchar(200),
    mobile     varchar(200),
    student_id varchar(200),
    open_id    varchar(200),
    avatar_url varchar(200),
    nick_name  varchar,
    updated_at timestamp,
    created_at timestamp,
    deleted_at timestamp,
    calss_name varchar


);
alter table "wx_user"
    owner to teach;
--笔记
create table if not exists notes
(
    id          bigint       not null
        primary key,
    updated_at  timestamp,
    created_at  timestamp,
    deleted_at  timestamp,
    title       varchar(255) null, --标题
    notes       varchar(255) null, --内容
    book_name   varchar(255) null, --书名
    book_author varchar(255) null, --作者
    notes_desc  varchar(255) null, --简述
    user_id     bigint             --所属人
);
alter table "notes"
    owner to teach;
---签到表
create table if not exists signin
(
    id           bigint    not null primary key,
    updated_at   timestamp,
    created_at   timestamp,
    deleted_at   timestamp,
    class_name   varchar   null, --班级
    student_id   bigint,         -- 所属人
    start_signin timestamp null, --上课签到时间
    end_signin   timestamp null, --下课签退时间
    teach_name   varchar   null, --教师名
    course_name  varchar         --课程
);
alter table "signin"
    owner to teach;
--作业表
create table if not exists homework
(
    id          bigint    not null primary key,
    updated_at  timestamp null,
    created_at  timestamp null,
    deleted_at  timestamp null,
    title       varchar   null,
    content     varchar   null,
    class_name  varchar   null, --班级
    teach_name  varchar,        --教师名称
    course_name varchar         --课程

);
alter table "homework"
    owner to teach;
--我的作业
create table if not exists myhomework
(
    id              bigint    not null primary key,
    updated_at      timestamp null,
    created_at      timestamp null,
    deleted_at      timestamp null,
    homework_id     bigint,  --作业iD
    homework_url    bigint,  --作业地址
    homework_desc   varchar, -- 作业描述
    homework_status varchar  --作业状态 0 未审核，1审核通过，2 审核不通过

);
alter table "myhomework"
    owner to teach;
--成绩表
create table if not exists grade
(
    id           bigint    not null primary key,
    updated_at   timestamp null,
    created_at   timestamp null,
    deleted_at   timestamp null,
    student_id   bigint,  --学生id
    course_name  varchar, --课程名
    course_grade integer, --总成绩
    teach_name   varchar, --教师姓名
    grades       integer, --平时成绩
    test_scores  integer  --考试成绩

);
alter table "grade"
    owner to teach;
--学习资料
create table if not exists materials
(
    id             bigint    not null primary key,
    updated_at     timestamp null,
    created_at     timestamp null,
    deleted_at     timestamp null,
    materials_url  varchar   null, --资料url
    materials_desc varchar   null, --资料描述
    category       varchar   null, --类别
    course_name    varchar         --课程
);
alter table "materials"
    owner to teach;
--日常错误信息
create table if not exists errormessage
(
    id         bigint    not null primary key,
    updated_at timestamp null,
    created_at timestamp null,
    deleted_at timestamp null,
    content    varchar   null --错误内容
);
alter table "errormessage"
    owner to teach;


create table if not exists remind
(
    id         bigint    not null primary key,
    updated_at timestamp null,
    created_at timestamp null,
    deleted_at timestamp null,
    title      varchar   null, --标题
    remindDesc varchar,        --简述
    content    varchar,        --内容
    status     varchar         -- 待复习
);
alter table "remind"
    owner to teach;
