create schema qls;
create database QLS;
use QLS;

create table BookInfo(
   BookName varchar(255),
   BookID int not null,
   Author varchar(255),
   BookType varchar(255),
   Publisher varchar(255),
   Quantity int
) engine = InnoDB;

create table Selling(
	Num int,
    BookID int,
    Price int,
    Quantity int,
    Dates datetime
) ENGINE = InnoDB;

create table Revenue(
	Revenue float,
    Expense float
) engine = InnoDB;

select * from BookInfo;
drop table bookinfo;
drop table Selling;