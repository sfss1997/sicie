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
	
//	@Test
//	public void guardarCurso() {
//            Curso curso = new Curso(null, null, null, null, null, "asd", "if434", "Logica", 3, 2, true);
//            cursoData.insertarCurso(curso);
//        }
        
        @Test
	public void listarCurso() {
           Iterator<Curso> x = cursoData.listarCursos();
         
         
            while (x.hasNext()) {
                Curso curso = x.next();
                System.out.print(curso.toString());
                System.out.print("/n");
            }
           
        }
}
