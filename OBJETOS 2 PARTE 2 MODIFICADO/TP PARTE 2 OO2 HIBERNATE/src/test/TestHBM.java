package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.HibernateUtil;

public class TestHBM {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("Conexión exitosa con Hibernate");
        session.close();
    }
}
