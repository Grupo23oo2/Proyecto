package dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Servicio;

public class ClienteDao {
    private static Session session;
    private Transaction tx;	

    // Método para iniciar la transacción
    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Método para manejar excepciones
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    // Agregar un cliente
    public boolean agregarCliente(Cliente cliente) {
        boolean resultado = false;
        try {
            iniciaOperacion();
            session.save(cliente);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return resultado;
    }

    // Modificar un cliente
    public boolean modificarCliente(int idPersona, String nuevoNombre, String nuevoApellido, String nuevoDni, String nuevoCuit) {
        boolean resultado = false;
        try {
            iniciaOperacion();
            Cliente cliente = session.get(Cliente.class, idPersona);
            if (cliente != null) {
                cliente.setNombre(nuevoNombre);
                cliente.setApellido(nuevoApellido);
                cliente.setDni(nuevoDni);
                cliente.setCuit(nuevoCuit);
                session.update(cliente);
                tx.commit();
                resultado = true;
            } else {
                System.out.println("Cliente no encontrado");
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return resultado;
    }

    // Eliminar un cliente
    public boolean eliminarCliente(int idPersona) {
        boolean resultado = false;
        try {
            iniciaOperacion();
            Cliente cliente = session.get(Cliente.class, idPersona);
            if (cliente != null) {
                session.delete(cliente);
                tx.commit();
                resultado = true;
            } else {
                System.out.println("Cliente no encontrado con ID: " + idPersona);
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return resultado;
    }

    // Traer un cliente por ID
    public Cliente traerCliente(int idPersona) {
        Cliente cliente = null;
        try {
            iniciaOperacion();
            cliente = session.get(Cliente.class, idPersona);
            if (cliente == null) {
                System.out.println("No se encontró ningún cliente con ID: " + idPersona);
            }Hibernate.initialize(cliente.getServicios());
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return cliente;
    }

    // Obtener los servicios de un cliente
    public Set<Servicio> traerServiciosDeCliente(Cliente cliente) {
        Set<Servicio> servicios = new HashSet<>();  // Inicializamos la colección en vacío
        try {
            iniciaOperacion();
            String hql = "SELECT c FROM Cliente c JOIN FETCH c.servicios WHERE c.idPersona = :id";
            Cliente c = session.createQuery(hql, Cliente.class)
                                .setParameter("id", cliente.getIdPersona())
                                .uniqueResult();
            if (c != null) {
                servicios = c.getServicios();  // Si el cliente existe, asignamos los servicios
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
