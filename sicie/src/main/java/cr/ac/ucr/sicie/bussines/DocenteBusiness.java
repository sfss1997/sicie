package cr.ac.ucr.sicie.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.sicie.data.DocenteData;
import cr.ac.ucr.sicie.domain.Docente;
@Service
public class DocenteBusiness {

	
	@Autowired
	private DocenteData docenteData;
	
	
	public void guardarDocente(Docente docente, String nombreRecinto) {
		docenteData.guardarDocente(docente, nombreRecinto);
	}
}
