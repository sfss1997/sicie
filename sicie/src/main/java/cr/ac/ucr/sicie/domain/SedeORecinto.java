package com.sitio.docentes.domain;

public class SedeORecinto {

	private int idRecinto;
	private String nombre;
	
	
	public SedeORecinto(int idRecinto,String nombre) {
		if (nombre.equals("")) new RuntimeException("El nombre de recinto es nulo");
		this.idRecinto = idRecinto;
		this.nombre = nombre;
	}

	
	
	public int getIdRecinto() {
		return idRecinto;
	}



	public void setIdRecinto(int idRecinto) {
		this.idRecinto = idRecinto;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if (nombre.equals("")) new RuntimeException("El nombre de recinto es nulo");
		this.nombre = nombre;
	}
	
	
}
