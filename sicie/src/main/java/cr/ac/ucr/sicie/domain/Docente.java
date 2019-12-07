package cr.ac.ucr.sicie.domain;

import java.util.List;

public class Docente {
	
	private int idDocente;
	private String correoInstitucional;
	private String nombre;
	private String apellidos;
	private String gradoAcademico;
	private List<Topico> topicosDeInteres;
	private List<Especializacion> especializacion;
	private boolean activo;
	
	
	public Docente(int idDocente,String correoInstitucional, String nombre, String apellidos, String gradoAcademico,
			List<Topico> topicosDeInteres, List<Especializacion> especializacion, boolean activo) {
//		if (correoInstitucional.equals("") || nombre.equals("") || apellidos.equals("") ||
//				gradoAcademico.equals("") || topicosDeInteres.equals("")) new RuntimeException("Las etiquetas viene vacías");
//		if (especializacion.isEmpty()) new RuntimeException("La lista especialización viene vacía");
		this.idDocente = idDocente;
		this.correoInstitucional = correoInstitucional;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.gradoAcademico = gradoAcademico;
		this.topicosDeInteres = topicosDeInteres;
		this.especializacion = especializacion;
		this.activo = activo;
	}
	
	public Docente(int idDocente, String correoInstitucional, String nombre, String apellidos, String gradoAcademico, boolean activo) {
//		if (correoInstitucional.equals("") || nombre.equals("") || apellidos.equals("") ||
//				gradoAcademico.equals("")) new RuntimeException("Las etiquetas viene vacías");
		this.idDocente = idDocente;
		this.correoInstitucional = correoInstitucional;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.gradoAcademico = gradoAcademico;
		this.activo = activo;
	}

	public Docente() {}


	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getCorreoInstitucional() {
		return correoInstitucional;
	}


	public void setCorreoInstitucional(String correoInstitucional) {
//		if (correoInstitucional.equals("")) new RuntimeException("Las etiquetas viene vacías");
		this.correoInstitucional = correoInstitucional;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
//		if (nombre.equals("")) new RuntimeException("Las etiquetas viene vacías");
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
//		if (apellidos.equals("") ) new RuntimeException("Las etiquetas viene vacías");
		this.apellidos = apellidos;
	}


	public String getGradoAcademico() {
		return gradoAcademico;
	}


	public void setGradoAcademico(String gradoAcademico) {
//		if (gradoAcademico.equals("")) new RuntimeException("Las etiquetas viene vacías");
		this.gradoAcademico = gradoAcademico;
	}


	public List<Topico> getTopicosDeInteres() {
		return topicosDeInteres;
	}


	public void setTopicosDeInteres(List<Topico> topicosDeInteres) {
//		if (topicosDeInteres.isEmpty()) new RuntimeException("Las etiquetas viene vacías");
		this.topicosDeInteres = topicosDeInteres;
	}


	public List<Especializacion> getEspecializacion() {
		return especializacion;
	}


	public void setEspecializacion(List<Especializacion> especializacion) {
//		if (especializacion.isEmpty()) new RuntimeException("La lista especialización viene vacía");
		this.especializacion = especializacion;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
