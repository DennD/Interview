SELECT '09:00:00 - 15:00:00' AS "Временной интервал",
       SUM(price)            as "Кассовые сборы",
       COUNT(sales.id)       as "Число посетителей"
FROM sessions
         INNER JOIN
     tickets ON sessions.ticket_id = tickets.id
         INNER JOIN
     sales ON sales.ticket_id = tickets.id
WHERE TIME(start_time) >= TIME('09:00:00')
  AND TIME(start_time) < TIME('15:00:00')
UNION ALL
SELECT '15:00:00 - 18:00:00' AS "Временной интервал",
       SUM(price)            as "Кассовые сборы",
       COUNT(sales.id)       as "Число посетителей"
FROM sessions
         INNER JOIN
     tickets ON sessions.ticket_id = tickets.id
         INNER JOIN
     sales ON sales.ticket_id = tickets.id
WHERE TIME(start_time) >= TIME('15:00:00')
  AND TIME(start_time) < TIME('18:00:00')
UNION ALL
SELECT '18:00:00 - 21:00:00' AS "Временной интервал",
       SUM(price)            as "Кассовые сборы",
       COUNT(sales.id)       as "Число посетителей"
FROM sessions
         INNER JOIN
     tickets ON sessions.ticket_id = tickets.id
         INNER JOIN
     sales ON sales.ticket_id = tickets.id
WHERE TIME(start_time) >= TIME('18:00:00')
  AND TIME(start_time) < TIME('21:00:00')
UNION ALL
SELECT '21:00:00 - 00:00:00' AS "Временной интервал",
       SUM(price)            as "Кассовые сборы",
       COUNT(sales.id)       as "Число посетителей"
FROM sessions
         INNER JOIN
     tickets ON sessions.ticket_id = tickets.id
         INNER JOIN
     sales ON sales.ticket_id = tickets.id
WHERE TIME(start_time) >= TIME('21:00:00')
  AND TIME(start_time) <= TIME('23:59:59');