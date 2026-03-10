package org.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop(1, "Asus", "Rog", "16GB", "256GB");
        Laptop l2 = new Laptop(2, "Hp", "Hp1", "16GB", "256GB");
        Laptop l3 = new Laptop(3, "Dell", "Dell1", "16GB", "256GB");

        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Laptop.class).configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.persist(l1);
            session.persist(l2);
            session.persist(l3);

            transaction.commit();
            System.out.println("\n\n\n\n");
            // Query query = session.createQuery("select ram from Laptop where brand like 'Asus'");
            Laptop result = session.byId(Laptop.class).getReference(2);

            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
