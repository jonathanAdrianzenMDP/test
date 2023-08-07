/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import mil.fap.models.ProyectoIOARR;

/**
 *
 * @author Jonathan
 */
public interface ProyectoIOARRData {
    public Integer set(ProyectoIOARR item);
    public ProyectoIOARR getById(Integer id);
    public Integer update(ProyectoIOARR item);
    public Integer updateUIT(ProyectoIOARR item);
    public String updateCierreInv(ProyectoIOARR item);
    public void updatePmi(ProyectoIOARR item);
    public Integer updateNombreCodigo(ProyectoIOARR item);
}
