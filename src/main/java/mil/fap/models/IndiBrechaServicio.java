/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class IndiBrechaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;
    private Integer idbrecindi;
    private String indicbrech;
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

    public String getIndicbrech() {
        return indicbrech;
    }

    public void setIndicbrech(String indicbrech) {
        this.indicbrech = indicbrech;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
