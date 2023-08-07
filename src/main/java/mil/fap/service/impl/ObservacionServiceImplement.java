/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import mil.fap.dao.ObservacionData;
import mil.fap.dao.SeguimientoProyData;
import mil.fap.helpers.Constantes;
import mil.fap.models.Observacion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.helpers.Message;
import mil.fap.service.ObservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristina
 */
@Service("observacionService")
public class ObservacionServiceImplement implements ObservacionService {

    @Autowired
    ObservacionData _ObservacionData;
    
    @Autowired
    SeguimientoProyData _SeguimientoProyData;
    
    @Override
    public Message insertObservacionIOARR(Observacion item, SeguimientoProy seguimientoProy) {
        Message msj = new Message();
        try{
            _ObservacionData.insert(item);
            msj.setData(item);
            _SeguimientoProyData.setIOARR(seguimientoProy);
            msj.setSuccess(true);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
            
        }catch(Exception ex){
            msj.setSuccess(false);
            msj.setException(ex.getMessage());
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
        
    }
    @Override
    public Message insertObservacionPIP(Observacion item, SeguimientoProy seguimientoProy) {
        Message msj = new Message();
        try{
            _ObservacionData.insert(item);
            msj.setData(item);
            _SeguimientoProyData.setPIP(seguimientoProy);
            msj.setSuccess(true);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
            
        }catch(Exception ex){
            msj.setSuccess(false);
            msj.setException(ex.getMessage());
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
        
    }

    @Override
    public Message getAllObservacion(Observacion item) {

        Message msj = new Message();
        try{
            msj.setData(_ObservacionData.getAll(item));
            msj.setSuccess(true);
            msj.setType(Constantes.Mensajes.typeSuccess);
            
        }catch(Exception ex){
            msj.setSuccess(false);
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

}
