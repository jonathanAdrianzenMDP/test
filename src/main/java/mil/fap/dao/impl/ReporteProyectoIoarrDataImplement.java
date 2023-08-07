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
import mil.fap.dao.ReportePoyectoIoarrData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ReportePoyectoIoarr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristina
 */
@Repository("reporteProyectoIoarrData")
public class ReporteProyectoIoarrDataImplement implements ReportePoyectoIoarrData {

    private SimpleJdbcCall reporteProyectoIoarr;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.reporteProyectoIoarr = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_REPORTE)
                .withProcedureName("USP_GET_REPORTEIOARR");
    }

    @Override
    public List<ReportePoyectoIoarr> ReportePoyectoIoarr(Integer Idproioarr) {
        List<ReportePoyectoIoarr> lReportePoyectoIoarr = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("N_IDPROIOARR", Idproioarr);

            Map map = reporteProyectoIoarr.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for (Map obj : result) {

                ReportePoyectoIoarr oReporte = new ReportePoyectoIoarr();
                oReporte.setIdproioarr(Format.toInteger(obj.get("i_idproioarr")));
                oReporte.setNombreproy(Format.toString(obj.get("nombreproy")));
                oReporte.setDescfuncion(Format.toString(obj.get("descfuncion")));
                oReporte.setDescdivfuncion(Format.toString(obj.get("descdivfuncion")));
                oReporte.setDescgrupofunc(Format.toString(obj.get("descgrupofunc")));
                oReporte.setServiciopublico(Format.toString(obj.get("serviciopublico")));
                 oReporte.setIndicbrech(Format.toString(obj.get("indicbrech")));       
                oReporte.setUnidadmed(Format.toString(obj.get("unidadmed")));
                oReporte.setEspaciogeo(Format.toString(obj.get("espaciogeo")));
                oReporte.setAnio(Format.toString(obj.get("anio")));
                oReporte.setValorindicador(Format.toDouble(obj.get("valorindicador")));
                oReporte.setValorcontri(Format.toDouble(obj.get("valorcontri")));
                oReporte.setDescsector(Format.toString(obj.get("descsector")));
                oReporte.setDescentidad(Format.toString(obj.get("descentidad")));
                oReporte.setNombreuf(Format.toString(obj.get("nombreuf")));
                oReporte.setResponsableuf(Format.toString(obj.get("responsableuf")));
                oReporte.setNomuei(Format.toString(obj.get("nomuei")));
                oReporte.setResponsableuei(Format.toString(obj.get("responsableuei")));
                oReporte.setDepartamento(Format.toString(obj.get("departamento")));
                oReporte.setProvincia(Format.toString(obj.get("provincia")));
                oReporte.setDistrito(Format.toString(obj.get("distrito")));
                oReporte.setTipoejecu(Format.toString(obj.get("tipoejecu")));
                oReporte.setFincia(Format.toString(obj.get("fincia"))); 
                oReporte.setUnidproduc(Format.toString(obj.get("unidproduc"))); 
                oReporte.setRecursoperador(Format.toString(obj.get("RECURSOPERADOR")));
                oReporte.setFuentfinan(Format.toInteger(obj.get("fuentfinan")));
                oReporte.setModaliejec(Format.toInteger(obj.get("modaliejec")));
                oReporte.setEntiduep(Format.toString(obj.get("entiduep")));
                oReporte.setObjinterv(Format.toString(obj.get("objinterv")));
                lReportePoyectoIoarr.add(oReporte);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lReportePoyectoIoarr;
    }

}
