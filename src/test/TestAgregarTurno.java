package test;

import java.time.LocalDateTime;
import java.util.HashSet;

import datos.Cliente;
import datos.Contacto;
import datos.Empleado;
import datos.Lugar;
import datos.Servicio;
import negocio.ClienteABM;
import negocio.ContactoABM;
import negocio.EmpleadoABM;
import negocio.LugarABM;
import negocio.ServicioABM;

public class TestAgregarTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServicioABM servicioABM = new ServicioABM();
		LugarABM lugarABM = new LugarABM();
		ContactoABM contactoABM = new ContactoABM();
		ClienteABM clienteABM = new ClienteABM();
		EmpleadoABM empleadoABM = new EmpleadoABM();
		
		Lugar lugar = new Lugar("Av. Siempre Viva 123");
		lugarABM.agregarLugar(lugar);
		
		Contacto contacto = new Contacto(1, "wilde", "pepito@gmail.com", "1123447565");
		Cliente cliente = new Cliente(1, "pepito", "gonzalez", "34824712", "20348247120", contacto, new HashSet<>());
		Empleado empleado = new Empleado(2, "raul", "fernandez", "45756987", "medico", new HashSet<>());
		//contacto.setCliente(cliente);
		//turno.setLugar(lugar);
		
		contactoABM.agregarContacto(contacto);
		clienteABM.agregarCliente(cliente);
		empleadoABM.agregarEmpleado(empleado);
		
		Servicio servicio = new Servicio(true, lugar, empleado, cliente, LocalDateTime.of(2024, 4, 1, 14, 30), LocalDateTime.of(2024, 4, 1, 13, 00));

		int resultado = servicioABM.agregarServicio(servicio);
		
		System.out.println("Cliente agregado: " + resultado);
	}

}
