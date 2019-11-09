/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.CursoBloqueData;
import java.util.List;

/**
 *
 * @author fabian
 */
public class CursoBloqueBusiness {
    
    private CursoBloqueData cursoBloqueData;
    
    public List<String> buscarBloqueIdPorSiglaCurso(String siglaCurso){
       
        return cursoBloqueData.buscarBloqueIdPorSiglaCurso(siglaCurso);
    }
    
  
    public List<String> buscarSiglaCursosPorBloqueId(String idBloque){
	
        return cursoBloqueData.buscarSiglaCursosPorBloqueId(idBloque);
    }
    
    
    public void insertarRelacion(String siglaCurso,String BloqueId){
        
       cursoBloqueData.insertarRelacion(siglaCurso,BloqueId);
    }
    
    
    public void eliminarRelacionPorBloqueIdOSiglaCurso(String id){
        
        cursoBloqueData.eliminarRelacionPorBloqueIdOSiglaCurso(id);
    }
}
