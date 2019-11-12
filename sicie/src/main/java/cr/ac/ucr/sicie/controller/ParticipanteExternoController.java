package cr.ac.ucr.sicie.controller;

import cr.ac.ucr.sicie.bussines.ParticipanteExternoBusiness;
import cr.ac.ucr.sicie.domain.ParticipanteExterno;
import cr.ac.ucr.sicie.domain.TipoParticipacionExterna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/participanteExterno")
public class ParticipanteExternoController {

    @Autowired
    ParticipanteExternoBusiness participanteExternoBusiness;

    @GetMapping(path = "/")
    public ResponseEntity<List<ParticipanteExterno>> getAllParticipantesExternos() {
        List<ParticipanteExterno> participantesExternos = participanteExternoBusiness.getAllParticipantesExternos();
        return new ResponseEntity<List<ParticipanteExterno>>(participantesExternos, HttpStatus.OK);
    }

    @GetMapping(path = "/participaciones")
    public ResponseEntity<List<TipoParticipacionExterna>> getAllParticipaciones() {
        List<TipoParticipacionExterna> participaciones = participanteExternoBusiness.getAllParticipaciones();
        return new ResponseEntity<List<TipoParticipacionExterna>>(participaciones, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParticipanteExterno> getParticipanteById(@PathVariable("id") int idParticipanteExterno) {
        ParticipanteExterno participanteExterno = participanteExternoBusiness.getParticipanteById(idParticipanteExterno);
        return new ResponseEntity<ParticipanteExterno>(participanteExterno, HttpStatus.OK);
    }

}
