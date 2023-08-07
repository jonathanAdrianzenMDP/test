/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

/**
 *
 * @author mnieva
 */
public class SolEjecucion extends Base {

    private Integer IDSOLEJECUCION;
    private String URLDOC;
    private String NOMDOC;
    private Integer IDPROIOARR;
    private String UITMAYOR75;
    private String DESCDOC;

    public String getDESCDOC() {
        return DESCDOC;
    }

    public void setDESCDOC(String DESCDOC) {
        this.DESCDOC = DESCDOC;
    }  

    public Integer getIDSOLEJECUCION() {
        return IDSOLEJECUCION;
    }

    public void setIDSOLEJECUCION(Integer IDSOLEJECUCION) {
        this.IDSOLEJECUCION = IDSOLEJECUCION;
    }

    public Integer getIDPROIOARR() {
        return IDPROIOARR;
    }

    public void setIDPROIOARR(Integer IDPROIOARR) {
        this.IDPROIOARR = IDPROIOARR;
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

    public String getUITMAYOR75() {
        return UITMAYOR75;
    }

    public void setUITMAYOR75(String UITMAYOR75) {
        this.UITMAYOR75 = UITMAYOR75;
    }
    
    

}
