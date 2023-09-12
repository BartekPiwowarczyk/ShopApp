--liquibase formatted sql
--changeset bpiw:9
alter table review add moderated boolean default false after content;