/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.ParametroValor;
import mil.fap.models.helpers.Message;

/**
 *
 * @author jmezas
 */
public interface ParametroValorService {
    
    /**
     * Permite Agregar un nuevo Parametro Valor
     * @param item
     * @return
     */
    Message add(ParametroValor item);
    /**
     *Lista los parametros valores activos
     * @param idparametro
     * @return
     */
    List<ParametroValor> list(int idparametro);
    
    /**
     *Lista Todos los parametros valores incluso los inactivos.
     * @param idparametro
     * @return
     */
    List<ParametroValor> listAll(int idparametro);
    List<ParametroValor> listParametro();
     Message deleteParametro(ParametroValor item);
}
