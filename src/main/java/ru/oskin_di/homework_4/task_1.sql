select table_1.name       as "Фильм 1",
       table_1.start_time as "Время начала",
       table_1.durability as "Длительность",
       table_2.name       as "Фильм 2",
       table_2.start_time as "Время начала",
       table_2.durability as "Длительность"
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
) as table_2 on (time_to_sec(table_1.durability) + time_to_sec(table_1.start_time)) > time_to_sec(table_2.start_time)
    and time_to_sec(table_1.start_time) <= time_to_sec(table_2.start_time)
    and table_1.id <> table_2.id
order by table_1.start_time;