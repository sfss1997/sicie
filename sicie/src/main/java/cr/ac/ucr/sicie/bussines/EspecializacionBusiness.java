package cr.ac.ucr.sicie.bussines;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.sicie.data.EspecializacionData;
import cr.ac.ucr.sicie.domain.Especializacion;

@Service
public class EspecializacionBusiness {
	
	@Autowired
	private EspecializacionData especializacionData;
	
	public Iterator<Especializacion> cargarEspecializacion(){
		return especializacionData.cargarEspecializacion();
	}
}
