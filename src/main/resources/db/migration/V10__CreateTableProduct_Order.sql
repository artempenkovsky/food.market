create table product_order
(
    id   bigint not null,
    product_id bigint not null,
    order_id bigint not null,
    quantity double precision,
    primary key (id)
);