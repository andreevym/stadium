package ru.hello;

import org.hibernate.Session;
import ru.hello.model.Guest;
import ru.hello.util.HibernateUtil;

public class Main {

    private static Session session;

    public Main() {
        session = HibernateUtil.getSessionFactory().openSession();
        shutdownHook();
    }

    public static void main(String[] args) {
        new Main(); // init self

        session.beginTransaction();

        Guest guest = new Guest();
        guest.setName("test guest");
        System.exit(-1);

        session.save(guest);
        session.getTransaction().commit();
    }

    private static void shutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("shutdown");

                if (session != null) {
                    session.close();
                }
                super.run();
            }
        });
    }
}
