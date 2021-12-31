drop view if exists info;
drop view if exists FilmBreak;
drop view if exists FilmSchedule;
drop table if exists cinema.film;
drop table if exists cinema.timetable;
drop table if exists cinema.ticket;
drop table if exists cinema.film_ticket_correlation;
CREATE TABLE IF NOT EXISTS cinema.film
(
    id       bigserial    NOT NULL,
    name     varchar(300) not null,
    duration integer      not null,
    CONSTRAINT film_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cinema.timetable
(
    id                bigserial NOT NULL,
    seance_start_time timestamp NOT NULL unique,
    film_id           bigint    not null,
    CONSTRAINT timetable_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cinema.ticket
(
    id           bigserial      NOT NULL,
    cost         decimal(19, 2) NOT NULL,
    timetable_id bigint         not null,
    CONSTRAINT ticket_pkey PRIMARY KEY (id)
);
