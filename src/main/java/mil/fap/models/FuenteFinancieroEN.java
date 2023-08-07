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
public class FuenteFinancieroEN {
    private int anio;
    private String tipo;
    private Double recurso_ordinario;
    private Double recurso_direc_recaudado;
    private Double recurso_operacion;
    private Double donacion_transferencia;
    private Double recurso_determinado;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the recurso_ordinario
     */
    public Double getRecurso_ordinario() {
        return recurso_ordinario;
    }

    /**
     * @param recurso_ordinario the recurso_ordinario to set
     */
    public void setRecurso_ordinario(Double recurso_ordinario) {
        this.recurso_ordinario = recurso_ordinario;
    }

    /**
     * @return the recurso_direc_recaudado
     */
    public Double getRecurso_direc_recaudado() {
        return recurso_direc_recaudado;
    }

    /**
     * @param recurso_direc_recaudado the recurso_direc_recaudado to set
     */
    public void setRecurso_direc_recaudado(Double recurso_direc_recaudado) {
        this.recurso_direc_recaudado = recurso_direc_recaudado;
    }

    /**
     * @return the recurso_operacion
     */
    public Double getRecurso_operacion() {
        return recurso_operacion;
    }

    /**
     * @param recurso_operacion the recurso_operacion to set
     */
    public void setRecurso_operacion(Double recurso_operacion) {
        this.recurso_operacion = recurso_operacion;
    }

    /**
     * @return the donacion_transferencia
     */
    public Double getDonacion_transferencia() {
        return donacion_transferencia;
    }

    /**
     * @param donacion_transferencia the donacion_transferencia to set
     */
    public void setDonacion_transferencia(Double donacion_transferencia) {
        this.donacion_transferencia = donacion_transferencia;
    }

    /**
     * @return the recurso_determinado
     */
    public Double getRecurso_determinado() {
        return recurso_determinado;
    }

    /**
     * @param recurso_determinado the recurso_determinado to set
     */
    public void setRecurso_determinado(Double recurso_determinado) {
        this.recurso_determinado = recurso_determinado;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
