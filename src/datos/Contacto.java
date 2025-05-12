package datos;


public class Contacto {
    private int idContacto;
    private String direccion;
    private String email;
    private String telefono;
    private Cliente cliente;
    
    public Contacto(String direccion, String email, String telefono) {
		super();
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}
    
    
    public Contacto(int idContacto, String direccion, String email, String telefono) {
		super();
		this.idContacto = idContacto;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}
    
	
	
	public Contacto() {}

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	



	



	

}
