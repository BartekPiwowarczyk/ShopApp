--liquibase formatted sql
--changeset bpiw:2

alter table products add image varchar(128) after currency;