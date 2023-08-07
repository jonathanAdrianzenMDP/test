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
import mil.fap.dao.BrechaIndicadorData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.BrechaIndicador;
import mil.fap.models.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("brechaIndicadorData")
public class BrechaIndicadorDataImplement implements BrechaIndicadorData {

    private SimpleJdbcCall listaPaginationBrechaIndicador;
    private SimpleJdbcCall insertarBrechaIndicador;
    private SimpleJdbcCall actualizarBrechaIndicador;
    private SimpleJdbcCall actualizarEstadoBrechaIndicador;
    private SimpleJdbcCall buscarBrechaIndicador;
    private SimpleJdbcCall listaNombresBrechaIndicador;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.listaPaginationBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_BrechasIndicadores)
                .withProcedureName("USP_GET_BRECHAINDICADOR_ALL");
        this.insertarBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_BrechasIndicadores)
                .withProcedureName("USP_INS_BRECHAINDICADOR");
        this.actualizarBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_BrechasIndicadores)
                .withProcedureName("USP_UPD_BRECHAINDICADOR");
        this.actualizarEstadoBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_BrechasIndicadores)
                .withProcedureName("USP_DEL_BRECHAINDICADOR");
        this.buscarBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_BrechasIndicadores)
                .withProcedureName("USP_GET_BRECHAINDICADOR");
        this.listaNombresBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_BrechasIndicadores)
                .withProcedureName("USP_GET_BRECHAINDICADOR_LST");
    }

    @Override
    public List<BrechaIndicador> listPagination(BrechaIndicador item) {
        List<BrechaIndicador> oDatos = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_PAGENUM", item.getPageInfo().getiPage())
                .addValue("N_PAGESIZE", item.getPageInfo().getiLength())
                .addValue("V_ANIO", item.getAnio())
                .addValue("V_SERVTIPOLO", item.getServtipolo())
                .addValue("V_INDICBRECH", item.getIndicbrech());

        Map map
                = listaPaginationBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            BrechaIndicador brechaIndicador = new BrechaIndicador();
            brechaIndicador.setPageInfo(new Pagination());
            brechaIndicador.getPageInfo().setiTotal(Format.toInteger(obj.get("TOTAL")));
            brechaIndicador.getPageInfo().setiEnd(Format.toInteger(obj.get("iEND")));
            brechaIndicador.setIdbrecindi(Format.toInteger(obj.get("IDBRECINDI")));
            brechaIndicador.setDescsector(Format.toString(obj.get("DESCSECTOR")));
            brechaIndicador.setDescfuncion(Format.toString(obj.get("DESCFUNCION")));
            brechaIndicador.setDescdivfuncion(Format.toString(obj.get("DESCDIVFUNCION")));
            brechaIndicador.setDescgrupofunc(Format.toString(obj.get("DESCGRUPOFUNC")));
            brechaIndicador.setTipologia(Format.toString(obj.get("TIPOLOGIA")));
            brechaIndicador.setServtipolo(Format.toString(obj.get("SERVTIPOLO")));
            brechaIndicador.setIndicbrech(Format.toString(obj.get("INDICBRECH")));
            brechaIndicador.setAnio(Format.toString(obj.get("ANIO")));
            brechaIndicador.setFeccreacio(Format.toString(obj.get("FECCREACIO")));
            brechaIndicador.setUnimed(Format.toString(obj.get("UNIMED")));
            brechaIndicador.setCapprod(Format.toString(obj.get("CAPPROD")));
            
            oDatos.add(brechaIndicador);

        }

        return oDatos;
    }

    @Override
    public String register(BrechaIndicador item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_IDSECTOR", item.getIdsector())
                .addValue("N_IDGRUPOFUN", item.getIdgrupofun())
                .addValue("N_IDDIVFUNCI", item.getIddivfunci())
                .addValue("N_IDFUNCION", item.getIdfuncion())
                .addValue("V_TIPOLOGIA", item.getTipologia())
                .addValue("V_SERVTIPOLO", item.getServtipolo())
                .addValue("V_INDICBRECH", item.getIndicbrech())
                .addValue("V_ANIO", item.getAnio())
                .addValue("V_UNIMED", item.getUnimed())
                .addValue("V_CAPPROD", item.getCapprod());
        

        Map map = insertarBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return oCodigo;
    }

    @Override
    public String update(BrechaIndicador item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDBRECINDI", item.getIdbrecindi())
                .addValue("I_IDSECTOR", item.getIdsector())
                .addValue("I_IDGRUPOFUN", item.getIdgrupofun())
                .addValue("I_IDDIVFUNCI", item.getIddivfunci())
                .addValue("I_IDFUNCION", item.getIdfuncion())
                .addValue("V_TIPOLOGIA", item.getTipologia())
                .addValue("V_SERVTIPOLO", item.getServtipolo())
                .addValue("V_INDICBRECH", item.getIndicbrech())
                .addValue("V_ANIO", item.getAnio())
                .addValue("V_UNIMED", item.getUnimed())
                .addValue("V_CAPPROD", item.getCapprod());

        Map map = actualizarBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public String updateEstado(BrechaIndicador item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDBRECINDI", item.getIdbrecindi());
        Map map = actualizarEstadoBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public BrechaIndicador buscarPorId(Integer idbrecindi) {
        BrechaIndicador brechaIndicador = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDBRECINDI", idbrecindi);

        Map map
                = buscarBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            brechaIndicador = new BrechaIndicador();
            brechaIndicador.setIdbrecindi(Format.toInteger(obj.get("IDBRECINDI")));
            brechaIndicador.setDescsector(Format.toString(obj.get("IDSECTOR")));
            brechaIndicador.setIdgrupofun(Format.toInteger(obj.get("IDGRUPOFUN")));
            brechaIndicador.setIddivfunci(Format.toInteger(obj.get("IDDIVFUNCI")));
            brechaIndicador.setIdfuncion(Format.toInteger(obj.get("IDFUNCION")));
            brechaIndicador.setTipologia(Format.toString(obj.get("TIPOLOGIA")));
            brechaIndicador.setServtipolo(Format.toString(obj.get("SERVTIPOLO")));
            brechaIndicador.setIndicbrech(Format.toString(obj.get("INDICBRECH")));
            brechaIndicador.setAnio(Format.toString(obj.get("ANIO")));
            brechaIndicador.setUnimed(Format.toString(obj.get("UNIMED")));
            brechaIndicador.setCapprod(Format.toString(obj.get("CAPPROD")));
        }

        return brechaIndicador;
    }

    @Override
    public List<BrechaIndicador> list() {
        List<BrechaIndicador> brechaIndicador = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource();
        Map map
                = listaNombresBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            BrechaIndicador brecha = new BrechaIndicador();
            brecha.setIdbrecindi(Format.toInteger(obj.get("IDBRECINDI")));
            brecha.setTipologia(Format.toString(obj.get("TIPOLOGIA")));
            brecha.setServtipolo(Format.toString(obj.get("SERVTIPOLO")));
            brecha.setIndicbrech(Format.toString(obj.get("INDICBRECH")));
            brecha.setIndicbrech(Format.toString(obj.get("UNIMED")));
            brecha.setIndicbrech(Format.toString(obj.get("CAPPROD")));

            brechaIndicador.add(brecha);
        }
        return brechaIndicador;
    }
}
