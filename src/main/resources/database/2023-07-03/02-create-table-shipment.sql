--liquibase formatted sql
--changeset bpiw:12
CREATE TABLE SHIPMENT(
    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(64) NOT NULL,
    PRICE DECIMAL(6,2) NOT NULL,
    TYPE VARCHAR(32) NOT NULL,
    DEFAULT_SHIPMENT BOOLEAN DEFAULT FALSE
);

INSERT INTO SHIPMENT(NAME, PRICE, TYPE, DEFAULT_SHIPMENT) VALUES ('Kurier', 14.99, 'DELIVERYMAN',true);
INSERT INTO SHIPMENT(NAME, PRICE, TYPE, DEFAULT_SHIPMENT) VALUES ('Odbiór osobisty', 0.0, 'SELFPICKUP',false);