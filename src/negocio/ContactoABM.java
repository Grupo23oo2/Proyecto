package negocio;


import dao.ContactoDao;
import datos.Contacto;

public class ContactoABM {
    private ContactoDao dao = new ContactoDao();

    public boolean agregarContacto(Contacto c) {
        try {
            dao.save(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Contacto traerContacto(int id) {
        return dao.get(id);
    }

    public boolean eliminarContacto(int id) {
        Contacto c = dao.get(id);
        if (c != null) {
            dao.delete(c);
            return true;
        }
        return false;
    }

    public boolean modificarContacto(Contacto c) {
        try {
            dao.update(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}