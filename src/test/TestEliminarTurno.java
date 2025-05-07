package test;

import negocio.TurnoABM;

public class TestEliminarTurno {
    public static void main(String[] args) {
        TurnoABM abm = new TurnoABM();
        boolean resultado = abm.eliminarTurno(1); // cambiar ID
        System.out.println("Turno eliminado: " + resultado);
    }
}