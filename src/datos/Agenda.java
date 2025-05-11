package datos;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agenda")
public class Agenda {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgenda;

	@Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaHora;

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private Set<Turno> turnos;

	
    
    public Agenda(LocalDateTime fechaHora, List<Turno> turnos) {
		super();
		this.fechaHora = fechaHora;
		this.turnos = new HashSet<>();
	}
    
    public Agenda() {
    	
    }
    
    public Agenda(int idAgenda, LocalDateTime fechaHora, List<Turno> turnos) {
		this.idAgenda = idAgenda;
		this.fechaHora = fechaHora;
		this.turnos = new HashSet<>();
	}
    

	public int getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "Agenda [idAgenda=" + idAgenda + ", fechaHora=" + fechaHora + ", turnos=" + turnos + "]";
	}

	

	
    
    
   
}