create database golf_db;

create user 'hibernate_user'@'%';
create user 'hibernate_user'@'localhost';

drop table if exists golf_db.test;

create table golf_db.test (
  id VARCHAR(100) NOT NULL,
  golf_id VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX golf_id_UNIQUE (golf_id))
ENGINE = InnoDB;