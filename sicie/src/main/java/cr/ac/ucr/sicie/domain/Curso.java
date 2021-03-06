package cr.ac.ucr.sicie.domain;

import java.util.*;

public class Curso {

    private Bloque bloque;
    private List<String> cursosRequisitos;
    private List<String> cursosCorrequisitos;
    private List<String> enfasis;
    private List<ProgramaCurso> programas;
    private List<String> optativos;
    private String planDeEstudios;
    private String sigla;
    private String nombre;
    private int creditos;
    private int nivel;
    private boolean optativa;

    public Curso() {
    }

    public Curso(Bloque bloque, List<String> cursosRequisitos, List<String> cursosCorrequisitos, List<String> enfasis, List<ProgramaCurso> programas, List<String> optativos, String planDeEstudios, String sigla, String nombre, int creditos, int nivel, boolean optativa) {
        this.bloque = bloque;
        this.cursosRequisitos = cursosRequisitos;
        this.cursosCorrequisitos = cursosCorrequisitos;
        this.enfasis = enfasis;
        this.programas = programas;
        this.optativos = optativos;
        this.planDeEstudios = planDeEstudios;
        this.sigla = sigla;
        this.nombre = nombre;
        this.creditos = creditos;
        this.nivel = nivel;
        this.optativa = optativa;
    }

    public Curso(String planDeEstudios, String sigla, String nombre, int creditos, int nivel, boolean optativa) {
        this.planDeEstudios = planDeEstudios;
        this.sigla = sigla;
        this.nombre = nombre;
        this.creditos = creditos;
        this.nivel = nivel;
        this.optativa = optativa;
    }

    
    
    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

    public List<String> getCursosRequisitos() {
        return cursosRequisitos;
    }

    public void setCursosRequisitos(List<String> cursosRequisitos) {
        this.cursosRequisitos = cursosRequisitos;
    }

    public List<String> getCursosCorrequisitos() {
        return cursosCorrequisitos;
    }

    public void setCursosCorrequisitos(List<String> cursosCorrequisitos) {
        this.cursosCorrequisitos = cursosCorrequisitos;
    }

    public List<String> getEnfasis() {
        return enfasis;
    }

    public void setEnfasis(List<String> enfasis) {
        this.enfasis = enfasis;
    }

    public List<ProgramaCurso> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaCurso> programas) {
        this.programas = programas;
    }

    public List<String> getOptativos() {
        return optativos;
    }

    public void setOptativos(List<String> optativos) {
        this.optativos = optativos;
    }

    public String getPlanDeEstudios() {
        return planDeEstudios;
    }

    public void setPlanDeEstudios(String planDeEstudios) {
        this.planDeEstudios = planDeEstudios;
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

    @Override
    public String toString() {
        return "Curso{" + "bloque=" + bloque + ", cursosRequisitos=" + cursosRequisitos + ", cursosCorrequisitos=" + cursosCorrequisitos + ", enfasis=" + enfasis + ", programas=" + programas + ", optativos=" + optativos + ", planDeEstudios=" + planDeEstudios + ", sigla=" + sigla + ", nombre=" + nombre + ", creditos=" + creditos + ", nivel=" + nivel + ", optativa=" + optativa + '}';
    }

    
    
    
    
    
}