package dao;

import datos.Contacto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ContactoDao {
    private SessionFactory sessionFactory;

    public ContactoDao() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(Contacto contacto) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(contacto);
        tx.commit();
        session.close();
    }

    public Contacto get(int id) {
        Session session = sessionFactory.openSession();
        Contacto contacto = session.get(Contacto.class, id);
        session.close();
        return contacto;
    }

    public void update(Contacto contacto) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(contacto);
        tx.commit();
        session.close();
    }

    public void delete(Contacto contacto) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(contacto);
        tx.commit();
        session.close();
    }
}