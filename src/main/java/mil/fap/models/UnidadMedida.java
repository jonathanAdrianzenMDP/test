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
public class UnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;
    private Integer idbrecindi;
    private String unimed;
    private String tipologia;
    private String capprod;
    private boolean estado;                                                                                                                                                                                                                                                                                    

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIdbrecindi() {
        return idbrecindi;
    }

    public void setIdbrecindi(Integer idbrecindi) {
        this.idbrecindi = idbrecindi;
    }

    public String getUnimed() {
        return unimed;
    }

    public void setUnimed(String unimed) {
        this.unimed = unimed;
    }  

    public boolean isEstado() {
        return estado;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getCapprod() {
        return capprod;
    }

    public void setCapprod(String capprod) {
        this.capprod = capprod;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

}
