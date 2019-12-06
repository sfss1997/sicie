/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabian
 */

@Repository
public class CursoEnfasisData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    
  
    public List<String> buscarEnfasisIdPorSiglaCurso(String siglaCurso){
        List<String> enfasis = new ArrayList<String>();
        String sqlScript = "SELECT id_bloque FROM curso_enfasis WHERE sigla_curso="+siglaCurso+";";
	
        return enfasis;
    }
    
    
    public List<String> buscarSiglaCursosPorEnfasisId(String idEnfasis){
        List<String> cursos = new ArrayList<String>();
        String sqlScript = "SELECT sigla_curso FROM curso_enfasis WHERE id_enfasis="+idEnfasis+";";
	
        return cursos;
    }
    
   
    public void insertarRelacion(String siglaCurso,String enfasisId){
        Connection connection = null;
        try {
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
                
                String sqlInsert = "INSERT INTO curso_enfasis VALUES(?,?);";
                PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, siglaCurso);
			stmt.setString(2, enfasisId);
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
    
    
    public void eliminarRelacionPorEnfasisIdOSiglaCurso(String id){
        String sqlScript = "DELETE FROM curso_enfasis WHERE id_enfasis="+id+"OR sigla_curso="+id+";";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            String sqlInsert = "DELETE FROM curso_enfasis WHERE id_enfasis=? OR sigla_curso=?;";
            PreparedStatement stmt = connection.prepareStatement(sqlInsert);
            stmt.setString(1, id);
            stmt.setString(2, id);
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
