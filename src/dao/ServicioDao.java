package dao;

import java.time.LocalDateTime;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Servicio;

public class ServicioDao {
	
	public boolean agregarServicio(Servicio servicio) {
	    boolean resultado = false;
	    Transaction tx = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        // Iniciar una nueva transacción
	        tx = session.beginTransaction();

	        // Guardar el servicio en la base de datos
	        session.save(servicio);

	        // Confirmar la transacción
	        tx.commit();

	        // Si todo sale bien, asignar true a resultado
	        resultado = true;
	    } catch (Exception e) {
	        // En caso de error, revertir la transacción
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }
	    return resultado;
	}
	
	public Servicio traerServicio(int idServicio) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Servicio servicio = session.get(Servicio.class, idServicio);

	        if (servicio != null) {
	            // Inicializamos relaciones antes de cerrar la sesión
	            Hibernate.initialize(servicio.getLugarServicio());
	            Hibernate.initialize(servicio.getCliente());
	            Hibernate.initialize(servicio.getEmpleado());
	            if (servicio.getCliente() != null) {
	                Hibernate.initialize(servicio.getCliente().getServicios());
	            }

	            if (servicio.getEmpleado() != null) {
	                Hibernate.initialize(servicio.getEmpleado().getServicios());
	            }
	        }

	        return servicio;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	public Servicio traerServicioPorFechaYHorario(LocalDateTime fechaHoraInicio) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        // Realizamos una consulta para buscar el servicio por fecha y hora
	        Query<Servicio> query = session.createQuery(
	            "FROM Servicio WHERE fechaHoraInicio = :fechaHoraInicio", Servicio.class);
	        query.setParameter("fechaHoraInicio", fechaHoraInicio);
	        
	        // Ejecutar la consulta y obtener el servicio
	        Servicio servicio = query.uniqueResult(); // Obtiene un solo resultado o null si no existe
	        
	        return servicio;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
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

    public boolean modificarServicio(int idServicio, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Servicio servicio = session.get(Servicio.class, idServicio);
            if (servicio == null) return false;

            tx = session.beginTransaction();

            servicio.setFechaHoraInicio(fechaHoraInicio);
            servicio.setFechaHoraFin(fechaHoraFin);

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