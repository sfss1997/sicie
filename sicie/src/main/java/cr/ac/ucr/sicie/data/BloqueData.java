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

import cr.ac.ucr.sicie.domain.Bloque;
import cr.ac.ucr.sicie.domain.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author fabian
 */
@Repository
public class BloqueData {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    
    public List<Bloque> listarBloques() {
        List<Bloque> bloques = new ArrayList<Bloque>();
        String sqlScript = "SELECT * FROM bloque;";

        return bloques;
    }

    
    public Bloque buscarBloquePorCurso(String siglaCurso) {
        String sqlSelect = "SELECT nombre FROM bloque B join curso_bloque CB ON B.id = CB.id_bloque WHERE B.id='" + siglaCurso + ";";
        return jdbcTemplate.query(sqlSelect, new BloqueExtractor());

    }

    
    public void insertarBloque(Bloque bloque) {
        String sqlScript = "INSERT INTO bloque VALUES("
                + bloque.getIdBloque() + ","
                + bloque.getNombreDelBloque() + ");";
    }

    
    public void eliminarBloque(int id) {
     
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            String sqlInsert = "DELETE FROM bloque WHERE id=?";
            PreparedStatement espec = connection.prepareStatement(sqlInsert);
            espec.setInt(1, id);
            espec.execute();

            connection.commit();
        } catch (Exception e) {
            try {
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

class BloqueExtractor implements ResultSetExtractor<Bloque> {

    @Override
    public Bloque extractData(ResultSet rs) throws SQLException, DataAccessException {

        //rs.next();
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        return new Bloque(null, id, nombre);
    }
}
