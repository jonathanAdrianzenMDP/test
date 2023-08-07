/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;

/**
 *
 * @author mnieva
 */
public interface SeguimientoProyService {

    public Message setIOARR(SeguimientoProy item);
    public Message setPIP(SeguimientoProy item);
    public List<SeguimientoProy> getSeguimientoEstadosPIP_IOARR(Integer IDPROIOARR, Integer IDPROYEPIP);
    SeguimientoProy getUltimoEstadoPorProceso(SeguimientoProy item);
}
