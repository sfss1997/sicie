package cr.ac.ucr.sicie.bussines;

import java.util.Iterator;
import java.util.List;

import cr.ac.ucr.sicie.data.TipoParticipacionInternaData;
import cr.ac.ucr.sicie.domain.TipoParticipacionInterna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.sicie.data.DocenteData;
import cr.ac.ucr.sicie.domain.Docente;

@Service
public class DocenteBusiness {

	
	@Autowired
	private DocenteData docenteData;

	private TipoParticipacionInternaData tipoParticipacionInternaData;

	@Autowired
	public void setTipoParticipacionInternaData(TipoParticipacionInternaData tipoParticipacionInternaData) {
		this.tipoParticipacionInternaData = tipoParticipacionInternaData;
	}

	public void guardarDocente(Docente docente, String nombreRecinto) {
		docenteData.guardarDocente(docente, nombreRecinto);
	}
	
	public void actualizarDocente(Docente docente, String nombreRecinto) {
		docenteData.actualizarDocente(docente, nombreRecinto);
	}
	
	public void borrarDocente(int idDocente) {
		docenteData.borrarDocente(idDocente);
	}
	
	public List<Docente> cargarDocentes(){
		return docenteData.cargarDocentes();
	}

	// este metodo hace lo mismo que cargarDocentes
	public List<Docente> getAllDocentes() {
		return docenteData.getAllDocentes();
	}

	public Docente getDocenteById(int idDocente) {
		return docenteData.getDocenteById(idDocente);
	}

	public List<TipoParticipacionInterna> getAllParticipaciones() {
		return tipoParticipacionInternaData.getAllParticipacionInterna();
	}
}
