package cr.ac.ucr.sicie.controller;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import cr.ac.ucr.sicie.domain.TipoParticipacionInterna;
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

import cr.ac.ucr.sicie.bussines.DocenteBusiness;
import cr.ac.ucr.sicie.domain.Docente;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/docente")
public class DocenteController {

	
	@Autowired
	private DocenteBusiness docenteBusiness;
	
	
	@PostMapping("/{nombreRecinto}")
	public ResponseEntity<Docente> guardarDocente(@RequestBody Docente docente, @PathVariable String nombreRecinto) {
		
		docenteBusiness.guardarDocente(docente,nombreRecinto);
		return new ResponseEntity<Docente>(HttpStatus.OK);
		
	}
	
	@GetMapping("/listaDocentes")
	public ResponseEntity<List<Docente>> cargarDocentes(){
		List<Docente> docentes = docenteBusiness.cargarDocentes();
		return new ResponseEntity<List<Docente>>(docentes, HttpStatus.OK);
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

	@GetMapping(path = "/participaciones")
	public ResponseEntity<List<TipoParticipacionInterna>> getAllParticipaciones () {
		List<TipoParticipacionInterna> participaciones = docenteBusiness.getAllParticipaciones();
		return new ResponseEntity<List<TipoParticipacionInterna>>(participaciones, HttpStatus.OK);
	}
}
