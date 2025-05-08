package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import datos.Agenda;
import datos.Turno;
import negocio.AgendaABM;

public class TestAgendaABM {

	public static void main(String[] args) {
		AgendaABM agendaABM = new AgendaABM();
		
		// Crear una nueva Agenda sin turnos
        Agenda nuevaAgenda = new Agenda(LocalDateTime.of(2025, 5, 10, 15, 0), new ArrayList<>());

        // Agregar agenda
        boolean agregada = agendaABM.agregarAgenda(nuevaAgenda);
        System.out.println("Agenda agregada: " + agregada + ", ID: " + nuevaAgenda.getIdAgenda());

  /*      // Eliminar agenda
        boolean eliminada = agendaABM.eliminarAgenda(nuevaAgenda.getIdAgenda());
        System.out.println("Agenda eliminada: " + eliminada);*/
		
        LocalDateTime desde = LocalDateTime.of(2025, 5, 1, 0, 0); // Fecha de inicio
        LocalDateTime hasta = LocalDateTime.of(2025, 5, 7, 23, 59); // Fecha de fin

        Set<Turno> turnosConfirmados = (Set<Turno>) agendaABM.traerTurnosConfirmados(desde, hasta);

        for (Turno turno : turnosConfirmados) {
            System.out.println("Turno confirmado: " + turno);
        }
        

	}

}