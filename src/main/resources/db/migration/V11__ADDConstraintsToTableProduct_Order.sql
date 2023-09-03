alter table if exists product_order
    add constraint FK_product_order_order foreign key (order_id) references orders;