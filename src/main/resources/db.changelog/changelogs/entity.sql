--liquibase formatted sql

--changeset nkozlov:post
CREATE SEQUENCE post_id_seq;
CREATE TABLE post
(
    id            BIGINT        NOT NULL PRIMARY KEY ,
    title         varchar(250)  NOT NULL,
    text          text          NOT NULL
);
CREATE INDEX file_info_id_index ON post (id);
ALTER SEQUENCE post_id_seq
    OWNED BY post.id;
--comment: Добавлена таблица post
