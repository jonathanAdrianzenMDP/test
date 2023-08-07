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
import mil.fap.dao.ReporteBrechaIndicadorData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ReporteBrechaIndicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


@Repository("reporteBrechaIndicadorData")
public class ReporteBrechaIndicadorDataImplement implements ReporteBrechaIndicadorData {
    
    private SimpleJdbcCall verReporteBrechaIndicador;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.verReporteBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_REPORTE)
                .withProcedureName("USP_GET_REPORTE_BRECHAINDI_ALL");
    }
    
    @Override
    public List<ReporteBrechaIndicador> getReporteBrechaIndicador(String anio, String servtipolo, String indicbrech) {
         List<ReporteBrechaIndicador> lReportes = new ArrayList<ReporteBrechaIndicador>();
          SqlParameterSource in = new MapSqlParameterSource()
                .addValue("V_ANIO", anio)
                .addValue("V_SERVTIPOLO", servtipolo)
                .addValue("V_INDICBRECH", indicbrech);
         
                
      Map map   = verReporteBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            ReporteBrechaIndicador oReporteBrechaIndicador = new ReporteBrechaIndicador();
            oReporteBrechaIndicador.setDESCSECTOR(Format.toString(obj.get("DESCSECTOR")));
            oReporteBrechaIndicador.setDESCFUNCION(Format.toString(obj.get("DESCFUNCION")));
            oReporteBrechaIndicador.setDESCDIVFUNCION(Format.toString(obj.get("DESCDIVFUNCION")));
            oReporteBrechaIndicador.setDESCGRUPOFUNC(Format.toString(obj.get("DESCGRUPOFUNC")));
            oReporteBrechaIndicador.setTIPOLOGIA(Format.toString(obj.get("TIPOLOGIA")));
            oReporteBrechaIndicador.setSERVTIPOLO(Format.toString(obj.get("SERVTIPOLO")));
            oReporteBrechaIndicador.setINDICBRECH(Format.toString(obj.get("INDICBRECH")));
            oReporteBrechaIndicador.setIDBRECINDI(Format.toInt(obj.get("IDBRECINDI")));
            oReporteBrechaIndicador.setVALOR(Format.toString(obj.get("VALOR")));
            oReporteBrechaIndicador.setANIO(Format.toString(obj.get("ANIO")));
            oReporteBrechaIndicador.setFECCREACIO(Format.toString(obj.get("FECCREACIO")));
            oReporteBrechaIndicador.setUNIMED(Format.toString(obj.get("UNIMED")));
            oReporteBrechaIndicador.setCAPPROD(Format.toString(obj.get("CAPPROD")));
            lReportes.add(oReporteBrechaIndicador);
        }
        return lReportes;
    }

    

}
