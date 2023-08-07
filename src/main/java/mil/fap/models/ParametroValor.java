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

public class ParametroValor implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;

    private Integer idparamval;
    private Integer idparame;
    private String valor;
    private String nomParam;
    private boolean estado;

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIdparamval() {
        return idparamval;
    }

    public void setIdparamval(Integer idparamval) {
        this.idparamval = idparamval;
    }

    public Integer getIdparame() {
        return idparame;
    }

    public void setIdparame(Integer idparame) {
        this.idparame = idparame;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the nomParam
     */
    public String getNomParam() {
        return nomParam;
    }

    /**
     * @param nomParam the nomParam to set
     */
    public void setNomParam(String nomParam) {
        this.nomParam = nomParam;
    }


}
