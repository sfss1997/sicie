/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.bussines.BloqueBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sicie.domain.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author fabian
 */

@Repository
public class CursoData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    
    private BloqueBusiness bloqueBusiness;
    
    @Transactional
    public Iterator<Curso> listarCursos(){
        
        String selectMysql;
		selectMysql = "SELECT sigla,nombre,nivel,creditos,plan_estudio_codigo,optativa FROM curso";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						
                                               (rs, row) -> new Curso(bloqueBusiness.buscarBloquePorCurso(rs.getString("sigla")),//bloque
                                                       null,//cursosRequisitosLista
                                                       null,//cursosCorrequisitosLista
                                                       null,//enfasisLista
                                                       null,//programasLista
                                                       rs.getString("plan_estudio_codigo"),
                                                       rs.getString("sigla"),
                                                       rs.getString("nombre"),
                                                       rs.getInt("creditos"),
                                                       rs.getInt("nivel"),
                                                       rs.getBoolean("optativo"))).iterator();
    }
    
    @Transactional
    public List<Curso> buscarCursos(String sigla){
        List<Curso> cursos = new ArrayList<Curso>();
        String sqlScript = "SELECT * FROM curso WHERE sigla="+sigla+";";
        
        return cursos;
    }
    
    @Transactional
    public void insertarCurso(Curso curso){
        Connection connection = null;
        try {
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
                
                String sqlInsert = "INSERT INTO curso (sigla,nombre,nivel,creditos,plan_estudio_codigo,optativa) VALUES(?,?,?,?,?,?);";
                PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, curso.getSigla());
			stmt.setString(2, curso.getNombre());
			stmt.setInt(3, curso.getNivel());
			stmt.setInt(4, curso.getCreditos());
			stmt.setString(5, curso.getPlanDeEstudios());
			stmt.setObject(6, curso.isOptativa());
			stmt.execute();
        
        connection.commit();
        } catch (Exception e) {
            try {
                System.out.print(e.toString());
                connection.rollback();

            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
     
    @Transactional
    public void eliminarCurso(String sigla){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            String sqlInsert = "DELETE FROM curso WHERE sigla=?;";
            PreparedStatement stmt = connection.prepareStatement(sqlInsert);
            stmt.setString(1, sigla);
            stmt.execute();

            connection.commit();
        } catch (Exception e) {
            try {
                System.out.print(e.toString());
                connection.rollback();

            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Transactional
    public void actualizarCurso(Curso curso) {
        Connection connection = null;
        try {
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
                
                String sqlInsert = "UPDATE curso SET nombre=?,nivel=?,creditos=?,plan_estudio_codigo=?,optativa=? WHERE sigla=?;";
                PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			
			stmt.setString(1, curso.getNombre());
			stmt.setInt(2, curso.getNivel());
			stmt.setInt(3, curso.getCreditos());
			stmt.setString(4, curso.getPlanDeEstudios());
			stmt.setObject(5, curso.isOptativa());
                        stmt.setString(6, curso.getSigla());
			stmt.execute();
        
        connection.commit();
        } catch (Exception e) {
            try {
                System.out.print(e.toString());
                connection.rollback();

            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

//class CursoExtractor implements ResultSetExtractor<Curso> {
//	@Override
//	public Curso extractData(ResultSet rs) throws SQLException, DataAccessException {
//		
//		rs.next();
//                
//                String sigla = rs.getString("sigla");
//                String nombre = rs.getString("nombre");
//                int nivel = rs.getInt("nivel");
//                int creditos = rs.getInt("creditos");
//                String planDeEstudios = rs.getString("plan_estudio_codigo");
//                boolean optativa = rs.getBoolean("optativa");
//               
//		//return new Curso(sigla, nombre, nivel, creditos, planDeEstudios, optativa);
//                return new Curso(null,//bloque
//                        null,//cursosRequisitos
//                        null,//cursosCorrequisitos,
//                        null,//enfasis,
//                        null,//programas,
//                        planDeEstudios,
//                        sigla,
//                        nombre,
//                        creditos,
//                        nivel,
//                        optativa);
//	}
//}
