package cr.ac.ucr.sicie.domain;

public class Especializacion {
	
	private int idEspecializacion;
	private String especializacion;
	
	public Especializacion(int idEspecializacion, String especializacion) {
		this.idEspecializacion = idEspecializacion;
		this.especializacion = especializacion;
	}

    public Especializacion() {

    }

    public int getIdEspecializacion() {
		return idEspecializacion;
	}

	public void setIdEspecializacion(int idEspecializacion) {
		this.idEspecializacion = idEspecializacion;
	}

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	
	

}
