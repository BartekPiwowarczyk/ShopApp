--liquibase formatted sql
--changeset bpiw:9
ALTER TABLE REVIEW ADD MODERATED BOOLEAN DEFAULT FALSE AFTER CONTENT;