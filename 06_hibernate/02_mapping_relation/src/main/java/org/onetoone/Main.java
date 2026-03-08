package org.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop(1, "Asus", "Rog", "16GB", "256GB");
        Students s2 = new Students(1, "sameer", 69, l1);

        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Students.class)
                .addAnnotatedClass(Laptop.class).configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.persist(l1);
            session.persist(s2);
            transaction.commit();

            Students students = session.get(Students.class, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
