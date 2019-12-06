/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.CursoCorrequisitoData;
import java.util.Iterator;

/**
 *
 * @author fabian
 */
public class CorrequisitoBusiness {
    private CursoCorrequisitoData correquisitoData;
    
    public Iterator<String> buscarCursosCorrequisito(String sigla) {
        
       return correquisitoData.buscarCursosCorrequisito(sigla);
    }
}
