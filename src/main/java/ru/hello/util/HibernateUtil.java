package ru.hello.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            //For XML mapping
            //return new Configuration().configure().buildSessionFactory();

            //For Annotation
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutDown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
