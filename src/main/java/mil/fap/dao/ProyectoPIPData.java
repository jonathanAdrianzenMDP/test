/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.ProyectoPIP;

/**
 *
 * @author jmezas
 */
public interface ProyectoPIPData {

    public Integer set(ProyectoPIP item);
    public Integer update(ProyectoPIP item);
    public ProyectoPIP get(Integer id);
    public void updatePmiPIP(ProyectoPIP item);
    public String updateCierreInvPIP(ProyectoPIP item);
    public Integer updateFechaPlan(ProyectoPIP item);
    public Integer updateNombreCodigo(ProyectoPIP item);
}
