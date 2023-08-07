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
import mil.fap.dao.TipoItemData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.TipoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmeza
 */
@Repository("tipoItemData")
public class TipoItemDataImplement implements TipoItemData {

    private SimpleJdbcCall insertarTipoItem;
    private SimpleJdbcCall listaTipoItem;
    private SimpleJdbcCall actualizarEstadoTipoItem;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.insertarTipoItem = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_TIPOITEM");
        this.listaTipoItem = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_SELECT_TIPOITEM");
        this.actualizarEstadoTipoItem = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_DEL_TIPOITEM");
    }

    @Override
    public Integer set(TipoItem item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdproyepip())
                .addValue("I_IDITEM", item.getIditem())
                .addValue("D_COSTOREF", item.getCostoref());

        Map map = insertarTipoItem.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return Integer.parseInt(oCodigo);
    }

    @Override
    public List<TipoItem> list(Integer idproyepip) {
        List<TipoItem> tipoItem = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_IDPROYEPIP", idproyepip);
        Map map
                = listaTipoItem.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            TipoItem tipo = new TipoItem();
            tipo.setIditem(Format.toString(obj.get("IDITEM")));
            tipo.setCostoref(Format.toDouble(obj.get("COSTOREF")));
            tipo.setV_costoref(Format.toString(obj.get("COSTOREF")));
            tipo.setTipoitem(Format.toString(obj.get("TIPOITEM")));
            tipo.setIdtipoitem(Format.toInteger(obj.get("IDTIPOITEM")));

            tipoItem.add(tipo);
        }
        return tipoItem;
    }

    @Override
    public Integer update(TipoItem item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdproyepip())
                .addValue("V_USUARIO", item.getUsucreacio());

        Map map = actualizarEstadoTipoItem.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

}
