/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

/**
 *
 * @author jmezas
 */
public class Dashboard  extends Base implements Serializable{
    
    private static final long serialVersionUID = 1L;


    private Integer total;
    private Integer total_pip_ioarr;
    private String tipo;
    private Integer anio;
    private Integer estadoactu;
    private Integer procactual;
    private String costo;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getTotal_pip_ioarr() {
        return total_pip_ioarr;
    }

    public void setTotal_pip_ioarr(Integer total_pip_ioarr) {
        this.total_pip_ioarr = total_pip_ioarr;
    }

    public Integer getEstadoactu() {
        return estadoactu;
    }

    public void setEstadoactu(Integer estadoactu) {
        this.estadoactu = estadoactu;
    }

    public Integer getProcactual() {
        return procactual;
    }

    public void setProcactual(Integer procactual) {
        this.procactual = procactual;
    }

    /**
     * @return the costo
     */
    public String getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }

    
    
}
