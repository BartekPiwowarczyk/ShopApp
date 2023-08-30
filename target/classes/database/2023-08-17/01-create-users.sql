--liquibase formatted sql
--changeset bpiw:17
CREATE TABLE USERS(
                      ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      USERNAME VARCHAR(50) NOT NULL UNIQUE,
                      PASSWORD VARCHAR(500) NOT NULL,
                      ENABLED BOOLEAN NOT NULL
);
--changeset bpiw:18
CREATE TABLE AUTHORITIES (
                             USERNAME VARCHAR(50) NOT NULL,
                             AUTHORITY VARCHAR(50) NOT NULL,
                             CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME)
);
--changeset bpiw:19
CREATE UNIQUE INDEX IX_AUTH_USERNAME ON AUTHORITIES (USERNAME,AUTHORITY);
