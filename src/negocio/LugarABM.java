package negocio;

import java.util.Set;

import dao.LugarDao;
import datos.Lugar;
import datos.Servicio;

public class LugarABM {

    private LugarDao lugarDao;

    public LugarABM() {
        this.lugarDao = new LugarDao();
    }

    public boolean agregarLugar(Lugar lugar) {
        return lugarDao.agregarLugar(lugar);
    }

    public Lugar traerLugar(int idLugar) {
        return lugarDao.traerLugar(idLugar);
    }

    public boolean eliminarLugar(int idLugar) {
        return lugarDao.eliminarLugar(idLugar);
    }

    public boolean modificarLugar(int idLugar, String nuevaDireccion) {
        return lugarDao.modificarLugar(idLugar, nuevaDireccion);
    }
    
    public Set<Servicio> traerServiciosPorLugar(Lugar lugar) {
        return lugarDao.traerServiciosPorLugar(lugar);
    }
    
}