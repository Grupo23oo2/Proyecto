package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Persona;

public class PersonaDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Persona objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}
	
	public boolean modificarPersona(Persona persona) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(persona);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean eliminar(int idPersona) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Persona persona = session.get(Persona.class, idPersona);
            if (persona == null) return false;
            tx = session.beginTransaction();
            session.delete(persona);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

	public Persona traer(long idPersona) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Persona traer(int dni) {
		Persona persona = null;

		try {
			iniciaOperacion();
			persona = (Persona) session.createQuery("from Persona p where p.dni = :dni").setParameter("dni", dni)
					.uniqueResult();
		} finally {
			session.close();
		}
		return persona;
	}

	public List<Persona> traer() {
		List<Persona> lista = new ArrayList<Persona>();
		try {
			iniciaOperacion();
			Query<Persona> query = session.createQuery("from Persona p order by p.apellido asc, p.nombre asc",
					Persona.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}