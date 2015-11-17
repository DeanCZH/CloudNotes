CREATE DATABASE IF NOT EXISTS db_cloudnotes CHARACTER  SET UTF8;
USE db_cloudnotes;

#用户信息表
CREATE TABLE IF NOT EXISTS tb_user(
user_id int(10) NOT NULL AUTO_INCREMENT,
user_name varchar(20) NOT NULL UNIQUE ,
user_password varchar(20) NOT NULL,
user_email varchar(50) NOT NULL UNIQUE ,
user_phone varchar(11) NOT NULL UNIQUE ,
user_createtime datetime DEFAULT NULL,
user_lastlogintime datetime NOT NULL ,
user_lastip varchar(15) NOT NULL,
PRIMARY key (user_id)
)ENGINE=InnoDB DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#NOTE
CREATE TABLE IF NOT EXISTS tb_note(
note_id int(10) NOT NULL AUTO_INCREMENT,
note_userid int(10) NOT NULL,
note_title varchar(200) NOT NULL,
note_content TEXT NOT NULL,
note_createtime DATETIME NOT NULL,
note_updatetime DATETIME NOT NULL,
PRIMARY key (note_id)
)ENGINE=InnoDB DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#UPLOAD
CREATE TABLE IF NOT EXISTS tb_upload(
upload_id int(10) NOT NULL AUTO_INCREMENT,
upload_userid int(10) NOT NULL,
upload_urilist varchar(200) NOT NULL,
upload_createtime DATETIME NOT NULL,
PRIMARY key (upload_id)
)ENGINE=InnoDB DEFAULT CHARSET utf8 COLLATE utf8_general_ci;