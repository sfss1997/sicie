/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.ProgramaCurso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabian
 */
public class ProgramaCursoData {
 
    public List<ProgramaCurso> listarProgramasCurso(){   
        List<ProgramaCurso> programasCurso = new ArrayList<ProgramaCurso>();
        String sqlScript = "SELECT * FROM programa_curso;";
        
        return programasCurso;
    }
    
    public List<ProgramaCurso> buscarProgramasCurso(int version){
        List<ProgramaCurso> programasCurso = new ArrayList<ProgramaCurso>();
        String sqlScript = "SELECT * FROM programa_curso WHERE version="+version+";";
                
        return programasCurso;
    }
    
    public void insertarProgramaCurso(ProgramaCurso programaCurso,String siglaCurso){
        String sqlScript = "INSERT INTO programa_curso VALUES("
                +programaCurso.getVersion()+","
                +programaCurso.isVigente()+","
                +siglaCurso+");";
    }
    
    public void eliminarProgramaCurso(int version){
        String sqlScript = "DELETE FROM programa_curso WHERE id="+version+";";
    }
}
