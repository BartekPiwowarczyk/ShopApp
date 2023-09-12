--liquibase formatted sql
--changeset bpiw:10
create table cart (
  id bigint not null auto_increment primary key,
  created datetime not null
);

create table cart_item(
    id bigint not null auto_increment primary key,
    product_id bigint not null,
    quantity int,
    cart_id bigint not null,
    constraint fk_cart_item_products foreign key (product_id) references product(id),
    constraint fk_cart_item_cart_id foreign key (cart_id) references cart(id)
);