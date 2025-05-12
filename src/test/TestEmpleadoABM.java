package test;

import datos.Empleado;
import datos.Servicio;
import negocio.EmpleadoABM;
import org.hibernate.SessionFactory;

import dao.HibernateUtil;

import java.util.Set;

import org.hibernate.Session;

public class TestEmpleadoABM {

	public static void main(String[] args) {
		EmpleadoABM abm = new EmpleadoABM();

        try {
            // 1. Agregar un nuevo empleado
            Empleado nuevo = new Empleado("Juan", "Pérez", "12345678", "Recepcionista");
            boolean agregado = abm.agregarEmpleado(nuevo);
            System.out.println("Empleado agregado " + agregado);

            // 2. Traer el empleado por ID
            Empleado e = abm.traerEmpleado(nuevo.getIdPersona());
            System.out.println("Empleado traído: " + e);
            
            
       /*     // PRUEBA DE MAPEO ENTRE EMPLEADO Y TURNO
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Empleado empleado = session.get(Empleado.class, e.getIdPersona());  // Trae el empleado por ID
            Set<Servicio> turnos1 = empleado.getServicios();  // Obtiene los turnos asociados
            System.out.println("Turnos del empleado: " + turnos1);
            session.close();         */ 
          

            // 3. Modificar empleado
            abm.modificarEmpleado(e.getIdPersona(), "Marta", "Sanchez", "23456789", "Asistente");
            System.out.println("Empleado modificado: " + abm.traerEmpleado(e.getIdPersona()));

            // 4. Traer turnos del empleado
            Set<Servicio> turnos = abm.traerServicio(e);
            System.out.println("Turnos del empleado:");
            for (Servicio t : turnos) {
                System.out.println(t);
            }
/*
            // 5. Eliminar al empleado
            abm.eliminarEmpleado(e.getIdPersona());
            System.out.println("Empleado eliminado.");
*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}