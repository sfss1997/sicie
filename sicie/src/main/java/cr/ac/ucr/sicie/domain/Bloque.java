package cr.ac.ucr.sicie.domain;

import java.util.*;

public class Bloque {

    private List<Curso> cursos;
    private int IdBloque;
    private int nombreDelBloque;

    public Bloque() {
    }

    public Bloque(List<Curso> cursos, int IdBloque, int nombreDelBloque) {
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

    public int getNombreDelBloque() {
        return nombreDelBloque;
    }

    public void setNombreDelBloque(int nombreDelBloque) {
        this.nombreDelBloque = nombreDelBloque;
    }
    
    

    
}