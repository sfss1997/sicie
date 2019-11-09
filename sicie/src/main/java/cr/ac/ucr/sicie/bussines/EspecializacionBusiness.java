package com.sitio.docentes.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitio.docentes.data.EspecializacionData;
import com.sitio.docentes.domain.Especializacion;
import com.sitio.docentes.domain.SedeORecinto;

@Service
public class EspecializacionBusiness {
	
	@Autowired
	private EspecializacionData especializacionData;
	
	public Iterator<Especializacion> cargarEspecializacion(){
		return especializacionData.cargarEspecializacion();
	}
}
