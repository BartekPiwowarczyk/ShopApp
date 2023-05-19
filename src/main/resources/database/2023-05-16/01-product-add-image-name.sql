--liquibase formatted sql
--changeset bpiw:2

alter table products add IMAGE varchar(128) after currency;