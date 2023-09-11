alter table if exists product
    ADD COLUMN price double precision;
alter table if exists product
    ADD COLUMN active bool default true;
alter table if exists product
    ADD COLUMN measurement_unit varchar;



