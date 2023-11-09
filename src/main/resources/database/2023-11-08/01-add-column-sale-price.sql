--liquibase formatted sql
--changeset bpiw:27
alter table product add sale_price decimal(9,2)