/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.ProyectoTipoIOARR;

/**
 *
 * @author Jonathan
 */
public interface ProyectoTipoIOARRData {
    public Integer set(ProyectoTipoIOARR item);
    public Integer update(ProyectoTipoIOARR item);
    public List<ProyectoTipoIOARR> list(Integer idProyIOARR);
}
