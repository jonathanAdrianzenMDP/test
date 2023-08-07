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
public class ComiteTrabajo extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pagination pageInfo;
    private Integer idintegrante;
    private String integrante;
    private String nrooficio;
    private Integer row_number;
    private Integer idproyepip;
    private Integer idproioarr;

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIdintegrante() {
        return idintegrante;
    }

    public void setIdintegrante(Integer idintegrante) {
        this.idintegrante = idintegrante;
    }

    public String getIntegrante() {
        return integrante;
    }

    public void setIntegrante(String integrante) {
        this.integrante = integrante;
    }

    public String getNrooficio() {
        return nrooficio;
    }

    public void setNrooficio(String nrooficio) {
        this.nrooficio = nrooficio;
    }

    public Integer getRow_number() {
        return row_number;
    }

    public void setRow_number(Integer row_number) {
        this.row_number = row_number;
    }

    public Integer getIdproyepip() {
        return idproyepip;
    }

    public void setIdproyepip(Integer idproyepip) {
        this.idproyepip = idproyepip;
    }

    public Integer getIdproioarr() {
        return idproioarr;
    }

    public void setIdproioarr(Integer idproioarr) {
        this.idproioarr = idproioarr;
    }
    
 
}
