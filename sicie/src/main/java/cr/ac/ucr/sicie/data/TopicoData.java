package cr.ac.ucr.sicie.data;

import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.sicie.domain.Topico;


@Repository
public class TopicoData {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Iterator<Topico> cargarTopicos(){
		String selectMysql;
		selectMysql = "select id_topico, topico from Topico_de_interes";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new Topico(rs.getInt("id_topico"),rs.getString("topico"))).iterator();
	}
}
