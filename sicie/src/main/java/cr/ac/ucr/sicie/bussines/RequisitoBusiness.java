/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.CursoRequisitoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fabian
 */
public class RequisitoBusiness {
     private CursoRequisitoData requisitoData;
    
    public List<String> buscarCursosRequisito(String sigla) {
        Iterator<String> iterator = requisitoData.buscarCursosRequisito(sigla);
        ArrayList<String> list = new ArrayList<String>();
         
            while (iterator.hasNext()) {
                String requisito = iterator.next();
                list.add(requisito);
            }
        return list;
       
    }
}
