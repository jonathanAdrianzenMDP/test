/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import mil.fap.models.EjecucionFisica;
import mil.fap.models.Observacion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;

/**
 *
 * @author jmezas
 */
public interface EjecucionFisicaService {

    public Message aprobar(SeguimientoProy item);

    public Message observar(Observacion item);

    public Message enviar(SeguimientoProy item);

    public Message register(EjecucionFisica item);

    EjecucionFisica getPIP(EjecucionFisica item);

//    public String updateEstado(EjecucionFisica item);
    
    public Message update(EjecucionFisica item);
}
