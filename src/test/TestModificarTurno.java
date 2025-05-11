package test;

import negocio.ServicioABM;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestModificarTurno {
    public static void main(String[] args) {
        ServicioABM abm = new ServicioABM();
        boolean resultado = abm.modificarServicio(1, LocalDate.of(2025, 5, 5), LocalTime.of(14, 0));
        System.out.println("Turno modificado: " + resultado);
    }
}