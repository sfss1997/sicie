package com.sitio.docentes.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitio.docentes.data.DocenteData;
import com.sitio.docentes.domain.Docente;

@Service
public class DocenteBusiness {

	
	@Autowired
	private DocenteData docenteData;
	
	
	public void guardarDocente(Docente docente, String nombreRecinto) {
		docenteData.guardarDocente(docente, nombreRecinto);
	}
	
	public void actualizarDocente(Docente docente, String nombreRecinto) {
		docenteData.actualizarDocente(docente, nombreRecinto);
	}
	
	public void borrarDocente(int idDocente) {
		docenteData.borrarDocente(idDocente);
	}
	
	public Iterator<Docente> cargarDocentes(){
		return docenteData.cargarDocentes();
	}
}
