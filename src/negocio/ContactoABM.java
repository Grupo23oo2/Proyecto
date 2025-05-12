package negocio;


import dao.ContactoDao;
import datos.Contacto;

public class ContactoABM {
    private ContactoDao dao = new ContactoDao();

    public boolean agregarContacto(Contacto contacto) {
        return dao.agregarContacto(contacto);
    }

    public Contacto traerContacto(int idContacto) {
        return dao.traerContacto(idContacto);
    }

    public boolean eliminarContacto(int idContacto) {
        return dao.eliminarContacto(idContacto);
    }

    public boolean modificarContacto(int idContacto, String nuevaDireccion, String nuevoEmail, String nuevoTelefono) {
        return dao.modificarContacto(idContacto, nuevaDireccion, nuevoEmail, nuevoTelefono);
    }
}
