package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.ParticipanteExterno;
import cr.ac.ucr.sicie.domain.ProyectoInvestigacion;
import cr.ac.ucr.sicie.domain.TipoParticipacionExterna;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProyectoInvestigacionDataTest {

    @Autowired
    ProyectoInvestigacionData proyectoInvestigacionData;

    @Autowired
    ParticipanteExternoData participanteExternoData;

    @Test
    public void getAllProyectosInvestigacionTest() {
        List<ProyectoInvestigacion> proyectosInvestigacion = proyectoInvestigacionData.getAllProyectosInvestigacion();
        Assert.assertNotNull(proyectosInvestigacion);
        Assert.assertTrue(!proyectosInvestigacion.isEmpty());
    }

    @Test
    public void deleteProyectoTest() {
        boolean isDeleted = proyectoInvestigacionData.deleteProyecto(5);
        Assert.assertTrue(isDeleted);
    }

    @Test
    public void getProyectoByIdTest() {
        ProyectoInvestigacion proyectoInvestigacion = proyectoInvestigacionData.getProyectoById(16);
        Assert.assertNotNull(proyectoInvestigacion);
    }

    @Test
    public void updateProyectoTest() {
        ParticipanteExterno participanteExterno = participanteExternoData.getParticipanteById(9);
        TipoParticipacionExterna tipoParticipacionExterna = new TipoParticipacionExterna();
        tipoParticipacionExterna.setDescripcion("Colaborador");
        tipoParticipacionExterna.setParticipanteExterno(participanteExterno);
        tipoParticipacionExterna.setIdParticipacion(1);

        ProyectoInvestigacion proyectoInvestigacion = proyectoInvestigacionData.getProyectoById(16);
        proyectoInvestigacion.getTipoParticipacionesExternas().add(tipoParticipacionExterna);
        proyectoInvestigacionData.updateProyectoInvestigacion(proyectoInvestigacion);
    }

}
