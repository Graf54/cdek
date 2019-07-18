drop table if exists app;
create table app
(
    id        serial,
    phone     varchar(50) not null,
    created   timestamp            default now() not null,
    status_id integer     not null default (0)
);
