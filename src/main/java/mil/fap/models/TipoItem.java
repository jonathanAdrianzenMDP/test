/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

/**
 *
 * @author jmeza
 */
public class TipoItem extends Base implements Serializable {

    private Integer idtipoitem;
    private Integer idproyepip;
    private String iditem;
    private String tipoitem;
    private Double costoref;
    private String v_costoref;

    public String getV_costoref() {
        return v_costoref;
    }

    public void setV_costoref(String v_costoref) {
        this.v_costoref = v_costoref;
    }
   
    public Integer getIdtipoitem() {
        return idtipoitem;
    }

    public void setIdtipoitem(Integer idtipoitem) {
        this.idtipoitem = idtipoitem;
    }

    public Integer getIdproyepip() {
        return idproyepip;
    }

    public void setIdproyepip(Integer idproyepip) {
        this.idproyepip = idproyepip;
    }

    public String getIditem() {
        return iditem;
    }

    public void setIditem(String iditem) {
        this.iditem = iditem;
    }

    public Double getCostoref() {
        return costoref;
    }

    public void setCostoref(Double costoref) {
        this.costoref = costoref;
    }

    public String getTipoitem() {
        return tipoitem;
    }

    public void setTipoitem(String tipoitem) {
        this.tipoitem = tipoitem;
    }


    
    
}
