package cr.ac.ucr.sicie.domain;

import java.util.LinkedList;
import java.util.List;

public class Curso {

	private int sigla;
	private String nombre;
	private int creditos;
	private int nivel;
	private PlanDeEstudio plan;
	private Bloque bloque;
	private List<Curso> cursosRequisito;
	private List<ProgramaDeCurso> programasDeCurso;
	
	
	
	
	public Curso() {
		this.cursosRequisito = new LinkedList<Curso>();
		this.programasDeCurso = new LinkedList<ProgramaDeCurso>();
		this.bloque  = new Bloque();
		this.plan = new PlanDeEstudio();
	}
	public int getSigla() {
		return sigla;
	}
	public void setSigla(int sigla) {
		this.sigla = sigla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
