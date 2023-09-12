--liquibase formatted sql
--changeset bpiw:20
insert into users (id, username, password, enabled)
values (1, 'admin', '{bcrypt}$2a$10$OG61/n0gXIT75xtw.Lp5kOPP7yuxyCbgvAWde8FEsZTek6AmTIiey', true);
insert into authorities (username, authority) values ('admin','ROLE_ADMIN');