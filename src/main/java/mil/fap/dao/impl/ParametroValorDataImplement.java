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
import mil.fap.dao.ParametroValorData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ParametroValor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("parametroValor")
public class ParametroValorDataImplement implements ParametroValorData {

    private SimpleJdbcCall listaParametroValor;
    private SimpleJdbcCall listaParametro;
    private SimpleJdbcCall listaTodoParametroValor;
    private SimpleJdbcCall eliminarParametroValor;
    private SimpleJdbcCall insertarParametroValor;
    private SimpleJdbcCall actualizarParametroValor;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
      
         this.listaParametroValor = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_PARAMETROVALOR");
         this.listaTodoParametroValor = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_PARAMETROVALOR_ALL");
        this.listaParametro = new SimpleJdbcCall(dataSource)
              .withSchemaName(Constantes.BDContext.Schema)
              .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
              .withProcedureName("USP_GET_PARAMETRO_ALL");
        this.eliminarParametroValor = new SimpleJdbcCall(dataSource)
              .withSchemaName(Constantes.BDContext.Schema)
              .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
              .withProcedureName("USP_DEL_PARAMETROVALOR");
        this.insertarParametroValor = new SimpleJdbcCall(dataSource)
              .withSchemaName(Constantes.BDContext.Schema)
              .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
              .withProcedureName("USP_INS_PARAMETROVALOR");
        this.actualizarParametroValor = new SimpleJdbcCall(dataSource)
              .withSchemaName(Constantes.BDContext.Schema)
              .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
              .withProcedureName("USP_UPD_PARAMETROVALOR");
    }
    
    @Override
    public Integer add(ParametroValor item) {
       Integer oCodigo=0;
        
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("I_IDPARAME", item.getIdparame())
                    .addValue("V_VALOR", item.getValor());

           
           Map<String, Object> out = insertarParametroValor.execute(in);
           oCodigo = Format.toInteger(out.get("I_IDPARAMVAL"));
        
        return oCodigo;
    }
    
    @Override
    public void update(ParametroValor item) {
       
        SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("I_IDPARAMVAL", item.getIdparamval())
                    .addValue("V_VALOR", item.getValor());

        actualizarParametroValor.execute(in);
           
    }
    
    @Override
    public List<ParametroValor> list(int idparametro) {
        List<ParametroValor> lParametroValor = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("N_IDPARAME", idparametro);

           Map map = listaParametroValor.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result){

                ParametroValor param = new ParametroValor();
                param.setIdparamval(Format.toInteger(obj.get("IDPARAMVAL")));
                param.setIdparame(Format.toInteger(obj.get("IDPARAME")));
                param.setValor(Format.toString(obj.get("VALOR")));
                param.setEstado(Format.toBoolean(obj.get("ESTADO")));
                lParametroValor.add(param);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lParametroValor;
    }
    @Override
    public List<ParametroValor> listAll(int idparametro) {
        List<ParametroValor> lParametroValor = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("I_IDPARAME", idparametro);

           Map map = listaTodoParametroValor.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result){

                ParametroValor param = new ParametroValor();
                param.setIdparamval(Format.toInteger(obj.get("IDPARAMVAL")));
                param.setIdparame(Format.toInteger(obj.get("IDPARAME")));
                param.setValor(Format.toString(obj.get("VALOR")));
                param.setNomParam(Format.toString(obj.get("NOMPARAM")));
                param.setEstado(Format.toBoolean(obj.get("ESTADO")));
                lParametroValor.add(param);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lParametroValor;
    }
    @Override
    public List<ParametroValor> listParametro() {
        List<ParametroValor> lParametroValor = new ArrayList<>();
        Map map = listaParametro.execute();
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result){

                ParametroValor param = new ParametroValor();
                param.setIdparame(Format.toInteger(obj.get("IDPARAME")));
                param.setNomParam(Format.toString(obj.get("NOMPARAM")));
                param.setEstado(Format.toBoolean(obj.get("ESTADO")));
                lParametroValor.add(param);
            }
       
        return lParametroValor;
    }
    @Override
    public void deleteParametro(ParametroValor item) {
        
         SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("I_IDPARAMVAL", item.getIdparamval())
                    .addValue("V_ESTADO", (item.isEstado()==true? "1": "0"));
        eliminarParametroValor.execute(in);            
    }

    
}
