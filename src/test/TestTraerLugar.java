package test;

import negocio.LugarABM;
import datos.Lugar;

public class TestTraerLugar {
    public static void main(String[] args) {
        LugarABM abm = new LugarABM();
        Lugar lugar = abm.traerLugar(1); // cambiar ID según el que quieras buscar
        System.out.println(lugar != null ? "Lugar encontrado: " + lugar.getDireccion() : "No se encontró el lugar");
    }
}
