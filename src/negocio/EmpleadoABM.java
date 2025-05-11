package negocio;

import dao.EmpleadoDao;
import datos.Cliente;
import datos.Contacto;
import datos.Empleado;
import datos.Servicio;

import java.util.HashSet;
import java.util.Set;

public class EmpleadoABM {

    private EmpleadoDao dao = new EmpleadoDao();

    public boolean agregarEmpleado(Empleado e) {
        return dao.agregarEmpleado(e);
    }

    public boolean agregarEmpleado(String nombre, String apellido, String dni, String rol) {
		Empleado e = new Empleado(nombre, apellido, dni, rol, new HashSet<>());
		return dao.agregarEmpleado(e);
	}
    
    public boolean modificarEmpleado(int idPersona, String nuevoNombre, String nuevoRol, String nuevoApellido, String nuevoDni) {
        return dao.modificarEmpleado(idPersona, nuevoNombre, nuevoRol, nuevoApellido, nuevoDni);
    }

    public boolean eliminarEmpleado(int idEmpleado) {
        return dao.eliminarEmpleado(idEmpleado);
    }

    public Empleado traerEmpleado(int idEmpleado) {
        return dao.traerEmpleado(idEmpleado);
    }

    public Set<Servicio> traerServicio(Empleado e) {
        return dao.traerTurnosDeEmpleado(e);
    }
}
