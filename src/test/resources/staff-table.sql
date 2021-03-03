create table staff (
    id          int not null primary key auto_increment,
    firstName   varchar(50),
    middleName  varchar(50),
    lastName    varchar(50),
    dob         date,
    phone       varchar(15),
    address     varchar(125)
);

