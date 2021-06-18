create table if not exists public.transaction
(
    id   serial not null
        constraint status_pk
            primary key,
    document_number varchar,
    post_date varchar,
    amount float,
    receiver_account varchar,
    receiver varchar,
    sender_account varchar,
    sender varchar
);

create table id not exists public.user
(
    id   serial not null
        constraint status_pk
            primary key,
    identification_number varchar,
    account_number varchar,
    amount float,
    name varchar,
    surname varchar,
    mobile_number varchar,
    email_address varchar
);