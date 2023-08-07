/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;

/**
 *
 * @author jmezas
 */
public interface LiquidacionInversionService {
        
    public Message aprobar(SeguimientoProy item);
    
    public Message regresar(SeguimientoProy item);
  
}
