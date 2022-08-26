--liquibase formatted sql

--changeset nkozlov:post
CREATE TABLE post
(
    id            SERIAL        NOT NULL PRIMARY KEY ,
    title         varchar(250)  NOT NULL,
    text          text          NOT NULL
);
CREATE INDEX file_info_id_index ON post (id);
--comment: Добавлена таблица post
