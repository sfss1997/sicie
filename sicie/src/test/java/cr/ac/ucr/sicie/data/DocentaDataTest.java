package cr.ac.ucr.sicie.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cr.ac.ucr.sicie.data.DocenteData;
import cr.ac.ucr.sicie.domain.Docente;
import cr.ac.ucr.sicie.domain.Especializacion;
import cr.ac.ucr.sicie.domain.Topico;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocentaDataTest {

	@Autowired
	private DocenteData docenteData;
	
	@Test
	public void guardarDocente() {
		List<Topico> topicosInteres = new ArrayList<Topico>();
		Topico topico = new Topico(22, "Inteligencia Artificial");
		topicosInteres.add(topico);
		assertEquals("Inteligencia Artificial", topicosInteres.get(0));
		List<Especializacion> especializacion = new ArrayList<Especializacion>();
		Especializacion especia = new Especializacion(43,"Telemática");
		especializacion.add(especia);
		assertEquals("Telemática", especializacion.get(0));
		Docente docente = new Docente(19,"emmanuel.solanonavarro@ucr.ac.cr","Emmanuel","Solano Navarro","Estudiante",topicosInteres,especializacion,true);
		
		//Iterator<Docente> listaDocentes = docenteData.cargarDocentes();
		
		docenteData.guardarDocente(docente, "Recinto de Paraíso");
		assertNotNull(docente);
	}
}
