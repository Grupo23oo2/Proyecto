package negocio;

import dao.ServicioDao;
import datos.Servicio;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioABM {

    private ServicioDao servicioDao;

    public ServicioABM() {
        this.servicioDao = new ServicioDao();
    }

    public int agregarServicio(Servicio servicio) {
        return servicioDao.agregarServicio(servicio);
    }

    public Servicio traerServicio(int idServicio) {
        return servicioDao.traerServicio(idServicio);
    }

    public boolean eliminarServicio(int idServicio) {
        return servicioDao.eliminarServicio(idServicio);
    }

    public boolean modificarServicio(int idServicio, LocalDate fechaTurno, LocalTime horaTurno) {
        Servicio servicio = servicioDao.traerServicio(idServicio);
        if (servicio != null) {
            servicio.setFechaHoraInicio(fechaTurno.atTime(horaTurno));
            return servicioDao.modificarServicio(servicio);
        }
        return false;
    }
}
