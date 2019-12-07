/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.bussines.CursoBusiness;
import cr.ac.ucr.sicie.domain.Curso;
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
    
    private CursoBusiness cursoBusiness;

    public Iterator<PlanEstudios> listarPlanesEstudios() {
         
        String selectSql;
        selectSql = "SELECT codigo,nombre_carrera,ano_resolucion,vigente,documento_fundamentacion_carrera,resolucion_creacion_carrera FROM plan_estudios";
        return jdbcTemplate
                 .query(selectSql, new Object[]{},
                         (rs, row) -> new PlanEstudios(//cursoBusiness.buscarCursosPorPlan(""),
                                 null,
                         rs.getString("codigo"), 
                         rs.getString("nombre_carrera"), 
                         rs.getInt("ano_resolucion"), 
                         rs.getBoolean("vigente"),
                         rs.getString("documento_fundamentacion_carrera"),
                         rs.getString("resolucion_creacion_carrera"))).iterator();
    }

    public Iterator<PlanEstudios> buscarPlanesEstudios(String codigo) {
        String selectMysql = "SELECT codigo,nombre_carrera,ano_resolucion,vigente,documento_fundamentacion_carrera,resolucion_creacion_carrera FROM plan_estudios WHERE codigo=" + codigo + ";";
        return jdbcTemplate
                .query(selectMysql, new Object[]{},
                         (rs, row) -> new PlanEstudios(cursoBusiness.buscarCursosPorPlan( rs.getString("codigo")),
                         rs.getString("codigo"), 
                         rs.getString("nombre_carrera"), 
                         rs.getInt("ano_resolucion"), 
                         rs.getBoolean("vigente"),
                         rs.getString("documento_fundamentacion_carrera"),
                         rs.getString("resolucion_creacion_carrera"))).iterator();
        }

    public void insertarPlanEstudios(PlanEstudios planEstudios) {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            String sqlInsert = "INSERT INTO plan_estudios(codigo,nombre_carrera,ano_resolucion,vigente,documento_fundamentacion_carrera,resolucion_creacion_carrera) VALUES(?,?,?,?,?,?);";
            PreparedStatement stmt = connection.prepareStatement(sqlInsert);
            stmt.setString(1, planEstudios.getCodigo());
            stmt.setString(2, planEstudios.getNombreCarrera());
            stmt.setInt(3, planEstudios.getAnoResolucion());
            stmt.setObject(4, planEstudios.isVigente());
            stmt.setString(5, planEstudios.getDocumentoFundamentacionCarrera());
            stmt.setString(6, planEstudios.getResolucionDeCreacionDeCarrera());
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

    public void eliminarPlanEstudios(String codigo) {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            String sqlInsert = "DELETE FROM plan_estudios WHERE codigo=?;";
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


