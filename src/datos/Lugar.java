package datos;

public class Lugar {
    private int idLugar;
    private String direccion;

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

    @Override
    public String toString() {
        return "Lugar [id=" + idLugar + ", direccion=" + direccion + "]";
    }
}
