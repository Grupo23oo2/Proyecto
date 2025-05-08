package datos;

import javax.persistence.*;

@Entity
@Table(name = "contacto")

public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContacto;
    
    private String email;
    private String telefono;

    public Contacto() {}

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
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
}
