--liquibase formatted sql
--changeset bpiw:16
create table order_log(
    id bigint not null auto_increment primary key,
    order_id bigint not null,
    created datetime not null,
    note text
);