/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

public class Observacion extends Base {

    private Integer IDOBSERVAC;
    private String DESCOBSERV;
    private Integer IDPROIOARR;
    private Integer IDPROYEPIP;
    private Integer PROCACTUAL;
    private String  DESCPROCACTUAL;

    public Integer getIDOBSERVAC() {
        return IDOBSERVAC;
    }

    public void setIDOBSERVAC(Integer IDOBSERVAC) {
        this.IDOBSERVAC = IDOBSERVAC;
    }

    public String getDESCOBSERV() {
        return DESCOBSERV;
    }

    public void setDESCOBSERV(String DESCOBSERV) {
        this.DESCOBSERV = DESCOBSERV;
    }

    public Integer getIDPROIOARR() {
        return IDPROIOARR;
    }

    public void setIDPROIOARR(Integer IDPROIOARR) {
        this.IDPROIOARR = IDPROIOARR;
    }

    /**
     * @return the IDPROYEPIP
     */
    public Integer getIDPROYEPIP() {
        return IDPROYEPIP;
    }

    /**
     * @param IDPROYEPIP the IDPROYEPIP to set
     */
    public void setIDPROYEPIP(Integer IDPROYEPIP) {
        this.IDPROYEPIP = IDPROYEPIP;
    }

    /**
     * @return the PROCACTUAL
     */
    public Integer getPROCACTUAL() {
        return PROCACTUAL;
    }

    /**
     * @param PROCACTUAL the PROCACTUAL to set
     */
    public void setPROCACTUAL(Integer PROCACTUAL) {
        this.PROCACTUAL = PROCACTUAL;
    }

    /**
     * @return the DESCPROCACTUAL
     */
    public String getDESCPROCACTUAL() {
        return DESCPROCACTUAL;
    }

    /**
     * @param DESCPROCACTUAL the DESCPROCACTUAL to set
     */
    public void setDESCPROCACTUAL(String DESCPROCACTUAL) {
        this.DESCPROCACTUAL = DESCPROCACTUAL;
    }
    
}
