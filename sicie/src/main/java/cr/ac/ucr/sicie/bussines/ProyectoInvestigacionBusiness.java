package cr.ac.ucr.sicie.bussines;

import cr.ac.ucr.sicie.data.ProyectoInvestigacionData;
import cr.ac.ucr.sicie.domain.ProyectoInvestigacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoInvestigacionBusiness {

    @Autowired
    ProyectoInvestigacionData proyectoInvestigacionData;

    public List<ProyectoInvestigacion> getAllProyectosInvestigacion() {
        return proyectoInvestigacionData.getAllProyectosInvestigacion();
    }

    public ProyectoInvestigacion saveProyecto(ProyectoInvestigacion proyectoInvestigacion) {
        return proyectoInvestigacionData.saveProyecto(proyectoInvestigacion);
    }

    public List<ProyectoInvestigacion> getProyectosByFiltro(int idRecinto, String tituloProyecto, String docente) {
        return proyectoInvestigacionData.getProyectosByFiltro(idRecinto, tituloProyecto, docente);
    }

    public boolean deleteProyecto(int idProyecto) {
        return proyectoInvestigacionData.deleteProyecto(idProyecto);
    }

}
