package cr.ac.ucr.sicie.controller;

import cr.ac.ucr.sicie.bussines.ProyectoInvestigacionBusiness;
import cr.ac.ucr.sicie.domain.ProyectoInvestigacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/proyectoInvestigacion")
public class ProyectoInvestigacionController {


    private ProyectoInvestigacionBusiness proyectoInvestigacionBusiness;

    @Autowired
    public void setProyectoInvestigacionBusiness(ProyectoInvestigacionBusiness proyectoInvestigacionBusiness) {
        this.proyectoInvestigacionBusiness = proyectoInvestigacionBusiness;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<ProyectoInvestigacion>> getAllProyectosInvestigacion() {
        List<ProyectoInvestigacion> proyectosInvestigacion = proyectoInvestigacionBusiness.getAllProyectosInvestigacion();
        return new ResponseEntity<>(proyectosInvestigacion, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ProyectoInvestigacion> saveProyecto(@RequestBody final ProyectoInvestigacion proyectoInvestigacion) {
        ProyectoInvestigacion insertedProyecto = proyectoInvestigacionBusiness.saveProyecto(proyectoInvestigacion);
        return new ResponseEntity<ProyectoInvestigacion>(insertedProyecto, HttpStatus.OK);
    }

    @GetMapping("/{idRecinto}/{titulo}/{docente}")
    public ResponseEntity<List<ProyectoInvestigacion>> getProyectosByFiltro(@PathVariable int idRecinto,
                                                                            @PathVariable String titulo,
                                                                            @PathVariable String docente) {
        List<ProyectoInvestigacion> proyectos = proyectoInvestigacionBusiness.getProyectosByFiltro(idRecinto, titulo, docente);
        return  new ResponseEntity<List<ProyectoInvestigacion>>(proyectos, HttpStatus.OK);
    }

}
//Raelik