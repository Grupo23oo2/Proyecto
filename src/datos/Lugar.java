package datos;

import java.util.HashSet;
import java.util.Set;


public class Lugar {
    private int idLugar;
    private String direccion;

    private Set<Servicio> servicios = new HashSet<>();

    public Lugar(int idLugar, String direccion, Set<Servicio> servicios) {
		super();
		this.idLugar = idLugar;
		this.direccion = direccion;
		this.servicios = servicios;
	}

	public Lugar(String direccion, Set<Servicio> servicios) {
		super();
		this.direccion = direccion;
		this.servicios = servicios;
	}
	
	public Lugar(String direccion) {
        this.direccion = direccion;
    }

    
    public Lugar() {}
    
    
    
    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Lugar [id=" + idLugar + ", direccion=" + direccion + "]";
    }



	
}
