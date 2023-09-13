alter table if exists orders
    add constraint FK_order_user foreign key (user_id) references users;