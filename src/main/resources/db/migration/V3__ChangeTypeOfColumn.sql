alter table if exists users
    ADD COLUMN new_date_column DATE;
alter table if exists users
    DROP COLUMN date_of_create;
alter table if exists users
    RENAME COLUMN new_date_column TO date_of_create;

