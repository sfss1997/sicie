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

import cr.ac.ucr.sicie.bussines.TopicoBusiness;
import cr.ac.ucr.sicie.domain.Topico;

@CrossOrigin(origins ="http://localhost:4200",maxAge=3600)
@RestController
@RequestMapping("/api/topico")
public class TopicosController {
	
	@Autowired
	private TopicoBusiness topicoBusiness;
	
	
	@GetMapping("/listaTopico")
	public ResponseEntity<List<Topico>> cargarTopico(){
		List<Topico> topico = topicoBusiness.cargarTopicos();
		return new ResponseEntity<List<Topico>>(topico, HttpStatus.OK);
	}

}
