package negocio;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {
	private PersonaDao personaDao;

    public PersonaABM() {
        this.personaDao = new PersonaDao();
    }

    public int agregarLugar(Persona persona) {
        return personaDao.agregar(persona);
    }

    public Persona traer(int idPersona) {
        return personaDao.traer(idPersona);
    }

    public boolean eliminar(int idPersona) {
        return personaDao.eliminar(idPersona);
    }

    public boolean modificarPersona(Persona persona) {
        return personaDao.modificarPersona(persona);
    }
}