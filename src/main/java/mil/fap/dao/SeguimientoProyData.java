/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.SeguimientoProy;

/**
 *
 * @author jmezas
 */
public interface SeguimientoProyData {

    Integer setIOARR(SeguimientoProy item);
    Integer setPIP(SeguimientoProy item);
    List<SeguimientoProy> getSeguimientoEstadosPIP_IOARR(Integer IDPROIOARR, Integer IDPROYEPIP);
    SeguimientoProy getUltimoEstadoPorProceso(SeguimientoProy item);
}
