/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.CursoRequisitoData;
import java.util.Iterator;

/**
 *
 * @author fabian
 */
public class RequisitoBusiness {
     private CursoRequisitoData requisitoData;
    
    public Iterator<String> buscarCursosRequisito(String sigla) {
        
       return requisitoData.buscarCursosRequisito(sigla);
    }
}
