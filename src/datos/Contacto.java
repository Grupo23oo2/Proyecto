package datos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContacto;
    private String direccion;
    private String email;
    private String telefono;

    //Relación 1 a 1 con Cliente
    // @OneToOne(mappedBy = "contacto")
    //private Cliente cliente;
    
    public Contacto() {}
    
	public Contacto(long idContacto, String direccion, String email, String telefono) {
		super();
		this.idContacto = idContacto;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		//this.cliente = cliente;
	}
	
	public Contacto(String direccion, String email, String telefono) {
		super();
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		//this.cliente = cliente;
	}

	public long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
	// Getter y Setter para cliente
    /*public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }*/
}
