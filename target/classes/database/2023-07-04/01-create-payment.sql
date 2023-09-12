--liquibase formatted sql
--changeset bpiw:14
create table payment(
                        id bigint not null auto_increment primary key,
                        name varchar(64) not null,
                        type varchar(32) not null,
                        default_payment boolean default false,
                        note text
);
insert into payment(name, type, default_payment, note)
values ('Przelew bankowy', 'BANK_TRANSFER', true, 'Prosimy o dokonanie przelewu na konto:\n30 1030 1739 5825 1518 9904 4499\n w tytule proszę podać nr zamówienia');