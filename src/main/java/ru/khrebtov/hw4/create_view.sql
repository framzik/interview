CREATE VIEW FilmSchedule AS
SELECT film.id,
       film.name           as name,
       film.duration       as duration,
       t.seance_start_time as time_start,
       t.seance_start_time + film.duration *
        interval '1 minute' as film_end
        from cinema.timetable t
        left join cinema.film on t.film_id = film.id;

CREATE VIEW FilmBreak AS
select C.name                                                 as фильм_1,
       C.time_start                                           as время_начала,
       c.duration                                             as длительность,
       C1.time_start                                          as время_начала_второго_фильма,
       extract(epoch from c1.time_start - c.film_end) / 60.00 as длительность_перерыва
FROM FilmSchedule AS C
         LEFT JOIN FilmSchedule AS C1
                   ON c.time_start <> c1.time_start
WHERE C1.id IS NOT NULL
  and c1.time_start > c.film_end
order by длительность_перерыва;