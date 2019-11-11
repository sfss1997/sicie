package cr.ac.ucr.sicie.bussines;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.sicie.data.TopicoData;


@Service
public class TopicoBusiness {
	@Autowired
	private TopicoData topicoData;
	
	public Iterator<cr.ac.ucr.sicie.domain.Topico> cargarTopicos(){
		return topicoData.cargarTopicos();
	}
}
