package datos;

import java.util.HashSet;
import java.util.Set;




public class Empleado extends Persona{

    private String rol;
    private Set<Servicio> servicios = new HashSet<>();  // Relación 1:N con Turno
    
    public Empleado(int idPersona, String nombre, String apellido, String dni, String rol, Set<Servicio> servicios) {
		super(idPersona, nombre, apellido, dni);
		this.rol = rol;
		this.servicios = servicios;
	}
    
    public Empleado(String nombre, String apellido, String dni, String rol, Set<Servicio> servicios) {
		super(nombre, apellido, dni);
		this.rol = rol;
		this.servicios = servicios;
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

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}

	

	
    

	

	
}