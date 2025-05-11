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

    public boolean eliminarServicio(int idServicio) {
        return servicioDao.eliminarServicio(idServicio);
    }

    public boolean modificarServicio(int idServicio, LocalDate fechaServicio, LocalTime horaServicio) {
        Servicio servicio = servicioDao.traerServicio(idServicio);
        if (servicio != null) {
            servicio.setFechaHora(fechaServicio.atTime(horaServicio));
            return servicioDao.modificarServicio(servicio);
        }
        return false;
    }
}
