--liquibase formatted sql
--changeset bpiw:23
alter table users add hash varchar(120);
--changeset bpiw:24
alter table users add hash_date datetime;