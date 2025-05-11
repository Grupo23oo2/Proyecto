package datos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idPersona")
public class Cliente extends Persona{
    private String cuit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacto_id")
    private Contacto contacto;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Servicio> servicios = new HashSet<>();
    
    public Cliente() {}

    public Cliente(int idPersona, String nombre, String apellido, String dni, String cuit, Contacto contacto, Set<Servicio> servicios) {
		super(idPersona, nombre, apellido, dni);
		this.cuit = cuit;
		this.contacto = contacto;
		this.servicios = servicios;
	}

    public Cliente(String nombre, String apellido, String dni, String cuit, Contacto contacto, Set<Servicio> servicios) {
		super(nombre, apellido, dni);
		this.cuit = cuit;
		this.contacto = contacto;
		this.servicios = servicios;
	}
    
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
}