package test;

import datos.Lugar;
import datos.Servicio;
import negocio.LugarABM;

import java.util.Set;

public class TestTraerServiciosPorLugar {
    public static void main(String[] args) {
        LugarABM abm = new LugarABM();

        int idLugar = 1; // Cambiá esto por un ID válido de tu base de datos
        Lugar lugar = abm.traerLugar(idLugar);

        if (lugar != null) {
            Set<Servicio> servicios = abm.traerServiciosPorLugar(lugar);

            System.out.println("Servicios en el lugar con ID " + idLugar + ":");
            if (servicios != null && !servicios.isEmpty()) {
                for (Servicio s : servicios) {
                    System.out.println(s);
                }
            } else {
                System.out.println("No hay servicios asociados.");
            }
        } else {
            System.out.println("No se encontró un lugar con ID " + idLugar);
        }
    }
}
