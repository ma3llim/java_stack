package org.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Laptop l1 = new Laptop(1, "Asus", "Rog", "16GB", "256GB");
        Laptop l2 = new Laptop(2, "Hp", "Hp1", "16GB", "256GB");
        Laptop l3 = new Laptop(3, "Dell", "Dell1", "16GB", "256GB");

        Students s1 = new Students(1, "Sameer", 69, Arrays.asList(l1, l2, l3));

        // set relationship
        l1.setStudents(s1);
        l2.setStudents(s1);
        l3.setStudents(s1);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Students.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            session.persist(s1);   // cascade will save laptops

            transaction.commit();

            Students student = session.get(Students.class, 1);
            System.out.println(student);
        }

        sessionFactory.close();
    }
}