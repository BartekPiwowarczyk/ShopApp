--liquibase formatted sql
--changeset bpiw:14
CREATE TABLE PAYMENT(
                        ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        NAME VARCHAR(64) NOT NULL,
                        TYPE VARCHAR(32) NOT NULL,
                        DEFAULT_PAYMENT BOOLEAN DEFAULT FALSE,
                        NOTE TEXT
);
INSERT INTO PAYMENT(NAME, TYPE, DEFAULT_PAYMENT, NOTE)
VALUES ('Przelew bankowy', 'BANK_TRANSFER', true, 'Prosimy o dokonanie przelewu na konto:\n30 1030 1739 5825 1518 9904 4499\n w tytule proszę podać nr zamówienia');