package cr.ac.ucr.sicie.domain;

public class EntidadProcedencia {

    private int idEntidad;
    private String nombre;

    public EntidadProcedencia(int idEntidad, String nombre) {
        this.idEntidad = idEntidad;
        this.nombre = nombre;
    }

    public EntidadProcedencia() {}

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
