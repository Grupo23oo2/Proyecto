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
            System.err.println("Error al agregar contacto: " + e.getMessage());
            return false;
        }
    }

        
    public Contacto traerContacto(int id) {
        try {
            return dao.get(id);
        } catch (Exception e) {
            System.err.println("Error al traer contacto " + id + ": " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarContacto(int id) {
        try {
            Contacto c = dao.get(id);
            if (c != null) {
                dao.delete(c);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error al eliminar contacto " + id + ": " + e.getMessage());
            return false;
        }
    }

    public boolean modificarContacto(Contacto c) {
        try {
            dao.update(c);
            return true;
        } catch (Exception e) {
            System.err.println("Error al modificar contacto: " + e.getMessage());
            return false;
        }
    }
}
