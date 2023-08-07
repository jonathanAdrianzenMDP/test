/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.helpers.Message;

/**
 *
 * @author jmezas
 */
public interface UnidadEjecutoraInverService {
    
    public List<UnidadEjecutoraInver> listPagination(UnidadEjecutoraInver item);
        
    public String register(UnidadEjecutoraInver item);
    
//    public UnidadEjecutoraInver buscarPorId(Integer idintegrante);
        
    public String updateEstado(UnidadEjecutoraInver item);
    
}
