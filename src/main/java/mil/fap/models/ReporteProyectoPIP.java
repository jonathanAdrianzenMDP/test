/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

/**
 *
 * @author jhosep meza
 */
public class ReporteProyectoPIP implements Serializable{
    
    private Integer  IDPROYEPIP;
    private String   NOMPROYECT;
    private String   DESCFUNCION;
    private String   DESCDIVFUNCION;
    private String   DESCGRUPOFUNC;
    private String   SECRESPONS;
    private String   SERVPUBLIC;
    private String   INDICBRECH;
    private String   UNIDADMED;
    private String   ESPACIOGEO;
    private String   ANIO;
    private Double   VALORINDI;
    private Double   VALORCONTRI;
    private String   TIPOLOGIA;
    private String   DESCSECTOR;
    private String   DESCENTIDAD;
    private String   NOMBREUF;
    private String   RESPONSABLEUF;
    private String   NOMBREUEI;
    private String   RESPONSABLEUEI;
    private String   NATINTERVE;
    private String   NOMUNIPROD;
    private String   DEPARTAMENTO;
    private String   PROVINCIA;
    private String   DISTRITO;
    private String   TIPOEJECU;
    private String   FINACIA;
    private Integer  TIPEJECPRO;
    private Integer  TIPFINANPR;
    private Integer  IDNOMBRUEI;
    private Integer  IDRESPOUEI;
    private String   DOCUTEC;
    private String   VALPREINV;
    private String   ENTIDUEP;
    private String   OBJINTERV;
    private String   CAPPRODUC;
    private String   v_totalMontoItem;

    public String getCAPPRODUC() {
        return CAPPRODUC;
    }

    public void setCAPPRODUC(String CAPPRODUC) {
        this.CAPPRODUC = CAPPRODUC;
    }
    
    public String getOBJINTERV() {
        return OBJINTERV;
    }

    public void setOBJINTERV(String OBJINTERV) {
        this.OBJINTERV = OBJINTERV;
    }
    
    public Integer getIDPROYEPIP() {
        return IDPROYEPIP;
    }

    public void setIDPROYEPIP(Integer IDPROYEPIP) {
        this.IDPROYEPIP = IDPROYEPIP;
    }

    public String getNOMPROYECT() {
        return NOMPROYECT;
    }

    public void setNOMPROYECT(String NOMPROYECT) {
        this.NOMPROYECT = NOMPROYECT;
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

    public String getSERVPUBLIC() {
        return SERVPUBLIC;
    }

    public void setSERVPUBLIC(String SERVPUBLIC) {
        this.SERVPUBLIC = SERVPUBLIC;
    }

    public String getINDICBRECH() {
        return INDICBRECH;
    }

    public void setINDICBRECH(String INDICBRECH) {
        this.INDICBRECH = INDICBRECH;
    }

    public String getUNIDADMED() {
        return UNIDADMED;
    }

    public void setUNIDADMED(String UNIDADMED) {
        this.UNIDADMED = UNIDADMED;
    }

    public String getESPACIOGEO() {
        return ESPACIOGEO;
    }

    public void setESPACIOGEO(String ESPACIOGEO) {
        this.ESPACIOGEO = ESPACIOGEO;
    }

    public String getANIO() {
        return ANIO;
    }

    public void setANIO(String ANIO) {
        this.ANIO = ANIO;
    }

    public Double getVALORINDI() {
        return VALORINDI;
    }

    public void setVALORINDI(Double VALORINDI) {
        this.VALORINDI = VALORINDI;
    }

    public Double getVALORCONTRI() {
        return VALORCONTRI;
    }

    public void setVALORCONTRI(Double VALORCONTRI) {
        this.VALORCONTRI = VALORCONTRI;
    }

    public String getTIPOLOGIA() {
        return TIPOLOGIA;
    }

    public void setTIPOLOGIA(String TIPOLOGIA) {
        this.TIPOLOGIA = TIPOLOGIA;
    }

    public String getDESCSECTOR() {
        return DESCSECTOR;
    }

    public void setDESCSECTOR(String DESCSECTOR) {
        this.DESCSECTOR = DESCSECTOR;
    }

    public String getDESCENTIDAD() {
        return DESCENTIDAD;
    }

    public void setDESCENTIDAD(String DESCENTIDAD) {
        this.DESCENTIDAD = DESCENTIDAD;
    }

    public String getNOMBREUF() {
        return NOMBREUF;
    }

    public void setNOMBREUF(String NOMBREUF) {
        this.NOMBREUF = NOMBREUF;
    }

    public String getRESPONSABLEUF() {
        return RESPONSABLEUF;
    }

    public void setRESPONSABLEUF(String RESPONSABLEUF) {
        this.RESPONSABLEUF = RESPONSABLEUF;
    }

    public String getNOMBREUEI() {
        return NOMBREUEI;
    }

    public void setNOMBREUEI(String NOMBREUEI) {
        this.NOMBREUEI = NOMBREUEI;
    }

    public String getRESPONSABLEUEI() {
        return RESPONSABLEUEI;
    }

    public void setRESPONSABLEUEI(String RESPONSABLEUEI) {
        this.RESPONSABLEUEI = RESPONSABLEUEI;
    }

    public String getNATINTERVE() {
        return NATINTERVE;
    }

    public void setNATINTERVE(String NATINTERVE) {
        this.NATINTERVE = NATINTERVE;
    }

    public String getNOMUNIPROD() {
        return NOMUNIPROD;
    }

    public void setNOMUNIPROD(String NOMUNIPROD) {
        this.NOMUNIPROD = NOMUNIPROD;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public String getPROVINCIA() {
        return PROVINCIA;
    }

    public void setPROVINCIA(String PROVINCIA) {
        this.PROVINCIA = PROVINCIA;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public String getTIPOEJECU() {
        return TIPOEJECU;
    }

    public void setTIPOEJECU(String TIPOEJECU) {
        this.TIPOEJECU = TIPOEJECU;
    }

    public String getFINACIA() {
        return FINACIA;
    }

    public void setFINACIA(String FINACIA) {
        this.FINACIA = FINACIA;
    }

    public String getSECRESPONS() {
        return SECRESPONS;
    }

    public void setSECRESPONS(String SECRESPONS) {
        this.SECRESPONS = SECRESPONS;
    }

    public Integer getTIPEJECPRO() {
        return TIPEJECPRO;
    }

    public void setTIPEJECPRO(Integer TIPEJECPRO) {
        this.TIPEJECPRO = TIPEJECPRO;
    }

    public Integer getTIPFINANPR() {
        return TIPFINANPR;
    }

    public void setTIPFINANPR(Integer TIPFINANPR) {
        this.TIPFINANPR = TIPFINANPR;
    }

    public Integer getIDNOMBRUEI() {
        return IDNOMBRUEI;
    }

    public void setIDNOMBRUEI(Integer IDNOMBRUEI) {
        this.IDNOMBRUEI = IDNOMBRUEI;
    }

    public Integer getIDRESPOUEI() {
        return IDRESPOUEI;
    }

    public void setIDRESPOUEI(Integer IDRESPOUEI) {
        this.IDRESPOUEI = IDRESPOUEI;
    }

    public String getDOCUTEC() {
        return DOCUTEC;
    }

    public void setDOCUTEC(String DOCUTEC) {
        this.DOCUTEC = DOCUTEC;
    }

    public String getENTIDUEP() {
        return ENTIDUEP;
    }

    public void setENTIDUEP(String ENTIDUEP) {
        this.ENTIDUEP = ENTIDUEP;
    }

    /**
     * @return the v_totalMontoItem
     */
    public String getV_totalMontoItem() {
        return v_totalMontoItem;
    }

    /**
     * @param v_totalMontoItem the v_totalMontoItem to set
     */
    public void setV_totalMontoItem(String v_totalMontoItem) {
        this.v_totalMontoItem = v_totalMontoItem;
    }

    /**
     * @return the VALPREINV
     */
    public String getVALPREINV() {
        return VALPREINV;
    }

    /**
     * @param VALPREINV the VALPREINV to set
     */
    public void setVALPREINV(String VALPREINV) {
        this.VALPREINV = VALPREINV;
    }

 

    
}
