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
import mil.fap.dao.ProyectoPIPData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ProyectoPIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("proyectoPIPData")
public class ProyectoPIPDataImplement implements ProyectoPIPData {

    private SimpleJdbcCall insertarProyectoPIP;
    private SimpleJdbcCall actualizarProyectoPIP;
    private SimpleJdbcCall listaProyectoPIP;
    private SimpleJdbcCall actualizarPmiPIP;
    private SimpleJdbcCall actualizarFechaPlan;
    private SimpleJdbcCall actualizarNombreCodigo;
    private SimpleJdbcCall actualizarCierreInvPIP;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.insertarProyectoPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_PROYECTOPIP");
        this.actualizarProyectoPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOPIP");
        this.listaProyectoPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_SELECT_PROYECTOPIP");
        this.actualizarPmiPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOPIP_APROBPMI");
        this.actualizarFechaPlan = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOPIP_FECHA");
        this.actualizarCierreInvPIP = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOPIP_CIERRE");
        this.actualizarNombreCodigo = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_MONBRECODIGO");
    }

    @Override
    public Integer set(ProyectoPIP item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDBRECINDI", item.getIdbrecindi())
                .addValue("I_IDFUNCION", item.getIdfuncion())
                .addValue("I_IDDIVFUNCI", item.getIddivfunci())
                .addValue("I_IDGRUPOFUN", item.getIdgrupofun())
                .addValue("V_NATINTERVE", item.getNatinterve())
                .addValue("V_IDDEPARTAM", item.getIdDepartamento())
                .addValue("V_IDPROVINCI", item.getIdProvincia())
                .addValue("V_IDDISTRITO", item.getIdDistrito())
                .addValue("V_NOMPROYECT", item.getNomproyect())
                .addValue("I_IDTIPDOCTC", item.getIdtipdoctc())
                .addValue("I_TIPEJECPRO", item.getTipejecpro())
                .addValue("I_TIPFINANPR", item.getTipfinanpr())
                .addValue("I_APROBACPMI", item.getAprobacpmi())
                .addValue("V_ESTADO", item.getEstado())
                .addValue("V_USUCREACIO", item.getUsucreacio())
                .addValue("I_ESTADOACTU", item.getEstadoactu())
                .addValue("I_PROCACTUAL", item.getProcactual())
                .addValue("I_IDSECTRESP", item.getIdsectresp())
                .addValue("V_SERVPUBLIC", item.getServpublic())
                .addValue("V_UNIDADMED", item.getUnidadmed())
                .addValue("V_ESPACIOGEO", item.getEspaciogeo())
                .addValue("V_ANIO", item.getAnio())
                .addValue("D_VALORINDI", item.getValorindi())
                .addValue("D_VALORCONTRI", item.getValorcontri())
                .addValue("V_TIPOLOPRY", item.getTipolopry())
                .addValue("I_IDSECTORUF", item.getIdsectoruf())
                .addValue("I_IDENTIDAUF", item.getIdentidauf())
                .addValue("I_IDNOMBREUF", item.getIdnombreuf())
                .addValue("I_IDRESPONUF", item.getIdresponuf())
                .addValue("I_IDSECTOUFI", item.getIdsectoufi())
                .addValue("I_IDENTIDUFI", item.getIdentidufi())
                .addValue("I_IDNOMBRUEI", item.getIdnombruei())
                .addValue("I_IDRESPOUEI", item.getIdrespouei())
                .addValue("I_IDSECTOUEP", item.getIdsectouep())
                .addValue("I_IDENTIDUEP", item.getIdentiduep())
                .addValue("I_IDNOMBRUEP", item.getIdnombruep())
                .addValue("V_NOMUNIPROD", item.getNomuniprod())
                .addValue("V_DOCUTEC", item.getDocutec())
                .addValue("D_VALPREINV", item.getValpreinv())
                .addValue("V_OBJINTERV", item.getObjinterv())
                .addValue("V_CAPPRODUC", item.getCapproduc())
                .addValue("V_CODUNIDPRO", item.getCodunidpro());

        Map map = insertarProyectoPIP.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return Integer.parseInt(oCodigo);
    }

    @Override
    public Integer update(ProyectoPIP item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdProyepip())
                .addValue("I_IDBRECINDI", item.getIdbrecindi())
                .addValue("I_IDFUNCION", item.getIdfuncion())
                .addValue("I_IDDIVFUNCI", item.getIddivfunci())
                .addValue("I_IDGRUPOFUN", item.getIdgrupofun())
                .addValue("V_NATINTERVE", item.getNatinterve())
                .addValue("V_IDDEPARTAM", item.getIdDepartamento())
                .addValue("V_IDPROVINCI", item.getIdProvincia())
                .addValue("V_IDDISTRITO", item.getIdDistrito())
                .addValue("V_NOMPROYECT", item.getNomproyect())
                .addValue("I_IDTIPDOCTC", item.getIdtipdoctc())
                .addValue("I_TIPEJECPRO", item.getTipejecpro())
                .addValue("I_TIPFINANPR", item.getTipfinanpr())
                .addValue("V_ESTADO", item.getEstado())
                .addValue("V_USUCREACIO", item.getUsucreacio())
                .addValue("I_ESTADOACTU", item.getEstadoactu())
                .addValue("I_PROCACTUAL", item.getProcactual())
                .addValue("I_IDSECTRESP", item.getIdsectresp())
                .addValue("V_SERVPUBLIC", item.getServpublic())
                .addValue("V_UNIDADMED", item.getUnidadmed())
                .addValue("V_ESPACIOGEO", item.getEspaciogeo())
                .addValue("V_ANIO", item.getAnio())
                .addValue("D_VALORINDI", item.getValorindi())
                .addValue("D_VALORCONTRI", item.getValorcontri())
                .addValue("V_TIPOLOPRY", item.getTipolopry())
                .addValue("I_IDSECTORUF", item.getIdsectoruf())
                .addValue("I_IDENTIDAUF", item.getIdentidauf())
                .addValue("I_IDNOMBREUF", item.getIdnombreuf())
                .addValue("I_IDRESPONUF", item.getIdresponuf())
                .addValue("I_IDSECTOUFI", item.getIdsectoufi())
                .addValue("I_IDENTIDUFI", item.getIdentidufi())
                .addValue("I_IDNOMBRUEI", item.getIdnombruei())
                .addValue("I_IDRESPOUEI", item.getIdrespouei())
                .addValue("I_IDSECTOUEP", item.getIdsectouep())
                .addValue("I_IDENTIDUEP", item.getIdentiduep())
                .addValue("I_IDNOMBRUEP", item.getIdnombruep())
                .addValue("V_NOMUNIPROD", item.getNomuniprod())
                .addValue("V_NOMUNIPROD", item.getNomuniprod())
                .addValue("V_DOCUTEC", item.getDocutec())
                .addValue("V_USUMODIFIC", item.getUsumodific())
                .addValue("D_VALPREINV", item.getValpreinv())
                .addValue("V_OBJINTERV", item.getObjinterv())
                .addValue("V_CAPPRODUC", item.getCapproduc());

        Map map = actualizarProyectoPIP.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

    @Override
    public ProyectoPIP get(Integer id) {
        ProyectoPIP proyectoPIP = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", id);

        Map map
                = listaProyectoPIP.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            proyectoPIP = new ProyectoPIP();
            proyectoPIP.setIdProyepip(Format.toInteger(obj.get("IDPROYEPIP")));
            proyectoPIP.setV_idProyepip(Format.toString(obj.get("V_IDPROYEPIP")));
            proyectoPIP.setIdbrecindi(Format.toInteger(obj.get("IDBRECINDI")));
            proyectoPIP.setIdfuncion(Format.toInteger(obj.get("IDFUNCION")));
            proyectoPIP.setIddivfunci(Format.toInteger(obj.get("IDDIVFUNCI")));
            proyectoPIP.setIdgrupofun(Format.toInteger(obj.get("IDGRUPOFUN")));
            proyectoPIP.setNatinterve(Format.toString(obj.get("NATINTERVE")));
            proyectoPIP.setNomproyect(Format.toString(obj.get("NOMPROYECT")));
            proyectoPIP.setIdtipdoctc(Format.toInteger(obj.get("IDTIPDOCTC")));
            proyectoPIP.setTipejecpro(Format.toInteger(obj.get("TIPEJECPRO")));
            proyectoPIP.setTipfinanpr(Format.toInteger(obj.get("TIPFINANPR")));
            proyectoPIP.setAprobacpmi(Format.toInteger(obj.get("APROBACPMI")));
            proyectoPIP.setEstado(Format.toString(obj.get("ESTADO")));
            proyectoPIP.setFeccreacio(Format.toString(obj.get("FECCREACIO")));
            proyectoPIP.setUsucreacio(Format.toString(obj.get("USUCREACIO")));
            proyectoPIP.setEstadoactu(Format.toInteger(obj.get("ESTADOACTU")));
            proyectoPIP.setDesc_estadoactu(Format.toString(obj.get("DESCESTADOACTU")));
            proyectoPIP.setProcactual(Format.toInteger(obj.get("PROCACTUAL")));
            proyectoPIP.setDesc_procactual(Format.toString(obj.get("DESCPROCACTUAL")));
            proyectoPIP.setIdDepartamento(Format.toString(obj.get("IDDEPARTAM")));
            proyectoPIP.setIdProvincia(Format.toString(obj.get("IDPROVINCI")));
            proyectoPIP.setIdDistrito(Format.toString(obj.get("IDDISTRITO")));
            proyectoPIP.setIdsectresp(Format.toInteger(obj.get("IDSECTRESP")));
            proyectoPIP.setServpublic(Format.toString(obj.get("SERVPUBLIC")));
            proyectoPIP.setUnidadmed(Format.toString(obj.get("UNIDADMED")));
            proyectoPIP.setEspaciogeo(Format.toString(obj.get("ESPACIOGEO")));
            proyectoPIP.setAnio(Format.toString(obj.get("ANIO")));
            proyectoPIP.setValorindi(Format.toDouble(obj.get("VALORINDI")));
            proyectoPIP.setValorcontri(Format.toDouble(obj.get("VALORCONTRI")));
            proyectoPIP.setTipolopry(Format.toString(obj.get("TIPOLOPRY")));
            proyectoPIP.setIdsectoruf(Format.toInteger(obj.get("IDSECTORUF")));
            proyectoPIP.setIdentidauf(Format.toInteger(obj.get("IDENTIDAUF")));
            proyectoPIP.setIdnombreuf(Format.toInteger(obj.get("IDNOMBREUF")));
            proyectoPIP.setIdresponuf(Format.toInteger(obj.get("IDRESPONUF")));
            proyectoPIP.setIdsectoufi(Format.toInteger(obj.get("IDSECTOUFI")));
            proyectoPIP.setIdentidufi(Format.toInteger(obj.get("IDENTIDUFI")));
            proyectoPIP.setIdnombruei(Format.toInteger(obj.get("IDNOMBRUEI")));
            proyectoPIP.setIdrespouei(Format.toInteger(obj.get("IDRESPOUEI")));
            proyectoPIP.setIdsectouep(Format.toInteger(obj.get("IDSECTOUEP")));
            proyectoPIP.setIdentiduep(Format.toInteger(obj.get("IDENTIDUEP")));
            proyectoPIP.setIdnombruep(Format.toInteger(obj.get("IDNOMBRUEP")));
            proyectoPIP.setNomuniprod(Format.toString(obj.get("NOMUNIPROD")));
            proyectoPIP.setDocutec(Format.toString(obj.get("DOCUTEC")));
            proyectoPIP.setValpreinv(Format.toDouble(obj.get("VALPREINV")));
            proyectoPIP.setCodunimef(Format.toInteger(obj.get("CODUNIMEF")));
            proyectoPIP.setObjinterv(Format.toString(obj.get("OBJINTERV")));
            proyectoPIP.setCapproduc(Format.toString(obj.get("CAPPRODUC")));
            proyectoPIP.setV_valpreinv(Format.toString(obj.get("VALPREINV")));
            proyectoPIP.setV_totalMontoItem(Format.toString(obj.get("V_TOTALCOSTOREF")));
            proyectoPIP.setFecplatra(Format.toString(obj.get("FECPLATRA")));
            proyectoPIP.setCierreinv(Format.toInteger(obj.get("CIERREINV")));
            proyectoPIP.setNomforeva(Format.toString(obj.get("NOMFOREVA")));
            proyectoPIP.setCodforeva(Format.toString(obj.get("CODFOREVA")));
        }
        return proyectoPIP;
    }

    @Override
    public void updatePmiPIP(ProyectoPIP item) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_APROBACPMI", item.getAprobacpmi())
                .addValue("I_CODUNIMEF", item.getCodunimef())
                .addValue("I_IDPROYEPIP", item.getIdProyepip())
                .addValue("V_USUARIO", item.getUsumodific());

        actualizarPmiPIP.execute(in);

    }

    @Override
    public String updateCierreInvPIP(ProyectoPIP item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdProyepip())
                .addValue("I_CIERREINV", item.getCierreinv());

        Map map = actualizarCierreInvPIP.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public Integer updateFechaPlan(ProyectoPIP item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdProyepip())
                .addValue("D_FECPLATRA", item.getFecplatra());

        Map map = actualizarFechaPlan.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

    @Override
    public Integer updateNombreCodigo(ProyectoPIP item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROYEPIP", item.getIdProyepip())
                .addValue("V_NOMFOREVA", item.getNomforeva())
                .addValue("V_CODFOREVA", item.getCodforeva());

        Map map = actualizarNombreCodigo.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

}
