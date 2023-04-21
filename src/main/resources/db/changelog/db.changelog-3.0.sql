--liquibase formatted sql

--changeset stanislav:1
ALTER TABLE users
    ADD COLUMN image VARCHAR(64);

--changeset stanislav:2
ALTER TABLE users_aud
    ADD COLUMN image VARCHAR(64);
