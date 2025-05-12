package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Lugar;
import datos.Servicio;

public class LugarDao {
	
	public boolean agregarLugar(Lugar lugar) {
        Transaction tx = null;
        boolean exito = false; // Variable para el retorno
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(lugar); // No necesitamos capturar el id si solo nos interesa el éxito
            tx.commit();
            exito = true; // Si llega aquí es porque se completó con éxito
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al agregar Lugar: " + e.getMessage());
            e.printStackTrace();
        }
        return exito; // Retorna el estado final
    }

    public Lugar traerLugar(int idLugar) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Lugar.class, idLugar);
        }
    }

    public boolean eliminarLugar(int idLugar) {
        Transaction tx = null;
        boolean exito = false; // Variable para el retorno
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Lugar lugar = session.get(Lugar.class, idLugar);
            if (lugar == null) return false; // Si no existe, retorna false
            tx = session.beginTransaction();
            session.delete(lugar);
            tx.commit();
            exito = true; // Si todo fue bien, actualizamos el estado
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al eliminar Lugar: " + e.getMessage());
            e.printStackTrace();
        }
        return exito; // Retorna el estado final
    }

    public boolean modificarLugar(int idLugar, String nuevaDireccion) {
        Transaction tx = null;
        boolean exito = false; // Variable para el retorno
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Obtener el lugar actual usando el id
            Lugar lugar = session.get(Lugar.class, idLugar);
            
            if (lugar == null) {
                return false; // Si no existe el lugar, retornamos false
            }

            // Modificar los atributos del lugar
            lugar.setDireccion(nuevaDireccion); // Suponiendo que el Lugar tiene un método setDireccion
            
            tx = session.beginTransaction();
            session.update(lugar); // Persistimos los cambios en la base de datos
            tx.commit();
            exito = true; // Si llegamos aquí, significa que la operación fue exitosa
        } catch (Exception e) {
            if (tx != null) tx.rollback(); // En caso de error, hacemos rollback
            System.err.println("Error al modificar Lugar: " + e.getMessage());
            e.printStackTrace();
        }
        return exito; // Retornamos el estado final
    }
    
    public Set<Servicio> traerServiciosPorLugar(Lugar lugar) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Servicio s where s.lugarServicio = :lugar";
            Query<Servicio> query = session.createQuery(hql, Servicio.class);
            query.setParameter("lugar", lugar);
            List<Servicio> servicios = query.getResultList();
            return new HashSet<>(servicios);
        }
    }
}
    
    
