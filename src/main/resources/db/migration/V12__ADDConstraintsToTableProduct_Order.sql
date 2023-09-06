alter table if exists product_order
    add constraint FK_product_order_product foreign key (product_id) references product;