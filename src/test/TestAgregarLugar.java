package test;

import negocio.LugarABM;

import java.util.HashSet;

import datos.Lugar;

public class TestAgregarLugar {
    public static void main(String[] args) {
        LugarABM abm = new LugarABM();
        
        try {
        Lugar lugar = new Lugar("Av. Siempre Viva 123",new HashSet());
        boolean resultado = abm.agregarLugar(lugar);
        System.out.println("Lugar agregado: " + resultado);
        
        
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}