/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sicie.domain.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabian
 */

@Repository
public class CursoData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly=true)
    public List<Curso> listarCursos(){
        List<Curso> cursos = new ArrayList<Curso>();
        String sqlScript = "SELECT * FROM bloque;";
        return cursos;
    }
    
    @Transactional(readOnly=true)
    public List<Curso> buscarCursos(String sigla){
        List<Curso> cursos = new ArrayList<Curso>();
        String sqlScript = "SELECT * FROM curso WHERE sigla="+sigla+";";
        
        return cursos;
    }
    
    @Transactional(readOnly=true)
    public void insertarCurso(Curso curso){
    String sqlScript = "INSERT INTO bloque VALUES("
            +curso.getSigla()+","
            +curso.getNombre()+","
            +curso.getNivel()+","
            +curso.getPlanDeEstudio().getCodigo()+");";
    }
     
    @Transactional(readOnly=true)
    public void eliminarCurso(String sigla){
        String sqlScript = "DELETE FROM curso WHERE sigla="+sigla+";";
    }
    
}
