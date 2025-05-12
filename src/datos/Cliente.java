package datos;

import java.util.HashSet;
import java.util.Set;



public class Cliente extends Persona{
    private String cuit;
    private Contacto contacto;
    private Set<Servicio> servicios = new HashSet<>();  // Relación 1:N con Turno
    
    public Cliente(int idPersona, String nombre, String apellido, String dni, String cuit, Contacto contacto,
			Set<Servicio> servicios) {
		super(idPersona, nombre, apellido, dni);
		this.cuit = cuit;
		this.contacto = contacto;
		this.servicios = servicios;
	}
    
    public Cliente(int idPersona, String nombre, String apellido, String dni, String cuit, Contacto contacto) {
		super(idPersona, nombre, apellido, dni);
		this.cuit = cuit;
		this.contacto = contacto;
	}
    
    
    public Cliente(String nombre, String apellido, String dni, String cuit, Contacto contacto,
			Set<Servicio> servicios) {
		super(nombre, apellido, dni);
		this.cuit = cuit;
		this.contacto = contacto;
		this.servicios = servicios;
	}
    
    

    public Cliente() {}

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }


	public Set<Servicio> getServicios() {
		return servicios;
	}


	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Cliente [cuit=" + cuit + ", contacto=" + contacto + ", servicios=" + servicios + ", idPersona="
				+ idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}



	

}