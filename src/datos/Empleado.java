package datos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")

public class Empleado extends Persona{
    private String rol;

    public Empleado(int idPersona, String nombre, String apellido, String dni, String rol) {
		super(idPersona, nombre, apellido, dni);
		this.rol = rol;
	}
    
    public Empleado() {}
    

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

	@Override
	public String toString() {
		return "Empleado [rol=" + rol + ", idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", dni=" + dni + "]";
	}




	
}