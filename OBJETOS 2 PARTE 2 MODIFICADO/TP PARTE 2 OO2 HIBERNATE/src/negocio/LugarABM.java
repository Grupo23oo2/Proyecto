package negocio;

import dao.LugarDao;
import datos.Lugar;
import datos.Servicio;

import java.util.Set;

public class LugarABM {

    private LugarDao lugarDao;

    public LugarABM() {
        this.lugarDao = new LugarDao();
    }

    public int agregarLugar(Lugar lugar) {
        return lugarDao.agregarLugar(lugar);
    }

    public Lugar traerLugar(int idLugar) {
        return lugarDao.traerLugar(idLugar);
    }

    public boolean eliminarLugar(int idLugar) {
        return lugarDao.eliminarLugar(idLugar);
    }

    public boolean modificarLugar(Lugar lugar) {
        return lugarDao.modificarLugar(lugar);
    }

    public Set<Servicio> traerServiciosPorLugar(Lugar lugar) {
        return lugarDao.traerServiciosPorLugar(lugar);
    }
}