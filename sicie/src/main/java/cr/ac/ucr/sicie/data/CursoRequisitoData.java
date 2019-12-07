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
public class CursoRequisitoData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    public Iterator<Texto> buscarCursosRequisito(String sigla) {
        
        String selectSql = "SELECT sigla_requisito FROM curso_requisito WHERE sigla_curso='" + sigla + "';";
        return jdbcTemplate
                .query(selectSql, new Object[]{},
                        (rs, row) -> new Texto(rs.getString("sigla_requisito"))).iterator();
        
        
        
    }
    
}
