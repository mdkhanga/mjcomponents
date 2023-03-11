

create table if not exists users (
    username  varchar(20) primary key ,
    password  varchar(10),
    email     varchar(30)
) ;