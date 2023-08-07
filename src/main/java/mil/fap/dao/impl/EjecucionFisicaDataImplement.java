/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao.impl;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mil.fap.dao.EjecucionFisicaData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.EjecucionFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("ejecucionFisicaData")
public class EjecucionFisicaDataImplement implements EjecucionFisicaData {

    private SimpleJdbcCall insertarEjecucionFisica;
    private SimpleJdbcCall buscarEjecucionFisica;
//    private SimpleJdbcCall deleteEjecucionFisica;
    private SimpleJdbcCall actualizarEjecucionFisica;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.insertarEjecucionFisica = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_INS_FUENTEFINANCIAMIENTO");
        this.buscarEjecucionFisica = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_GET_FUENTEFINANCIAMIENTO");
//        this.deleteEjecucionFisica = new SimpleJdbcCall(dataSource)
//                .withSchemaName(Constantes.BDContext.Schema)
//                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
//                .withProcedureName("USP_DEL_FUENTEFINANCIAMIENTO");
        this.actualizarEjecucionFisica = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_FORMULACIONYEVALUACION)
                .withProcedureName("USP_UPD_FUENTEFINANCIAMIENTO");

    }

    @Override
    public String register(EjecucionFisica item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("D_RECORDIN", item.getRecordin())
                .addValue("D_RECDIRREC", item.getRecdirrec())
                .addValue("D_RECROOR", item.getRecroor())
                .addValue("D_RECDONTRA", item.getRecdontra())
                .addValue("D_RECDETER", item.getRecdeter())
                .addValue("V_USUCREACIO", item.getUsucreacio())
                .addValue("I_IDPROYEPIP", item.getIdproyepip())
                .addValue("I_IDPROIOARR", item.getIdproioarr());

        Map map = insertarEjecucionFisica.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return oCodigo;
    }

    @Override
    public EjecucionFisica get(EjecucionFisica item) {
        EjecucionFisica ejecucionFisica = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdproyepip())
                .addValue("I_IDPROIOARR", item.getIdproioarr());

        Map map
                = buscarEjecucionFisica.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            ejecucionFisica = new EjecucionFisica();
            ejecucionFisica.setIdfinanci(Format.toInteger(obj.get("IDFINANCI")));
            ejecucionFisica.setRecordin(Format.toDouble(obj.get("RECORDIN")));
            ejecucionFisica.setRecdirrec(Format.toDouble(obj.get("RECDIRREC")));
            ejecucionFisica.setRecroor(Format.toDouble(obj.get("RECROOR")));
            ejecucionFisica.setRecdontra(Format.toDouble(obj.get("RECDONTRA")));
            ejecucionFisica.setRecdeter(Format.toDouble(obj.get("RECDETER")));
            ejecucionFisica.setEstado(Format.toString(obj.get("ESTADO")));
            ejecucionFisica.setIdproyepip(Format.toInteger(obj.get("IDPROYEPIP")));
            ejecucionFisica.setIdproioarr(Format.toInteger(obj.get("IDPROIOARR")));
        }
        return ejecucionFisica;
    }
//        @Override
//    public String updateEstado(EjecucionFisica item) {
//        String oCodigo = "";
//        SqlParameterSource in = new MapSqlParameterSource()
//                .addValue("I_IDFINANCI", item.getIdfinanci())
//                .addValue("V_USUMODIFIC", item.getUsumodific());
//        Map map = deleteEjecucionFisica.execute(in);
//        List<Map> result = (List<Map>) map.get("MENSAJE");
//        for (Map obj : result) {
//            oCodigo = Format.toString(obj.get("MSG"));
//        }
//        return oCodigo;
//    }

        @Override
    public String update(EjecucionFisica item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDFINANCI", item.getIdfinanci())
                .addValue("V_USUMODIFIC", item.getUsumodific());              

        Map map = actualizarEjecucionFisica.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }
}
