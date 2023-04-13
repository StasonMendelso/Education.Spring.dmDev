--liquibase formatted sql

--changeset stanislav:1
CREATE TABLE IF NOT EXISTS revision
(
    id        SERIAL PRIMARY KEY,
    timestamp BIGINT NOT NULL
);

--changeset stanislav:2
CREATE TABLE IF NOT EXISTS users_aud
(
    id          BIGINT,
    rev         INT REFERENCES revision (id),
    revtype     SMALLINT,
    username    VARCHAR(64) NOT NULL UNIQUE,
    birth_date  DATE,
    firstname   VARCHAR(64),
    lastname    VARCHAR(64),
    role        VARCHAR(32),
    company_id  INT,
    created_at  timestamp,
    created_by  VARCHAR(64),
    modified_at timestamp,
    modified_by VARCHAR(64)
);