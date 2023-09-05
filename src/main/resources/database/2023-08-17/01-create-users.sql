--liquibase formatted sql
--changeset bpiw:17
create table users(
                      id bigint not null auto_increment primary key,
                      username varchar(50) not null unique,
                      password varchar(500) not null,
                      enabled boolean not null
);
--changeset bpiw:18
create table authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);
--changeset bpiw:19
create unique index ix_auth_username on authorities (username,authority);
