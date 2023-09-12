--liquibase formatted sql
--changeset bpiw:7
insert into category (id,name,description,slug) values (1,'inne','','inne');
update product set category_id=1;
alter table product modify category_id bigint not null;