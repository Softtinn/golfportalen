create database golf_db;

create user 'hibernate_user'@'%' identified by 'password';
create user 'hibernate_user'@'localhost' identified by 'password';

grant select, insert, delete, update on *.* to 'hibernate_user'@'%' identified by 'password';
grant select, insert, delete, update on *.* to 'hibernate_user'@'localhost' identified by 'password';

drop table if exists golf_db.test;

create table golf_db.test (
  id VARCHAR(100) NOT NULL,
  golf_id VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;