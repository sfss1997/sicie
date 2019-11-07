/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.EnfasisData;
import cr.ac.ucr.sicie.domain.Enfasis;
import java.util.List;

/**
 *
 * @author fabian
 */
public class EnfasisBusiness {
    
    private EnfasisData enfasisData;
    
    public List<Enfasis> listarEnfasis(){
        
        return enfasisData.listarEnfasis();
    }
    
    public List<Enfasis> buscarEnfasis(String id){
        
        return enfasisData.buscarEnfasis(id);
    }
    
    public void insertarEnfasis(Enfasis enfasis){
    
        enfasisData.insertarEnfasis(enfasis);
    }
    
    public void eliminarEnfasis(String id){
    
        enfasisData.eliminarEnfasis(id);
    }
}
