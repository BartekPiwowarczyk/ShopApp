--liquibase formatted sql
--changeset bpiw:20
insert into users (id, username, password, enabled)
values (1, 'admin', '{bcrypt}$2a$10$QeJCmL.JD4tZt2dCEmApg.PCF/Ywu0tvpCBABTylUEoLwExZCikjS', true);
insert into authorities (username, authority) values ('admin','ROLE_ADMIN');