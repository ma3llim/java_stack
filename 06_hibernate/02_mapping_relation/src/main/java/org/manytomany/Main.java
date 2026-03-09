package org.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Laptop l1 = new Laptop("Asus", "Rog", "16GB", "256GB");
        Laptop l2 = new Laptop("Hp", "Hp1", "16GB", "256GB");
        Laptop l3 = new Laptop("Dell", "Dell1", "16GB", "256GB");

        Students s1 = new Students("Sameer", 69, Arrays.asList(l1, l2, l3));
        Students s2 = new Students("Fahad", 69, Arrays.asList(l1, l2, l3));

        // set relationship
        l1.setStudents(Arrays.asList(s1, s2));
        l2.setStudents(Arrays.asList(s1, s2));
        l3.setStudents(Arrays.asList(s1, s2));

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Students.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            session.persist(l1);
            session.persist(l2);
            session.persist(l3);

            session.persist(s1);
            session.persist(s2);

            transaction.commit();

            Students student = session.get(Students.class, 1);
            System.out.println(student);
        }

        sessionFactory.close();
    }
}