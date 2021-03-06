/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.ProgramaCurso;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
public class ProgramaCursoData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
 
  
    public Iterator<ProgramaCurso> listarProgramasCurso(){   
        
         String selectMysql;
		selectMysql = "SELECT version,vigente,sigla_curso FROM programa_curso";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
					(rs, row) -> new ProgramaCurso(
                                rs.getInt("version"),
                                rs.getBoolean("vigente"),
                                rs.getString("sigla_curso"),
                                rs.getString("programa_curso_base"))).iterator();
	
        
    }
    
   
    public Iterator<ProgramaCurso> buscarProgramasPorCurso(String sigla){
        String selectSql = "SELECT version,vigente,sigla_curso,programa_curso_base FROM programa_curso WHERE sigla_curso="+sigla+";";
        return jdbcTemplate
                .query(selectSql, new Object[]{},
                        (rs, row) -> new ProgramaCurso(
                                rs.getInt("version"),
                                rs.getBoolean("vigente"),
                                rs.getString("sigla_curso"),
                                rs.getString("programa_curso_base"))).iterator();
    }
    

    public void insertarProgramaCurso(ProgramaCurso programaCurso){
       
        Connection connection = null;
        try {
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
                
                String sqlInsert = "INSERT INTO programa_curso(version,vigente,sigla_curso) VALUES(?,?,?);";
                PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setInt(1, programaCurso.getVersion());
                        stmt.setObject(2, programaCurso.isVigente());
			stmt.setString(3,programaCurso.getSiglaCurso());
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
    
    
    public void eliminarProgramaCurso(int version,String siglaCurso){
        
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            String sqlInsert = "DELETE FROM programa_curso WHERE version=? AND sigla_curso=?;";
            PreparedStatement stmt = connection.prepareStatement(sqlInsert);
            stmt.setInt(1, version);
            stmt.setString(2, siglaCurso);
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
    
    
    public void actualizarProgramaCurso(ProgramaCurso programaCurso,String siglaCurso){
       
        Connection connection = null;
        try {
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
                
                String sqlInsert = "Update programa_curso SET vigente=? WHERE version=? AND sigla_curso=?;";
                PreparedStatement stmt = connection.prepareStatement(sqlInsert);
                        stmt.setObject(1, programaCurso.isVigente());
                        stmt.setInt(2, programaCurso.getVersion());
                        stmt.setString(3, siglaCurso);
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




