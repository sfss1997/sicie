package cr.ac.ucr.sicie.bussines;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.sicie.data.SedeORecintoData;
import cr.ac.ucr.sicie.domain.SedeORecinto;

@Service
public class SedeORecintoBusiness {
	@Autowired
	private SedeORecintoData sedeData;
	
	
	public Iterator<SedeORecinto> cargarSedes(){
		return sedeData.cargarRecinto();
	}
	
}
