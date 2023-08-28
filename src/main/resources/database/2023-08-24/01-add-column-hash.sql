--liquibase formatted sql
--changeset bpiw:23
ALTER TABLE USERS ADD HASH VARCHAR(120);
--changeset bpiw:24
ALTER TABLE USERS ADD HASH_DATE datetime;