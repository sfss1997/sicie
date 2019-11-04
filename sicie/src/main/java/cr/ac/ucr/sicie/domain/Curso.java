import java.util.*;

public class Curso {

	private Bloque bloque;
	private Collection<Curso> cursosRequisitos;
	private Collection<Curso> cursosCorrequisitos;
	private Collection<Enfasis> enfasis;
	private Collection<ProgramaCurso> programas;
	private PlanDeEstudio planDeEstudio;
	private String sigla;
	private String nombre;
	private int creditos;
	private int nivel;
	private boolean optativa = false;

}