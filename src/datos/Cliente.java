package datos;

public class Cliente extends Persona{
    private String cuit;
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