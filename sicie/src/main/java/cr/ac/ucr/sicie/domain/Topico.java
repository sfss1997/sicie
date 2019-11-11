package cr.ac.ucr.sicie.domain;

public class Topico {
	
	private int idTopico;
	private String topico;
	
	
	
	public Topico(int idTopico, String topico) {
		this.idTopico = idTopico;
		this.topico = topico;
	}
	
	public int getIdTopico() {
		return idTopico;
	}
	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}
	public String getTopico() {
		return topico;
	}
	public void setTopico(String topico) {
		this.topico = topico;
	}
	
	
	

}
