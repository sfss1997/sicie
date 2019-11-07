package cr.ac.ucr.sicie.domain;

import java.util.*;

public class Curso {

    private Bloque bloque;
    private List<Curso> cursosRequisitos;
    private List<Curso> cursosCorrequisitos;
    private List<Enfasis> enfasis;
    private List<ProgramaCurso> programas;
    private PlanEstudios planDeEstudio;
    private String sigla;
    private String nombre;
    private int creditos;
    private int nivel;
    private boolean optativa = false;

    public Curso() {
    }

    public Curso(Bloque bloque, List<Curso> cursosRequisitos, List<Curso> cursosCorrequisitos, List<Enfasis> enfasis, List<ProgramaCurso> programas, PlanEstudios planDeEstudio, String sigla, String nombre, int creditos, int nivel) {
        this.bloque = bloque;
        this.cursosRequisitos = cursosRequisitos;
        this.cursosCorrequisitos = cursosCorrequisitos;
        this.enfasis = enfasis;
        this.programas = programas;
        this.planDeEstudio = planDeEstudio;
        this.sigla = sigla;
        this.nombre = nombre;
        this.creditos = creditos;
        this.nivel = nivel;
    }

    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

    public List<Curso> getCursosRequisitos() {
        return cursosRequisitos;
    }

    public void setCursosRequisitos(List<Curso> cursosRequisitos) {
        this.cursosRequisitos = cursosRequisitos;
    }

    public List<Curso> getCursosCorrequisitos() {
        return cursosCorrequisitos;
    }

    public void setCursosCorrequisitos(List<Curso> cursosCorrequisitos) {
        this.cursosCorrequisitos = cursosCorrequisitos;
    }

    public List<Enfasis> getEnfasis() {
        return enfasis;
    }

    public void setEnfasis(List<Enfasis> enfasis) {
        this.enfasis = enfasis;
    }

    public List<ProgramaCurso> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaCurso> programas) {
        this.programas = programas;
    }

    public PlanEstudios getPlanDeEstudio() {
        return planDeEstudio;
    }

    public void setPlanDeEstudio(PlanEstudios planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isOptativa() {
        return optativa;
    }

    public void setOptativa(boolean optativa) {
        this.optativa = optativa;
    }

    
        
    
}