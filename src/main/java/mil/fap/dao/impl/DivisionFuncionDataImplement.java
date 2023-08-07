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
import mil.fap.dao.DivisionFuncionData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.DivisionFuncion;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mnieva
 */
@Repository("divisionFuncionData")
public class DivisionFuncionDataImplement implements DivisionFuncionData{
    
    private SimpleJdbcCall listaDivisionFuncion;
    private SimpleJdbcCall buscarIdDivfuncion;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        
         this.listaDivisionFuncion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_DIVISIONFUNCION");
          this.buscarIdDivfuncion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_DIVFUN");
    }
    
    @Override
    public List<DivisionFuncion> list(Integer idfuncion) {
         List<DivisionFuncion> lFuncion = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("N_IDFUNCION", idfuncion);
            Map map = listaDivisionFuncion.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result)
             {
                 DivisionFuncion divfun = new DivisionFuncion();
                divfun.setIddivfuncion(Format.toInteger(obj.get("IDDIVFUNCION")));
                divfun.setIdfuncion(Format.toInteger(obj.get("IDFUNCION")));
                divfun.setDescdivfuncion(Format.toString(obj.get("DESCDIVFUNCION")));
                divfun.setEstado(Format.toBoolean(obj.get("ESTADO")));

                lFuncion.add(divfun);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lFuncion;
    }

    @Override
    public DataTable<DivisionFuncion> Paginacion(DivisionFuncion item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message updataEstado(Integer iddivfuncion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(DivisionFuncion DivisionFuncion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(DivisionFuncion DivisionFuncion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DivisionFuncion buscarPorId(Integer iddivfuncion) {
              DivisionFuncion divisionFuncion = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_IDDIVFUNCION", iddivfuncion);

        Map map
                = buscarIdDivfuncion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            divisionFuncion = new DivisionFuncion();
            divisionFuncion.setIddivfuncion(Format.toInteger(obj.get("IDBRECINDI")));
            divisionFuncion.setIdfuncion(Format.toInteger(obj.get("IDSECTOR")));
            divisionFuncion.setDescdivfuncion(Format.toString(obj.get("IDGRUPOFUN")));
            divisionFuncion.setEstado(Format.toBoolean(obj.get("ESTADO")));

        }
        return divisionFuncion;
    }

}
