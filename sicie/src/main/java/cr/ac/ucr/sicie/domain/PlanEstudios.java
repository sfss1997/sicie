package cr.ac.ucr.sicie.domain;

import java.io.File;
import java.util.*;

public class PlanEstudios {

    private List<Curso> cursos;
    private String codigo;
    private String nombreCarrera;
    private int anoResolucion;
    private File documentoFundamentacionCarrera;
    private boolean vigente;
    private File resolucionDeCreacionDeCarrera;

    public PlanEstudios() {
    }

    public PlanEstudios(List<Curso> cursos, String codigo, String nombreCarrera, int anoResolucion, File documentoFundamentacionCarrera, boolean vigente, File resolucionDeCreacionDeCarrera) {
        this.cursos = cursos;
        this.codigo = codigo;
        this.nombreCarrera = nombreCarrera;
        this.anoResolucion = anoResolucion;
        this.documentoFundamentacionCarrera = documentoFundamentacionCarrera;
        this.vigente = vigente;
        this.resolucionDeCreacionDeCarrera = resolucionDeCreacionDeCarrera;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getAnoResolucion() {
        return anoResolucion;
    }

    public void setAnoResolucion(int anoResolucion) {
        this.anoResolucion = anoResolucion;
    }

    public File getDocumentoFundamentacionCarrera() {
        return documentoFundamentacionCarrera;
    }

    public void setDocumentoFundamentacionCarrera(File documentoFundamentacionCarrera) {
        this.documentoFundamentacionCarrera = documentoFundamentacionCarrera;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public File getResolucionDeCreacionDeCarrera() {
        return resolucionDeCreacionDeCarrera;
    }

    public void setResolucionDeCreacionDeCarrera(File resolucionDeCreacionDeCarrera) {
        this.resolucionDeCreacionDeCarrera = resolucionDeCreacionDeCarrera;
    }

    
    

}