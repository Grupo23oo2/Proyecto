package negocio;

import java.time.LocalDateTime;
import java.util.Set;

import dao.AgendaDao;
import datos.Agenda;
import datos.Turno;

public class AgendaABM {

    private AgendaDao agendaDao= new AgendaDao();
    
 // Método para agregar una agenda
    public boolean agregarAgenda(Agenda agenda) {
        if (agenda == null) {
            throw new IllegalArgumentException("La agenda no puede ser nula");
        }
        // Validar la fecha y hora (si es necesario)
        if (agenda.getFechaHora() == null) {
            throw new IllegalArgumentException("La fecha y hora de la agenda son obligatorias");
        }
        // Aquí puedes agregar más validaciones según lo necesites

        return agendaDao.agregarAgenda(agenda);
    }

    // Método para eliminar una agenda
    public boolean eliminarAgenda(int idAgenda) {
        if (idAgenda <= 0) {
            throw new IllegalArgumentException("El ID de la agenda no es válido");
        }
        return agendaDao.eliminarAgenda(idAgenda);
    }


    public Set<Turno> traerTurnosConfirmados(LocalDateTime desde, LocalDateTime hasta) {
        return agendaDao.traerTurnosConfirmados(desde, hasta);
    }
    
    
}