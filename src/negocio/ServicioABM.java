package negocio;

import dao.TurnoDao;
import datos.Turno;
import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoABM {

    private TurnoDao turnoDao;

    public TurnoABM() {
        this.turnoDao = new TurnoDao();
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
