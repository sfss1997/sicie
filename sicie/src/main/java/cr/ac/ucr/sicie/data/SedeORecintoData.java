package com.sitio.docentes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sitio.docentes.domain.Docente;
import com.sitio.docentes.domain.SedeORecinto;

@Repository
public class SedeORecintoData {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void guardarRecinto(SedeORecinto recinto) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			String sqlInsert = "INSERT INTO `IF-6100_Docentes`.`Recinto`(`nombre`) VALUES (?);";
			PreparedStatement insertSedeORecinto = connection.prepareStatement(sqlInsert);
			insertSedeORecinto.setString(1, recinto.getNombre());
			insertSedeORecinto.execute();
			
			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			}catch(SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	public Iterator<SedeORecinto> cargarRecinto(){
		String selectMysql;
		selectMysql = "SELECT `Recinto`.`nombre` FROM `IF-6100_Docentes`.`Recinto`;";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new SedeORecinto(rs.getString("nombre"))).iterator();
	}

}
