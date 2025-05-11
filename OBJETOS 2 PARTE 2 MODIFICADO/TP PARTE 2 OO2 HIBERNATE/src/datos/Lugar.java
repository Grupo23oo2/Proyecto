import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lugar")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLugar;

    private String direccion;

    @OneToMany(mappedBy = "lugarServicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Servicio> servicios = new HashSet<>();

    public Lugar() {}

    public Lugar(String direccion) {
        this.direccion = direccion;
    }

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
