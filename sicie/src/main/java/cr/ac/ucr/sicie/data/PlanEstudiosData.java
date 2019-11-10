/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sicie.domain.PlanEstudios;
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
public class PlanEstudiosData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    
    
    @Transactional
    public Iterator<PlanEstudios> listarPlanesEstudios(){
        
        String selectMysql;
		selectMysql = "SELECT codigo,nombre_carrera,ano_resolucion,vigente FROM plan_estudios";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new PlanEstudios(rs.getString("codigo"),rs.getString("nombre_carrera"), rs.getInt("ano_resolucion"), rs.getBoolean("vigente"))).iterator();
        
    }
    
    @Transactional
    public List<PlanEstudios> buscarPlanesEstudios(String codigo){
        List<PlanEstudios> planesEstudios = new ArrayList<PlanEstudios>();
        String sqlScript = "SELECT * FROM plan_estudio WHERE codigo="+codigo+";";
        
        return planesEstudios;
    }
    
    @Transactional
    public void insertarPlanEstudios(PlanEstudios planEstudios){

        Connection connection = null;
        try {
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
                
                String sqlInsert = "INSERT INTO plan_estudio(codigo,nombre_carrera,ano_resolucion,vigente) VALUES(?,?,?,?);";
                PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, planEstudios.getCodigo());
			stmt.setString(2, planEstudios.getNombreCarrera());
			stmt.setInt(3, planEstudios.getAnoResolucion());
			stmt.setObject(4, planEstudios.isVigente());
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
    public void eliminarPlanEstudios(String codigo){
        
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            String sqlInsert = "DELETE FROM plan_estudio WHERE codigo=?;";
            PreparedStatement stmt = connection.prepareStatement(sqlInsert);
            stmt.setString(1, codigo);
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
    public void actualizarPlanEstudios(PlanEstudios planEstudios) {
        Connection connection = null;
        try {
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
                
                String sqlInsert = "UPDATE plan_estudios SET nombre_carrera=?,ano_resolucion=?,vigente=? WHERE codigo=?;";
                PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			
			stmt.setString(1, planEstudios.getNombreCarrera());
			stmt.setInt(2, planEstudios.getAnoResolucion());
			stmt.setObject(3, planEstudios.isVigente());
			stmt.setString(4, planEstudios.getCodigo());
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

class PlanEstudiosExtractor implements ResultSetExtractor<PlanEstudios> {
	@Override
	public PlanEstudios extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		rs.next();
                
                String codigo = rs.getString("codigo");
                String nombreCarrera = rs.getString("nombre_carrera");
                int anoResolucion = rs.getInt("ano_resolucion");
                boolean vigente = rs.getBoolean("vigente");
               
		return new PlanEstudios(codigo, nombreCarrera, anoResolucion, vigente);
	}

    
}
