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
import mil.fap.dao.UbigeoData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.Ubigeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("ubigeoData")
public class UbigeoDataImplement implements UbigeoData {

    private SimpleJdbcCall listaUbigeo;
    private SimpleJdbcCall listaUbigeoProv;
    private SimpleJdbcCall listaUbigeoDist;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.listaUbigeo = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_UBIGEO");
        this.listaUbigeoProv = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_UBIGEOPROV");
        this.listaUbigeoDist = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_UBIGEODIST");
    }

    @Override
    public List<Ubigeo> list() {
        List<Ubigeo> ubigeo = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource();
        Map map
                = listaUbigeo.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            Ubigeo ubi = new Ubigeo();
            ubi.setCodigo(Format.toString(obj.get("CODIGO")));
            ubi.setDescri(Format.toString(obj.get("DESCRI")));

            ubigeo.add(ubi);
        }
        return ubigeo;
    }

    @Override
    public List<Ubigeo> listProv(String codigo) {
        List<Ubigeo> ubigeo = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                  .addValue("V_CODIGO", codigo);
        Map map
                = listaUbigeoProv.execute(in); 
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            Ubigeo ubi = new Ubigeo();
            ubi.setCodigo(Format.toString(obj.get("CODIGO")));
            ubi.setDescri(Format.toString(obj.get("DESCRI")));

            ubigeo.add(ubi);
        }
        return ubigeo;
    }
  @Override
    public List<Ubigeo> listDist(String codigo) {
        List<Ubigeo> ubigeo = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                   .addValue("V_CODIGO", codigo);;
          Map map
                = listaUbigeoDist.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            Ubigeo ubi = new Ubigeo();
            ubi.setCodigo(Format.toString(obj.get("CODIGO")));
            ubi.setDescri(Format.toString(obj.get("DESCRI")));

            ubigeo.add(ubi);
        }
        return ubigeo;
    }

   }
