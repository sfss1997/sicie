package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.TipoParticipacionExterna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class TipoParticipacionExternaData {

    private ParticipanteExternoData participanteExternoData;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private void setParticipanteExternoData(ParticipanteExternoData participanteExternoData) {
        this.participanteExternoData = participanteExternoData;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TipoParticipacionExterna getParticipacionExternaById(int idParticipacionExterna) {
        CallableStatement cstmt = null;
        TipoParticipacionExterna tipoParticipacionExterna = null;

        String sqlStoredProcedure = "{call get_participacion_externa_by_id(?, ?, ?)}";

        try (Connection conn = dataSource.getConnection()) {
            cstmt = conn.prepareCall(sqlStoredProcedure);

            cstmt.setInt(1, idParticipacionExterna);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.INTEGER);

            cstmt.execute();

            tipoParticipacionExterna = new TipoParticipacionExterna();
            tipoParticipacionExterna.setIdParticipacion(idParticipacionExterna);
            tipoParticipacionExterna.setDescripcion(cstmt.getString(2));
            tipoParticipacionExterna.setParticipanteExterno(participanteExternoData.getParticipanteById(cstmt.getInt(3)));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return tipoParticipacionExterna;
    }

    public List<TipoParticipacionExterna> getTipoParticipacionByIdProyecto(int idProyecto) {
        String sqlSelect = "SELECT participante_externo_id, tp.id_tipo_participacion_externa, tp.descripcion" +
                " FROM proyectoinvestigacion_participanteexterno pe" +
                " JOIN tipoparticipacionexterna tp ON tp.id_tipo_participacion_externa = pe.id_tipo_participacion_externa" +
                " WHERE id_proyecto_investigacion = ?;";
        List<TipoParticipacionExterna> tipoParticipacionesExternas = jdbcTemplate.query(sqlSelect, new Object[]{idProyecto}, (rs, row)
                -> new TipoParticipacionExterna(
                        rs.getInt("id_tipo_participacion_externa"),
                        rs.getString("descripcion"),
                        participanteExternoData.getParticipanteById(rs.getInt("participante_externo_id"))));
        return tipoParticipacionesExternas;
    }

    public List<TipoParticipacionExterna> getAllParticipaciones() {
        String sqlSelect = "SELECT id_tipo_participacion_externa, descripcion" +
                " FROM tipoparticipacionexterna;";
        List<TipoParticipacionExterna> participaciones = jdbcTemplate.query(sqlSelect, new Object[]{}, (rs, row) ->
                new TipoParticipacionExterna(rs.getInt("id_tipo_participacion_externa"),
                        rs.getString("descripcion"), null));
        return participaciones;
    }

}
