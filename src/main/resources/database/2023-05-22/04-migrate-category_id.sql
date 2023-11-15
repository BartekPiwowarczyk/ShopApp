--liquibase formatted sql
--changeset bpiw:7
insert into category (id,name,description,slug) values (1,'other','','other');
update product set category_id=1;
alter table product modify category_id bigint not null;