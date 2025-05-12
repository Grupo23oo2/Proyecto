package negocio;

import dao.LugarDao;
import datos.Lugar;

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
}