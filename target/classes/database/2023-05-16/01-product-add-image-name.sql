--liquibase formatted sql
--changeset bpiw:2

alter table product add IMAGE varchar(128) after currency;