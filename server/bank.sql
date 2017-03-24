create table user (
username varchar(255) not null,
email varchar(255) not null,
phone varchar(30) not null,
password varchar(255) not null,
primary key(email)
);

create table room (
id int(5) not null auto_increment,
roomname varchar(255) not null,
roominfo varchar(255) not null,
name varchar(255) not null,
birth varchar(30) not null,
bank varchar(30) not null,
account varchar(30) not null,
primary key(id)
);

create table member (
id int(5) not null,
email varchar(255) not null
);

create table total (
id int(5) not null,
money int(5) not null
);

create table trans (
id int(5) not null,
date varchar(30) not null,
info varchar(30) not null,
money varchar(30) not null
);						
