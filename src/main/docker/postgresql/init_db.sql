CREATE ROLE db_user;
ALTER ROLE db_user WITH SUPERUSER
INHERIT
CREATEROLE
CREATEDB
LOGIN
NOREPLICATION
NOBYPASSRLS
PASSWORD 'md5d7980ace5b59ea073a4c25bd767b9c8d';

CREATE DATABASE public_db WITH TEMPLATE = template0 OWNER = postgres;
GRANT ALL ON DATABASE public_db TO db_user;

\connect public_db;

CREATE TABLE product(
  id    serial primary key not null,
  name  varchar(255) not null
);

CREATE TABLE store(
  id    serial primary key not null,
  name  varchar(255) not null
);

INSERT INTO product VALUES (default, 'Test Product #1');

INSERT INTO store VALUES (default, 'Test Store #1');

