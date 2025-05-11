package dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Servicio;

public class EmpleadoDao {
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

    public boolean agregarEmpleado(Empleado objeto) {
        boolean resultado = false;
        try {
            iniciaOperacion();
            session.save(objeto);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return resultado;
    }

    public boolean modificarEmpleado(int idPersona, String nuevoNombre, String nuevoRol, String nuevoApellido, String nuevoDni) {
        boolean resultado = false;
        try {
            iniciaOperacion();
            Empleado emp = session.get(Empleado.class, idPersona);
            if (emp != null) {
                emp.setNombre(nuevoNombre);
                emp.setApellido(nuevoApellido);
                emp.setRol(nuevoRol);
                emp.setDni(nuevoDni);
                session.update(emp);
                tx.commit();
                resultado = true;
            } else {
                System.out.println("Empleado no encontrado");
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return resultado;
    }

    public boolean eliminarEmpleado(int idPersona) {
        boolean resultado = false;
        try {
            iniciaOperacion();
            Empleado empleado = session.get(Empleado.class, idPersona);
            if (empleado != null) {
                session.delete(empleado);
                tx.commit();
                resultado = true;
            } else {
                System.out.println("Empleado no encontrado con ID: " + idPersona);
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return resultado;
    }

    public Empleado traerEmpleado(int idPersona) {
        Empleado objeto = null;
        try {
            iniciaOperacion();
            objeto = (Empleado) session.get(Empleado.class, idPersona);
            if (objeto == null) {
                System.out.println("No se encontró ningún empleado con ID: " + idPersona);
            }
        } finally {
            session.close();
        }
        return objeto;
    }

    public Set<Servicio> traerTurnosDeEmpleado(Empleado empleado) {
        Set<Servicio> servicios = new HashSet<>();  // Inicializamos la colección en vacío
        try {
            iniciaOperacion();
            String hql = "SELECT e FROM Empleado e JOIN FETCH e.servicios WHERE e.idPersona = :id";
            Empleado e = session.createQuery(hql, Empleado.class)
                                .setParameter("id", empleado.getIdPersona())
                                .uniqueResult();
            if (e != null) {
                servicios = e.getServicios();  // Si el empleado existe, asignamos los servicios
            }
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return servicios;  // Si no encontró servicios, devolverá un Set vacío
    }




}