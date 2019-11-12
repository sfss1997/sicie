package cr.ac.ucr.sicie.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ProyectoInvestigacion {

    private int idProyectoInvestigacion;
    private String codigo;
    private String titulo;
    private String descripcion;
    private String objetivoGeneral;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    private List<TipoParticipacionExterna> tipoParticipacionesExternas;
    private List<TipoParticipacionInterna> tipoParticipacionesInternas;
    private SedeORecinto recinto;

    public ProyectoInvestigacion() {
        tipoParticipacionesExternas = new ArrayList<>();
        tipoParticipacionesInternas = new ArrayList<>();
        recinto = new SedeORecinto();
    }

    public ProyectoInvestigacion(int idProyectoInvestigacion,
                                 String codigo,
                                 String titulo,
                                 String descripcion,
                                 String objetivoGeneral,
                                 LocalDate fechaInicio,
                                 LocalDate fechaFinal,
                                 List<TipoParticipacionExterna> tipoParticipacionesExternas,
                                 List<TipoParticipacionInterna> tipoParticipacionesInternas,
                                 SedeORecinto recinto) {
        this.idProyectoInvestigacion = idProyectoInvestigacion;
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.objetivoGeneral = objetivoGeneral;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.tipoParticipacionesExternas = tipoParticipacionesExternas;
        this.tipoParticipacionesInternas = tipoParticipacionesInternas;
        this.recinto = recinto;
    }

    public int getIdProyectoInvestigacion() {
        return idProyectoInvestigacion;
    }

    public void setIdProyectoInvestigacion(int idProyectoInvestigacion) {
        this.idProyectoInvestigacion = idProyectoInvestigacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public List<TipoParticipacionExterna> getTipoParticipacionesExternas() {
        return tipoParticipacionesExternas;
    }

    public void setTipoParticipacionesExternas(List<TipoParticipacionExterna> tipoParticipacionesExternas) {
        this.tipoParticipacionesExternas = tipoParticipacionesExternas;
    }

    public List<TipoParticipacionInterna> getTipoParticipacionesInternas() {
        return tipoParticipacionesInternas;
    }

    public void setTipoParticipacionesInternas(List<TipoParticipacionInterna> tipoParticipacionesInternas) {
        this.tipoParticipacionesInternas = tipoParticipacionesInternas;
    }

    public SedeORecinto getRecinto() {
        return recinto;
    }

    public void setRecinto(SedeORecinto recinto) {
        this.recinto = recinto;
    }
}
