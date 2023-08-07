/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

import java.util.List;

/**
 *
 * @author jmezas
 */
public class NuevoPIPRequest {

    private ProyectoPIP proyectoPIP;

    private List<TipoItem> listTipoItem;
    private List<Inversion> listInversion;
   

    
    
    public ProyectoPIP getProyectoPIP() {
        return proyectoPIP;
    }

    public void setProyectoPIP(ProyectoPIP proyectoPIP) {
        this.proyectoPIP = proyectoPIP;
    }

    public List<TipoItem> getListTipoItem() {
        return listTipoItem;
    }

    public void setListTipoItem(List<TipoItem> listTipoItem) {
        this.listTipoItem = listTipoItem;
    }

    public List<Inversion> getListInversion() {
        return listInversion;
    }

    public void setListInversion(List<Inversion> listInversion) {
        this.listInversion = listInversion;
    }



    

}
