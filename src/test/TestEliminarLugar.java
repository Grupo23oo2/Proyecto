package test;

import negocio.LugarABM;

public class TestEliminarLugar {
    public static void main(String[] args) {
        LugarABM abm = new LugarABM();
        boolean resultado = abm.eliminarLugar(1); // cambiar ID
        System.out.println("Lugar eliminado: " + resultado);
    }
}
