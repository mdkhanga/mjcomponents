

create table if not exists users (
    username  varchar(20) primary key ,
    password  varchar(10),
    email     varchar(30)
) ;

create table if not exists accounts  (
    username  varchar(20),
    accountname varchar(20),
    id SERIAL PRIMARY KEY,
    type varchar(8),
    subtype varchar(10),
    balance float,
    updated timestamp,
    FOREIGN KEY (username) REFERENCES users(username)
) ;

create table if not exists monthlybalance  (
    username  varchar(20),
    accountid integer,
    balance float,
    bmonth smallint,
    byear smallint,
    updated timestamp,
    FOREIGN KEY (username) REFERENCES users(username),
    FOREIGN KEY (accountid) REFERENCES accounts(id),
    PRIMARY KEY (username, accountid, bmonth, byear)
 
) ;


create table if not exists accountbalancehistory  (
    int accountid,
    int month,
    int year,
    float balance,
    updated timestamp,
    PRIMARY KEY(accountid, month, year),
    FOREIGN KEY (accountid) REFERENCES accounts(id)
) ;

create table if not exists transaction  (
    id serial primary key,
    username  varchar(20),
    accountname varchar(20),
    amount float,
    operation varchar(6),
    updated timestamp
) ;

create table if not exists accountupdatehistory  (
    username  varchar(20),
    accountname varchar(20),
    oldbalance float,
    newbalance float,
    updated timestamp
) ;