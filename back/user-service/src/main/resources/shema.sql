create table users
(
    id    uuid not null
        constraint users_pkey
            primary key,
    age   integer,
    name  varchar(255),
    email varchar(255)
        constraint uk_email
            unique
);