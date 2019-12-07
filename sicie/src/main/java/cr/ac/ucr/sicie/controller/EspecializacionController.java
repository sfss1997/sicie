package cr.ac.ucr.sicie.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.sicie.bussines.EspecializacionBusiness;
import cr.ac.ucr.sicie.domain.Especializacion;

@CrossOrigin(origins ="http://localhost:4200",maxAge=3600)
@RestController
@RequestMapping("/api/especializacion")
public class EspecializacionController {

	@Autowired
	private EspecializacionBusiness especializacionBusiness;
	
	
	@GetMapping("/listaEspecializacion")
	public ResponseEntity<List<Especializacion>> cargarEspecializacion(){
		List<Especializacion> especializacion = especializacionBusiness.cargarEspecializacion();
		return new ResponseEntity<List<Especializacion>>(especializacion, HttpStatus.OK);
	}
}
