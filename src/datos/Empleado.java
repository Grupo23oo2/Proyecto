package datos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado extends Persona{

    private String rol;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)  // mappedBy debe coincidir con el atributo en la clase Turno
    private Set<Turno> turnos = new HashSet<>();  // Relación 1:N con Turno
    
   
    
    public Empleado(int idPersona, String nombre, String apellido, String dni, String rol, Set<Turno> turnos) {
		super(idPersona, nombre, apellido, dni);
		this.rol = rol;
		this.turnos = turnos;
	}
    
    public Empleado(String nombre, String apellido, String dni, String rol, Set<Turno> turnos) {
		super(nombre, apellido, dni);
		this.rol = rol;
		this.turnos = turnos;
	}
    
    public Empleado(String nombre, String apellido, String dni, String rol) {
		super(nombre, apellido, dni);
		this.rol = rol;
	}

    
    public Empleado(){}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	

	
    

	

	
}