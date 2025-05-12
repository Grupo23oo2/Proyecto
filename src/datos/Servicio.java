package datos;

import java.time.LocalDateTime;

public class Servicio {
    private int idServicio;
    private boolean presencial;
    private Lugar lugarServicio;
    private Empleado empleado;
    private Cliente cliente;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    
    public Servicio(int idServicio, boolean presencial, Lugar lugarServicio, Empleado empleado, Cliente cliente,
			LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
		super();
		this.idServicio = idServicio;
		this.presencial = presencial;
		this.lugarServicio = lugarServicio;
		this.empleado = empleado;
		this.cliente = cliente;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
	}

	public Servicio(boolean presencial, Lugar lugarServicio, Empleado empleado, Cliente cliente,
			LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
		super();
		this.presencial = presencial;
		this.lugarServicio = lugarServicio;
		this.empleado = empleado;
		this.cliente = cliente;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
	}
    

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
