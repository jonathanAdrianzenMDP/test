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
import mil.fap.dao.ReporteProyectoPIPData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ReporteProyectoPIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose
 */
@Repository("reporteProyectoPIPData")
public class ReporteProyectoPIPDataImplement implements ReporteProyectoPIPData {

    private SimpleJdbcCall reporteProyectoPIP;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.reporteProyectoPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_REPORTE)
                .withProcedureName("USP_GET_REPORTEPIP_ALL");
    }

    @Override
    public List<ReporteProyectoPIP> ReporteProyectoPIP(Integer Idproyepip) {
        List<ReporteProyectoPIP> lReporteProyectoPIP = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("N_IDPROYEPIP", Idproyepip);

            Map map = reporteProyectoPIP.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for (Map obj : result) {
                ReporteProyectoPIP oReporte = new ReporteProyectoPIP();
                oReporte.setIDPROYEPIP(Format.toInteger(obj.get("IDPROYEPIP")));
                oReporte.setNOMPROYECT(Format.toString(obj.get("NOMPROYECT")));
                oReporte.setDESCFUNCION(Format.toString(obj.get("DESCFUNCION")));
                oReporte.setDESCDIVFUNCION(Format.toString(obj.get("DESCDIVFUNCION")));
                oReporte.setDESCGRUPOFUNC(Format.toString(obj.get("DESCGRUPOFUNC")));
                oReporte.setSECRESPONS(Format.toString(obj.get("SECRESPONS")));
                oReporte.setSERVPUBLIC(Format.toString(obj.get("SERVPUBLIC")));
                oReporte.setINDICBRECH(Format.toString(obj.get("INDICBRECH")));
                oReporte.setUNIDADMED(Format.toString(obj.get("UNIDADMED")));
                oReporte.setESPACIOGEO(Format.toString(obj.get("ESPACIOGEO")));
                oReporte.setANIO(Format.toString(obj.get("ANIO")));
                oReporte.setVALORINDI(Format.toDouble(obj.get("VALORINDI")));
                oReporte.setVALORCONTRI(Format.toDouble(obj.get("VALORCONTRI")));
                oReporte.setTIPOLOGIA(Format.toString(obj.get("TIPOLOGIA")));
                oReporte.setDESCSECTOR(Format.toString(obj.get("DESCSECTOR")));
                oReporte.setDESCENTIDAD(Format.toString(obj.get("DESCENTIDAD")));
                oReporte.setNOMBREUF(Format.toString(obj.get("NOMBREUF")));
                oReporte.setRESPONSABLEUF(Format.toString(obj.get("RESPONSABLEUF")));
                oReporte.setNOMBREUEI(Format.toString(obj.get("NOMBREUEI")));
                oReporte.setRESPONSABLEUEI(Format.toString(obj.get("RESPONSABLEUEI")));
                oReporte.setNATINTERVE(Format.toString(obj.get("NATINTERVE")));
                oReporte.setNOMUNIPROD(Format.toString(obj.get("NOMUNIPROD")));
                oReporte.setDEPARTAMENTO(Format.toString(obj.get("DEPARTAMENTO")));
                oReporte.setPROVINCIA(Format.toString(obj.get("PROVINCIA")));
                oReporte.setDISTRITO(Format.toString(obj.get("DISTRITO")));
                oReporte.setTIPOEJECU(Format.toString(obj.get("TIPOEJECU")));
                oReporte.setFINACIA(Format.toString(obj.get("FINACIA")));
                oReporte.setTIPEJECPRO(Format.toInteger(obj.get("TIPEJECPRO")));
                oReporte.setTIPFINANPR(Format.toInteger(obj.get("TIPFINANPR")));
                oReporte.setIDNOMBRUEI(Format.toInteger(obj.get("IDNOMBRUEI")));
                oReporte.setIDRESPOUEI(Format.toInteger(obj.get("IDRESPOUEI")));
                oReporte.setDOCUTEC(Format.toString(obj.get("DOCUTEC")));
                oReporte.setVALPREINV(Format.toString(obj.get("VALPREINV")));
                oReporte.setENTIDUEP(Format.toString(obj.get("ENTIDUEP")));
                oReporte.setOBJINTERV(Format.toString(obj.get("OBJINTERV")));
                oReporte.setV_totalMontoItem(Format.toString(obj.get("V_TOTALCOSTOREF")));
                oReporte.setCAPPRODUC(Format.toString(obj.get("CAPPRODUC")));
                lReporteProyectoPIP.add(oReporte);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lReporteProyectoPIP;
    }

}
