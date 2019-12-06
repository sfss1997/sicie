/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.sicie.data;

import java.util.Iterator;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author fabian
 */
public class CursoRequisitoData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    public Iterator<String> buscarCursosRequisito(String sigla) {
        
        String selectSql = "SELECT sigla_requisito FROM curso WHERE sigla_curso=" + sigla + ";";
        return jdbcTemplate
                .query(selectSql, new Object[]{},
                        (rs, row) -> new String(rs.getString("sigla_requisito"))).iterator();
    }
    
}
