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
import mil.fap.dao.IdeasInversionData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.IdeasInversion;
import mil.fap.models.Pagination;
import mil.fap.models.helpers.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mnieva
 */
@Repository("ideasInversionData")
public class IdeasInversionDataImplement implements IdeasInversionData {

    private SimpleJdbcCall listaPaginationIdeasInversion;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        
        this.listaPaginationIdeasInversion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_GET_IDEASINVERSION_ALL");
    }
    
    @Override
    public DataTable<IdeasInversion> listPagination(IdeasInversion item) {
       DataTable<IdeasInversion> oDatos = new DataTable<>();
       
       oDatos.setAaData(new ArrayList<IdeasInversion>());
    
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_PAGENUM", item.getPageInfo().getiPage())
                .addValue("N_PAGESIZE", item.getPageInfo().getiLength())
                .addValue("V_ANIO", item.getAnio())
                .addValue("V_TIPO", item.getTipo())
                .addValue("V_ESTADO_REGISTRO", item.getEstado_registro())
                .addValue("V_SIGLA", item.getSigla())
                .addValue("V_IOARR_PIP", item.getIdpip_ioarr())
                .addValue("V_NOMBREPROY", item.getNombreproy());
        
        Map map
                = listaPaginationIdeasInversion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result){
            
            IdeasInversion ideasInversion = new IdeasInversion();
            ideasInversion.setPageInfo(new Pagination());
            ideasInversion.getPageInfo().setiTotal(Format.toInteger(obj.get("TOTAL")));
            ideasInversion.getPageInfo().setiEnd(Format.toInteger(obj.get("iEND")));
            ideasInversion.setId(Format.toInteger(obj.get("id")));
            ideasInversion.setIdpip_ioarr(Format.toString(obj.get("idpip_ioarr")));
            ideasInversion.setNombreproy(Format.toString(obj.get("nombreproy")));
            ideasInversion.setTipo(Format.toString(obj.get("tipo")));
            ideasInversion.setSigla(Format.toString(obj.get("sigla")));
            ideasInversion.setCod_proceso_actual(Format.toInteger(obj.get("COD_PROCESO_ACTUAL")));
            ideasInversion.setProceso_actual(Format.toString(obj.get("PROCESO_ACTUAL")));
            ideasInversion.setEstado_registro(Format.toString(obj.get("ESTADO_PROCESO_ACTUAL")));
            ideasInversion.setCod_estado_registro(Format.toInt(obj.get("cod_estadoactu")));
            ideasInversion.setFeccreacio(Format.toString(obj.get("feccreacio")));
            ideasInversion.setAprobacionPMI(Format.toInt(obj.get("aprobacpmi")));
            ideasInversion.setCodunimef(Format.toString(obj.get("codunimef")));
            oDatos.getAaData().add(ideasInversion);
        }
         
        oDatos.setiDisplayRecords(oDatos.getAaData().size());
        return oDatos;
    }
    }

    
