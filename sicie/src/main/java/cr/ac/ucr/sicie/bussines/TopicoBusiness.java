package com.sitio.docentes.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitio.docentes.data.TopicoData;
import com.sitio.docentes.domain.SedeORecinto;
import com.sitio.docentes.domain.Topico;

@Service
public class TopicoBusiness {
	@Autowired
	private TopicoData topicoData;
	
	public Iterator<Topico> cargarTopicos(){
		return topicoData.cargarTopicos();
	}
}
