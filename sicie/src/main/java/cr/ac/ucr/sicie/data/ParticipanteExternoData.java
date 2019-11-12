package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.EntidadProcedencia;
import cr.ac.ucr.sicie.domain.ParticipanteExterno;
import cr.ac.ucr.sicie.domain.TipoParticipacionExterna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ParticipanteExternoData {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private DataSource dataSource;

    public List<ParticipanteExterno> getAllParticipantesExternos() {
        String sqlSelect = "SELECT id_participante_externo, nombre, apellidos, grado_academico, correo_electronico, entidad_procedencia_id" +
                " FROM ParticipanteExterno;";
        List<ParticipanteExterno> participantesExternos = new LinkedList<>(jdbcTemplate.query(sqlSelect, new Object[]{}, (rs, row) ->
                new ParticipanteExterno(rs.getInt("id_participante_externo"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("grado_academico"),
                        rs.getString("correo_electronico"),
                        new EntidadProcedencia())));
        return participantesExternos;
    }

    public ParticipanteExterno getParticipanteById(int idParticipanteExterno) {
        String sqlSelect = "SELECT id_participante_externo, nombre, apellidos, grado_academico, correo_electronico, entidad_procedencia_id" +
                " FROM ParticipanteExterno" +
                " WHERE id_participante_externo = ?;";
        return (ParticipanteExterno) jdbcTemplate.queryForObject(sqlSelect, new Object[] {idParticipanteExterno}, (rs, row) ->
                new ParticipanteExterno(idParticipanteExterno,
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("grado_academico"),
                        rs.getString("correo_electronico"),
                        new EntidadProcedencia()));
    }
}
