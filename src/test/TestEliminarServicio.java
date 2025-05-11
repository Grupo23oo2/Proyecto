package test;

import negocio.ServicioABM;

public class TestEliminarServicio {
    public static void main(String[] args) {
        ServicioABM abm = new ServicioABM();
        boolean resultado = abm.eliminarServicio(1); // cambiar ID
        System.out.println("Servicio eliminado: " + resultado);
    }
}