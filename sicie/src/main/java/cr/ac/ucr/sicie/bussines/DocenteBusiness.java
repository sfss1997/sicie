package com.sitio.docentes.bussines;

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
}
