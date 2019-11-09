/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.CursoEnfasisData;
import java.util.List;

/**
 *
 * @author fabian
 */
public class CursoEnfasisBusiness {
    
    private CursoEnfasisData cursoEnfasisData;
    
    public List<String> buscarEnfasisIdPorSiglaCurso(String siglaCurso){
       
        return cursoEnfasisData.buscarEnfasisIdPorSiglaCurso(siglaCurso);
    }
    
  
    public List<String> buscarSiglaCursosPorEnfasisId(String idEnfasis){
	
        return cursoEnfasisData.buscarSiglaCursosPorEnfasisId(idEnfasis);
    }
    
    
    public void insertarRelacion(String siglaCurso,String enfasisId){
        
       cursoEnfasisData.insertarRelacion(siglaCurso, enfasisId);
    }
    
    
    public void eliminarRelacionPorEnfasisIdOSiglaCurso(String id){
        
        cursoEnfasisData.eliminarRelacionPorEnfasisIdOSiglaCurso(id);
    }
    
}
