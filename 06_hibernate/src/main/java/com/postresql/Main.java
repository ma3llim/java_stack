package com.postresql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam("16");
        l1.setStorage("256GB");

        Students s1 = new Students();
        s1.setRollNo(7);
        s1.setStudentName("Sameer");
        s1.setStudentMarks(10);
        s1.setLaptop(l1);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(com.postresql.Students.class).configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        // insert
         session.persist(s1);

        // fetch
        // Students data = session.get(Students.class, 1);
        // System.out.println(data);
        System.out.println("");

        // update
        Transaction transaction = session.beginTransaction();
        // session.merge(s1);
        System.out.println("");

        // delete
        // session.remove(s1);

        session.close();
        sessionFactory.close();
    }
}
