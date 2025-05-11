package dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Contacto;
import datos.Servicio;

public class ClienteDao {
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
	
	public Cliente traerCliente(long idCliente) {
		Cliente cliente = null;
	    try {
	        iniciaOperacion();
	        cliente = (Cliente) session.get(Cliente.class, idCliente);
	        if (cliente == null) {
	            System.out.println("No se encontró ningún cliente con id: " + idCliente);
	        }
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	    } finally {
	        session.close();
	    }
	    return cliente;
	}

	public boolean modificarCliente(int idPersona, String nuevoNombre, String nuevoApellido, String nuevoDni, String nuevoCuit, Contacto nuevoContacto) {
	    boolean resultado = false;
	    try {
	        iniciaOperacion();
	        Cliente cliente = session.get(Cliente.class, idPersona);
	        if (cliente != null) {
	        	cliente.setNombre(nuevoNombre);
	        	cliente.setApellido(nuevoApellido);
	        	cliente.setDni(nuevoDni);
	        	cliente.setCuit(nuevoCuit);
	        	cliente.setContacto(nuevoContacto);
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

	public Set<Servicio> traerTurnosDeCliente(Cliente cliente) {
	    Set<Servicio> turnos = new HashSet<>();
	    try {
	        iniciaOperacion();
	        String hql = "SELECT c FROM Cliente c JOIN FETCH c.servicios WHERE c.idPersona = :id";
	        Cliente c = session.createQuery(hql, Cliente.class)
	                            .setParameter("id", cliente.getIdPersona())
	                            .uniqueResult();
	        if (c != null) {
	            turnos = c.getServicios();
	        }
	        tx.commit();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	    return turnos;
	}
}