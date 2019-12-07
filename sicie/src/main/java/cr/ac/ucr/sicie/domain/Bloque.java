package cr.ac.ucr.sicie.domain;

import java.util.*;

public class Bloque {

    private List<Curso> cursos;
    private int IdBloque;
    private String nombreDelBloque;

    public Bloque() {
    }

    public Bloque(List<Curso> cursos, int IdBloque, String nombreDelBloque) {
        this.cursos = cursos;
        this.IdBloque = IdBloque;
        this.nombreDelBloque = nombreDelBloque;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public int getIdBloque() {
        return IdBloque;
    }

    public void setIdBloque(int IdBloque) {
        this.IdBloque = IdBloque;
    }

    public String getNombreDelBloque() {
        return nombreDelBloque;
    }

    public void setNombreDelBloque(String nombreDelBloque) {
        this.nombreDelBloque = nombreDelBloque;
    }

    
    
    

    
}