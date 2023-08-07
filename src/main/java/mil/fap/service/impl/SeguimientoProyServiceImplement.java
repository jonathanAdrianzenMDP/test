/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.SeguimientoProyData;
import mil.fap.helpers.Constantes;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;
import mil.fap.service.SeguimientoProyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mnieva
 */
@Service("seguimientoProyService")
public class SeguimientoProyServiceImplement implements SeguimientoProyService {

    @Autowired
    SeguimientoProyData data;

    @Override
    public Message setIOARR(SeguimientoProy item) {
        Message msj = new Message();
        try {
            data.setIOARR(item);
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
    public Message setPIP(SeguimientoProy item) {
        Message msj = new Message();
        try {
            data.setPIP(item);
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
    public List<SeguimientoProy> getSeguimientoEstadosPIP_IOARR(Integer IDPROIOARR, Integer IDPROYEPIP){
        return data.getSeguimientoEstadosPIP_IOARR(IDPROIOARR, IDPROYEPIP);
    }
    
    @Override
    public SeguimientoProy getUltimoEstadoPorProceso(SeguimientoProy item){
        return data.getUltimoEstadoPorProceso(item);
    }
}
