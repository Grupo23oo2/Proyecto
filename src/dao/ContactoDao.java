package dao;

import datos.Contacto;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContactoDao {

    private Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) {
            tx.rollback();
        }
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public boolean agregarContacto(Contacto contacto) {
        boolean exito = false;
        try {
            iniciaOperacion();
            session.save(contacto);
            tx.commit();
            exito = true;  // Operación exitosa
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exito;  // Retorna true si fue exitoso, false si hubo error
    }

    public Contacto traerContacto(int idContacto) {
        Contacto contacto = null;
        try {
            iniciaOperacion();
            contacto = session.get(Contacto.class, idContacto);
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contacto;
    }

    public boolean eliminarContacto(int idContacto) {
        boolean exito = false;
        try {
            iniciaOperacion();
            Contacto contacto = session.get(Contacto.class, idContacto);
            if (contacto != null) {
                session.delete(contacto);
                tx.commit();
                exito = true;
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exito;
    }

    public boolean modificarContacto(int idContacto, String nuevaDireccion, String nuevoEmail, String nuevoTelefono) {
        boolean exito = false;
        try {
            iniciaOperacion();
            Contacto contacto = session.get(Contacto.class, idContacto);
            if (contacto != null) {
                // Seteamos nuevos valores
                contacto.setDireccion(nuevaDireccion);
                contacto.setEmail(nuevoEmail);
                contacto.setTelefono(nuevoTelefono);
                session.update(contacto);
                tx.commit();
                exito = true;
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exito;
    }
}