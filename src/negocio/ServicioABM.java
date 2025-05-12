package negocio;

import dao.HibernateUtil;
import dao.ServicioDao;
import datos.Servicio;
import java.time.LocalDateTime;


import org.hibernate.Session;
import org.hibernate.query.Query;

public class ServicioABM {

    private ServicioDao servicioDao;

    public ServicioABM() {
        this.servicioDao = new ServicioDao();
    }
    
    public boolean agregarServicioABM(Servicio servicio) {
        return servicioDao.agregarServicio(servicio);
    }

    public boolean eliminarServicio(int idServicio) {
        return servicioDao.eliminarServicio(idServicio);
    }

    public boolean modificarServicio(int idServicio, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Servicio servicio = servicioDao.traerServicio(idServicio);
        if (servicio != null) {
            servicio.setFechaHoraInicio(fechaHoraInicio);
            return servicioDao.modificarServicio(idServicio,fechaHoraInicio,fechaHoraFin);
        }
        return false;
    }
    
    public Servicio traerServicio(int idServicio) {
        return servicioDao.traerServicio(idServicio);  // Llamada al método en el Dao
    }
    
    public Servicio traerServicioPorFechaYHorario(LocalDateTime fechaHora) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Realizamos una consulta para buscar el servicio por fecha y hora
            Query<Servicio> query = session.createQuery(
                "FROM Servicio WHERE fechaHora = :fechaHora", Servicio.class);
            query.setParameter("fechaHora", fechaHora);
            
            // Ejecutar la consulta y obtener el servicio
            Servicio servicio = query.uniqueResult(); // Obtiene un solo resultado o null si no existe
            
            return servicio;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
