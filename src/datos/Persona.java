package datos;

import javax.persistence.*;

@MappedSuperclass

public abstract class Persona {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idPersona;  // El id será autoincremental y será heredado
	
	protected String nombre;
	protected String apellido;
	protected String dni;
	
	public Persona(int idPersona, String nombre, String apellido, String dni) {
		
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public Persona(){}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	
	
	
	
}
