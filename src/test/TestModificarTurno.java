package test;

import negocio.TurnoABM;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestModificarTurno {
    public static void main(String[] args) {
        TurnoABM abm = new TurnoABM();
        boolean resultado = abm.modificarTurno(1, LocalDate.of(2025, 5, 5), LocalTime.of(14, 0));
        System.out.println("Turno modificado: " + resultado);
    }
}