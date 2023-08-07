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
public class EjecucionFisica extends Base implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Pagination pageInfo;
    private Integer idfinanci;
    private Double recordin;
    private Double recdirrec;
    private Double recroor;
    private Double recdontra;
    private Double recdeter;
    private Integer idproyepip;
    private Integer idproioarr;

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIdfinanci() {
        return idfinanci;
    }

    public void setIdfinanci(Integer idfinanci) {
        this.idfinanci = idfinanci;
    }

    public Double getRecordin() {
        return recordin;
    }

    public void setRecordin(Double recordin) {
        this.recordin = recordin;
    }

    public Double getRecdirrec() {
        return recdirrec;
    }

    public void setRecdirrec(Double recdirrec) {
        this.recdirrec = recdirrec;
    }

    public Double getRecroor() {
        return recroor;
    }

    public void setRecroor(Double recroor) {
        this.recroor = recroor;
    }

    public Double getRecdontra() {
        return recdontra;
    }

    public void setRecdontra(Double recdontra) {
        this.recdontra = recdontra;
    }

    public Double getRecdeter() {
        return recdeter;
    }

    public void setRecdeter(Double recdeter) {
        this.recdeter = recdeter;
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
