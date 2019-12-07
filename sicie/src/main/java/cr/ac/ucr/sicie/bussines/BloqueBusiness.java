/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.BloqueData;
import cr.ac.ucr.sicie.domain.Bloque;
import java.util.List;

/**
 *
 * @author fabian
 */
public class BloqueBusiness {
    
    private BloqueData bloqueData;
            
    public List<Bloque> listarBloques(){
        
        return bloqueData.listarBloques();
    }
    
    public Bloque buscarBloquePorCurso(String siglaCurso){
       
        return bloqueData.buscarBloquePorCurso(siglaCurso);
    }
    
    public void insertarBloque(Bloque bloque){
    
        bloqueData.insertarBloque(bloque);
    }
    
    public void eliminarBloque(int id){
    
        bloqueData.eliminarBloque(id);
    }
}
