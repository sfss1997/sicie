package cr.ac.ucr.sicie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sicie.domain.SedeORecinto;



@Repository
public class SedeORecintoData {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public Iterator<SedeORecinto> cargarRecinto(){
		String selectMysql;
		selectMysql = "select id_recinto, nombre_recinto from Recinto";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new SedeORecinto(rs.getInt("id_recinto"),rs.getString("nombre_recinto"))).iterator();
	}

}
