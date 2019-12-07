/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;
import cr.ac.ucr.sicie.domain.Curso;
import cr.ac.ucr.sicie.domain.ProgramaCurso;
import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProgramaCursoDataTest {
    
    @Autowired
    private ProgramaCursoData programaCursoData;

    @Test
    public void insertarProgramaCurso() {
        ProgramaCurso programaCurso = new ProgramaCurso(1, true, "link", "IF500");
        programaCursoData.insertarProgramaCurso(programaCurso);
    }
    
    @Test
    public void listarProgramaCurso(){
        programaCursoData.listarProgramasCurso();
    }
    
    @Test
    public void buscarProgramaCurso(){
        programaCursoData.buscarProgramasPorCurso("IF500");
    }
    
    @Test
    public void actualizarProgramaCurso(){
        ProgramaCurso programaCurso = new ProgramaCurso(1, false, "link2", "IF500");
        programaCursoData.actualizarProgramaCurso(programaCurso, "IF500");
    }
    
    @Test
    public void eliminarProgramaCurso() {
        programaCursoData.eliminarProgramaCurso(0, "IF500");
    }
}
