--liquibase formatted sql

--changeset stanislav:1
ALTER TABLE users
    ADD COLUMN password VARCHAR(128) DEFAULT '123';

--changeset stanislav:2
ALTER TABLE users_aud
    ADD COLUMN password VARCHAR(128);
