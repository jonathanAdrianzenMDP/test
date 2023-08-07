/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

public class DocumentoAdjunto extends Base {

    private Integer IDDOCUMENT;
    private String DESCDOC;
    private String URLDOC;
    private String NOMDOC;
    private Integer IDBRECINDI;
    private Integer IDPROIOARR;
    private Integer IDPROYEPIP;
    private Integer PROCACTUAL;
    private String  DESCPROCACTUAL;
    private byte[] byteDOC;

    /**
     * @return the IDDOCUMENT
     */
    public Integer getIDDOCUMENT() {
        return IDDOCUMENT;
    }

    /**
     * @param IDDOCUMENT the IDDOCUMENT to set
     */
    public void setIDDOCUMENT(Integer IDDOCUMENT) {
        this.IDDOCUMENT = IDDOCUMENT;
    }

    /**
     * @return the DESCDOC
     */
    public String getDESCDOC() {
        return DESCDOC;
    }

    /**
     * @param DESCDOC the DESCDOC to set
     */
    public void setDESCDOC(String DESCDOC) {
        this.DESCDOC = DESCDOC;
    }

    /**
     * @return the URLDOC
     */
    public String getURLDOC() {
        return URLDOC;
    }

    /**
     * @param URLDOC the URLDOC to set
     */
    public void setURLDOC(String URLDOC) {
        this.URLDOC = URLDOC;
    }

    /**
     * @return the NOMDOC
     */
    public String getNOMDOC() {
        return NOMDOC;
    }

    /**
     * @param NOMDOC the NOMDOC to set
     */
    public void setNOMDOC(String NOMDOC) {
        this.NOMDOC = NOMDOC;
    }

    /**
     * @return the IDBRECINDI
     */
    public Integer getIDBRECINDI() {
        return IDBRECINDI;
    }

    /**
     * @param IDBRECINDI the IDBRECINDI to set
     */
    public void setIDBRECINDI(Integer IDBRECINDI) {
        this.IDBRECINDI = IDBRECINDI;
    }

    /**
     * @return the IDPROIOARR
     */
    public Integer getIDPROIOARR() {
        return IDPROIOARR;
    }

    /**
     * @param IDPROIOARR the IDPROIOARR to set
     */
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

    /**
     * @return the byteDOC
     */
    public byte[] getByteDOC() {
        return byteDOC;
    }

    /**
     * @param byteDOC the byteDOC to set
     */
    public void setByteDOC(byte[] byteDOC) {
        this.byteDOC = byteDOC;
    }

}
