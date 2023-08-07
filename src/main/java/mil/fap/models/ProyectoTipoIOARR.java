/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class ProyectoTipoIOARR extends Base implements Serializable  {
    
    private Integer idProyTipoIOARR;
    private Integer idProyIOARR;
    private String tipoIOARR;
    private Integer idTipoIOARR;
    private Double montoInversion;
    private String v_montoInversion;
    private Integer metaFisica;
    private String unidadMedida;
    

    public String getV_montoInversion() {
        return v_montoInversion;
    }

    public void setV_montoInversion(String v_montoInversion) {
        this.v_montoInversion = v_montoInversion;
    }

    
    public Integer getIdProyTipoIOARR() {
        return idProyTipoIOARR;
    }

    /**
     * @param idProyTipoIOARR the idProyTipoIOARR to set
     */
    public void setIdProyTipoIOARR(Integer idProyTipoIOARR) {
        this.idProyTipoIOARR = idProyTipoIOARR;
    }

    /**
     * @return the idTipoIOARR
     */
    public Integer getIdTipoIOARR() {
        return idTipoIOARR;
    }

    /**
     * @param idTipoIOARR the idTipoIOARR to set
     */
    public void setIdTipoIOARR(Integer idTipoIOARR) {
        this.idTipoIOARR = idTipoIOARR;
    }

    /**
     * @return the montoInversion
     */
    public Double getMontoInversion() {
        return montoInversion;
    }

    /**
     * @param montoInversion the montoInversion to set
     */
    public void setMontoInversion(Double montoInversion) {
        this.montoInversion = montoInversion;
    }

    /**
     * @return the metaFisica
     */
    public Integer getMetaFisica() {
        return metaFisica;
    }

    /**
     * @param metaFisica the metaFisica to set
     */
    public void setMetaFisica(Integer metaFisica) {
        this.metaFisica = metaFisica;
    }

    /**
     * @return the unidadMedida
     */
    public String getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * @param unidadMedida the unidadMedida to set
     */
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * @return the idProyIOARR
     */
    public Integer getIdProyIOARR() {
        return idProyIOARR;
    }

    /**
     * @param idProyIOARR the idProyIOARR to set
     */
    public void setIdProyIOARR(Integer idProyIOARR) {
        this.idProyIOARR = idProyIOARR;
    }

    /**
     * @return the tipoIOARR
     */
    public String getTipoIOARR() {
        return tipoIOARR;
    }

    /**
     * @param tipoIOARR the tipoIOARR to set
     */
    public void setTipoIOARR(String tipoIOARR) {
        this.tipoIOARR = tipoIOARR;
    }

}