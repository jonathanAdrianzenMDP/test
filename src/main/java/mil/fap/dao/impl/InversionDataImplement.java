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
import mil.fap.dao.InversionData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.Inversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nlarico
 */
@Repository("inversionData")
public class InversionDataImplement implements InversionData {

    private SimpleJdbcCall listainversion;
    private SimpleJdbcCall insertarInversion;
    private SimpleJdbcCall actualizarEstadoInversion;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.listainversion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_SELECT_INVERSION");
        this.insertarInversion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_INVERSION");
        this.actualizarEstadoInversion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_DEL_INVERSION");
    }

    @Override
    public List<Inversion> list(Integer idproyepip) {
        List<Inversion> inversion = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_IDPROYEPIP", idproyepip);
        Map map
                = listainversion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            Inversion tipo = new Inversion();
            tipo.setIdinversion(Format.toInteger(obj.get("IDINVERSION")));
            tipo.setIdtipoinver(Format.toInteger(obj.get("IDTIPOINVER")));
            tipo.setInversion(Format.toString(obj.get("INVERSION")));
            tipo.setCostoref(Format.toDouble(obj.get("COSTOREF")));
            tipo.setV_costoref(Format.toString(obj.get("COSTOREF")));

            inversion.add(tipo);
        }
        return inversion;
    }

    @Override
    public Integer set(Inversion item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdproyepip())
                .addValue("I_IDTIPOINVER", item.getIdtipoinver())
                .addValue("D_COSTOREF", item.getCostoref());

        Map map = insertarInversion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

    @Override
    public Integer update(Inversion item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdproyepip())
                .addValue("V_USUARIO", item.getUsucreacio());

        Map map = actualizarEstadoInversion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }
}
