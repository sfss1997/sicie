package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.Curso;
import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CursoDataTest {

    @Autowired
    private CursoData cursoData;

    @Test
    public void insertarCurso() {
        Curso curso = new Curso("01", "IF500", "Logica", 3, 2, true);
        cursoData.insertarCurso(curso);
    }

    @Test
    public void listarCurso() {
        Iterator<Curso> iterator = cursoData.listarCursos();

        while (iterator.hasNext()) {
            Curso curso = iterator.next();
            System.out.print(curso.toString());
            System.out.print("/n");
        }

    }

    @Test
    public void actualizarCurso() {
        Curso curso = new Curso("01", "IF500", "Logica", 2, 3, true);
        cursoData.actualizarCurso(curso);
    }

    @Test
    public void buscarCursosPorPlan() {
        Iterator<Curso> iterator = cursoData.buscarCursosPorPlan("01");

        while (iterator.hasNext()) {
            Curso curso = iterator.next();
            System.out.print(curso.toString());
            System.out.print("/n");
        }
    }
    
    @Test
    public void eliminarCurso() {
        cursoData.eliminarCurso("IF500");
    }

}
