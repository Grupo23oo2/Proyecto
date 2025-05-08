package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Lugar;

public class LugarDao {
	
    public int agregarLugar(Lugar lugar) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            int id = (int) session.save(lugar);
            tx.commit();
            return id;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return 0;
        }
    }

    public Lugar traerLugar(int idLugar) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Lugar.class, idLugar);
        }
    }

    public boolean eliminarLugar(int idLugar) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Lugar lugar = session.get(Lugar.class, idLugar);
            if (lugar == null) return false;
            tx = session.beginTransaction();
            session.delete(lugar);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarLugar(Lugar lugar) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(lugar);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}