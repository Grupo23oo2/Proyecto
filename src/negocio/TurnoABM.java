package negocio;

import dao.TurnoDao;
import datos.Turno;
import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoABM {

    private TurnoDao turnoDao= new TurnoDao();

    
    public boolean agregarTurno(Turno turno) {
        return turnoDao.agregarTurno(turno);
    }

    public Turno traerTurno(int idTurno) {
        return turnoDao.traerTurno(idTurno);
    }
    

    public boolean eliminarTurno(int idTurno) {
        return turnoDao.eliminarTurno(idTurno);
    }

    public boolean modificarTurno(int idTurno, LocalDate fechaTurno, LocalTime horaTurno) {
        Turno turno = turnoDao.traerTurno(idTurno);
        if (turno != null) {
            turno.setFechaHora(fechaTurno.atTime(horaTurno));
            return turnoDao.modificarTurno(turno);
        }
        return false;
    }
}
