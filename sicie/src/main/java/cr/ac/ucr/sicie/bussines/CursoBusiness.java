/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.CursoData;
import cr.ac.ucr.sicie.domain.Curso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fabian
 */
public class CursoBusiness {
    
    private CursoData cursoData;
   
    public Iterator<Curso> listarCursos(){
        
        return cursoData.listarCursos();
    }
    
    public Iterator<Curso> buscarCursos(String sigla){
        
        return cursoData.buscarCursos(sigla);
    }
    
    public void insertarCurso(Curso curso){
        
        cursoData.insertarCurso(curso);
    }
    
    public void actualizarCurso(Curso curso){
        
        cursoData.actualizarCurso(curso);
    }
    
    public void eliminarCurso(String sigla){
    
        cursoData.eliminarCurso(sigla);
    }
    
    public Iterator<Curso> buscarCursosPorPlan(String codigo){
    
        return cursoData.buscarCursosPorPlan(codigo);
    }
    
    
    
  
}
