package datos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Servicio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    private boolean presencial;
    @ManyToOne
    @JoinColumn(name = "idLugar")
    private Lugar lugarServicio;
    
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
   
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    
    public Servicio() {}
    
    public Servicio(int idServicio, boolean presencial, Lugar lugarServicio, Empleado empleado, Cliente cliente, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
		super();
		this.idServicio = idServicio;
		this.presencial = presencial;
		this.lugarServicio = lugarServicio;
		this.empleado = empleado;
		this.cliente = cliente;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
	}

	public Servicio(boolean presencial, Lugar lugarServicio, Empleado empleado, Cliente cliente, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
		super();
		this.presencial = presencial;
		this.lugarServicio = lugarServicio;
		this.empleado = empleado;
		this.cliente = cliente;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
	}

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

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
}
