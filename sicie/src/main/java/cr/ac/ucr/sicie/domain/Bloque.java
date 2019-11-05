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

    
}