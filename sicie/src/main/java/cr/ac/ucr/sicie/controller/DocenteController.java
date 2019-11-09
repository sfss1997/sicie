package com.sitio.docentes.controller;


import java.sql.SQLException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitio.docentes.business.DocenteBusiness;
import com.sitio.docentes.domain.Docente;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/docente")
public class DocenteController {

	
	@Autowired
	private DocenteBusiness docenteBusiness;
	
	
	@PostMapping("/{nombreRecinto}")
	public ResponseEntity<Docente> guardarDocente(@RequestBody Docente docente, @PathVariable String nombreRecinto) {
		
		docenteBusiness.guardarDocente(docente,nombreRecinto);
		return null;
		
	}
	
	@GetMapping
	public Iterator<Docente> cargarDocentes(){
		Iterator<Docente> docentes = docenteBusiness.cargarDocentes();
		return docentes;
	}
	
	
	@PostMapping(value = "/actualizaDocente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Docente> actualizaDocente(@RequestBody final Docente docente,@PathVariable String nombreRecinto) {
		
		docenteBusiness.actualizarDocente(docente, nombreRecinto);
		return new ResponseEntity<Docente>(HttpStatus.OK);

	}
	
	@DeleteMapping(value = "/{idDocente}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Docente> borrarDocente(@PathVariable final Integer idDocente) throws SQLException {
	    
		
		docenteBusiness.borrarDocente(idDocente);
		return new ResponseEntity<Docente>(HttpStatus.NO_CONTENT);
	  
	}
}
