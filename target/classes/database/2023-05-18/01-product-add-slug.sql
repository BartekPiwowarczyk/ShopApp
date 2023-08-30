--liquibase formatted sql
--changeset bpiw:3
alter table product add SLUG varchar(255) after image;
alter table product add constraint ui_product_slug unique key(slug);