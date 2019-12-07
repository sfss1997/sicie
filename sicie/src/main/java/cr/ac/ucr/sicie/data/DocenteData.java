package cr.ac.ucr.sicie.data;

import java.sql.*;
import java.util.Iterator;

import java.util.List;
import java.util.LinkedList;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sicie.domain.Docente;
import cr.ac.ucr.sicie.domain.Especializacion;
import cr.ac.ucr.sicie.domain.SedeORecinto;
import cr.ac.ucr.sicie.domain.Topico;

@Repository
public class DocenteData {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	public List<Docente> getAllDocentes() {
		String sqlSelect = "SELECT id_docente, nombre, apellidos, grado_academico, activo, correo_institucional" +
				" FROM Docente;";
		List<Docente> docentes = new LinkedList<>(jdbcTemplate.query(sqlSelect, new Object[]{}, (rs, row) ->
				new Docente(rs.getInt("id_docente"),
						rs.getString("correo_institucional"),
						rs.getString("nombre"),
						rs.getString("apellidos"),
						rs.getString("grado_academico"),
						null,
						null,
						rs.getBoolean("activo"))));
		return docentes;
	}

	public Docente getDocenteById(int idDocente) {
		CallableStatement cstmt = null;
		Docente docente = null;

		String sqlStoredProcedure = "{call get_docente_by_id(?, ?, ?, ?, ?, ?)}";

		try (Connection conn = dataSource.getConnection()) {
			cstmt = conn.prepareCall(sqlStoredProcedure);

			cstmt.setInt(1, idDocente);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.TINYINT);
			cstmt.registerOutParameter(6, Types.VARCHAR);

			cstmt.execute();

			docente = new Docente();
			docente.setIdDocente(idDocente);
			docente.setNombre(cstmt.getString(2));
			docente.setApellidos(cstmt.getString(3));
			docente.setGradoAcademico(cstmt.getString(4));
			docente.setActivo(cstmt.getBoolean(5));
			docente.setCorreoInstitucional(cstmt.getString(6));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(cstmt != null) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return docente;
	}
	
	public void guardarDocente(Docente docente, String nombreRecinto) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			String sqlInsert = "insert into Docente(id_docente,correo_institucional,nombre,apellidos,grado_academico,activo) values(?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setInt(1, docente.getIdDocente());
			stmt.setString(2, docente.getCorreoInstitucional());
			stmt.setString(3, docente.getNombre());
			stmt.setString(4, docente.getApellidos());
			stmt.setString(5, docente.getGradoAcademico());
			stmt.setObject(6, docente.isActivo());
			stmt.execute();
			
			
			for (int i=0; i< docente.getTopicosDeInteres().size();i++) {
				String sqlInsertDocenteTopicos ="insert into Docente_Topicos_de_Interes(id_docente,id_topico) values(?,?);";
				PreparedStatement insertTopicos = connection.prepareStatement(sqlInsertDocenteTopicos);
				insertTopicos.setInt(1, docente.getIdDocente());
				Topico topico = getIdTopico(docente.getTopicosDeInteres().get(i).getTopico());
				insertTopicos.setInt(2, topico.getIdTopico());
				insertTopicos.execute();
			}
			
			for (int i=0; i< docente.getEspecializacion().size();i++) {
				String sqlInsertDocenteEspecializacion="insert into Docente_Especializacion(id_docente,id_especializacion) values(?,?);";
				PreparedStatement insertEspecializacion = connection.prepareStatement(sqlInsertDocenteEspecializacion);
				insertEspecializacion.setInt(1, docente.getIdDocente());
				Especializacion especializacion = getIdEspecializacion(docente.getEspecializacion().get(i).getEspecializacion());
				
				insertEspecializacion.setInt(2, especializacion.getIdEspecializacion());
				insertEspecializacion.execute();
			}
			
			String sqlInsertRecintoDocente = "insert into Recinto_Docente(id_recinto,id_docente) values (?,?);";
			PreparedStatement insertRecintoLaboral = connection.prepareStatement(sqlInsertRecintoDocente);
			insertRecintoLaboral.setInt(1, getIdRecinto(nombreRecinto).getIdRecinto());
			insertRecintoLaboral.setInt(2, docente.getIdDocente());
			insertRecintoLaboral.execute();
			
			connection.commit();
		}catch(Exception e){
			try {
				System.out.print(e.toString());
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
	
	private Topico getIdTopico(String nombreTopico) {
		String sqlSelect = "select id_topico,topico from Topico_de_interes where topico='"+nombreTopico+"'";
		return jdbcTemplate.query(sqlSelect, new TopicoExtractor());
	}
	
	private Especializacion getIdEspecializacion(String nombreEspecializacion) {
		String sqlSelect = "select id_especializacion,especializacion from Especializacion where especializacion='"+nombreEspecializacion+"'";
		return jdbcTemplate.query(sqlSelect, new EspecializacionExtractor());
	}
	
	private SedeORecinto getIdRecinto(String nombreRecinto) {
		String sqlSelect = "select id_recinto,nombre_recinto from Recinto where nombre_recinto='"+nombreRecinto+"'";
		return jdbcTemplate.query(sqlSelect, new RecintoExtractor());
	}
	
	@Transactional
	public void actualizarDocente(Docente docente, String nombreRecinto) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			
			String sqlBorrarEspecializacion = "delete from Docente_Especializacion where id_docente=?";
			PreparedStatement espec = connection.prepareStatement(sqlBorrarEspecializacion);
			espec.setInt(1, docente.getIdDocente());
			espec.execute();
			
			String sqlBorrarTopico = "delete from Docente_Topicos_de_Interes where id_docente=?";
			PreparedStatement topico = connection.prepareStatement(sqlBorrarTopico);
			topico.setInt(1, docente.getIdDocente());
			topico.execute();
			
			String sqlBorrarRecintoDocente = "delete from Recinto_Docente where id_docente=?";
			PreparedStatement docenteRecinto = connection.prepareStatement(sqlBorrarRecintoDocente);
			docenteRecinto.setInt(1, docente.getIdDocente());
			docenteRecinto.execute();
			
			String sqlActualizar = "update Docente set correo_institucional = ?, nombre=?, apellidos = ?, grado_academico=?,activo=? where id_docente = ?" ;
			PreparedStatement stmt = connection.prepareStatement(sqlActualizar);
			stmt.setString(1, docente.getCorreoInstitucional());
			stmt.setString(2, docente.getNombre());
			stmt.setString(3, docente.getApellidos());
			stmt.setString(4, docente.getGradoAcademico());
			stmt.setObject(5, docente.isActivo());
			stmt.setInt(6, docente.getIdDocente());
			stmt.execute();
			
			for (int i=0; i< docente.getTopicosDeInteres().size();i++) {
				String sqlInsertDocenteTopicos ="insert into Docente_Topicos_de_Interes(id_docente,id_topico) values(?,?);";
				PreparedStatement insertTopicos = connection.prepareStatement(sqlInsertDocenteTopicos);
				insertTopicos.setInt(1, docente.getIdDocente());
				Topico topico1 = getIdTopico(docente.getTopicosDeInteres().get(i).getTopico());
				insertTopicos.setInt(2, topico1.getIdTopico());
				insertTopicos.execute();
			}
			
			for (int i=0; i< docente.getEspecializacion().size();i++) {
				String sqlInsertDocenteEspecializacion="insert into Docente_Especializacion(id_docente,id_especializacion) values(?,?);";
				PreparedStatement insertEspecializacion = connection.prepareStatement(sqlInsertDocenteEspecializacion);
				insertEspecializacion.setInt(1, docente.getIdDocente());
				Especializacion especializacion1 = getIdEspecializacion(docente.getEspecializacion().get(i).getEspecializacion());
				insertEspecializacion.setInt(2, especializacion1.getIdEspecializacion());
				insertEspecializacion.execute();
			}
			
			String sqlInsertRecintoDocente = "insert into Recinto_Docente(id_recinto,id_docente) values (?,?);";
			PreparedStatement insertRecintoLaboral = connection.prepareStatement(sqlInsertRecintoDocente);
			insertRecintoLaboral.setInt(1, getIdRecinto(nombreRecinto).getIdRecinto());
			insertRecintoLaboral.setInt(2, docente.getIdDocente());
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
	public void borrarDocente(int idDocente) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			
			String sqlBorrarEspecializacion = "delete from Docente_Especializacion where id_docente=?";
			PreparedStatement espec = connection.prepareStatement(sqlBorrarEspecializacion);
			espec.setInt(1, idDocente);
			espec.execute();
			
			String sqlBorrarTopico = "delete from Docente_Topicos_de_Interes where id_docente=?";
			PreparedStatement topico = connection.prepareStatement(sqlBorrarTopico);
			topico.setInt(1, idDocente);
			topico.execute();
			
			String sqlBorrarRecintoDocente = "delete from Recinto_Docente where id_docente=?";
			PreparedStatement docenteRecinto = connection.prepareStatement(sqlBorrarRecintoDocente);
			docenteRecinto.setInt(1, idDocente);
			docenteRecinto.execute();
			
			String sqlBorrarDocente = "delete Docente where id_docente=?";
			PreparedStatement docente = connection.prepareStatement(sqlBorrarDocente);
			docente.setInt(1, idDocente);
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
	
	public List<Docente> cargarDocentes(){
		String selectMysql;
		selectMysql = "select id_docente, correo_institucional, nombre,apellidos, grado_academico,activo from Docente";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new Docente(rs.getInt("id_docente"),rs.getString("correo_institucional"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("grado_academico"),rs.getBoolean("activo")));
	}
	

}

class TopicoExtractor implements ResultSetExtractor<Topico> {
	@Override
	public Topico extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		rs.next();
		
		int idTopico = rs.getInt("id_topico");
		String nombreTopico = rs.getString("topico");
		return new Topico(idTopico,nombreTopico);
	}

}

class EspecializacionExtractor implements ResultSetExtractor<Especializacion> {
	@Override
	public Especializacion extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		rs.next();
		
		int idEspecializacion = rs.getInt("id_especializacion");
		String nombreEspecializacion = rs.getString("especializacion");
		return new Especializacion(idEspecializacion,nombreEspecializacion);
	}

}

class RecintoExtractor implements ResultSetExtractor<SedeORecinto> {
	@Override
	public SedeORecinto extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		rs.next();
		
		int idRecinto = rs.getInt("id_recinto");
		String nombreRecinto = rs.getString("nombre_recinto");
		return new SedeORecinto(idRecinto,nombreRecinto);
	}

}
