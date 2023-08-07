/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class Funcion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;

    private Integer idfuncion;
    private String descfuncion;
    private boolean estado;

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(Integer idfuncion) {
        this.idfuncion = idfuncion;
    }

    public String getDescfuncion() {
        return descfuncion;
    }

    public void setDescfuncion(String descfuncion) {
        this.descfuncion = descfuncion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
