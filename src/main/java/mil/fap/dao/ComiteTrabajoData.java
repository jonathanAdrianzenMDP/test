/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.ComiteTrabajo;

/**
 *
 * @author mnieva
 */
public interface ComiteTrabajoData {
    
        public List<ComiteTrabajo> listPagination(ComiteTrabajo item);
        
        public String register(ComiteTrabajo item);
        
        public String update(ComiteTrabajo item);
        
        public ComiteTrabajo buscarPorId(Integer idintegrante);
        
        public String updateEstado(ComiteTrabajo item);
}
