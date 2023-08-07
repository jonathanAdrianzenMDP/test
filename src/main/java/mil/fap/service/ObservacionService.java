/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.Observacion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;

/**
 *
 * @author cristina
 */
public interface ObservacionService {
    Message insertObservacionIOARR(Observacion item, SeguimientoProy seguimientoProy);
    Message insertObservacionPIP(Observacion item, SeguimientoProy seguimientoProy);
    Message getAllObservacion(Observacion item);
}
