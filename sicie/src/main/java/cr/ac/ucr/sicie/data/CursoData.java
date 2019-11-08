/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabian
 */
public class CursoData {
    
    public List<Curso> listarCursos(){
        
        List<Curso> cursos = new ArrayList<Curso>();
        return cursos;
    }
    
    public List<Curso> buscarCursos(String sigla){
        
        List<Curso> cursos = new ArrayList<Curso>();
        return cursos;
    }
    
    public void insertarCurso(Curso curso){
    
    }
    
    public void eliminarCurso(String sigla){
    
    }
    
}
