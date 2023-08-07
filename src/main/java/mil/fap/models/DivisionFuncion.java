
package mil.fap.models;

import java.io.Serializable;

public class DivisionFuncion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;
    private Integer iddivfuncion;
    private Integer idfuncion;
    private String descdivfuncion;
    private boolean estado;

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIddivfuncion() {
        return iddivfuncion;
    }

    public void setIddivfuncion(Integer iddivfuncion) {
        this.iddivfuncion = iddivfuncion;
    }

    public Integer getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(Integer idfuncion) {
        this.idfuncion = idfuncion;
    }

    public String getDescdivfuncion() {
        return descdivfuncion;
    }

    public void setDescdivfuncion(String descdivfuncion) {
        this.descdivfuncion = descdivfuncion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
