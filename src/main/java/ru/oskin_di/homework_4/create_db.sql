CREATE SCHEMA `cinema`;

CREATE TABLE `films`
(
    `id`         int          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`       varchar(255) NOT NULL,
    `durability` time         NOT NULL
);

INSERT INTO `films` (name, durability)
VALUES ('Матрица', '01:30:00'),
       ('Властелин Колец', '02:00:00'),
       ('Гарри Поттер', '01:30:00'),
       ('Аватар', '02:00:00'),
       ('Терминатор', '01:00:00');


CREATE TABLE `tickets`
(
    `id`    int    NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `price` double NOT NULL
);

INSERT INTO `tickets` (price)
VALUES (300),
       (350),
       (400),
       (450);


CREATE TABLE `sessions`
(
    `id`         int      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `film_id`    int      NOT NULL,
    `start_time` datetime NOT NULL,
    `ticket_id`  int      NOT NULL,
    FOREIGN KEY (`film_id`) REFERENCES `films` (`id`),
    FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
);

INSERT INTO `sessions` (film_id, start_time, ticket_id)
VALUES (1, '2022-01-01 09:00:00', 1),
       (2, '2022-01-01 10:00:00', 1),
       (3, '2022-01-01 12:00:00', 1),
       (4, '2022-01-01 15:00:00', 2),
       (5, '2022-01-01 16:00:00', 3),
       (1, '2022-01-01 17:00:00', 3),
       (3, '2022-01-01 19:00:00', 3),
       (5, '2022-01-01 22:00:00', 4),
       (2, '2022-01-01 22:00:00', 4),
       (3, '2022-01-01 22:30:00', 4);


CREATE TABLE `sales`
(
    `id`         int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `session_id` int NOT NULL,
    `ticket_id`  int NOT NULL,
    `number`     int NOT NULL,
    FOREIGN KEY (`session_id`) REFERENCES `sessions` (`id`),
    FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
);

INSERT INTO `sales` (session_id, ticket_id, number)
VALUES (1, 1, 111),
       (1, 1, 222),
       (1, 1, 333),
       (2, 1, 444),
       (2, 1, 555),
       (3, 1, 666),
       (3, 1, 777),
       (4, 2, 888),
       (4, 2, 999),
       (5, 3, 211),
       (1, 3, 322),
       (3, 3, 433),
       (3, 3, 544),
       (5, 4, 655),
       (5, 4, 766),
       (3, 4, 877),
       (3, 4, 988),
       (2, 4, 123);