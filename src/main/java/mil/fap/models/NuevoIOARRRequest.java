/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.util.List;

public class NuevoIOARRRequest{
  
  private ProyectoIOARR proyectoIOARR;
  private List<ProyectoTipoIOARR> listProyectoTipoIOARR;

    /**
     * @return the proyectoIOARR
     */
    public ProyectoIOARR getProyectoIOARR() {
        return proyectoIOARR;
    }

    /**
     * @param proyectoIOARR the proyectoIOARR to set
     */
    public void setProyectoIOARR(ProyectoIOARR proyectoIOARR) {
        this.proyectoIOARR = proyectoIOARR;
    }

    /**
     * @return the listProyectoTipoIOARR
     */
    public List<ProyectoTipoIOARR> getListProyectoTipoIOARR() {
        return listProyectoTipoIOARR;
    }

    /**
     * @param listProyectoTipoIOARR the listProyectoTipoIOARR to set
     */
    public void setListProyectoTipoIOARR(List<ProyectoTipoIOARR> listProyectoTipoIOARR) {
        this.listProyectoTipoIOARR = listProyectoTipoIOARR;
    }


}
