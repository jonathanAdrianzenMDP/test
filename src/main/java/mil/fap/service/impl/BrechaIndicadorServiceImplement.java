/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.BrechaIndicadorData;
import mil.fap.helpers.Constantes;
import mil.fap.models.BrechaIndicador;
import mil.fap.models.BrechaIndicadorRequest;
import mil.fap.models.helpers.Message;
import mil.fap.service.BrechaIndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmezas
 */
@Service("brechaIndicadorService")
public class BrechaIndicadorServiceImplement implements BrechaIndicadorService {
    
    @Autowired
    BrechaIndicadorData data;
    
    @Override
    public List<BrechaIndicador> listPagination(BrechaIndicador item) {
        return data.listPagination(item);
    }

    @Override
    public String register(BrechaIndicadorRequest item) {
        try{
                        data.register(item.getBrechaIndicador());

        }catch(Exception ex){
            return Constantes.Mensajes.MensajeErrorExcepcion;
        }
        return Constantes.Mensajes.MensajeGuardarExito;
    }

    @Override
    public Message update(BrechaIndicador item) {
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

    @Override
    public String updateEstado(BrechaIndicador item) {
        try{
            data.updateEstado(item);
        }catch(Exception ex){
            return Constantes.Mensajes.MensajeErrorExcepcion;
        }
        return Constantes.Mensajes.MensajeCambiarEstado;
    }

    @Override
    public BrechaIndicador buscarPorId(Integer idbrecindi) {
        return data.buscarPorId(idbrecindi);
    }

    @Override
    public List<BrechaIndicador> list() {
        return data.list();
    }
    
    

}
