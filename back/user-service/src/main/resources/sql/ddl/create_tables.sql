create table client
(
    id    uuid not null
        constraint client_pkey
            primary key,
    age   integer,
    email varchar(255)
        constraint uk_bfgjs3fem0hmjhvih80158x29
            unique,
    name  varchar(255)
);

create table comment
(
    id        bigint not null
        constraint comment_pkey
            primary key,
    content   varchar(255),
    client_id uuid
        constraint fkkh7b1ibqumr31jlf124of15vy
            references client
);