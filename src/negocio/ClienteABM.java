package negocio;

import java.util.Set;

import dao.ClienteDao;
import datos.Cliente;
import datos.Servicio;

public class ClienteABM {
    private ClienteDao clienteDao = new ClienteDao();

    // Agregar un nuevo cliente
    public boolean agregarCliente(Cliente cliente) {
        return clienteDao.agregarCliente(cliente);
    }

    // Modificar los datos de un cliente
    public boolean modificarCliente(int idPersona, String nuevoNombre, String nuevoApellido, String nuevoDni, String nuevoCuit) {
        return clienteDao.modificarCliente(idPersona, nuevoNombre, nuevoApellido, nuevoDni, nuevoCuit);
    }

    // Eliminar un cliente
    public boolean eliminarCliente(int idPersona) {
        return clienteDao.eliminarCliente(idPersona);
    }

    // Traer un cliente por su ID
    public Cliente traerCliente(int idPersona) {
        return clienteDao.traerCliente(idPersona);
    }

    // Obtener los servicios asociados a un cliente
    public Set<Servicio> traerServiciosDeCliente(Cliente cliente) {
        return clienteDao.traerServiciosDeCliente(cliente);
    }
}