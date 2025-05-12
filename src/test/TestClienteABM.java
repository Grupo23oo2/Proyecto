package test;

import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import datos.Contacto;
import datos.Servicio;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestClienteABM {
	public static void main(String[] args) {

		ClienteABM clienteABM = new ClienteABM();
		ContactoABM contactoABM = new ContactoABM();
		
		try {
			// 1. Agregar un nuevo cliente
			Cliente nuevo = new Cliente("cucu", "zaza", "12345678", "contador", null, new HashSet());
			Contacto contacto = new Contacto("zabaleta", "morrison@gmail.com", "1123447565");
			nuevo.setContacto(contacto);
			contacto.setCliente(nuevo);
			clienteABM.agregarCliente(nuevo);			
			contactoABM.agregarContacto(contacto);

            System.out.println("Cliente guardado: " + nuevo);

          //2- Traer el cliente por dni
            Cliente c = clienteABM.traerCliente(nuevo.getIdPersona());
            System.out.println("Cliente por id: " + c);

            //3- Modificar cliente
            Contacto contactoAModificar = new Contacto(1,"gerli", "referi@gmail.com", "116542565");
             clienteABM.modificarCliente(c.getIdPersona(), "antonio", "referi", "234234234", "202342342340");
            System.out.println("Cliente modificado: " + clienteABM.traerCliente(c.getIdPersona()));

            //4- Eliminar al cliente
            clienteABM.eliminarCliente(c.getIdPersona());
            System.out.println("Cliente eliminado.");

            //5- Traer servicios del cliente
            Set<Servicio> servicios = clienteABM.traerServiciosDeCliente(c);
            System.out.println("Servicios del cliente:");
            for (Servicio s : servicios) {
                System.out.println(s);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		
		

	}

}
