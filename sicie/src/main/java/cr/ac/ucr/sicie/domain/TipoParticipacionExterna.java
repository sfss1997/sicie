package cr.ac.ucr.sicie.domain;

public class TipoParticipacionExterna {
    private int idParticipacion;
    private String descripcion;

    private ParticipanteExterno participanteExterno;

    public TipoParticipacionExterna(int idParticipacion,
                                    String descripcion,
                                    ParticipanteExterno participanteExterno) {
        this.idParticipacion = idParticipacion;
        this.descripcion = descripcion;
        this.participanteExterno = participanteExterno;
    }

    public TipoParticipacionExterna() {
        participanteExterno = new ParticipanteExterno();
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

    public ParticipanteExterno getParticipanteExterno() {
        return participanteExterno;
    }

    public void setParticipanteExterno(ParticipanteExterno participanteExterno) {
        this.participanteExterno = participanteExterno;
    }
}
