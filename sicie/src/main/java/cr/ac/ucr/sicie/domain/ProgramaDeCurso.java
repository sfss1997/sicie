package cr.ac.ucr.sicie.domain;

import java.io.File;

public class ProgramaDeCurso {

	private int idPrograma;
	private File enunciadoPrograma;
	private int anioAprobacion;
	private boolean vigente;
	
	public ProgramaDeCurso() {
	
	}

	public int getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	public File getEnunciadoPrograma() {
		return enunciadoPrograma;
	}

	public void setEnunciadoPrograma(File enunciadoPrograma) {
		this.enunciadoPrograma = enunciadoPrograma;
	}

	public int getAnioAprobacion() {
		return anioAprobacion;
	}

	public void setAnioAprobacion(int anioAprobacion) {
		this.anioAprobacion = anioAprobacion;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
	
	
	
	
}
