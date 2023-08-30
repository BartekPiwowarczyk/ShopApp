--liquibase formatted sql
--changeset bpiw:2

ALTER TABLE PRODUCT ADD IMAGE VARCHAR(128) AFTER CURRENCY;