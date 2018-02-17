--drop schema prod_schema;
CREATE SCHEMA if not exists prod_schema AUTHORIZATION developer; 
--drop table auth;
create table if not exists auth(id bigint auto_increment primary key, username varchar(255), passkey varchar(255));
--truncate table auth;
