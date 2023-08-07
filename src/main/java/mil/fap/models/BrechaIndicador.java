/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.io.Serializable;

public class BrechaIndicador extends Base implements Serializable {

    private static final long serialVersionUID = 1L;
    public Pagination pageInfo;
    
    private Funcion funcion;
    
    private ParametroValor parametroValor;
  
    private Grupofunc grupofunc;
    
    private DivisionFuncion divisionFuncion;

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public ParametroValor getParametroValor() {
        return parametroValor;
    }

    public void setParametroValor(ParametroValor parametroValor) {
        this.parametroValor = parametroValor;
    }

    public Grupofunc getGrupofunc() {
        return grupofunc;
    }

    public void setGrupofunc(Grupofunc grupofunc) {
        this.grupofunc = grupofunc;
    }

    public DivisionFuncion getDivisionFuncion() {
        return divisionFuncion;
    }

    public void setDivisionFuncion(DivisionFuncion divisionFuncion) {
        this.divisionFuncion = divisionFuncion;
    }

    private Integer idbrecindi;
    private Integer idsector;
    private String valor;
    private Integer idgrupofun;
    private String descgrupofunc;
    private Integer iddivfunci;
    private String descdivfuncion;
    private Integer idfuncion;
    private String descfuncion;
    private String tipologia;
    private String servtipolo;
    private String indicbrech;
    private String anio;
    private String descsector;
    private String unimed;
    private String capprod;

    public String getDescsector() {
        return descsector;
    }

    public void setDescsector(String descsector) {
        this.descsector = descsector;
    }

    public Integer getIdbrecindi() {
        return idbrecindi;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setIdbrecindi(Integer idbrecindi) {
        this.idbrecindi = idbrecindi;
    }

    public Integer getIdsector() {
        return idsector;
    }

    public void setIdsector(Integer idsector) {
        this.idsector = idsector;
    }

    public Integer getIdgrupofun() {
        return idgrupofun;
    }

    public void setIdgrupofun(Integer idgrupofun) {
        this.idgrupofun = idgrupofun;
    }

    public Integer getIddivfunci() {
        return iddivfunci;
    }

    public void setIddivfunci(Integer iddivfunci) {
        this.iddivfunci = iddivfunci;
    }

    public Integer getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(Integer idfuncion) {
        this.idfuncion = idfuncion;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getServtipolo() {
        return servtipolo;
    }

    public void setServtipolo(String servtipolo) {
        this.servtipolo = servtipolo;
    }

    public String getIndicbrech() {
        return indicbrech;
    }

    public void setIndicbrech(String indicbrech) {
        this.indicbrech = indicbrech;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDescgrupofunc() {
        return descgrupofunc;
    }

    public void setDescgrupofunc(String descgrupofunc) {
        this.descgrupofunc = descgrupofunc;
    }

    public String getDescdivfuncion() {
        return descdivfuncion;
    }

    public void setDescdivfuncion(String descdivfuncion) {
        this.descdivfuncion = descdivfuncion;
    }

    public String getDescfuncion() {
        return descfuncion;
    }

    public void setDescfuncion(String descfuncion) {
        this.descfuncion = descfuncion;
    }

    /**
     * @return the pageInfo
     */
    public Pagination getPageInfo() {
        return pageInfo;
    }

    /**
     * @param pageInfo the pageInfo to set
     */
    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getUnimed() {
        return unimed;
    }

    public void setUnimed(String unimed) {
        this.unimed = unimed;
    }

    public String getCapprod() {
        return capprod;
    }

    public void setCapprod(String capprod) {
        this.capprod = capprod;
    }

    

}
