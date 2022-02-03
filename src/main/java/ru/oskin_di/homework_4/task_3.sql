select name        as "Название фильма",
       sum_price   as "Общая сумма сборов",
       avg_clients as "Среднее число зрителей сеанса",
       sum_clients as "Общее число посетителей"
from (select *
      from (select films.name                  as name,
                   sum(help_table.sum_price)   as sum_price,
                   avg(help_table.count_sales) as avg_clients,
                   sum(count_sales)            as sum_clients
            from films
                     inner join(select sessions.id     as id,
                                       film_id,
                                       sum(price)      as sum_price,
                                       count(sales.id) as count_sales
                                from sessions
                                         inner join tickets
                                                    on sessions.ticket_id = tickets.id
                                         inner join sales
                                                    on sales.ticket_id = tickets.id
                                group by sessions.id) as help_table
                               on films.id = help_table.film_id
            group by films.id) as results_1
      union all
      select "Итого:", sum(sum_price) as sum_price, avg(avg_clients) as avg_clients, sum(sum_clients) as sum_clients
      from (select films.name                  as name,
                   sum(help_table.sum_price)   as sum_price,
                   avg(help_table.count_sales) as avg_clients,
                   sum(count_sales)            as sum_clients
            from films
                     inner join(select sessions.id     as id,
                                       film_id,
                                       sum(price)      as sum_price,
                                       count(sales.id) as count_sales
                                from sessions
                                         inner join tickets
                                                    on sessions.ticket_id = tickets.id
                                         inner join sales
                                                    on sales.ticket_id = tickets.id
                                group by sessions.id) as help_table
                               on films.id = help_table.film_id
            group by films.id) as results_2) as results;