package datos;

import java.time.LocalDateTime;

public class Servicio {
    private int idServicio;
    private boolean presencial;
    private Lugar lugarServicio;
    private Empleado empleado;
    private Cliente cliente;
    private LocalDateTime fechaHora;

    public Servicio() {}

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idTurno) {
        this.idServicio = idTurno;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public Lugar getLugarServicio() {
        return lugarServicio;
    }

    public void setLugarServicio(Lugar lugarTurno) {
        this.lugarServicio = lugarTurno;
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

}
