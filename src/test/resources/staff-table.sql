create table staff (
    id          int not null primary key,
    firstName   varchar(50),
    middleName  varchar(50),
    lastName    varchar(50),
    dob         date,
    gender      bit,
    phone       varchar(9),
    address     varchar(125)
);