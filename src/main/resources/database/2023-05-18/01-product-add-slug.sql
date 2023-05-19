--liquibase formatted sql
--changeset bpiw:3
alter table products add SLUG varchar(255) after image;
alter table products add constraint ui_product_slug unique key(slug);