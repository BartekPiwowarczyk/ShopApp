--liquibase formatted sql
--changeset bpiw:2

alter table product add image varchar(128) after currency;