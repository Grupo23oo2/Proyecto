package datos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    private boolean presencial;
    private Lugar lugarServicio;
    private LocalDateTime fechaHora;
    private String estadoServicio;
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    public Servicio(int idServicio, boolean presencial, Lugar lugarServicio, LocalDateTime fechaHora, String estadoServicio,
                    Cliente cliente, Empleado empleado) {
        this.idServicio = idServicio;
        this.presencial = presencial;
        this.lugarServicio = lugarServicio;
        this.fechaHora = fechaHora;
        this.estadoServicio = estadoServicio;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Servicio(boolean presencial, Lugar lugarServicio, LocalDateTime fechaHora, String estadoServicio,
                    Cliente cliente, Empleado empleado) {
        this.presencial = presencial;
        this.lugarServicio = lugarServicio;
        this.fechaHora = fechaHora;
        this.estadoServicio = estadoServicio;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Servicio() {}

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
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

    public void setLugarServicio(Lugar lugarServicio) {
        this.lugarServicio = lugarServicio;
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

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }
}
