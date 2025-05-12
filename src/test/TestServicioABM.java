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

public class TestServicioABM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClienteABM clienteABM = new ClienteABM();
		EmpleadoABM empleadoABM = new EmpleadoABM();
		ContactoABM contactoABM = new ContactoABM();
		LugarABM lugarABM = new LugarABM();
		ServicioABM servicioABM = new ServicioABM();
		
		Lugar lugar = new Lugar("Calle Falsa 123");
		lugarABM.agregarLugar(lugar);
		System.out.println("-------1-------");
		Cliente cliente = new Cliente("pepito", "gonzalez", "34824712", "20348247120", null, new HashSet<>());
		Contacto contacto = new Contacto(1, "wilde", "pepito@gmail.com", "1123447565");
		cliente.setContacto(contacto);
		System.out.println("-------2-------");
		contacto.setCliente(cliente);
		clienteABM.agregarCliente(cliente);
		contactoABM.agregarContacto(contacto);
		System.out.println("-------3-------");
		Empleado empleado = new Empleado(2, "raul", "fernandez", "45756987", "medico", new HashSet<>());

		
		System.out.println("-------4-------");
		empleadoABM.agregarEmpleado(empleado);
		
		Servicio servicio = new Servicio(true, lugar, empleado, cliente, LocalDateTime.of(2024, 4, 1, 14, 30), LocalDateTime.of(2024, 4, 1, 13, 00));

		boolean resultado = servicioABM.agregarServicioABM(servicio);
		
		System.out.println("Cliente agregado: " + resultado);
		
		
		
	}

}
