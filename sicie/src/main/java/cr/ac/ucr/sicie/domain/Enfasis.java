package cr.ac.ucr.sicie.domain;

import java.util.*;

public class Enfasis {

    private List<Curso> cursos;
    private int idEnfasis;
    private String nombreEnfasis;

    public Enfasis() {
    }

    public Enfasis(List<Curso> cursos, int idEnfasis, String nombreEnfasis) {
        this.cursos = cursos;
        this.idEnfasis = idEnfasis;
        this.nombreEnfasis = nombreEnfasis;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public int getIdEnfasis() {
        return idEnfasis;
    }

    public void setIdEnfasis(int idEnfasis) {
        this.idEnfasis = idEnfasis;
    }

    public String getNombreEnfasis() {
        return nombreEnfasis;
    }

    public void setNombreEnfasis(String nombreEnfasis) {
        this.nombreEnfasis = nombreEnfasis;
    }

    
    
}