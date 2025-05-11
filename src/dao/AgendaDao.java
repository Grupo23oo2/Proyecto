package dao;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Agenda;
import datos.Turno;

public class AgendaDao {

    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

 // Método para agregar una agenda
    public boolean agregarAgenda(Agenda agenda) {
        boolean resultado = false;
        try {
            iniciaOperacion();
            session.save(agenda);  // Guardamos la agenda en la BD
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return resultado;
    }

    // Método para traer turnos confirmados dentro de un rango de fechas
	    public Set<Turno> traerTurnosConfirmados(LocalDateTime desde, LocalDateTime hasta) {
	    	Set<Turno> turnosConfirmados = new HashSet<>();
	        try {
	            iniciaOperacion();
	            String hql = "FROM Turno t WHERE t.estadoTurno = :estado AND t.fechaHora BETWEEN :desde AND :hasta";
	            Query<Turno> query = session.createQuery(hql, Turno.class);

	            query.setParameter("estado", "CONFIRMADO");
	            query.setParameter("desde", desde); 
	            query.setParameter("hasta", hasta); 
	            
	            turnosConfirmados = new HashSet<>(query.list());
	           
	            System.out.println("Cantidad de turnos confirmados encontrados: " + turnosConfirmados.size());
	        } catch (HibernateException he) {
	            manejaExcepcion(he);
	        } finally {
	            session.close();
	        }
	        return turnosConfirmados;
	    }
	    
	    
	    
}