/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

/**
 *
 * @author nlarico
 */
public class Inversion extends Base implements Serializable{
    private Integer idinversion;
    private Integer idtipoinver;
    private Integer idproyepip;
    private String  inversion;
    private Double  costoref;
    private String  v_costoref;

    public String getV_costoref() {
        return v_costoref;
    }

    public void setV_costoref(String v_costoref) {
        this.v_costoref = v_costoref;
    }

    public Integer getIdinversion() {
        return idinversion;
    }

    public void setIdinversion(Integer idinversion) {
        this.idinversion = idinversion;
    }

    public Integer getIdtipoinver() {
        return idtipoinver;
    }

    public void setIdtipoinver(Integer idtipoinver) {
        this.idtipoinver = idtipoinver;
    }

    public Integer getIdproyepip() {
        return idproyepip;
    }

    public void setIdproyepip(Integer idproyepip) {
        this.idproyepip = idproyepip;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public Double getCostoref() {
        return costoref;
    }

    public void setCostoref(Double costoref) {
        this.costoref = costoref;
    }
            
    
}
