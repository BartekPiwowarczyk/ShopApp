--liquibase formatted sql
--changeset bpiw:15
ALTER TABLE `ORDER` ADD PAYMENT_ID BIGINT;
UPDATE `ORDER` SET PAYMENT_ID=1;
ALTER TABLE `ORDER` MODIFY PAYMENT_ID BIGINT NOT NULL;