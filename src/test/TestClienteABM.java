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
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		ContactoABM contactoABM = new ContactoABM();
		
		try {
			//1- Agregar un nuevo cliente
			//Contacto contacto = new Contacto(1,"wilde", "pepito@gmail.com", "1123447565", null); -----ANTES
			Cliente nuevo = new Cliente(1,"pepito", "gonzalez", "123456789", "56756756453", null, new HashSet<>());
			//Contacto contacto = new Contacto(1,"wilde", "pepito@gmail.com", "1123447565");
			
			contactoABM.agregar("wilde", "pepito@gmail.com", "1123447565");
			
			//contacto.setCliente(nuevo);
			
			//contacto.setCliente(nuevo); // Esto mantiene la relación bidireccional coherente
			nuevo.setContacto(contactoABM.traer(1)); // Fundamental			
			
			boolean resultado = clienteABM.agregarCliente(nuevo);
			
			System.out.println("Cliente agregado: " + resultado);
			/*
			//2- Traer el cliente por dni
			Cliente c = clienteABM.traerCliente(nuevo.getDni());
            System.out.println("Cliente por dni: " + c);
            
            //3- Modificar cliente
            Contacto contactoAModificar = new Contacto(1,"gerli", "referi@gmail.com", "116542565");
 			clienteABM.modificarCliente(c.getIdPersona(), "antonio", "referi", "234234234", "202342342340", contactoAModificar);
            System.out.println("Cliente modificado: " + clienteABM.traerCliente("234234234"));
            
            //4- Eliminar al cliente
            clienteABM.eliminarCliente(c.getIdPersona());
            System.out.println("Cliente eliminado.");
            
            //5- Traer servicios del cliente
            Set<Servicio> servicios = clienteABM.traerTurnosDeCliente(c);
            System.out.println("Servicios del cliente:");
            for (Servicio s : servicios) {
                System.out.println(s);
            }
            */
		} catch (Exception ex) {
			ex.printStackTrace();
        }	
	}
}