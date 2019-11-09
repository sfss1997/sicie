/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.ProgramaCursoData;
import cr.ac.ucr.sicie.domain.ProgramaCurso;
import java.util.List;

/**
 *
 * @author fabian
 */
public class ProgramaCursoBusiness {
    
    private ProgramaCursoData programaCursoData;
    
    public List<ProgramaCurso> listarProgramasCurso(){
        
        return programaCursoData.listarProgramasCurso();
    }
    
    public List<ProgramaCurso> buscarProgramasCurso(int version){
        
        return programaCursoData.buscarProgramasCurso(version);
    }
    
    public void insertarProgramaCurso(ProgramaCurso programaCurso, String siglaCurso){
        
        programaCursoData.insertarProgramaCurso(programaCurso, siglaCurso);
    }
    
    public void eliminarProgramaCurso(int version){
        
        programaCursoData.eliminarProgramaCurso(version);
    }
}
