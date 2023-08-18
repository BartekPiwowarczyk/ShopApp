--liquibase formatted sql
--changeset bpiw:20
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED)
VALUES (1, 'admin', '{bcrypt}$2a$10$QeJCmL.JD4tZt2dCEmApg.PCF/Ywu0tvpCBABTylUEoLwExZCikjS', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('admin','ROLE_ADMIN');