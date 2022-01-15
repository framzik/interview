drop table if exists student;
CREATE TABLE IF NOT EXISTS student
(
    id       bigserial    NOT NULL,
    name     varchar(300) not null,
    mark integer      not null,
    CONSTRAINT student_pkey PRIMARY KEY (id)
);


