package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.TipoParticipacionInterna;
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
public class TipoParticipacionInternaData {

    private DataSource dataSource;
    private DocenteData docenteData;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Autowired
    public void setDocenteData(DocenteData docenteData) {
        this.docenteData = docenteData;
    }

    public List<TipoParticipacionInterna> getAllParticipacionInterna() {
        String sqlSelect = "SELECT id_tipo_participacion_interna, descripcion" +
                " FROM tipoparticipacioninterna;";
        List<TipoParticipacionInterna> participaciones = jdbcTemplate.query(sqlSelect, new Object[]{}, (rs, row) ->
                new TipoParticipacionInterna(rs.getInt("id_tipo_participacion_interna"),
                        rs.getString("descripcion"), null));
        return participaciones;
    }

    public TipoParticipacionInterna getParticipacionInternaById(int idParticipacionInterna) {

        CallableStatement cstmt = null;
        TipoParticipacionInterna tipoParticipacionInterna = null;
        String sqlStoredProcedure = "{call get_participacion_interna_by_id(?, ?, ?)}";

        try (Connection conn = dataSource.getConnection()) {
            cstmt = conn.prepareCall(sqlStoredProcedure);

            cstmt.setInt(1, idParticipacionInterna);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.INTEGER);

            cstmt.execute();

            tipoParticipacionInterna = new TipoParticipacionInterna();
            tipoParticipacionInterna.setIdParticipacion(idParticipacionInterna);
            tipoParticipacionInterna.setDescripcion(cstmt.getString(2));
            tipoParticipacionInterna.setDocente(docenteData.getDocenteById(cstmt.getInt(3)));

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
        return tipoParticipacionInterna;
    }

    public List<TipoParticipacionInterna> getTipoParticipacionByIdProyecto(int idProyecto) {
        String sqlSelect = "SELECT id_docente, tp.id_tipo_participacion_interna, tp.descripcion" +
                " FROM proyectoinvestigacion_docente pd" +
                " JOIN tipoparticipacioninterna tp ON tp.id_tipo_participacion_interna = pd.id_tipo_participacion_interna" +
                " WHERE id_proyecto_investigacion = ?;";
        List<TipoParticipacionInterna> tipoParticipacionesInternas = jdbcTemplate.query(sqlSelect, new Object[]{idProyecto}, (rs, row)
                -> new TipoParticipacionInterna(
                        rs.getInt("id_tipo_participacion_interna"),
                        rs.getString("descripcion"),
                        docenteData.getDocenteById(rs.getInt("id_docente"))));
        return tipoParticipacionesInternas;
    }
}
