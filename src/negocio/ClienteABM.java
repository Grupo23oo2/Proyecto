package negocio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;
import datos.Servicio;

public class ClienteABM {
	private ClienteDao clienteDao;

	public ClienteABM() {
		this.clienteDao = new ClienteDao();
	}

	public boolean agregarCliente(Cliente cliente) {
		return clienteDao.agregarCliente(cliente);
	}
	
	public boolean agregarCliente(String nombre, String apellido, String dni, String cuit, Contacto contacto) {
		Cliente c = new Cliente(nombre, apellido, dni, cuit, contacto, new HashSet<>());
		return clienteDao.agregarCliente(c);
	}

	public Cliente traerCliente(long idCliente) {
		return clienteDao.traerCliente(idCliente);
	}

	public boolean eliminarCliente(int idCliente) {
		return clienteDao.eliminarCliente(idCliente);
	}

	public boolean modificarCliente(int idPersona, String nuevoNombre, String nuevoApellido, String nuevoDni,
			String nuevoCuit, Contacto nuevoContacto) {
		return clienteDao.modificarCliente(idPersona, nuevoNombre, nuevoApellido, nuevoDni, nuevoCuit, nuevoContacto);
	}

	public Set<Servicio> traerTurnosDeCliente(Cliente cliente) {
		return clienteDao.traerTurnosDeCliente(cliente);
	}
}
