create table deliveries_type
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table order_status
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table payment_type
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);
alter table if exists orders
    add column deliveries_type_id bigint;
alter table if exists orders
    add column order_status_id bigint;
alter table if exists orders
    add column payment_type_id bigint;

alter table if exists orders
    add constraint FK_deliveries_type_order foreign key (deliveries_type_id) references deliveries_type;
alter table if exists orders
    add constraint FK2_order_status_order foreign key (order_status_id) references order_status;
alter table if exists orders
    add constraint FK_payment_type_order foreign key (payment_type_id) references payment_type;