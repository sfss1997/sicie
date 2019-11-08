package com.sitio.docentes.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitio.docentes.data.SedeORecintoData;
import com.sitio.docentes.domain.Docente;
import com.sitio.docentes.domain.SedeORecinto;

@Service
public class SedeORecintoBusiness {
	@Autowired
	private SedeORecintoData sedeData;
	
	
	public Iterator<SedeORecinto> cargarSedes(){
		return sedeData.cargarRecinto();
	}
	
}
