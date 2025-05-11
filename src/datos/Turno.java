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
@Table(name = "turno")
public class Turno {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;
    private boolean presencial;
    private Lugar lugarTurno;
    private LocalDateTime fechaHora;
    private String estadoTurno;
    private Empleado cliente;
    
    @ManyToOne
    @JoinColumn(name = "idEmpleado")  // Asegúrate de que el nombre de la columna coincida con el de la base de datos
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "idAgenda")  // Establece la columna que representa la clave foránea
    private Agenda agenda;
    
    public Turno(int idTurno, boolean presencial, Lugar lugarTurno, LocalDateTime fechaHora, String estadoTurno,
			Empleado cliente, Empleado empleado, Agenda agenda) {
		super();
		this.idTurno = idTurno;
		this.presencial = presencial;
		this.lugarTurno = lugarTurno;
		this.fechaHora = fechaHora;
		this.estadoTurno = estadoTurno;
		this.cliente = cliente;
		this.empleado = empleado;
		this.agenda = agenda;
	}
    
    public Turno(boolean presencial, Lugar lugarTurno, LocalDateTime fechaHora, String estadoTurno, Empleado cliente,
			Empleado empleado, Agenda agenda) {
		super();
		this.presencial = presencial;
		this.lugarTurno = lugarTurno;
		this.fechaHora = fechaHora;
		this.estadoTurno = estadoTurno;
		this.cliente = cliente;
		this.empleado = empleado;
		this.agenda = agenda;
	}
    
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

    public Empleado getCliente() {
		return cliente;
	}

	public void setCliente(Empleado cliente) {
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

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
    
}
