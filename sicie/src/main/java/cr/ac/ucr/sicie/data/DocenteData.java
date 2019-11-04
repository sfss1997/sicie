package cr.ac.ucr.sicie.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sicie.domain.Docente;

@Repository
public class DocenteData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public void guardarDocente(Docente docente, int idRecinto) {
		String sqlInsert = "Insert into Docente(id_docente,correo_institucional,nombre,apellidos,grado_academico,activo) VALUES ("+docente.getIdDocente()+","+docente.getCorreoInstitucional()+","+docente.getNombre()+","+docente.getApellidos()+","+docente.getGradoAcademico()+","+docente.isActivo()+");";
		jdbcTemplate.update(sqlInsert);
		for (int i=0; i< docente.getEspecializacion().size();i++) {
			String sqlInsertDocenteTopicos ="Insert into Docente_Topicos_de_Interes(id_docente,id_topico) VALUES ("+docente.getIdDocente()+","+docente.getTopicosDeInteres().get(i)+");";
			jdbcTemplate.update(sqlInsertDocenteTopicos);
		}
		
		for (int i=0; i< docente.getEspecializacion().size();i++) {
			String sqlInsertDocenteEspecializacion="Insert into Docente_Especializacion(id_docente, id_especializacion) VALUES ("+docente.getIdDocente()+","+docente.getEspecializacion().get(i)+");";
			jdbcTemplate.execute(sqlInsertDocenteEspecializacion);
		}
		
		String sqlInsertRecintoDocente = "Insert into Recinto_Docente(id_recinto,id_docente) VALUES ("+idRecinto+","+docente.getIdDocente()+");";
		jdbcTemplate.execute(sqlInsertRecintoDocente);
	}
	
	
	

}
