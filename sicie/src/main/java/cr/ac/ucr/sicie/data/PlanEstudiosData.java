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

import cr.ac.ucr.sicie.domain.PlanEstudios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabian
 */

@Repository
public class PlanEstudiosData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly=true)
    public List<PlanEstudios> listarPlanesEstudios(){
        List<PlanEstudios> planesEstudios = new ArrayList<PlanEstudios>();
        String sqlScript = "SELECT * FROM plan_estudio;";
        
        return planesEstudios;
    }
    
    @Transactional(readOnly=true)
    public List<PlanEstudios> buscarPlanesEstudios(String codigo){
        List<PlanEstudios> planesEstudios = new ArrayList<PlanEstudios>();
        String sqlScript = "SELECT * FROM plan_estudio WHERE codigo="+codigo+";";
        
        return planesEstudios;
    }
    
    @Transactional(readOnly=true)
    public void insertarPlanEstudios(PlanEstudios planEstudios){
        String sqlScript = "INSERT INTO plan_estudio VALUES("
                +planEstudios.getCodigo()+","
                +planEstudios.getNombreCarrera()+"," 
                +planEstudios.getAnoResolucion()+","
                +planEstudios.isVigente()+");";
    }
    
    @Transactional(readOnly=true)
    public void eliminarPlanEstudios(String codigo){
        String sqlScript = "DELETE FROM plan_estudio WHERE codigo="+codigo+";";
    }
}
