--liquibase formatted sql
--changeset bpiw:8
CREATE TABLE REVIEWS(
    REVIEW_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_ID BIGINT NOT NULL,
    AUTHOR_NAME VARCHAR(60) NOT NULL,
    CONTENT TEXT
);