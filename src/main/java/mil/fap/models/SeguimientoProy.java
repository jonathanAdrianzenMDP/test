/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class SeguimientoProy extends Base implements Serializable{

    private Integer idseguimie;
    private Integer idproyepip;
    private Integer idproioarr;
    private Integer codproceso;
    private Integer estadoproc;
    private String styleProc;
    private String nombreProc;
    private String nombreEstado;
    private Double AVANCE_IOARR;
    private Double AVANCE_PIP;

    public Integer getIdseguimie() {
        return idseguimie;
    }

    public void setIdseguimie(Integer idseguimie) {
        this.idseguimie = idseguimie;
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

    public Integer getCodproceso() {
        return codproceso;
    }

    public void setCodproceso(Integer codproceso) {
        this.codproceso = codproceso;
    }

    public Integer getEstadoproc() {
        return estadoproc;
    }

    public void setEstadoproc(Integer estadoproc) {
        this.estadoproc = estadoproc;
    }

    /**
     * @return the styleProc
     */
    public String getStyleProc() {
        return styleProc;
    }

    /**
     * @param styleProc the styleProc to set
     */
    public void setStyleProc(String styleProc) {
        this.styleProc = styleProc;
    }

    /**
     * @return the nombreProc
     */
    public String getNombreProc() {
        return nombreProc;
    }

    /**
     * @param nombreProc the nombreProc to set
     */
    public void setNombreProc(String nombreProc) {
        this.nombreProc = nombreProc;
    }

    /**
     * @return the nombreEstado
     */
    public String getNombreEstado() {
        return nombreEstado;
    }

    /**
     * @param nombreEstado the nombreEstado to set
     */
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    /**
     * @return the AVANCE_PIP
     */
    public Double getAVANCE_PIP() {
        return AVANCE_PIP;
    }

    /**
     * @param AVANCE_PIP the AVANCE_PIP to set
     */
    public void setAVANCE_PIP(Double AVANCE_PIP) {
        this.AVANCE_PIP = AVANCE_PIP;
    }

    /**
     * @return the AVANCE_IOARR
     */
    public Double getAVANCE_IOARR() {
        return AVANCE_IOARR;
    }

    /**
     * @param AVANCE_IOARR the AVANCE_IOARR to set
     */
    public void setAVANCE_IOARR(Double AVANCE_IOARR) {
        this.AVANCE_IOARR = AVANCE_IOARR;
    }
 
    
    
}
