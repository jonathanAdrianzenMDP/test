/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import mil.fap.dao.ObservacionData;
import mil.fap.dao.SeguimientoProyData;
import mil.fap.helpers.Constantes;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;
import mil.fap.service.LiquidacionInversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("liquidacionInversionService")
public class LiquidacionInversionServiceImplement implements LiquidacionInversionService {

    @Autowired
    SeguimientoProyData _SeguimientoProyService;
    @Autowired
    ObservacionData _ObservacionData;

    @Override
    public Message aprobar(SeguimientoProy item) {
        Message msj = new Message();
        try {
            item.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
            item.setCodproceso(Constantes.ProcesosPIP_IOARR.LiquidacionInversion);

            if (!item.getIdproioarr().equals(0)) {
                _SeguimientoProyService.setIOARR(item);
            } else {
                _SeguimientoProyService.setPIP(item);
            }

            msj.setSuccess(true);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setSuccess(false);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public Message regresar(SeguimientoProy item) {
        Message msj = new Message();
        try {
            item.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
            item.setCodproceso(Constantes.ProcesosPIP_IOARR.EjecucionFisicaFinanciera);

            if (!item.getIdproioarr().equals(0)) {
                _SeguimientoProyService.setIOARR(item);
            } else {
                _SeguimientoProyService.setPIP(item);
            }

            msj.setSuccess(true);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setSuccess(false);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

}
