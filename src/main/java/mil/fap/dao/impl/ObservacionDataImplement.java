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
import mil.fap.dao.ObservacionData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.Observacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristina
 */
@Repository("observacionData")
public class ObservacionDataImplement implements ObservacionData{
    
    private SimpleJdbcCall insertarObservacion;
    private SimpleJdbcCall listarObservacion;
  
   @Autowired
   public void setDataSource(DataSource dataSource) {
        
         this.insertarObservacion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_OBSERVADO");
         this.listarObservacion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_GET_OBSERVACION_ALL");
   }
   
    @Override
    public String insert(Observacion item) {
        String oCodigo = "";
        
        SqlParameterSource in = new MapSqlParameterSource()
        .addValue("V_DESCOBSERV", item.getDESCOBSERV())
        .addValue("V_USUCREACIO", item.getUsucreacio())
        .addValue("I_IDPROIOARR", item.getIDPROIOARR())
        .addValue("I_IDPROYEPIP", item.getIDPROYEPIP())
        .addValue("I_PROCACTUAL", item.getPROCACTUAL());
        
        Map map =
          insertarObservacion.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result){
                oCodigo = Format.toString(obj.get("MSG"));
            }
         return oCodigo;   
    }

    @Override
    public List<Observacion> getAll(Observacion item) {
        List<Observacion> lst = new ArrayList<>();
        SqlParameterSource in = new MapSqlParameterSource()
            .addValue("I_IDPROIOARR", item.getIDPROIOARR())
            .addValue("I_IDPROYEPIP", item.getIDPROYEPIP());
        Map map = listarObservacion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        
        for(Map i : result){

            Observacion obj = new Observacion();
            obj.setIDOBSERVAC(Format.toInteger(i.get("IDOBSERVAC")));
            obj.setDESCOBSERV(Format.toString(i.get("DESCOBSERV")));
            obj.setFeccreacio(Format.toString(i.get("FECHACREACION")));
            obj.setUsucreacio(Format.toString(i.get("USUCREACIO")));
            obj.setIDPROIOARR(Format.toInteger(i.get("IDPROIOARR")));
            obj.setIDPROYEPIP(Format.toInteger(i.get("IDPROYEPIP")));
            obj.setPROCACTUAL(Format.toInteger(i.get("PROCACTUAL")));
            obj.setDESCPROCACTUAL(Format.toString(i.get("VALOR")));
            lst.add(obj);
        }
        
        return lst;
    }
    
}
