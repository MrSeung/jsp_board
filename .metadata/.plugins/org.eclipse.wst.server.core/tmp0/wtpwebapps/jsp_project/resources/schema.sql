
use mysql

create user 'jspuser'@'localhost' identified by 'mysql';
grant all privileges on jspdb.* to 'jspuser'@'localhost' with grant option;
flush privileges;

create database jspdb;

create table member(
Id varchar(100) not null,
Password varchar(100) not null,
Email varchar(100) not null,
Age int not null,
Reg_date datetime default now(),
Last_login datetime default null,
primary key(id));

create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(100) not null,
content text,
reg_date datetime default now(),
primary key(bno)
);
-- 조회수
alter table board add readcount int default 0;
-- 이미지 파일 업로드
alter table board add image_file text;

create table reply(
rno int not null auto_increment,
user_id varchar(100) not null,
board_bno int not null,
content text,
reg_date datetime default now(),
primary key(rno)
);
