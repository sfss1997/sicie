package cr.ac.ucr.sicie.domain;

public class ParticipanteExterno {

    private int idParticipanteExterno;
    private String nombre;
    private String apellidos;
    private String gradoAcademico;
    private String correoElectronico;

    private EntidadProcedencia entidadProcedencia;

    public ParticipanteExterno(int idParticipanteExterno,
                               String nombre,
                               String apellidos,
                               String gradoAcademico,
                               String correoElectronico,
                               EntidadProcedencia entidadProcedencia) {
        this.idParticipanteExterno = idParticipanteExterno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.gradoAcademico = gradoAcademico;
        this.correoElectronico = correoElectronico;
        this.entidadProcedencia = entidadProcedencia;
    }

    public ParticipanteExterno() {
        entidadProcedencia = new EntidadProcedencia();
    }

    public int getIdParticipanteExterno() {
        return idParticipanteExterno;
    }

    public void setIdParticipanteExterno(int idParticipanteExterno) {
        this.idParticipanteExterno = idParticipanteExterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public EntidadProcedencia getEntidadProcedencia() {
        return entidadProcedencia;
    }

    public void setEntidadProcedencia(EntidadProcedencia entidadProcedencia) {
        this.entidadProcedencia = entidadProcedencia;
    }
}
