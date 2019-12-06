/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.CursoCorrequisitoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fabian
 */
public class CorrequisitoBusiness {
    private CursoCorrequisitoData correquisitoData;
    
    public List<String> buscarCursosCorrequisito(String sigla) {
         
        Iterator<String> iterator = correquisitoData.buscarCursosCorrequisito(sigla);
        ArrayList<String> list = new ArrayList<String>();
         
            while (iterator.hasNext()) {
                String correquisito = iterator.next();
                list.add(correquisito);
            }
        return list;
    }
}
