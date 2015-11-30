package ru.hello;

import org.hibernate.Session;
import ru.hello.model.Guest;
import ru.hello.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Guest guest = new Guest();
        guest.setName("test guest");
        session.save(guest);
        session.getTransaction().commit();
    }
}
