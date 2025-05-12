package test;

import negocio.LugarABM;

import java.util.HashSet;
import java.util.Set;

import datos.Lugar;
import datos.Servicio;

public class TestAgregarLugar {
    public static void main(String[] args) {
        LugarABM abm = new LugarABM();
        
        try {
        Lugar lugar = new Lugar("Av. Siempre Viva 123",new HashSet());
        boolean resultado = abm.agregarLugar(lugar);
        System.out.println("Lugar agregado: " + resultado);
        
     // 4. Traer turnos del empleado
        Set<Servicio> servicios = abm.traerServiciosPorLugar(lugar);
        System.out.println("Turnos del lugar:");
        for (Servicio t : servicios) {
            System.out.println(t);
        }
        
        
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}