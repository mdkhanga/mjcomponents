

create table if not exists users (
    username  varchar(20) primary key ,
    password  varchar(10),
    email     varchar(30)
) ;

create table if not exists accounts  (
    username  varchar(20),
    accountname varchar(20) primary key,
    type varchar(8),
    balance float,
    updated timestamp,
    FOREIGN KEY (username) REFERENCES users(username)
) ;

create table if not exists transaction  (
    username  varchar(20),
    accountname varchar(20),
    amount float,
    operation int,
    updated timestamp
) ;

create table if not exists accountupdatehistory  (
    username  varchar(20),
    accountname varchar(20),
    oldbalance float,
    newbalance float,
    updated timestamp
) ;