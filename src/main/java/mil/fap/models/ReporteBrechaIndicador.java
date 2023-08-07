
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class ReporteBrechaIndicador implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String DESCSECTOR  ;
    private String DESCFUNCION;
    private String DESCDIVFUNCION;
    private String  DESCGRUPOFUNC;
    private String TIPOLOGIA;
    private String SERVTIPOLO;
    private String INDICBRECH;
    private Integer IDBRECINDI;
    private String VALOR;
    private String ANIO;
    private String FECCREACIO;
    private String UNIMED;
    private String CAPPROD;

    public String getDESCSECTOR() {
        return DESCSECTOR;
    }

    public void setDESCSECTOR(String DESCSECTOR) {
        this.DESCSECTOR = DESCSECTOR;
    }

    public String getDESCFUNCION() {
        return DESCFUNCION;
    }

    public void setDESCFUNCION(String DESCFUNCION) {
        this.DESCFUNCION = DESCFUNCION;
    }

    public String getDESCDIVFUNCION() {
        return DESCDIVFUNCION;
    }

    public void setDESCDIVFUNCION(String DESCDIVFUNCION) {
        this.DESCDIVFUNCION = DESCDIVFUNCION;
    }

    public String getDESCGRUPOFUNC() {
        return DESCGRUPOFUNC;
    }

    public void setDESCGRUPOFUNC(String DESCGRUPOFUNC) {
        this.DESCGRUPOFUNC = DESCGRUPOFUNC;
    }

    public String getTIPOLOGIA() {
        return TIPOLOGIA;
    }

    public void setTIPOLOGIA(String TIPOLOGIA) {
        this.TIPOLOGIA = TIPOLOGIA;
    }

    public String getSERVTIPOLO() {
        return SERVTIPOLO;
    }

    public void setSERVTIPOLO(String SERVTIPOLO) {
        this.SERVTIPOLO = SERVTIPOLO;
    }

    public String getINDICBRECH() {
        return INDICBRECH;
    }

    public void setINDICBRECH(String INDICBRECH) {
        this.INDICBRECH = INDICBRECH;
    }

  
    public String getVALOR() {
        return VALOR;
    }

    public void setVALOR(String VALOR) {
        this.VALOR = VALOR;
    }

    public String getANIO() {
        return ANIO;
    }

    public void setANIO(String ANIO) {
        this.ANIO = ANIO;
    }

    public String getFECCREACIO() {
        return FECCREACIO;
    }

    public void setFECCREACIO(String FECCREACIO) {
        this.FECCREACIO = FECCREACIO;
    }

    public Integer getIDBRECINDI() {
        return IDBRECINDI;
    }

    public void setIDBRECINDI(Integer IDBRECINDI) {
        this.IDBRECINDI = IDBRECINDI;
    }

    public String getUNIMED() {
        return UNIMED;
    }

    public void setUNIMED(String UNIMED) {
        this.UNIMED = UNIMED;
    }

    public String getCAPPROD() {
        return CAPPROD;
    }

    public void setCAPPROD(String CAPPROD) {
        this.CAPPROD = CAPPROD;
    }


  

   
}