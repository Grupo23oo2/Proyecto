package test;

import negocio.ClienteABM;

public class TestEliminarCliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
        boolean resultado = abm.eliminarCliente(1); // cambiar ID
        System.out.println("Cliente eliminado: " + resultado);
	}

}
