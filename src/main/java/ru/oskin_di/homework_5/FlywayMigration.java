package ru.oskin_di.homework_5;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    public static void start() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5433/students","postgres","postgres")
                .load();
        flyway.migrate();
    }

}
