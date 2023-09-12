--liquibase formatted sql
--changeset bpiw:12
create table shipment(
    id bigint not null auto_increment primary key,
    name varchar(64) not null,
    price decimal(6,2) not null,
    type varchar(32) not null,
    default_shipment boolean default false
);

insert into shipment(name, price, type, default_shipment) values ('kurier', 14.99, 'DELIVERYMAN',true);
insert into shipment(name, price, type, default_shipment) values ('Odbiór osobisty', 0.0, 'SELFPICKUP',false);