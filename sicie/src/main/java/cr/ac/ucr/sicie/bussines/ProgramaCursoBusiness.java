/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.ProgramaCursoData;
import cr.ac.ucr.sicie.domain.ProgramaCurso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fabian
 */
public class ProgramaCursoBusiness {
    
    private ProgramaCursoData programaCursoData;
    
    public Iterator<ProgramaCurso> listarProgramasCurso(){
        
        return programaCursoData.listarProgramasCurso();
    }
    
    public List<ProgramaCurso> buscarProgramasPorCurso(String sigla){
        
        Iterator<ProgramaCurso> iterator = programaCursoData.buscarProgramasPorCurso(sigla);
        ArrayList<ProgramaCurso> list = new ArrayList<ProgramaCurso>();
         
            while (iterator.hasNext()) {
                ProgramaCurso programaCurso = iterator.next();
                list.add(programaCurso);
            }
        return list;
    }
    
    public void insertarProgramaCurso(ProgramaCurso programaCurso){
        
        programaCursoData.insertarProgramaCurso(programaCurso);
    }
    
    public void eliminarProgramaCurso(int version,String siglaCurso){
        
        programaCursoData.eliminarProgramaCurso(version,siglaCurso);
    }
    
    public void actualizarProgramaCurso(ProgramaCurso programaCurso, String siglaCurso){
        
        programaCursoData.actualizarProgramaCurso(programaCurso, siglaCurso);
    }
}
