--liquibase formatted sql
--changeset bpiw:26
alter table `order` add order_hash varchar(12);