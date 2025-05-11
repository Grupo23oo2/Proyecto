package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Turno;

public class TurnoDao {
    public Turno traerTurno(int idTurno) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Turno.class, idTurno);
        }
    }

    public boolean eliminarTurno(int idTurno) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Turno t = session.get(Turno.class, idTurno);
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

    public boolean modificarTurno(Turno turno) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(turno);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}