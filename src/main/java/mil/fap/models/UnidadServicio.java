/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

/**
 *
 * @author cristina
 */


import java.io.Serializable;

public class UnidadServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;

    private String codigo;
    private String sigla;
    private String idorganigrama;

    public String getIdorganigrama() {
        return idorganigrama;
    }

    public void setIdorganigrama(String idorganigrama) {
        this.idorganigrama = idorganigrama;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    
    
}
