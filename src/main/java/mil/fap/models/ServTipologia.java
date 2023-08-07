/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;
import java.util.List;

public class ServTipologia implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;
    private Integer idgrupofun;
    private String servtipolo;
    private boolean estado;

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIdgrupofun() {
        return idgrupofun;
    }

    public void setIdgrupofun(Integer idgrupofun) {
        this.idgrupofun = idgrupofun;
    }

    public String getServtipolo() {
        return servtipolo;
    }

    public void setServtipolo(String servtipolo) {
        this.servtipolo = servtipolo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
