--liquibase formatted sql
--changeset bpiw:25
update payment set default_payment=false;
insert into payment(name, type, default_payment, note)
values ('Online payment via Przelewy 24', 'P24_ONLINE', true, '');