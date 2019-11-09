/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.Bloque;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabian
 */

@Repository
public class CursoBloqueData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly=true)
    public List<String> buscarBloqueIdPorSiglaCurso(String siglaCurso){
        List<String> bloques = new ArrayList<String>();
        String sqlScript = "SELECT id_bloque FROM curso_bloque WHERE sigla_curso="+siglaCurso+";";
	
        return bloques;
    }
    
    @Transactional(readOnly=true)
    public List<String> buscarSiglaCursosPorBloqueId(String bloqueId){
        List<String> cursos = new ArrayList<String>();
        String sqlScript = "SELECT sigla_curso FROM curso_bloque WHERE curso_id="+bloqueId+";";
	
        return cursos;
    }
    
    @Transactional(readOnly=true)
    public void insertarRelacion(String siglaCurso,String bloqueId){
        String sqlScript = "INSERT INTO curso_bloque VALUES("
                +siglaCurso+","
                +bloqueId+");";
    }
    
    @Transactional(readOnly=true)
    public void eliminarRelacionPorBloqueIdOSiglaCurso(String id){
        String sqlScript = "DELETE FROM curso_bloque WHERE id_bloque="+id+"OR sigla_curso="+id+";";
    }
}
