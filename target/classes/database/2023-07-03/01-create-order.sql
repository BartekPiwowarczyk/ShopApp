--liquibase formatted sql
--changeset bpiw:11
CREATE TABLE `ORDER`(
                        ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        PLACE_DATE DATETIME NOT NULL,
                        ORDER_STATUS VARCHAR(32) NOT NULL,
                        GROSS_VALUE DECIMAL(6,2) NOT NULL,
                        FIRSTNAME VARCHAR(64) NOT NULL,
                        LASTNAME VARCHAR(64) NOT NULL,
                        STREET VARCHAR(64) NOT NULL,
                        ZIPCODE VARCHAR(6) NOT NULL,
                        CITY VARCHAR(64) NOT NULL,
                        EMAIL VARCHAR(64) NOT NULL,
                        PHONE VARCHAR(64) NOT NULL
);
CREATE TABLE ORDER_ROW(
                          ID BIGINT NOT NULL auto_increment PRIMARY KEY,
                          ORDER_ID BIGINT NOT NULL,
                          PRODUCT_ID BIGINT NOT NULL,
                          QUANTITY INT NOT NULL,
                          PRICE DECIMAL(6,2) NOT NULL,
                          CONSTRAINT FK_ORDER_ROW_ORDER_ID FOREIGN KEY (ORDER_ID) REFERENCES `ORDER`(ID),
                          CONSTRAINT FK_ORDER_ROW_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(ID)
);