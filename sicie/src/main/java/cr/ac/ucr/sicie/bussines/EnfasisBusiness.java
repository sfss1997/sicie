/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.EnfasisData;
import cr.ac.ucr.sicie.domain.Enfasis;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fabian
 */
public class EnfasisBusiness {
    
    private EnfasisData enfasisData;
    
    public Iterator<Enfasis> listarEnfasis(){
        
        return enfasisData.listarEnfasis();
    }
    
    public ArrayList<String> buscarEnfasisBySiglaCurso(String Sigla){
        Iterator<String> iterator = enfasisData.buscarEnfasisBySiglaCurso(Sigla);
        ArrayList<String> list = new ArrayList<String>();
         list=(ArrayList<String>) enfasisData.buscarEnfasisBySiglaCurso(Sigla);
//            while (iterator.hasNext()) {
//                String enfasis = iterator.next();
//                list.add(enfasis);
//            }
        return list;
    }
    
    public void insertarEnfasis(Enfasis enfasis){
    
        enfasisData.insertarEnfasis(enfasis);
    }
    
    public void eliminarEnfasis(String id){
    
        enfasisData.eliminarEnfasis(id);
    }
}
