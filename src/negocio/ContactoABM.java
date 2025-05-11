package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	ContactoDao dao = new ContactoDao();

	public Contacto traer(long idContacto) {
		Contacto c = dao.traer(idContacto);
		return c;
	}

	public int agregarContacto(Contacto contacto) {
		return dao.agregar(contacto);
	}

	public int agregar(String direccion, String email, String telefono) {
		// Lanzar excepción si el cliente ya tiene un contacto
		Contacto c = new Contacto(direccion, email, telefono);
		return dao.agregar(c);
	}

	public void modificar(Contacto c) {
		dao.actualizar(c);
	}

	public void eliminar(long idContacto) {
		Contacto c = dao.traer(idContacto);
		dao.eliminar(c);
	}
}