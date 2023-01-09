-- auto-generated definition
create table words
(
    id      serial
        constraint words_pk
            primary key,
    english varchar not null,
    russian varchar not null
);

alter table words
    owner to postgres;

create unique index words_english_uindex
    on words (english);

create unique index words_id_uindex
    on words (id);

create table progress
(
    id           serial
        constraint progress_pk
            primary key,
    from_russian boolean default false not null,
    from_english boolean default false not null,
    word_id      integer               not null
        constraint progress_words_id_fk
            references words
            on update cascade on delete cascade
);

alter table progress
    owner to postgres;

create unique index progress_id_uindex
    on progress (id);

create unique index progress_word_id_uindex
    on progress (word_id);