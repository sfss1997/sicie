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

import cr.ac.ucr.sicie.domain.Enfasis;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author fabian
 */
@Repository
public class EnfasisData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
   
    public Iterator<Enfasis> listarEnfasis(){
        
        String selectSql = "SELECT * FROM enfasis;";
        return jdbcTemplate
                .query(selectSql, new Object[]{},
                        (rs, row) -> new Enfasis(
                                null,
                                rs.getInt("id"),
                                rs.getString("nombre"))).iterator();
    }
    
    
    public Iterator<String> buscarEnfasisBySiglaCurso(String sigla){
        
        String selectSql = "SELECT id,nombre FROM enfasis JOIN curso_enfasis ON id=id_enfasis WHERE sigla_curso='"+sigla+"';";
        return jdbcTemplate
                .query(selectSql, new Object[]{},
                        (rs, row) -> new String(rs.getString("nombre"))).iterator();
    }
    
    
    public void insertarEnfasis(Enfasis enfasis){
        String sqlScript = "INSERT INTO enfasis VALUES("
                +enfasis.getIdEnfasis()+","
                +enfasis.getNombreEnfasis()+");";
    }
    
    
    public void eliminarEnfasis(String id){
        String sqlScript = "DELETE FROM enfasis WHERE id="+id+";";
    }
}
