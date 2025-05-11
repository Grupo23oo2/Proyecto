package negocio;

import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {
	private ClienteDao clienteDao;

    public ClienteABM() {
        this.clienteDao = new ClienteDao();
    }

    public boolean agregarCliente(Cliente cliente) {
        return clienteDao.agregarCliente(cliente);
    }

    public Cliente traerCliente(String dni) {
        return clienteDao.traerCliente(dni);
    }
    
    public boolean eliminarCliente(int idCliente) {
        return clienteDao.eliminarCliente(idCliente);
    }

    public boolean modificarCliente(int idPersona, String nuevoNombre, String nuevoApellido, String nuevoDni, String nuevoCuit, Contacto nuevoContacto) {
		return clienteDao.modificarCliente(idPersona, nuevoNombre, nuevoApellido, nuevoDni, nuevoCuit, nuevoContacto);
	}
}


	