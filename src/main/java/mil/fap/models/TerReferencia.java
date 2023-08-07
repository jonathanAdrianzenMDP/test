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
public class TerReferencia extends  Base{
    private Integer IDREFERENCIA;
    private String URLDOC;
    private String DESCDOC;
    private String NOMDOC;
    private Integer IDPROYEPIP;
    public Integer getIDREFERENCIA() {
        return IDREFERENCIA;
    }

    public void setIDREFERENCIA(Integer IDREFERENCIA) {
        this.IDREFERENCIA = IDREFERENCIA;
    }

    public String getURLDOC() {
        return URLDOC;
    }

    public void setURLDOC(String URLDOC) {
        this.URLDOC = URLDOC;
    }

    public String getNOMDOC() {
        return NOMDOC;
    }

    public void setNOMDOC(String NOMDOC) {
        this.NOMDOC = NOMDOC;
    }

    public Integer getIDPROYEPIP() {
        return IDPROYEPIP;
    }

    public void setIDPROYEPIP(Integer IDPROYEPIP) {
        this.IDPROYEPIP = IDPROYEPIP;
    }

    public String getDESCDOC() {
        return DESCDOC;
    }

    public void setDESCDOC(String DESCDOC) {
        this.DESCDOC = DESCDOC;
    }


    
}
