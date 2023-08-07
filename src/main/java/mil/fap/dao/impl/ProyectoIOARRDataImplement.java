/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao.impl;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mil.fap.dao.ProyectoIOARRData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.ProyectoIOARR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan
 */
@Repository("proyectoIOARRData")
public class ProyectoIOARRDataImplement implements ProyectoIOARRData {

    private SimpleJdbcCall insertarProyectoIOARR;
    private SimpleJdbcCall actualizarProyectoIOARR;
    private SimpleJdbcCall seleccionarProyectoIOARR;
    private SimpleJdbcCall actualizarUIT;
    private SimpleJdbcCall actualizarCierreInv;
    private SimpleJdbcCall actualizarPMI;
    private SimpleJdbcCall actualizarNombreCodigoIOARR;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.insertarProyectoIOARR = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_INS_PROYECTOIOARR");
        this.actualizarProyectoIOARR = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOIOARR");
        this.seleccionarProyectoIOARR = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_SEL_PROYECTOIOARR_GET");
        this.actualizarPMI = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOIOARR_APROBPMI");
        this.actualizarUIT = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOIOARR_UIT");
        this.actualizarCierreInv = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_PROYECTOIOARR_CIERRE");
        this.actualizarNombreCodigoIOARR = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_PMI)
                .withProcedureName("USP_UPD_MONBRECODIGO_IOARR");
    }

    @Override
    public Integer set(ProyectoIOARR item) {
        String oCodigo = "";

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDRESPONUF", item.getidResponsableUF())
                .addValue("I_IDSECTORUF", item.getIdSectorUF())
                .addValue("I_IDNOMBREUF", item.getIdNombreUF())
                .addValue("I_IDENTIDAUF", item.getIdEntidadUF())
                .addValue("I_IDSECTOUFI", item.getIdSectorUFI())
                .addValue("I_IDENTIDUFI", item.getIdEntidadUFI())
                .addValue("I_IDNOMBRUEI", item.getIdNombreUEI())
                .addValue("I_IDRESPOUEI", item.getIdResponsableUEI())
                .addValue("I_IDSECTOUEP", item.getIdSectorUEP())
                .addValue("I_IDENTIDUEP", item.getIdEntidadUEP())
                .addValue("I_IDNOMBRUEP", item.getIdNombreUEP())
                .addValue("I_IDFUNCION", item.getIdFuncion())
                .addValue("I_IDDIVFUNCION", item.getIdDivFuncion())
                .addValue("I_IDGRUPOFUN", item.getIdGrupoFuncion())
                .addValue("I_IDSECTRESP", item.getIdSectorResponsable())
                .addValue("V_SERVPUBLIC", item.getServicioPulico())
                .addValue("I_IDBRECINDI", item.getIdBrechaIndicador())
                .addValue("V_UNIDPRODUC", item.getUnidadProductora())
                .addValue("V_CODUNIDPRO", item.getCodUnidadProductora())
                .addValue("V_IDDEPARTAM", item.getIdDepartamento())
                .addValue("V_IDPROVINCI", item.getIdProvincia())
                .addValue("V_IDDISTRITO", item.getIdDistrito())
                .addValue("V_RECURSOPERADOR", item.getFinanciaTotalParcial())
                .addValue("V_USUCREACIO", item.getUsucreacio())
                .addValue("I_ESTADOACTU", item.getIdEstadoActual())
                .addValue("I_PROCACTUAL", item.getIdProcesoActual())
                .addValue("I_MODALIEJEC", item.getModalidadEjecucion())
                .addValue("I_FUENTFINAN", item.getFuenteFinanciamiento())
                .addValue("I_APROBACPMI", item.getAprobacionPMI())
                .addValue("V_NOMBREPROY", item.getNombreInversion())
                .addValue("V_UNIDADMED", item.getUnidadmed())
                .addValue("V_ESPACIOGEO", item.getEspaciogeo())
                .addValue("V_ANIO", item.getAnio())
                .addValue("D_VALORINDICADOR", item.getValorindicador())
                .addValue("D_VALORCONTRI", item.getValorcontri())
                .addValue("V_OBJINTERV", item.getObjinterv());

        Map map
                = insertarProyectoIOARR.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

    @Override
    public ProyectoIOARR getById(Integer id) {
        ProyectoIOARR proyectoIOARR = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", id);

        Map map = seleccionarProyectoIOARR.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            proyectoIOARR = new ProyectoIOARR();
            proyectoIOARR.setIdProIOARR(Format.toInteger(obj.get("IDPROIOARR")));
            proyectoIOARR.setV_idProIOARR(Format.toString(obj.get("V_IDPROIOARR")));
            proyectoIOARR.setResponsableUF(Format.toInteger(obj.get("IDRESPONUF")));
            proyectoIOARR.setIdSectorUF(Format.toInteger(obj.get("IDSECTORUF")));
            proyectoIOARR.setIdNombreUF(Format.toInteger(obj.get("IDNOMBREUF")));
            proyectoIOARR.setIdEntidadUF(Format.toInteger(obj.get("IDENTIDAUF")));
            proyectoIOARR.setIdSectorUFI(Format.toInteger(obj.get("IDSECTOUFI")));
            proyectoIOARR.setIdEntidadUFI(Format.toInteger(obj.get("IDENTIDUFI")));
            proyectoIOARR.setIdNombreUEI(Format.toInteger(obj.get("IDNOMBRUEI")));
            proyectoIOARR.setIdResponsableUEI(Format.toInteger(obj.get("IDRESPOUEI")));
            proyectoIOARR.setIdSectorUEP(Format.toInteger(obj.get("IDSECTOUEP")));
            proyectoIOARR.setIdEntidadUEP(Format.toInteger(obj.get("IDENTIDUEP")));
            proyectoIOARR.setIdNombreUEP(Format.toInteger(obj.get("IDNOMBRUEP")));
            proyectoIOARR.setIdFuncion(Format.toInteger(obj.get("IDFUNCION")));
            proyectoIOARR.setIdDivFuncion(Format.toInteger(obj.get("IDDIVFUNCION")));
            proyectoIOARR.setIdGrupoFuncion(Format.toInteger(obj.get("IDGRUPOFUN")));
            proyectoIOARR.setIdSectorResponsable(Format.toInteger(obj.get("IDSECTRESP")));
            proyectoIOARR.setServicioPulico(Format.toString(obj.get("SERVPUBLIC")));
            proyectoIOARR.setIdBrechaIndicador(Format.toInteger(obj.get("IDBRECINDI")));
            proyectoIOARR.setUnidadProductora(Format.toString(obj.get("UNIDPRODUC")));
            proyectoIOARR.setCodUnidadProductora(Format.toString(obj.get("CODUNIDPRO")));
            proyectoIOARR.setIdDepartamento(Format.toString(obj.get("IDDEPARTAM")));
            proyectoIOARR.setIdProvincia(Format.toString(obj.get("IDPROVINCI")));
            proyectoIOARR.setIdDistrito(Format.toString(obj.get("IDDISTRITO")));
            proyectoIOARR.setCentroPoblado(Format.toString(obj.get("CENTROPOBL")));
            proyectoIOARR.setLongitudLatitud(Format.toString(obj.get("LONGITLATI")));
            proyectoIOARR.setFinanciaTotalParcial(Format.toString(obj.get("RECURSOPERADOR")));
            proyectoIOARR.setUsucreacio(Format.toString(obj.get("USUMODIFIC")));
            proyectoIOARR.setIdEstadoActual(Format.toInteger(obj.get("ESTADOACTU")));
            proyectoIOARR.setDesc_estadoactu(Format.toString(obj.get("DESCESTADOACTU")));
            proyectoIOARR.setIdProcesoActual(Format.toInteger(obj.get("PROCACTUAL")));
            proyectoIOARR.setFeccreacio(Format.toString(obj.get("FECCREACIO")));
            proyectoIOARR.setFuenteFinanciamiento(Format.toInteger(obj.get("FUENTFINAN")));
            proyectoIOARR.setModalidadEjecucion(Format.toInteger(obj.get("MODALIEJEC")));
            proyectoIOARR.setNombreInversion(Format.toString(obj.get("NOMBREPROY")));
            proyectoIOARR.setUnidadmed(Format.toString(obj.get("UNIDADMED")));
            proyectoIOARR.setEspaciogeo(Format.toString(obj.get("ESPACIOGEO")));
            proyectoIOARR.setAnio(Format.toString(obj.get("ANIO")));
            proyectoIOARR.setValorindicador(Format.toDouble(obj.get("VALORINDICADOR")));
            proyectoIOARR.setValorcontri(Format.toDouble(obj.get("VALORCONTRI")));
            proyectoIOARR.setAprobacionPMI(Format.toInteger(obj.get("APROBACPMI")));
            proyectoIOARR.setCodunimef(Format.toInteger(obj.get("CODUNIMEF")));
            proyectoIOARR.setV_totalInversionTipoIoarr(Format.toString(obj.get("V_TOTALINVERSION")));
            proyectoIOARR.setObjinterv(Format.toString(obj.get("OBJINTERV")));
            proyectoIOARR.setUitmayor75(Format.toString(obj.get("UITMAYOR75")));
            proyectoIOARR.setCierreinv(Format.toInteger(obj.get("CIERREINV")));
            proyectoIOARR.setNomforeva(Format.toString(obj.get("NOMFOREVA")));
            proyectoIOARR.setCodforeva(Format.toString(obj.get("CODFOREVA")));

        }
        return proyectoIOARR;
    }

    @Override
    public Integer update(ProyectoIOARR item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", item.getIdProIOARR())
                .addValue("I_IDRESPONUF", item.getidResponsableUF())
                .addValue("I_IDSECTORUF", item.getIdSectorUF())
                .addValue("I_IDNOMBREUF", item.getIdNombreUF())
                .addValue("I_IDENTIDAUF", item.getIdEntidadUF())
                .addValue("I_IDSECTOUFI", item.getIdSectorUFI())
                .addValue("I_IDENTIDUFI", item.getIdEntidadUFI())
                .addValue("I_IDNOMBRUEI", item.getIdNombreUEI())
                .addValue("I_IDRESPOUEI", item.getIdResponsableUEI())
                .addValue("I_IDSECTOUEP", item.getIdSectorUEP())
                .addValue("I_IDENTIDUEP", item.getIdEntidadUEP())
                .addValue("I_IDNOMBRUEP", item.getIdNombreUEP())
                .addValue("I_IDFUNCION", item.getIdFuncion())
                .addValue("I_IDDIVFUNCION", item.getIdDivFuncion())
                .addValue("I_IDGRUPOFUN", item.getIdGrupoFuncion())
                .addValue("I_IDSECTRESP", item.getIdSectorResponsable())
                .addValue("V_SERVPUBLIC", item.getServicioPulico())
                .addValue("I_IDBRECINDI", item.getIdBrechaIndicador())
                .addValue("V_UNIDPRODUC", item.getUnidadProductora())
                .addValue("V_CODUNIDPRO", item.getCodUnidadProductora())
                .addValue("V_IDDEPARTAM", item.getIdDepartamento())
                .addValue("V_IDPROVINCI", item.getIdProvincia())
                .addValue("V_IDDISTRITO", item.getIdDistrito())
                .addValue("V_CENTROPOBL", item.getCentroPoblado())
                .addValue("V_LONGITLATI", item.getLongitudLatitud())
                .addValue("V_RECURSOPERADOR", item.getFinanciaTotalParcial())
                .addValue("V_USUMODIFIC", item.getUsucreacio())//ojo en modificar
                .addValue("I_MODALIEJEC", item.getModalidadEjecucion())
                .addValue("I_FUENTFINAN", item.getFuenteFinanciamiento())
                .addValue("V_NOMBREPROY", item.getNombreInversion())
                .addValue("V_UNIDADMED", item.getUnidadmed())
                .addValue("V_ESPACIOGEO", item.getEspaciogeo())
                .addValue("V_ANIO", item.getAnio())
                .addValue("D_VALORINDICADOR", item.getValorindicador())
                .addValue("D_VALORCONTRI", item.getValorcontri())
                .addValue("V_OBJINTERV", item.getObjinterv());

        Map map = actualizarProyectoIOARR.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

    @Override
    public Integer updateUIT(ProyectoIOARR item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", item.getIdProIOARR())
                .addValue("I_UITMAYOR75", item.getUitmayor75());
        //  .addValue("V_USUARIO", item.getUsucreacio());

        Map map = actualizarUIT.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }

    @Override
    public String updateCierreInv(ProyectoIOARR item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", item.getIdProIOARR())
                .addValue("I_CIERREINV", item.getCierreinv());
        //  .addValue("V_USUARIO", item.getUsucreacio());

        Map map = actualizarCierreInv.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public void updatePmi(ProyectoIOARR item) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_APROBACPMI", item.getAprobacionPMI())
                .addValue("I_CODUNIMEF", item.getCodunimef())
                .addValue("I_IDPROIOARR", item.getIdProyectoIOARR())
                .addValue("V_USUARIO", item.getUsumodific());

        actualizarPMI.execute(in);

    }
    
    @Override
    public Integer updateNombreCodigo(ProyectoIOARR item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDPROIOARR", item.getIdProIOARR())
                .addValue("V_NOMFOREVA", item.getNomforeva())
                .addValue("V_CODFOREVA", item.getCodforeva());

        Map map = actualizarNombreCodigoIOARR.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return Integer.parseInt(oCodigo);
    }


}
