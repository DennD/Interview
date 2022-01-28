package ru.oskin_di.homework_5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigurationHibernate {

    private static SessionFactory sessionFactory;

    private ConfigurationHibernate() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return sessionFactory = new Configuration()
                    .configure("configs/hibernate.cfg.xml")
                    .buildSessionFactory();
        } else {
            return sessionFactory;
        }
    }
}
