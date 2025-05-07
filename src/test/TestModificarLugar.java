package test;

import negocio.LugarABM;
import datos.Lugar;

public class TestModificarLugar {
    public static void main(String[] args) {
        LugarABM abm = new LugarABM();
        Lugar lugar = abm.traerLugar(1); // cambiar ID
        if (lugar != null) {
            lugar.setDireccion("Nueva dirección 456");
            boolean resultado = abm.modificarLugar(lugar);
            System.out.println("Lugar modificado: " + resultado);
        } else {
            System.out.println("Lugar no encontrado");
        }
    }
}