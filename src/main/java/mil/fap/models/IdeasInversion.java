/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class IdeasInversion extends Base implements Serializable {

    private static final long serialVersionUID = 1L;
    public Pagination pageInfo;
    private Integer id;
     private String idpip_ioarr;
    private String nombreproy;
    private String tipo;
    private String sigla;
    private int cod_proceso_actual;
    private String proceso_actual;
    private int cod_estado_registro;
    private String estado_registro;
    private String fechaenvio;
    private String fechaaprobacion;
    private int aprobacionPMI;
    private String codunimef;

   

  private String anio;


    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getIdpip_ioarr() {
        return idpip_ioarr;
    }

    public void setIdpip_ioarr(String idpip_ioarr) {
        this.idpip_ioarr = idpip_ioarr;
    }

    public String getNombreproy() {
        return nombreproy;
    }

    public void setNombreproy(String nombreproy) {
        this.nombreproy = nombreproy;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEstado_registro() {
        return estado_registro;
    }

    public void setEstado_registro(String estado_registro) {
        this.estado_registro = estado_registro;
    }

    public String getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(String fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public String getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(String fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
     /**
     * @return the proceso_actual
     */
    public String getProceso_actual() {
        return proceso_actual;
    }

    /**
     * @param proceso_actual the proceso_actual to set
     */
    public void setProceso_actual(String proceso_actual) {
        this.proceso_actual = proceso_actual;
    }

    /**
     * @return the cod_estado_registro
     */
    public int getCod_estado_registro() {
        return cod_estado_registro;
    }

    /**
     * @param cod_estado_registro the cod_estado_registro to set
     */
    public void setCod_estado_registro(int cod_estado_registro) {
        this.cod_estado_registro = cod_estado_registro;
    }

    /**
     * @return the aprobacionPMI
     */
    public int getAprobacionPMI() {
        return aprobacionPMI;
    }

    /**
     * @param aprobacionPMI the aprobacionPMI to set
     */
    public void setAprobacionPMI(int aprobacionPMI) {
        this.aprobacionPMI = aprobacionPMI;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the cod_proceso_actual
     */
    public int getCod_proceso_actual() {
        return cod_proceso_actual;
    }

    /**
     * @param cod_proceso_actual the cod_proceso_actual to set
     */
    public void setCod_proceso_actual(int cod_proceso_actual) {
        this.cod_proceso_actual = cod_proceso_actual;
    }

    /**
     * @return the codunimef
     */
    public String getCodunimef() {
        return codunimef;
    }

    /**
     * @param codunimef the codunimef to set
     */
    public void setCodunimef(String codunimef) {
        this.codunimef = codunimef;
    }

  
    
    


} 