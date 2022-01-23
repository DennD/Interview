select film_1_name as 'Фильм 1',
       film_1_start_time as 'Время начала',
       film_1_durability as 'Длительность',
       film_2_start_time as 'Время начала второго фильма',
       pereriv as 'Длительность перерыва'
from (select table_1.name       as film_1_name,
             table_1.start_time as film_1_start_time,
             table_1.durability as film_1_durability,
             table_2.start_time as film_2_start_time,
             sec_to_time(time_to_sec(table_2.start_time) - (time_to_sec(table_1.start_time) + time_to_sec(table_1.durability))) as pereriv
      from (
               select sessions.id         as id,
                      films.name          as name,
                      films.durability    as durability,
                      sessions.start_time as start_time
               from films
                        inner join sessions on films.id = sessions.film_id
           ) as table_1
               inner join (
          select sessions.id         as id,
                 films.name          as name,
                 films.durability    as durability,
                 sessions.start_time as start_time
          from films
                   inner join sessions on films.id = sessions.film_id
      ) as table_2 on (time_to_sec(table_1.durability) + time_to_sec(table_1.start_time)) <= time_to_sec(table_2.start_time)
          and table_1.id <> table_2.id
      having pereriv >= time("00:30:00")
      order by pereriv) as table_help;