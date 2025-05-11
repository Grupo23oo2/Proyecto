package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Servicio;

public class ServicioDao {
    public Servicio traerServicio(int idServicio) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Servicio.class, idServicio);
        }
    }

    public boolean eliminarServicio(int idServicio) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Servicio t = session.get(Servicio.class, idServicio);
            if (t == null) return false;
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarServicio(Servicio servicio) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(servicio);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}