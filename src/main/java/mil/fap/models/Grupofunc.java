package mil.fap.models;

import java.io.Serializable;

public class Grupofunc implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Pagination pageInfo;
    private Integer idgrupofun;
    private Integer iddivfuncion;   
    private String descgrupofunc;
    private boolean estado;

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getIdgrupofun() {
        return idgrupofun;
    }

    public void setIdgrupofun(Integer idgrupofun) {
        this.idgrupofun = idgrupofun;
    }

    public Integer getIddivfuncion() {
        return iddivfuncion;
    }

    public void setIddivfuncion(Integer iddivfuncion) {
        this.iddivfuncion = iddivfuncion;
    }

    public String getDescgrupofunc() {
        return descgrupofunc;
    }

    public void setDescgrupofunc(String descgrupofunc) {
        this.descgrupofunc = descgrupofunc;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
