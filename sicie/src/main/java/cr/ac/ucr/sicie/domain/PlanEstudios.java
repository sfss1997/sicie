package cr.ac.ucr.sicie.domain;

import java.io.File;
import java.util.*;

public class PlanEstudios {

    private ArrayList<Curso> cursos;
    private String codigo;
    private String nombreCarrera;
    private int anoResolucion;
    private String documentoFundamentacionCarrera;
    private boolean vigente;
    private String resolucionDeCreacionDeCarrera;

    public PlanEstudios() {
    }

    public PlanEstudios(ArrayList<Curso> cursos, String codigo, String nombreCarrera, int anoResolucion, boolean vigente, String documentoFundamentacionCarrera, String resolucionDeCreacionDeCarrera) {
        this.cursos = cursos;
        this.codigo = codigo;
        this.nombreCarrera = nombreCarrera;
        this.anoResolucion = anoResolucion;
        this.documentoFundamentacionCarrera = documentoFundamentacionCarrera;
        this.vigente = vigente;
        this.resolucionDeCreacionDeCarrera = resolucionDeCreacionDeCarrera;
    }

    public PlanEstudios(String codigo, String nombreCarrera, int anoResolucion, boolean vigente, String documentoFundamentacionCarrera, String resolucionDeCreacionDeCarrera) {
        this.codigo = codigo;
        this.nombreCarrera = nombreCarrera;
        this.anoResolucion = anoResolucion;
        this.documentoFundamentacionCarrera = documentoFundamentacionCarrera;
        this.vigente = vigente;
        this.resolucionDeCreacionDeCarrera = resolucionDeCreacionDeCarrera;
    }
    
    

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
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

    public String getDocumentoFundamentacionCarrera() {
        return documentoFundamentacionCarrera;
    }

    public void setDocumentoFundamentacionCarrera(String documentoFundamentacionCarrera) {
        this.documentoFundamentacionCarrera = documentoFundamentacionCarrera;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public String getResolucionDeCreacionDeCarrera() {
        return resolucionDeCreacionDeCarrera;
    }

    public void setResolucionDeCreacionDeCarrera(String resolucionDeCreacionDeCarrera) {
        this.resolucionDeCreacionDeCarrera = resolucionDeCreacionDeCarrera;
    }

    @Override
    public String toString() {
        return "PlanEstudios{" + "cursos=" + cursos + ", codigo=" + codigo + ", nombreCarrera=" + nombreCarrera + ", anoResolucion=" + anoResolucion + ", documentoFundamentacionCarrera=" + documentoFundamentacionCarrera + ", vigente=" + vigente + ", resolucionDeCreacionDeCarrera=" + resolucionDeCreacionDeCarrera + '}';
    }

   
    
    
    
}
    

    