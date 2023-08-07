/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mil.fap.dao.ComiteTrabajoData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ComiteTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmeza
 */
@Repository("comiteTrabajoData")
public class ComiteTrabajoDataImplement implements ComiteTrabajoData {

    private SimpleJdbcCall listaPaginationComiteTrabajo;
    private SimpleJdbcCall insertarComiteTrabajo;
    private SimpleJdbcCall actualizarComiteTrabajo;
    private SimpleJdbcCall buscarComiteTrabajo;
    private SimpleJdbcCall deleteComiteTrabajo;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.listaPaginationComiteTrabajo = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_GET_COMITETRABAJO_ALL");
        this.insertarComiteTrabajo = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_INS_COMITETRABAJO");
        this.actualizarComiteTrabajo = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_UPD_COMITETRABAJO");
        this.buscarComiteTrabajo = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_GET_COMITETRABAJO");
          this.deleteComiteTrabajo = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_DEL_COMITETRABAJO");

    }

    @Override
    public List<ComiteTrabajo> listPagination(ComiteTrabajo item) {

        List<ComiteTrabajo> oDatos = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_IDPROYEPIP", item.getIdproyepip())
                .addValue("N_IDPROIOARR", item.getIdproioarr());

        Map map
                = listaPaginationComiteTrabajo.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            ComiteTrabajo comiteTrabajo = new ComiteTrabajo();
            comiteTrabajo.setRow_number(Format.toInteger(obj.get("ROW_NUMBER")));
            comiteTrabajo.setIdintegrante(Format.toInteger(obj.get("IDINTEGRANTE")));
            comiteTrabajo.setIntegrante(Format.toString(obj.get("INTEGRANTE")));
            comiteTrabajo.setNrooficio(Format.toString(obj.get("NROOFICIO")));
            oDatos.add(comiteTrabajo);

        }
        return oDatos;
    }

    @Override
    public String register(ComiteTrabajo item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("V_INTEGRANTE", item.getIntegrante())
                .addValue("V_NROOFICIO", item.getNrooficio())
                .addValue("V_USUCREACIO", item.getUsucreacio())
                .addValue("N_IDPROYEPIP", item.getIdproyepip())
                .addValue("N_IDPROIOARR", item.getIdproioarr());

        Map map = insertarComiteTrabajo.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return oCodigo;
    }

    @Override
    public String update(ComiteTrabajo item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDINTEGRANTE", item.getIdintegrante())
                .addValue("V_INTEGRANTE", item.getIntegrante())
                .addValue("V_NROOFICIO", item.getNrooficio())
                .addValue("V_USUMODIFIC", item.getUsucreacio());               

        Map map = actualizarComiteTrabajo.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public ComiteTrabajo buscarPorId(Integer idintegrante) {
             ComiteTrabajo comiteTrabajo = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDINTEGRANTE", idintegrante);

        Map map
                = buscarComiteTrabajo.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            comiteTrabajo = new ComiteTrabajo();
            comiteTrabajo.setIdintegrante(Format.toInteger(obj.get("IDINTEGRANTE")));
            comiteTrabajo.setIntegrante(Format.toString(obj.get("INTEGRANTE")));
            comiteTrabajo.setNrooficio(Format.toString(obj.get("NROOFICIO")));
            comiteTrabajo.setIdproyepip(Format.toInteger(obj.get("IDPROYEPIP")));
        }
        return comiteTrabajo;
    }

    @Override
    public String updateEstado(ComiteTrabajo item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDINTEGRANTE", item.getIdintegrante())
                .addValue("V_USUMODIFIC", item.getUsumodific());
        Map map = deleteComiteTrabajo.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

}
