/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

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
public class CursoEnfasisData {
    
     @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly=true)
    public List<String> buscarEnfasisIdPorSiglaCurso(String siglaCurso){
        List<String> enfasis = new ArrayList<String>();
        String sqlScript = "SELECT id_bloque FROM curso_enfasis WHERE sigla_curso="+siglaCurso+";";
	
        return enfasis;
    }
    
    @Transactional(readOnly=true)
    public List<String> buscarSiglaCursosPorEnfasisId(String idEnfasis){
        List<String> cursos = new ArrayList<String>();
        String sqlScript = "SELECT sigla_curso FROM curso_enfasis WHERE id_enfasis="+idEnfasis+";";
	
        return cursos;
    }
    
    @Transactional(readOnly=true)
    public void insertarRelacion(String siglaCurso,String enfasisId){
        String sqlScript = "INSERT INTO curso_enfasis VALUES("
                +siglaCurso+","
                +enfasisId+");";
    }
    
    @Transactional(readOnly=true)
    public void eliminarRelacionPorEnfasisIdOSiglaCurso(String id){
        String sqlScript = "DELETE FROM curso_enfasis WHERE id_enfasis="+id+"OR sigla_curso="+id+";";
    }
}
