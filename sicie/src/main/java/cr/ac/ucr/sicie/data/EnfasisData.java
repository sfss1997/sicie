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
import java.util.List;

/**
 *
 * @author fabian
 */
@Repository
public class EnfasisData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly=true)
    public List<Enfasis> listarEnfasis(){
        List<Enfasis> enfasis = new ArrayList<Enfasis>();
        String sqlScript = "SELECT * FROM enfasis;";
        
        return enfasis;
    }
    
    @Transactional(readOnly=true)
    public List<Enfasis> buscarEnfasis(String id){
        List<Enfasis> enfasis = new ArrayList<Enfasis>();
        String sqlScript = "SELECT * FROM enfasis WHERE id="+id+";";
        
        return enfasis;
    }
    
    @Transactional(readOnly=true)
    public void insertarEnfasis(Enfasis enfasis){
        String sqlScript = "INSERT INTO enfasis VALUES("
                +enfasis.getIdEnfasis()+","
                +enfasis.getNombreEnfasis()+");";
    }
    
    @Transactional(readOnly=true)
    public void eliminarEnfasis(String id){
        String sqlScript = "DELETE FROM enfasis WHERE id="+id+";";
    }
}
