package com.sitio.docentes.data;

import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sitio.docentes.domain.Especializacion;
import com.sitio.docentes.domain.Topico;

@Repository
public class EspecializacionData {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Iterator<Especializacion> cargarEspecializacion(){
		String selectMysql;
		selectMysql = "select id_especializacion, especializacion from Especializacion";
		return jdbcTemplate
				.query(selectMysql, new Object[] {  },
						(rs, row) -> new Especializacion(rs.getInt("id_especializacion"),rs.getString("especializacion"))).iterator();
	}
}
