drop table if exists user;

create table user (
  id identity,
  firstName varchar(25) not null,
  lastName varchar(25) not null,
  age INTEGER not null,
  birthDate DATETIME NOT NULL
);