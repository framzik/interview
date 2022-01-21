--список фильмов, для каждого — с указанием
-- общего числа посетителей за все время,
-- среднего числа зрителей за сеанс
-- общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
-- Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
drop view if exists info;
CREATE VIEW info AS
select f.name,
       count(ct)                                                       as число_посетителей,
       count(ct) / (select count(*)
                    from cinema.timetable
                    where timetable.film_id = f.id)                    as среднее_число_зрителей_за_сеанс,
       case when sum(ct.cost) is not null then sum(ct.cost) else 0 end as сумма_сборов
from cinema.film f
         left join cinema.timetable t on f.id = t.film_id
         left join cinema.ticket ct on t.id = ct.timetable_id
group by f.name, f.id
order by сумма_сборов;

select * from info
UNION
select 'итого' ,
       sum(info.число_посетителей),
       sum(info.среднее_число_зрителей_за_сеанс)/ (select count(*) from cinema.timetable),
       sum(info.сумма_сборов)
from info;


--число посетителей и кассовые сборы, сгруппированные по времени начала фильма: с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).
select '08-15' as time,
       count(ct)                                                       as число_посетителей,
       case when sum(ct.cost) is not null then sum(ct.cost) else 0 end as сумма_сборов
from  cinema.timetable t
         left join cinema.ticket ct on t.id = ct.timetable_id
where t.seance_start_time between '2021-12-29 08:00:00' and '2021-12-29 15:00:00'
union select '15-18',
             count(ct)                                                       as число_посетителей,
             case when sum(ct.cost) is not null then sum(ct.cost) else 0 end as сумма_сборов
from  cinema.timetable t
          left join cinema.ticket ct on t.id = ct.timetable_id
where t.seance_start_time between '2021-12-29 15:00:00' and '2021-12-29 18:00:00'
union select '18-21',
             count(ct)                                                       as число_посетителей,
             case when sum(ct.cost) is not null then sum(ct.cost) else 0 end as сумма_сборов
      from  cinema.timetable t
                left join cinema.ticket ct on t.id = ct.timetable_id
      where t.seance_start_time between '2021-12-29 18:00:00' and '2021-12-29 21:00:00'
union select '21-00',
             count(ct)                                                       as число_посетителей,
             case when sum(ct.cost) is not null then sum(ct.cost) else 0 end as сумма_сборов
from  cinema.timetable t
          left join cinema.ticket ct on t.id = ct.timetable_id
where t.seance_start_time between '2021-12-29 21:00:00' and '2021-12-30 00:00:00'
order by time;

