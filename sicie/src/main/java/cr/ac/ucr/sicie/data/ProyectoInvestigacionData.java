package cr.ac.ucr.sicie.data;

import cr.ac.ucr.sicie.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class ProyectoInvestigacionData {

    private JdbcTemplate jdbcTemplate;
    private SedeORecintoData recintoData;
    private DocenteData docenteData;
    private TipoParticipacionInternaData tipoParticipacionInternaData;
    private TipoParticipacionExternaData tipoParticipacionExternaData;
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setDocenteData(DocenteData docenteData) {
        this.docenteData = docenteData;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setRecintoData(SedeORecintoData recintoData) {
        this.recintoData = recintoData;
    }

    @Autowired
    public void setTipoParticipacionExternaData(TipoParticipacionExternaData tipoParticipacionExternaData) {
        this.tipoParticipacionExternaData = tipoParticipacionExternaData;
    }

    @Autowired
    public void setTipoParticipacionInternaData(TipoParticipacionInternaData tipoParticipacionInternaData) {
        this.tipoParticipacionInternaData = tipoParticipacionInternaData;
    }

    public List<ProyectoInvestigacion> getProyectosByFiltro(int idRecinto, String tituloProyecto, String docente) {

        if(tituloProyecto.equals("null") && docente.equals("null") && idRecinto == 0) {
            return getAllProyectosInvestigacion();
        }

        // si los valores vienen como "null" desde la UI, se vacian para no causar conflictos en la consulta
        tituloProyecto = (tituloProyecto.equals("null")) ? "" : tituloProyecto;
        docente = (docente.equals("null")) ? "" : docente;

        String sqlSelect = "SELECT p.id_proyecto_investigacion, codigo, titulo, fecha_inicio, fecha_final," +
            " p.descripcion, objetivo_general, id_recinto\n" +
            " FROM ProyectoInvestigacion p" +
            "  JOIN proyectoinvestigacion_docente pd ON p.id_proyecto_investigacion = pd.id_proyecto_investigacion" +
            "  JOIN docente d ON d.id_docente = pd.id_docente" +
            "  JOIN tipoparticipacioninterna tp ON pd.id_tipo_participacion_interna = tp.id_tipo_participacion_interna" +
            " WHERE id_recinto = ? AND titulo LIKE ? AND tp.descripcion = 'Investigador Principal' AND d.nombre LIKE ?;";
        List<ProyectoInvestigacion> proyectosInvestigacion = jdbcTemplate.query(sqlSelect,
            new Object[]{idRecinto, "%"+tituloProyecto+"%", "%"+docente+"%"}, (rs, row) ->
                new ProyectoInvestigacion(rs.getInt("id_proyecto_investigacion"),
                    rs.getString("codigo"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("objetivo_general"),
                    rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getDate("fecha_final").toLocalDate(),
                    tipoParticipacionExternaData.getTipoParticipacionByIdProyecto(rs.getInt("id_proyecto_investigacion")),
                    tipoParticipacionInternaData.getTipoParticipacionByIdProyecto(rs.getInt("id_proyecto_investigacion")),
                    recintoData.getRecintoById(rs.getInt("id_recinto"))));
        return proyectosInvestigacion;
    }

    public List<ProyectoInvestigacion> getAllProyectosInvestigacion() {
        String sqlSelect = "SELECT id_proyecto_investigacion, codigo, titulo, fecha_inicio, fecha_final," +
                " descripcion, objetivo_general, id_recinto"+
                " FROM ProyectoInvestigacion ";
        List<ProyectoInvestigacion> proyectosInvestigacion = jdbcTemplate.query(sqlSelect, new Object[] {}, (rs, row) ->
            new ProyectoInvestigacion(rs.getInt("id_proyecto_investigacion"),
                rs.getString("codigo"),
                rs.getString("titulo"),
                rs.getString("descripcion"),
                rs.getString("objetivo_general"),
                rs.getDate("fecha_inicio").toLocalDate(),
                rs.getDate("fecha_final").toLocalDate(),
                tipoParticipacionExternaData.getTipoParticipacionByIdProyecto(rs.getInt("id_proyecto_investigacion")),
                tipoParticipacionInternaData.getTipoParticipacionByIdProyecto(rs.getInt("id_proyecto_investigacion")),
                recintoData.getRecintoById(rs.getInt("id_recinto"))));
        return  proyectosInvestigacion;
    }

    public ProyectoInvestigacion saveProyecto(ProyectoInvestigacion proyectoInvestigacion) {

        CallableStatement cstmt = null;
        String sqlStoredProcedure = "{call save_proyecto(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection()) {
            cstmt = conn.prepareCall(sqlStoredProcedure);
            conn.setAutoCommit(false);

            cstmt.setString("codigo", proyectoInvestigacion.getCodigo());
            cstmt.setString("titulo", proyectoInvestigacion.getTitulo());
            cstmt.setString("descripcion", proyectoInvestigacion.getDescripcion());
            cstmt.setString("objetivo_general", proyectoInvestigacion.getObjetivoGeneral());
            cstmt.setDate("fecha_inicio", convertToDateViaSqlDate(proyectoInvestigacion.getFechaInicio()));
            cstmt.setDate("fecha_final", convertToDateViaSqlDate(proyectoInvestigacion.getFechaFinal()));
            cstmt.setInt("id_recinto", proyectoInvestigacion.getRecinto().getIdRecinto());
            cstmt.registerOutParameter("id_proyecto", Types.INTEGER);
            cstmt.execute();

            int idProyecto = cstmt.getInt("id_proyecto");

            sqlStoredProcedure = "{call save_participaciones_internas(?, ?, ?)}";
            cstmt = conn.prepareCall(sqlStoredProcedure);
            for (TipoParticipacionInterna participacion : proyectoInvestigacion.getTipoParticipacionesInternas()) {
                cstmt.setInt(1, idProyecto);
                cstmt.setInt(2, participacion.getDocente().getIdDocente());
                cstmt.setInt(3, participacion.getIdParticipacion());
                cstmt.execute();
            }

            sqlStoredProcedure = "{call save_participaciones_externas(?, ?, ?)}";
            cstmt = conn.prepareCall(sqlStoredProcedure);
            for (TipoParticipacionExterna participacion : proyectoInvestigacion.getTipoParticipacionesExternas()) {
                cstmt.setInt(1, idProyecto);
                cstmt.setInt(2, participacion.getParticipanteExterno().getIdParticipanteExterno());
                cstmt.setInt(3, participacion.getIdParticipacion());
                cstmt.execute();
            }
            conn.commit();
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
        return proyectoInvestigacion;
    }

    private Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return Date.valueOf(dateToConvert);
    }

}
