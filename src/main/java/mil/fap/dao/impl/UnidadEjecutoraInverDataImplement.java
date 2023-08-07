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
import mil.fap.dao.UnidadEjecutoraInverData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.UnidadEjecutoraInver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jadrianzen
 */
@Repository("UnidadEjecutoraInver")
public class UnidadEjecutoraInverDataImplement implements UnidadEjecutoraInverData {
     private SimpleJdbcCall listar;
     private SimpleJdbcCall listaPaginationUnidadEjecutora;
     private SimpleJdbcCall insertarUnidadEjecutora;
     private SimpleJdbcCall buscarUnidadEjecutora;
     private SimpleJdbcCall deleteUnidadEjecutora;
     
      @Autowired
    public void setDataSource(DataSource dataSource) {

        this.listar = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_UNIDADEJECINVER");
        this.listaPaginationUnidadEjecutora = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_UNIDADEJECUTORAINV_ALL");
        this.insertarUnidadEjecutora = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_INS_UNIDADEJECUTORAINV");
        this.buscarUnidadEjecutora = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_UNIDADEJECUTORAINV");
        this.deleteUnidadEjecutora = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_DEL_UNIDADEJECUTORAINV");
       
    }

    @Override
    public List<UnidadEjecutoraInver> getAll(int id) {
         List<UnidadEjecutoraInver> oDatos = new ArrayList<>();
          SqlParameterSource in = new MapSqlParameterSource()
        .addValue("I_IDENTIFICADOR", id);
          Map map = listar.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            UnidadEjecutoraInver i = new UnidadEjecutoraInver();
            i.setDescunidad(Format.toString(obj.get("descunidad")));
            i.setResponsable(Format.toString(obj.get("responsable")));
            i.setIdentificador(Format.toInteger(obj.get("identificador")));
            oDatos.add(i);
        }
        
        return oDatos;
    }

    @Override
    public List<UnidadEjecutoraInver> listPagination(UnidadEjecutoraInver item) {
        List<UnidadEjecutoraInver> oDatos = new ArrayList<>();
        SqlParameterSource in = new MapSqlParameterSource();
        Map map = listaPaginationUnidadEjecutora.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            UnidadEjecutoraInver unidadEjecutoraInver = new UnidadEjecutoraInver();
            unidadEjecutoraInver.setIdentificador(Format.toInteger(obj.get("IDENTIFICADOR")));
            unidadEjecutoraInver.setNsa(Format.toString(obj.get("NSA")));
            unidadEjecutoraInver.setDescunidad(Format.toString(obj.get("DESCUNIDAD")));
            unidadEjecutoraInver.setResponsable(Format.toString(obj.get("RESPONSABLE")));
            unidadEjecutoraInver.setFeccreacio(Format.toString(obj.get("FECCREACIO")));
            unidadEjecutoraInver.setEstado(Format.toString(obj.get("ESTADO")));
            oDatos.add(unidadEjecutoraInver);
        }
        return oDatos;
    }

    @Override
    public String register(UnidadEjecutoraInver item) {
          String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("V_NSA", item.getNsa())
                .addValue("V_DESCUNIDAD", item.getDescunidad())
                .addValue("V_RESPONSABLE", item.getResponsable())
                .addValue("V_CODUNIEJE", item.getCodunieje())
                .addValue("V_USUCREACIO", item.getUsucreacio());

        Map map = insertarUnidadEjecutora.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public String updateEstado(UnidadEjecutoraInver item) {
            String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDENTIFICADOR", item.getIdentificador())
                .addValue("V_USUMODIFIC", item.getUsumodific());
        Map map = deleteUnidadEjecutora.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }
}
