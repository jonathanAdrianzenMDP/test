/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

/**
 *
 * @author jadrianzen
 */
public class UnidadEjecutoraInver extends Base {
    private Integer identificador;
    private String descunidad;
    private String responsable;
    private String codunieje;
    private String nsa;

    public String getNsa() {
        return nsa;
    }

    public void setNsa(String nsa) {
        this.nsa = nsa;
    }
    /**
     * @return the identificador
     */
    public Integer getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the descunidad
     */
    public String getDescunidad() {
        return descunidad;
    }

    /**
     * @param descunidad the descunidad to set
     */
    public void setDescunidad(String descunidad) {
        this.descunidad = descunidad;
    }

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCodunieje() {
        return codunieje;
    }

    public void setCodunieje(String codunieje) {
        this.codunieje = codunieje;
    }
        
}
