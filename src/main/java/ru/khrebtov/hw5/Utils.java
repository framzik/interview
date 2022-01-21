package ru.khrebtov.hw5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {
    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
