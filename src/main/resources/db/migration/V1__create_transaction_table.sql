create table if not exists public.user
(
    id   serial not null
    primary key,
    identification_number varchar unique,
    account_number varchar default uuid_in((md5((random())::text))::cstring),
    amount float,
    name varchar,
    surname varchar,
    mobile_number varchar,
    email_address varchar unique,
    password varchar
    );

create table if not exists public.transaction
(
    id   serial not null
    constraint status_pk
    primary key,
    document_number varchar default uuid_in((md5((random())::text))::cstring),
    post_date timestamp default now(),
    amount float,
    receiver_id integer constraint receiver_id_fk01
    references public.user,
    sender_id integer constraint sender_id_fk02
    references public.user
    );