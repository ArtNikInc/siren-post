--liquibase formatted sql

--changeset nkozlov:post
CREATE TABLE post
(
    id    SERIAL       NOT NULL PRIMARY KEY,
    title varchar(250) NOT NULL,
    text  text         NOT NULL
);
CREATE INDEX post_id_index ON post (id);
--comment: Добавлена таблица post

--changeset nkozlov:comment
CREATE TABLE comment
(
    id        SERIAL NOT NULL PRIMARY KEY,
    post_id   SERIAL NOT NULL,
    parent_id SERIAL,
    text      text   NOT NULL,
    FOREIGN KEY (post_id) REFERENCES  post (id),
    FOREIGN KEY (parent_id) REFERENCES  comment (id)
);
CREATE INDEX file_info_id_index ON comment (id);
--comment: Добавлена таблица comment