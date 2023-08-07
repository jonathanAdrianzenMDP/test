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
import mil.fap.dao.IndiBrechaServicioData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.IndiBrechaServicio;
import mil.fap.models.ServTipologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("indibrechaserviciodata")
public class IndiBrechaServicioDataImplement implements IndiBrechaServicioData {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall listaIndiBrechaServicio;
        
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.listaIndiBrechaServicio = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_INDIBRECHASERVICIO");
        
    }

    @Override
    public List<IndiBrechaServicio> list(String servtipolo){
        List<IndiBrechaServicio> lIndiBrechaServicio = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("V_SERVTIPOLO", servtipolo);
            Map map = listaIndiBrechaServicio.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result)
             {
                IndiBrechaServicio idiBrechaServicio = new IndiBrechaServicio();
                idiBrechaServicio.setIdbrecindi(Format.toInteger(obj.get("IDBRECINDI")));
                idiBrechaServicio.setIndicbrech(Format.toString(obj.get("INDICBRECH")));
                idiBrechaServicio.setEstado(Format.toBoolean(obj.get("ESTADO")));

                lIndiBrechaServicio.add(idiBrechaServicio);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lIndiBrechaServicio;
    }

    
   
}