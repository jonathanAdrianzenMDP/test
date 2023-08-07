/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.UnidadEjecutoraInver;

/**
 *
 * @author jadrianzen
 */
public interface UnidadEjecutoraInverData {
    List<UnidadEjecutoraInver> getAll(int id);
    
    public List<UnidadEjecutoraInver> listPagination(UnidadEjecutoraInver item);
        
    public String register(UnidadEjecutoraInver item);
          
    public String updateEstado(UnidadEjecutoraInver item);
}
