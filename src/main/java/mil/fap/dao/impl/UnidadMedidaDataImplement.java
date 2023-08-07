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
import mil.fap.dao.UnidadMedidaData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.UnidadMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("unidadMedidadata")
public class UnidadMedidaDataImplement implements UnidadMedidaData {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall listaUnidadMedida;
        
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.listaUnidadMedida = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_UNIDADMEDIDA");
        
    }

    @Override
    public List<UnidadMedida> list(Integer idbrecindi){
        List<UnidadMedida> lUnidadMedida = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("N_IDBRECINDI", idbrecindi);
            Map map = listaUnidadMedida.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result)
             {
                UnidadMedida idUnidadMedida = new UnidadMedida();
                idUnidadMedida.setIdbrecindi(Format.toInteger(obj.get("IDBRECINDI")));
                idUnidadMedida.setUnimed(Format.toString(obj.get("UNIMED")));
                idUnidadMedida.setTipologia(Format.toString(obj.get("TIPOLOGIA")));
                idUnidadMedida.setCapprod(Format.toString(obj.get("CAPPROD")));
                idUnidadMedida.setEstado(Format.toBoolean(obj.get("ESTADO")));

                lUnidadMedida.add(idUnidadMedida);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lUnidadMedida;
    }

    
   
}