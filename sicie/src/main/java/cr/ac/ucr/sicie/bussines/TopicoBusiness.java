package cr.ac.ucr.sicie.bussines;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.sicie.data.TopicoData;
import cr.ac.ucr.sicie.domain.Topico;


@Service
public class TopicoBusiness {
	@Autowired
	private TopicoData topicoData;
	
	public List<Topico> cargarTopicos(){
		return topicoData.cargarTopicos();
	}
}
