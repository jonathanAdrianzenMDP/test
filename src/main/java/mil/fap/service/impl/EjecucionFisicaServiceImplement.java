/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import mil.fap.dao.EjecucionFisicaData;
import mil.fap.dao.ObservacionData;
import mil.fap.dao.SeguimientoProyData;
import mil.fap.helpers.Constantes;
import mil.fap.models.EjecucionFisica;
import mil.fap.models.Observacion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;
import mil.fap.service.EjecucionFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jmezas
 */
@Repository("ejecucionFisicaService")
public class EjecucionFisicaServiceImplement implements EjecucionFisicaService {

    @Autowired
    SeguimientoProyData _SeguimientoProyService;
    @Autowired
    ObservacionData _ObservacionData;
    @Autowired
    EjecucionFisicaData data;

    @Override
    public Message aprobar(SeguimientoProy item) {
        Message msj = new Message();
        try {
            item.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
            item.setCodproceso(Constantes.ProcesosPIP_IOARR.EjecucionFisicaFinanciera);

            if (!item.getIdproioarr().equals(0)) {
                _SeguimientoProyService.setIOARR(item);
            } else {
                _SeguimientoProyService.setPIP(item);
            }

            item.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
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
    public Message observar(Observacion item) {
        Message msj = new Message();
        try {
            _ObservacionData.insert(item);
            SeguimientoProy seguimientoProy = new SeguimientoProy();
            seguimientoProy.setIdproioarr(item.getIDPROIOARR());
            seguimientoProy.setIdproyepip(item.getIDPROYEPIP());
            seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
            seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.EjecucionFisicaFinanciera);
            if (!item.getIDPROIOARR().equals(0)) {
                _SeguimientoProyService.setIOARR(seguimientoProy);
            } else {
                _SeguimientoProyService.setPIP(seguimientoProy);
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
    public Message enviar(SeguimientoProy item) {
        Message msj = new Message();
        try {
            item.setEstadoproc(Constantes.EstadosPIP_IOARR.PendienteRevision);
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

    @Override
    public Message register(EjecucionFisica item) {
        Message msj = new Message();
        try {
            data.register(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public EjecucionFisica getPIP(EjecucionFisica item) {
        return data.get(item);

    }

//    @Override
//    public String updateEstado(EjecucionFisica item) {
//        try {
//            data.updateEstado(item);
//        } catch (Exception ex) {
//            return Constantes.Mensajes.MensajeErrorExcepcion;
//        }
//        return Constantes.Mensajes.MensajeCambiarEstado;
//    }
    
        @Override
    public Message update(EjecucionFisica item) {
        Message msj = new Message();
        try {
            data.update(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }


}
