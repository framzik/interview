--ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
-- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
select C.name        as фильм_1,
       C.time_start  as время_начала,
       c.duration    as длительность,
       C1.name       as фильм_2,
       C1.time_start as время_начала2,
       C1.duration   as длительность2
FROM FilmSchedule AS C
         LEFT JOIN FilmSchedule AS C1
                   ON C1.time_start BETWEEN C.time_start AND C.film_end
                       AND C.id <> C1.id
WHERE C1.id IS NOT NULL
ORDER BY время_начала;




