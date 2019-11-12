package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.ParticipanteExternoData;
import cr.ac.ucr.sicie.data.TipoParticipacionExternaData;
import cr.ac.ucr.sicie.domain.ParticipanteExterno;
import cr.ac.ucr.sicie.domain.TipoParticipacionExterna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteExternoBusiness {

    private ParticipanteExternoData participanteExternoData;
    private TipoParticipacionExternaData tipoParticipacionExternaData;

    @Autowired
    public void setTipoParticipacionExternaData(TipoParticipacionExternaData tipoParticipacionExternaData) {
        this.tipoParticipacionExternaData = tipoParticipacionExternaData;
    }

    @Autowired
    public void setParticipanteExternoData(ParticipanteExternoData participanteExternoData) {
        this.participanteExternoData = participanteExternoData;
    }

    public List<ParticipanteExterno> getAllParticipantesExternos() {
        return  participanteExternoData.getAllParticipantesExternos();
    }

    public ParticipanteExterno getParticipanteById(int idParticipanteExterno) {
        return participanteExternoData.getParticipanteById(idParticipanteExterno);
    }

    public List<TipoParticipacionExterna> getAllParticipaciones() {
        return tipoParticipacionExternaData.getAllParticipaciones();
    }
}
