/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.PlanEstudiosData;
import cr.ac.ucr.sicie.domain.PlanEstudios;
import java.util.List;

/**
 *
 * @author fabian
 */
public class PlanEstudiosBusiness {
    
    private PlanEstudiosData planesEstudiosData;
    
    public List<PlanEstudios> listarPlanesEstudios(){
        
        return planesEstudiosData.listarPlanesEstudios();
    }
    
    public List<PlanEstudios> buscarPlanesEstudios(String codigo){
        
        return planesEstudiosData.buscarPlanesEstudios(codigo);
    }
    
    public void insertarPlanEstudios(PlanEstudios planEstudios){
    
        
        planesEstudiosData.insertarPlanEstudios(planEstudios);
    }
    
    public void eliminarPlanEstudios(String codigo){
        
        planesEstudiosData.eliminarPlanEstudios(codigo);
    }
    
}
