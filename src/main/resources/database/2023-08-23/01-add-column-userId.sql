--liquibase formatted sql
--changeset bpiw:21
alter table `order` add user_id bigint;
--changeset bpiw:22
alter table `order` add constraint fk_order_user_id foreign key (user_id) references users(id);