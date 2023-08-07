/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.ComiteTrabajo;
import mil.fap.models.helpers.Message;

/**
 *
 * @author mnieva
 */
public interface ComiteTrabajoService {

    public List<ComiteTrabajo> listPagination(ComiteTrabajo item);

    public Message register(ComiteTrabajo item);

    public Message update(ComiteTrabajo item);
    
    public ComiteTrabajo buscarPorId(Integer idintegrante);
    
    public String updateEstado(ComiteTrabajo item);

}
