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
import mil.fap.dao.UnidadServicioData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.UnidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristina
 */
@Repository("unidadServicio")
public class UnidadServicioDataImplement implements UnidadServicioData {
  private SimpleJdbcCall listaUnidadServicio;
     @Autowired
    public void setDataSource(DataSource dataSource) {

        this.listaUnidadServicio = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GEL_UNIDADESSERVICIO_ALL");
  
    }
@Override
    public List<UnidadServicio> listaUnidadServicio() {
        List<UnidadServicio> unidadServicio = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource();
            Map map
                = listaUnidadServicio.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            UnidadServicio item = new UnidadServicio();
            
             item.setCodigo(Format.toString(obj.get("CODIGO")));
             item.setSigla(Format.toString(obj.get("SIGLA")));
             item.setIdorganigrama(Format.toString(obj.get("IDORGANIGRAMA")));
             unidadServicio.add(item);
        }
        return unidadServicio;
    }
}

