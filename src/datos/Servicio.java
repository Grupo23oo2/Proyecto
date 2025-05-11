package datos;

import java.time.LocalDateTime;

public class Turno {
    private int idTurno;
    private boolean presencial;
    private Lugar lugarTurno;
    private Empleado empleado;
    private Cliente cliente;
    private LocalDateTime fechaHora;
    private String estadoTurno;

    public Turno() {}

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public Lugar getLugarTurno() {
        return lugarTurno;
    }

    public void setLugarTurno(Lugar lugarTurno) {
        this.lugarTurno = lugarTurno;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = estadoTurno;
    }
}
