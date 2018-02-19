--drop schema prod_schema;
CREATE SCHEMA if not exists prod_schema AUTHORIZATION developer; 
--drop table auth;
create table if not exists auth(id bigint auto_increment primary key, firstName varchar(60), lastName varchar(60), username varchar(12), passkey varchar(255), createdBy varchar(12), modifiedBy varchar(12), modifiedOn varchar(60), createdOn varchar(60) );
--truncate table auth;
