package datos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona{
    private String cuit;
    private Contacto contacto;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)  // mappedBy debe coincidir con el atributo en la clase Turno
    private Set<Turno> turnos = new HashSet<>();  // Relación 1:N con Turno
    
    public Cliente(int idPersona, String nombre, String apellido, String dni, String cuit, Contacto contacto,
			Set<Turno> turnos) {
		super(idPersona, nombre, apellido, dni);
		this.cuit = cuit;
		this.contacto = contacto;
		this.turnos = turnos;
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


	public Set<Turno> getTurnos() {
		return turnos;
	}


	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

    

	



}