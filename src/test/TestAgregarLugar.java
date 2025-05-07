package test;

import negocio.LugarABM;
import datos.Lugar;

public class TestAgregarLugar {
    public static void main(String[] args) {
        LugarABM abm = new LugarABM();
        Lugar lugar = new Lugar("Av. Siempre Viva 123");
        int resultado = abm.agregarLugar(lugar);
        System.out.println("Lugar agregado: " + resultado);
    }
}