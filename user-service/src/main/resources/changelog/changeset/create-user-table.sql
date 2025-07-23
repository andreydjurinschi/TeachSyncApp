-- liquibase formatted sql

-- changeset andrei:create-user-table
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    full_name VARCHAR(255),
    hashed_password VARCHAR(255),
    user_role INT,
    username VARCHAR(255) NOT NULL
);
