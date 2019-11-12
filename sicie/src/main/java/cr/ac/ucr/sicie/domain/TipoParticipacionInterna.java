package cr.ac.ucr.sicie.domain;

public class TipoParticipacionInterna {
    private int idParticipacion;
    private String descripcion;

    private Docente docente;

    public TipoParticipacionInterna(int idParticipacion,
                                    String descripcion,
                                    Docente docente) {
        this.idParticipacion = idParticipacion;
        this.descripcion = descripcion;
        this.docente = docente;
    }

    public TipoParticipacionInterna() {
        docente = new Docente();
    }

    public int getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(int idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
