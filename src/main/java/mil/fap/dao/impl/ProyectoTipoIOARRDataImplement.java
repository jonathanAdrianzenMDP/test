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
import mil.fap.dao.ProyectoTipoIOARRData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ProyectoTipoIOARR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan
 */
@Repository("proyectoTipoIOARRData")
public class ProyectoTipoIOARRDataImplement implements ProyectoTipoIOARRData {

    private SimpleJdbcCall insertarProyectoTipoIOARR;
    private SimpleJdbcCall listarTipoProyectoIoarr;
    private SimpleJdbcCall actualizarEstadoTipoIOARR;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.insertarProyectoTipoIOARR = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_PROYTIPOIOARR");

        this.listarTipoProyectoIoarr = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_REPORTE)
                .withProcedureName("USP_GET_PROYTIPOIOARR");

        this.actualizarEstadoTipoIOARR = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_DEL_PROYTIPOIOARR");

    }

    @Override
    public Integer set(ProyectoTipoIOARR item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", item.getIdProyIOARR())
                .addValue("I_IDTIPIOARR", item.getIdTipoIOARR())
                .addValue("D_MONTOINVER", item.getMontoInversion())
                .addValue("V_USUARIO", item.getUsucreacio());

        Map map = insertarProyectoTipoIOARR.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

    @Override
    public List<ProyectoTipoIOARR> list(Integer idProyIOARR) {
        List<ProyectoTipoIOARR> proyectoTipoIOARR = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", idProyIOARR);
        Map map
                = listarTipoProyectoIoarr.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            ProyectoTipoIOARR item = new ProyectoTipoIOARR();
            item.setIdTipoIOARR(Format.toInt(obj.get("IDTIPIOARR")));
            item.setTipoIOARR(Format.toString(obj.get("TIPOIOARR")));
            item.setMontoInversion(Format.toDouble(obj.get("MONTOINVER")));
            item.setV_montoInversion(Format.toString(obj.get("MONTOINVER")));

            proyectoTipoIOARR.add(item);
        }
        return proyectoTipoIOARR;
    }

    @Override
    public Integer update(ProyectoTipoIOARR item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", item.getIdProyIOARR())
                .addValue("V_USUARIO", item.getUsucreacio());

        Map map = actualizarEstadoTipoIOARR.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

}
