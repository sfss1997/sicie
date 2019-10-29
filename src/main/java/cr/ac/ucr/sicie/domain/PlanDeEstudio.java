package cr.ac.ucr.sicie.domain;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PlanDeEstudio {
	private int codigo;
	private String nombreCarrera;
	private int anioResolucion;
	private File documentoFundamentacionCarrera;
	private boolean vigente;
	private File resolucionDeCrecionDeCarrera;
	private List<Curso> cursos;
	
	
	
	public PlanDeEstudio() {
		this.cursos = new LinkedList<Curso>();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public int getAnioResolucion() {
		return anioResolucion;
	}
	public void setAnioResolucion(int anioResolucion) {
		this.anioResolucion = anioResolucion;
	}
	public File getDocumentoFundamentacionCarrera() {
		return documentoFundamentacionCarrera;
	}
	public void setDocumentoFundamentacionCarrera(File documentoFundamentacionCarrera) {
		this.documentoFundamentacionCarrera = documentoFundamentacionCarrera;
	}
	public boolean isVigente() {
		return vigente;
	}
	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
	public File getResolucionDeCrecionDeCarrera() {
		return resolucionDeCrecionDeCarrera;
	}
	public void setResolucionDeCrecionDeCarrera(File resolucionDeCrecionDeCarrera) {
		this.resolucionDeCrecionDeCarrera = resolucionDeCrecionDeCarrera;
	}
	
	
		
}
