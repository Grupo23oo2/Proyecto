package datos;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
@Table(name = "cliente")

public class Cliente extends Persona{
    private String cuit;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idContacto") // clave foránea en la tabla cliente
    private Contacto contacto;

    public Cliente(int idPersona, String nombre, String apellido, String dni, String cuit, Contacto contacto) {
		super(idPersona, nombre, apellido, dni);
		this.cuit = cuit;
		this.contacto = contacto;
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



	
}