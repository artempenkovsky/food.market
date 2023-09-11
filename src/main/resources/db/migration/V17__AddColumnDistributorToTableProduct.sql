alter table if exists product
    ADD COLUMN distributor_id bigint;
alter table if exists product
    add constraint FK_product_user foreign key (distributor_id) references users;