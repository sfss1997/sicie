package cr.ac.ucr.sicie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sicie.domain.Docente;

@Repository
public class DocenteData {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Transactional
	public void guardarDocente(Docente docente, String nombreRecinto) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			String sqlInsert = "INSERT INTO `IF-6100_Docente`.`Docente` (`correo_institucional`,`nombre`, `apellidos`, `gradoAcademico`,`activo`)"
					+ "VALUES (?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, docente.getCorreoInstitucional());
			stmt.setString(2, docente.getNombre());
			stmt.setString(3, docente.getApellidos());
			stmt.setString(4, docente.getGradoAcademico());
			stmt.setObject(5, docente.isActivo());
			stmt.execute();
			
			
			for (int i=0; i< docente.getEspecializacion().size();i++) {
				String sqlInsertDocenteTopicos ="INSERT INTO `IF-6100_Docente`.`DocenteTopico` (`correo_institucional`,`nombretopico`)"
						+ "VALUES (?,?);";
				PreparedStatement insertTopicos = connection.prepareStatement(sqlInsertDocenteTopicos);
				insertTopicos.setString(1, docente.getCorreoInstitucional());
				insertTopicos.setString(2, docente.getTopicosDeInteres().get(i));
				insertTopicos.execute();
			}
			
			for (int i=0; i< docente.getEspecializacion().size();i++) {
				String sqlInsertDocenteEspecializacion="INSERT INTO `IF-6100_Docente`.`DocenteEspecializacion` (`correo_institucional`,`especializacion`)" 
						+ "VALUES (?,?);";
				PreparedStatement insertEspecializacion = connection.prepareStatement(sqlInsertDocenteEspecializacion);
				insertEspecializacion.setString(1, docente.getCorreoInstitucional());
				insertEspecializacion.setString(2, docente.getEspecializacion().get(i));
				insertEspecializacion.execute();
			}
			
			String sqlInsertRecintoDocente = "INSERT INTO `IF-6100_Docente`.`RecintoDocente` (`nombre`,`correoInstitucional`)" 
					+ "VALUES (?,?);";
			PreparedStatement insertRecintoLaboral = connection.prepareStatement(sqlInsertRecintoDocente);
			insertRecintoLaboral.setString(1, docente.getNombre()+" "+docente.getApellidos());
			insertRecintoLaboral.setString(2, nombreRecinto);
			insertRecintoLaboral.execute();
			
			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	@Transactional
	public void actualizarDocente(Docente docente, String nombreRecinto) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			
			String sqlBorrarEspecializacion = "DELETE FROM `IF-6100_Docentes`.`DocenteEspecializacion`" + 
					" WHERE `correo_institucional` =?;";
			PreparedStatement espec = connection.prepareStatement(sqlBorrarEspecializacion);
			espec.setString(1, docente.getCorreoInstitucional());
			espec.execute();
			
			String sqlBorrarTopico = "DELETE FROM `IF-6100_Docentes`.`DocenteTopico`" + 
					"WHERE `correo_institucional` = ?;";
			PreparedStatement topico = connection.prepareStatement(sqlBorrarTopico);
			topico.setString(1, docente.getCorreoInstitucional());
			topico.execute();
			
			String sqlBorrarRecintoDocente = "DELETE FROM `IF-6100_Docentes`.`RecintoDocente`" + 
					" WHERE `correoInstitucional` = ?;";
			PreparedStatement docenteRecinto = connection.prepareStatement(sqlBorrarRecintoDocente);
			docenteRecinto.setString(1, docente.getCorreoInstitucional());
			docenteRecinto.execute();
			
			String sqlActualizar = "UPDATE `IF-6100_Docentes`.`Docente`" + 
					" SET `correo_institucional` = ?, `nombre` = ?," + 
					" `apellidos` = ?, `gradoAcademico` = ?," + 
					" `activo` = ? WHERE `correo_institucional` = ?;" ;
			PreparedStatement stmt = connection.prepareStatement(sqlActualizar);
			stmt.setString(1, docente.getCorreoInstitucional());
			stmt.setString(2, docente.getNombre());
			stmt.setString(3, docente.getApellidos());
			stmt.setString(4, docente.getGradoAcademico());
			stmt.setObject(5, docente.isActivo());
			stmt.setString(6, docente.getCorreoInstitucional());
			stmt.execute();
			
			for (int i=0; i< docente.getEspecializacion().size();i++) {
				String sqlInsertDocenteTopicos ="INSERT INTO `IF-6100_Docente`.`DocenteTopico` (`correo_institucional`,`nombretopico`)"
						+ "VALUES (?,?);";
				PreparedStatement insertTopicos = connection.prepareStatement(sqlInsertDocenteTopicos);
				insertTopicos.setString(1, docente.getCorreoInstitucional());
				insertTopicos.setString(2, docente.getTopicosDeInteres().get(i));
				insertTopicos.execute();
			}
			
			for (int i=0; i< docente.getEspecializacion().size();i++) {
				String sqlInsertDocenteEspecializacion="INSERT INTO `IF-6100_Docente`.`DocenteEspecializacion` (`correo_institucional`,`especializacion`)" 
						+ "VALUES (?,?);";
				PreparedStatement insertEspecializacion = connection.prepareStatement(sqlInsertDocenteEspecializacion);
				insertEspecializacion.setString(1, docente.getCorreoInstitucional());
				insertEspecializacion.setString(2, docente.getEspecializacion().get(i));
				insertEspecializacion.execute();
			}
			
			String sqlInsertRecintoDocente = "INSERT INTO `IF-6100_Docente`.`RecintoDocente` (`nombre`,`correoInstitucional`)" 
					+ "VALUES (?,?);";
			PreparedStatement insertRecintoLaboral = connection.prepareStatement(sqlInsertRecintoDocente);
			insertRecintoLaboral.setString(1, docente.getNombre()+" "+docente.getApellidos());
			insertRecintoLaboral.setString(2, nombreRecinto);
			insertRecintoLaboral.execute();
			
			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	
	@Transactional
	public void borrarDocente(String correoInstitucional) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			
			String sqlBorrarEspecializacion = "DELETE FROM `IF-6100_Docentes`.`DocenteEspecializacion`" + 
					" WHERE `correo_institucional` =?;";
			PreparedStatement espec = connection.prepareStatement(sqlBorrarEspecializacion);
			espec.setString(1, correoInstitucional);
			espec.execute();
			
			String sqlBorrarTopico = "DELETE FROM `IF-6100_Docentes`.`DocenteTopico`" + 
					"WHERE `correo_institucional` = ?;";
			PreparedStatement topico = connection.prepareStatement(sqlBorrarTopico);
			topico.setString(1, correoInstitucional);
			topico.execute();
			
			String sqlBorrarRecintoDocente = "DELETE FROM `IF-6100_Docentes`.`RecintoDocente`" + 
					" WHERE `correoInstitucional` = ?;";
			PreparedStatement docenteRecinto = connection.prepareStatement(sqlBorrarRecintoDocente);
			docenteRecinto.setString(1, correoInstitucional);
			docenteRecinto.execute();
			
			String sqlBorrarDocente = "DELETE FROM `IF-6100_Docentes`.`Docente`" + 
					" WHERE `correo_institucional` = ?;";
			PreparedStatement docente = connection.prepareStatement(sqlBorrarDocente);
			docente.setString(1, correoInstitucional);
			docente.execute();
			
			
			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	public Iterator<Docente> cargarDocentes(){
		String selectMysql;
		selectMysql = "SELECT `Docente`.`correo_institucional`, `Docente`.`nombre`,`Docente`.`apellidos`, `Docente`.`gradoAcademico`, `Docente`.`activo` FROM `IF-6100_Docentes`.`Docente`;";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new Docente(rs.getString("correo_institucional"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("gradoAcademico"),rs.getBoolean("activo"))).iterator();
	}
	

}
;