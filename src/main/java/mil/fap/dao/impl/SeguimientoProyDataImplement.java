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
import mil.fap.dao.SeguimientoProyData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.SeguimientoProy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("seguimientoProyData")
public class SeguimientoProyDataImplement implements SeguimientoProyData {

    private SimpleJdbcCall insertarSeguimientoProyIOARR;
    private SimpleJdbcCall insertarSeguimientoProyPIP;
    private SimpleJdbcCall listarSeguimientoEstadosPIP;
    private SimpleJdbcCall seleccionarUltimoEstadoPorProceso;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.insertarSeguimientoProyIOARR = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_SEGUIMIENTOPROY_IOARR");
        this.insertarSeguimientoProyPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_SEGUIMIENTOPROY_PIP");
        this.listarSeguimientoEstadosPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_GET_SEGUIMIENTOESTADOS");
        this.seleccionarUltimoEstadoPorProceso = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_SEL_ESTADOPORPROCESO");;

    }

    public Integer setIOARR(SeguimientoProy item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_CODPROCESO", item.getCodproceso())
                .addValue("I_ESTADOPROC", item.getEstadoproc())
                .addValue("I_IDPROIOARR", item.getIdproioarr())
                .addValue("V_USUCREACIO", item.getUsucreacio())
                .addValue("V_TERMINALIP", item.getIpTerminal());

        Map map = insertarSeguimientoProyIOARR.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return Integer.parseInt(oCodigo);
    }

    public Integer setPIP(SeguimientoProy item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_CODPROCESO", item.getCodproceso())
                .addValue("I_ESTADOPROC", item.getEstadoproc())
                .addValue("I_IDPROYEPIP", item.getIdproyepip())
                .addValue("V_USUCREACIO", item.getUsucreacio())
                .addValue("V_TERMINALIP", item.getIpTerminal());

        Map map = insertarSeguimientoProyPIP.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return Integer.parseInt(oCodigo);
    }

    @Override
    public List<SeguimientoProy> getSeguimientoEstadosPIP_IOARR(Integer IDPROIOARR, Integer IDPROYEPIP) {
          List<SeguimientoProy> lst = new ArrayList<SeguimientoProy>();
         
            SqlParameterSource in = new MapSqlParameterSource()
            .addValue("I_IDPROIOARR", IDPROIOARR)
            .addValue("I_IDPROYEPIP", IDPROYEPIP);
            
            Map map = listarSeguimientoEstadosPIP.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            
            for (Map obj : result) {
                
                SeguimientoProy item = new SeguimientoProy();
                item.setCodproceso(Format.toInteger(obj.get("CODPROCESO")));
                item.setIdproyepip(Format.toInteger(obj.get("I_IDPROYEPIP")));
                item.setIdproioarr(Format.toInteger(obj.get("I_IDPROIOARR")));
                item.setEstadoproc(Format.toInteger(obj.get("ESTADOACTU")));
                item.setNombreProc(Format.toString(obj.get("NOMPROC")));
                item.setStyleProc(Format.toString(obj.get("STYLE")).toLowerCase());
                lst.add(item);
            }
        
        return lst;
    }
    @Override
    public SeguimientoProy getUltimoEstadoPorProceso(SeguimientoProy item) {
          SeguimientoProy seguimiento = new SeguimientoProy();
         
            SqlParameterSource in = new MapSqlParameterSource()
            .addValue("I_IDPROIOARR", item.getIdproioarr())
            .addValue("I_IDPROYEPIP", item.getIdproyepip())
            .addValue("I_CODPROCESO", item.getCodproceso());
            
            Map map = seleccionarUltimoEstadoPorProceso.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            
            for (Map obj : result) {
                seguimiento.setNombreEstado(Format.toString(obj.get("NOMESTADO")));
                seguimiento.setEstadoproc(Format.toInteger(obj.get("CODESTADO")));
                seguimiento.setStyleProc(Format.toString(obj.get("STYLE")).toLowerCase());
                seguimiento.setAVANCE_IOARR(Format.toDouble(obj.get("AVANCE_IOARR")));
                seguimiento.setAVANCE_PIP(Format.toDouble(obj.get("AVANCE_PIP")));
            }
        
        return seguimiento;
    }
}
