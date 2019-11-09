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

import cr.ac.ucr.sicie.domain.Bloque;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabian
 */

@Repository
public class BloqueData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    @Transactional(readOnly=true)
    public List<Bloque> listarBloques(){
        List<Bloque> bloques = new ArrayList<Bloque>();
        String sqlScript = "SELECT * FROM bloque;";
	
        return bloques;
    }
    
    @Transactional(readOnly=true)
    public List<Bloque> buscarBloques(String id){
        List<Bloque> bloques = new ArrayList<Bloque>();
        String sqlScript = "SELECT * FROM bloque WHERE id="+id+";";
	
        return bloques;
    }
    
    @Transactional(readOnly=true)
    public void insertarBloque(Bloque bloque){
        String sqlScript = "INSERT INTO bloque VALUES("
                +bloque.getIdBloque()+","
                +bloque.getNombreDelBloque()+");";
    }
    
    @Transactional(readOnly=true)
    public void eliminarBloque(String id){
        String sqlScript = "DELETE FROM bloque WHERE id="+id+";";
    }
}
