/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class ProyectoIOARR extends Base implements Serializable {

    private Integer idProIOARR;
    private String v_idProIOARR;
    private Integer idProyectoIOARR;
    private Integer idResponsableUF;
    private Integer idSectorUF;
    private Integer idNombreUF;
    private Integer idEntidadUF;
    private Integer idSectorUFI;
    private Integer idEntidadUFI;
    private Integer idNombreUEI;
    private Integer idResponsableUEI;
    private Integer idSectorUEP;
    private Integer idEntidadUEP;
    private Integer idNombreUEP;
    private Integer idFuncion;
    private Integer idDivFuncion;
    private Integer idGrupoFuncion;
    private Integer idSectorResponsable;
    private String servicioPulico;
    private Integer idBrechaIndicador;
    private String unidadProductora;
    private String codUnidadProductora;
    private String idDepartamento;
    private String idProvincia;
    private String idDistrito;
    private String centroPoblado;
    private String longitudLatitud;
    private String financiaTotalParcial;
    private Integer idEstadoActual;
    private String desc_estadoactu;
    private Integer idProcesoActual;
    private Integer aprobacionPMI;
    private Integer modalidadEjecucion;
    private Integer fuenteFinanciamiento;
    private String nombreInversion;
    private String unidadmed;
    private String espaciogeo;
    private String anio;
    private Double valorindicador;
    private Double valorcontri;
    private Integer codunimef;
    private String v_totalInversionTipoIoarr;
    private String objinterv;
    private String uitmayor75;
    private Integer cierreinv;
    private String nomforeva;
    private String codforeva;

    public String getNomforeva() {
        return nomforeva;
    }

    public void setNomforeva(String nomforeva) {
        this.nomforeva = nomforeva;
    }

    public String getCodforeva() {
        return codforeva;
    }

    public void setCodforeva(String codforeva) {
        this.codforeva = codforeva;
    }

    public String getUitmayor75() {
        return uitmayor75;
    }

    public void setUitmayor75(String uitmayor75) {
        this.uitmayor75 = uitmayor75;
    }

    public String getObjinterv() {
        return objinterv;
    }

    public void setObjinterv(String objinterv) {
        this.objinterv = objinterv;
    }

    public Integer getCodunimef() {
        return codunimef;
    }

    public void setCodunimef(Integer codunimef) {
        this.codunimef = codunimef;
    }

    public Integer getIdProIOARR() {
        return idProIOARR;
    }

    public void setIdProIOARR(Integer idProIOARR) {
        this.idProIOARR = idProIOARR;
    }

    /**
     * @return the idProyectoIOARR
     */
    public Integer getIdProyectoIOARR() {
        return idProyectoIOARR;
    }

    /**
     * @param idProyectoIOARR the idProyectoIOARR to set
     */
    public void setIdProyectoIOARR(Integer idProyectoIOARR) {
        this.idProyectoIOARR = idProyectoIOARR;
    }

    /**
     * @return the responsableUF
     */
    public Integer getidResponsableUF() {
        return idResponsableUF;
    }

    /**
     * @param responsableUF the responsableUF to set
     */
    public void setResponsableUF(Integer idResponsableUF) {
        this.idResponsableUF = idResponsableUF;
    }

    /**
     * @return the idSectorUF
     */
    public Integer getIdSectorUF() {
        return idSectorUF;
    }

    /**
     * @param idSectorUF the idSectorUF to set
     */
    public void setIdSectorUF(Integer idSectorUF) {
        this.idSectorUF = idSectorUF;
    }

    /**
     * @return the idNombreUF
     */
    public Integer getIdNombreUF() {
        return idNombreUF;
    }

    /**
     * @param idNombreUF the idNombreUF to set
     */
    public void setIdNombreUF(Integer idNombreUF) {
        this.idNombreUF = idNombreUF;
    }

    /**
     * @return the idEntidadUF
     */
    public Integer getIdEntidadUF() {
        return idEntidadUF;
    }

    /**
     * @param idEntidadUF the idEntidadUF to set
     */
    public void setIdEntidadUF(Integer idEntidadUF) {
        this.idEntidadUF = idEntidadUF;
    }

    /**
     * @return the idSectorUFI
     */
    public Integer getIdSectorUFI() {
        return idSectorUFI;
    }

    /**
     * @param idSectorUFI the idSectorUFI to set
     */
    public void setIdSectorUFI(Integer idSectorUFI) {
        this.idSectorUFI = idSectorUFI;
    }

    /**
     * @return the idEntidadUFI
     */
    public Integer getIdEntidadUFI() {
        return idEntidadUFI;
    }

    /**
     * @param idEntidadUFI the idEntidadUFI to set
     */
    public void setIdEntidadUFI(Integer idEntidadUFI) {
        this.idEntidadUFI = idEntidadUFI;
    }

    /**
     * @return the idNombreUEI
     */
    public Integer getIdNombreUEI() {
        return idNombreUEI;
    }

    /**
     * @param idNombreUEI the idNombreUEI to set
     */
    public void setIdNombreUEI(Integer idNombreUEI) {
        this.idNombreUEI = idNombreUEI;
    }

    /**
     * @return the responsableUEI
     */
    public Integer getIdResponsableUEI() {
        return idResponsableUEI;
    }

    /**
     * @param responsableUEI the responsableUEI to set
     */
    public void setIdResponsableUEI(Integer idResponsableUEI) {
        this.idResponsableUEI = idResponsableUEI;
    }

    /**
     * @return the idSectorUEP
     */
    public Integer getIdSectorUEP() {
        return idSectorUEP;
    }

    /**
     * @param idSectorUEP the idSectorUEP to set
     */
    public void setIdSectorUEP(Integer idSectorUEP) {
        this.idSectorUEP = idSectorUEP;
    }

    /**
     * @return the idEntidadUEP
     */
    public Integer getIdEntidadUEP() {
        return idEntidadUEP;
    }

    /**
     * @param idEntidadUEP the idEntidadUEP to set
     */
    public void setIdEntidadUEP(Integer idEntidadUEP) {
        this.idEntidadUEP = idEntidadUEP;
    }

    /**
     * @return the idNombreUEP
     */
    public Integer getIdNombreUEP() {
        return idNombreUEP;
    }

    /**
     * @param idNombreUEP the idNombreUEP to set
     */
    public void setIdNombreUEP(Integer idNombreUEP) {
        this.idNombreUEP = idNombreUEP;
    }

    /**
     * @return the idFuncion
     */
    public Integer getIdFuncion() {
        return idFuncion;
    }

    /**
     * @param idFuncion the idFuncion to set
     */
    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    /**
     * @return the idDivFuncion
     */
    public Integer getIdDivFuncion() {
        return idDivFuncion;
    }

    /**
     * @param idDivFuncion the idDivFuncion to set
     */
    public void setIdDivFuncion(Integer idDivFuncion) {
        this.idDivFuncion = idDivFuncion;
    }

    /**
     * @return the idGrupoFuncion
     */
    public Integer getIdGrupoFuncion() {
        return idGrupoFuncion;
    }

    /**
     * @param idGrupoFuncion the idGrupoFuncion to set
     */
    public void setIdGrupoFuncion(Integer idGrupoFuncion) {
        this.idGrupoFuncion = idGrupoFuncion;
    }

    /**
     * @return the idSectorResponsable
     */
    public Integer getIdSectorResponsable() {
        return idSectorResponsable;
    }

    /**
     * @param idSectorResponsable the idSectorResponsable to set
     */
    public void setIdSectorResponsable(Integer idSectorResponsable) {
        this.idSectorResponsable = idSectorResponsable;
    }

    /**
     * @return the servicioPulico
     */
    public String getServicioPulico() {
        return servicioPulico;
    }

    /**
     * @param servicioPulico the servicioPulico to set
     */
    public void setServicioPulico(String servicioPulico) {
        this.servicioPulico = servicioPulico;
    }

    /**
     * @return the idBrechaIndicador
     */
    public Integer getIdBrechaIndicador() {
        return idBrechaIndicador;
    }

    /**
     * @param idBrechaIndicador the idBrechaIndicador to set
     */
    public void setIdBrechaIndicador(Integer idBrechaIndicador) {
        this.idBrechaIndicador = idBrechaIndicador;
    }

    /**
     * @return the unidadProductora
     */
    public String getUnidadProductora() {
        return unidadProductora;
    }

    /**
     * @param unidadProductora the unidadProductora to set
     */
    public void setUnidadProductora(String unidadProductora) {
        this.unidadProductora = unidadProductora;
    }

    /**
     * @return the codUnidadProductora
     */
    public String getCodUnidadProductora() {
        return codUnidadProductora;
    }

    /**
     * @param codUnidadProductora the codUnidadProductora to set
     */
    public void setCodUnidadProductora(String codUnidadProductora) {
        this.codUnidadProductora = codUnidadProductora;
    }

    /**
     * @return the centroPoblado
     */
    public String getCentroPoblado() {
        return centroPoblado;
    }

    /**
     * @param centroPoblado the centroPoblado to set
     */
    public void setCentroPoblado(String centroPoblado) {
        this.centroPoblado = centroPoblado;
    }

    /**
     * @return the longitudLatitud
     */
    public String getLongitudLatitud() {
        return longitudLatitud;
    }

    /**
     * @param longitudLatitud the longitudLatitud to set
     */
    public void setLongitudLatitud(String longitudLatitud) {
        this.longitudLatitud = longitudLatitud;
    }

    /**
     * @return the financiaTotalParcial
     */
    public String getFinanciaTotalParcial() {
        return financiaTotalParcial;
    }

    /**
     * @param financiaTotalParcial the financiaTotalParcial to set
     */
    public void setFinanciaTotalParcial(String financiaTotalParcial) {
        this.financiaTotalParcial = financiaTotalParcial;
    }

    /**
     * @return the idEstadoActual
     */
    public Integer getIdEstadoActual() {
        return idEstadoActual;
    }

    /**
     * @param idEstadoActual the idEstadoActual to set
     */
    public void setIdEstadoActual(Integer idEstadoActual) {
        this.idEstadoActual = idEstadoActual;
    }

    /**
     * @return the idProcesoActual
     */
    public Integer getIdProcesoActual() {
        return idProcesoActual;
    }

    /**
     * @param idProcesoActual the idProcesoActual to set
     */
    public void setIdProcesoActual(Integer idProcesoActual) {
        this.idProcesoActual = idProcesoActual;
    }

    /**
     * @return the aprobacionPMI
     */
    public Integer getAprobacionPMI() {
        return aprobacionPMI;
    }

    /**
     * @param aprobacionPMI the aprobacionPMI to set
     */
    public void setAprobacionPMI(Integer aprobacionPMI) {
        this.aprobacionPMI = aprobacionPMI;
    }

    /**
     * @return the idDepartamento
     */
    public String getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the idProvincia
     */
    public String getIdProvincia() {
        return idProvincia;
    }

    /**
     * @param idProvincia the idProvincia to set
     */
    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    /**
     * @return the idDistrito
     */
    public String getIdDistrito() {
        return idDistrito;
    }

    /**
     * @param idDistrito the idDistrito to set
     */
    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    /**
     * @return the modalidadEjecucion
     */
    public Integer getModalidadEjecucion() {
        return modalidadEjecucion;
    }

    /**
     * @param modalidadEjecucion the modalidadEjecucion to set
     */
    public void setModalidadEjecucion(Integer modalidadEjecucion) {
        this.modalidadEjecucion = modalidadEjecucion;
    }

    /**
     * @return the fuenteFinanciamiento
     */
    public Integer getFuenteFinanciamiento() {
        return fuenteFinanciamiento;
    }

    /**
     * @param fuenteFinanciamiento the fuenteFinanciamiento to set
     */
    public void setFuenteFinanciamiento(Integer fuenteFinanciamiento) {
        this.fuenteFinanciamiento = fuenteFinanciamiento;
    }

    /**
     * @return the nombreInversion
     */
    public String getNombreInversion() {
        return nombreInversion;
    }

    /**
     * @param nombreInversion the nombreInversion to set
     */
    public void setNombreInversion(String nombreInversion) {
        this.nombreInversion = nombreInversion;
    }

    /**
     * @return the v_idProIOARR
     */
    public String getV_idProIOARR() {
        return v_idProIOARR;
    }

    /**
     * @param v_idProIOARR the v_idProIOARR to set
     */
    public void setV_idProIOARR(String v_idProIOARR) {
        this.v_idProIOARR = v_idProIOARR;
    }

    /**
     * @return the desc_estadoactu
     */
    public String getDesc_estadoactu() {
        return desc_estadoactu;
    }

    /**
     * @param desc_estadoactu the desc_estadoactu to set
     */
    public void setDesc_estadoactu(String desc_estadoactu) {
        this.desc_estadoactu = desc_estadoactu;
    }

    public String getUnidadmed() {
        return unidadmed;
    }

    public void setUnidadmed(String unidadmed) {
        this.unidadmed = unidadmed;
    }

    public String getEspaciogeo() {
        return espaciogeo;
    }

    public void setEspaciogeo(String espaciogeo) {
        this.espaciogeo = espaciogeo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Double getValorindicador() {
        return valorindicador;
    }

    public void setValorindicador(Double valorindicador) {
        this.valorindicador = valorindicador;
    }

    public Double getValorcontri() {
        return valorcontri;
    }

    public void setValorcontri(Double valorcontri) {
        this.valorcontri = valorcontri;
    }

    /**
     * @return the v_totalInversionTipoIoarr
     */
    public String getV_totalInversionTipoIoarr() {
        return v_totalInversionTipoIoarr;
    }

    /**
     * @param v_totalInversionTipoIoarr the v_totalInversionTipoIoarr to set
     */
    public void setV_totalInversionTipoIoarr(String v_totalInversionTipoIoarr) {
        this.v_totalInversionTipoIoarr = v_totalInversionTipoIoarr;
    }

    public Integer getCierreinv() {
        return cierreinv;
    }

    public void setCierreinv(Integer cierreinv) {
        this.cierreinv = cierreinv;
    }

}
