CREATE DATABASE IF NOT EXISTS db_cloudnotes CHARACTER  SET UTF8;
USE db_cloudnotes;

#用户信息表
CREATE TABLE IF NOT EXISTS tb_user(
user_id INT(10) NOT NULL AUTO_INCREMENT,
user_name VARCHAR(20) NOT NULL UNIQUE ,
user_password VARCHAR(20) NOT NULL,
user_email VARCHAR(50) NOT NULL,
user_phone VARCHAR (20),
user_createtime DATETIME ,
user_lastlogintime TIMESTAMP,
PRIMARY key (user_id)
)ENGINE=InnoDB DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#NOTE
CREATE TABLE IF NOT EXISTS tb_note(
note_id int(10) NOT NULL AUTO_INCREMENT,
note_userid int(10) NOT NULL,
note_bookid int(10) NOT NULL,
note_title varchar(200) NOT NULL,
note_content TEXT NOT NULL,
note_createtime DATETIME NOT NULL,
note_updatetime DATETIME NOT NULL,
PRIMARY key (note_id)
)ENGINE=InnoDB DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#BOOK
CREATE TABLE IF NOT EXISTS tb_book(
book_id int(10) NOT NULL AUTO_INCREMENT,
book_userid int(10) NOT NULL,
book_title varchar(200) NOT NULL,
book_desc varchar(2000) NOT NULL,
book_notenum int(10) NOT NULL DEFAULT '0' COMMENT '笔记总数',
note_createtime DATETIME NOT NULL,
PRIMARY key (book_id)
)ENGINE=InnoDB DEFAULT CHARSET utf8 COLLATE utf8_general_ci;