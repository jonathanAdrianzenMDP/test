
package mil.fap.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mil.fap.dao.ServTipologiaData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ServTipologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


@Repository("servtipologiaData")
public class ServTipologiaDataImplement implements ServTipologiaData {
     private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall listaServTipologia;
        
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.listaServTipologia = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_SERVTIPOLOGIA");
        
    }

    @Override
    public List<ServTipologia> list(Integer idgrupofun){
        List<ServTipologia> lServTipologia = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("N_IDGRUPOFUN", idgrupofun);
            Map map = listaServTipologia.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result)
             {
                ServTipologia servtipologia = new ServTipologia();
                servtipologia.setIdgrupofun(Format.toInteger(obj.get("IDGRUPOFUN")));
                servtipologia.setServtipolo(Format.toString(obj.get("SERVTIPOLO")));
                servtipologia.setEstado(Format.toBoolean(obj.get("ESTADO")));

                lServTipologia.add(servtipologia);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lServTipologia;
    }

    
   
}
