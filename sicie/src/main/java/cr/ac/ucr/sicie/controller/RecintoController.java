package cr.ac.ucr.sicie.controller;

import cr.ac.ucr.sicie.bussines.SedeORecintoBusiness;
import cr.ac.ucr.sicie.domain.SedeORecinto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/recinto")
public class RecintoController {

    private SedeORecintoBusiness recintoBusiness;

    @Autowired
    public void setRecintoBusiness (SedeORecintoBusiness recintoBusiness) {
        this.recintoBusiness = recintoBusiness;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<SedeORecinto>> getAllRecintos() {
        List<SedeORecinto> recintos = recintoBusiness.getAllRecintos();
        return new ResponseEntity<>(recintos, HttpStatus.OK);
    }

}
