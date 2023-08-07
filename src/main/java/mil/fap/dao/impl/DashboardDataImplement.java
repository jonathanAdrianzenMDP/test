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
import mil.fap.dao.DashboardData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.Dashboard;
import mil.fap.models.FuenteFinancieroEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("dashboardData")
public class DashboardDataImplement implements DashboardData {

    private SimpleJdbcCall chartCantidadIdeasInversion;
    private SimpleJdbcCall chartTotalCostoIdeasInversion;
    private SimpleJdbcCall chartTotalFuenteFinanciamiento;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.chartCantidadIdeasInversion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_REPORTE)
                .withProcedureName("USP_GET_LISTCANT_PIP_IOARR");
        this.chartTotalCostoIdeasInversion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_REPORTE)
                .withProcedureName("USP_SEL_REPTOTALINVERSION");
        this.chartTotalFuenteFinanciamiento = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_REPORTE)
                .withProcedureName("USP_GET_FINANCIAMIENTO");
    }

    @Override
    public List<Dashboard> getCantidadIdeasInversion(Dashboard item) { 
        
        List<Dashboard> oDatos = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("V_ANIO", item.getAnio())
                .addValue("I_ESTADOACTU", item.getEstadoactu())
                .addValue("I_PROCACTUAL", item.getProcactual());

        Map map
                = chartCantidadIdeasInversion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            Dashboard dashboard = new Dashboard();
            dashboard.setTotal(Format.toInteger(obj.get("TOTAL")));
            dashboard.setTipo(Format.toString(obj.get("TIPO")));
            dashboard.setAnio(Format.toInteger(obj.get("ANIO")));
            
            oDatos.add(dashboard);

        }
        return oDatos;
    }
    @Override
    public List<Dashboard> getTotalCostoIdeasInversion(Dashboard item) { 
        
        List<Dashboard> oDatos = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("V_ANIO", item.getAnio());

        Map map
                = chartTotalCostoIdeasInversion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            Dashboard dashboard = new Dashboard();
            dashboard.setCosto(Format.toString(obj.get("COSTO")));
            dashboard.setTipo(Format.toString(obj.get("TIPO")));
            
            oDatos.add(dashboard);

        }
        return oDatos;
    }
    
    @Override
    public List<FuenteFinancieroEN> getFuenteFinanciamiento(FuenteFinancieroEN item) { 
        
        List<FuenteFinancieroEN> oDatos = new ArrayList<>();

        SqlParameterSource in = new MapSqlParameterSource()
                 .addValue("V_ANIO", item.getAnio());

        Map map
                = chartTotalFuenteFinanciamiento.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            FuenteFinancieroEN _item = new FuenteFinancieroEN();
            _item.setTipo(Format.toString(obj.get("TIPO")));
            _item.setRecurso_ordinario(Format.toDouble(obj.get("recordin")));
            _item.setRecurso_direc_recaudado(Format.toDouble(obj.get("recdirrec")));
            _item.setRecurso_operacion(Format.toDouble(obj.get("recroor")));
            _item.setDonacion_transferencia(Format.toDouble(obj.get("recdontra")));
            _item.setRecurso_determinado(Format.toDouble(obj.get("recdeter")));
            
            
            oDatos.add(_item);

        }
        return oDatos;
    }
}
