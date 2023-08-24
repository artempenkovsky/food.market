create table user_roles
(
    id   bigint not null,
    role varchar(255),
    primary key (id)
);
create table users
(
    id             bigint not null,
    name           varchar(255),
    sur_name       varchar(255),
    login          varchar(255),
    password       varchar(255),
    date_of_create varchar(255),
    user_role_id   bigint not null,
    primary key (id)
);
alter table if exists users
    add constraint FK_role_user foreign key (user_role_id) references user_roles;
alter table if exists users
    add constraint UK_user_login unique (login);